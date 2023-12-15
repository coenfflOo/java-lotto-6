package lotto.view.constant;

import java.text.DecimalFormat;

public enum PrintFormat {

    RESPONSE_LOTTO_AMOUNT("%d개를 구매했습니다."),
    RESPONSE_LOTTO_NUMBER("[%s]"),
    RESPONSE_LOTTO_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    RESPONSE_BONUS_RESULT("%d개 일치 (%s원) - %d개"),
    RESPONSE_LOTTO_PRICE("총 수익률은 %.1f%%입니다.");

    private final String format;
    private final DecimalFormat priceFormat;

    PrintFormat(String format) {
        this.format = format;
        this.priceFormat = null;
    }

    PrintFormat(DecimalFormat priceFormat) {
        this.format = null;
        this.priceFormat = priceFormat;
    }

    public String getFormat() {
        return format;
    }

    private DecimalFormat getPriceFormat() {
        return priceFormat;
    }

    /*
    public static String formatBenefit(final String benefitName, final int amount) {
        return String.format(BENEFIT_FORMAT.getFormat(), benefitName, SEPARATOR_FORMAT.getPriceFormat().format(amount));
    }

    public String formatPrice(int amount) {
        if (priceFormat != null) {
            return priceFormat.format(amount) + System.lineSeparator();
        }
        return SEPARATOR_FORMAT.getPriceFormat().format(amount) + System.lineSeparator();
    }*/
}