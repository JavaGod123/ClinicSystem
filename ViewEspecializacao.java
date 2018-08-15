/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.EspecializacaoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Especializacao;

/**
 *
 * @author Nicolas
 */
public class ViewEspecializacao extends javax.swing.JFrame {

    /**
     * Creates new form ViewEspecializacao
     */
    public ViewEspecializacao() {
        initComponents();
    }

   public void buscarTableId(int id){
        DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
        modelo.setNumRows(0);
        EspecializacaoDAO dao = new EspecializacaoDAO();
        Especializacao e = new Especializacao();
        try{
        e = dao.getById(id);
        modelo.addRow(new Object[]{
            e.getEspecializacaoId(),
            e.getDesc(),
        });

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Meu deus" + ex);
            limparTable();
        }
    }
     public void buscarTable(){
         
         DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
         modelo.setNumRows(0);
         EspecializacaoDAO dao = new EspecializacaoDAO();

         try {
             for(Especializacao e : dao.getAll()){
                 modelo.addRow(new Object[]{
                 e.getEspecializacaoId(),
                 e.getDesc(),
                 }
                 );
                           
             }
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Falha ao preencher a tabela " + ex);
             limparTable();
         }
     }
     public void limparTable(){
         txtId.setText(null);
         txtEspecializacao.setText(null);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jConsultar = new javax.swing.JButton();
        jAlterar = new javax.swing.JButton();
        jExcluir = new javax.swing.JButton();
        txtEspecializacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCadastrar = new javax.swing.JButton();
        jButtonConsultarId = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemPaciente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItemMedico = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemHome = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemFecharPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Especialização");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/if_circle-back-arrow-glyph_763477.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Especialização");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 60);

        jConsultar.setText("Consultar");
        jConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jConsultar);
        jConsultar.setBounds(40, 103, 90, 30);

        jAlterar.setText("Alterar");
        jAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jAlterar);
        jAlterar.setBounds(180, 103, 80, 30);

        jExcluir.setText("Excluir");
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jExcluir);
        jExcluir.setBounds(320, 103, 80, 30);

        txtEspecializacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecializacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEspecializacao);
        txtEspecializacao.setBounds(250, 190, 160, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Especialização");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 170, 85, 15);

        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jCadastrar);
        jCadastrar.setBounds(420, 190, 81, 30);

        jButtonConsultarId.setText("Consultar por ID");
        jButtonConsultarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarIdActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultarId);
        jButtonConsultarId.setBounds(120, 190, 111, 30);
        getContentPane().add(txtId);
        txtId.setBounds(40, 190, 70, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 170, 11, 15);

        jDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Especialização"
            }
        ));
        jScrollPane1.setViewportView(jDados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 230, 452, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/82948-qual-o-tipo-de-piso-ideal-pra-hospitais-750x410.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-6, -6, 610, 420);

        jMenu1.setText("Cadastro");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Usuário");
        jMenu1.add(jMenuItem4);

        jMenuItemPaciente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPaciente.setText("Paciente");
        jMenuItemPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPaciente);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Enfermeira(o)");
        jMenu1.add(jMenuItem3);

        jMenuItemMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemMedico.setText("Médico");
        jMenuItemMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMedicoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemMedico);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatorio");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ferramentas");

        jMenuItemHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHome.setText("Home");
        jMenuItemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHomeActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemHome);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Sair");

        jMenuItemFecharPrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFecharPrograma.setText("Fechar Programa");
        jMenuItemFecharPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharProgramaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemFecharPrograma);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(618, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPacienteActionPerformed
        //        new ViewPaciente().setVisible(true);
        //        this.dispose();
    }//GEN-LAST:event_jMenuItemPacienteActionPerformed

    private void jMenuItemMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMedicoActionPerformed
        new ViewMedico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemMedicoActionPerformed

    private void jMenuItemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHomeActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemHomeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed

        buscarTable();

    }//GEN-LAST:event_jConsultarActionPerformed

    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        Especializacao e = new Especializacao();
        EspecializacaoDAO edao = new EspecializacaoDAO();
        List<Especializacao> especs = new ArrayList<>();

        e.setEspecializacaoId(Integer.parseInt(txtId.getText()));
        e.setDesc(txtEspecializacao.getText());

        edao.update(e);
        buscarTableId((int)e.getEspecializacaoId());
    }//GEN-LAST:event_jAlterarActionPerformed

    private void txtEspecializacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecializacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecializacaoActionPerformed

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed
        Especializacao e = new Especializacao();
        EspecializacaoDAO edao = new EspecializacaoDAO();
        List<Especializacao> especs = new ArrayList<>();

        e.setDesc(txtEspecializacao.getText());
        especs.add(e);

        edao.insert(e);
        buscarTable();

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jButtonConsultarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarIdActionPerformed
        Especializacao e = new Especializacao();
        EspecializacaoDAO edao = new EspecializacaoDAO();
        List<Especializacao> especs = new ArrayList<>();

        e = edao.getById(Integer.parseInt(txtId.getText()));

        txtEspecializacao.setText(e.getDesc());
        buscarTableId((int)e.getEspecializacaoId());
    }//GEN-LAST:event_jButtonConsultarIdActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        Especializacao e = new Especializacao();
        EspecializacaoDAO edao = new EspecializacaoDAO();
        
        e = edao.getById(Integer.parseInt(txtId.getText()));
        
        edao.remove((int) e.getEspecializacaoId());
    }//GEN-LAST:event_jExcluirActionPerformed

    private void jMenuItemFecharProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharProgramaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharProgramaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewEspecializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEspecializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEspecializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEspecializacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEspecializacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonConsultarId;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JButton jConsultar;
    private javax.swing.JTable jDados;
    private javax.swing.JButton jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemFecharPrograma;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JMenuItem jMenuItemMedico;
    private javax.swing.JMenuItem jMenuItemPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEspecializacao;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
