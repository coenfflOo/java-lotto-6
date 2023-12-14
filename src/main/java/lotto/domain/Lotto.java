package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumbers() {
        Arrays.sort(numbers.toArray());
        return numbers.stream()
            .map(String::valueOf)
            .reduce((a, b) -> a + ", " + b)
            .orElseThrow(IllegalArgumentException::new);
    }

    // TODO: 추가 기능 구현
}
