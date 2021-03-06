/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.CargasGetSet;
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
import java.util.stream.Collectors;

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
        String sql = "select nome from transportador limit 1";
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

    public void insertRotas(CargasGetSet carga) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer idRota = numRota();

        try {

            conn = Conexao.getConnection();
            String sql = "insert into rotas values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idRota);

            String cidades = carga.getCidades_entrega().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            ps.setString(2, cidades);
            ps.setInt(3, carga.getIdCarga());
            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CargasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int numRota() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();
        String sql = "SELECT MAX(idRotas) + 1 FROM rotas";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("MAX(idRotas) + 1");
        }

        return 0;
    }

    public List<RotasGetSet> getRotas(String t, String v) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<RotasGetSet> listaRota = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "select r.idRotas, r.Cidades, r.idCargas " +
                    "from rotas as r " +
                    "join transportador as t " +
                    "join cargas_has_nota_fiscal as cnf " +
                    "join veiculos as v " +
                    "join nota_fiscal as nf " +
                    "join cargas as c " +
                    "where v.Nome = ? and " +
                    "t.Nome = ? and " +
                    "c.sit = 'Liberado' and " +
                    "r.idCargas = cnf.idCargas and " +
                    "c.idCargas = r.idCargas and " +
                    "cnf.idNota_Fiscal = nf.idNota_Fiscal and " +
                    "nf.idTransportador = t.idTransportador and " +
                    "nf.idVeiculo = v.idVeiculos " +
                    "group by idRotas";

        ps = conn.prepareStatement(sql);
        ps.setString(1, v);
        ps.setString(2, t);
        rs = ps.executeQuery();

        while (rs.next()) {
            RotasGetSet rotags = new RotasGetSet();

            rotags.setIdRota(rs.getInt("idRotas"));
            rotags.setListaCidadeString(rs.getString("Cidades"));
            rotags.setIdCarga(rs.getInt("idCargas"));

            listaRota.add(rotags);
        }
        rs.close();
        conn.close();

        return listaRota;

    }
    
    public void atualizarCarga(Integer idCarga) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update cargas set sit = 'Encerrado' where idCargas = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCarga);
            ps.execute();

//            conn.commit();
        } catch (SQLException e) {
            Logger.getLogger(rotasDAO.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(rotasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(rotasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(rotasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    }

