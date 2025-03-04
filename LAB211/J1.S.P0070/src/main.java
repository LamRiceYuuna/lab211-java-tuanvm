import java.util.ResourceBundle;
import java.util.Locale;

public class main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        EBank tp = new EBank();
        while (true) {
            System.out.println("=======================================");
            System.out.println("1. Vietnamese\n"
                             + "2. English\n"
                             + "3. Exit");
            int option = utils.getInt("Enter your option: ", 1, 3);
            ResourceBundle rb;
            Locale locale;
            
            switch (option) {
                case 1:
                    locale = new Locale("vi", "VIETNAM");
                    rb = ResourceBundle.getBundle("language",locale);
                    tp.login(rb);
                    break;
                case 2:
                    locale = new Locale("en", "ENGLAND");
                    rb = ResourceBundle.getBundle("language",locale);
                    tp.login(rb);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
