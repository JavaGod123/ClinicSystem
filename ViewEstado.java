/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.EspecializacaoDAO;
import DAO.EstadoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Especializacao;
import modelo.Estado;

/**
 *
 * @author Nicolas
 */
public class ViewEstado extends javax.swing.JFrame {

    /**
     * Creates new form ViewEspecializacao
     */
    public ViewEstado() {
        initComponents();
    }

   public void buscarTableId(int id){
        DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
        modelo.setNumRows(0);
        EstadoDAO esdao = new EstadoDAO();
        Estado es = new Estado();
        try{
        es = esdao.getById(id);
        modelo.addRow(new Object[]{
            es.getEstadoId(),
            es.getNome(),
            es.getUf()
        });

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Falha ao preencher a tabela " + ex);
            limparTable();
        }
    }
     public void buscarTable(){
         
         DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
         modelo.setNumRows(0);
         EstadoDAO esdao = new EstadoDAO();

         try {
             for(Estado es : esdao.getAll()){
                 modelo.addRow(new Object[]{
                 es.getEstadoId(),
                 es.getNome(),
                 es.getUf(),
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
         txtEstado.setText(null);
         txtUF.setText(null);
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
        txtUF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCadastrar = new javax.swing.JButton();
        jButtonConsultarId = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDados = new javax.swing.JTable();
        txtEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItemPaciente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItemMedico = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
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
        jLabel2.setText("Registro de Estados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
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

        txtUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUFActionPerformed(evt);
            }
        });
        getContentPane().add(txtUF);
        txtUF.setBounds(370, 160, 40, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("UF");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(370, 140, 14, 15);

        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jCadastrar);
        jCadastrar.setBounds(430, 160, 81, 30);

        jButtonConsultarId.setText("Consultar por ID");
        jButtonConsultarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarIdActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultarId);
        jButtonConsultarId.setBounds(120, 160, 111, 30);
        getContentPane().add(txtId);
        txtId.setBounds(30, 160, 70, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 140, 11, 15);

        jDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome do Estado", "UF"
            }
        ));
        jScrollPane1.setViewportView(jDados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 230, 452, 90);

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(txtEstado);
        txtEstado.setBounds(250, 160, 100, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Estado");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 140, 39, 15);

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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Estado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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

    private void jMenuItemFecharProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharProgramaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemFecharProgramaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed

        buscarTable();

    }//GEN-LAST:event_jConsultarActionPerformed

    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        Estado es = new Estado();
        EstadoDAO esdao = new EstadoDAO();

        es.setEstadoId(Integer.parseInt(txtId.getText()));
        es.setNome(txtEstado.getText());
        es.setUf(txtUF.getText());

        esdao.update(es);
        buscarTableId((int)es.getEstadoId());
    }//GEN-LAST:event_jAlterarActionPerformed

    private void txtUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUFActionPerformed

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed
        Estado es = new Estado();
        EstadoDAO esdao = new EstadoDAO();
        List<Estado> estados = new ArrayList<>();

        es.setNome(txtEstado.getText());
        es.setUf(txtUF.getText());
        estados.add(es);

        esdao.insert(es);
        buscarTable();

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jButtonConsultarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarIdActionPerformed
        Estado es = new Estado();
        EstadoDAO esdao = new EstadoDAO();
        

        es = esdao.getById(Integer.parseInt(txtId.getText()));

        txtUF.setText(es.getUf());
        txtEstado.setText(es.getNome());
        buscarTableId((int)es.getEstadoId());
    }//GEN-LAST:event_jButtonConsultarIdActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        Estado es = new Estado();
        EstadoDAO esdao = new EstadoDAO();
       
        es = esdao.getById(Integer.parseInt(txtId.getText()));
        
        esdao.remove((int) es.getEstadoId());
    }//GEN-LAST:event_jExcluirActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ViewEstado().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEstado().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemFecharPrograma;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JMenuItem jMenuItemMedico;
    private javax.swing.JMenuItem jMenuItemPaciente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
