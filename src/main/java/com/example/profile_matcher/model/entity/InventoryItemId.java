package com.example.profile_matcher.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InventoryItemId implements Serializable {

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "inventory_id", columnDefinition = "CHAR(36)")
    private String inventoryId;

    // Default constructor
    public InventoryItemId() {
    }

    // Constructor
    public InventoryItemId(Long itemId, String inventoryId) {
        this.itemId = itemId;
        this.inventoryId = inventoryId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InventoryItemId that = (InventoryItemId) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(inventoryId, that.inventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, inventoryId);
    }
}
