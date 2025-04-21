package com.example.profile_matcher.model.mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.profile_matcher.model.dto.ClanDTO;
import com.example.profile_matcher.model.dto.DeviceDTO;
import com.example.profile_matcher.model.dto.PlayerProfileDTO;
import com.example.profile_matcher.model.entity.Player;
import com.example.profile_matcher.model.entity.PlayerInventory;

@Component
public class PlayerMapper {
    // TODO Add mapstructs for mapping
    public PlayerProfileDTO playerToPlayerProfileDTO(Player player) {
        if (player == null || player.getPlayerProfile() == null) {
            return null;
        }

        PlayerProfileDTO dto = new PlayerProfileDTO();

        // Map basic fields from Player
        dto.setPlayerId(player.getPlayerId());
        dto.setCountry(player.getCountry());
        dto.setBirthdate(player.getBirthdate());
        dto.setCreated(player.getCreated());
        dto.setModified(player.getModified());
        dto.setLanguage(player.getLanguage());
        dto.setGender(player.getGender());

        // Map fields from PlayerProfile
        dto.setLevel(player.getPlayerProfile().getLevel());
        dto.setXp(player.getPlayerProfile().getXp());
        dto.setTotalPlaytime(player.getPlayerProfile().getTotalPlaytime());

        // Map session from PlayerSession
        if (player.getPlayerSession() != null) {
            dto.setLastSession(player.getPlayerSession().getLastSession());
            dto.setCredential(player.getPlayerSession().getCredential());
        }

        // Map store data from PlayerStore
        if (player.getPlayerStore() != null) {
            dto.setTotalSpent(Double.valueOf(player.getPlayerStore().getSpentMoney()).intValue());            
            dto.setTotalRefund(player.getPlayerStore().getRefundTransactions());
            dto.setTotalTransactions(player.getPlayerStore().getTotalTransactions());
            dto.setLastPurchase(player.getPlayerStore().getLastPurchase());
        }

        // Map active campaigns
        dto.setActiveCampaigns(player.getPlayerProfile().getActiveCampaigns() != null
                ? List.of(player.getPlayerProfile().getActiveCampaigns().split(","))
                : List.of());

        // Map devices
        if (player.getPlayerDevices() != null) {
            dto.setDevices(player.getPlayerDevices().stream()
                    .map(device -> {
                        if (device.getDevice() == null) {
                            return null;
                        }
                        DeviceDTO deviceDTO = new DeviceDTO();
                        deviceDTO.setId(device.getDevice().getId());
                        deviceDTO.setModel(device.getDevice().getModel());
                        deviceDTO.setCarrier(device.getCarrier().getName());
                        deviceDTO.setFirmware(device.getFirmware().getFirmwareVersion());
                        return deviceDTO;
                    })
                    .collect(Collectors.toList()));
        }

        // Map inventory
        if (player.getPlayerInventory() != null) {
            PlayerInventory inventory = player.getPlayerInventory();

            // Use LinkedHashMap to maintain insertion order
            Map<String, Integer> inventoryMap = new LinkedHashMap<>();

            // Add cash and coins first
            inventoryMap.put("cash", inventory.getCash());
            inventoryMap.put("coins", inventory.getCoins());

            // Add inventory items
            if (inventory.getInventoryItems() != null) {
                inventory.getInventoryItems().forEach(item -> {
                    inventoryMap.put(item.getGameItem().getDescription(), item.getQuantity());
                });
            }

            // Set the inventory map to the DTO
            dto.setInventory(inventoryMap);
        }

        // Map clan
        if (player.getPlayerProfile().getClan() != null) {
            ClanDTO clanDTO = new ClanDTO();
            clanDTO.setId(player.getPlayerProfile().getClan().getClanId() != null
                    ? player.getPlayerProfile().getClan().getClanId().trim()
                    : null);
            clanDTO.setName(player.getPlayerProfile().getClan().getName());
            dto.setClan(clanDTO);
        }

        // Map custom field
        // TODO Ask if this needed and how to populate
        dto.setCustomField("mycustom");

        return dto;
    }
}
