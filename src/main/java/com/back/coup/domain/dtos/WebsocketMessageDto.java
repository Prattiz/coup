package com.back.coup.domain.dtos;

import com.fasterxml.jackson.databind.JsonNode;

public class WebsocketMessageDto {

    private String command;
    private JsonNode payload;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public JsonNode getPayload() {
        return payload;
    }

    public void setPayload(JsonNode payload) {
        this.payload = payload;
    }
}
