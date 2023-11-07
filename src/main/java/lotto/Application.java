package lotto;

import lotto.controller.LottoController;
import lotto.service.PurchaseService;
import lotto.service.ResultService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        PurchaseService purchaseService = new PurchaseService();
        ResultService resultService = new ResultService();
        WinningNumberService winningNumberService = new WinningNumberService();
        LottoController lottoController = new LottoController(inputView, outputView, purchaseService, resultService,
                winningNumberService);
        lottoController.play();
    }
}
