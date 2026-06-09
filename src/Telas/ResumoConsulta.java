/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import ConexaoDAO.Conexao;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinni
 */
public final class ResumoConsulta extends javax.swing.JFrame {

    /**
     * Creates new form ResumoConsulta
     */
    public ResumoConsulta() {
  initComponents();
        aplicarPermissoes(); // 👈 ESSENCIAL (faltava isso)
    }

    public void aplicarPermissoes() {

        String perfil = Model.Sessao.perfil;

        if (perfil == null) {
            JOptionPane.showMessageDialog(this, "Erro: usuário não logado!");
            System.exit(0);
        }

        switch (perfil) {
            
              case "ADMIN" -> {
                // tudo liberado
            }
         case "VET", "VETERINARIO" -> {
   
            }
            
            case "ATENDENTE" -> {
                btnEmitirReceita.setEnabled(false);  
                btnCancelarConsulta.setEnabled(false);
            }

            default -> {
                JOptionPane.showMessageDialog(this, "Perfil inválido!");
                System.exit(0);
            }
        } 
    }
    
    private void pesquisarConsulta() {

    try {

        if (txtPesquisaConsultaId.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Informe o ID da consulta."
            );

            return;
        }

        try (Connection conn = ConexaoDAO.Conexao.conectar()) {
            String sql =
                    
                    "SELECT c.id_consulta, c.data_consulta, c.descricao,c.status, " +
                    "p.id_pet, p.nome_pet, p.peso, p.raca, p.idade, p.cpf_tutor, " +
                    "t.nome_tutor, " +
                    "pr.id_profissional, pr.especialidade " +
                    "FROM consulta c " +
                    "INNER JOIN pet p ON c.id_pet = p.id_pet " +
                    "INNER JOIN tutor t ON p.cpf_tutor = t.cpf " +
                    "INNER JOIN profissional pr ON c.id_profissional = pr.id_profissional " +
                    "WHERE c.id_consulta = ?";
            
            PreparedStatement stmt =
                    conn.prepareStatement(sql);
            
            stmt.setInt(
                    1,
                    Integer.parseInt(
                            txtPesquisaConsultaId.getText()
                    )
            );
            
            ResultSet rs =
                    stmt.executeQuery();
            
            if (rs.next()) {
                
                carregarTabelas(rs);
                
            } else {
                
                JOptionPane.showMessageDialog(
                        this,
                        "Consulta não encontrada."
                );
            }
            
            rs.close();
            stmt.close();
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Erro: " + e.getMessage()
        );
    }
}
    
 private void carregarTabelas(ResultSet rs) throws SQLException {

    DefaultTableModel modeloDados =
            (DefaultTableModel) TableDados.getModel();

    modeloDados.setRowCount(0);

          modeloDados.addRow(new Object[]{
          rs.getString("nome_tutor"),
          rs.getString("nome_pet"),
          rs.getInt("id_pet"),
          rs.getInt("id_consulta"),
          rs.getInt("id_profissional"),
          rs.getString("especialidade"),
          rs.getString("data_consulta"),
          rs.getString("cpf_tutor"),
          rs.getString("status")
});



    DefaultTableModel modeloPet =
            (DefaultTableModel) TablePet.getModel();

    modeloPet.setRowCount(0);

    modeloPet.addRow(new Object[]{
        rs.getDouble("peso"),
        rs.getString("raca"),
        rs.getInt("idade"),
        rs.getInt("id_pet")
    });



    DefaultTableModel modeloDescricao =
            (DefaultTableModel) TableDescricao.getModel();

    modeloDescricao.setRowCount(0);

    modeloDescricao.addRow(new Object[]{
        rs.getString("descricao")
    });
}   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDados = new javax.swing.JTable();
        btnEmitirReceita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePet = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaConsultaId = new javax.swing.JTextField();
        btnCancelarConsulta = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableDescricao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        TableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome Tutor", "Nome Pet", " ID Pet", "ID Consulta", "ID Profissional", "Função", "Data", "CPF tutor", "Status"
            }
        ));
        jScrollPane1.setViewportView(TableDados);

        btnEmitirReceita.setText("Emitir receita ");
        btnEmitirReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirReceitaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Resumo da Consulta");

        TablePet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Peso", "Raça", "Idade", "IdPet"
            }
        ));
        jScrollPane2.setViewportView(TablePet);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisar ID Consulta:");

        txtPesquisaConsultaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaConsultaIdActionPerformed(evt);
            }
        });

        btnCancelarConsulta.setText("Cancelar Consulta");
        btnCancelarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultaActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        TableDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Descrição"
            }
        ));
        jScrollPane3.setViewportView(TableDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPesquisaConsultaId, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(398, 398, 398)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnEmitirReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)
                            .addComponent(btnCancelarConsulta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaConsultaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmitirReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmitirReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirReceitaActionPerformed
        
       int linha = TableDados.getSelectedRow();

if (linha == -1) {
    JOptionPane.showMessageDialog(this,
            "Selecione uma consulta na tabela.");
    return;
}

int idConsulta = Integer.parseInt(
        TableDados.getValueAt(linha, 3).toString()
);

Receita tela = new Receita(idConsulta);
tela.setVisible(true);
dispose();
        
    }//GEN-LAST:event_btnEmitirReceitaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCancelarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarConsultaActionPerformed

    private void txtPesquisaConsultaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaConsultaIdActionPerformed
     
           if (!txtPesquisaConsultaId.getText().trim().isEmpty()) {
           pesquisarConsulta();
    }
        
    }//GEN-LAST:event_txtPesquisaConsultaIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResumoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumoConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDados;
    private javax.swing.JTable TableDescricao;
    private javax.swing.JTable TablePet;
    private javax.swing.JButton btnCancelarConsulta;
    private javax.swing.JButton btnEmitirReceita;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtPesquisaConsultaId;
    // End of variables declaration//GEN-END:variables
}
