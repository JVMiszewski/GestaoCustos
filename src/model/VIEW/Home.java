package model.VIEW;

import model.CONF.ConfiguracoesVIEW;
import connection.ConnectionFactory;
import java.awt.Toolkit;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.USER.Login;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        setTitle("Simulador de Custos");
        jScrollPane1.setHorizontalScrollBar(null);
        setExtendedState(MAXIMIZED_BOTH);
        jScrollPane1.setViewportView(new SimuladorCustosVIEW());
        setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/real.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMSimuladorCustos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMCadastrar = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMRelatorios = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMConfigurar = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        jMSimuladorCustos.setText("Simulador de custos");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Calcular custos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMSimuladorCustos.add(jMenuItem5);

        jMenuBar1.add(jMSimuladorCustos);

        jMCadastrar.setText("Cadastrar");

        jMenuItem15.setText("Categoria");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem15);

        jMenuItem16.setText("Unidade");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem16);

        jMenuItem3.setText("Máquina");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem3);

        jMenuItem6.setText("Ferramenta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem6);

        jMenuItem1.setText("Material");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem1);

        jMenuItem2.setText("Processo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem2);

        jMenuItem4.setText("Ficha Técnica");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMenuItem4);

        jMenuBar1.add(jMCadastrar);

        jMRelatorios.setText("Relatórios");

        jMenuItem8.setText("Categorias");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem8);

        jMenuItem9.setText("Unidades");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem9);

        jMenuItem10.setText("Máquinas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem10);

        jMenuItem11.setText("Ferramentas");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem11);

        jMenuItem12.setText("Materiais");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem12);

        jMenuItem13.setText("Processos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem13);

        jMenuItem14.setText("Fichas Técnicas");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMRelatorios.add(jMenuItem14);

        jMenuBar1.add(jMRelatorios);

        jMConfigurar.setText("Configurar");

        jMenuItem7.setText("Configurações");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMConfigurar.add(jMenuItem7);

        jMenuBar1.add(jMConfigurar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        jScrollPane1.setViewportView(new MateriaisView());

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        jScrollPane1.setViewportView(new ProcessosView());

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        jScrollPane1.setViewportView(new MaquinasVIEW());

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        jScrollPane1.setViewportView(new FichasTecnicasVIEW());

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        jScrollPane1.setViewportView(new SimuladorCustosVIEW());

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        jScrollPane1.setViewportView(new FerramentasVIEW());

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        new ConfiguracoesVIEW(this).setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        Connection con = ConnectionFactory.getConnection();

        String src = "/relatorios/categorias.jasper";

        InputStream reportFile = null;
        reportFile = getClass().getResourceAsStream(src);

        JasperPrint jp = null;

        try {

            jp = JasperFillManager.fillReport(reportFile, null, con);

        } catch (JRException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Relatorio - Categorias");
        jv.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/real.png")));      
        
        jv.setVisible(true);

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        Connection con = ConnectionFactory.getConnection();

        String src = "/relatorios/unidades.jasper";

        InputStream reportFile = null;
        reportFile = getClass().getResourceAsStream(src);

        JasperPrint jp = null;

        try {

            jp = JasperFillManager.fillReport(reportFile, null, con);

        } catch (JRException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Relatorio - Unidades");
        jv.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/real.png")));

        jv.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed

        Connection con = ConnectionFactory.getConnection();

        String src = "/relatorios/maquinas.jasper";
        
        InputStream reportFile = null;
        reportFile = getClass().getResourceAsStream(src);

        JasperPrint jp = null;

        try {

            jp = JasperFillManager.fillReport(reportFile, null, con);

        } catch (JRException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Relatorio - Máquinas");
        jv.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/real.png")));

        jv.setVisible(true);

    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        Connection con = ConnectionFactory.getConnection();

        String src = "/relatorios/ferramentas.jasper";
        
        InputStream reportFile = null;
        reportFile = getClass().getResourceAsStream(src);

        JasperPrint jp = null;

        try {

            jp = JasperFillManager.fillReport(reportFile, null, con);

        } catch (JRException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

        JasperViewer jv = new JasperViewer(jp, false);
        jv.setTitle("Relatorio - Ferramentas");
        jv.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/imagens/real.png")));

        jv.setVisible(true);

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed

        new MaterialREPORT().setVisible(true);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       
        new ProcessoREPORT().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        
        new FichaTecnicaREPORT().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
       
        jScrollPane1.setViewportView(new CategoriaVIEW());
       
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        
        jScrollPane1.setViewportView(new UnidadeVIEW());
        
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMCadastrar;
    private javax.swing.JMenu jMConfigurar;
    private javax.swing.JMenu jMRelatorios;
    private javax.swing.JMenu jMSimuladorCustos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
