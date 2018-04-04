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
    protected String name;
    protected String salt;
    protected String hash;
    protected String plaintextPassword;
    protected int time;
    
    public void password(String n, String s, String h){
        name = n;
        salt = s;
        hash = h;
        plaintextPassword = null;
        time = 0;
    }
    
}
