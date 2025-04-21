package com.example.profile_matcher.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYER_STORES")
public class PlayerStore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "store_id", columnDefinition = "CHAR(36)")
    private String storeId;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)

    private Player player;

    @Column(name = "spent_money", nullable = false)
    private double spentMoney;

    @Column(name = "refund_transactions", nullable = false)
    private int refundTransactions;

    @Column(name = "last_purchase", nullable = false)
    private LocalDateTime lastPurchase;

    @Column(name = "total_transactions", nullable = false)
    // TODO: Add transactions table by player to store , get total size and set
    private int totalTransactions;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(double spentMoney) {
        this.spentMoney = spentMoney;
    }

    public int getRefundTransactions() {
        return refundTransactions;
    }

    public void setRefundTransactions(int refundTransactions) {
        this.refundTransactions = refundTransactions;
    }

    public LocalDateTime getLastPurchase() {
        return lastPurchase;
    }

    public void setLastPurchase(LocalDateTime lastPurchase) {
        this.lastPurchase = lastPurchase;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
