package com.example.profile_matcher.manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile_matcher.manager.api.PlayerApi;
import com.example.profile_matcher.manager.facade.PlayerFacade;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;

@RestController
public class PlayerController implements PlayerApi {
    
    private static final Logger log = LogManager.getLogger(PlayerController.class);
    
    @Autowired
    private final PlayerFacade playerFacade;

    public PlayerController(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    // TODO: improve request resource uri avoiding verbs
    @Override    
    @PostMapping("/get_client_config/{playerId}")    
    public ResponseEntity<PlayerProfileDTO> getClientConfig(@PathVariable String playerId) {
        log.debug("Fetching client config for playerId: {}", playerId);
        PlayerProfileDTO player = playerFacade.getClientConfig(playerId);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
