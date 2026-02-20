package com.back.coup.domain.models.redis;


import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSession implements Serializable{

    private int playerId;
    private String roomId;
    private int numTurnPlayer;
    private String playerName;
    
    @Builder.Default
    private boolean isPlayerAdmin = false;

    @Builder.Default
    private Set<Cards> cards = null;
  
    private int coins;

    @Builder.Default
    private boolean itsTurn = false;

    @Builder.Default
    private boolean playedLastRound = false;

    @Builder.Default
    private boolean liedLastRound = false;
}
