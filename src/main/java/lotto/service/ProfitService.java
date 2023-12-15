package lotto.service;

import java.util.Map;
import lotto.domain.constant.Rank;

public class ProfitService {
    public static double calculateProfitOfWinning(Map<Rank, Integer> result, int amount) {
        long totalWinningAmount = getTotalWinningAmount(result);
        // 수익률 계산 (총 당첨 금액 / 투입 금액)
         return ((double) totalWinningAmount / (amount*1000)) * 100;
    }

    private static long getTotalWinningAmount(Map<Rank, Integer> result) {
        long totalWinningAmount = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            // 해당 등수의 총 당첨 금액을 계산합니다.
            totalWinningAmount += (long) rank.getPrizeMoney() * count;
        }
        return totalWinningAmount;
    }

}
