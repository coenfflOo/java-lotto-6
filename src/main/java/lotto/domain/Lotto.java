package lotto.domain;

import static lotto.exception.ErrorCode.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        INVALID_LOTTO_SIZE.validate(() -> sizeValidate(numbers));
        INVALID_LOTTO_DUPLICATE.validate(()->duplicateValidate(numbers));
    }

    public List<Integer> getNumber(){
        return numbers;
    }

    public String getNumbers() {
        Arrays.sort(numbers.toArray());
        return numbers.stream()
            .map(String::valueOf)
            .reduce((a, b) -> a + ", " + b)
            .orElseThrow(IllegalArgumentException::new);
    }

    private boolean sizeValidate(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean duplicateValidate(List<Integer> numbers) {
        HashSet<Integer> setNumber = new HashSet<>(numbers);
        return setNumber.size() != 6;
    }
}
