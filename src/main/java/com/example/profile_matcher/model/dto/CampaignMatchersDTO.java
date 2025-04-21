package com.example.profile_matcher.model.dto;

import java.util.List;
import java.util.Map;

public class CampaignMatchersDTO {

    private LevelDTO level;
    private Map<String, List<String>> has;
    private Map<String, List<String>> doesNotHave;

    public LevelDTO getLevel() {
        return level;
    }

    public void setLevel(LevelDTO level) {
        this.level = level;
    }

    public Map<String, List<String>> getHas() {
        return has;
    }

    public void setHas(Map<String, List<String>> has) {
        this.has = has;
    }

    public Map<String, List<String>> getDoesNotHave() {
        return doesNotHave;
    }

    public void setDoesNotHave(Map<String, List<String>> doesNotHave) {
        this.doesNotHave = doesNotHave;
    }
}
