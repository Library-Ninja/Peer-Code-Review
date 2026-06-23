import java.util.Scanner;

public class ShiftByFibonacci
{
    public static void main(String[] args)
    {
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String specialChars = "!@#$%^&*():;,./?\"\'";
        int preFib = 1;
        int fib = 0;
        int temp = 0;
        String answer = "";

        //scanObject is used to take user input
        Scanner scanObject = new Scanner(System.in);
        System.out.println("Enter Plaintext Message:");
        String phrase = scanObject.nextLine();

        String[] aPhrase = new String[phrase.length()];
        //This loop changes the String phrase into a String array of letters
        for (int h = 0; h < phrase.length(); h++)
        {
            aPhrase[h] = phrase.substring(h, h+1).toLowerCase();
        }

        //This loop goes through each letter in the phrase array and shifts each letter by the next number in the fibonacci sequence
        for (String letter : aPhrase)
        {
            //Makes sure the letter is not a special character
            if (specialChars.indexOf(letter) == -1)
            {
                for (int j = 0; j < alphabet.length; j++)
                {
                    //finds the index of the letter in alphabet (j)
                    if (letter.equals(alphabet[j]))
                    {
                        //adds the letter plus the current fibonacci number
                        answer += alphabet[(j + fib)%26];
                        temp = fib;
                        fib += preFib;
                        preFib = temp;
                    }
                }
            }
            else //For special characters
            {
                answer += letter;
            }
        }
        System.out.println(answer);
    }
}
