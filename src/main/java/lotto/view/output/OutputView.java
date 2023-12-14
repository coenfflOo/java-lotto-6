package lotto.view.output;

import static lotto.view.constant.PrintFormat.*;

import java.util.List;
import lotto.domain.Lotto;

public final class OutputView extends OutputWriter {


    public static void printLottoTickets(int amount, List<Lotto> lottos) {
        printFormat(RESPONSE_LOTTO_AMOUNT.getFormat(), amount);
        for (Lotto lotto : lottos) {
            printFormat(RESPONSE_LOTTO_NUMBER.getFormat(), lotto.getNumbers());
        }
    }
}