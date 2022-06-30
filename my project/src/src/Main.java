package src;

public class Main {

    public static void main(String[] args) {

        int code = Authentication.authenticate();

        if (code == 0) {
            System.out.println("Login success!");
        } else {
            System.out.println("Login failed!");
        }
    }

}
