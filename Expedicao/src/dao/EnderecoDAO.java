/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.EnderecoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnderecoDAO {
    
    public EnderecoGetSet Insert(EnderecoGetSet e) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = Conexao.getConnection();

            String sql = "insert into endereco (Logradouro, Cidade, Estado, Pais, Numero) VALUES (?, ?, ?, ?, ?); ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, e.getRua());
            ps.setString(2, e.getCidade());
            ps.setString(3, e.getEstado());
            ps.setString(4, e.getPais());
            ps.setInt(5, e.getNumero());
            ps.execute();
     

            sql = "select max(idEndereco) from endereco; ";
            ps = conn.prepareStatement(sql);
            ps.execute();
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setIdEndereco(rs.getInt("max(idEndereco)"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
}
}
