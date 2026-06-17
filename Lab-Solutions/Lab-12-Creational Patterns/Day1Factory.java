// Solution 1: Multi-Channel Notification System
// Pattern: Factory Pattern + Singleton

interface Notification {
    void send();
}

class EmailService implements Notification {
    private static EmailService instance;
    private EmailService() {}
    public static EmailService getInstance() {
        if (instance == null)
            instance = new EmailService();
        return instance;
    }
    public void send() {
        System.out.println("Email Notification Sent");
    }
}

class SMSService implements Notification {
    private static SMSService instance;
    private SMSService() {}
    public static SMSService getInstance() {
        if (instance == null)
            instance = new SMSService();
        return instance;
    }
    public void send() {
        System.out.println("SMS Notification Sent");
    }
}

class NotificationFactory {
    public static Notification getNotification(String type) {
        if (type.equalsIgnoreCase("email"))
            return EmailService.getInstance();
        else
            return SMSService.getInstance();
    }
}

class Day1Factory {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.getNotification("email");
        Notification n2 = NotificationFactory.getNotification("sms");
        n1.send();
        n2.send();
    }
}
