/*
 * Password (hash) cracker by Josh D'Anna and Kirby Darst  
 */
package pa4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kirby
 */
public class PA4 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        Password alice = new Password(null, "8f5140bee08ae5847615c9b55e40e56f");
        Password bob = new Password(null, "f32fb20d098584d7cfc39a40a0dce4f2");
        Password chuck = new Password(null, "cc4d706ba1c3017a156eeea9070dd9a9");
        Password dan = new Password(null, "725321a069c71ab4a0d73b66f3a32544");
        Password ed = new Password(null, "798b8202a9ccd2b5271daf804bfcd45d");
        Password frank = new Password(null, "00fcb586544c2be44180cd85eaf24921");
        Password george = new Password(null, "6234e99a2940fa0eaa7d1f82537dfbb4");
        Password harry = new Password(null, "2f5f7d26aee6df8c0d7d5fe5ea09e98c");
        Password isaac = new Password(null, "b95ddb19c0ea2ca56778720a138aa0ce");
        Password jack = new Password(null, "97c6be63844d947564b8687a019cc0f3");
        Password ken = new Password(null, "4002e83daccc6a776c125d80b35e621c");
        Password laura = new Password(null, "94b3f5c480dbba6c169bbc149269da14");
        Password mary = new Password(null, "c33dff9a774add5dcad530b3a85facc9");
        Password nancy = new Password(null, "5e084369ef95582a8b8690f1dc3ab8f4");
        Password oprah = new Password(null, "11c65b1362122712dfd665a483e394d0");
        Password pam = new Password("erty", "3dff33dcb40d5cf35be5d11f033fc895");
        Password quin = new Password("zxcv", "12c45f723d4a80dd89645b0fd05b6c5a");
        Password rob = new Password("hjkl", "e6fac5ee63591a415aa71616c86e9cae");
        Password sam = new Password("uiop", "17cec957462e3ba4d167943ebd50bc93");
        Password tom = new Password("asdf", "850a7a3142acce590dc7a8ee02765358");

        //uses scanner to get all words from bible.txt and put them into the wordList
        Scanner scanner = new Scanner("bible.txt");
        ArrayList wordList = new ArrayList();
        String word;

        //makes a word list without duplicates that is easily accessable
        while (scanner.hasNext()) {
            word = scanner.next();
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
        }

        //solve hash and print result in format (username, password, time it took to solve)
        System.out.println(solvePassword(wordList, alice));
        System.out.println(solvePassword(wordList, bob));
        System.out.println(solvePassword(wordList, chuck));
        System.out.println(solvePassword(wordList, dan));
        System.out.println(solvePassword(wordList, ed));
        System.out.println(solvePassword(wordList, frank));
        System.out.println(solvePassword(wordList, george));
        System.out.println(solvePassword(wordList, harry));
        System.out.println(solvePassword(wordList, isaac));
        System.out.println(solvePassword(wordList, jack));
        System.out.println(solvePassword(wordList, ken));
        System.out.println(solvePassword(wordList, laura));
        System.out.println(solvePassword(wordList, mary));
        System.out.println(solvePassword(wordList, nancy));
        System.out.println(solvePassword(wordList, oprah));
        System.out.println(solvePassword(wordList, pam));
        System.out.println(solvePassword(wordList, quin));
        System.out.println(solvePassword(wordList, rob));
        System.out.println(solvePassword(wordList, sam));
        System.out.println(solvePassword(wordList, tom));

    }

    //checks words from the given arraylist
    //makes educated hashes as guesses and sees if they match
    //returns the name, password and the time it took to calculate it
    private static String solvePassword(ArrayList wordList, Password pswd) {
        String correctGuess = ""; //use createGuess fuction to append correct salt onto end of "guess" hash
        String guess = "";
        String saltyGuess = "";
        long startTime = System.nanoTime();
        long endTime=0; //initiakze when answer is found
        boolean pswdFound = false;
        for (int i = 0; i < wordList.size(); i++) {
            //checks words-case sensitiviey (make all lowercase)  
            //checks words with pre/post appended symbols,numbers and letters
            //checks words with sub of nums/symb
            
            if (pswdFound == true){
                endTime = System.nanoTime();
            }
        }
        long time = endTime-startTime;
        long milli = time/100000; 
        long sec = milli/1000; 
        long min = sec/60;
        long hours = min/60;
                
        return (pswd + " " + correctGuess + " " + hours + ":" + min + ":" + sec + ":" + milli);
    }

}
