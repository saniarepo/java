/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net1;

import java.net.*;
import java.io.*;

/**
 *
 * @author Alexander
 */
public class Net1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
         URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        File f = new File("test.html");
        FileOutputStream fos = new FileOutputStream(f);
        
        String inputLine;
        while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
                  fos.write(inputLine.getBytes());
        
        }
            
        in.close();
        fos.close();
    }
    
}
