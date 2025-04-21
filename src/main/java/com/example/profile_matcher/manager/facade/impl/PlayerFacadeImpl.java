package com.example.profile_matcher.manager.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.profile_matcher.manager.facade.PlayerFacade;
import com.example.profile_matcher.manager.service.ExternalService;
import com.example.profile_matcher.manager.service.PlayerService;
import com.example.profile_matcher.model.dto.CampaignDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

@Component
public class PlayerFacadeImpl implements PlayerFacade {

    @Autowired
    private final PlayerService playerService;
    @Autowired
    private final ExternalService externalService;

    public PlayerFacadeImpl(PlayerService playerService, ExternalService externalService) {
        this.playerService = playerService;
        this.externalService = externalService;
    }

    @Override
    public PlayerProfileDTO getClientConfig(String playerId) {        
        PlayerProfileDTO player = playerService.getPlayer(playerId);
        if (player == null) {
            return null;
        }
        
        List<CampaignDTO> newCampaigns = externalService.getCampaignMatches(player);

        if (newCampaigns != null && !newCampaigns.isEmpty()) {
            List<String> activeCampaigns = newCampaigns.stream()
                    .map(CampaignDTO::getName)
                    .collect(Collectors.toList());

            player.setActiveCampaigns(activeCampaigns);
            
            playerService.savePlayerCampaign(player);
        }

        // Map the updated player entity to the DTO and return it
        return player;
    }
}
