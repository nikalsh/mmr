package model;

import exception.LevelNotFoundException;

import java.util.Map;

public class Rank {
    private final int level;
    /* minimum exp required for a level */
    private final int minExp;
    /* maximum exp for a level */
    private final int maxExp;
    /* maximum level of opponent */
    private final int maxMatch;
    private final double lossFactor;
    private final double winFactor;

    private Rank(int level, int minExp, int maxExp, int maxMatch, double lossFactor, double winFactor) {
        this.level = level;
        this.minExp = minExp;
        this.maxExp = maxExp;
        this.maxMatch = maxMatch + level;
        this.lossFactor = lossFactor;
        this.winFactor = winFactor;
    }

    public int getLevel() {
        return level;
    }

    public int getMinExp() {
        return minExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public int getMaxMatch() {
        return maxMatch;
    }

    public double getLossFactor() {
        return lossFactor;
    }

    public double getWinFactor() {
        return winFactor;
    }

    public static int MIN_LEVEL = 1;
    public static int MAX_LEVEL = 50;
    public static int MAX_EXP = 1000000000;
    public static int MIN_EXP = 1;

    public static Rank findRankByLevel(Integer level) throws LevelNotFoundException {
        if (TABLE.get(level) != null) {
            return TABLE.get(level);
        }
        throw new LevelNotFoundException(String.format("Could not find level, minimum %s, maxmimum %s%n", MIN_LEVEL, MAX_LEVEL));
    }

    public static Integer findLevelByExperience(int exp) throws LevelNotFoundException {
        return TABLE.entrySet()
                .stream()
                .filter(e -> exp >= e.getValue().getMinExp() && exp <= e.getValue().getMaxExp())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new LevelNotFoundException(String.format("Could not find level in experience range; minimum: %s, maximum: %s%n", MIN_EXP, MAX_EXP)));
    }

    private static final Map<Integer, Rank> TABLE = Map.ofEntries(
            Map.entry(1, new Rank(1, MIN_EXP, 99, 10, 0.0, 1.0)),
            Map.entry(2, new Rank(2, 100, 199, 9, 0.025, 1.0)),
            Map.entry(3, new Rank(3, 200, 299, 8, 0.05, 1.0)),
            Map.entry(4, new Rank(4, 300, 399, 7, 0.075, 1.0)),
            Map.entry(5, new Rank(5, 400, 499, 6, 0.1, 1.0)),
            Map.entry(6, new Rank(6, 500, 599, 5, 0.15, 1.0)),
            Map.entry(7, new Rank(7, 600, 699, 6, 0.2, 1.0)),
            Map.entry(8, new Rank(8, 700, 799, 6, 0.275, 1.0)),
            Map.entry(9, new Rank(9, 800, 899, 6, 0.35, 1.0)),
            Map.entry(10, new Rank(10, 900, 999, 6, 0.4, 1.0)),
            Map.entry(11, new Rank(11, 1000, 1099, 6, 0.45, 1.0)),
            Map.entry(12, new Rank(12, 1100, 1199, 6, 0.5, 1.0)),
            Map.entry(13, new Rank(13, 1200, 1399, 6, 0.55, 1.0)),
            Map.entry(14, new Rank(14, 1400, 1599, 6, 0.575, 1.0)),
            Map.entry(15, new Rank(15, 1600, 1799, 6, 0.6, 1.0)),
            Map.entry(16, new Rank(16, 1800, 1999, 6, 0.625, 1.0)),
            Map.entry(17, new Rank(17, 2000, 2249, 7, 0.65, 1.0)),
            Map.entry(18, new Rank(18, 2250, 2499, 7, 0.675, 1.0)),
            Map.entry(19, new Rank(19, 2500, 2749, 7, 0.7, 1.0)),
            Map.entry(20, new Rank(20, 2750, 2999, 7, 0.725, 1.0)),
            Map.entry(21, new Rank(21, 3000, 3249, 7, 0.75, 1.0)),
            Map.entry(22, new Rank(22, 3250, 3499, 7, 0.775, 1.0)),
            Map.entry(23, new Rank(23, 3500, 3749, 7, 0.8, 1.0)),
            Map.entry(24, new Rank(24, 3750, 3999, 7, 0.825, 1.0)),
            Map.entry(25, new Rank(25, 4000, 4249, 7, 0.85, 1.0)),
            Map.entry(26, new Rank(26, 4250, 4499, 7, 0.875, 1.0)),
            Map.entry(27, new Rank(27, 4500, 4749, 8, 0.9, 1.0)),
            Map.entry(28, new Rank(28, 4750, 4999, 8, 0.925, 1.0)),
            Map.entry(29, new Rank(29, 5000, 5249, 8, 0.95, 1.0)),
            Map.entry(30, new Rank(30, 5250, 5499, 9, 0.975, 1.0)),
            Map.entry(31, new Rank(31, 5500, 5749, 10, 1.0, 1.0)),
            Map.entry(32, new Rank(32, 5750, 5999, 11, 1.0, 1.0)),
            Map.entry(33, new Rank(33, 6000, 6249, 12, 1.0, 1.0)),
            Map.entry(34, new Rank(34, 6250, 6499, 13, 1.0, 1.0)),
            Map.entry(35, new Rank(35, 6500, 6749, 14, 1.0, 1.0)),
            Map.entry(36, new Rank(36, 6750, 6999, 14, 1.0, 1.0)),
            Map.entry(37, new Rank(37, 7000, 7249, 13, 1.0, 1.0)),
            Map.entry(38, new Rank(38, 7250, 7499, 12, 1.0, 1.0)),
            Map.entry(39, new Rank(39, 7500, 7749, 11, 1.0, 1.0)),
            Map.entry(40, new Rank(40, 7750, 7999, 10, 1.0, 1.0)),
            Map.entry(41, new Rank(41, 8000, 8249, 9, 1.0, 1.0)),
            Map.entry(42, new Rank(42, 8250, 8499, 8, 1.0, 0.95)),
            Map.entry(43, new Rank(43, 8500, 8749, 7, 1.0, 0.9)),
            Map.entry(44, new Rank(44, 8750, 8999, 6, 1.0, 0.85)),
            Map.entry(45, new Rank(45, 9000, 9249, 5, 1.0, 0.8)),
            Map.entry(46, new Rank(46, 9250, 9499, 4, 1.0, 0.7)),
            Map.entry(47, new Rank(47, 9500, 9749, 3, 1.0, 0.65)),
            Map.entry(48, new Rank(48, 9750, 9999, 2, 1.0, 0.6)),
            Map.entry(49, new Rank(49, 10000, 10249, 1, 1.0, 0.55)),
            Map.entry(50, new Rank(50, 10250, MAX_EXP, 0, 1.0, 0.5)));
}