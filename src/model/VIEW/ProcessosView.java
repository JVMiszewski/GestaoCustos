package model.VIEW;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BEAN.Categoria;
import model.DAO.CategoriaDAO;
import model.BEAN.*;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.*;
import model.VIEW.*;

public class ProcessosView extends javax.swing.JPanel {

    private String pesquisa;

    public ProcessosView() {

        initComponents();

        readJTable();

        CategoriaDAO cDAO = new CategoriaDAO();

        for (Categoria c : cDAO.read()) {

            jCCategoria.addItem(c);

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

    public void clearJText() {

        jTNome.setText("");
        jTDescricao.setText("");
        jTPreco.setText("");

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

    public void readJTable() {

        DefaultTableModel modelo = (DefaultTableModel) jtableProcessos.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();
        MaquinaProcessoDAO mpDAO = new MaquinaProcessoDAO();

        for (Processo p : pDAO.read()) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getDescricaoP(),
                p.getPrecoP(),
                p.getCategoria().getNome(),
                "Lista de Máquinas",
                "Lista de Ferramentas",
                "Lista de Materiais",});
        }

    }

    public void readJTableWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jtableProcessos.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.readWhere(nome)) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getDescricaoP(),
                p.getPrecoP(),
                p.getCategoria().getNome(),
                "Lista de Máquinas",
                "Lista de Ferramentas",
                "Lista de Materiais",});
        }

    }

    public void readJTableWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jtableProcessos.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getDescricaoP(),
                p.getPrecoP(),
                p.getCategoria().getNome(),
                "Lista de Máquinas",
                "Lista de Ferramentas",
                "Lista de Materiais",});
        }

    }

    public int readJTableMAX() {

        int id = 0;

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.read()) {

            id = p.getIdProcesso();

        }

        return id;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jLPreco = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jLCategoria = new javax.swing.JLabel();
        jCCategoria = new javax.swing.JComboBox<Object>();
        jLDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDescricao = new javax.swing.JTextArea();
        jCadastrar = new javax.swing.JButton();
        jAlterar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLCategoria1 = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtableProcessos = new javax.swing.JTable();
        jExcluir = new javax.swing.JButton();

        Titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Titulo1.setText("Processos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLNome.setText("Nome:");
        jPanel1.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLPreco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLPreco.setText("Preço:");
        jPanel1.add(jLPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jTNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTNome.setToolTipText("Digite o nome do Processo");
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 219, -1));

        jTPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTPreco.setToolTipText("Digite o preço do Processo");
        jTPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPrecoKeyTyped(evt);
            }
        });
        jPanel1.add(jTPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 219, -1));

        jLCategoria.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLCategoria.setText("Categoria:");
        jPanel1.add(jLCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel1.add(jCCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 160, -1));

        jLDescricao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLDescricao.setText("Descrição:");
        jPanel1.add(jLDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jTDescricao.setColumns(20);
        jTDescricao.setRows(5);
        jTDescricao.setToolTipText("Digite a descrição do Processo");
        jScrollPane1.setViewportView(jTDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 410, -1));

        jCadastrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jAlterar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jAlterar.setText("Alterar");
        jAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Lista de Processos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLCategoria1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLCategoria1.setText("Processos:");
        jPanel3.add(jLCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyTyped(evt);
            }
        });
        jPanel3.add(jTPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 201, 29));

        jtableProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Processo", "Descrição", "Preço", "Categoria", "Máquinas", "Ferramentas", "Materiais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableProcessos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableProcessosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtableProcessos);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 920, 280));

        jExcluir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jExcluir.setText("Excluir");
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });
        jPanel3.add(jExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(Titulo1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(Titulo1)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed

        if (jTDescricao.getText().isEmpty() == false && jTNome.getText().isEmpty() == false && jTPreco.getText().isEmpty() == false) {

            Processo p = new Processo();
            ProcessoDAO dao = new ProcessoDAO();
            Categoria categoria = (Categoria) jCCategoria.getSelectedItem();

            p.setNomeP(jTNome.getText());
            p.setDescricaoP(jTDescricao.getText());
            p.setPrecoP(Double.parseDouble(jTPreco.getText()));
            p.setCategoria(categoria);

            dao.create(p);

            clearJText();

            readJTable();

        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jtableProcessosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableProcessosMouseClicked

        String newTable = "";
        int id = 0;

        if (jtableProcessos.getSelectedRow() != -1) {

            newTable = (jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), jtableProcessos.getSelectedColumn())).toString();

            if (newTable.equalsIgnoreCase("Lista de Máquinas")) {

                id = ((int) jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 0));
                new MaquinaProcessoVIEW(id).setVisible(true);

            } else if (newTable.equalsIgnoreCase("Lista de Ferramentas")) {

                id = ((int) jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 0));
                new FerramentaProcessoVIEW(id).setVisible(true);

            } else if (newTable.equalsIgnoreCase("Lista de Materiais")) {

                id = ((int) jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 0));
                new MaterialProcessoVIEW(id).setVisible(true);

            } else {

            }
        }

        if (jtableProcessos.getSelectedRow() != -1) {

            jTNome.setText(jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 1).toString());
            jTDescricao.setText(jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 2).toString());
            jTPreco.setText(jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 3).toString());
            jCCategoria.setSelectedIndex(getItem(jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 4).toString()));

        }
    }//GEN-LAST:event_jtableProcessosMouseClicked

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed

        if (jtableProcessos.getSelectedRow() != -1) {

            Processo p = new Processo();
            ProcessoDAO dao = new ProcessoDAO();

            p.setIdProcesso((int) jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 0));

            dao.delete(p);

            clearJText();

            readJTable();

        }

    }//GEN-LAST:event_jExcluirActionPerformed

    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed

        if (jtableProcessos.getSelectedRow() != -1) {

            Processo p = new Processo();
            Categoria categoria = (Categoria) jCCategoria.getSelectedItem();
            ProcessoDAO pDAO = new ProcessoDAO();

            p.setNomeP(jTNome.getText());
            p.setDescricaoP(jTDescricao.getText());
            p.setPrecoP(Double.parseDouble(jTPreco.getText()));
            p.setCategoria(categoria);

            p.setIdProcesso((int) jtableProcessos.getValueAt(jtableProcessos.getSelectedRow(), 0));

            pDAO.update(p);

            clearJText();

            readJTable();

        }

    }//GEN-LAST:event_jAlterarActionPerformed

    private void jTPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecoKeyTyped

        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }

    }//GEN-LAST:event_jTPrecoKeyTyped

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
    private javax.swing.JLabel Titulo1;
    private javax.swing.JButton jAlterar;
    private javax.swing.JComboBox<Object> jCCategoria;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JButton jExcluir;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLCategoria1;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTDescricao;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTable jtableProcessos;
    // End of variables declaration//GEN-END:variables

}
