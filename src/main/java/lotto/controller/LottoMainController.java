package lotto.controller;


import static lotto.exception.ErrorCode.ERROR_PREFIX;

import lotto.view.input.InputView;

public class LottoMainController {

    private LottoMainController(){
    }

    public static void start() {
        int inputMoney = InputView.inputBuyAmount();
    }

}
