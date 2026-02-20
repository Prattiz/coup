package com.back.coup.domain.commands;

import org.springframework.stereotype.Component;

import com.back.coup.domain.dtos.WebsocketMessageDto;


@Component
public class GameStart {

    public String execute(WebsocketMessageDto message) {
        return "ON_GAME_START" + message.payload;
    }
}
