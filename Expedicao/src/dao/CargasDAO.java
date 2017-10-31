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

        public List<NFeGetSet> getNFe(String t, String c) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        List<NFeGetSet> listaNFe = new ArrayList<>();
        
        
            conn = Conexao.getConnection();
            String sql = "SELECT nf.idNota_Fiscal, c.Nome, endr.Logradouro, endr.Cidade, endr.Estado " +
                        "FROM clientes AS c " +
                        "JOIN nota_fiscal as nf " +
                        "JOIN endereco AS endr " +
                        "JOIN itens_nota_fiscal as inf " +
                        "JOIN pedidos as p " +
                        "JOIN transportador as t " +
                        "JOIN produto_acabado as pa " +
                        "WHERE nf.idItens_Nota_Fiscal = inf.idItens_Nota_Fiscal AND " +
                        "inf.idPedidos = p.idPedidos AND " +
                        "c.idEndereco = endr.idEndereco AND " +
                        "t.idTransportador = nf.idTransportador AND " +
                        "t.Nome = ? AND " +
                        "endr.Cidade = ? AND " +
                        "p.idClientes = c.idClientes AND " +
                        "pa.idPedidos = inf.idPedidos";
            ps = conn.prepareStatement(sql);
            ps.setString(1, t);
            ps.setString(2, c);
            rs = ps.executeQuery();

            while (rs.next()) {
                NFeGetSet nfegs = new NFeGetSet();
                
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
