package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.constant.Rank;

public class ResultService {
    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;

    public ResultService(LottoTickets lottoTickets, WinningLotto winningLotto) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> calculateResults() {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottoTickets.getLottos()) {
            Rank rank = determineRank(lotto);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }

    private Rank determineRank(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;

        for (int number : lotto.getNumber()) {
            if (winningLotto.getWinningNumbers().contains(number)) {
                matchCount++;
            }
            if (winningLotto.getBonusNumber()==number) {
                matchBonus = true;
            }
        }

        return Rank.valueOf(matchCount, matchBonus);
    }

}
