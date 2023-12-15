package lotto.controller;


import static lotto.exception.ErrorCode.ERROR_PREFIX;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoMainController {
    private static LottoTickets lottoTickets;

    private LottoMainController(){
    }

    public static void start() {

    }

    private static void generateLottoTickets() {
        int inputMoney = InputView.inputBuyAmount();
        lottoTickets = LottoTickets.of(inputMoney);
        OutputView.printLottoTickets(lottoTickets.getAmount(), lottoTickets.getLottos());
    }

    private static void getInputNumbers(){
        Lotto winningLotto = InputView.inputWinningNumber();
    }
}
