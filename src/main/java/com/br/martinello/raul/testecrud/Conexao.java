package com.br.martinello.raul.testecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public static Connection getConexao() {
        Connection conn = null;

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC", "root", "martinello");
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.err.println("ERRO AO CONECTAR");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstm) {
        closeConnection(conn);
        try {
            if(pstm != null){
                pstm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) {
        closeConnection(conn, pstm);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
