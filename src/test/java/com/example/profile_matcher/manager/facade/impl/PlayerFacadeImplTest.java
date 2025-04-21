package com.example.profile_matcher.manager.facade.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.profile_matcher.manager.service.ExternalService;
import com.example.profile_matcher.manager.service.PlayerService;
import com.example.profile_matcher.model.dto.CampaignDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

class PlayerFacadeImplTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private ExternalService externalService;

    @InjectMocks
    private PlayerFacadeImpl playerFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getClientConfig_PlayerExistsAndMatchesCampaign_ReturnsUpdatedPlayerProfile() {
        String playerId = "97983be2-98b7-11e7-90cf-082e5f28d836";
        PlayerProfileDTO mockPlayer = new PlayerProfileDTO();
        mockPlayer.setPlayerId(playerId);

        CampaignDTO mockCampaign = new CampaignDTO();
        mockCampaign.setName("mycampaign");

        when(playerService.getPlayer(playerId)).thenReturn(mockPlayer);
        when(externalService.getCampaignMatches(mockPlayer)).thenReturn(List.of(mockCampaign));

        PlayerProfileDTO result = playerFacade.getClientConfig(playerId);

        assertNotNull(result);
        assertEquals(1, result.getActiveCampaigns().size());
        assertEquals("mycampaign", result.getActiveCampaigns().get(0));

        verify(playerService, times(1)).getPlayer(playerId);
        verify(externalService, times(1)).getCampaignMatches(mockPlayer);
        verify(playerService, times(1)).savePlayerCampaign(mockPlayer);
    }

    @Test
    void getClientConfig_PlayerDoesNotExist_ReturnsNull() {
        String playerId = "nonexistent-id";

        when(playerService.getPlayer(playerId)).thenReturn(null);

        PlayerProfileDTO result = playerFacade.getClientConfig(playerId);

        assertNull(result);
        verify(playerService, times(1)).getPlayer(playerId);
        verifyNoInteractions(externalService);
    }
}
