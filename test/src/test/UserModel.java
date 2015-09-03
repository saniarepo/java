/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Alexander
 */
public class UserModel {
    private final String table = "users";    
    
    public ArrayList getUsersList() throws SQLException, ClassNotFoundException{
            String sql = "select * from "+this.table;
            Mysql mysql = new Mysql(Setting.dbHost, Setting.dbName, Setting.dbUser, Setting.dbPass);
            ResultSet rs = mysql.get(sql);
            ArrayList list = new ArrayList<User>();
            while (rs.next()) {
 
                // Сохраняем всё в список
                User user = new User();
                user.id = rs.getInt("id");
                user.name = rs.getString("name");
                user.lastname = rs.getString("lastname");
                user.age = rs.getInt("age");
                list.add(user);
            }
             return list;
        }
    
        public void addUser(User user) throws SQLException, ClassNotFoundException{
            String sql = "insert into "+this.table+" (name, lastname, age) values("+user.name+","+user.lastname+","+user.age+")";
            Mysql mysql = new Mysql(Setting.dbHost, Setting.dbName, Setting.dbUser, Setting.dbPass);
            mysql.update(sql);
        }
        
        public void delUser(int id) throws SQLException, ClassNotFoundException{
              String sql = "delete from "+this.table+" where id="+id;
              Mysql mysql = new Mysql(Setting.dbHost, Setting.dbName, Setting.dbUser, Setting.dbPass);
              mysql.update(sql);
        }
        
        public void updateUser(int id, User user) throws SQLException, ClassNotFoundException{
               String sql = "update "+this.table+" set name="+user.name+",lastname="+user.lastname+",age="+user.age + " where id="+id;
               Mysql mysql = new Mysql(Setting.dbHost, Setting.dbName, Setting.dbUser, Setting.dbPass);
               mysql.update(sql);
        }
}
