/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gunjan
 */
public class Validator {

    public boolean numberPattern(String str) {
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }

    public boolean ssnPattern(String str) {
        Pattern p = Pattern.compile("^\\d{3}-\\d{2}-\\d{4}$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }
    
    public String dateFormat(){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        
        return date;
    }
    
    public boolean emailFormat(String str){
        Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }

}
