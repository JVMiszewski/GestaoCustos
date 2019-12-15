
package model.VIEW;

import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import model.BEAN.*;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.*;
import model.USER.Login;

public class MaterialProcessoVIEW extends javax.swing.JFrame {

    private int id;
    private String pesquisa;
    
    public MaterialProcessoVIEW(int matId) {
        
        initComponents();
        setTitle("Materiais do processo: " + String.valueOf(matId));
        
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
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(MaterialProcessoVIEW.class.getResource("/imagens/real.png")));
        
        this.id = matId;
        
        readJTable(id);
        readJTable();
                
    }
    
    public void readJTable(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterial.getModel();
        
        modelo.setNumRows(0);
        
        MaterialDAO mDAO = new MaterialDAO();
        
        for (Material m : mDAO.read()){

            modelo.addRow(new Object[]{
                
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
   
            });
            
        }
    }
    
    public void readJTable(int id){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterialSelecionado.getModel();
        
        modelo.setNumRows(0);
        
        MaterialProcessoDAO mDAO = new MaterialProcessoDAO();
        
        for (MaterialProcesso m : mDAO.readP(id)){

            modelo.addRow(new Object[]{
                
                m.getIdMaterialProcesso(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getDescricaoM(),
                m.getProcesso().getNomeP(),
   
            });
            
        }
    }
    
    public void readJTableWhere(int id, String nome){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterialSelecionado.getModel();
        
        modelo.setNumRows(0);
        
        MaterialProcessoDAO mDAO = new MaterialProcessoDAO();
        
        for (MaterialProcesso m : mDAO.readWhere(id, nome)){

            modelo.addRow(new Object[]{
                
                m.getIdMaterialProcesso(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getDescricaoM(),
                m.getProcesso().getNomeP(),
   
            });
            
        }
    }
    
        public void readJTableWhere(int id, int cod){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterialSelecionado.getModel();
        
        modelo.setNumRows(0);
        
        MaterialProcessoDAO mDAO = new MaterialProcessoDAO();
        
        for (MaterialProcesso m : mDAO.readWhere(id, cod)){

            modelo.addRow(new Object[]{
                
                m.getIdMaterialProcesso(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getDescricaoM(),
                m.getProcesso().getNomeP(),
   
            });
            
        }
    }
    
    public void readJTableWhere(String nome){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterial.getModel();
        
        modelo.setNumRows(0);
        
        MaterialDAO mDAO = new MaterialDAO();
        
        for (Material m : mDAO.readWhere(nome)){

            modelo.addRow(new Object[]{
                
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
   
            });
            
        }
    }
    
    public void readJTableWhere(int id){
        
        DefaultTableModel modelo = (DefaultTableModel) jTMaterial.getModel();
        
        modelo.setNumRows(0);
        
        MaterialDAO mDAO = new MaterialDAO();
        
        for (Material m : mDAO.readWhere(id)){

            modelo.addRow(new Object[]{
                
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
   
            });
            
        }
    }
    
    private MaterialProcessoVIEW() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLPesquisarM = new javax.swing.JLabel();
        jTPesquisarM = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTMaterial = new javax.swing.JTable();
        jBSelecionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaterialSelecionado = new javax.swing.JTable();
        jBExcluir = new javax.swing.JButton();
        jLPesquisarMs = new javax.swing.JLabel();
        jTPesquisarMs = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(843, 680));
        setPreferredSize(new java.awt.Dimension(843, 680));

        titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo.setText("Materiais");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Materiais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(823, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(823, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPesquisarM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarM.setText("Pesquisar:");
        jPanel1.add(jLPesquisarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 34));

        jTPesquisarM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMKeyReleased(evt);
            }
        });
        jPanel1.add(jTPesquisarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 128, 34));

        jTMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Material", "Descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTMaterial);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 790, 130));

        jBSelecionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSelecionar.setText("Selecionar");
        jBSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarActionPerformed(evt);
            }
        });
        jPanel1.add(jBSelecionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Materiais Selecionados\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(823, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(823, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTMaterialSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Material", "Descricao", "Processo"
            }
        ));
        jScrollPane1.setViewportView(jTMaterialSelecionado);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 800, 130));

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, -1, -1));

        jLPesquisarMs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisarMs.setText("Pesquisar:");
        jPanel2.add(jLPesquisarMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jTPesquisarMs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMsKeyReleased(evt);
            }
        });
        jPanel2.add(jTPesquisarMs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
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

        if(jTMaterial.getSelectedRow() != -1){

            Material m = new Material();
            MaterialProcesso mp = new MaterialProcesso();
            MaterialProcessoDAO mpDAO = new MaterialProcessoDAO();
            Processo p = new Processo();

            m.setIdMaterial((int) jTMaterial.getValueAt(jTMaterial.getSelectedRow(), 0));
            p.setIdProcesso(this.id);
            mp.setMaterial(m);
            mp.setProcesso(p);

            mpDAO.create(mp);

            readJTable(this.id);

        }
    }//GEN-LAST:event_jBSelecionarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        if(jTMaterialSelecionado.getSelectedRow() != -1){

            MaterialProcesso mp = new MaterialProcesso();
            MaterialProcessoDAO mpdao = new MaterialProcessoDAO();

            mp.setIdMaterialProcesso((int) jTMaterialSelecionado.getValueAt(jTMaterialSelecionado.getSelectedRow(), 0));

            mpdao.delete(mp);

            readJTable(this.id);
            
            jTPesquisarMs.setText("");

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTPesquisarMsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarMsKeyReleased
        
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
            java.util.logging.Logger.getLogger(MaterialProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterialProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterialProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterialProcessoVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaterialProcessoVIEW().setVisible(true);
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
    private javax.swing.JTable jTMaterial;
    private javax.swing.JTable jTMaterialSelecionado;
    private javax.swing.JTextField jTPesquisarM;
    private javax.swing.JTextField jTPesquisarMs;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}
