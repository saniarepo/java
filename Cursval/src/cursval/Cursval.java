/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursval;


import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.util.*;

/**
 *
 * @author Alexander
 */
public class Cursval {

  public static String url = "http://www.cbr.ru/scripts/XML_dynamic.asp?";
  
  
   
    public static class Curs{
        String valuta;
        String curs;
        String date;
        
        public void setValuta(String valuta){
            this.valuta = valuta;
        }
        
         public void setCurs(String curs){
            this.curs = curs;
        }
         
          public void setDate(String date){
            this.date = date;
        }
          
         public String getValuta(){
             return this.valuta;
         }
         
         public String getCurs(){
             return this.curs;
         }
         
         public String getDate(){
             return this.date;
         }
         
    
    }
    
    
    public static List parse(String xml)throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource xml_source = new InputSource(new StringReader(xml));
        Document doc = builder.parse(xml_source);
        
        List<Curs> curses = new ArrayList<Curs>();
        
        NodeList list = doc.getElementsByTagName("Record");
        for ( int i = 0; i < list.getLength(); i++){
            Curs curs = new Curs();
            curs.setDate(list.item(i).getAttributes().item(0).getNodeValue());
            curs.setValuta(list.item(i).getAttributes().item(1).getNodeValue());
            NodeList sublist = list.item(i).getChildNodes();
            for ( int j = 0; j < sublist.getLength(); j++ ){
                if ( sublist.item(j).getNodeName().equals("Value") ){
                    curs.setCurs( sublist.item(j).getTextContent());
                }
            }
            curses.add(curs);
        }
        return curses;
    }
    
    public static void printCurses(List<Curs> curses ){
        for (Curs curs: curses){
            System.out.println("Дата: "+ curs.getDate());
            System.out.println("Валюта: "+ curs.getValuta());
            System.out.println("Курс: "+ curs.getCurs());
        }
    
    }
}
