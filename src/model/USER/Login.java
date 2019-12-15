
package model.USER;

import hashing.HashFactory;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BEAN.Usuario;
import model.DAO.UsuarioDAO;
import model.VIEW.Home;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        
        setTitle("Login");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagens/real.png")));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jLSenha = new javax.swing.JLabel();
        jTUsuario = new javax.swing.JTextField();
        jBEntrar = new javax.swing.JButton();
        jLCadastro = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setText("Login");

        jLUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLUsuario.setText("Usuário:");

        jLSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLSenha.setText("Senha");

        jTUsuario.setToolTipText("Digite o nome de usuário");
        jTUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTUsuarioKeyTyped(evt);
            }
        });

        jBEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBEntrar.setText("Entrar");
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jLCadastro.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLCadastro.setText("Não possui conta? Crie uma");
        jLCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCadastroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCadastroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCadastroMouseExited(evt);
            }
        });

        jPSenha.setText("jPasswordField1");
        jPSenha.setToolTipText("Digite a senha");
        jPSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPSenhaFocusLost(evt);
            }
        });
        jPSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPSenhaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jBEntrar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPSenha))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLUsuario)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(titulo)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(titulo)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLUsuario)
                    .addComponent(jTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBEntrar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastroMouseClicked
        
        new CreateAccount().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLCadastroMouseClicked

    private void jLCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastroMouseEntered
        jLCadastro.setForeground(Color.red);
    }//GEN-LAST:event_jLCadastroMouseEntered

    private void jLCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastroMouseExited
        jLCadastro.setForeground(Color.black);
    }//GEN-LAST:event_jLCadastroMouseExited

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        
        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        for (Usuario u : uDAO.readWhere(jTUsuario.getText())){

            u.getIdUsuario();
            u.getNome();
            u.getSenha();
            
            usuario.setIdUsuario(u.getIdUsuario());
            usuario.setNome(u.getNome());
            usuario.setSenha(u.getSenha());
            
            //System.out.println(usuario.getSenha());

        }
 
        HashFactory hash = new HashFactory();
        boolean matched = true;
        
        if (usuario.getSenha().isEmpty() != true){
            
            try {
                matched = hash.validatePassword(Arrays.toString(jPSenha.getPassword()), usuario.getSenha());
                    System.out.println(matched);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }else {
            matched = false;
        }
        
        if (matched == true){
            
            new Home().setVisible(true);
            this.dispose();
            
        } else if (matched == false){
            
            jTUsuario.setForeground(Color.red);
            jPSenha.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, "Senha ou Usuários Incorretos");
            
        } else {
            
        }
        
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jPSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPSenhaFocusGained
       
        jPSenha.setText("");
        
    }//GEN-LAST:event_jPSenhaFocusGained

    private void jPSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPSenhaFocusLost
        
        if(jPSenha.getPassword() != null){       
            
        } else {
            jPSenha.setText("**************");
        }
        
    }//GEN-LAST:event_jPSenhaFocusLost

    private void jTUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuarioKeyTyped
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            
            jPSenha.requestFocus();
            
        }
        
    }//GEN-LAST:event_jTUsuarioKeyTyped

    private void jPSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaKeyTyped
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER){
            
            jBEntrar.doClick();
            
        }
        
    }//GEN-LAST:event_jPSenhaKeyTyped

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JLabel jLCadastro;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTUsuario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
