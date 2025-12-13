package com.example.yarisma.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
@Slf4j
@Component
public class BuzzerHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private final AtomicBoolean winnerChosen = new AtomicBoolean(false);
    private final AtomicBoolean buzzerEnabled = new AtomicBoolean(true);

    private volatile String winnerSessionId = null;
    private volatile String winnerName=null;
    private volatile Instant winnerTimestamp = null;
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        session.getAttributes().put("teamLabel", deriveTeamLabel(session));
        log.info("Connected to web socket at {}", session.getUri());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        log.info("Disconnected from web socket at {}", session.getUri());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload() == null ? "" : message.getPayload().trim();
        String upper = payload.toUpperCase();

        if(!buzzerEnabled.get()){
            log.info("Buzz attempt while disabled from {}", session.getUri());
            try { session.sendMessage(new TextMessage("DISABLED")); } catch (IOException ignored) {}
            return;
        }

        // Accept plain "BUZZ", "RESET", and ignore/ack other payloads (e.g., JOIN).
        if(upper.equals("BUZZ")) {
            handleBuzzer(session);
        }
        else if(upper.equals("RESET")){
            resetRound();
        }
        else {
            log.info("Ignoring non-buzz payload '{}' from {}", payload, session.getUri());
        }

    }


    private void handleBuzzer(WebSocketSession session) {
        if(winnerChosen.compareAndSet(false,true)){
            winnerSessionId=session.getId();
            winnerName=(String) session.getAttributes().getOrDefault("teamLabel","UNKNOWN");
            winnerTimestamp=Instant.now();
            log.info("New buzzer session at {} winner {}", session.getUri(), winnerName);
            broadcastResults(session, true);
            messagingTemplate.convertAndSend("/topic/feedback","WINNER:"+winnerName);
        }
        else {
            log.info("Already buzzer session at {}", session.getUri());
            broadcastResults(session, false);
        }
    }


    public void resetRound()throws IOException {
        winnerChosen.set(false);
        winnerSessionId = null;
        winnerName = null;
        winnerTimestamp = null;
        log.info("Reset round");
        broadcastMessage("RESET");
        messagingTemplate.convertAndSend("/topic/feedback","RESET");
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("WebSocket error for session {}: {}", session.getId(), exception.getMessage());
        session.close(CloseStatus.SERVER_ERROR);
    }

    private String deriveTeamLabel(WebSocketSession session){
        URI uri = session.getUri();
        if(uri==null) return "UNKNOWN";
        String path = uri.getPath(); // e.g., /buzzer1
        if(path==null || path.isBlank()) return "UNKNOWN";
        String last = path.substring(path.lastIndexOf('/')+1).toUpperCase(); // BUZZER1
        if(last.startsWith("BUZZER")) {
            String suffix = last.replace("BUZZER","");
            if(!suffix.isBlank()) {
                return "TEAM" + suffix;
            }
        }
        return last;
    }

    private void broadcastResults(WebSocketSession winnerSession, boolean isWinnerAttempt) {
        String winnerLabel = isWinnerAttempt ? (String) winnerSession.getAttributes().getOrDefault("teamLabel","UNKNOWN") : winnerName;
        for (WebSocketSession ws : sessions) {
            if (ws.isOpen()) {
                try {
                    if (ws.getId().equals(winnerSession.getId()) && isWinnerAttempt && winnerChosen.get()) {
                        ws.sendMessage(new TextMessage("WINNER:" + winnerLabel));
                    } else if (winnerChosen.get()) {
                        ws.sendMessage(new TextMessage("LOSE"));
                    }
                } catch (IOException e) {
                    log.error("Failed to send result to {}", ws.getId(), e);
                }
            }
        }
    }

    private void broadcastMessage(String text) throws IOException {
        for (WebSocketSession ws : sessions) {
            if (ws.isOpen()) {
                ws.sendMessage(new TextMessage(text));
            }
        }
    }

    public void enableBuzzers(){
        buzzerEnabled.set(true);
        winnerChosen.set(false);
        winnerSessionId = null;
        winnerName = null;
        winnerTimestamp = null;
        log.info("Buzzers ENABLED");
        try {
            broadcastMessage("RESET");
            broadcastMessage("ENABLED");
        } catch (IOException ignored) {}
        messagingTemplate.convertAndSend("/topic/feedback","RESET");
        messagingTemplate.convertAndSend("/topic/feedback","ENABLED");
    }

    public void disableBuzzers() throws IOException {
        buzzerEnabled.set(false);
        winnerChosen.set(false);
        winnerSessionId = null;
        winnerName = null;
        winnerTimestamp = null;
        log.info("Buzzers DISABLED");
        broadcastMessage("DISABLED");
        messagingTemplate.convertAndSend("/topic/feedback","DISABLED");
    }
}
