/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.martinello.raul.testecrud;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raul.venson
 */
public class TestDAO {

    public void save(Teste teste) {
        String sql = "insert into estados (nome_estado, regiao_estado) values (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.getConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, teste.getNomeEstado());
            pstm.setString(2, teste.getRegiaoEstado());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Teste> read() {
        
        Connection conn = Conexao.getConexao();
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM estados";

        try {
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Teste teste) {
        String sql = "update estados set nome_estado = ?, regiao_estado = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.getConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, teste.getNomeEstado());
            pstm.setString(2, teste.getRegiaoEstado());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Teste teste) {
        String sql = "delete estados where nome_estado = ? and regiao_estado = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.getConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, teste.getNomeEstado());
            pstm.setString(2, teste.getRegiaoEstado());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
