/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;
import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;




/**
 *
 * @author Alexander
 */
public class XMLparser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("G:\\Users\\Alexander\\Documents\\contacts2.xml");
        try{
            List<Cat> cats = parse2(file);
            for ( Cat cat: cats ){
                System.out.println("Name:" + cat.getName());
                System.out.println("LastName:" + cat.getLastName());
                System.out.println("workPhone:" + cat.getWorkPhone());
                System.out.println("homePhone:" + cat.getHomePhone());
                System.out.println("-----------------------------------");
                
            }
        }catch(Exception e){
            System.out.println(e.toString());
        
        }
   }
        
    
    public static String readFile(File file){
        try{
            FileInputStream fis = new FileInputStream(file);
            String inputLine;
            StringBuffer sb = new StringBuffer();
             BufferedReader in = new BufferedReader(new InputStreamReader(fis));
             while( (inputLine = in.readLine()) != null ){
                 sb.append(inputLine);
             }
              return sb.toString();
                                         
        }catch(Exception e){
            return null;
        }
    
    }
    
    
    public static void parse(File file) throws Exception{
        
        
        String string = readFile(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource xml_source = new InputSource(new StringReader(string));
        Document doc = builder.parse(file);

        NodeList list = doc.getElementsByTagName("contact");
            for (int i = 0; i <list.getLength(); i++){
                System.out.println(list.item(i).getAttributes().item(0).getNodeValue());
                System.out.println(list.item(i).getAttributes().item(1).getNodeName());
                 System.out.println(list.item(i).getAttributes().item(2));
                 System.out.println("------------------------------------");
                
            }

    }
    
     public static List parse2(File file) throws Exception{
        
        
        String string = readFile(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource xml_source = new InputSource(new StringReader(string));
        Document doc = builder.parse(file);

        List<Cat> catsList = new ArrayList<Cat>();
        
        NodeList list = doc.getElementsByTagName("contact");
            for (int i = 0; i <list.getLength(); i++){
               Cat cat = new Cat(); 
                NodeList sublist = list.item(i).getChildNodes();
               for ( int j = 0; j < sublist.getLength(); j++ ){
                   if (!sublist.item(j).getNodeName().equals("phone") ){
                       if ( sublist.item(j).getNodeName().equals("firstname")) cat.setName(sublist.item(j).getTextContent());
                       if (sublist.item(j).getNodeName().equals("lastname") )cat.setLastName(sublist.item(j).getTextContent());
                   }else{
                       cat.setWorkPhone(sublist.item(j).getAttributes().item(0).getNodeValue());
                       cat.setHomePhone(sublist.item(j).getAttributes().item(1).getNodeValue());
                   }
                  
               }
               catsList.add(cat);
                    
            }
            return catsList;
    }
     
     
    
    
}


