/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.NFeGetSet;
import gets_sets.TransportadorGetSet;
import gets_sets.VeiculoGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wesley Ricardo
 */
public class nfeDAO {

    public List<NFeGetSet> buscarCliente(String cliente) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<NFeGetSet> listaNFe = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "select c.idClientes, c.Nome, p.idPedidos, pi.idPedidos_Itens, pa.Descricao, pi.Quantidade, pi.Valor " +
                    "from clientes as c " +
                    "join pedidos as p " +
                    "join pedidos_itens as pi " +
                    "join produto_acabado as pa " +
                    "join clientes_has_pedidos as cp " +
                    "join nota_fiscal as nf " +
                    "where cp.idClientes = c.idClientes and " +
                    "nf.idClientes = cp.idClientes and " +
                    "cp.idPedidos = p.idPedidos and " +
                    "cp.idPedidos_Itens = pi.idPedidos_Itens and " +
                    "pi.idProduto_Acabado = pa.idProduto_Acabado and " +
                    "nf.idClientes = c.idClientes and " +
                    "nf.idPedidos = cp.idPedidos and " +
                    "c.Nome like ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + cliente + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            NFeGetSet nfegs = new NFeGetSet();

            nfegs.setIdCliente(rs.getInt("idClientes"));
            nfegs.setNomeCliente(rs.getString("nome"));
            nfegs.setIdPedido(rs.getInt("idPedidos"));
            nfegs.setIdPedidoItens(rs.getInt("idPedidos_Itens"));
            nfegs.setDescpedido(rs.getString("Descricao"));
            nfegs.setQuantidade(rs.getInt("Quantidade"));
            nfegs.setValor(rs.getString("Valor"));

            listaNFe.add(nfegs);

        }
        rs.close();
        conn.close();

        return listaNFe;
    }

    public int numNFe() throws SQLException {

        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();
        String sql = "SELECT MAX(idNota_Fiscal) + 1 FROM nota_fiscal";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("MAX(idNota_Fiscal) + 1");
        }

        return 0;
    }

    public void Insert(NFeGetSet nfe) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = Conexao.getConnection();
            String sql = "INSERT INTO nota_fiscal (idNota_Fiscal, Data, Observacao, Valor, idClientes, idPedidos, idPedidos_Itens, idTransportador, BaseICMS, BaseICMS_ST, ValorICMS, ValorICMS_Subs, idVeiculo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, nfe.getIdNota());
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data;
            try {
                data = new java.sql.Date(fmt.parse(nfe.getData()).getTime());
                ps.setDate(2, data);
            } catch (ParseException ex) {
                Logger.getLogger(nfeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.setString(3, nfe.getObs());
            ps.setString(4, nfe.getValor());
            ps.setInt(5, nfe.getIdCliente());
            ps.setInt(6, nfe.getIdPedido());
            ps.setInt(7, nfe.getIdPedidoItens());
            ps.setInt(8, nfe.getIdTransportador());
            ps.setFloat(9, nfe.getBaseicms());
            ps.setFloat(10, nfe.getBaseicms_st());
            ps.setFloat(11, nfe.getValoricms());
            ps.setFloat(12, nfe.getValoricmssub());
            ps.setInt(13, nfe.getIdVeiculo());

            ps.execute();

            // conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(TransportadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<TransportadorGetSet> carregaTransporte() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        List<TransportadorGetSet> transp = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "SELECT t.Nome, t.idTransportador FROM transportador as t";

        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TransportadorGetSet transpgs = new TransportadorGetSet();

            transpgs.setNome(rs.getString("Nome"));
            transpgs.setIdTransportador(rs.getInt("idTransportador"));

            transp.add(transpgs);

        }
        rs.close();
        conn.close();

        return transp;
    }

    public List<VeiculoGetSet> carregaVeiculo(String transporte) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        List<VeiculoGetSet> veiculo = new ArrayList<>();

        conn = Conexao.getConnection();
        String sql = "SELECT v.Nome, v.idVeiculos "
                + "FROM veiculos as v "
                + "join transportador_has_veiculos as tv "
                + "join transportador as t "
                + "where tv.idVeiculos = v.idVeiculos and "
                + "tv.idTransportador = t.idTransportador and "
                + "t.Nome = ?";

        ps = conn.prepareStatement(sql);
        ps.setString(1, transporte);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            VeiculoGetSet veigs = new VeiculoGetSet();

            veigs.setNome(rs.getString("Nome"));
            veigs.setIdVeiculo(rs.getInt("idVeiculos"));

            veiculo.add(veigs);

        }
        rs.close();
        conn.close();

        return veiculo;
    }

}
