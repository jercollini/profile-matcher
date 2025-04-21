package com.example.profile_matcher.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTORY_ITEMS")
public class InventoryItems {

    @EmbeddedId
    private InventoryItemId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("inventoryId") // Maps the inventoryId part of the composite key
    @JoinColumn(name = "inventory_id", nullable = false)

    private PlayerInventory playerInventory;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("itemId") // Maps the itemId part of the composite key
    @JoinColumn(name = "item_id", nullable = false)

    private GameItem gameItem;

    @Column(nullable = false)
    private int quantity;

    public InventoryItemId getId() {
        return id;
    }

    public void setId(InventoryItemId id) {
        this.id = id;
    }

    public PlayerInventory getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(PlayerInventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public GameItem getGameItem() {
        return gameItem;
    }

    public void setGameItem(GameItem gameItem) {
        this.gameItem = gameItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return gameItem != null ? gameItem.getDescription() : null;
    }
}
