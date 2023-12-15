package lotto.domain;

import java.util.List;

public class WinningLotto {

    //당첨 번호
    private final Lotto winningNumbers;

    //당천 보너스 번호
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumber();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
    // 여기에 필요한 메소드들을 추가합니다.
}

