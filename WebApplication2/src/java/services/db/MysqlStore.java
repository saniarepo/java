/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.db;

import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Alexander
 */
public class MysqlStore {
        
    private static String dbHost = "127.0.0.1";
    private static String dbName = "symfony";
    private static String dbUser = "root";
    private static String dbPass = "rootroot";
    
    public static ArrayList getSelect(String sql){
            // Устанавливаем соединение с БД
 
        String connectionURL = "jdbc:mysql://127.0.0.1/"+dbName;
 
        Connection connection = null;
 
        ResultSet rs;
 
        ArrayList dataList = new ArrayList();
 
        try {
 
            // Загружаем драйвер БД
 
            Class.forName("com.mysql.jdbc.Driver");
 
            // Подключаемся к БД
 
            connection = DriverManager.getConnection(connectionURL, dbUser,
                    dbPass);
 
            // Выбираем данные из БД
 
            Statement s = connection.createStatement();
 
            s.executeQuery(sql);
 
            rs = s.getResultSet();
 
            while (rs.next()) {
 
                // Сохраняем всё в список
 
                dataList.add(rs.getInt("id"));
 
                dataList.add(rs.getString("name"));
 
            }
 
            rs.close();
 
            s.close();
            return dataList;
        } catch (Exception e) {
 
            System.out.println("Exception is ;" + e);
            return null;
 
        }
        
        
    }
    
}
