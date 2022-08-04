import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> tenRolls = new ArrayList<Integer>();
        Random randNum = new Random();
        for (int i=0; i<11; i++) {
            // 랜드넘을 10번 돌려서 나온숫자를 텐롤에 넣어주어야 함
            tenRolls.add(randNum.nextInt(21));
        }
        return tenRolls;        
    }

    public String getRandomLetter() {
        
        Random randLetter = new Random();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabetArray = new String[26];

        for (int i=0; i<26; i++) {
            alphabetArray[i] = String.valueOf(alphabet.charAt(i));
        }
        return alphabetArray[randLetter.nextInt(26)];
    }

    public String generatePassword() {
        String password = "";
        for (int i=0; i<8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordSet = new ArrayList<String>();

        for (int i=0; i<length; i++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
}