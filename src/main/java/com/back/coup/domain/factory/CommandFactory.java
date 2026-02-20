package com.back.coup.domain.factory;

import org.springframework.stereotype.Component;

import com.back.coup.domain.commands.*;
import com.back.coup.domain.dtos.EventResponse;
import com.back.coup.domain.dtos.WebsocketMessageDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommandFactory {

    // COMMANDS
    // private final Action action;
    // private final LeaveRoom leaveRoom;
    private final JoinRoom joinRoom;
    // private final GameStart gameStart;
    // private final Doubt doubt;

    public EventResponse execute(WebsocketMessageDto message) {

        switch (message.command) {

            // case "ACTION":
            //     return action.execute(message);

            // case "DOUBT":
            //     return doubt.execute(message);

            // case "LEAVE_ROOM":
            //     return leaveRoom.execute(message);

            case "JOIN_ROOM": 
                return joinRoom.execute(message);

            // case "GAME_START":
            //     return gameStart.execute(message);

            default:
                throw new RuntimeException(
                    "Command not found: " + message.command
                );
        }
    }
}
