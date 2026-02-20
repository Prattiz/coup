package com.back.coup.endpoints;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.back.coup.handler.WebSocketHandle;

@Configuration
@EnableWebSocket
public class WebSocketEndpoint implements WebSocketConfigurer {

    private final WebSocketHandle webSocketHandler;

    public WebSocketEndpoint(WebSocketHandle webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
            .addHandler(webSocketHandler, "/ws")
            .setAllowedOrigins("*");
    }
}
