package telas;

import dao.CargasDAO;
import dao.rotasDAO;
import gets_sets.CargasGetSet;
import gets_sets.NFeGetSet;
import gets_sets.RotasGetSet;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author comp16
 */
public class InternalCargas extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalCargas
     */
    private CargasDAO cargasDAO = new CargasDAO();
    private rotasDAO rotasDAO = new rotasDAO();
    private DefaultTableModel modeloNFe, modeloCargas, modeloRotas;
    private RotasGetSet rotasgs = new RotasGetSet();

    public InternalCargas() {

        initComponents();

    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transporteComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cidadeComboBox = new javax.swing.JComboBox<>();
        botaoPesquisar = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idCargaNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botaoConfirmarCarga = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCargas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaNFRelacionada = new javax.swing.JTable();
        botaoSubir = new javax.swing.JButton();
        botaoDescer = new javax.swing.JButton();
        botaoNFeGeral = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gerenciar Cargas");

        transporteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        transporteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transporteComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Forma de Transporte");

        jLabel2.setText("NFe Relacionada");

        jLabel3.setText("Cidade");

        cidadeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cidadeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeComboBoxActionPerformed(evt);
            }
        });

        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Carga");

        idCargaNum.setEditable(false);
        idCargaNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idCargaNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCargaNumActionPerformed(evt);
            }
        });

        jLabel5.setText("Itens da Carga");

        botaoConfirmarCarga.setText("Confirmar Carga");
        botaoConfirmarCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarCargaActionPerformed(evt);
            }
        });

        tabelaCargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NFe", "Cliente", "Cidade", "Estado", "Transportador", "Veículo"
            }
        ));
        tabelaCargas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCargasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCargas);

        tabelaNFRelacionada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NFe", "Cliente", "Cidade", "Estado", "Transportador", "Veículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaNFRelacionada.getTableHeader().setReorderingAllowed(false);
        tabelaNFRelacionada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaNFRelacionadaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaNFRelacionada);
        if (tabelaNFRelacionada.getColumnModel().getColumnCount() > 0) {
            tabelaNFRelacionada.getColumnModel().getColumn(0).setResizable(false);
            tabelaNFRelacionada.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelaNFRelacionada.getColumnModel().getColumn(1).setResizable(false);
            tabelaNFRelacionada.getColumnModel().getColumn(2).setResizable(false);
            tabelaNFRelacionada.getColumnModel().getColumn(3).setResizable(false);
            tabelaNFRelacionada.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaNFRelacionada.getColumnModel().getColumn(4).setResizable(false);
            tabelaNFRelacionada.getColumnModel().getColumn(5).setResizable(false);
        }

        botaoSubir.setText("Subir");
        botaoSubir.setFocusable(false);
        botaoSubir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSubir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSubirActionPerformed(evt);
            }
        });

        botaoDescer.setText("Descer");
        botaoDescer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDescerActionPerformed(evt);
            }
        });

        botaoNFeGeral.setText("Exibir NFe Geral");
        botaoNFeGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNFeGeralActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(transporteComboBox, 0, 174, Short.MAX_VALUE)
                                        .addComponent(cidadeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(botaoPesquisar)
                                            .addGap(18, 18, 18)
                                            .addComponent(botaoNFeGeral))
                                        .addComponent(jLabel2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idCargaNum, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(botaoConfirmarCarga)
                                .addGap(34, 34, 34)
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoSubir, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(botaoDescer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(transporteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(cidadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoNFeGeral)
                            .addComponent(botaoPesquisar))))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoRemover))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSubir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoDescer)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idCargaNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoConfirmarCarga)
                    .addComponent(botaoCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed

        try {

            String transporte = (String) transporteComboBox.getSelectedItem();
            String cidade = (String) cidadeComboBox.getSelectedItem();

            List<CargasGetSet> NFe = cargasDAO.getNFe(transporte, cidade);

            modeloNFe = (DefaultTableModel) tabelaNFRelacionada.getModel();
            modeloCargas = (DefaultTableModel) tabelaCargas.getModel();
            modeloNFe.setNumRows(0);

            for (int i = 0; i < NFe.size(); i++) {

                boolean flag = true;
                for (int j = 0; j < modeloCargas.getRowCount(); j++) {

                    if (modeloCargas.getValueAt(j, 0) == NFe.get(i).getId_Nota_Fiscal()) {
                        flag = false;
                        System.out.println("é igual!");

                    }
                }
                if (flag) {
                    System.out.println("é diferente!");
                    modeloNFe.addRow(new Object[]{NFe.get(i).getId_Nota_Fiscal(), NFe.get(i).getTextoCliente(), NFe.get(i).getTextoCidade(), NFe.get(i).getTextoEstado(), NFe.get(i).getTransportador(), NFe.get(i).getVeiculo()});
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botaoPesquisarActionPerformed

    public void setarCampos() throws SQLException {

        Vector itensCidades = cargasDAO.carregaCidadesCargas();
        Vector itensTransportador = cargasDAO.carregaFormaTransporte();

        DefaultComboBoxModel modelCidades = new DefaultComboBoxModel(itensCidades);
        cidadeComboBox.setModel(modelCidades);

        DefaultComboBoxModel modelTransportador = new DefaultComboBoxModel(itensTransportador);
        transporteComboBox.setModel(modelTransportador);

        idCargaNum.setText(Integer.toString(cargasDAO.numCarga()));

    }

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        
         modeloCargas.removeRow(tabelaCargas.getSelectedRow());
         tabelaCargas.setModel(modeloCargas);
        
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void idCargaNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCargaNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCargaNumActionPerformed

    private void botaoConfirmarCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarCargaActionPerformed

        int linha = tabelaCargas.getRowCount();
        CargasGetSet Carga = new CargasGetSet();
        List cidades_entrega = new ArrayList();
        
        try {
            cargasDAO.insertCargas(Carga);
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < linha; i++) {
            Carga.setNFe(Integer.parseInt(tabelaCargas.getValueAt(i, 0).toString()));
            try {
                cargasDAO.insertCargasNotaFiscal(Carga);
            } catch (SQLException ex) {
                Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cidades_entrega.add(tabelaCargas.getValueAt(i, 2).toString());
        }

        Carga.setCidades_entrega(cidades_entrega);
        Carga.setIdCarga(Integer.parseInt(idCargaNum.getText()));
        
        try {
           
            rotasDAO.insertRotas(Carga);
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        Integer idCarga = -1;
        
        try {
            idCarga = cargasDAO.numCarga() - 1;
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }

        rotasgs.setIdCarga(idCarga);
        rotasgs.setCidades(cidades_entrega);
        
              
        try {
            setarCampos();
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }
        modeloCargas.setNumRows(0);

    }//GEN-LAST:event_botaoConfirmarCargaActionPerformed


    private void transporteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transporteComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transporteComboBoxActionPerformed

    private void tabelaNFRelacionadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNFRelacionadaMouseClicked

    }//GEN-LAST:event_tabelaNFRelacionadaMouseClicked

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed

        int linha = tabelaNFRelacionada.getSelectedRow();
        modeloCargas = (DefaultTableModel) tabelaCargas.getModel();
        modeloNFe = (DefaultTableModel) tabelaNFRelacionada.getModel();
        if (linha != -1) {
            modeloCargas.addRow(new Object[]{tabelaNFRelacionada.getValueAt(linha, 0), tabelaNFRelacionada.getValueAt(linha, 1), tabelaNFRelacionada.getValueAt(linha, 2), tabelaNFRelacionada.getValueAt(linha, 3), tabelaNFRelacionada.getValueAt(linha, 4),  tabelaNFRelacionada.getValueAt(linha, 5)});
            modeloNFe.removeRow(linha);

            //modeloCargas.addRow((Object[]{tabelaNFRelacionada.getValueAt(linha, 0)}));
//            NFeGetSet nfegs = new NFeGetSet();
//            
//            nfegs.setId_Nota_Fiscal(Integer.parseInt(modeloCargas.getValueAt(linha, 0).toString()));
//            nfegs.setTextoCliente(modeloCargas.getValueAt(linha, 1).toString());
//            nfegs.setTextoLogradouro(modeloCargas.getValueAt(linha, 2).toString());
//            nfegs.setTextoCidade(modeloCargas.getValueAt(linha, 3).toString());
//            nfegs.setTextoEstado(modeloCargas.getValueAt(linha, 4).toString());
//            System.out.println(nfegs);
//           
//            modeloCargas.addRow(new Object[]{nfegs.getId_Nota_Fiscal(), nfegs.getTextoCliente(), nfegs.getTextoLogradouro(), nfegs.getTextoCidade(), nfegs.getTextoEstado()});
//            modeloNFe.removeRow(linha);
//            tabelaNFRelacionada.setModel(modeloNFe);
//            tabelaCargas.setModel(modeloCargas);
        }


    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSubirActionPerformed

        int tamanho = tabelaCargas.getRowCount();

        modeloCargas.moveRow(tabelaCargas.getSelectedRow(), tabelaCargas.getSelectedRow(), tabelaCargas.getSelectedRow() - 1);

        tabelaCargas.setModel(modeloCargas);


    }//GEN-LAST:event_botaoSubirActionPerformed

    private void cidadeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeComboBoxActionPerformed

    private void botaoDescerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDescerActionPerformed

        int tamanho = tabelaCargas.getRowCount();

        modeloCargas.moveRow(tabelaCargas.getSelectedRow(), tabelaCargas.getSelectedRow(), tabelaCargas.getSelectedRow() + 1);

        tabelaCargas.setModel(modeloCargas);

    }//GEN-LAST:event_botaoDescerActionPerformed

    private void tabelaCargasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCargasMouseClicked

        if (tabelaCargas.getSelectedRow() - 1 == -1) {

            botaoSubir.setEnabled(false);
        } else {
            botaoSubir.setEnabled(true);
        }

        if (tabelaCargas.getSelectedRow() + 1 == tabelaCargas.getRowCount()) {

            botaoDescer.setEnabled(false);
        } else {
            botaoDescer.setEnabled(true);
        }

    }//GEN-LAST:event_tabelaCargasMouseClicked

    private void botaoNFeGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNFeGeralActionPerformed
       
        try {

            List<CargasGetSet> NFe = cargasDAO.getNFeGeral();
            
            modeloNFe = (DefaultTableModel) tabelaNFRelacionada.getModel();
            modeloCargas = (DefaultTableModel) tabelaCargas.getModel();
            modeloNFe.setNumRows(0);

            for (int i = 0; i < NFe.size(); i++) {

                boolean flag = true;
                for (int j = 0; j < modeloCargas.getRowCount(); j++) {

                    if (modeloCargas.getValueAt(j, 0) == NFe.get(i).getId_Nota_Fiscal()) {
                        flag = false;
                        System.out.println("é igual!");

                    }
                }
                if (flag) {
                    System.out.println("é diferente!");
                    modeloNFe.addRow(new Object[]{NFe.get(i).getId_Nota_Fiscal(), NFe.get(i).getTextoCliente(), NFe.get(i).getTextoCidade(), NFe.get(i).getTextoEstado(), NFe.get(i).getTransportador(), NFe.get(i).getVeiculo()});
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(InternalCargas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botaoNFeGeralActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        
         this.dispose();
        
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmarCarga;
    private javax.swing.JButton botaoDescer;
    private javax.swing.JButton botaoNFeGeral;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSubir;
    private javax.swing.JComboBox<String> cidadeComboBox;
    private javax.swing.JTextField idCargaNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabelaCargas;
    private javax.swing.JTable tabelaNFRelacionada;
    private javax.swing.JComboBox<String> transporteComboBox;
    // End of variables declaration//GEN-END:variables
}
