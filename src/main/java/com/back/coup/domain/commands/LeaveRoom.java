package com.back.coup.domain.commands;

import org.springframework.stereotype.Component;

import com.back.coup.domain.dtos.WebsocketMessageDto;


@Component
public class LeaveRoom{

    public String execute(WebsocketMessageDto message) {
        return "ON_LEAVE_ROOM" + message.getPayload();
    }
}
