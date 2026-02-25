// ---------- TIGHT COUPLING ----------
class EmailServiceTight {
    void sendEmail(String message) {
        System.out.println("Email sent (Tight): " + message);
    }
}

class NotificationTight {
    private EmailServiceTight emailService = new EmailServiceTight(); // Direct dependency

    void send(String message) {
        emailService.sendEmail(message);
    }
}

// ---------- LOOSE COUPLING ----------
interface NotificationService {
    void send(String message);
}

class EmailServiceLoose implements NotificationService {
    public void send(String message) {
        System.out.println("Email sent (Loose): " + message);
    }
}

class SmsServiceLoose implements NotificationService {
    public void send(String message) {
        System.out.println("SMS sent (Loose): " + message);
    }
}

class NotificationLoose {
    private NotificationService service;

    NotificationLoose(NotificationService service) {
        this.service = service; // Dependency Injection
    }

    void notifyUser(String message) {
        service.send(message);
    }
}

// ---------- MAIN CLASS ----------
public class Solution {
    public static void main(String[] args) {

        // Tightly coupled usage
        NotificationTight tightNotification = new NotificationTight();
        tightNotification.send("Your order is shipped!");

        // Loosely coupled usage
        NotificationService service = new SmsServiceLoose(); // or new EmailServiceLoose();
        NotificationLoose looseNotification = new NotificationLoose(service);
        looseNotification.notifyUser("Your order is shipped!");
    }
}
