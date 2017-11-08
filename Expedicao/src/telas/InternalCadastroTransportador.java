/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.EnderecoDAO;
import dao.TransportadorDAO;
import gets_sets.EnderecoGetSet;
import gets_sets.TransportadorGetSet;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley Ricardo & PHB
 */
public class InternalCadastroTransportador extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalCadastroTransportador
     */
    
    EnderecoDAO enddao = new EnderecoDAO();
    TransportadorDAO transdao = new TransportadorDAO();
    EnderecoGetSet endgetset = new EnderecoGetSet();
    TransportadorGetSet transgetset = new TransportadorGetSet();
    
    
    public InternalCadastroTransportador() {
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

        botaoLimparTransportador = new javax.swing.JButton();
        textoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoCidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botaoCadastrarTransportador = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoEstado = new javax.swing.JTextField();
        textoNumero = new javax.swing.JTextField();
        textoPais = new javax.swing.JTextField();
        textoRua = new javax.swing.JTextField();
        textoCNPJ = new javax.swing.JFormattedTextField();
        textoTelefone = new javax.swing.JFormattedTextField();
        botaoCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastro de Transportador");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        botaoLimparTransportador.setText("Limpar");
        botaoLimparTransportador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparTransportadorActionPerformed(evt);
            }
        });

        textoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNomeActionPerformed(evt);
            }
        });
        textoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNomeKeyTyped(evt);
            }
        });

        jLabel3.setText("CNPJ");

        jLabel4.setText("Telefone");

        textoCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCidadeActionPerformed(evt);
            }
        });
        textoCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoCidadeKeyTyped(evt);
            }
        });

        jLabel1.setText("Nome");

        botaoCadastrarTransportador.setText("Cadastrar");
        botaoCadastrarTransportador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarTransportadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Rua");

        jLabel6.setText("Estado");

        jLabel7.setText("Número");

        jLabel8.setText("País");

        jLabel9.setText("Cidade");

        textoEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEstadoActionPerformed(evt);
            }
        });
        textoEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoEstadoKeyTyped(evt);
            }
        });

        textoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNumeroActionPerformed(evt);
            }
        });
        textoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNumeroKeyTyped(evt);
            }
        });

        textoPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoPaisActionPerformed(evt);
            }
        });
        textoPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoPaisKeyTyped(evt);
            }
        });

        textoRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoRuaActionPerformed(evt);
            }
        });
        textoRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoRuaKeyTyped(evt);
            }
        });

        try {
            textoCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textoCNPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCNPJActionPerformed(evt);
            }
        });

        try {
            textoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel5)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textoRua, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(textoCNPJ)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botaoCadastrarTransportador)
                                        .addGap(40, 40, 40)
                                        .addComponent(botaoLimparTransportador, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoPais)
                                    .addComponent(textoNumero)
                                    .addComponent(textoTelefone)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCancelar)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(textoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrarTransportador)
                    .addComponent(botaoLimparTransportador)
                    .addComponent(botaoCancelar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNomeActionPerformed

    private void textoCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCidadeActionPerformed

    private void textoEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEstadoActionPerformed

    private void textoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNumeroActionPerformed

    private void textoPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoPaisActionPerformed

    private void textoRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoRuaActionPerformed

    private void botaoCadastrarTransportadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarTransportadorActionPerformed
      
        String Telefone = textoTelefone.getText().replaceAll("[()-]", "");
        String CNPJ = textoCNPJ.getText().trim().replaceAll("[./-]","");
        
        endgetset.setCidade(textoCidade.getText());
        endgetset.setEstado(textoEstado.getText());
        endgetset.setNumero(Integer.parseInt(textoNumero.getText()));
        endgetset.setPais(textoPais.getText());
        endgetset.setRua(textoRua.getText());
        enddao.Insert(endgetset);
        
        transgetset.setNome(textoNome.getText());
        transgetset.setCnpj(textoCNPJ.getText());
        transgetset.setTelefone(textoTelefone.getText());
        transgetset.setIdEndereco(endgetset.getIdEndereco());
        transdao.Insert(transgetset);
        
        LimparCampos();
        
    }//GEN-LAST:event_botaoCadastrarTransportadorActionPerformed

    private void botaoLimparTransportadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparTransportadorActionPerformed
       
       LimparCampos();
  
    }//GEN-LAST:event_botaoLimparTransportadorActionPerformed

    private void textoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNomeKeyTyped
        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) { 
            evt.consume();
        }
        int limit = 50;

        if (textoNome.getText().length() == limit) {

            evt.consume();
        }

    }//GEN-LAST:event_textoNomeKeyTyped

    private void textoRuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoRuaKeyTyped
        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        int limit = 50;

        if (textoRua.getText().length() == limit) {

            evt.consume();
        }
    }//GEN-LAST:event_textoRuaKeyTyped

    private void textoCidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoCidadeKeyTyped
         String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        int limit = 50;

        if (textoCidade.getText().length() == limit) {

            evt.consume();
        }
    }//GEN-LAST:event_textoCidadeKeyTyped

    private void textoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        int limit = 50;

        if (textoNumero.getText().length() == limit) {

            evt.consume();
        }
    }//GEN-LAST:event_textoNumeroKeyTyped

    private void textoPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPaisKeyTyped
         String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        int limit = 50;

        if (textoPais.getText().length() == limit) {

            evt.consume();
        }
    }//GEN-LAST:event_textoPaisKeyTyped

    private void textoEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoEstadoKeyTyped
        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        int limit = 2;

        if (textoEstado.getText().length() == limit) {

            evt.consume();
        }
    }//GEN-LAST:event_textoEstadoKeyTyped

    private void textoCNPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCNPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCNPJActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
          LimparCampos();        
    }//GEN-LAST:event_formInternalFrameClosed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
        LimparCampos();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    
    public void LimparCampos(){
        
        textoCNPJ.setText("");
        textoCidade.setText("");
        textoEstado.setText("");
        textoNome.setText("");
        textoNumero.setText("");
        textoPais.setText("");
        textoRua.setText("");
        textoTelefone.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarTransportador;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoLimparTransportador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField textoCNPJ;
    private javax.swing.JTextField textoCidade;
    private javax.swing.JTextField textoEstado;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoNumero;
    private javax.swing.JTextField textoPais;
    private javax.swing.JTextField textoRua;
    private javax.swing.JFormattedTextField textoTelefone;
    // End of variables declaration//GEN-END:variables
}
