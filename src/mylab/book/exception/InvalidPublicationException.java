package mylab.book.exception;

public class InvalidPublicationException extends RuntimeException {

    // 기본 생성자
    public InvalidPublicationException() {
        super("유효하지 않은 출판물 정보입니다.");
    }

    // 예외 메시지를 받는 생성자
    public InvalidPublicationException(String message) {
        super(message);
    }
}