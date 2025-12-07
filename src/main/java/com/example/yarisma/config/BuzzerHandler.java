package com.example.yarisma.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
@Slf4j
@Component
public class BuzzerHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private final AtomicBoolean winnerChosen = new AtomicBoolean(false);

    private volatile String winnerSessionId = null;
    private volatile String winnerName=null;
    private volatile Instant winnerTimestamp = null;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info("Connected to web socket at {}", session.getUri());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        log.info("Disconnected from web socket at {}", session.getUri());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload().trim().toUpperCase();
        if(payload.equals("BUZZ")) {
            handleBuzzer(session);
        }
        else if(payload.equals("RESET")){
            resetRound();
        }
        else {
            log.info("Invalid payload received from web socket at {}", session.getUri());
        }

    }


    private void handleBuzzer(WebSocketSession session) {
        if(winnerChosen.compareAndSet(false,true)){
            winnerSessionId=session.getId();
            winnerName=session.getPrincipal().getName();
            winnerTimestamp=Instant.now();
            log.info("New buzzer session at {}", session.getUri());
        }
        else {
            log.info("Already buzzer session at {}", session.getUri());
        }
    }


    public void resetRound()throws IOException {
        winnerChosen.set(false);
        winnerSessionId = null;
        winnerName = null;
        winnerTimestamp = null;
        log.info("Reset round");
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("WebSocket error for session {}: {}", session.getId(), exception.getMessage());
        session.close(CloseStatus.SERVER_ERROR);
    }

}
