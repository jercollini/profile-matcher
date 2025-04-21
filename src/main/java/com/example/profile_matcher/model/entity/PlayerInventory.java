package com.example.profile_matcher.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYER_INVENTORY")
public class PlayerInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "inventory_id", columnDefinition = "CHAR(36)")
    private String inventoryId;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private int cash;

    @Column(nullable = false)
    private int coins;

    @OneToMany(mappedBy = "playerInventory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<InventoryItems> inventoryItems;

    public List<InventoryItems> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItems> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
