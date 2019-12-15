package model.VIEW;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BEAN.Material;
import model.BEAN.Categoria;
import model.BEAN.Unidade;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.CategoriaDAO;
import model.DAO.MaterialDAO;
import model.DAO.UnidadeDAO;

public class MateriaisView extends javax.swing.JPanel {

    private String pesquisa;

    public MateriaisView() {

        initComponents();

        readJTable();

        CategoriaDAO cDAO = new CategoriaDAO();

        for (Categoria c : cDAO.read()) {

            jCCategoria.addItem(c);

        }

        UnidadeDAO uDAO = new UnidadeDAO();

        for (Unidade u : uDAO.read()) {

            jComboBox1.addItem(u);

        }

        ConfiguracoesDAO cfDAO = new ConfiguracoesDAO();

        for (Configuracoes c : cfDAO.read()) {

            c.getId();
            c.getPesquisa();
            c.getCasas();

            if (c.getPesquisa().equals("id")) {
                pesquisa = "id";
            } else {
                pesquisa = "nome";
            }

        }

    }

    public int getItem(String categoria) {

        int index = 0;

        CategoriaDAO cDAO = new CategoriaDAO();
        ArrayList<String> categorias = new ArrayList();

        for (Categoria c : cDAO.read()) {

            categorias.add(c.getNome());

        }

        for (int i = 0; i < categorias.size(); i++) {

            if (categorias.get(i).equals(categoria)) {
                index = i;
            }

        }

        return index;

    }

    public int getItemU(String unidade) {

        int index = 0;

        UnidadeDAO uDAO = new UnidadeDAO();
        ArrayList<String> unidades = new ArrayList();

        for (Unidade u : uDAO.read()) {

            unidades.add(u.getNome());

        }

        for (int i = 0; i < unidades.size(); i++) {

            if (unidades.get(i).equals(unidade)) {
                index = i;
            }

        }

        return index;

    }

    public void clearJText() {

        jTNome.setText("");
        jTDescricao.setText("");
        jTPreco.setText("");

    }

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jTableMaterial.getModel();

        modelo.setNumRows(0);

        MaterialDAO mDAO = new MaterialDAO();

        for (Material m : mDAO.read()) {

            modelo.addRow(new Object[]{
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
                m.getUn(),
                m.getPrecoM(),
                m.getCategoria().getNome(),});
        }
    }

    public void readJTableWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTableMaterial.getModel();

        modelo.setNumRows(0);

        MaterialDAO mDAO = new MaterialDAO();

        for (Material m : mDAO.readWhere(nome)) {

            modelo.addRow(new Object[]{
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
                m.getUn(),
                m.getPrecoM(),
                m.getCategoria().getNome(),});

        }
    }

    public void readJTableWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTableMaterial.getModel();

        modelo.setNumRows(0);

        MaterialDAO mDAO = new MaterialDAO();

        for (Material m : mDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                m.getIdMaterial(),
                m.getNomeM(),
                m.getDescricaoM(),
                m.getUn(),
                m.getPrecoM(),
                m.getCategoria().getNome(),});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLNome1 = new javax.swing.JLabel();
        jLPreco = new javax.swing.JLabel();
        jLCategoria = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jCCategoria = new javax.swing.JComboBox<>();
        jBCadastrar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDescricao = new javax.swing.JTextArea();
        jLUN = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMaterial = new javax.swing.JTable();
        jBExcluir = new javax.swing.JButton();

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Titulo.setText("Material");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNome1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLNome1.setText("Nome:");
        jPanel1.add(jLNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLPreco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLPreco.setText("Preço:");
        jPanel1.add(jLPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLCategoria.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLCategoria.setText("Categoria:");
        jPanel1.add(jLCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jTNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTNome.setToolTipText("Digite o nome do Material");
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 190, -1));

        jTPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTPreco.setToolTipText("Digite o preço do material");
        jTPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPrecoKeyTyped(evt);
            }
        });
        jPanel1.add(jTPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 190, -1));

        jCCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCCategoria.setMaximumRowCount(10);
        jPanel1.add(jCCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 160, -1));

        jBCadastrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, -1, -1));

        jBAlterar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, -1, -1));

        jTDescricao.setColumns(20);
        jTDescricao.setRows(5);
        jTDescricao.setToolTipText("Digite a descrição do Material");
        jTDescricao.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 290, 110));

        jLUN.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLUN.setText("UN:");
        jPanel1.add(jLUN, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jLDescricao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLDescricao.setText("Descrição:");
        jPanel1.add(jLDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 80, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Materiais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLNome.setText("Pesquisar:");
        jPanel2.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
        });
        jPanel2.add(jTPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 179, -1));

        jTableMaterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Material", "Descrição", "UN", "Preço", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMaterial);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 81, 1020, 180));

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(Titulo))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed

        if (jTNome.getText().isEmpty() == false && jTDescricao.getText().isEmpty() == false && jTPreco.getText().isEmpty() == false) {
            Material m = new Material();
            MaterialDAO dao = new MaterialDAO();
            Categoria categoria = (Categoria) jCCategoria.getSelectedItem();
            Unidade unidade = (Unidade) jComboBox1.getSelectedItem();

            m.setNomeM(jTNome.getText());
            m.setDescricaoM(jTDescricao.getText());
            m.setPrecoM(Double.parseDouble(jTPreco.getText()));
            m.setUn(unidade);
            m.setCategoria(categoria);

            dao.create(m);

            clearJText();

            readJTable();
        }else{
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }


    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        if (jTableMaterial.getSelectedRow() != -1) {

            Material m = new Material();
            MaterialDAO dao = new MaterialDAO();

            m.setIdMaterial((int) jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 0));

            dao.delete(m);

            clearJText();

            readJTable();

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed

        if (jTableMaterial.getSelectedRow() != -1 && jTNome.getText().isEmpty() == false && jTDescricao.getText().isEmpty() == false 
                && jTPreco.getText().isEmpty() == false) {

            Material m = new Material();
            Categoria categoria = (Categoria) jCCategoria.getSelectedItem();
            Unidade unidade = (Unidade) jComboBox1.getSelectedItem();

            MaterialDAO mDAO = new MaterialDAO();

            m.setNomeM(jTNome.getText());
            m.setDescricaoM(jTDescricao.getText());
            m.setPrecoM(Double.parseDouble(jTPreco.getText()));
            m.setUn(unidade);
            m.setCategoria(categoria);

            m.setIdMaterial((int) jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 0));

            mDAO.update(m);

            clearJText();

            readJTable();

        } else{
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jTableMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMaterialMouseClicked

        if (jTableMaterial.getSelectedRow() != -1) {

            jTNome.setText(jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 1).toString());
            jTDescricao.setText(jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 2).toString());
            jTPreco.setText(jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 4).toString());
            jCCategoria.setSelectedIndex(getItem(jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 5).toString()));
            jComboBox1.setSelectedIndex(getItemU(jTableMaterial.getValueAt(jTableMaterial.getSelectedRow(), 3).toString()));

        }

    }//GEN-LAST:event_jTableMaterialMouseClicked

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

    private void jTPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecoKeyTyped

        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }


    }//GEN-LAST:event_jTPrecoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JComboBox<Categoria> jCCategoria;
    private javax.swing.JComboBox<Object> jComboBox1;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLNome1;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JLabel jLUN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTDescricao;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTable jTableMaterial;
    // End of variables declaration//GEN-END:variables
}
