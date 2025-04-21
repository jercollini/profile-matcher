package com.example.profile_matcher.manager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.example.profile_matcher.manager.service.PlayerService;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;
import com.example.profile_matcher.model.entity.Player;
import com.example.profile_matcher.model.entity.PlayerProfile;
import com.example.profile_matcher.model.mapper.PlayerMapper;
import com.example.profile_matcher.repositories.PlayerProfileRepository;
import com.example.profile_matcher.repositories.PlayerRepository;

@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;
    @Autowired
    private final PlayerProfileRepository playerProfileRepository;
    @Autowired
    private PlayerMapper playerMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper,
            PlayerProfileRepository playerProfileRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
        this.playerProfileRepository = playerProfileRepository;

    }

    @Override
    public PlayerProfileDTO getPlayer(String playerId) {
        Assert.notNull(playerId, "Player ID must not be null");

        Optional<Player> player = playerRepository.findById(playerId.toString());

        return player.map(playerMapper::playerToPlayerProfileDTO)
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void savePlayerCampaign(PlayerProfileDTO playerProfileDTO) {
        Assert.notNull(playerProfileDTO, "PlayerProfileDTO must not be null");

        Optional<PlayerProfile> playerProfile = playerProfileRepository.findByPlayer_PlayerId(playerProfileDTO.getPlayerId());
        if (playerProfile.isPresent()) {
            PlayerProfile existingPlayer = playerProfile.get();
            existingPlayer.setActiveCampaigns(String.join(",", playerProfileDTO.getActiveCampaigns()));
            playerProfileRepository.save(existingPlayer);
        }
    }
}
