package src;

import java.util.Scanner;

public class Authentication {

    private static final String LOGIN = "vitali";
    private static final String PASSWORD = "1234";

    public static int authenticate() {
        Scanner s = new Scanner(System.in);

        boolean isLoginSuccess = false;

        for (int maxCount = 3; maxCount > 0 && !isLoginSuccess; maxCount--) {
            System.out.print("Login: ");
            String login = s.nextLine();

            System.out.print("Password: ");
            String password = s.nextLine();

            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                isLoginSuccess = true;
            }
        }

        return isLoginSuccess ? 0 : -1;
    }


}
