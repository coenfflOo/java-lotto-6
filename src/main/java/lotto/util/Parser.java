package lotto.util;

import static lotto.exception.ErrorCode.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DELIMITER = ",";
    // 1000원 단위로 떨어지는 숫자인가
    private static final Pattern REGEX_PRICE_PATTERN = Pattern.compile("^\\d{1,}000$");
    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static int parseInput(String input) {
        INVALID_INPUT.validate(() -> hasWhitespace(input));
        INVALID_AMOUNT_INPUT.validate(() -> isInvalidMoneyPattern(input));
        return Integer.parseInt(input);
    }


    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidMoneyPattern(String input) {
        return matchWithRegex(input, REGEX_PRICE_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
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