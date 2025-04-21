package com.example.profile_matcher.manager.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.profile_matcher.model.dto.CampaignDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

class ExternalServiceImplTest {

    private ExternalServiceImpl externalService;

    @BeforeEach
    void setUp() {
        externalService = new ExternalServiceImpl();
    }

    @Test
    void getCampaignMatches_PlayerMatchesCampaign_ReturnsCampaignList() {
        PlayerProfileDTO mockPlayer = new PlayerProfileDTO();
        mockPlayer.setLevel(3);
        mockPlayer.setCountry("CA");

        List<CampaignDTO> campaigns = externalService.getCampaignMatches(mockPlayer);

        assertNotNull(campaigns);
        assertFalse(campaigns.isEmpty());
        assertEquals("mycampaign", campaigns.get(0).getName());
    }
}
