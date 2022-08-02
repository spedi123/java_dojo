import java.util.ArrayList;

public class PuzzleTest {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> tenRolls = generator.getTenRolls();
        System.out.println("Random numbers are : " + tenRolls);

        String randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter is : " + randomLetter);

        String password = generator.generatePassword();
        System.out.println("Password is : " + password);

        ArrayList<String> newPassword = generator.getNewPasswordSet(10);
        System.out.println("Passwrd list are : " + newPassword);
    }
}