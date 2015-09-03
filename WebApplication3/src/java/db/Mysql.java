/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
   
import entities.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Mysql {
    
    private  String dbHost = "127.0.0.1";
    private String dbName = "test";
    private String dbUser = "root";
    private String dbPass = "rootroot";
    
    private Connection connection = null;
    private ResultSet rs = null;
    private  Statement s = null;
    
    public Mysql(){
    
    }
    
    public Mysql(String dbHost, String dbName, String dbUser, String dbPass){
        this.dbHost = dbHost;
        this.dbUser = dbUser;
        this.dbName = dbName;
        this.dbPass = dbPass;
    }
    
    public  void connect() throws SQLException, ClassNotFoundException{
         String connectionURL = "jdbc:mysql://"+this.dbHost+"/"+this.dbName;
         // Загружаем драйвер БД
            Class.forName("com.mysql.jdbc.Driver");
 
            // Подключаемся к БД
            this.connection = DriverManager.getConnection(connectionURL, this.dbUser,
                    this.dbPass);
    }
    
    public ResultSet get(String sql) throws SQLException, ClassNotFoundException{
        this.connect();
        this.s = this.connection.createStatement();
        this.s.executeQuery(sql);
        this.rs = this.s.getResultSet();
        return this.rs;
    }
    
    
    public int update(String sql) throws SQLException, ClassNotFoundException{
        this.connect();
        this.s = this.connection.createStatement();
        int res = this.s.executeUpdate(sql);
        return res;
    }
    
}
