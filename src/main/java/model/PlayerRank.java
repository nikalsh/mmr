package model;

import exception.LevelNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PlayerRank {
    private Integer level;
    private Integer experience;
    private String playerId;

    public PlayerRank(Integer experience, String playerId) throws LevelNotFoundException {
        this.experience = experience;
        this.playerId = playerId;
        this.level = Rank.findLevelByExperience(experience);
    }

    public PlayerRank(Integer experience, Integer level) {
        this.experience = experience;
        this.level = level;
    }

    public PlayerRank(Integer experience) throws LevelNotFoundException {
        this.experience = experience;
        this.level = Rank.findLevelByExperience(experience);
    }
}
