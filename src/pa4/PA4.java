/*
 * Password (hash) cracker by Josh D'Anna and Kirby Darst  
 */
package pa4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Kirby
 */
public class PA4 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {

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
        File file = new File("bible.txt");
        Scanner scanner = new Scanner(file);
        ArrayList wordList = new ArrayList();
        String word;

        while (scanner.hasNext()) {
            word = scanner.next();
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
        }

        //make a method that will create all possible word combos & place in a list array 
        ArrayList pswds = new ArrayList();
        ArrayList hashPswds = new ArrayList();
        
        generateHash(wordList, hashPswds, "");
        
        //pswds = preAndAppending(pswds, wordList);
        //make a hashed copy of the list for each person (adds salt too) using createGuess()

        //solve hash and print result in format (username, password, time it took to solve)
//        System.out.println(solvePassword(hashList, pswds, alice));
//        System.out.println(solvePassword(hashList, pswds, bob));
//        System.out.println(solvePassword(hashList, pswds, chuck));
//        System.out.println(solvePassword(hashList, pswds, dan));
//        System.out.println(solvePassword(hashList, pswds, ed));
//        System.out.println(solvePassword(hashList, pswds, frank));
//        System.out.println(solvePassword(hashList, pswds, george));
//        System.out.println(solvePassword(hashList, pswds, harry));
//        System.out.println(solvePassword(hashList, pswds, isaac));
//        System.out.println(solvePassword(hashList, pswds, jack));
//        System.out.println(solvePassword(hashList, pswds, ken));
//        System.out.println(solvePassword(hashList, pswds, laura));
//        System.out.println(solvePassword(hashList, pswds, mary));
//        System.out.println(solvePassword(hashList, pswds, nancy));
//        System.out.println(solvePassword(hashList, pswds, oprah));
//        System.out.println(solvePassword(hashList, pswds, pam));
//        System.out.println(solvePassword(hashList, pswds, quin));
//        System.out.println(solvePassword(hashList, pswds, rob));
//        System.out.println(solvePassword(hashList, pswds, sam));
//        System.out.println(solvePassword(hashList, pswds, tom));
    }

    //checks words from the given arraylist
    //makes educated hashes as guesses and sees if they match
    //returns the name, password and the time it took to calculate it
    private static String solvePassword(ArrayList hashList, ArrayList comboList, Password usern) {
        String pswd = usern.getHash();
        String unhashedPswd = "unhashedPswd";
        long startTime = System.nanoTime();
        long endTime = 0;

        //finds out of password is in list.
        if (hashList.contains(pswd)) {
            endTime = System.nanoTime();
            unhashedPswd = (String) comboList.get(hashList.indexOf(pswd));
        }

        //takes care of stopwatch
        long time = endTime - startTime;
        long milli = time / 100000;
        long sec = milli / 1000;
        long min = sec / 60;
        long hours = min / 60;

        return (unhashedPswd + " " + unhashedPswd + " " + hours + ":" + min + ":" + sec + ":" + milli);
    }
    
    private static void generateHash(ArrayList pswds, ArrayList hashPswds, String salt) throws NoSuchAlgorithmException {
        for (int i = 0; i < pswds.size(); i++){
            String temp = (String)pswds.get(i) + salt;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(temp.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
            System.out.println(temp + " " + myHash);
            hashPswds.add(myHash);
        }
    
    }
    
    private static String singleSub(String password, String letter, String subbedLetter){
        String subbedPass = password.replaceAll(letter, subbedLetter);
        return subbedPass;
    }
    
    private static String subAll(String password){
        String subbedPass = password.replaceAll("a", "@");
//        subbedPass = subbedPass.replaceAll("b", "");
//        subbedPass = subbedPass.replaceAll("c", "");
//        subbedPass = subbedPass.replaceAll("d", "");
        subbedPass = subbedPass.replaceAll("e", "3");
//        subbedPass = subbedPass.replaceAll("f", "");
//        subbedPass = subbedPass.replaceAll("g", "");
//        subbedPass = subbedPass.replaceAll("h", "");
        subbedPass = subbedPass.replaceAll("i", "!");
//        subbedPass = subbedPass.replaceAll("j", "");
//        subbedPass = subbedPass.replaceAll("k", "");
        subbedPass = subbedPass.replaceAll("l", "1");
//        subbedPass = subbedPass.replaceAll("m", "");
//        subbedPass = subbedPass.replaceAll("n", "");
        subbedPass = subbedPass.replaceAll("o", "0");
//        subbedPass = subbedPass.replaceAll("p", "");
//        subbedPass = subbedPass.replaceAll("q", "");
//        subbedPass = subbedPass.replaceAll("r", "");
        subbedPass = subbedPass.replaceAll("s", "$");
        subbedPass = subbedPass.replaceAll("t", "7");
//        subbedPass = subbedPass.replaceAll("u", "");
//        subbedPass = subbedPass.replaceAll("v", "");
//        subbedPass = subbedPass.replaceAll("w", "");
//        subbedPass = subbedPass.replaceAll("x", "");
//        subbedPass = subbedPass.replaceAll("y", "");
        subbedPass = subbedPass.replaceAll("z", "2");
        
        return subbedPass;
    }

    private static ArrayList preAndAppending(ArrayList pswds, ArrayList wordList) {
        //nums 0-9 at indecies 0-9, letters a-z at indices 34 & A-Z at 35-61, symbols 62- 89 (cant do \ and ")
        String digitList = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~`!@#$%^&*()_-+={}[]:;'<>,.?/|'";
        String tempPswd;
        //append/prepend digits (as many as 4)
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < digitList.length(); j++) {
                //prepend 1 digit
                tempPswd = (String) wordList.get(i);
                pswds.add(digitList.substring(j) + tempPswd);
                //append 1 digit
                pswds.add(tempPswd + digitList.substring(j));
                for (int k = 0; k < digitList.length(); k++) {
                    //prepend 2 digits
                    pswds.add(digitList.substring(j) + digitList.substring(k) + tempPswd);
                    //append 2 digits
                    pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k));
                    for (int l = 0; l < digitList.length(); l++) {
                        //prepend 3 digits
                        pswds.add(digitList.substring(j) + digitList.substring(k) + digitList.substring(l) + tempPswd);
                        //append 3 digits
                        pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k) + digitList.substring(l));
                        for (int m = 0; m < digitList.length(); m++) {
                            //prepend 4 digits
                            pswds.add(digitList.substring(j) + digitList.substring(k) + digitList.substring(l)+ digitList.substring(m) + tempPswd);
                            //append 4 digits
                            pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k) + digitList.substring(l) + digitList.substring(m));
                        }
                    }
                }
            }
        }

        return pswds;
    }

}
