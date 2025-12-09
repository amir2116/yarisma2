package com.example.yarisma.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer , WebSocketMessageBrokerConfigurer {

    @Autowired
    private BuzzerHandler buzzerHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(buzzerHandler, "/buzzer").setAllowedOrigins("*").withSockJS();
    }
}
