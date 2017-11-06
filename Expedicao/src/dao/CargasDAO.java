/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.CargasGetSet;
import gets_sets.NFeGetSet;
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
 * @author comp16
 */
public class CargasDAO {

    
    public List<CargasGetSet> getNFe(String t, String c) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<CargasGetSet> listaNFe = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "SELECT nf.idNota_Fiscal, c.Nome, endr.Logradouro, endr.Cidade, endr.Estado, t.Nome "
                + "from clientes as c "
                + "join endereco as endr "
                + "join transportador as t "
                + "join nota_fiscal as nf "
                + "join pedidos as p "
                + "join clientes_has_pedidos as cp "
                + "where nf.idClientes = c.idClientes and "
                + "nf.idPedidos = p.idPedidos and "
                + "nf.idTransportador = t.idTransportador and "
                + "endr.idEndereco = c.idEndereco and "
                + "nf.idNota_Fiscal not in (select cnf.idNota_Fiscal from cargas_has_nota_fiscal as cnf) and "
                + "endr.Cidade = ? AND "
                + "t.Nome = ? "
                + "GROUP by nf.idNota_Fiscal";
        ps = conn.prepareStatement(sql);
        ps.setString(1, c);
        ps.setString(2, t);
        rs = ps.executeQuery();

        while (rs.next()) {
            CargasGetSet nfegs = new CargasGetSet();

            nfegs.setId_Nota_Fiscal(rs.getInt("idnota_fiscal"));
            nfegs.setTextoCidade(rs.getString("cidade"));
            nfegs.setTextoCliente(rs.getString("nome"));
            nfegs.setTextoLogradouro(rs.getString("logradouro"));
            nfegs.setTextoEstado(rs.getString("estado"));

            listaNFe.add(nfegs);
        }
        rs.close();
        conn.close();

        return listaNFe;
    }

    public List<CargasGetSet> getNFeGeral() throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<CargasGetSet> listaNFe = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "SELECT nf.idNota_Fiscal, c.Nome, endr.Logradouro, endr.Cidade, endr.Estado, t.Nome "
                + "from clientes as c "
                + "join endereco as endr "
                + "join transportador as t "
                + "join nota_fiscal as nf "
                + "join pedidos as p "
                + "join clientes_has_pedidos as cp "
                + "where nf.idClientes = c.idClientes and "
                + "nf.idPedidos = p.idPedidos and "
                + "nf.idTransportador = t.idTransportador and "
                + "endr.idEndereco = c.idEndereco and "
                + "nf.idNota_Fiscal not in (select cnf.idNota_Fiscal from cargas_has_nota_fiscal as cnf) "
                + "GROUP by nf.idNota_Fiscal";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            CargasGetSet nfegs = new CargasGetSet();

            nfegs.setId_Nota_Fiscal(rs.getInt("idnota_fiscal"));
            nfegs.setTextoCidade(rs.getString("cidade"));
            nfegs.setTextoCliente(rs.getString("nome"));
            nfegs.setTextoLogradouro(rs.getString("logradouro"));
            nfegs.setTextoEstado(rs.getString("estado"));

            listaNFe.add(nfegs);
        }
        rs.close();
        conn.close();

        return listaNFe;
    }
    
    
    
    public void insertCargas(CargasGetSet carga) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer idCarga = numCarga();

        try {

            conn = Conexao.getConnection();
            String sql = "insert into cargas values(?,?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCarga);
            ps.setString(2, "Liberado");
            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CargasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertCargasNotaFiscal(CargasGetSet carga) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        Integer idCarga = numCarga() - 1;
   

        try {
            
            conn = Conexao.getConnection();
            String sql = "insert into cargas_has_nota_fiscal values (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCarga);
            ps.setInt(2, carga.getNFe());
            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CargasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Vector carregaCidadesCargas() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector cidade = new Vector();

        conn = Conexao.getConnection();
        String sql = "SELECT endr.Cidade "
                + "from clientes as c "
                + "join endereco as endr "
                + "join transportador as t "
                + "join nota_fiscal as nf "
                + "join pedidos as p "
                + "join clientes_has_pedidos as cp "
                + "where nf.idClientes = c.idClientes and "
                + "nf.idPedidos = p.idPedidos and "
                + "nf.idTransportador = t.idTransportador and "
                + "endr.idEndereco = c.idEndereco "
                + "GROUP by nf.idNota_Fiscal";

        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cidade.add(rs.getString("cidade"));

        }
        rs.close();
        conn.close();

        return cidade;
    }

    public int numCarga() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();
        String sql = "SELECT MAX(idCargas) + 1 FROM cargas";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("MAX(idCargas) + 1");
        }

        return 0;
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

    public Vector carregaFormaTransporte() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector transporte = new Vector();

        conn = Conexao.getConnection();
        String sql = "SELECT t.Nome "
                + "FROM transportador as t "
                + "JOIN nota_fiscal as nf "
                + "WHERE nf.idTransportador = t.idTransportador "
                + "group by t.Nome";

        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            transporte.add(rs.getString("nome"));

        }
        rs.close();
        conn.close();

        return transporte;
    }

}
