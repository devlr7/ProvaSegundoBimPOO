/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatecpg.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import java.util.ArrayList;
/**
 * Web application lifecycle listener.
 *
 * @author Leandro
 */
public class NewServletListener implements ServletContextListener {

    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:C:\\Users\\Leandro\\Desktop\\dbprova";
    public static Exception exception = null;
    
    public static Connection getConnection()throws Exception{
     return DriverManager.getConnection(URL);  
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName(CLASS_NAME);
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            
            stmt.execute("CREATE TABLE IF NOT EXISTS Disciplina("
            + "name VARCHAR (200)NOT NULL"
            +")");
        
            if(getNameDisciplina().isEmpty()){
                stmt.execute("INSERT INTO Disciplina VALUES("+"'POO'"+")");
            }
            
        stmt.close();
        con.close();
            
        }catch(Exception ex){
            exception = ex;
        }
    }

    public static ArrayList<String> getNameDisciplina()throws Exception{
        
        ArrayList<String> list = new ArrayList<>();
       
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM Disciplina");
        
        while(rs.next()){
            list.add(rs.getString("name"));
        }
        
        rs.close();
        stmt.close();
        con.close();
            
        return list;

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
