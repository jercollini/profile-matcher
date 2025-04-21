package com.example.profile_matcher.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYER_PROFILES")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "profile_id", columnDefinition = "CHAR(36)")
    private String profileId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "player_id")    
    private Player player;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private int xp;

    @Column(name = "total_playtime", nullable = false)
    private int totalPlaytime;

    @Column(name = "active_campaigns", length = 1000)
    private String activeCampaigns;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clan_id", referencedColumnName = "clan_id")       
    private Clan clan;
    

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public String getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(String activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}
