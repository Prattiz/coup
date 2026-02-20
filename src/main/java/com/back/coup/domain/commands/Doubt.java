package com.back.coup.domain.commands;

import org.springframework.stereotype.Component;

import com.back.coup.domain.dtos.WebsocketMessageDto;


@Component
public class Doubt {

    public String execute(WebsocketMessageDto message) {
        return "ON_DOUBT" + message.payload;
    }
}
