package lotto.domain;


import java.util.List;
import static lotto.constant.LottoNumber.MAX_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
