package com.back.coup.domain.interfaces;

import com.back.coup.domain.dtos.WebsocketMessageDto;

public interface Command {
    String execute(WebsocketMessageDto message);
}
