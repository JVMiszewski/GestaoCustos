package model.VIEW;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BEAN.Categoria;
import model.BEAN.Ferramenta;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.CategoriaDAO;
import model.DAO.FerramentaDAO;

public class FerramentasVIEW extends javax.swing.JPanel {

    private String pesquisa;

    public FerramentasVIEW() {

        initComponents();

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

        readJTable();

    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

        modelo.setNumRows(0);

        FerramentaDAO fDAO = new FerramentaDAO();

        for (Ferramenta f : fDAO.read()) {

            modelo.addRow(new Object[]{
                f.getIdFerramenta(),
                f.getNome(),
                f.getDescricao(),});

        }
    }

    public void readJTableWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

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

        DefaultTableModel modelo = (DefaultTableModel) jTMaquinas.getModel();

        modelo.setNumRows(0);

        FerramentaDAO fDAO = new FerramentaDAO();

        for (Ferramenta f : fDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                f.getIdFerramenta(),
                f.getNome(),
                f.getDescricao(),});

        }
    }

    public void clearJText() {

        jTNome.setText("");
        jTDescricao.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTDescricao = new javax.swing.JTextField();
        jBCadastar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMaquinas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jBExcluir = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Ferramentas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 11, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 56, 36));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Descrição:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 87, 36));

        jTNome.setToolTipText("Digite o nome da ferramenta");
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, 36));

        jTDescricao.setToolTipText("Digite a descrição da ferramenta");
        jPanel1.add(jTDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 160, 36));

        jBCadastar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBCadastar.setText("Cadastrar");
        jBCadastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastarActionPerformed(evt);
            }
        });
        jPanel1.add(jBCadastar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jBAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 530, 160));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Ferramentas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jTMaquinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ferramenta", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTMaquinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTMaquinas);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pesquisar:");

        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyTyped(evt);
            }
        });

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBExcluir)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1091, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastarActionPerformed

        if (jTNome.getText().isEmpty() == false && jTDescricao.getText().isEmpty() == false) {

            Ferramenta f = new Ferramenta();
            FerramentaDAO fdao = new FerramentaDAO();

            f.setNome(jTNome.getText());
            f.setDescricao(jTDescricao.getText());

            fdao.create(f);

            clearJText();

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }


    }//GEN-LAST:event_jBCadastarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        if (jTMaquinas.getSelectedRow() != -1) {

            Ferramenta f = new Ferramenta();
            FerramentaDAO dao = new FerramentaDAO();

            f.setIdFerramenta((int) jTMaquinas.getValueAt(jTMaquinas.getSelectedRow(), 0));

            dao.delete(f);

            clearJText();

            readJTable();

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed

        if (jTMaquinas.getSelectedRow() != -1 && jTNome.getText().isEmpty() == false && jTDescricao.getText().isEmpty() == false) {

            Ferramenta f = new Ferramenta();
            FerramentaDAO fdao = new FerramentaDAO();

            f.setNome(jTNome.getText());
            f.setDescricao(jTDescricao.getText());
            f.setIdFerramenta((int) jTMaquinas.getValueAt(jTMaquinas.getSelectedRow(), 0));

            fdao.update(f);

            clearJText();

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jTMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMaquinasMouseClicked

        if (jTMaquinas.getSelectedRow() != -1) {

            jTNome.setText(jTMaquinas.getValueAt(jTMaquinas.getSelectedRow(), 1).toString());
            jTDescricao.setText(jTMaquinas.getValueAt(jTMaquinas.getSelectedRow(), 2).toString());

        }

    }//GEN-LAST:event_jTMaquinasMouseClicked

    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased

        if (pesquisa.equals("id")) {

            if (jTPesquisar.getText().isEmpty() == false) {

                readJTableWhere(Integer.parseInt(jTPesquisar.getText()));

            } else if (jTPesquisar.getText().isEmpty() == true) {

                readJTable();

            }

        } else {

            readJTableWhere((String) jTPesquisar.getText());

        }


    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jTPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyTyped

        if (pesquisa.equals("id")) {

            String caracteres = "0987654321";

            if (!caracteres.contains(evt.getKeyChar() + "")) {

                evt.consume();

            }

        } else {

        }

    }//GEN-LAST:event_jTPesquisarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDescricao;
    private javax.swing.JTable jTMaquinas;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    // End of variables declaration//GEN-END:variables
}
