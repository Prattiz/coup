package com.back.coup.services;


import java.util.HashSet;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.back.coup.domain.dtos.JoinRoomDTO;
import com.back.coup.domain.models.redis.Lobby;
import com.back.coup.domain.models.redis.PlayerSession;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JoinRoomService {
    
    private final RedisTemplate<String, Object> redisTemplate;


    private void addPlayerSessionIntoRoom(Lobby room, JoinRoomDTO player){

        int nextTurnPosition = room.getPlayers().size() + 1;
        
        if (nextTurnPosition >= 10){
            throw new RuntimeException("the room is full");
        }

        PlayerSession newSession = PlayerSession.builder()
            .playerId(player.playerId)
            .playerName(player.playerName)
            .roomId(room.getRoomId())
            .numTurnPlayer(nextTurnPosition)
            .coins(2) 
            .itsTurn(nextTurnPosition == 1)
            .liedLastRound(false)
            .playedLastRound(false)
            .build();
        
        if (room.getPlayers().contains(newSession)){ 
            throw new RuntimeException("Player already in room!");
        }

        room.getPlayers().add(newSession);

        redisTemplate.opsForValue()
            .set("player:" + newSession.getPlayerId(), newSession);
    }


    public void execute(String roomId, JoinRoomDTO player) {

        try {
            String key = "room:" + roomId;

            Lobby room = (Lobby) redisTemplate.opsForValue().get(key);

            // Sala não existe -> cria (tirar isso depois e colocar numa rota post)
            if (room == null) {

                room = Lobby.builder()
                    .roomId(roomId)
                    .players(new HashSet<>())
                    .status(0)
                    .createdAt(System.currentTimeMillis())
                    .build();

                // throw new RuntimeException("room does not exist");
            }

            if (room.getStatus() != 0) {
                throw new RuntimeException("Room already in game");
            }

            if (room.getPlayers().size() >= 10) {
                throw new RuntimeException("the room is full");
            }

            addPlayerSessionIntoRoom(room, player);
            redisTemplate.opsForValue().set(key, room);
            
            
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
    }
}
