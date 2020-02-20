/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author mayur
 */
public class GenerateLogs {
    private static GenerateLogs generateLogs;
    
    public static GenerateLogs getInstance(){
        if(generateLogs==null){
            generateLogs=new GenerateLogs();
        }
        return generateLogs;
    }
    
    public void generateLogs(String name, String msg) throws IOException {
        Logger logger = Logger.getLogger(name);
        FileHandler fh;
        try {

            // This block configure the logger with handler and formatter  
            fh = new FileHandler("logs/MyLogFile.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages  
            logger.info(msg);
            fh.close();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
