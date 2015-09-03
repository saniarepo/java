/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        out.println("test");
        //Mysql mysql = new Mysql("127.0.0.1", "test", "root", "rootroot");
        //String sql = "select * from users";
        //ResultSet rs=mysql.exec(sql); 
        
        UserModel model = new UserModel();
        ArrayList<User> list = model.getUsersList();
        for(User user: list){
            out.println(user.id);
            out.println(user.name);
            out.println(user.lastname);
            out.println(user.age);
        }
        
         Mysql mysql = new Mysql(Setting.dbHost, Setting.dbName, Setting.dbUser, Setting.dbPass);
        String sql = "insert into users (name,lastname,age) values('Петр', 'Гарин', 56)";
        mysql.update(sql); 
     
    }
    
}
