/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.TransportadorGetSet;
import gets_sets.VeiculoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author comp16
 */
public class VeiculoDAO {

    public Vector empresaVeiculo() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Vector empresas = new Vector();

        conn = Conexao.getConnection();
        String sql = "SELECT nome FROM transportador";

        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            empresas.add(rs.getString("nome"));
        }

        rs.close();
        conn.close();

        return empresas;
    }

    public Integer empresaCorrespondente(String empresa) {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        int idEmpresa = -1;
        try {
            conn = Conexao.getConnection();
            String sql = "select idTransportador from transportador where nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, empresa);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                idEmpresa = rs.getInt("idTransportador");
                
            }

            conn.commit();
        } catch (SQLException e) {
            // System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        

        return idEmpresa;
    }

    public void Insert(VeiculoGetSet vei) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO veiculos (Nome, Placa, Chassi, Capacidade, Tipo, idTransportador) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ResultSet rs = null;

            ps.setString(1, vei.getNome());
            ps.setString(2, vei.getPlaca());
            ps.setString(3, vei.getChassi());
            ps.setString(4, vei.getCapacidade());
            ps.setString(5, vei.getTipo());
            ps.setInt(6, vei.getIdTransportador());

            ps.execute();
            
            sql = "select max(idVeiculos) from veiculos";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                vei.setIdVeiculo(rs.getInt("max(idVeiculos)"));
            }
            
            
            sql = "INSERT INTO transportador_has_veiculos (idTransportador, idVeiculos) VALUES (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, vei.getIdTransportador());
            ps.setInt(2, vei.getIdVeiculo());
            ps.execute();
            
            

        } catch (SQLException ex) {
            Logger.getLogger(TransportadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
