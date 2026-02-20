package com.back.coup.domain.models.redis;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

import com.back.coup.enumerate.cards.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cards implements Serializable{

    private int id;

    private CardTypeEnum type;

    // Ações que essa carta pode executar
    @Builder.Default
    private Set<CardActionEnum> actions = new HashSet<>();

    // Ações que essa carta pode bloquear
    @Builder.Default
    private Set<CardActionEnum> blocks = new HashSet<>();

    // Quais cartas podem bloquear essa carta
    @Builder.Default
    private Set<CardTypeEnum> blockedBy = new HashSet<>();
}
