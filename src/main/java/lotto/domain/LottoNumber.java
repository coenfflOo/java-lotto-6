package lotto.domain;

import static lotto.exception.ErrorCode.INVALID_LOTTO_DUPLICATE;
import static lotto.exception.ErrorCode.INVALID_LOTTO_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    public static LottoNumber of(int numbers, Lotto lotto) {
        return new LottoNumber(numbers, lotto);
    }

    private void validate(int number, Lotto lotto) {
        INVALID_LOTTO_NUMBER.validate(() -> invalidRange(number));
        INVALID_LOTTO_DUPLICATE.validate(()->isDuplicate(number, lotto));
    }

    private boolean isDuplicate(int number, Lotto lotto) {
        return lotto.getNumber().contains(number);
    }

    private boolean invalidRange(int number){
        return number < 1 || number > 45;
    }
    // 여기에 필요한 메소드들을 추가합니다.
}
