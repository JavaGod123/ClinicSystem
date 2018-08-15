/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.CidadeDAO;
import DAO.EspecializacaoDAO;
import DAO.EstadoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cidade;
import modelo.Especializacao;
import modelo.Estado;

/**
 *
 * @author Nicolas
 */
public class ViewCidade extends javax.swing.JFrame {

    /**
     * Creates new form ViewEspecializacao
     */
    public ViewCidade() {
        initComponents();
        EstadoDAO esdao = new EstadoDAO();
        for(Estado es: esdao.getAll()){
            estadoCombo.addItem(es);
        }
    }

   public void buscarTableId(int id){
        DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
        modelo.setNumRows(0);
        CidadeDAO cidao = new CidadeDAO();
        Cidade c = new Cidade();
        try{
        c = cidao.getById(id);
        modelo.addRow(new Object[]{
            c.getCidadeId(),
            c.getNome(),
            c.getCep(),
            c.getEstado().getNome(),
        });

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Falha ao Preencher a tabela " + ex);
            limparTable();
        }
    }
     public void buscarTable(){
         
         DefaultTableModel modelo = (DefaultTableModel) jDados.getModel();
         modelo.setNumRows(0);
         CidadeDAO cidao = new CidadeDAO();

         try {
             for(Cidade c : cidao.getAll()){
                 modelo.addRow(new Object[]{
                 c.getCidadeId(),
                 c.getNome(),
                 c.getCep(),
                 c.getEstado().getNome(),
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
         txtCEP.setText(null);
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
        txtCEP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCadastrar = new javax.swing.JButton();
        jButtonConsultarId = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDados = new javax.swing.JTable();
        jCadastrar1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jCadastrar2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        estadoCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemMedico = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuCidade = new javax.swing.JMenuItem();
        jMenuEstado = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuFerramentas = new javax.swing.JMenu();
        jMenuItemHome = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemDeslogar = new javax.swing.JMenuItem();
        jMenuItemFecharPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidade");
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
        jLabel2.setText("Registro de Cidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
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

        txtCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPActionPerformed(evt);
            }
        });
        getContentPane().add(txtCEP);
        txtCEP.setBounds(30, 220, 160, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("CEP");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 200, 23, 15);

        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jCadastrar);
        jCadastrar.setBounds(420, 170, 81, 30);

        jButtonConsultarId.setText("Consultar por ID");
        jButtonConsultarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarIdActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultarId);
        jButtonConsultarId.setBounds(110, 170, 111, 30);
        getContentPane().add(txtId);
        txtId.setBounds(30, 170, 70, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("ID");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 150, 11, 15);

        jDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Cidade", "CEP", "UF"
            }
        ));
        jScrollPane1.setViewportView(jDados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 260, 452, 90);

        jCadastrar1.setText("Cadastrar");
        jCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCadastrar1);
        jCadastrar1.setBounds(420, 170, 81, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("UF");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 200, 14, 15);

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtCidade);
        txtCidade.setBounds(250, 170, 160, 30);

        jCadastrar2.setText("Cadastrar");
        jCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrar2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCadastrar2);
        jCadastrar2.setBounds(420, 170, 81, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Nome da Cidade");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 150, 92, 15);

        getContentPane().add(estadoCombo);
        estadoCombo.setBounds(250, 220, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/82948-qual-o-tipo-de-piso-ideal-pra-hospitais-750x410.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-6, -6, 610, 420);

        jMenuCadastro.setText("Cadastros");

        jMenuItemMedico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemMedico.setText("Médico");
        jMenuItemMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMedicoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemMedico);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Usuário");
        jMenuCadastro.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Especialização");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem1);

        jMenuCidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuCidade.setText("Cidade");
        jMenuCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCidadeActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCidade);

        jMenuEstado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuEstado.setText("Estado");
        jMenuEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEstadoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuEstado);

        jMenuBar1.add(jMenuCadastro);

        jMenuRelatorios.setText("Relatórios");
        jMenuBar1.add(jMenuRelatorios);

        jMenuFerramentas.setText("Ferramentas");

        jMenuItemHome.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemHome.setText("Home");
        jMenuItemHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHomeActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemHome);

        jMenuBar1.add(jMenuFerramentas);

        jMenu1.setText("Sair");

        jMenuItemDeslogar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDeslogar.setText("Deslogar");
        jMenuItemDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeslogarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDeslogar);

        jMenuItemFecharPrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFecharPrograma.setText("Fechar Programa");
        jMenuItemFecharPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharProgramaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFecharPrograma);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(618, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed

        buscarTable();

    }//GEN-LAST:event_jConsultarActionPerformed

    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        Cidade c = new Cidade();
        Estado es = new Estado();
        CidadeDAO cidao = new CidadeDAO();
        

        c.setCidadeId(Integer.parseInt(txtId.getText()));
        c.setNome(txtCidade.getText());
        c.setCep(txtCEP.getText());
        es = (Estado) estadoCombo.getSelectedItem();
        c.setEstado(es);
       cidao.update(c);
        buscarTableId((int)c.getCidadeId());
    }//GEN-LAST:event_jAlterarActionPerformed

    private void txtCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEPActionPerformed

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed
        Cidade c = new Cidade();
        CidadeDAO cidao = new CidadeDAO();
        Estado es = new Estado();
        List<Cidade> cidades = new ArrayList<>();

        c.setNome(txtCidade.getText());
        c.setCep(txtCEP.getText());
        es = (Estado) estadoCombo.getSelectedItem();
        c.setEstado(es);
        cidades.add(c);

        cidao.insert(c);
        buscarTable();

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jButtonConsultarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarIdActionPerformed
        Cidade c = new Cidade();
        CidadeDAO cidao = new CidadeDAO();

        c = cidao.getById(Integer.parseInt(txtId.getText()));

        txtCidade.setText(c.getNome());
        txtCEP.setText(c.getCep());
        buscarTableId((int)c.getCidadeId());
    }//GEN-LAST:event_jButtonConsultarIdActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        Cidade c = new Cidade();
        CidadeDAO cidao = new CidadeDAO();
        
        c = cidao.getById(Integer.parseInt(txtId.getText()));
        
        cidao.remove((int) c.getCidadeId());
    }//GEN-LAST:event_jExcluirActionPerformed

    private void jCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCadastrar1ActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void jCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCadastrar2ActionPerformed

    private void jMenuItemMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMedicoActionPerformed
        new ViewMedico().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemMedicoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ViewEspecializacao().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCidadeActionPerformed
        new ViewCidade().setVisible(true);
    }//GEN-LAST:event_jMenuCidadeActionPerformed

    private void jMenuEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEstadoActionPerformed
        new ViewEstado().setVisible(true);
    }//GEN-LAST:event_jMenuEstadoActionPerformed

    private void jMenuItemHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHomeActionPerformed
        new ViewPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItemHomeActionPerformed

    private void jMenuItemDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeslogarActionPerformed

    }//GEN-LAST:event_jMenuItemDeslogarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> estadoCombo;
    private javax.swing.JButton jAlterar;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonConsultarId;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JButton jCadastrar1;
    private javax.swing.JButton jCadastrar2;
    private javax.swing.JButton jConsultar;
    private javax.swing.JTable jDados;
    private javax.swing.JButton jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenuItem jMenuCidade;
    private javax.swing.JMenuItem jMenuEstado;
    private javax.swing.JMenu jMenuFerramentas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemDeslogar;
    private javax.swing.JMenuItem jMenuItemFecharPrograma;
    private javax.swing.JMenuItem jMenuItemHome;
    private javax.swing.JMenuItem jMenuItemMedico;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
