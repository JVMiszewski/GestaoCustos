package model.VIEW;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BEAN.Categoria;
import model.BEAN.FichaTecnica;
import model.BEAN.Material;
import model.BEAN.MaterialUsado;
import model.BEAN.Processo;
import model.BEAN.ProcessoUsado;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.CategoriaDAO;
import model.DAO.FichaTecnicaDAO;
import model.DAO.MaquinaProcessoDAO;
import model.DAO.MaterialDAO;
import model.DAO.MaterialUsadoDAO;
import model.DAO.ProcessoDAO;
import model.DAO.ProcessoUsadoDAO;

public class FichasTecnicasVIEW extends javax.swing.JPanel {

    private int id = 0;
    private int count = 0;
    private double custoTotal = 0;
    private String pesquisa;

    public FichasTecnicasVIEW() {

        initComponents();

        ConfiguracoesDAO DAO = new ConfiguracoesDAO();

        for (Configuracoes c : DAO.read()) {

            c.getId();
            c.getPesquisa();
            c.getCasas();

            if (c.getPesquisa().equals("id")) {
                pesquisa = "id";
            } else {
                pesquisa = "nome";
            }

        }

        CategoriaDAO cDAO = new CategoriaDAO();

        for (Categoria c : cDAO.read()) {

            jCBCategoria.addItem(c);

        }

        readJTableM();
        readJTableF();
        readJComboBox();
        jCBCategoria.setSelectedIndex(0);

    }

    public void readJComboBox() {

        FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

        for (FichaTecnica ft : ftDAO.read()) {

            jCBFichaTecnica.addItem(ft);

        }

    }

    public void readJTableM() {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriaisSelecionaveis.getModel();

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

    public void readJTableMWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriaisSelecionaveis.getModel();

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

    public void readJTableMWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriaisSelecionaveis.getModel();

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

    public void readJTableF() {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessosSelecionaveis.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.read()) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getPrecoP(),});
        }

    }

    public void readJTableFWhere(String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessosSelecionaveis.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.readWhere(nome)) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getPrecoP(),});
        }

    }

    public void readJTableFWhere(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessosSelecionaveis.getModel();

        modelo.setNumRows(0);

        ProcessoDAO pDAO = new ProcessoDAO();

        for (Processo p : pDAO.readWhere(id)) {

            modelo.addRow(new Object[]{
                p.getIdProcesso(),
                p.getNomeP(),
                p.getPrecoP(),});
        }

    }

    public int readMAX() {

        int id = 0;

        FichaTecnicaDAO tDAO = new FichaTecnicaDAO();

        for (FichaTecnica t : tDAO.readMAX()) {

            id = t.getIdFichaTecnica();

        }

        return id;

    }

    public void readJTableM(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriasSelecionado.getModel();

        modelo.setNumRows(0);

        MaterialUsadoDAO mDAO = new MaterialUsadoDAO();

        for (MaterialUsado m : mDAO.readP(id)) {

            modelo.addRow(new Object[]{
                m.getIdMaterialUsado(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getPrecoM(),
                m.getQuantidade(),
                m.getPreco(),});

            this.custoTotal += m.getPreco();

        }

        jTCustoTotal.setText(String.valueOf(this.custoTotal));

    }

    public void readJTableM(int id, String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriasSelecionado.getModel();

        modelo.setNumRows(0);

        MaterialUsadoDAO mDAO = new MaterialUsadoDAO();

        for (MaterialUsado m : mDAO.readP(id, nome)) {

            modelo.addRow(new Object[]{
                m.getIdMaterialUsado(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getPrecoM(),
                m.getQuantidade(),
                m.getPreco(),});

        }

    }

    public void readJTableM(int id, int cod) {

        DefaultTableModel modelo = (DefaultTableModel) jTMateriasSelecionado.getModel();

        modelo.setNumRows(0);

        MaterialUsadoDAO mDAO = new MaterialUsadoDAO();

        for (MaterialUsado m : mDAO.readP(id, cod)) {

            modelo.addRow(new Object[]{
                m.getIdMaterialUsado(),
                m.getMaterial().getNomeM(),
                m.getMaterial().getPrecoM(),
                m.getQuantidade(),
                m.getPreco(),});

        }

    }

    public void readJTableF(int id) {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessoSelecionado.getModel();

        modelo.setNumRows(0);

        ProcessoUsadoDAO puDAO = new ProcessoUsadoDAO();

        for (ProcessoUsado pu : puDAO.readP(id)) {

            modelo.addRow(new Object[]{
                pu.getIdProcessoUsado(),
                pu.getProcesso().getNomeP(),
                pu.getProcesso().getPrecoP(),
                pu.getQuantidade(),
                pu.getPreco(),});

            this.custoTotal += pu.getPreco();
        }

        jTCustoTotal.setText(String.valueOf(this.custoTotal));

    }

    public void readJTableF(int id, String nome) {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessoSelecionado.getModel();

        modelo.setNumRows(0);

        ProcessoUsadoDAO puDAO = new ProcessoUsadoDAO();

        for (ProcessoUsado pu : puDAO.readP(id, nome)) {

            modelo.addRow(new Object[]{
                pu.getIdProcessoUsado(),
                pu.getProcesso().getNomeP(),
                pu.getProcesso().getPrecoP(),
                pu.getQuantidade(),
                pu.getPreco(),});

        }

    }

    public void readJTableF(int id, int cod) {

        DefaultTableModel modelo = (DefaultTableModel) jTProcessoSelecionado.getModel();

        modelo.setNumRows(0);

        ProcessoUsadoDAO puDAO = new ProcessoUsadoDAO();

        for (ProcessoUsado pu : puDAO.readP(id, cod)) {

            modelo.addRow(new Object[]{
                pu.getIdProcessoUsado(),
                pu.getProcesso().getNomeP(),
                pu.getProcesso().getPrecoP(),
                pu.getQuantidade(),
                pu.getPreco(),});

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jBCadastrar = new javax.swing.JButton();
        jLCategoria = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLPesquisar = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jCBFichaTecnica = new javax.swing.JComboBox<>();
        jBAlterar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLMateriaisSelecionaveis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMateriaisSelecionaveis = new javax.swing.JTable();
        jBSelecionarM = new javax.swing.JButton();
        jTQuantidadeM = new javax.swing.JTextField();
        jLQauntidade = new javax.swing.JLabel();
        jLMaterialSelecionado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTMateriasSelecionado = new javax.swing.JTable();
        jBRemoverM = new javax.swing.JButton();
        jTPesquisarMS = new javax.swing.JTextField();
        jTPesquisarMSM = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLProcessosSelecionaveis = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProcessosSelecionaveis = new javax.swing.JTable();
        jLProcessosSelecionados = new javax.swing.JLabel();
        jLQuantidadeP = new javax.swing.JLabel();
        jBSelecionarP = new javax.swing.JButton();
        jTQuantidadeP = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTProcessoSelecionado = new javax.swing.JTable();
        jBRemoverF = new javax.swing.JButton();
        jTPesquisarPS = new javax.swing.JTextField();
        jTPesquisarPSP = new javax.swing.JTextField();
        jLCustoTotal = new javax.swing.JLabel();
        jTCustoTotal = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Titulo.setText("Ficha Técnica do Produto");
        add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLNome.setText("Nome:");
        jPanel1.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 24));

        jTNome.setToolTipText("Digite o nome da Ficha Técnica");
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 30));

        jBCadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBCadastrar.setText("Cadastar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 100, 30));

        jLCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCategoria.setText("Categoria:");
        jPanel1.add(jLCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 24));

        jPanel1.add(jCBCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 180, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 414, 201));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Selecionar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPesquisar.setText("Pesquisar");
        jPanel2.add(jLPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 24));

        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
        });
        jPanel2.add(jTPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 140, 30));

        jCBFichaTecnica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBFichaTecnicaItemStateChanged(evt);
            }
        });
        jPanel2.add(jCBFichaTecnica, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 140, 30));

        jBAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(jBAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 100, 30));

        jBExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jBExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 100, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 414, 190));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLMateriaisSelecionaveis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLMateriaisSelecionaveis.setText("Materiais Selecionáveis:");
        jPanel3.add(jLMateriaisSelecionaveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 24));

        jTMateriaisSelecionaveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição", "UN", "Preço UN", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTMateriaisSelecionaveis.setMaximumSize(new java.awt.Dimension(214, 0));
        jScrollPane1.setViewportView(jTMateriaisSelecionaveis);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 517, 159));

        jBSelecionarM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSelecionarM.setText("Selecionar");
        jBSelecionarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarMActionPerformed(evt);
            }
        });
        jPanel3.add(jBSelecionarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        jTQuantidadeM.setToolTipText("Digite a quantidade");
        jTQuantidadeM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTQuantidadeMKeyTyped(evt);
            }
        });
        jPanel3.add(jTQuantidadeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 103, 25));

        jLQauntidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLQauntidade.setText("Quantidade:");
        jPanel3.add(jLQauntidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 103, 26));

        jLMaterialSelecionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLMaterialSelecionado.setText("Materiais Selecionados:");
        jPanel3.add(jLMaterialSelecionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, 24));

        jTMateriasSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço UN", "Quantidade", "Preço Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTMateriasSelecionado);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 510, 159));

        jBRemoverM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRemoverM.setText("Remover");
        jBRemoverM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverMActionPerformed(evt);
            }
        });
        jPanel3.add(jBRemoverM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, -1, -1));

        jTPesquisarMS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMSKeyReleased(evt);
            }
        });
        jPanel3.add(jTPesquisarMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 30));

        jTPesquisarMSM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarMSMKeyReleased(evt);
            }
        });
        jPanel3.add(jTPesquisarMSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 120, 30));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1312, 261));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLProcessosSelecionaveis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLProcessosSelecionaveis.setText("Processos Selecionaveis:");
        jPanel4.add(jLProcessosSelecionaveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 24));

        jTProcessosSelecionaveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Coódigo", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTProcessosSelecionaveis);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 517, 159));

        jLProcessosSelecionados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLProcessosSelecionados.setText("Processos Selecionados:");
        jPanel4.add(jLProcessosSelecionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, 24));

        jLQuantidadeP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLQuantidadeP.setText("Quantidade:");
        jPanel4.add(jLQuantidadeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 103, 26));

        jBSelecionarP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSelecionarP.setText("Selecionar");
        jBSelecionarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarPActionPerformed(evt);
            }
        });
        jPanel4.add(jBSelecionarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, -1));

        jTQuantidadeP.setToolTipText("Digite a quantidade");
        jTQuantidadeP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTQuantidadePKeyTyped(evt);
            }
        });
        jPanel4.add(jTQuantidadeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 103, 25));

        jTProcessoSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço UN", "Quantidade", "Preço Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTProcessoSelecionado);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 500, 160));

        jBRemoverF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRemoverF.setText("Remover");
        jBRemoverF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoverFActionPerformed(evt);
            }
        });
        jPanel4.add(jBRemoverF, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, -1, -1));

        jTPesquisarPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarPSKeyReleased(evt);
            }
        });
        jPanel4.add(jTPesquisarPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 130, 30));

        jTPesquisarPSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarPSPKeyReleased(evt);
            }
        });
        jPanel4.add(jTPesquisarPSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 120, 30));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 1312, 257));

        jLCustoTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCustoTotal.setText("Custo Total:");
        add(jLCustoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 860, -1, 33));

        jTCustoTotal.setEditable(false);
        add(jTCustoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 860, 150, 30));

        jBSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });
        add(jBSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 880, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jBSelecionarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarMActionPerformed

        if (jTMateriaisSelecionaveis.getSelectedRow() != -1 && jTQuantidadeM.getText().isEmpty() == false) {

            MaterialUsado mu = new MaterialUsado();
            Material m = new Material();
            FichaTecnica ft = new FichaTecnica();
            MaterialUsadoDAO dao = new MaterialUsadoDAO();
            FichaTecnica ficha = (FichaTecnica) jCBFichaTecnica.getSelectedItem();
            this.id = ficha.getIdFichaTecnica();

            m.setIdMaterial((Integer) jTMateriaisSelecionaveis.getValueAt(jTMateriaisSelecionaveis.getSelectedRow(), 0));
            ft.setIdFichaTecnica(this.id);
            String t = String.valueOf(jTMateriaisSelecionaveis.getValueAt(jTMateriaisSelecionaveis.getSelectedRow(), 4));
            double tr = Double.parseDouble(t);
            int pr = Integer.parseInt(jTQuantidadeM.getText());
            mu.setPreco(tr * pr);
            mu.setQuantidade(pr);
            mu.setMaterial(m);
            mu.setFichaTecnica(ft);

            dao.create(mu);

            this.custoTotal = 0;
            readJTableM(this.id);
            readJTableF(this.id);
        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBSelecionarMActionPerformed

    private void jBSelecionarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarPActionPerformed

        if (jTProcessosSelecionaveis.getSelectedRow() != -1 && jTQuantidadeP.getText().isEmpty() == false) {

            ProcessoUsado pu = new ProcessoUsado();
            Processo p = new Processo();
            FichaTecnica ft = new FichaTecnica();
            ProcessoUsadoDAO dao = new ProcessoUsadoDAO();

            p.setIdProcesso((Integer) jTProcessosSelecionaveis.getValueAt(jTProcessosSelecionaveis.getSelectedRow(), 0));
            ft.setIdFichaTecnica(this.id);
            String t = String.valueOf(jTProcessosSelecionaveis.getValueAt(jTProcessosSelecionaveis.getSelectedRow(), 2));
            double tr = Double.parseDouble(t);
            int pr = Integer.parseInt(jTQuantidadeP.getText());
            pu.setPreco(tr * pr);
            pu.setQuantidade(pr);
            pu.setProcesso(p);
            pu.setFichaTecnica(ft);

            dao.create(pu);

            this.custoTotal = 0;
            readJTableF(this.id);
            readJTableM(this.id);

        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBSelecionarPActionPerformed

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed

        if (jTNome.getText().isEmpty() == false) {
            FichaTecnica ft = new FichaTecnica();
            FichaTecnicaDAO dao = new FichaTecnicaDAO();
            Categoria categoria = (Categoria) jCBCategoria.getSelectedItem();

            ft.setNome((String) jTNome.getText());
            ft.setCategoria(categoria);

            dao.create(ft);

            this.custoTotal = 0;
            readJTableM(readMAX());
            readJTableF(readMAX());

            jCBFichaTecnica.removeAllItems();
            readJComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased

        FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

        jCBFichaTecnica.removeAllItems();

        for (FichaTecnica ft : ftDAO.readWhere(jTPesquisar.getText())) {

            jCBFichaTecnica.addItem(ft);

        }

    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jCBFichaTecnicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBFichaTecnicaItemStateChanged

        if (this.count != 0) {

            if (jCBFichaTecnica.getItemCount() != 0) {

                FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

                this.id = fichaTecnica.getIdFichaTecnica();

                readJTableF(this.id);
                readJTableM(this.id);

                jTNome.setText(fichaTecnica.getNome());
                jCBCategoria.setSelectedIndex(getItem(fichaTecnica.getCategoria().getNome()));

                this.count++;
                this.custoTotal = 0;

            } else {

            }

        } else {

            jTNome.setText("");
            jCBCategoria.setSelectedItem(null);
            this.count++;
            this.custoTotal = 0;
        }

    }//GEN-LAST:event_jCBFichaTecnicaItemStateChanged

    private void jBRemoverMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverMActionPerformed

        if (jTMateriasSelecionado.getSelectedRow() != -1) {

            MaterialUsado mu = new MaterialUsado();
            MaterialUsadoDAO dao = new MaterialUsadoDAO();

            mu.setIdMaterialUsado((int) jTMateriasSelecionado.getValueAt(jTMateriasSelecionado.getSelectedRow(), 0));

            dao.delete(mu);

            this.custoTotal = 0;
            readJTableM(this.id);
            readJTableF(this.id);

        }


    }//GEN-LAST:event_jBRemoverMActionPerformed

    private void jBRemoverFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoverFActionPerformed

        if (jTProcessoSelecionado.getSelectedRow() != -1) {

            ProcessoUsado pu = new ProcessoUsado();
            ProcessoUsadoDAO dao = new ProcessoUsadoDAO();

            pu.setIdProcessoUsado((int) jTProcessoSelecionado.getValueAt(jTProcessoSelecionado.getSelectedRow(), 0));

            dao.delete(pu);

            this.custoTotal = 0;
            readJTableF(this.id);
            readJTableM(this.id);

        }

    }//GEN-LAST:event_jBRemoverFActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed

        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer alterar os dados da Ficha Técnica: " + fichaTecnica.getNome() + " ?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            FichaTecnica ft = new FichaTecnica();
            Categoria categoria = (Categoria) jCBCategoria.getSelectedItem();
            FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

            ft.setNome(jTNome.getText());
            ft.setCategoria(categoria);

            ft.setIdFichaTecnica(fichaTecnica.getIdFichaTecnica());

            ftDAO.update(ft);

            jCBFichaTecnica.removeAllItems();

            readJComboBox();

        } else if (confirma == JOptionPane.NO_OPTION) {

        }


    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed

        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer excluir a Ficha Técnica: " + fichaTecnica.getNome() + " ?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {

            FichaTecnica ft = new FichaTecnica();
            FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

            ft.setIdFichaTecnica(fichaTecnica.getIdFichaTecnica());

            ftDAO.delete(ft);

            jCBFichaTecnica.removeAllItems();

            readJComboBox();

        } else if (confirma == JOptionPane.NO_OPTION) {

        }

    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        FichaTecnica ft = new FichaTecnica();
        FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();
        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        ft.setCusto(Double.parseDouble(jTCustoTotal.getText()));

        ft.setIdFichaTecnica(fichaTecnica.getIdFichaTecnica());

        ftDAO.updateCusto(ft);

    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jTQuantidadeMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQuantidadeMKeyTyped

        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }

    }//GEN-LAST:event_jTQuantidadeMKeyTyped

    private void jTQuantidadePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQuantidadePKeyTyped

        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }

    }//GEN-LAST:event_jTQuantidadePKeyTyped

    private void jTPesquisarPSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarPSKeyReleased

        if (pesquisa.equals("id")) {

            if (jTPesquisarPS.getText().isEmpty() == false) {

                readJTableFWhere(Integer.parseInt(jTPesquisarPS.getText()));

            } else if (jTPesquisarPS.getText().isEmpty() == true) {

                readJTableF();

            }

        } else {

            readJTableFWhere((String) jTPesquisarPS.getText());

        }

    }//GEN-LAST:event_jTPesquisarPSKeyReleased

    private void jTPesquisarMSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarMSKeyReleased

        if (pesquisa.equals("id")) {

            if (jTPesquisarMS.getText().isEmpty() == false) {

                readJTableMWhere(Integer.parseInt(jTPesquisarMS.getText()));

            } else if (jTPesquisarMS.getText().isEmpty() == true) {

                readJTableM();

            }

        } else {

            readJTableMWhere((String) jTPesquisarMS.getText());

        }

    }//GEN-LAST:event_jTPesquisarMSKeyReleased

    private void jTPesquisarMSMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarMSMKeyReleased

        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        if (pesquisa.equals("id")) {

            if (jTPesquisarMSM.getText().isEmpty() == false) {

                readJTableM(fichaTecnica.getIdFichaTecnica(), Integer.parseInt(jTPesquisarMSM.getText()));

            } else if (jTPesquisarMSM.getText().isEmpty() == true) {

                readJTableM(fichaTecnica.getIdFichaTecnica());

            }

        } else {

            readJTableM(fichaTecnica.getIdFichaTecnica(), String.valueOf(jTPesquisarMSM.getText()));

        }

    }//GEN-LAST:event_jTPesquisarMSMKeyReleased

    private void jTPesquisarPSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarPSPKeyReleased

        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        if (pesquisa.equals("id")) {

            if (jTPesquisarPSP.getText().isEmpty() == false) {

                readJTableF(fichaTecnica.getIdFichaTecnica(), Integer.parseInt(jTPesquisarPSP.getText()));

            } else if (jTPesquisarPSP.getText().isEmpty() == true) {

                readJTableF(fichaTecnica.getIdFichaTecnica());

            }

        } else {

            readJTableF(fichaTecnica.getIdFichaTecnica(), String.valueOf(jTPesquisarPSP.getText()));

        }

    }//GEN-LAST:event_jTPesquisarPSPKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBRemoverF;
    private javax.swing.JButton jBRemoverM;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jBSelecionarM;
    private javax.swing.JButton jBSelecionarP;
    private javax.swing.JComboBox<Object> jCBCategoria;
    private javax.swing.JComboBox<Object> jCBFichaTecnica;
    private javax.swing.JLabel jLCategoria;
    private javax.swing.JLabel jLCustoTotal;
    private javax.swing.JLabel jLMateriaisSelecionaveis;
    private javax.swing.JLabel jLMaterialSelecionado;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLPesquisar;
    private javax.swing.JLabel jLProcessosSelecionados;
    private javax.swing.JLabel jLProcessosSelecionaveis;
    private javax.swing.JLabel jLQauntidade;
    private javax.swing.JLabel jLQuantidadeP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTCustoTotal;
    private javax.swing.JTable jTMateriaisSelecionaveis;
    private javax.swing.JTable jTMateriasSelecionado;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPesquisarMS;
    private javax.swing.JTextField jTPesquisarMSM;
    private javax.swing.JTextField jTPesquisarPS;
    private javax.swing.JTextField jTPesquisarPSP;
    private javax.swing.JTable jTProcessoSelecionado;
    private javax.swing.JTable jTProcessosSelecionaveis;
    private javax.swing.JTextField jTQuantidadeM;
    private javax.swing.JTextField jTQuantidadeP;
    // End of variables declaration//GEN-END:variables
}
