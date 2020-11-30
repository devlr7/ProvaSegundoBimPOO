
package com.fatecpg.model;

import java.sql.*;

public class Disciplina {
    
    String name;
    
    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:C:\\Users\\Leandro\\Desktop\\dbprova";
    public static Exception exception = null;
    
    public Disciplina(String name){
        this.name = name;
    }
    
    
    public static void insertDisciplina(String name) throws Exception{
        
        Class.forName(CLASS_NAME);
        Connection con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        stmt.execute("INSERT INTO Disciplina VALUES('"+name+"')");
        stmt.close();
        con.close();
    }
    
    public static void deleteDisciplina(String name) throws Exception{
        
        Class.forName(CLASS_NAME);
        Connection con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        stmt.execute("DELETE FROM Disciplina WHERE name = '"+name+"'");
        stmt.close();
        con.close();
    
}
    
}
