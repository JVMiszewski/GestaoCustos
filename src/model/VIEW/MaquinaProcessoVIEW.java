package model.VIEW;

import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import model.BEAN.Maquina;
import model.BEAN.MaquinaProcesso;
import model.BEAN.Processo;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.MaquinaDAO;
import model.DAO.MaquinaProcessoDAO;
import model.DAO.ProcessoDAO;

public class MaquinaProcessoVIEW extends javax.swing.JFrame {

    private int id;
    private String pesquisa;

    public MaquinaProcessoVIEW(int maqId) {

        initComponents();
        setTitle("Maquinas do processo: " + String.valueOf(maqId));
        
        ConfiguracoesDAO cDAO = new ConfiguracoesDAO();

        for (Configuracoes c : cDAO.read()) {

            c.getId();
            c.getPesquisa();
            c.getCasas();

            if (c.getPesquisa().equals("id")) {
                pesquisa = "id";
            } else {
                pesquisa = "nome";
            }
  
        }

        this.id = maqId;

        readJTable(id);
        readJTable();

        setIconImage(Toolkit.getDefaultToolkit().getImage(MaquinaProcessoVIEW.class.getResource("/imagens/real.png")));
    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

        modelo.setNumRows(0);

        MaquinaDAO mDAO = new MaquinaDAO();

        for (Maquina m : mDAO.read()) {

            modelo.addRow(new Object[]{
                m.getIdMaquina(),
                m.getNome(),
                m.getDescricao(),});

        }
    }

    public void readJTable(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinasSelecionadas.getModel();

        modelo.setNumRows(0);

        MaquinaProcessoDAO mDAO = new MaquinaProcessoDAO();

        for (MaquinaProcesso m : mDAO.readP(id)) {

            modelo.addRow(new Object[]{
                m.getIdMaquinaProcesso(),
                m.getMaquina().getNome(),
                m.getMaquina().getDescricao(),
                m.getProcesso().getNomeP(),});

        }
    }

    public void readJTableWhere(int id, String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinasSelecionadas.getModel();

        modelo.setNumRows(0);

        MaquinaProcessoDAO mDAO = new MaquinaProcessoDAO();

        for (MaquinaProcesso m : mDAO.readWhere(id, nome)) {

            modelo.addRow(new Object[]{
                m.getIdMaquinaProcesso(),
                m.getMaquina().getNome(),
                m.getMaquina().getDescricao(),
                m.getProcesso().getNomeP(),});

        }
    }
    
    public void readJTableWhere(int id, int cod) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinasSelecionadas.getModel();

        modelo.setNumRows(0);

        MaquinaProcessoDAO mDAO = new MaquinaProcessoDAO();

        for (MaquinaProcesso m : mDAO.readWhere(id, cod)) {

            modelo.addRow(new Object[]{
                m.getIdMaquinaProcesso(),
                m.getMaquina().getNome(),
                m.getMaquina().getDescricao(),
                m.getProcesso().getNomeP(),});

        }
    }

    public void readJTableWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

        modelo.setNumRows(0);

        MaquinaDAO mDAO = new MaquinaDAO();

        for (Maquina m : mDAO.readWhere(nome)) {

            modelo.addRow(new Object[]{
                m.getIdMaquina(),
                m.getNome(),
                m.getDescricao(),});

        }
    }
    
    public void readJTableWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

        modelo.setNumRows(0);

        MaquinaDAO mDAO = new MaquinaDAO();

        for (Maquina m : mDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                m.getIdMaquina(),
                m.getNome(),
                m.getDescricao(),});

        }
    }

    private MaquinaProcessoVIEW() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBSelecionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTMaquinas = new javax.swing.JTable();
        jLPesquisarM = new javax.swing.JLabel();
        jTPesquisarM = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLPesquisarMs = new javax.swing.JLabel();
        jTPesquisarMs = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaquinasSelecionadas = new javax.swing.JTable();
        jBExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setText("Máquinas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Máquinas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(823, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(823, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBSelecionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSelecionar.setText("Selecionar");
        jBSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(jBSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        jTMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Maquina", "Descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTMaquinas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 800, 120));

        jLPesquisarM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarM.setText("Pesquisar:");
        jPanel1.add(jLPesquisarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 34));

        jTPesquisarM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMKeyReleased(evt);
            }
        });
        jPanel1.add(jTPesquisarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 128, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Máquinas Selecionadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(823, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(823, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPesquisarMs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarMs.setText("Pesquisar:");
        jPanel2.add(jLPesquisarMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 30));

        jTPesquisarMs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMsKeyReleased(evt);
            }
        });
        jPanel2.add(jTPesquisarMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 130, 30));

        jTMaquinasSelecionadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Máquina", "Descricao", "Processo"
            }
        ));
        jScrollPane1.setViewportView(jTMaquinasSelecionadas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 800, 130));

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(328, 328, 328))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesquisarMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarMKeyReleased

        if (pesquisa.equals("id")) {

            if (jTPesquisarM.getText().isEmpty() == false) {

                readJTableWhere(Integer.parseInt(jTPesquisarM.getText()));

            } else if (jTPesquisarM.getText().isEmpty() == true) {

                readJTable();

            }

        } else {

            readJTableWhere((String) jTPesquisarM.getText());

        }
        
    }//GEN-LAST:event_jTPesquisarMKeyReleased

    private void jBSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarActionPerformed

        if (jTMaquinas.getSelectedRow() != -1) {

            Maquina m = new Maquina();
            MaquinaDAO mdao = new MaquinaDAO();
            MaquinaProcesso mp = new MaquinaProcesso();
            MaquinaProcessoDAO mpDAO = new MaquinaProcessoDAO();
            Processo p = new Processo();
            ProcessoDAO pDAO = new ProcessoDAO();

            m.setIdMaquina((int) jTMaquinas.getValueAt(jTMaquinas.getSelectedRow(), 0));
            p.setIdProcesso(this.id);
            mp.setMaquina(m);
            mp.setProcesso(p);

            mpDAO.create(mp);

            readJTable(this.id);

        }

    }//GEN-LAST:event_jBSelecionarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        if (jTMaquinasSelecionadas.getSelectedRow() != -1) {

            MaquinaProcesso mp = new MaquinaProcesso();
            MaquinaProcessoDAO mpdao = new MaquinaProcessoDAO();

            mp.setIdMaquinaProcesso((int) jTMaquinasSelecionadas.getValueAt(jTMaquinasSelecionadas.getSelectedRow(), 0));

            mpdao.delete(mp);

            readJTable(this.id);

            jTPesquisarMs.setText("");

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTPesquisarMsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarMsKeyReleased

        readJTableWhere(this.id, String.valueOf(jTPesquisarMs.getText()));
        
        if (pesquisa.equals("id")) {

            if (jTPesquisarMs.getText().isEmpty() == false) {

                readJTableWhere(this.id, Integer.parseInt(jTPesquisarMs.getText()));

            } else if (jTPesquisarMs.getText().isEmpty() == true) {

                readJTable(this.id);

            }

        } else {

            readJTableWhere(this.id, (String) jTPesquisarMs.getText());

        }

    }//GEN-LAST:event_jTPesquisarMsKeyReleased

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
            java.util.logging.Logger.getLogger(MaquinaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaquinaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaquinaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaquinaProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaquinaProcessoVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSelecionar;
    private javax.swing.JLabel jLPesquisarM;
    private javax.swing.JLabel jLPesquisarMs;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTMaquinas;
    private javax.swing.JTable jTMaquinasSelecionadas;
    private javax.swing.JTextField jTPesquisarM;
    private javax.swing.JTextField jTPesquisarMs;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
