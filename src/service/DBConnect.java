/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Shakith
 */
public class DBConnect {
        private static Connection conn;
    
    private static void DBConn() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/timetable", "root", "123");
    }
    
    public static void iud(String sql) throws Exception {
        if(conn == null)
            DBConn();
        conn.createStatement().executeUpdate(sql);
    }
    public static ResultSet search(String sql)throws Exception{
        if(conn==null){
            DBConn();
        }
        return  conn.createStatement().executeQuery(sql);
    }
    public static Connection getConn()throws Exception{
        if(conn==null){
            DBConn();
        }
        return conn;
    } 
}
