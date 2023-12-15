package lotto.view.output;

import static lotto.view.constant.OutputMessage.RESPONSE_RESULT;
import static lotto.view.constant.PrintFormat.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.constant.Rank;

public final class OutputView extends OutputWriter {

    public static void printLottoTickets(int amount, List<Lotto> lottos) {
        printFormat(RESPONSE_LOTTO_AMOUNT.getFormat(), amount);
        for (Lotto lotto : lottos) {
            printFormat(RESPONSE_LOTTO_NUMBER.getFormat(), lotto.getNumbers());
        }
    }

    public static void printResult(Map<Rank, Integer> results) {
        printMessageResponse(RESPONSE_RESULT);
        for (Rank rank : Rank.values()) {
            int count = results.getOrDefault(rank, 0);
            if (rank == Rank.SECOND) {
                printFormat3(RESPONSE_LOTTO_RESULT.getFormat(),  rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()), count);
                printNewLine();
            }
            if (rank != Rank.SECOND){
                printFormat3(RESPONSE_BONUS_RESULT.getFormat(),rank.getMatchCount(), formatCurrency(rank.getPrizeMoney()), count);
                printNewLine();
            }
        }
    }

}