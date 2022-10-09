package racingcar.model.vo;

import racingcar.model.constants.ErrorMessage;

public class TotalRound {

    private final int totalRound;

    public TotalRound(int number) {
        if (!validateRoundCount(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_MIN);
        }
        this.totalRound = number;
    }

    public TotalRound(String input) {
        if (!validateRoundNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_NOT_NUMBER);
        }
        int number = Integer.parseInt(input);
        if (!validateRoundCount(number)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MESSAGE_PREFIX + ErrorMessage.ROUND_COUNT_MIN);
        }
        this.totalRound = number;
    }

    public static boolean validateRoundCount(int number) {
        return number >= 1;
    }

    public static boolean validateRoundNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getTotalRound() {
        return totalRound;
    }
}
