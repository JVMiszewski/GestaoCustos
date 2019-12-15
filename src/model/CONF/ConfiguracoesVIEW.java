package model.CONF;

import java.awt.Toolkit;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.VIEW.Home;
import model.VIEW.Home;

public class ConfiguracoesVIEW extends javax.swing.JFrame {

    private String pesquisa;
    private int casas;
    private Configuracoes conf = new Configuracoes();
    private Home home;

    public ConfiguracoesVIEW(Home home) {
        initComponents();
        
        setTitle("Configurações");
        
        this.home = home;

        setIconImage(Toolkit.getDefaultToolkit().getImage(ConfiguracoesVIEW.class.getResource("/imagens/real.png")));
        
        conf();

    }

    private ConfiguracoesVIEW() {
        
    }

    public void conf() {

        ConfiguracoesDAO cDAO = new ConfiguracoesDAO();

        for (Configuracoes c : cDAO.read()) {

            c.getId();
            c.getPesquisa();
            c.getCasas();

            conf.setId(c.getId());
            conf.setCasas(c.getCasas());
            conf.setPesquisa(c.getPesquisa());

        }

        if (conf.getPesquisa().equals("id")) {

            jRBCodigo.setSelected(true);
            jRBNome.setSelected(false);

        } else {

            jRBCodigo.setSelected(false);
            jRBNome.setSelected(true);

        }

        switch (conf.getCasas()) {

            case 2:
                jRB2.setSelected(true);
                jRB3.setSelected(false);
                jRB4.setSelected(false);
                break;

            case 3:
                jRB2.setSelected(false);
                jRB3.setSelected(true);
                jRB4.setSelected(false);
                break;

            default:
                jRB2.setSelected(false);
                jRB3.setSelected(false);
                jRB4.setSelected(true);
                break;
        }

    }

    public String WhoSelectedSearch() {

        if (jRBCodigo.isSelected()) {
            this.pesquisa = "id";
        } else if (jRBNome.isSelected()){
            this.pesquisa = "nome";
        }
        
         System.out.println(pesquisa);
        return this.pesquisa;
       

    }
    
    public int WhoSelectedDecimals() {

        if (jRB2.isSelected()) {
            this.casas = 2;
        } else if (jRB3.isSelected()){
            this.casas = 3;
        } else if (jRB4.isSelected()){
            this.casas = 4;
        }
        
         System.out.println(casas);
        return this.casas;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLPesquisa = new javax.swing.JLabel();
        jRBCodigo = new javax.swing.JRadioButton();
        jRBNome = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLCasasDecimais = new javax.swing.JLabel();
        jRB2 = new javax.swing.JRadioButton();
        jRB3 = new javax.swing.JRadioButton();
        jRB4 = new javax.swing.JRadioButton();
        jBSalvar = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLPesquisa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLPesquisa.setText("Configuração de Pesquisa");

        buttonGroup1.add(jRBCodigo);
        jRBCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRBCodigo.setText("Código");

        buttonGroup1.add(jRBNome);
        jRBNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRBNome.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(jRBNome))
                    .addComponent(jLPesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBCodigo)
                    .addComponent(jRBNome))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Casas Decimais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLCasasDecimais.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLCasasDecimais.setText("Configuração de Casas decimais");

        buttonGroup2.add(jRB2);
        jRB2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRB2.setText("2");

        buttonGroup2.add(jRB3);
        jRB3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRB3.setText("3");

        buttonGroup2.add(jRB4);
        jRB4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRB4.setText("4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCasasDecimais)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRB2)
                        .addGap(18, 18, 18)
                        .addComponent(jRB3)
                        .addGap(18, 18, 18)
                        .addComponent(jRB4)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCasasDecimais, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB2)
                    .addComponent(jRB3)
                    .addComponent(jRB4))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jBSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSalvar.setText("Salvar Configurações");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Titulo.setText("Configurações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBSalvar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        Configuracoes c = new Configuracoes();
        ConfiguracoesDAO dao = new ConfiguracoesDAO();

        c.setId(conf.getId());
        c.setPesquisa(WhoSelectedSearch());
        c.setCasas(WhoSelectedDecimals());

        dao.update(c);

        home.dispose();
        
        new Home().setVisible(true);
        
    }//GEN-LAST:event_jBSalvarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracoesVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiguracoesVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLCasasDecimais;
    private javax.swing.JLabel jLPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRB2;
    private javax.swing.JRadioButton jRB3;
    private javax.swing.JRadioButton jRB4;
    private javax.swing.JRadioButton jRBCodigo;
    private javax.swing.JRadioButton jRBNome;
    // End of variables declaration//GEN-END:variables
}
