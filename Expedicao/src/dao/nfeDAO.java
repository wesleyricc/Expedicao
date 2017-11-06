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
        String sql = "select c.Nome, p.idPedidos, pa.Descricao, pi.Quantidade " +
                    "from clientes as c " +
                    "join pedidos as p " +
                    "join pedidos_itens as pi " +
                    "join produto_acabado as pa " +
                    "join clientes_has_pedidos as cp " +
                    "where c.Nome like ? and " +
                    "p.idPedidos = cp.idPedidos and " +
                    "cp.idClientes = c.idClientes and " +
                    "cp.idPedidos_Itens = pi.idPedidos_Itens and " +
                    "pi.idProduto_Acabado = pa.idProduto_Acabado";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + cliente + "%");
        rs = ps.executeQuery();

        while (rs.next()) {
            NFeGetSet nfegs = new NFeGetSet();

            nfegs.setNomeCliente(rs.getString("nome"));
            
            listaNFe.add(nfegs);

        }
        rs.close();
        conn.close();

        return listaNFe;
    
}
}
