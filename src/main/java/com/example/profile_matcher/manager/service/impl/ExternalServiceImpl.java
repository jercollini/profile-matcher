package com.example.profile_matcher.manager.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.profile_matcher.manager.service.ExternalService;
import com.example.profile_matcher.model.dto.CampaignDTO;
import com.example.profile_matcher.model.dto.CampaignMatchersDTO;
import com.example.profile_matcher.model.dto.LevelDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ExternalServiceImpl implements ExternalService {
    private static final Logger log = LogManager.getLogger(ExternalServiceImpl.class);    

    @Override
    public List<CampaignDTO> getCampaignMatches(PlayerProfileDTO player) {
        // Mocked logic of performing call to external service get all campaigns and match them
        if (player != null /* TODO: Add exhaustive required data to perform matching*/) {
            log.info("MATCHING CAMPAIGNS FOR PLAYER: {}", player.getPlayerId());
        }
        return getMockedCampaigns();
    }

    private List<CampaignDTO> getMockedCampaigns() {
         CampaignDTO campaign = new CampaignDTO();
        campaign.setGame("mygame");
        campaign.setName("mycampaign");
        campaign.setPriority(10.5);

        // Set matchers
        CampaignMatchersDTO matchers = new CampaignMatchersDTO();

        // Level matcher
        LevelDTO level = new LevelDTO();
        level.setMin(1);
        level.setMax(3);
        matchers.setLevel(level);

        // "Has" matcher
        matchers.setHas(Map.of(
            "country", List.of("US", "RO", "CA"),
            "items", List.of("item_1")
        ));

        // "Does not have" matcher
        matchers.setDoesNotHave(Map.of(
            "items", List.of("item_4")
        ));

        campaign.setMatchers(matchers);

        // Set dates
        campaign.setStartDate(LocalDateTime.parse("2022-01-25T00:00:00"));
        campaign.setEndDate(LocalDateTime.parse("2022-02-25T00:00:00"));
        campaign.setEnabled(true);
        campaign.setLastUpdated(LocalDateTime.parse("2021-07-13T11:46:58"));

        return List.of(campaign);
      }
}
