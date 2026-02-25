// ---------- SERVICE INTERFACE ----------
interface NotificationService {
    void send(String message);
}

// ---------- IMPLEMENTATIONS ----------
class EmailService implements NotificationService {
    public void send(String message) { // 
        System.out.println("Email sent: " + message);
    }
}

class SmsService implements NotificationService {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

// ---------- DEPENDENCY INJECTION EXAMPLES ----------
public class DependencyInjection {

    // ---------------- CONSTRUCTOR INJECTION ----------------
    class NotificationConstructor {
        private NotificationService service;

        // Constructor Injection
        NotificationConstructor(NotificationService service) {
            this.service = service;
        }

        void notifyUser(String message) {
            service.send(message);
        }
    }

    // ---------------- SETTER INJECTION ----------------
    class NotificationSetter {
        private NotificationService service;

        // Setter Injection
        void setService(NotificationService service) {
            this.service = service;
        }

        void notifyUser(String message) {
            service.send(message);
        }
    }

    // ---------------- FIELD INJECTION (Spring style) ----------------
    // NOTE: This works in Spring, not plain Java
    // import org.springframework.beans.factory.annotation.Autowired;
    class NotificationField {
        // @Autowired
        private NotificationService service;

        void notifyUser(String message) {
            service.send(message);
        }
    }

    // ---------------- MAIN METHOD FOR TESTING ----------------
    public static void main(String[] args) {
        DependencyInjection di = new DependencyInjection();

        // Constructor Injection
        NotificationConstructor nc =
                di.new NotificationConstructor(new EmailService());
        nc.notifyUser("Constructor Injection Example");

        // Setter Injection
        NotificationSetter ns = di.new NotificationSetter();
        ns.setService(new SmsService());
        ns.notifyUser("Setter Injection Example");

        // Field Injection (simulated manually since no Spring here)
        NotificationField nf = di.new NotificationField();
        nf.service = new EmailService(); // manually injected
        nf.notifyUser("Field Injection Example");
    }
}
 // it is hard 