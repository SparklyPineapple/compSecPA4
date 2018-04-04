/*
 * Password (hash) cracker by Josh D'Anna and Kirby Darst  
 */
package pa4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kirby
 */
public class PA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // call pswrd class and enter hash stuff

        
        
        
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
        
        //solve hash and print result
        
        

        
    }
    
    //checks words from the given arraylist
    private String solvePassword(ArrayList[] wordList){ //add passrd class w/ passowrd pswd
        
        
        //checks words w/o case sensitiviey (make all lowercase)
        
        //checks words with pre/post appended symbols,numbers and letters
        
        //checks words with sub of nums/symb
        
        
        return "";
    } 
    


}
