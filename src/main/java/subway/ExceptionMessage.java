package subway;

public enum ExceptionMessage {
    INPUT_NONE("값을 입력해 주세요."),
    INPUT_WRONG_MAIN_MENU("존재하지 않는 메뉴입니다. (1 혹은 Q를 입력해 주세요.)"),
    INPUT_WRONG_PATH_MENU("존재하지 않는 메뉴입니다. (1, 2 혹은 B를 입력해 주세요.)"),
    INPUT_NOT_EXIST_STATION("존재하지 않는 역입니다."),
    INPUT_SAME_STATION("출발역과 도착역이 동일합니다."),
    NO_RESULT_CAN_BE_FOUND("결과를 찾을 수 없습니다.");

    private final String exceptionMessage;
    private static final String ERROR_TAG = "[ERROR] ";

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
