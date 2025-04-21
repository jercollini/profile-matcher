package com.example.profile_matcher.manager.service;

import java.util.List;

import com.example.profile_matcher.model.dto.CampaignDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

public interface ExternalService {
    List<CampaignDTO> getCampaignMatches(PlayerProfileDTO playerProfileDTO);
}
