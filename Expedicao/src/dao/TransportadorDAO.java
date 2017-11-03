/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.TransportadorGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author comp16
 */
public class TransportadorDAO {
  
        
    public void Insert(TransportadorGetSet trans) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO transportador (Nome, idEndereco, Telefone, CNPJ) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, trans.getNome());
            ps.setInt(2, trans.getIdEndereco());
            ps.setString(3, trans.getTelefone());
            ps.setString(4, trans.getCnpj());

            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(TransportadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
