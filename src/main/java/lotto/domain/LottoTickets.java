package lotto.domain;

import static lotto.exception.ErrorCode.INVALID_AMOUNT_INPUT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.List;

public class LottoTickets {
    //구매한 양
    private final int amount;

    //구매한 양 만큼 로또 발행
    private final List<Lotto> lottos;

    private LottoTickets(int money) {
        this.amount = money/1000;
        this.lottos = new ArrayList<>();
        buyLotto();
    }

    public static LottoTickets of(int money) {
        validate(money);
        return new LottoTickets(money);
    }

    private void buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.of(numbers));
        }
    }

    private static void validate(int money){
        INVALID_AMOUNT_INPUT.validate(()->isDivide(money));
    }

    private static boolean isDivide(int input){
        if (input%1000 == 0)
            return true;
        return false;
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
