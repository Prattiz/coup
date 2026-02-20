package com.back.coup.domain.dtos;

import com.fasterxml.jackson.databind.JsonNode;

public class EventResponse {
    private String event; 
    private JsonNode payload; 

    public EventResponse(String event, JsonNode payload) { 
        this.event = event; 
        this.payload = payload; 
    }

    public String getEvent() { return event; } 
    public JsonNode getPayload() { return payload; }
}
