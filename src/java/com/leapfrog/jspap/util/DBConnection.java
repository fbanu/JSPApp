/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jspap.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DBConnection {
    private Connection conn=null;
    private PreparedStatement stmt=null;
    public void open()throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jspapp", "root", "");
    }
    public PreparedStatement initStatement(String sql)throws SQLException{
        stmt=(PreparedStatement) conn.prepareStatement(sql);
        return stmt;
    }
    public int executeUpdate() throws SQLException{
        return stmt.executeUpdate();
    }
    public ResultSet executeQuery() throws SQLException{
        return stmt.executeQuery();
    }
    public void close() throws SQLException{
        if(conn!=null && !conn.isClosed()){
            conn.close();
        }
    }
}