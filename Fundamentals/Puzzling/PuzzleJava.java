import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> tenRolls = new ArrayList<Integer>();
        Random randNum = new Random();

        for (int i=0; i<10; i++) {
            tenRolls.add(randNum.nextInt(21));
        }
        return tenRolls;
    }
    
    public String getRandomLetter() {
        Random randLetter = new Random();

        String alphabetLetter = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i=0; i<26; i++) {
            alphabet[i] = String.valueOf(alphabetLetter.charAt(i));
        }
        return alphabet[randLetter.nextInt(26)];
    }

    public String generatePassword(){
        String password = "";
        for (int i=0; i<8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> newPassword = new ArrayList<String>();

        for (int i=0; i<length; i++) {
            newPassword.add(generatePassword());
        }
        return newPassword;
    }
}