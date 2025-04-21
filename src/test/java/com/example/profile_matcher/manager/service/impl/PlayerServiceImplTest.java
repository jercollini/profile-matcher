package com.example.profile_matcher.manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.profile_matcher.model.dto.PlayerProfileDTO;
import com.example.profile_matcher.model.entity.Player;
import com.example.profile_matcher.model.mapper.PlayerMapper;
import com.example.profile_matcher.repositories.PlayerRepository;


class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerMapper playerMapper;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getPlayer_PlayerExists_ReturnsPlayerProfileDTO() {
        String playerId = "97983be2-98b7-11e7-90cf-082e5f28d836";
        Player mockPlayer = new Player();
        mockPlayer.setPlayerId(playerId);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(mockPlayer));
        when(playerMapper.playerToPlayerProfileDTO(mockPlayer)).thenReturn(new PlayerProfileDTO());

        PlayerProfileDTO result = playerService.getPlayer(playerId);

        assertNotNull(result);
        verify(playerRepository, times(1)).findById(playerId);
        verify(playerMapper, times(1)).playerToPlayerProfileDTO(mockPlayer);
    }

    @Test
    void getPlayer_PlayerDoesNotExist_ReturnsNull() {
        String playerId = "nonexistent-id";

        when(playerRepository.findById(playerId)).thenReturn(Optional.empty());

        PlayerProfileDTO result = playerService.getPlayer(playerId);

        assertNull(result);
        verify(playerRepository, times(1)).findById(playerId);
        verifyNoInteractions(playerMapper);
    }
}
