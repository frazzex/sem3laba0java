package dip;

/**
 * Добавьте новый класс SmsSender, который будет отправлять SMS-сообщения.
 * Попробуйте внедрить его в NotificationService.
 * Поймите, что возможно, это не так и просто :)
 * Проведите рефакторинг в соответствии с принципом инверсии зависимостей.
 */
public class NotificationService {
    private final MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void send(String message) {
        messageSender.send(message);
    }
}
