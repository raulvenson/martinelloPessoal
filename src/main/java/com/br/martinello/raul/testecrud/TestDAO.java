/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.martinello.raul.testecrud;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        ResultSet rs = null;
        String sql = "SELECT * FROM estados";
        
        List<Teste> estados = new ArrayList<>();

        try {
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Teste teste = new Teste();
                teste.setCodEstado(rs.getInt("cod_estado"));
                teste.setNomeEstado(rs.getString("nome_estado"));
                teste.setRegiaoEstado(rs.getString("regiao_estado"));
                estados.add(teste);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TestDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(conn, pstm, rs);
        }
        
        
        return estados;
        
    }

    public void update(Teste teste) {
        String sql = "update estados set nome_estado = ?, regiao_estado = ? WHERE cod_estado = ?";

        Connection conn = Conexao.getConexao();
        PreparedStatement pstm = null;

        try {

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, teste.getNomeEstado());
            pstm.setString(2, teste.getRegiaoEstado());
            pstm.setInt(3, teste.getCodEstado());

            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e);
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
        String sql = "delete from estados where cod_estado = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.getConexao();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, teste.getCodEstado());

            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
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
