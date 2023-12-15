package lotto.util;

import static lotto.exception.ErrorCode.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DELIMITER = ",";
    // 1000원 단위로 떨어지는 숫자인가
    private static final Pattern REGEX_NUMBER_PATTERN = Pattern.compile("^\\d{1,}$");
    // 쉼표(,)를 기준으로 구분되는가
    private static final Pattern REGEX_DELIMITER_PATTERN = Pattern.compile("^\\d{1,}(,\\d{1,}){5,}\\*$");
    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static int parseInput(String input) {
        INVALID_INPUT.validate(() -> hasWhitespace(input));
        INVALID_INPUT.validate(() -> isInvalidNumberPattern(input));
        return Integer.parseInt(input);
    }

    public static List<Integer> parseInputToList(String input) {
        INVALID_INPUT.validate(() -> hasWhitespace(input));
        INVALID_DELIMITER.validate(() -> isInvalidLottoPattern(input));
        INVALID_INPUT.validate(() -> isEndWithDelimiter(input));
        return parseInputToListWithoutDelimiter(input);
    }

    //==Parsing Method==//
    private static List<Integer> parseInputToListWithoutDelimiter(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(DELIMITER)) {
            int numberValue = Integer.parseInt(number);
            INVALID_LOTTO_NUMBER.validate(() -> isInvalidLottoNumber(numberValue));
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidNumberPattern(String input) {
        return matchWithRegex(input, REGEX_NUMBER_PATTERN);
    }
    private static boolean isInvalidLottoPattern(String input) {
        return matchWithRegex(input, REGEX_DELIMITER_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
    }

    //1~45 사이의 숫자인가
    public static boolean isInvalidLottoNumber(Integer value) {
        return value < 1 || value > 45;
    }

    // List를 Set으로 변환했을 때, 크기가 동일한가
    public static boolean isInvalidLottoSize(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    // 양수인가
//    private static boolean isNotPositiveInteger(Integer value) {
//        return value < POSITIVE_NUMBER_MINIMUM_RANGE;
//    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }

}