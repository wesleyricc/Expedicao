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
        String sql = "select c.Nome, p.idPedidos, pa.Descricao, pi.Quantidade, nf.Valor " +
                    "from clientes as c " +
                    "join pedidos as p " +
                    "join pedidos_itens as pi " +
                    "join produto_acabado as pa " +
                    "join clientes_has_pedidos as cp " +
                    "join nota_fiscal as nf " +
                    "where p.idPedidos = cp.idPedidos and " +
                    "cp.idClientes = c.idClientes and " +
                    "cp.idPedidos_Itens = pi.idPedidos_Itens and " +
                    "pi.idProduto_Acabado = pa.idProduto_Acabado and " +
                    "nf.idPedidos = p.idPedidos and " +
                    "c.Nome like ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + cliente + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            NFeGetSet nfegs = new NFeGetSet();

            nfegs.setNomeCliente(rs.getString("nome"));
            nfegs.setIdPedido(rs.getInt("idPedidos"));
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
}
