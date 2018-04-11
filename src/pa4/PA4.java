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

//        Password alice = new Password(null, "8f5140bee08ae5847615c9b55e40e56f", "alice");
        Password bob = new Password(null, "f32fb20d098584d7cfc39a40a0dce4f2", "bob");
//        Password chuck = new Password(null, "cc4d706ba1c3017a156eeea9070dd9a9", "chuck");
        Password dan = new Password(null, "725321a069c71ab4a0d73b66f3a32544", "dan");
//        Password ed = new Password(null, "798b8202a9ccd2b5271daf804bfcd45d", "ed");
//        Password frank = new Password(null, "00fcb586544c2be44180cd85eaf24921", "frank");
        Password george = new Password(null, "6234e99a2940fa0eaa7d1f82537dfbb4", "george");
//        Password harry = new Password(null, "2f5f7d26aee6df8c0d7d5fe5ea09e98c", "harry");
//        Password isaac = new Password(null, "b95ddb19c0ea2ca56778720a138aa0ce", "isaac");
//        Password jack = new Password(null, "97c6be63844d947564b8687a019cc0f3", "jack");
//        Password ken = new Password(null, "4002e83daccc6a776c125d80b35e621c", "ken");
        Password laura = new Password(null, "94b3f5c480dbba6c169bbc149269da14", "laura");
        Password mary = new Password(null, "c33dff9a774add5dcad530b3a85facc9", "mary");
        Password nancy = new Password(null, "5e084369ef95582a8b8690f1dc3ab8f4", "nancy");
        Password oprah = new Password(null, "11c65b1362122712dfd665a483e394d0", "oprah");
//        Password pam = new Password("erty", "3dff33dcb40d5cf35be5d11f033fc895", "pam");
//        Password quin = new Password("zxcv", "12c45f723d4a80dd89645b0fd05b6c5a", "quin");
//        Password rob = new Password("hjkl", "e6fac5ee63591a415aa71616c86e9cae", "rob");
//        Password sam = new Password("uiop", "17cec957462e3ba4d167943ebd50bc93", "sam");
//        Password tom = new Password("asdf", "850a7a3142acce590dc7a8ee02765358", "tom");

        //uses scanner to get all words from bible.txt and put them into the wordList
        File file = new File("bible.txt");
        Scanner scanner = new Scanner(file);
        ArrayList wordList = new ArrayList();
        String word;
        char firstLetter, lastLetter;
        while (scanner.hasNext()) {
            word = scanner.next();
            firstLetter = word.charAt(0);
            lastLetter = word.charAt(word.length() - 1);
            while (!Character.isLetterOrDigit(firstLetter)) {
                word = word.substring(1);
                firstLetter = word.charAt(0);
            }
            while (!Character.isLetterOrDigit(lastLetter)) {
                word = word.substring(0, word.length() - 1);
                lastLetter = word.charAt(word.length() - 1);
            }
            if (!wordList.contains(word)) {
                wordList.add(word);
            }
        }

        //make a method that will create all possible word combos & place in a list array 
        ArrayList pswds = new ArrayList();
        pswds.addAll(wordList);
        ArrayList hashPswds = new ArrayList();
        
//        upperLowerCase(pswds, wordList);
//        preAndAppending(pswds, wordList);

        appendABC(pswds);
        upperCase(pswds);
        lowerCase(pswds);
//        singleSub(pswds, "A", "4");
        singleSub(pswds, "a", "@");
//        singleSub(pswds, "B", "8");
//        singleSub(pswds, "g", "6");
        singleSub(pswds, "e", "3");
        singleSub(pswds, "i", "!");
        singleSub(pswds, "l", "1");
        singleSub(pswds, "o", "0");
        singleSub(pswds, "s", "5");
//        singleSub(pswds, "t", "7");
//        singleSub(pswds, "z", "2");

        generateHash(pswds, hashPswds, "");

        //pswds = preAndAppending(pswds, wordList);
        //make a hashed copy of the list for each person (adds salt too) using createGuess()
        //solve hash and print result in format (username, password, time it took to solve)
//        System.out.println(solvePassword(hashPswds, pswds, alice));
        System.out.println(solvePassword(hashPswds, pswds, bob));
//        System.out.println(solvePassword(hashPswds, pswds, chuck));
        System.out.println(solvePassword(hashPswds, pswds, dan));
//        System.out.println(solvePassword(hashPswds, pswds, ed));
//        System.out.println(solvePassword(hashPswds, pswds, frank));
        System.out.println(solvePassword(hashPswds, pswds, george));
//        System.out.println(solvePassword(hashPswds, pswds, harry));
//        System.out.println(solvePassword(hashPswds, pswds, isaac));
//        System.out.println(solvePassword(hashPswds, pswds, jack));
//        System.out.println(solvePassword(hashPswds, pswds, ken));
        System.out.println(solvePassword(hashPswds, pswds, laura));
        System.out.println(solvePassword(hashPswds, pswds, mary));
        System.out.println(solvePassword(hashPswds, pswds, nancy));
        System.out.println(solvePassword(hashPswds, pswds, oprah));
//        System.out.println(solvePassword(hashPswds, pswds, pam));
//        System.out.println(solvePassword(hashPswds, pswds, quin));
//        System.out.println(solvePassword(hashPswds, pswds, rob));
//        System.out.println(solvePassword(hashPswds, pswds, sam));
//        System.out.println(solvePassword(hashPswds, pswds, tom));
    }

    //checks words from the given arraylist
    //makes educated hashes as guesses and sees if they match
    //returns the name, password and the time it took to calculate it
    private static String solvePassword(ArrayList hashList, ArrayList pswds, Password usern) {
        String pswdHash = usern.getHash();
        String unhashedPswd = "unhashedPswd";

        long startTime = System.nanoTime();
        long endTime = 0;

        //finds out of password is in list.
        if (hashList.contains(pswdHash)) {
            endTime = System.nanoTime();
            unhashedPswd = (String) pswds.get(hashList.indexOf(pswdHash));
        }

        //takes care of stopwatch
        long time = endTime - startTime;
        long milli = time / 100000;
        long sec = milli / 1000;
        long min = sec / 60;
        long hours = min / 60;

        return (usern.getName() + " " + unhashedPswd + " " + hours + ":" + min + ":" + sec + ":" + milli);
    }

    private static void generateHash(ArrayList pswds, ArrayList hashPswds, String salt) throws NoSuchAlgorithmException {
        for (int i = 0; i < pswds.size(); i++) {
            String temp = (String) pswds.get(i) + salt;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(temp.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
//            System.out.println(temp + " " + myHash);
            hashPswds.add(myHash);
        }

    }

    private static void singleSub(ArrayList pswds, String letter, String subbedLetter) {
        int size = pswds.size();
        for(int i = 0; i < size; i++){
            String temp = (String) pswds.get(i);
            String subbedPass = temp.replaceAll(letter, subbedLetter);
            pswds.add(subbedPass);
        }
    }

    private static String subAll(String password) {
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
//                pswds.add(digitList.substring(j) + tempPswd);
                //append 1 digit
                pswds.add(tempPswd + digitList.substring(j));
                for (int k = 0; k < digitList.length(); k++) {
                    //prepend 2 digits
//                    pswds.add(digitList.substring(j) + digitList.substring(k) + tempPswd);
                    //append 2 digits
                    pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k));
                    for (int l = 0; l < digitList.length(); l++) {
                        //prepend 3 digits
//                        pswds.add(digitList.substring(j) + digitList.substring(k) + digitList.substring(l) + tempPswd);
                        //append 3 digits
                        pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k) + digitList.substring(l));
                        for (int m = 0; m < digitList.length(); m++) {
                            //prepend 4 digits
//                            pswds.add(digitList.substring(j) + digitList.substring(k) + digitList.substring(l) + digitList.substring(m) + tempPswd);
                            //append 4 digits
                            pswds.add(tempPswd + digitList.substring(j) + digitList.substring(k) + digitList.substring(l) + digitList.substring(m));
                        }
                    }
                }
            }
        }

        return pswds;
    }

    private static ArrayList upperLowerCase(ArrayList pswds, ArrayList wordList) {
        //just captitolizes first letter
        String word, halfWord, letter;
        for (int i = 0; i < wordList.size(); i++) {
            word = (String) wordList.get(i);
            halfWord = word.substring(1);
            letter = (word.substring(0, 1)).toUpperCase();
            pswds.add(letter + halfWord);
        }
        return pswds;
    }
    
    
    private static void upperCase(ArrayList pswds){
        int size = pswds.size();
        for (int i = 0; i < size; i++){
            String temp = (String) pswds.get(i);
            String upper = temp.toUpperCase();
            pswds.add(upper);
        }
    }
    private static void lowerCase(ArrayList pswds) {
        int size = pswds.size();
        for (int i = 0; i < size; i++){
            String temp = (String) pswds.get(i);
            String lower = temp.toLowerCase();
            pswds.add(lower);
        }
    }
    private static void appendABC(ArrayList pswds) {
        int size = pswds.size();
        for(int i = 0; i < size; i++){
            String temp = (String) pswds.get(i);
            String app = "abc" + temp;
            pswds.add(app);
        }
    
    }

}
