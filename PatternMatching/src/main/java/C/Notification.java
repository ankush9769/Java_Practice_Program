package C;

public sealed interface Notification permits SMSNotification, EmailNotification,PushNotification{
}
