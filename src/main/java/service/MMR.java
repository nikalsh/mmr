package service;

import exception.LevelNotFoundException;
import model.ExperienceExchange;
import model.PlayerRank;
import model.Rank;

import java.util.ArrayList;
import java.util.List;

public class MMR {

    public static List<PlayerRank> updatePlayerRanks(PlayerRank winner, PlayerRank loser) throws LevelNotFoundException {

        int winnerExp = winner.getExperience();
        int loserExp = loser.getExperience();
        int winnerLevel = winner.getLevel();
        int loserLevel = loser.getLevel();
        int levelDiff = Math.abs(loser.getLevel() - winner.getLevel());
        ExperienceExchange experienceExchange = ExperienceExchange.get(levelDiff);
        Rank winnerRank = Rank.findRankByLevel(winnerLevel);
        Rank loserRank = Rank.findRankByLevel(loserLevel);
        double winFactor = winnerRank.getWinFactor();
        double lossFactor = loserRank.getLossFactor();

        /* higherWin - lowerLoss */
        if (winnerLevel > loserLevel) {
            int expGained = ExperienceExchange.expGained(experienceExchange.getHigherWin(), winFactor);
            int winSum = winnerExp + expGained;
            winner.setExperience(winSum >= Rank.MAX_EXP ? Rank.MAX_EXP : winSum);

            int expLost = ExperienceExchange.expGained(experienceExchange.getLowerLoss(), lossFactor);
            int loseSum = loserExp - expLost;
            loser.setExperience(loseSum <= 0 ? Rank.MIN_EXP : loseSum);

            return updateLevels(winner, loser, winnerRank, loserRank);
        }

        /* lowerWin - higherLoss */
        int expGained = ExperienceExchange.expGained(experienceExchange.getLowerWin(), winFactor);
        int winSum = winnerExp + expGained;
        winner.setExperience(winSum >= Rank.MAX_EXP ? Rank.MAX_EXP : winSum);

        int expLost = ExperienceExchange.expGained(experienceExchange.getHigherLoss(), lossFactor);
        int loseSum = loserExp - expLost;
        loser.setExperience(loseSum <= 0 ? Rank.MIN_EXP : loseSum);

        return updateLevels(winner, loser, winnerRank, loserRank);
    }

    private static List<PlayerRank> updateLevels(PlayerRank winner, PlayerRank loser, Rank winnerRank, Rank loserRank) throws LevelNotFoundException {
        if (winner.getExperience() > winnerRank.getMaxExp()) {
            int newExp = winner.getExperience();
            Integer newLevel = Rank.findLevelByExperience(newExp);
            winner.setLevel(newLevel);
        }

        if (loser.getExperience() < loserRank.getMinExp()) {
            int newExp = loser.getExperience();
            Integer newLevel = Rank.findLevelByExperience(newExp);
            loser.setLevel(newLevel);
        }

        return new ArrayList<>(List.of(winner, loser));
    }

}
