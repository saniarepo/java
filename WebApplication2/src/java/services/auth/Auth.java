/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.auth;

/**
 *
 * @author Alexander
 */
public class Auth {
     public static boolean checkPassword(String userId, String password){
         if (userId.equals("") || userId == null) return false;
         if(password.equals("") || password == null) return false;
         if (userId.equals("sania") && password.equals("229497")) return true;
         return false;
     }
}
