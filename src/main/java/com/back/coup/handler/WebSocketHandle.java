package com.back.coup.handler;

import com.back.coup.domain.dtos.EventResponse;
import com.back.coup.domain.dtos.WebsocketMessageDto;
import com.back.coup.repository.WebsocketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandle extends TextWebSocketHandler {

    private final WebsocketRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public WebSocketHandle(WebsocketRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void handleTextMessage(
        WebSocketSession session,
        TextMessage message
    ) throws Exception {

        WebsocketMessageDto messageDto =
            mapper.readValue(message.getPayload(), WebsocketMessageDto.class);

        EventResponse response = repository.waitingCommand(messageDto);
        String jsonResponse = mapper.writeValueAsString(response);

        session.sendMessage(new TextMessage(jsonResponse));
    }

}
