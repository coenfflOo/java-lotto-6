package lotto.view.constant;

public enum OutputMessage {
    RESPONSE_RESULT("""
            당첨 통계
            ---
            """)
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
