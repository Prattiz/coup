package com.back.coup.services;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Collections;

import com.back.coup.domain.models.redis.Lobby;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveRoomService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void execute(String roomId, int playerId) {
        try {
            String roomKey = "room:" + roomId;
            String playerKey = "player:" + playerId;

            // Recupera o lobby
            Lobby room = (Lobby) redisTemplate.opsForValue().get(roomKey);

            if (room == null) {
                throw new RuntimeException("Room does not exist");
            } 
            if (redisTemplate.opsForValue().get(playerKey) == null){
                throw new RuntimeException("Player does not exist");
            }

            // Atualiza o lobby dando lose ao jogador
            room.getPlayers().removeIf(playerInRoom -> {
                if (playerInRoom.getPlayerId() == playerId) {
                    // Atualiza os cards do jogador para 0 antes de remover
                    playerInRoom.setCards(Collections.emptySet()); // lista vazia, perdeu o jogo
                    playerInRoom.setCoins(0);
                    return true; // remove da lista
                }
                return false;
            });

            // Atualiza o lobby
            redisTemplate.opsForValue().set(roomKey, room);

            // Remove o jogador no redis
            redisTemplate.delete(playerKey);

        } catch (Exception e) {
            System.out.println("ERRO LeaveRoomService: " + e);
        }
    }
}
