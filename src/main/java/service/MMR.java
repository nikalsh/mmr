package service;

import exception.LevelNotFoundException;
import model.Rank;

import java.util.Map;

public class MMR {

    public static Integer findLevelByExperience(int exp) throws LevelNotFoundException {
        return Rank.TABLE.entrySet()
                .stream()
                .filter(e -> exp >= e.getValue().getMinExp() && exp <= e.getValue().getMaxExp())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new LevelNotFoundException("Could not find level in experience range"));
    }

}
