/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

/**
 *
 * @author Alexander
 */
public class Cat{
    String name;
    String lastname;
    String workPhone;
    String homePhone;
    
    public void Cat(){
        
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public void setLastName(String lastname){
       this.lastname = lastname;
    }
    
    public void setWorkPhone(String phone){
       this.workPhone = phone;
    }
    
    public void setHomePhone(String phone){
       this.homePhone = phone;
    }
    
     public String getName(){
       return this.name;
    }
    
    public String getLastName(){
       return this.lastname;
    }
    
    public String getWorkPhone(){
       return this.workPhone;
    }
    
    public String getHomePhone(){
       return this.homePhone;
    }
    
    

}
