package com.example.profile_matcher.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss'Z'";

    @JsonProperty("player_id")
    private String playerId;
    private String credential;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime created;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime modified;
    @JsonProperty("last_session")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime lastSession;
    @JsonProperty("total_spent")
    private int totalSpent;
    @JsonProperty("total_refund")
    private int totalRefund;
    @JsonProperty("total_transactions")
    private int totalTransactions;
    @JsonProperty("last_purchase")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime lastPurchase;
    @JsonProperty("active_campaigns")
    private List<String> activeCampaigns;
    private List<DeviceDTO> devices;
    private int level;
    private int xp;
    @JsonProperty("total_playtime")
    private int totalPlaytime;
    private String country;
    private String language;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime birthdate;
    private String gender;
    private Map<String, Integer> inventory;
    private ClanDTO clan;
    @JsonProperty("_customfield")
    private String customField;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastSession() {
        return lastSession;
    }

    public void setLastSession(LocalDateTime lastSession) {
        this.lastSession = lastSession;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(int totalRefund) {
        this.totalRefund = totalRefund;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public LocalDateTime getLastPurchase() {
        return lastPurchase;
    }

    public void setLastPurchase(LocalDateTime lastPurchase) {
        this.lastPurchase = lastPurchase;
    }

    public List<String> getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(List<String> activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }

    public List<DeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDTO> devices) {
        this.devices = devices;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public ClanDTO getClan() {
        return clan;
    }

    public void setClan(ClanDTO clan) {
        this.clan = clan;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }
}
