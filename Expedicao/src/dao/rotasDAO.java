/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.CargasGetSet;
import gets_sets.NFeGetSet;
import gets_sets.RotasGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wesley Ricardo
 */
public class rotasDAO {

    public Vector carregaTransportador() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector transportador = new Vector();

        conn = Conexao.getConnection();
        String sql = "select nome from transportador";
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            transportador.add(rs.getString("nome"));

        }
        rs.close();
        conn.close();

        return transportador;
    }

    public Vector carregaVeiculos(String transportador) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector veiculos = new Vector();

        conn = Conexao.getConnection();
        String sql = "select vei.nome "
                + "from veiculos as vei "
                + "join transportador as t "
                + "join transportador_has_veiculos as tv "
                + "where vei.idTransportador = t.idTransportador AND "
                + "tv.idVeiculos = vei.idVeiculos and "
                + "t.Nome = ?;";
        ps = conn.prepareStatement(sql);
        ps.setString(1, transportador);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            veiculos.add(rs.getString("nome"));

        }
        rs.close();
        conn.close();

        return veiculos;
    }

}
