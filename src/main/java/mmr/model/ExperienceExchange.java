package mmr.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class ExperienceExchange {

    private final int levelDiff;
    private final int higherWin;
    private final int higherLoss;
    private final int lowerWin;
    private final int lowerLoss;

    private ExperienceExchange(int levelDiff, int higherWin, int higherLoss, int lowerWin, int lowerLoss) {
        this.levelDiff = levelDiff;
        this.higherWin = higherWin;
        this.higherLoss = higherLoss;
        this.lowerWin = lowerWin;
        this.lowerLoss = lowerLoss;
    }

    public static int expGained(int exp, double factor) {
        return (int) ((double) exp * factor);
    }

    private static final Map<Integer, ExperienceExchange> EXP_EXCHANGE = Map.ofEntries(
            Map.entry(0, new ExperienceExchange(0, 100, 100, 100, 100)),
            Map.entry(1, new ExperienceExchange(1, 92, 108, 108, 92)),
            Map.entry(2, new ExperienceExchange(2, 85, 115, 115, 850)),
            Map.entry(3, new ExperienceExchange(3, 79, 121, 121, 79)),
            Map.entry(4, new ExperienceExchange(4, 74, 126, 126, 74)),
            Map.entry(5, new ExperienceExchange(5, 70, 130, 130, 70)),
            Map.entry(6, new ExperienceExchange(6, 66, 134, 134, 66)),
            Map.entry(7, new ExperienceExchange(7, 63, 137, 137, 63)),
            Map.entry(8, new ExperienceExchange(8, 60, 140, 140, 60)),
            Map.entry(9, new ExperienceExchange(9, 58, 142, 142, 58)),
            Map.entry(10, new ExperienceExchange(10, 56, 144, 144, 56)),
            Map.entry(11, new ExperienceExchange(11, 54, 146, 146, 54)),
            Map.entry(12, new ExperienceExchange(12, 53, 147, 147, 53)),
            Map.entry(13, new ExperienceExchange(13, 52, 148, 148, 52)),
            Map.entry(14, new ExperienceExchange(14, 51, 149, 149, 51)),
            Map.entry(15, new ExperienceExchange(15, 50, 150, 150, 50))
    );

    public static ExperienceExchange get(int levelDiff) {
        return levelDiff >= 15 ? EXP_EXCHANGE.get(15) : EXP_EXCHANGE.get(levelDiff);
    }

}
