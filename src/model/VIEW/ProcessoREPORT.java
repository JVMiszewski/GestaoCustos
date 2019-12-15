   package model.VIEW;

import connection.ConnectionFactory;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BEAN.Categoria;
import model.BEAN.Unidade;
import model.DAO.CategoriaDAO;
import model.DAO.UnidadeDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ProcessoREPORT extends javax.swing.JFrame {

    public ProcessoREPORT() {

        initComponents();
        setTitle("Relatórios - Processos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

        CategoriaDAO cDAO = new CategoriaDAO();

        for (Categoria c : cDAO.read()) {

            jCBCategoria.addItem(c);

        }

        UnidadeDAO uDAO = new UnidadeDAO();

        jTPreco.setEnabled(false);
        rbMaior.setEnabled(false);
        rbMenor.setEnabled(false);
        rbIgual.setEnabled(false);
        jCBCategoria.setEnabled(false);
        jTNome.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPesquisa = new javax.swing.ButtonGroup();
        bgPreco = new javax.swing.ButtonGroup();
        titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbPreco = new javax.swing.JRadioButton();
        rbCategoria = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        jbConfirmar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLPreco = new javax.swing.JLabel();
        jTPreco = new javax.swing.JTextField();
        rbMaior = new javax.swing.JRadioButton();
        rbMenor = new javax.swing.JRadioButton();
        rbIgual = new javax.swing.JRadioButton();
        jLCategoria = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<Object>();
        jTNome = new javax.swing.JTextField();
        jbEmitir = new javax.swing.JButton();
        jbEmitirCompleto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        titulo.setText("Emitir Relatório sobre Processos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        bgPesquisa.add(rbPreco);
        rbPreco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbPreco.setText("Preço");

        bgPesquisa.add(rbCategoria);
        rbCategoria.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbCategoria.setText("Categoria");

        bgPesquisa.add(rbNome);
        rbNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbNome.setText("Nome");

        jbConfirmar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbPreco)
                .addGap(40, 40, 40)
                .addComponent(rbCategoria)
                .addGap(35, 35, 35)
                .addComponent(rbNome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbConfirmar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPreco)
                    .addComponent(rbCategoria)
                    .addComponent(rbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jbConfirmar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Parâmetros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPreco.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLPreco.setText("Preço:");
        jPanel2.add(jLPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 74, 27));

        jTPreco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(jTPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 33, 107, -1));

        bgPreco.add(rbMaior);
        rbMaior.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbMaior.setText("Maior");
        jPanel2.add(rbMaior, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 32, -1, -1));

        bgPreco.add(rbMenor);
        rbMenor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbMenor.setText("Menor");
        jPanel2.add(rbMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 32, -1, -1));

        bgPreco.add(rbIgual);
        rbIgual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rbIgual.setText("Igual");
        jPanel2.add(rbIgual, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 32, -1, -1));

        jLCategoria.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLCategoria.setText("Categoria:");
        jPanel2.add(jLCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, -1, 27));

        jLNome.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLNome.setText("Nome:");
        jPanel2.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 74, 27));

        jCBCategoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(jCBCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 78, 190, -1));

        jTNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 190, -1));

        jbEmitir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbEmitir.setText("Emitir");
        jbEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmitirActionPerformed(evt);
            }
        });
        jPanel2.add(jbEmitir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, -1, -1));

        jbEmitirCompleto.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jbEmitirCompleto.setText("Emitir Relatório Completo");
        jbEmitirCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmitirCompletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titulo)
                        .addGap(72, 72, 72))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEmitirCompleto)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(titulo)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbEmitirCompleto)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEmitirCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmitirCompletoActionPerformed

        Connection con = ConnectionFactory.getConnection();

        String src = "/relatorios/processoC.jasper";

        InputStream reportFile = null;
        reportFile = getClass().getResourceAsStream(src);

        JasperPrint jp = null;

        try {

            jp = JasperFillManager.fillReport(reportFile, null, con);

        } catch (JRException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Relatorio - Processo");
        jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

        jv.setVisible(true);

    }//GEN-LAST:event_jbEmitirCompletoActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed

        if (rbCategoria.isSelected() == true) {
            jCBCategoria.setEnabled(true);
        } else {
            jCBCategoria.setEnabled(false);
        }

        if (rbPreco.isSelected() == true) {
            jTPreco.setEnabled(true);
            rbMaior.setEnabled(true);
            rbMenor.setEnabled(true);
            rbIgual.setEnabled(true);
        } else {
            jTPreco.setEnabled(false);
            rbMaior.setEnabled(false);
            rbMenor.setEnabled(false);
            rbIgual.setEnabled(false);
        }

        if (rbNome.isSelected() == true) {
            jTNome.setEnabled(true);
        } else {
            jTNome.setEnabled(false);
        }
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEmitirActionPerformed

        if (jCBCategoria.isEnabled() == true) {

            Categoria categoria = (Categoria) jCBCategoria.getSelectedItem();

            Connection con = ConnectionFactory.getConnection();

            String src = "/relatorios/processoCategoria.jasper";

            InputStream reportFile = null;
            reportFile = getClass().getResourceAsStream(src);

            JasperPrint jp = null;

            try {

                HashMap parametros = new HashMap<>();
                parametros.put("categoria", categoria.getNome());

                jp = JasperFillManager.fillReport(reportFile, parametros, con);

            } catch (JRException ex) {

                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

            }

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Relatorio - Processos");
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

            jv.setVisible(true);

        }  else if (jTNome.isEnabled() == true) {

            Connection con = ConnectionFactory.getConnection();

            String src = "/relatorios/processoNome.jasper";

            InputStream reportFile = null;
            reportFile = getClass().getResourceAsStream(src);

            JasperPrint jp = null;

            try {

                HashMap parametros = new HashMap<>();
                parametros.put("nome", jTNome.getText());

                jp = JasperFillManager.fillReport(reportFile, parametros, con);

            } catch (JRException ex) {

                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

            }

            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Relatorio - Processos");
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

            jv.setVisible(true);

        } else if (jTPreco.isEnabled() == true) {

            if (rbMaior.isSelected() == true) {

                Connection con = ConnectionFactory.getConnection();

                String src = "/relatorios/processoPrecoMaior.jasper";

                InputStream reportFile = null;
                reportFile = getClass().getResourceAsStream(src);

                JasperPrint jp = null;

                try {

                    HashMap parametros = new HashMap<>();
                    parametros.put("preco", Double.parseDouble(jTPreco.getText()));

                    jp = JasperFillManager.fillReport(reportFile, parametros, con);

                } catch (JRException ex) {

                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

                }

                JasperViewer jv = new JasperViewer(jp, false);
                jv.setTitle("Relatorio - Processos");
                jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

                jv.setVisible(true);

            } else if (rbMenor.isSelected() == true) {

                Connection con = ConnectionFactory.getConnection();

                String src = "/relatorios/processoPrecoMenor.jasper";
                
                InputStream reportFile = null;
                reportFile = getClass().getResourceAsStream(src);

                JasperPrint jp = null;

                try {

                    HashMap parametros = new HashMap<>();
                    parametros.put("preco", Double.parseDouble(jTPreco.getText()));

                    jp = JasperFillManager.fillReport(reportFile, parametros, con);

                } catch (JRException | NullPointerException ex) {

                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

                }

                JasperViewer jv = new JasperViewer(jp, false);
                jv.setTitle("Relatorio - Processos");
                jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

                jv.setVisible(true);

            } else if (rbIgual.isSelected() == true) {

                Connection con = ConnectionFactory.getConnection();

                String src = "/relatorios/processoPrecoIgual.jasper";
                
                InputStream reportFile = null;
                reportFile = getClass().getResourceAsStream(src);

                JasperPrint jp = null;

                try {

                    HashMap parametros = new HashMap<>();
                    parametros.put("preco", Double.parseDouble(jTPreco.getText()));

                    jp = JasperFillManager.fillReport(reportFile, parametros, con);

                } catch (JRException ex) {

                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

                }

                JasperViewer jv = new JasperViewer(jp, false);
                jv.setTitle("Relatorio - Processos");
                jv.setIconImage(Toolkit.getDefaultToolkit().getImage(ProcessoREPORT.class.getResource("/imagens/real.png")));

                jv.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Escolha alguma opção");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha alguma opção");
        }

    }//GEN-LAST:event_jbEmitirActionPerformed

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
            java.util.logging.Logger.getLogger(ProcessoREPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessoREPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessoREPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessoREPORT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessoREPORT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPesquisa;
    private javax.swing.ButtonGroup bgPreco;
    private javax.swing.JComboBox<Object> jCBCategoria;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbEmitir;
    private javax.swing.JButton jbEmitirCompleto;
    private javax.swing.JRadioButton rbCategoria;
    private javax.swing.JRadioButton rbIgual;
    private javax.swing.JRadioButton rbMaior;
    private javax.swing.JRadioButton rbMenor;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbPreco;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
