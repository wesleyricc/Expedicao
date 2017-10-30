/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gets_sets.CargasGetSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
            String sql = "SELECT nf.idNota_Fiscal, c.Nome, endr.Logradouro, endr.Cidade, endr.Estado, endr.Numero"
                    + "FROM clientes AS c "
                    + "JOIN nota_fiscal as nf "
                    + "JOIN endereco AS endr "
                    + "JOIN itens_nota_fiscal as inf "
                    + "JOIN pedidos as p "
                    + "JOIN transportador as t "
                    + "WHERE inf.idPedidos = p.idPedidos  AND "
                    + "p.idClientes = c.idClientes AND "
                    + "c.idEndereco = endr.idEndereco AND "
                    + "nf.idTransportador = t.idTransportador AND "
                    + "nf.idItens_Nota_Fiscal = inf.idItens_Nota_Fiscal "
                    + // comparar cidade e transporte
                    // itens de nota fiscal fazer getset separado
                    "order by idNota_Fiscal;";
            ps = conn.prepareStatement(sql);
            ps.setString(0, c);
            ps.setString(1, t);
            rs = ps.executeQuery();

            while (rs.next()) {
                CargasGetSet cgt = new CargasGetSet();

                cgt.setNFe(rs.getInt("id_notafiscal"));
                cgt.setCliente(rs.getString("nome"));
                cgt.setRua(rs.getString("logradouro"));
                cgt.setCidade(rs.getString("cidade"));
                cgt.setEstado(rs.getString("estado"));
                cgt.setNumero(rs.getInt("numero"));

                listaNFe.add(cgt);

            }
            
            return listaNFe;
        }

    
    
    public Vector carregaCidadesCargas() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector cidade = new Vector();
    
            conn = Conexao.getConnection();
            String sql = "select endr.Cidade " +
                        "FROM clientes AS c " +
                        "JOIN pedidos as p " +
                        "JOIN endereco as endr " +
                        "JOIN pedidos_itens as pi " +
                        "JOIN pedidos_has_pedidos_itens as ppi " +
                        "JOIN itens_nota_fiscal as inf " +
                        "JOIN nota_fiscal as nf " +
                        "WHERE c.idClientes = p.idClientes AND " +
                        "p.idPedidos = ppi.idPedidos AND " +
                        "ppi.idPedidos_Itens = pi.idPedidos_Itens AND " +
                        "inf.idItens_Nota_Fiscal = nf.idItens_Nota_Fiscal AND " +
                        "endr.idEndereco = c.idEndereco " +
                        "GROUP BY endr.Cidade";
            
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cidade.add(rs.getString("cidade"));
   
            }
            rs.close();
            conn.close();
        

        return cidade;
    }
    
    public Vector carregaFormaTransporte() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Vector transporte = new Vector();
    
            conn = Conexao.getConnection();
            String sql = "select t.Nome " +
                        "FROM transportador as t " +
                        "JOIN nota_fiscal as nf " +
                        "WHERE nf.idTransportador = t.idTransportador " +
                        "GROUP BY t.Nome";
            
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
