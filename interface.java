package com.mycompany.telamain;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


 
public class TelaMain extends JFrame implements ActionListener {

 private JFrame frame;
 private JTextField textField;
 private JTextField textField_1;
 private JTextField textField_2;
 private JTextField textField_3;
 private JTextField textField_4;
 private JTextField textField_5;
 private JButton btnNewButton;
 private JComboBox comboBox;

 public static void main(String[] args) {
 
     TelaMain window = new TelaMain();
 }


 public TelaMain() {
  initialize();
 }

 private void initialize() {
 
  JFrame frame = new JFrame();
  frame.setBackground(Color.DARK_GRAY);
  frame.setLocationRelativeTo(null);
  frame.setSize(600, 500);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Tela de Cadastro");
        frame.setResizable(false);

      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 204, 204)); // Rosa pastel
      panel.setLayout(null);
     
      frame.getContentPane().add(panel);

     
      JLabel lblNewLabel = new JLabel ("Cadastro de Clientes");
      lblNewLabel.setForeground(Color.WHITE);
      lblNewLabel.setFont(new Font ("Tahoma", Font.PLAIN, 20));
      lblNewLabel.setBounds(203, 33, 186, 23);
      panel.add(lblNewLabel);
     
      JLabel lblNewLabel_1 = new JLabel("Nome:");
      lblNewLabel_1.setForeground(Color.WHITE);
      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel_1.setBounds(150,66,123,14);
      panel.add(lblNewLabel_1);
     
     
      comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[]
       {"Paraná", "Minas Gerais", "Rio de Janeiro", "São Paulo"}));
      comboBox.setBounds(160, 204, 138, 22);
      panel.add(comboBox);
     
     
      ButtonGroup bg = new ButtonGroup();
     
      JRadioButton rdbtnNewRadioButton = new JRadioButton("Brasileiro(a)", false);
     
      rdbtnNewRadioButton.setForeground(Color.WHITE);
      rdbtnNewRadioButton.setBackground(Color.GRAY);
      rdbtnNewRadioButton.setBounds(430, 204, 140, 23);
     
      JRadioButton rdbtnEstrangeiro = new JRadioButton("Estrangeiro(a)", false);
     
      rdbtnEstrangeiro.setForeground(Color.WHITE);
      rdbtnEstrangeiro.setBackground(Color.GRAY);
      rdbtnEstrangeiro.setBounds(430,235,140,23);
     
      bg.add(rdbtnEstrangeiro);
      bg.add(rdbtnNewRadioButton);
     
      panel.add(rdbtnEstrangeiro);
      panel.add(rdbtnNewRadioButton);      
     
      JTextArea textArea = new JTextArea();
      textArea.setBounds(50, 288, 173, 149);
      panel.add(textArea);
       
     
      JCheckBox chckbxNewCheckBox = new JCheckBox("Receber notificações de promoções");
      chckbxNewCheckBox.setBackground(new Color(255, 204, 204));
      chckbxNewCheckBox.setForeground(Color.WHITE);
      chckbxNewCheckBox.setBounds(280, 300, 300, 23);
      panel.add(chckbxNewCheckBox);
     
      JCheckBox chckbxNotificacaoDeNovos = new JCheckBox("Receber noticifições de novos produtos");
      chckbxNotificacaoDeNovos.setForeground(Color.WHITE);
      chckbxNotificacaoDeNovos.setBackground(new Color(255, 204, 204));
      chckbxNotificacaoDeNovos.setBounds(280, 330, 300, 23);
      panel.add(chckbxNotificacaoDeNovos);
     
   // Botao tela principal
      btnNewButton = new JButton ("Cadastrar");
      btnNewButton.setBounds(200, 150, 106, 23);
             btnNewButton.addActionListener(this);
      panel.add(btnNewButton);


 
   // Botao para limpar em tela principal
   JButton btnNewButton_1 = new JButton("Limpar");
   btnNewButton_1.setBounds(325, 150, 106, 23);
   panel.add(btnNewButton_1);
   // Funcao do botao limpar
         btnNewButton_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     textField_3.setText("");
     textField_4.setText("");
     textArea.setText("");
     chckbxNewCheckBox.setSelected(false);
     chckbxNotificacaoDeNovos.setSelected(false);
     bg.clearSelection();
     comboBox.setSelectedIndex(0);;
    }
});
      // Criaçao da barra de menu
      JMenuBar menuBar = new JMenuBar();
      menuBar.setBackground(new Color(255, 204, 204));
      menuBar.setBounds(0, 0, 600, 22);
      panel.add(menuBar);
     
      JMenu mnNewMenu = new JMenu("Menu");
      mnNewMenu.setForeground(Color.WHITE);
      mnNewMenu.setBackground(Color.DARK_GRAY);
      menuBar.add(mnNewMenu);

      //Criaçao do itens do menu
      JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
      mnNewMenu.add(itemCadastrar);

   itemCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verifica se todos os campos estão completos
                boolean allFieldsFilled = !textField_3.getText().isEmpty() &&
                                          !textField_4.getText().isEmpty() &&
                                          !textArea.getText().isEmpty() &&                                          
                                          bg.getSelection() != null &&
                                          comboBox.getSelectedIndex() != -1;;
                // Mensagem do sistema
                if (allFieldsFilled) {
                    JOptionPane.showMessageDialog(frame, "Cadastro Concluído!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos!");
                }
            }
        });

      JMenuItem itemLimpar = new JMenuItem("Limpar");
      mnNewMenu.add(itemLimpar);
         itemLimpar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    textField_3.setText("");
    textField_4.setText("");
    textArea.setText("");
    chckbxNewCheckBox.setSelected(false);
    chckbxNotificacaoDeNovos.setSelected(false);

   }
  });
         
      JMenuItem itemSair = new JMenuItem("Sair");
      mnNewMenu.add(itemSair);
   itemSair.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);
   }
  });
       
     
 
      textField_3 = new JTextField();
      textField_3.setBounds(230, 66, 278, 19);
      panel.add(textField_3);
      textField_3.setColumns(10);
     
      textField_4 = new JTextField();
      textField_4.setBounds(230, 99, 278, 19);
      panel.add(textField_4);
      textField_4.setColumns(10);
     
      JLabel lblNewLabel_3 = new JLabel("Endereço: ");
      lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel_3.setForeground(new Color(255, 255, 255));
      lblNewLabel_3.setBounds(150, 100, 106, 20);
      panel.add(lblNewLabel_3);
     
   JLabel lblNewLabel_5 = new JLabel("Estado:");
      lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel_5.setForeground(new Color(255, 255, 255));
      lblNewLabel_5.setBounds(100, 207, 91, 13);
      panel.add(lblNewLabel_5);
     
      JLabel lblNewLabel_6 = new JLabel("Nacionalidade:");
      lblNewLabel_6.setForeground(new Color(255, 255, 255));
      lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel_6.setBounds(320, 207, 150, 13);
      panel.add(lblNewLabel_6);
     
      JLabel lblNewLabel_7 = new JLabel("Deixe sua Sugestão:");
      lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
      lblNewLabel_7.setForeground(new Color(255, 255, 255));
      lblNewLabel_7.setBounds(50, 260, 213, 20);
      panel.add(lblNewLabel_7);
   
     
      frame.setVisible(true);      
     
      }
   public void actionPerformed(ActionEvent e){
   if (e.getSource() == btnNewButton) {
    String texto = textField_3.getText();
    JOptionPane.showMessageDialog(this, "Nome digitado:"+texto);
                                String selecionado = (String) comboBox.getSelectedItem();
                                JOptionPane.showConfirmDialog(this,"Texto:"+ texto + "," + selecionado );
   
   }
  }
}
