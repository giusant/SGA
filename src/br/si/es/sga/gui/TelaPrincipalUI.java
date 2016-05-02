package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.Icon;

public class TelaPrincipalUI extends JFrame implements MouseListener {

  private JPanel contentPane;
  /**
   * @wbp.nonvisual location=59,129
   */
  
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          TelaPrincipalUI frame = new TelaPrincipalUI();
          frame.setVisible(true);
          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public TelaPrincipalUI() {
    setResizable(false);
    setTitle("Tela Principal - SGA" + " - Usuário: "+ LoginUI.UsuarioAtual);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 583, 376);
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setForeground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    this.setSize(1200, 700);
    this.setLocationRelativeTo(null);  
    
    ImageIcon imageIcon = new ImageIcon(TelaPrincipalUI.class.getResource("/add1.png"));
    ImageIcon imageIcon2 = new ImageIcon(TelaPrincipalUI.class.getResource("/TelaInicial2.png"));  
    ImageIcon imageIcon3 = new ImageIcon(TelaPrincipalUI.class.getResource("/nome2.png"));

    JLabel image = new JLabel(imageIcon);
    image.setBounds(70, 90, 50, 50);
    contentPane.add(image);    
    
    JLabel image2 = new JLabel(imageIcon);
    image2.setBounds(70, 150, 50, 50);
    contentPane.add(image2);
    
    JLabel image3 = new JLabel(imageIcon);
    image3.setBounds(70, 211, 50, 50);
    contentPane.add(image3);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBounds(0, 0, 1194, 21);
    contentPane.add(menuBar);
    
    JMenu mnArquivo = new JMenu("Arquivo");
    menuBar.add(mnArquivo);
    
    JMenuItem mntmSair = new JMenuItem("Sair");
    mntmSair.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		TelaPrincipalUI.this.dispose();
    		LoginUI loginUI = new LoginUI();
    		loginUI.Atualizar();
    	}
    });
    mnArquivo.add(mntmSair);
    
    JMenu mnCadastro = new JMenu("Cadastro");
    menuBar.add(mnCadastro);
    
    JMenuItem mntmAluno = new JMenuItem("Aluno");
    mntmAluno.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mntmAluno){
          CadastroAlunoUI cadastroaluno = new CadastroAlunoUI();
          cadastroaluno.setVisible(true);
        }
      }
    });
    mnCadastro.add(mntmAluno);
    
    JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
    mntmFuncionrio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mntmFuncionrio){
          CadastroFuncionarioUI cadastroFuncionario = new CadastroFuncionarioUI();
          cadastroFuncionario.setVisible(true);
        }
      }
    });
    mnCadastro.add(mntmFuncionrio);
    
    JMenuItem mntmModalidade = new JMenuItem("Modalidade");
    mntmModalidade.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mntmModalidade){
          CadastroModalidadeUI cadastromodalidade = new CadastroModalidadeUI();
          cadastromodalidade.setVisible(true);
        }
      }
    });
    mnCadastro.add(mntmModalidade);
    
    JMenu mnPagamento = new JMenu("Pagamento");
    menuBar.add(mnPagamento);
    
    JMenuItem mntmNovoPagamento = new JMenuItem("Novo");
    mntmNovoPagamento.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mntmNovoPagamento){
              PagamentoUI pagamento = new PagamentoUI();
              pagamento.setVisible(true);
            }
          }
        });
        mnPagamento.add(mntmNovoPagamento);
        
        JMenuItem mntmConsultarPagamento = new JMenuItem("Consultar Pagamentos");
        mnPagamento.add(mntmConsultarPagamento);
        
        JMenu mnNotificaes = new JMenu("Notifica\u00E7\u00F5es");
        menuBar.add(mnNotificaes);
        
        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar.add(mnAjuda);
        
        JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
        lblCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCadastrarAluno.setBounds(130, 100, 170, 32);
        lblCadastrarAluno.setCursor(new Cursor(Cursor.HAND_CURSOR));   //"hiperlink" na label
        contentPane.add(lblCadastrarAluno);
        lblCadastrarAluno.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
              if(e.getSource() == lblCadastrarAluno){         
              CadastroAlunoUI cadastroAluno = new CadastroAlunoUI();
              cadastroAluno.setVisible(true);
            }
            }  
        }); 
        
            
        JLabel lblCadastrarFuncionario = new JLabel("Cadastrar Funcion\u00E1rio");
        lblCadastrarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCadastrarFuncionario.setBounds(130, 160, 229, 32);
        lblCadastrarFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(lblCadastrarFuncionario);
        
        lblCadastrarFuncionario.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
              if(e.getSource() == lblCadastrarFuncionario){         
              CadastroFuncionarioUI cadastrofuncionario = new CadastroFuncionarioUI();
              cadastrofuncionario.setVisible(true);
            }
            }  
        }); 
        
        JLabel lblNovoPagamento = new JLabel("Novo Pagamento");
        lblNovoPagamento.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if(e.getSource() == lblNovoPagamento){
              PagamentoUI pagamento = new PagamentoUI();
              pagamento.setVisible(true);
            }
          }      
        });
        lblNovoPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNovoPagamento.setBounds(130, 218, 181, 32);
        lblNovoPagamento.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(lblNovoPagamento);
        
        JLabel labelTelaInicial = new JLabel("");
        labelTelaInicial.setIcon(imageIcon2);
        labelTelaInicial.setBounds(576, 139, 598, 511);
        contentPane.add(labelTelaInicial);
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(imageIcon3);
        label_1.setBounds(86, 458, 247, 94);
        contentPane.add(label_1);
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
    }
  