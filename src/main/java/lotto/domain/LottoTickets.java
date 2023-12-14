package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.List;

public class LottoTickets {

    private final int amount;

    private final List<Lotto> lottos;

    private LottoTickets(int money) {
        this.amount = money/1000;
        this.lottos = new ArrayList<>();
        buyLotto();
    }

    public static LottoTickets of(int money) {
        return new LottoTickets(money);
    }

    private void buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.of(numbers));
        }
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
