package com.back.coup.services;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.back.coup.domain.models.redis.Lobby;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StartRoomService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void execute(String roomId) {
        try {
            String roomKey = "room:" + roomId;

            Lobby room = (Lobby) redisTemplate.opsForValue().get(roomKey);

            if (room == null) {
                throw new RuntimeException("Room does not exist");
            }

            if (room.getPlayers().size() < 2) {
                throw new RuntimeException("Not enough players to start the game");
            }

            if (room.getStatus() != 0) {
                throw new RuntimeException("Room already in game");
            }

            // Atualiza o player session de todos os jogadores na sala 
            // todo: Cria baralho do Coup

            
            // todo: Distribuir cartas do baralho e inicializar jogadores
            
            
            // Atualiza status do Lobby
            room.setStatus(1);
            room.setCurrentPlayerTurn(1);
            // Atualiza Lobby no Redis
            redisTemplate.opsForValue().set(roomKey, room);

        } catch (Exception e) {
            System.out.println("ERRO StartRoomService: " + e);
        }
    }
}
