import java.util.Random;
import java.util.Scanner;
public class Hangman {
    
    public static final String[] WORDS = {"JAVA","PYTHON","SCALA","KOTLIN","PHP","PERL"};
    
    // ANSWERWORD is the word User try to Guess
    public static final String ANSWERWORD = getAnswerWord();
    
    // Below statement will create an EmptyString
    /* Default value will be NULL for each character 
       present in the String */
    public static String emptyString = new String(new char[ANSWERWORD.length()]);
    
    // Replace every character in emptyString with "*" 
    public static String aestriskString = emptyString.replace("\0","*");
    
    // Number of Tries
    public static int attemptsRemaining = 7;
    
    public static void main(String args[])
    {
         do
        {
            System.out.print("Guess any letter: " );
            System.out.println(aestriskString);
            // Take letter from the user
            Scanner in = new Scanner(System.in);
            String guessLetter = in.next();
            checkGuess(guessLetter.toUpperCase());
        }while(attemptsRemaining > 0 && aestriskString.contains("*")); 

        if (attemptsRemaining == 0)
            System.out.println("YOU LOST");
    }

    public static void checkGuess(String guessLetter)
    {
        StringBuilder newAestriskString = new StringBuilder(aestriskString);
        // Loop through each letter of ANSWERWORD
        for(int i=0; i< ANSWERWORD.length(); i++)
        {
            //Check if guessLetter is present in the ANSWERWORD
            if(ANSWERWORD.charAt(i) == guessLetter.charAt(0))
                newAestriskString.setCharAt(i,guessLetter.charAt(0));
        }
        /* If guessLetter is NOT present in ANSWERWORD, then 
           newAsteriskString will be same as asteriskString */
        if(aestriskString.equals(String.valueOf(newAestriskString)))
            attemptsRemaining--;
        else
            aestriskString = String.valueOf(newAestriskString);
        if(aestriskString.equals(ANSWERWORD))
            System.out.println("YOU WIN !! ANSWERWORD was: "+ANSWERWORD);
        else
            System.out.println("ATTENTION !! Tries Left: "+attemptsRemaining);
    }
    
    public static String  getAnswerWord()
    {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        String answerWord = WORDS[index];
        return answerWord;
    }
}
