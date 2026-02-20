package com.back.coup.domain.dtos;

import com.fasterxml.jackson.databind.JsonNode;

public class EventResponse {
    public String event; 
    public JsonNode payload; 

    public EventResponse(String event, JsonNode payload) { 
        this.event = event; 
        this.payload = payload; 
    }
}
