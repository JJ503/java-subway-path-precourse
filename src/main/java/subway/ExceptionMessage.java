package subway;

public enum ExceptionMessage {
    INPUT_NONE("값을 입력해 주세요."),
    INPUT_WRONG_MAIN_MENU("존재하지 않는 메뉴입니다. (1 혹은 Q를 입력해 주세요.)"),
    INPUT_WRONG_PATH_MENU("존재하지 않는 메뉴입니다. (1, 2 혹은 B를 입력해 주세요.)");

    private final String exceptionMessage;
    private static final String ERROR_TAG = "[ERROR] ";

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void getExceptionMessage() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
