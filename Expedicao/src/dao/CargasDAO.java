/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author comp16
 */
public class CargasDAO {

    public int getNFe(String cidade, String transporte) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            String sql = "SELECT nf.idNota_Fiscal, c.Nome, endr.Logradouro, endr.Cidade, endr.Estado, endr.Numero\n" +
                        "FROM clientes AS c\n" +
                        "JOIN nota_fiscal as nf\n" +
                        "JOIN endereco AS endr\n" +
                        "JOIN itens_nota_fiscal as inf\n" +
                        "JOIN pedidos as p\n" +
                        "JOIN transportador as t\n" +
                        "WHERE inf.idPedidos = p.idPedidos  AND\n" +
                        "p.idClientes = c.idClientes AND\n" +
                        "c.idEndereco = endr.idEndereco AND\n" +
                        "nf.idTransportador = t.idTransportador AND\n" +
                        "nf.idItens_Nota_Fiscal = inf.idItens_Nota_Fiscal\n" +
                        // comparar cidade e transporte
                        // itens de nota fiscal fazer getset separado
                        "order by idNota_Fiscal;";
            ps = conn.prepareStatement(sql);
            ps.setString(0, cidade);
            ps.setString(1, transporte);
            rs = ps.executeQuery();

           /* if (rs.next()) {

                String razao_social = rs.getString(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String telefone = rs.getString(4);
                String email = rs.getString(5);
                String CNPJ = rs.getString(6);
                
                Fornecedor f = new Fornecedor();
                f.setTextoRazaoFornecedor(razao_social);
                f.setTextoNomeFornecedor(nome);
                f.setTextoEnderecoFornecedor(endereco);
                f.setTextoTelefoneFornecedor(telefone);
                f.setTextoEmailFornecedor(email);
                f.setTextoCNPJFornecedor(CNPJ);
                
                return f;
            }*/
                

            conn.commit();
        } catch (SQLException e) {
            // System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }

        return 1; //retornar o correto
    }

}
