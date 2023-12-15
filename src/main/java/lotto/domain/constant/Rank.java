package lotto.domain.constant;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    Rank(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        // 2등과 3등은 일치하는 번호가 5개일 때, 보너스 번호 일치 여부에 따라 결정됩니다.
        if (matchCount == 5 && matchBonus) {
            return Rank.SECOND;
        }
        if (matchCount == 5 && !matchBonus) {
            return Rank.THIRD;
        }

        for (Rank rank : values()) {
            if (matchCount == rank.matchCount && rank != Rank.SECOND) {
                return rank;
            }
        }

        return Rank.NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}

