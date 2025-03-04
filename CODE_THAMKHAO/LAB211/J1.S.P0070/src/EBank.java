import java.util.Random;
import java.util.ResourceBundle;

public class EBank {
    Utils utils = new Utils();

    public void login(ResourceBundle rb) {
        String account = checkAccount(rb);
        System.out.println(rb.getString("account.is") + account);
        checkPassword(rb);
        checkCapcha(rb);
        System.out.println(rb.getString("success"));

    }

    private String checkAccount(ResourceBundle rb) {
        String account = utils.getString(rb.getString("account"), rb.getString("account.wrong"), "[0-9]{10}");
        return account;
    }

    private void checkPassword(ResourceBundle rb) {
        String password;
        System.out.println(rb.getString("password"));
        do {
            password = utils.sc.nextLine();
            if (!password.matches("[a-zA-Z0-9]{8,31}")
                    || !password.matches("[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*")
                    || !password.matches("[a-zA-Z0-9]*[0-9]+[a-zA-Z0-9]*")) {
                System.err.print(rb.getString("password.wrong"));
                continue;
            }
            break;
        } while (true);
    }

    private void checkCapcha(ResourceBundle rb) {
        String capchaGenerate = randomCapcha();
        System.out.println("Captcha: " + capchaGenerate);
        do {
            String capchaInput = utils.getString(rb.getString("capcha"), rb.getString("capcha.wrong"), "[a-zA-Z0-9]{1,5}");
            if (!capchaGenerate.contains(capchaInput)) {
                System.err.println(rb.getString("capcha.wrong"));
                continue;
            }
            break;
        } while (true);
    }

    private String randomCapcha() {
        Random rand = new Random();
        String s = "";
        for (char i = 'a'; i <= 'z'; i++) {
            s += i;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            s += i;
        }
        for (int i = 0; i <= 9; i++) {
            s += i;
        }
        String capcha = "";
        for (int i = 0; i < 5; i++) {
            int indexCapcha = rand.nextInt(s.length());
            capcha += s.charAt(indexCapcha);
        }
        return capcha;
    }
}
