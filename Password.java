package pixl;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Savindi on 10/19/2018.
 *
 * @author Savindi
 */
public class Password {
  public static void main(String[] args) {
    System.out.println(createPassword());
    System.out.println(checkPassword("12e!rty"));
  }

  /*
  Creating the password
      make it 8 characters in length
      have one number and character in it, start with a character.
      have one special character (limit to ! $ _ * )
  */
  /**
   * Create a 8 character long random password which contains a number,a character and a special
   * character(! $ _ *).
   * @return password
   */
  public static char[] createPassword() {
    String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerChars = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";
    String specialChars = "!$_*";
    int pwdLen = 8;
    char[] pwd = new char[pwdLen];
    Random random = new Random();
    int spCharIndex;
    int numIndex;

    String chars = upperChars + lowerChars;
    String allChars = chars + numbers + specialChars;

    pwd[0] = chars.charAt(random.nextInt(chars.length()));

    //Random index to place a number in the password string
    do {
      numIndex = random.nextInt(pwdLen);
    } while (numIndex == 0);
    //Random number
    char num = numbers.charAt(random.nextInt(numbers.length()));
    pwd[numIndex] = num;

    //Random index to place a special character in the password string
    do {
      spCharIndex = random.nextInt(pwdLen);
    } while (spCharIndex == numIndex || spCharIndex == 0);
    System.out.println("character_index: " + spCharIndex + " num_index: " + numIndex);
    //Random special character
    char spChar = specialChars.charAt(random.nextInt(specialChars.length()));
    pwd[spCharIndex] = spChar;
    
    for (int i = 1; i < pwdLen; i++) {
      if (i != numIndex && i != spCharIndex) {
        pwd[i] = allChars.charAt(random.nextInt(allChars.length()));
      }
    }
    return pwd;
  }

  /*
  Checking the password
      allow 6 to 24 characters in length
      have one number and character in it
      have one special character (limit to ! $ _ * )
   */
  /**
   * Check the password whether it is 6-24 character length password with a number, character and
   * a special character(! $ _ * ).
   * @param password password.
   * @return correct boolean variable.
   */
  public static boolean checkPassword(String password) {
    boolean correct = false;
    if (password.length() < 6 || password.length() > 24) {
      correct =  false;
    } else if (Pattern.compile("[0-9]").matcher(password).find()
            && Pattern.compile("[a-zA-Z]").matcher(password).find()
            && Pattern.compile("[!$_*]").matcher(password).find()) {
      correct = true;
    }
    return correct;
  }
}
