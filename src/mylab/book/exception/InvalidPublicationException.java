package mylab.book.exception;

public class InvalidPublicationException extends RuntimeException {

    // �⺻ ������
    public InvalidPublicationException() {
        super("��ȿ���� ���� ���ǹ� �����Դϴ�.");
    }

    // ���� �޽����� �޴� ������
    public InvalidPublicationException(String message) {
        super(message);
    }
}