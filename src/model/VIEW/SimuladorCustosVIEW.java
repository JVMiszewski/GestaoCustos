package model.VIEW;

import connection.ConnectionFactory;
import formating.DFormat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BEAN.FichaTecnica;
import model.BEAN.Unidade;
import model.CONF.Configuracoes;
import model.CONF.ConfiguracoesDAO;
import model.DAO.FichaTecnicaDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

public class SimuladorCustosVIEW extends javax.swing.JPanel {

    private int id = 0;
    private int count = 0;
    private int casas;

    public SimuladorCustosVIEW() {
        initComponents();

        FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

        for (FichaTecnica ft : ftDAO.read()) {

            jCBFichaTecnica.addItem(ft);

        }

        ConfiguracoesDAO cfDAO = new ConfiguracoesDAO();

        for (Configuracoes c : cfDAO.read()) {

            c.getId();
            c.getPesquisa();
            c.getCasas();

            switch (c.getCasas()) {

                case 2:
                    casas = 2;
                    break;

                case 3:
                    casas = 3;
                    break;

                case 4:
                    casas = 4;
                    break;

            }

        }

    }

    public void readJTableF(int id) {

        FichaTecnicaDAO fDAO = new FichaTecnicaDAO();

        for (FichaTecnica f : fDAO.readID(id)) {

            jTCMP.setText(String.valueOf(f.getCusto()));
            jTCMPM.setText(String.valueOf(f.getCusto()));

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGGraficosI = new javax.swing.ButtonGroup();
        bGGraficosM = new javax.swing.ButtonGroup();
        Titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLPesquisar = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jCBFichaTecnica = new javax.swing.JComboBox<Object>();
        jPanel3 = new javax.swing.JPanel();
        jLCMP = new javax.swing.JLabel();
        jTCMP = new javax.swing.JTextField();
        jLFixo = new javax.swing.JLabel();
        jTFixo = new javax.swing.JTextField();
        jLQuantidade = new javax.swing.JLabel();
        jTQuantidade = new javax.swing.JTextField();
        jLResultadoCI = new javax.swing.JLabel();
        jTResultadoCI = new javax.swing.JTextField();
        jLPorcentagemLucro = new javax.swing.JLabel();
        jTPorcentagemLucro = new javax.swing.JTextField();
        jLPreco = new javax.swing.JLabel();
        jTPreco = new javax.swing.JTextField();
        jTVariavel = new javax.swing.JTextField();
        jLVariavel = new javax.swing.JLabel();
        jBCalcularCI = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBEmitirGraficosI = new javax.swing.JButton();
        jRPizza = new javax.swing.JRadioButton();
        jRBarras = new javax.swing.JRadioButton();
        jBEmitirGraficosI1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLCMPM = new javax.swing.JLabel();
        jTCMPM = new javax.swing.JTextField();
        jLQuantidadeM = new javax.swing.JLabel();
        jTQuantidadeM = new javax.swing.JTextField();
        jLResultadoCM = new javax.swing.JLabel();
        jTResultadoCM = new javax.swing.JTextField();
        jLPorcentagemLucroM = new javax.swing.JLabel();
        jTPorcentagemLucroM = new javax.swing.JTextField();
        jLPrecoM = new javax.swing.JLabel();
        jTPrecoM = new javax.swing.JTextField();
        jTVariavelM = new javax.swing.JTextField();
        jLVariavelM = new javax.swing.JLabel();
        jBCalcularCM = new javax.swing.JButton();
        jBEmitirGraficosM = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jRPizzaM = new javax.swing.JRadioButton();
        jRBarrasM = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Titulo.setText("Simulador de Custos");
        add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 11, -1, -1));

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 414, 105));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Custo Integral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLCMP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCMP.setText("Custo com materiais e processos:");
        jPanel3.add(jLCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, 20));

        jTCMP.setEditable(false);
        jPanel3.add(jTCMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 130, 30));

        jLFixo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLFixo.setText("Custos Fixos:");
        jPanel3.add(jLFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 20));

        jTFixo.setToolTipText("Digite o valor dos custos fixos");
        jTFixo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFixoKeyTyped(evt);
            }
        });
        jPanel3.add(jTFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, 30));

        jLQuantidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLQuantidade.setText("Quantidade:");
        jPanel3.add(jLQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 90, 20));

        jTQuantidade.setToolTipText("Digite a quantidade");
        jTQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTQuantidadeKeyTyped(evt);
            }
        });
        jPanel3.add(jTQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 70, 30));

        jLResultadoCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLResultadoCI.setText("O custo integral é de:");
        jPanel3.add(jLResultadoCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 30));

        jTResultadoCI.setEditable(false);
        jPanel3.add(jTResultadoCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 100, 30));

        jLPorcentagemLucro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPorcentagemLucro.setText("Porcentagem de lucro:");
        jPanel3.add(jLPorcentagemLucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, 30));

        jTPorcentagemLucro.setToolTipText("Digite a porcentagem de lucro desejada");
        jTPorcentagemLucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPorcentagemLucroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPorcentagemLucroKeyTyped(evt);
            }
        });
        jPanel3.add(jTPorcentagemLucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 70, 30));

        jLPreco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPreco.setText("O preço é de:");
        jPanel3.add(jLPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, 30));

        jTPreco.setEditable(false);
        jPanel3.add(jTPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 80, 30));

        jTVariavel.setToolTipText("Digite o valor com os custos variáveis ");
        jTVariavel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTVariavelKeyTyped(evt);
            }
        });
        jPanel3.add(jTVariavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, 30));

        jLVariavel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLVariavel.setText("Custos Variáveis:");
        jPanel3.add(jLVariavel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 120, 20));

        jBCalcularCI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBCalcularCI.setText("Calcular");
        jBCalcularCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularCIActionPerformed(evt);
            }
        });
        jPanel3.add(jBCalcularCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 630, 260));

        jBEmitirGraficosI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEmitirGraficosI.setText("Exibir Gráficos");
        jBEmitirGraficosI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmitirGraficosIActionPerformed(evt);
            }
        });
        jPanel3.add(jBEmitirGraficosI, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        bGGraficosI.add(jRPizza);
        jRPizza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRPizza.setText("Pizza");
        jPanel3.add(jRPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        bGGraficosI.add(jRBarras);
        jRBarras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRBarras.setText("Barras");
        jPanel3.add(jRBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jBEmitirGraficosI1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEmitirGraficosI1.setText("Emitir Relatório");
        jBEmitirGraficosI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmitirGraficosI1ActionPerformed(evt);
            }
        });
        jPanel3.add(jBEmitirGraficosI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 650, 580));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Custo Marginal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLCMPM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCMPM.setText("Custo com materiais e processos:");
        jPanel4.add(jLCMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, 20));

        jTCMPM.setEditable(false);
        jPanel4.add(jTCMPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 130, 30));

        jLQuantidadeM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLQuantidadeM.setText("Quantidade:");
        jPanel4.add(jLQuantidadeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 90, 20));

        jTQuantidadeM.setToolTipText("Digite a quantidade");
        jTQuantidadeM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTQuantidadeMKeyTyped(evt);
            }
        });
        jPanel4.add(jTQuantidadeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 100, 30));

        jLResultadoCM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLResultadoCM.setText("O custo integral é de:");
        jPanel4.add(jLResultadoCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 30));

        jTResultadoCM.setEditable(false);
        jPanel4.add(jTResultadoCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 100, 30));

        jLPorcentagemLucroM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPorcentagemLucroM.setText("Porcentagem de lucro:");
        jPanel4.add(jLPorcentagemLucroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 160, 30));

        jTPorcentagemLucroM.setToolTipText("Digite a porcentagem de lucro desejada");
        jTPorcentagemLucroM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPorcentagemLucroMKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPorcentagemLucroMKeyTyped(evt);
            }
        });
        jPanel4.add(jTPorcentagemLucroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 70, 30));

        jLPrecoM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrecoM.setText("O preço é de:");
        jPanel4.add(jLPrecoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 30));

        jTPrecoM.setEditable(false);
        jPanel4.add(jTPrecoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 80, 30));

        jTVariavelM.setToolTipText("Digite o valor dos custos variáveis");
        jTVariavelM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTVariavelMKeyTyped(evt);
            }
        });
        jPanel4.add(jTVariavelM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 100, 30));

        jLVariavelM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLVariavelM.setText("Custos Variáveis:");
        jPanel4.add(jLVariavelM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, 20));

        jBCalcularCM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBCalcularCM.setText("Calcular");
        jBCalcularCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularCMActionPerformed(evt);
            }
        });
        jPanel4.add(jBCalcularCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jBEmitirGraficosM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEmitirGraficosM.setText("Exibir Gráficos");
        jBEmitirGraficosM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmitirGraficosMActionPerformed(evt);
            }
        });
        jPanel4.add(jBEmitirGraficosM, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 630, 260));

        bGGraficosM.add(jRPizzaM);
        jRPizzaM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRPizzaM.setText("Pizza");
        jPanel4.add(jRPizzaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        bGGraficosM.add(jRBarrasM);
        jRBarrasM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRBarrasM.setText("Barras");
        jPanel4.add(jRBarrasM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Emitir Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 650, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased

        FichaTecnicaDAO ftDAO = new FichaTecnicaDAO();

        jCBFichaTecnica.removeAllItems();

        for (FichaTecnica ft : ftDAO.readWhere(jTPesquisar.getText())) {

            jCBFichaTecnica.addItem(ft);

        }
    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jCBFichaTecnicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBFichaTecnicaItemStateChanged

        System.out.println(jCBFichaTecnica.getItemCount());

        if (jCBFichaTecnica.getItemCount() >= 1) {

            FichaTecnica fichaTecnic = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

            this.id = fichaTecnic.getIdFichaTecnica();
            readJTableF(id);

            this.count++;

            if (this.count != 0) {

                if (jCBFichaTecnica.getItemCount() != 0) {

                    FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

                    this.id = fichaTecnica.getIdFichaTecnica();
                    readJTableF(id);

                    this.count++;

                } else {

                }

            } else {

                this.count++;
            }

        } else {

        }

    }//GEN-LAST:event_jCBFichaTecnicaItemStateChanged

    private void jBCalcularCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularCIActionPerformed

        if (jTCMP.getText().isEmpty() != true && jTFixo.getText().isEmpty() != true && jTVariavel.getText().isEmpty() != true && 
                jTQuantidade.getText().isEmpty() != true) {

            double fixo = Double.parseDouble(jTFixo.getText());
            double variavel = Double.parseDouble(jTVariavel.getText());
            int quantidade = Integer.parseInt(jTQuantidade.getText());
            double cmp = Double.parseDouble(jTCMP.getText());

            double custo = 0;

            custo = ((fixo + variavel + cmp) / quantidade);

            DFormat f = new DFormat();

            jTResultadoCI.setText(String.valueOf(f.dfFormat(this.casas, custo)));

        }else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBCalcularCIActionPerformed

    private void jTPorcentagemLucroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPorcentagemLucroKeyReleased

        if (jTPorcentagemLucro.getText().isEmpty() != true) {

            double preco = Double.parseDouble(jTResultadoCI.getText());
            double por = Double.parseDouble(jTPorcentagemLucro.getText());
            por = por / 100;

            preco += preco * por;

            DFormat f = new DFormat();

            jTPreco.setText(String.valueOf(f.dfFormat(this.casas, preco)));

        }

    }//GEN-LAST:event_jTPorcentagemLucroKeyReleased

    private void jTPorcentagemLucroMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPorcentagemLucroMKeyReleased

        if (jTPorcentagemLucroM.getText().isEmpty() != true) {

            double preco = Double.parseDouble(jTResultadoCM.getText());
            double por = Double.parseDouble(jTPorcentagemLucroM.getText());
            por = por / 100;

            preco += preco * por;

            DFormat f = new DFormat();

            jTPrecoM.setText(String.valueOf(f.dfFormat(this.casas, preco)));

        }

    }//GEN-LAST:event_jTPorcentagemLucroMKeyReleased

    private void jBCalcularCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularCMActionPerformed

        if (jTCMPM.getText().isEmpty() != true && jTVariavelM.getText().isEmpty() != true && jTQuantidadeM.getText().isEmpty() != true) {

            double variavel = Double.parseDouble(jTVariavelM.getText());
            int quantidade = Integer.parseInt(jTQuantidadeM.getText());
            double cmp = Double.parseDouble(jTCMPM.getText());

            double custo = 0;

            custo = ((variavel + cmp) / quantidade);

            DFormat f = new DFormat();

            jTResultadoCM.setText(String.valueOf(f.dfFormat(this.casas, custo)));

        } else {
            JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
        }

    }//GEN-LAST:event_jBCalcularCMActionPerformed

    private void jTFixoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFixoKeyTyped
        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_jTFixoKeyTyped

    private void jTVariavelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTVariavelKeyTyped
        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_jTVariavelKeyTyped

    private void jTQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQuantidadeKeyTyped
        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_jTQuantidadeKeyTyped

    private void jTPorcentagemLucroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPorcentagemLucroKeyTyped
        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_jTPorcentagemLucroKeyTyped

    private void jTVariavelMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTVariavelMKeyTyped

        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }

    }//GEN-LAST:event_jTVariavelMKeyTyped

    private void jTQuantidadeMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQuantidadeMKeyTyped
        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_jTQuantidadeMKeyTyped

    private void jTPorcentagemLucroMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPorcentagemLucroMKeyTyped

        String caracteres = "0987654321.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }

    }//GEN-LAST:event_jTPorcentagemLucroMKeyTyped

    private void jBEmitirGraficosIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmitirGraficosIActionPerformed

        if (jRBarras.isSelected()) {

            DefaultCategoryDataset barra = new DefaultCategoryDataset();
            barra.setValue(Double.parseDouble(jTCMP.getText()), "Custos com materiais e precessos", "");
            barra.setValue(Double.parseDouble(jTFixo.getText()), "Custos fixos", "");
            barra.setValue(Double.parseDouble(jTVariavel.getText()), "Custos variáveis", "");
            barra.setValue(Double.parseDouble(jTPreco.getText()) * Double.parseDouble(jTQuantidade.getText()), "Preço final", "");

            JFreeChart chart = ChartFactory.createBarChart3D("Gráfico de Barras", "", "Valor em reais", barra, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.WHITE);
            plot.setRangeGridlinePaint(Color.WHITE);
            plot.setOutlineVisible(false);

            CategoryPlot categoryPlot = chart.getCategoryPlot();
            CategoryItemRenderer renderer = categoryPlot.getRenderer();
            renderer.setSeriesPaint(0, new Color(30, 144, 255));
            renderer.setSeriesPaint(1, new Color(224, 255, 255));
            renderer.setSeriesPaint(2, new Color(220, 20, 60));
            renderer.setSeriesPaint(3, new Color(255, 0, 255));

            BarRenderer re = (BarRenderer) chart.getCategoryPlot().getRenderer();
            re.setItemMargin(-1.0);
            re.setBase(0.0);
            re.setMaximumBarWidth(.07);
            re.setItemLabelAnchorOffset(0.8);

            Dimension d = new Dimension(620, 250);

            ChartPanel painel = new ChartPanel(chart);
            painel.setPreferredSize(d);
            painel.setAutoscrolls(false);
            jScrollPane1.setAutoscrolls(false);

            jScrollPane1.setViewportView(painel);

        } else if (jRPizza.isSelected()) {

            DefaultPieDataset pizza = new DefaultPieDataset();

            pizza.setValue("Custos com materiais e precessos", Double.parseDouble(jTCMP.getText()));
            pizza.setValue("Custos fixos", Double.parseDouble(jTFixo.getText()));
            pizza.setValue("Custos variáveis", Double.parseDouble(jTVariavel.getText()));

            JFreeChart chart = ChartFactory.createPieChart3D("Gráfico de Pizza", pizza, true, true, false);

            PiePlot p = (PiePlot) chart.getPlot();
            p.setBackgroundPaint(null);

            p.setSectionPaint("Custos com materiais e precessos", new Color(25, 25, 112));
            p.setSectionPaint("Custos variáveis", new Color(0, 100, 0));
            p.setSectionPaint("Custos fixos", new Color(210, 105, 30));

            Dimension d = new Dimension(620, 250);

            ChartPanel painel = new ChartPanel(chart);
            painel.setPreferredSize(d);
            painel.setAutoscrolls(false);
            jScrollPane1.setAutoscrolls(false);

            jScrollPane1.setViewportView(painel);

        }

    }//GEN-LAST:event_jBEmitirGraficosIActionPerformed

    private void jBEmitirGraficosMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmitirGraficosMActionPerformed

        if (jRBarrasM.isSelected()) {

            DefaultCategoryDataset barra = new DefaultCategoryDataset();

            barra.setValue(Double.parseDouble(jTCMPM.getText()), "Custos com materiais e precessos", "");
            barra.setValue(Double.parseDouble(jTVariavelM.getText()), "Custos variáveis", "");
            barra.setValue(Double.parseDouble(jTPrecoM.getText()) * Double.parseDouble(jTQuantidadeM.getText()), "Preço final", "");

            JFreeChart chart = ChartFactory.createBarChart3D("Gráfico de Barras", "", "Valor em reais", barra, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.WHITE);
            plot.setRangeGridlinePaint(Color.WHITE);
            plot.setOutlineVisible(false);

            CategoryPlot categoryPlot = chart.getCategoryPlot();
            CategoryItemRenderer renderer = categoryPlot.getRenderer();
            renderer.setSeriesPaint(0, new Color(25, 25, 112));
            renderer.setSeriesPaint(1, new Color(0, 100, 0));
            renderer.setSeriesPaint(2, new Color(210, 105, 30));

            BarRenderer re = (BarRenderer) chart.getCategoryPlot().getRenderer();
            re.setItemMargin(-1.0);
            re.setBase(0.0);
            re.setMaximumBarWidth(.07);
            re.setItemLabelAnchorOffset(0.8);

            Dimension d = new Dimension(620, 250);

            ChartPanel painel = new ChartPanel(chart);
            painel.setPreferredSize(d);
            painel.setAutoscrolls(false);
            jScrollPane1.setAutoscrolls(false);

            System.out.println(painel.getSize());

            jScrollPane2.setViewportView(painel);

        } else if (jRPizzaM.isSelected()) {

            DefaultPieDataset pizza = new DefaultPieDataset();

            pizza.setValue("Custos com materiais e precessos", Double.parseDouble(jTCMPM.getText()));
            pizza.setValue("Custos variáveis", Double.parseDouble(jTVariavelM.getText()));

            JFreeChart chart = ChartFactory.createPieChart3D("Gráfico de Pizza", pizza, true, true, false);

            PiePlot p = (PiePlot) chart.getPlot();
            p.setBackgroundPaint(null);

            p.setSectionPaint("Custos com materiais e precessos", new Color(25, 25, 112));
            p.setSectionPaint("Custos variáveis", new Color(0, 100, 0));

            Dimension d = new Dimension(620, 250);

            ChartPanel painel = new ChartPanel(chart);
            painel.setPreferredSize(d);
            painel.setAutoscrolls(false);
            jScrollPane2.setAutoscrolls(false);

            jScrollPane2.setViewportView(painel);

        }

    }//GEN-LAST:event_jBEmitirGraficosMActionPerformed

    private void jBEmitirGraficosI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmitirGraficosI1ActionPerformed

        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        Connection con = ConnectionFactory.getConnection();

        InputStream reportFile = getClass().getResourceAsStream("/relatorios/SC.jasper");
       
        JasperPrint jp = null;
        
        try {
            HashMap parametros = new HashMap<>();
            parametros.put("id", fichaTecnica.getIdFichaTecnica());
            parametros.put("cf", jTFixo.getText());
            parametros.put("cv", jTVariavel.getText());
            parametros.put("q", jTQuantidade.getText());
            parametros.put("ci", jTResultadoCI.getText());
            parametros.put("p", jTPorcentagemLucro.getText());
            parametros.put("preco", jTPreco.getText());
            parametros.put("SUBREPORT_DIR", "/relatorios/");

            jp = JasperFillManager.fillReport(reportFile, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Relatorio Integral - Simulador de Custos");
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(MaterialREPORT.class.getResource("/imagens/real.png")));

            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(SimuladorCustosVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBEmitirGraficosI1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        FichaTecnica fichaTecnica = (FichaTecnica) jCBFichaTecnica.getSelectedItem();

        Connection con = ConnectionFactory.getConnection();

        InputStream reportFile = getClass().getResourceAsStream("/relatorios/SCm.jasper");
       
        JasperPrint jp = null;
        
        try {
            HashMap parametros = new HashMap<>();
            parametros.put("id", fichaTecnica.getIdFichaTecnica());
            parametros.put("cv", jTVariavel.getText());
            parametros.put("q", jTQuantidade.getText());
            parametros.put("cm", jTResultadoCI.getText());
            parametros.put("p", jTPorcentagemLucro.getText());
            parametros.put("preco", jTPreco.getText());
            parametros.put("SUBREPORT_DIR", "/relatorios/");

            jp = JasperFillManager.fillReport(reportFile, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Relatorio Marginal - Simulador de Custos");
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(MaterialREPORT.class.getResource("/imagens/real.png")));

            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(SimuladorCustosVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.ButtonGroup bGGraficosI;
    private javax.swing.ButtonGroup bGGraficosM;
    private javax.swing.JButton jBCalcularCI;
    private javax.swing.JButton jBCalcularCM;
    private javax.swing.JButton jBEmitirGraficosI;
    private javax.swing.JButton jBEmitirGraficosI1;
    private javax.swing.JButton jBEmitirGraficosM;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jCBFichaTecnica;
    private javax.swing.JLabel jLCMP;
    private javax.swing.JLabel jLCMPM;
    private javax.swing.JLabel jLFixo;
    private javax.swing.JLabel jLPesquisar;
    private javax.swing.JLabel jLPorcentagemLucro;
    private javax.swing.JLabel jLPorcentagemLucroM;
    private javax.swing.JLabel jLPreco;
    private javax.swing.JLabel jLPrecoM;
    private javax.swing.JLabel jLQuantidade;
    private javax.swing.JLabel jLQuantidadeM;
    private javax.swing.JLabel jLResultadoCI;
    private javax.swing.JLabel jLResultadoCM;
    private javax.swing.JLabel jLVariavel;
    private javax.swing.JLabel jLVariavelM;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRBarras;
    private javax.swing.JRadioButton jRBarrasM;
    private javax.swing.JRadioButton jRPizza;
    private javax.swing.JRadioButton jRPizzaM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCMP;
    private javax.swing.JTextField jTCMPM;
    private javax.swing.JTextField jTFixo;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPorcentagemLucro;
    private javax.swing.JTextField jTPorcentagemLucroM;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTextField jTPrecoM;
    private javax.swing.JTextField jTQuantidade;
    private javax.swing.JTextField jTQuantidadeM;
    private javax.swing.JTextField jTResultadoCI;
    private javax.swing.JTextField jTResultadoCM;
    private javax.swing.JTextField jTVariavel;
    private javax.swing.JTextField jTVariavelM;
    // End of variables declaration//GEN-END:variables
}
