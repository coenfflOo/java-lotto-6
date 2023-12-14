package lotto.exception;

import java.util.function.BooleanSupplier;

public enum ErrorCode {
    INVALID_AMOUNT_INPUT("금액은 1000단위로 떨어지는 숫자여야 합니다. 다시 입력해 주세요."),
    INVALID_INPUT("입력값이 올바르지 않습니다. 다시 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public void validate(BooleanSupplier condition) {
        if (isSameCondition(condition)) {
            throw BusinessException.from(this);
        }
    }

    private boolean isSameCondition(BooleanSupplier condition) {
        return condition.getAsBoolean();
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
