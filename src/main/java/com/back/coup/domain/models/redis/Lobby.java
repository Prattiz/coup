package com.back.coup.domain.models.redis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lobby implements Serializable{

    private String roomId;

    @Builder.Default
    private Set<PlayerSession> players = new HashSet<>();

    @Builder.Default
    private int status = 0; // 0 = WAITING | 1 = IN GAME
    
    @Builder.Default
    private int currentPlayerTurn = 1;

    private long createdAt;
}
