package com.example.profile_matcher.manager.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile_matcher.model.dto.PlayerProfileDTO;

/**
 * REST API interface for managing player-related operations.
 * Provides endpoints for retrieving player profile information.
 */
@RestController
@RequestMapping("/api/v1/player")
public interface PlayerApi {   
    
    /**
     * Retrieves a player profile by its ID, updating campaign data if it is needed.
     * @param playerId
     * @return
     */
    ResponseEntity<PlayerProfileDTO> getClientConfig(@PathVariable String playerId);
}
