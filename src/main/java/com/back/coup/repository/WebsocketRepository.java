package com.back.coup.repository;

import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.back.coup.domain.dtos.EventResponse;
import com.back.coup.domain.dtos.WebsocketMessageDto;
import com.back.coup.domain.factory.CommandFactory;


@Repository
public class WebsocketRepository {

    private WebSocketSession session;
    private final CommandFactory factory;

    public WebsocketRepository(CommandFactory factory) {
        this.factory = factory;
    }

    public EventResponse waitingCommand(WebsocketMessageDto message) {
        return factory.execute(message);
    }
    
    public void send(String command) {
        try {
            session.sendMessage(new TextMessage(command));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao enviar comando no websocket", e);
        }
    }
}
