package com.example.profile_matcher.manager.service;

import com.example.profile_matcher.model.dto.PlayerProfileDTO;

public interface PlayerService {
    PlayerProfileDTO getPlayer(String playerId);

    void savePlayerCampaign(PlayerProfileDTO playerProfileDTO);
}
