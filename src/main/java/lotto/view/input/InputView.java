package lotto.view.input;

import static lotto.view.constant.InputMessage.REQUEST_BUY_AMOUNT;

import lotto.util.InputUtil;
import lotto.util.Parser;

public class InputView {
    private InputView() {
    }

    public static int inputBuyAmount() {
        while (true) {
            try {
                System.out.print(REQUEST_BUY_AMOUNT.getMessage());
                final String input = InputUtil.readLine();
                return Parser.parseInput(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


}