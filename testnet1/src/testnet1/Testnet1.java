/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testnet1;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Alexander
 */
public class Testnet1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
         String url = "http://site1.loc/test_request.php";
         String file = "test1.html";
         sendRequest(url);
         String content = getContent(url);
         System.out.printf("\nContent: \n %s", content);
         String result = (loadContentToFile(url, file))? "load success": "load fail";
         System.out.printf("\nResult:  %s", result);
    }
    
    /*GET request*/
    public static void sendRequest(String url){
        try{
            URL currUrl = new URL(url);
             BufferedReader in = new BufferedReader(new InputStreamReader(currUrl.openStream()));
             String inputLine;
             while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
             in.close();
        }catch(Exception e){
            System.out.println("Fail open url: "+ url);
        }
    }
    
    /*GET request and get response content*/
    public static String getContent(String url){
        try{
            URL currUrl = new URL(url);
             BufferedReader in = new BufferedReader(new InputStreamReader(currUrl.openStream()));
             StringBuffer sb = new StringBuffer();
             String inputLine;
             while ((inputLine = in.readLine()) != null){
                sb.append(inputLine);
            }
             in.close();
             return sb.toString();
        }catch(Exception e){
            return null;
        }
    }
    
    /*save response on GET request to file*/
    public static boolean loadContentToFile(String url, String filename){
          try{
            URL currUrl = new URL(url);
             BufferedReader in = new BufferedReader(new InputStreamReader(currUrl.openStream()));
             File f = new File(filename);
             FileOutputStream fos = new FileOutputStream(f);
             String inputLine;
             while ((inputLine = in.readLine()) != null){
                fos.write(inputLine.getBytes());
             }
             in.close();
             fos.close();
             return true;
        }catch(Exception e){
            return false;
        }
    
    }
    
    /*send POST request and resive response*/
    public static String sendRequest(String url, String data){
        try{
            URL currUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)currUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
           out.write("data=" + data);
           out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String resivedString;
            StringBuffer sb = new StringBuffer();
            while ((resivedString = in.readLine()) != null) {
               sb.append(resivedString);
            }
            in.close();
            return sb.toString();
        }
        catch(Exception e){
            return null;
        }
        
    }
    
    /*send POST request and resive response*/
    public static String sendPostRequest(String url, Map<String,String> data){
        try{
            URL currUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)currUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            StringBuffer reqStr = new StringBuffer();
           int count = 0;
            for ( String key: data.keySet() ){
               reqStr.append(key).append("=").append(data.get(key));
               count++;
               if ( count  < data.size()) reqStr.append("&");
               
           }
           
            out.write(reqStr.toString());
           out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String resivedString;
            StringBuffer sb = new StringBuffer();
            while ((resivedString = in.readLine()) != null) {
               sb.append(resivedString);
            }
            in.close();
            return sb.toString();
        }
        catch(Exception e){
            return null;
        }
    }
    
    
    public static String uploadFiles(String url, Map<String,String> data, Map<String,String> files){
       try{
            
           File f = null;
           FileInputStream fis = null;
           int c;
           byte[] b = null;
           URL currUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)currUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            String boundary = "----------Q3o1lH0sOFGdmsjeitxjAL";
           connection.addRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
           OutputStream out = connection.getOutputStream();
           int count = 0;
           for (String key: data.keySet()){
                out.write(("--"+boundary+"\n").getBytes());
                out.write(("Content-Disposition: form-data; name=\""+key+"\"\n\n").getBytes());
                
                out.write(data.get(key).getBytes());
                count++;
                 if ( count < (files.size() + data.size())){
                        out.write(("\n--"+boundary+"\n").getBytes());
                   }else{
                        out.write(("\n--"+boundary+"--\n\n").getBytes());
                   }
           }
           
           for (String field: files.keySet()){
                f = new File(files.get(field));
                fis = new FileInputStream(f);
                c  = fis.available();
                b = new byte[c];
                fis.read(b);
                fis.close();
               // out.write(("--"+boundary+"\n").getBytes());
                out.write(("Content-Disposition: form-data; name=\""+field+"\"; filename=\""+f.getName() +"\"\n").getBytes());
                out.write(("Content-Type: application/octet-stream\n").getBytes());
                out.write(("Content-Transfer-Encoding: binary\n\n").getBytes());
                out.write(b);
                count++;
                if ( count < (files.size() + data.size())){
                        out.write(("\n--"+boundary+"\n").getBytes());

                   }else{
                        out.write(("\n--"+boundary+"--\n\n").getBytes());

                   }
           }
          
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String resivedString;
            StringBuffer sb = new StringBuffer();
            while ((resivedString = in.readLine()) != null) {
               sb.append(resivedString);
            }
            in.close();
            return sb.toString();
        }
        catch(Exception e){
            return null;
        }  
    
    
    }
    
    
}
