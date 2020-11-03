
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {
    public static Connection getConexao(){
        Connection conn = null;
        
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC", "root", "martinello");
            System.out.println("Conectado!");
        }catch(SQLException e){
            System.err.println("ERRO AO CONECTAR");
            e.printStackTrace();
        } 
        return conn;
        }
    
    public static void main(String[] args) {
        Conexao.getConexao();
    }
}
