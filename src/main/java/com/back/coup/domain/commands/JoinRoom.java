package com.back.coup.domain.commands;

import org.springframework.stereotype.Component;

import com.back.coup.domain.dtos.EventResponse;
import com.back.coup.domain.dtos.JoinRoomDTO;
import com.back.coup.domain.dtos.WebsocketMessageDto;
import com.back.coup.services.JoinRoomService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JoinRoom {

    private final ObjectMapper mapper = new ObjectMapper();
    private final JoinRoomService joinRoomService;

    public EventResponse execute(WebsocketMessageDto message) {
        JsonNode payload = message.payload;

        JoinRoomDTO payloadPlayer = mapper.convertValue(
                payload.get("player"),
                JoinRoomDTO.class);

        try {

            joinRoomService.execute(
                payload.get("roomId").asText(),
                payloadPlayer
            );

            return new EventResponse("ON_JOIN_ROOM", payload);
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            return new EventResponse("Error", null);
        }
    }
}
