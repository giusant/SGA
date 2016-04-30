package br.si.es.sga.ui;

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
		setTitle("Tela Principal - SGA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 376);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);	
		
		ImageIcon imageIcon = new ImageIcon("img/add1.png");

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
		mnArquivo.add(mntmSair);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mnCadastro.add(mntmAluno);
		
		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
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
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnPagamento.add(mntmNovo);
		
		JMenuItem mntmConsultarPagamento = new JMenuItem("Consultar Pagamento");
		mnPagamento.add(mntmConsultarPagamento);
		
		JMenu mnDiria = new JMenu("Di\u00E1ria");
		menuBar.add(mnDiria);
		
		JMenuItem mntmNovaDiria = new JMenuItem("Nova Di\u00E1ria");
		mnDiria.add(mntmNovaDiria);
		
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
		
				
		JLabel lblCadastrarFuncionrio = new JLabel("Cadastrar Funcion\u00E1rio");
		lblCadastrarFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastrarFuncionrio.setBounds(130, 160, 229, 32);
		lblCadastrarFuncionrio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblCadastrarFuncionrio);
		
		lblCadastrarFuncionrio.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		    	if(e.getSource() == lblCadastrarFuncionrio){	       
		    	CadastroFuncionarioUI cadastrofuncionario = new CadastroFuncionarioUI();
		    	cadastrofuncionario.setVisible(true);
		    }
		    }  
		}); 
		
		JLabel lblNovaDiaria = new JLabel("Nova Di\u00E1ria");
		lblNovaDiaria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNovaDiaria.setBounds(130, 218, 129, 32);
		lblNovaDiaria.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblNovaDiaria);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Eleandro\\Dropbox\\SGA\\Dynamic-Logo-Transparente-White_1 (1).png"));
		label.setBounds(576, 139, 598, 511);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Eleandro\\Dropbox\\SGA\\nome2.png"));
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
