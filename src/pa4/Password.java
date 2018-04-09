/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa4;



/**
 *
 * @author Joshua
 */
public class Password {
    protected String salt;
    protected String hash;
    protected String name;
    protected String plaintextPassword;
    
    public Password(String s, String h, String n){
        salt = s;
        hash = h; 
        name = n;
    }
    
    public String createGuess (String word){
        String guess = word + this.salt;
        return guess;
    }
    
    public String getHash (){
        return hash;
    }
    
    public String getName(){
        return name;
    }
    
}
//        Password alice = new Password(null, "8f5140bee08ae5847615c9b55e40e56f");
//        Password bob = new Password(null, "f32fb20d098584d7cfc39a40a0dce4f2");
//        Password chuck = new Password(null, "cc4d706ba1c3017a156eeea9070dd9a9");
//        Password dan = new Password(null, "725321a069c71ab4a0d73b66f3a32544");
//        Password ed = new Password(null, "798b8202a9ccd2b5271daf804bfcd45d");
//        Password frank = new Password(null, "00fcb586544c2be44180cd85eaf24921");
//        Password george = new Password(null, "6234e99a2940fa0eaa7d1f82537dfbb4");
//        Password harry = new Password(null, "2f5f7d26aee6df8c0d7d5fe5ea09e98c");
//        Password isaac = new Password(null, "b95ddb19c0ea2ca56778720a138aa0ce");
//        Password jack = new Password(null, "97c6be63844d947564b8687a019cc0f3");
//        Password ken = new Password(null, "4002e83daccc6a776c125d80b35e621c");
//        Password laura = new Password(null, "94b3f5c480dbba6c169bbc149269da14");
//        Password mary = new Password(null, "c33dff9a774add5dcad530b3a85facc9");
//        Password nancy = new Password(null, "5e084369ef95582a8b8690f1dc3ab8f4");
//        Password oprah = new Password(null, "11c65b1362122712dfd665a483e394d0");
//        Password pam = new Password("erty", "3dff33dcb40d5cf35be5d11f033fc895");
//        Password quin = new Password("zxcv", "12c45f723d4a80dd89645b0fd05b6c5a");
//        Password rob = new Password("hjkl", "e6fac5ee63591a415aa71616c86e9cae");
//        Password sam = new Password("uiop", "17cec957462e3ba4d167943ebd50bc93");
//        Password tom = new Password("asdf", "850a7a3142acce590dc7a8ee02765358");
