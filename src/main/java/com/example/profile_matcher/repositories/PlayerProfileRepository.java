package com.example.profile_matcher.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.profile_matcher.model.entity.PlayerProfile;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, String> {

    Optional<PlayerProfile> findByPlayer_PlayerId(String playerId);
}
