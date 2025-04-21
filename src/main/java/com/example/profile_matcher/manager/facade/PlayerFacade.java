package com.example.profile_matcher.manager.facade;

import com.example.profile_matcher.model.dto.PlayerProfileDTO;

public interface PlayerFacade {
    PlayerProfileDTO getClientConfig(String playerId);
}
