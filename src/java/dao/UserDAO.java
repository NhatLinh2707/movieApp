/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Helper.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserDTO;

/**
 *
 * @author linh2
 */
public class UserDAO {
        static Connection conn;
        static PreparedStatement ps;
        static ResultSet rs; 
        
    public UserDTO login(String username, String password){
            try {
                String query = "select * from Users \n" +
                        "where username = ?;";
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                while(rs.next()){
                    if(password.equals(rs.getString("password"))){
                        UserDTO user = new UserDTO(username);
                        return user;
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return null;
    }
}
