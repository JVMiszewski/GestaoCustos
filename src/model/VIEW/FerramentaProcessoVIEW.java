package model.VIEW;

import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import model.BEAN.*;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.*;
import model.USER.Login;

public class FerramentaProcessoVIEW extends javax.swing.JFrame {

    private int id;
    private String pesquisa;

    public FerramentaProcessoVIEW(int ferId) {

        initComponents();
        setTitle("Ferramentas do processo: " + String.valueOf(ferId));

        this.id = ferId;
        
        ConfiguracoesDAO cDAO = new ConfiguracoesDAO();

        for (Configuracoes c : cDAO.read()) {

            c.getId();
            c.getPesquisa();

            if (c.getPesquisa().equals("id")) {
                pesquisa = "id";
            } else {
                pesquisa = "nome";
            }  

        }
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(FerramentaProcessoVIEW.class.getResource("/imagens/real.png")));

        readJTable();
        readJTable(id);

    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentas.getModel();

        modelo.setNumRows(0);

        FerramentaDAO fDAO = new FerramentaDAO();

        for (Ferramenta f : fDAO.read()) {

            modelo.addRow(new Object[]{
                f.getIdFerramenta(),
                f.getNome(),
                f.getDescricao(),});

        }
    }

    public void readJTable(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentasProcesso.getModel();

        modelo.setNumRows(0);

        FerramentaProcessoDAO fDAO = new FerramentaProcessoDAO();

        for (FerramentaProcesso f : fDAO.readP(id)) {

            modelo.addRow(new Object[]{
                f.getIdFerramentaProcesso(),
                f.getFerramenta().getNome(),
                f.getFerramenta().getDescricao(),
                f.getProcesso().getNomeP(),});

        }
    }

    public void readJTableWhere(int id, String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentasProcesso.getModel();

        modelo.setNumRows(0);

        FerramentaProcessoDAO fDAO = new FerramentaProcessoDAO();

        for (FerramentaProcesso f : fDAO.readWhere(id, nome)) {

            modelo.addRow(new Object[]{
                f.getIdFerramentaProcesso(),
                f.getFerramenta().getNome(),
                f.getFerramenta().getDescricao(),
                f.getProcesso().getNomeP(),});

        }
    }
    
    public void readJTableWhere(int id, int cod) {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentasProcesso.getModel();

        modelo.setNumRows(0);

        FerramentaProcessoDAO fDAO = new FerramentaProcessoDAO();

        for (FerramentaProcesso f : fDAO.readWhere(id, cod)) {

            modelo.addRow(new Object[]{
                f.getIdFerramentaProcesso(),
                f.getFerramenta().getNome(),
                f.getFerramenta().getDescricao(),
                f.getProcesso().getNomeP(),});

        }
    }

    public void readJTableWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentas.getModel();

        modelo.setNumRows(0);

        FerramentaDAO fDAO = new FerramentaDAO();

        for (Ferramenta f : fDAO.readWhere(nome)) {

            modelo.addRow(new Object[]{
                f.getIdFerramenta(),
                f.getNome(),
                f.getDescricao(),});

        }
    }
    
    public void readJTableWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTFerramentas.getModel();

        modelo.setNumRows(0);

        FerramentaDAO fDAO = new FerramentaDAO();

        for (Ferramenta f : fDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                f.getIdFerramenta(),
                f.getNome(),
                f.getDescricao(),});

        }
    }

    private FerramentaProcessoVIEW() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLPesquisarF = new javax.swing.JLabel();
        jTPesquisarF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFerramentas = new javax.swing.JTable();
        jBSelecionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTFerramentasProcesso = new javax.swing.JTable();
        jBExcluir = new javax.swing.JButton();
        jLPesquisarFs = new javax.swing.JLabel();
        jTPesquisarFs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setText("Ferramentas");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 11, -1, 36));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Ferramentas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPesquisarF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarF.setText("Pesquisar:");
        jPanel1.add(jLPesquisarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 74, 34));

        jTPesquisarF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarFKeyReleased(evt);
            }
        });
        jPanel1.add(jTPesquisarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 128, 34));

        jTFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ferramenta", "Descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTFerramentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 810, 130));

        jBSelecionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSelecionar.setText("Selecionar");
        jBSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(jBSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, 833, 270));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Ferramentas Selecionadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFerramentasProcesso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ferramenta", "Descricao", "Processo"
            }
        ));
        jScrollPane2.setViewportView(jTFerramentasProcesso);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 810, 180));

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, -1, -1));

        jLPesquisarFs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarFs.setText("Pesquisar:");
        jPanel2.add(jLPesquisarFs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTPesquisarFs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarFsKeyReleased(evt);
            }
        });
        jPanel2.add(jTPesquisarFs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 832, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        if (jTFerramentasProcesso.getSelectedRow() != -1) {

            FerramentaProcesso fp = new FerramentaProcesso();
            FerramentaProcessoDAO fpdao = new FerramentaProcessoDAO();

            fp.setIdFerramentaProcesso((int) jTFerramentasProcesso.getValueAt(jTFerramentasProcesso.getSelectedRow(), 0));

            fpdao.delete(fp);

            readJTable(this.id);
            
            jTPesquisarFs.setText("");

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTPesquisarFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarFKeyReleased
        
        if (pesquisa.equals("id")) {

            if (jTPesquisarF.getText().isEmpty() == false) {

                readJTableWhere(Integer.parseInt(jTPesquisarF.getText()));

            } else if (jTPesquisarF.getText().isEmpty() == true) {

                readJTable();

            }

        } else {

            readJTableWhere((String) jTPesquisarF.getText());

        }
        
    }//GEN-LAST:event_jTPesquisarFKeyReleased

    private void jBSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarActionPerformed

        if (jTFerramentas.getSelectedRow() != -1) {

            Ferramenta f = new Ferramenta();
            FerramentaDAO fdao = new FerramentaDAO();
            FerramentaProcesso fp = new FerramentaProcesso();
            FerramentaProcessoDAO fpDAO = new FerramentaProcessoDAO();
            Processo p = new Processo();
            ProcessoDAO pDAO = new ProcessoDAO();

            f.setIdFerramenta((int) jTFerramentas.getValueAt(jTFerramentas.getSelectedRow(), 0));
            p.setIdProcesso(this.id);
            fp.setFerramenta(f);
            fp.setProcesso(p);

            fpDAO.create(fp);

            readJTable(this.id);

        }

    }//GEN-LAST:event_jBSelecionarActionPerformed

    private void jTPesquisarFsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarFsKeyReleased

        if (pesquisa.equals("id")) {

            if (jTPesquisarFs.getText().isEmpty() == false) {

                readJTableWhere(this.id, Integer.parseInt(jTPesquisarFs.getText()));

            } else if (jTPesquisarFs.getText().isEmpty() == true) {

                readJTable(this.id);

            }

        } else {

            readJTableWhere(this.id, (String) jTPesquisarFs.getText());

        }
        
    }//GEN-LAST:event_jTPesquisarFsKeyReleased

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
            java.util.logging.Logger.getLogger(FerramentaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FerramentaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FerramentaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FerramentaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FerramentaProcessoVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSelecionar;
    private javax.swing.JLabel jLPesquisarF;
    private javax.swing.JLabel jLPesquisarFs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTFerramentas;
    private javax.swing.JTable jTFerramentasProcesso;
    private javax.swing.JTextField jTPesquisarF;
    private javax.swing.JTextField jTPesquisarFs;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
