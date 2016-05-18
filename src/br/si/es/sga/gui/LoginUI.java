package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JPasswordField;

import br.si.es.sga.dao.UsuarioDAO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.PersistenciaException;
import br.si.es.sga.jdbc.ConexaoUtil;
import br.si.es.sga.util.MessageUtil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JPasswordField textFieldSenha;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	static String UsuarioAtual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setResizable(false);
		setTitle("SGA - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 268);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		ImageIcon imageIcon = new ImageIcon(LoginUI.class.getResource("/ImagemLogin.jpg"));
	    ImageIcon imageIcon2 = new ImageIcon(LoginUI.class.getResource("/nome2.png"));
	    
	    
	    JLabel labelPrimeiroUsuario = new JLabel(imageIcon);
	    labelPrimeiroUsuario.setBounds(247, 51, 199, 177);
	    contentPane.add(labelPrimeiroUsuario);
		
	    JButton btnCadastro = new JButton("Cadastro");
	    btnCadastro.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CadastroFuncionarioUI cadastrofuncionario = new CadastroFuncionarioUI();
	    		cadastrofuncionario.setVisible(true);
	    	}
	    });
		btnCadastro.setBounds(345, 11, 89, 23);
		contentPane.add(btnCadastro);
		btnCadastro.setVisible(false);
		
		JLabel lblPrimeiroUsuario = new JLabel("1\u00BA Usu\u00E1rio");
		lblPrimeiroUsuario.setBounds(247, 15, 88, 14);
		contentPane.add(lblPrimeiroUsuario);
		lblPrimeiroUsuario.setVisible(false);
		
		try {
		List<UsuarioDTO> listaUsuario;
			listaUsuario = usuarioDAO.listarTodos();
		if(listaUsuario.isEmpty() ){
			lblPrimeiroUsuario.setVisible(true);
			btnCadastro.setVisible(true);
		}
		} catch (PersistenciaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	    JButton btnConfimar = new JButton("Confirmar");
	    
	    btnConfimar.setMnemonic('C');
	    btnConfimar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		String login = textFieldLogin.getText();
	    		String senha = String.valueOf(textFieldSenha.getPassword());
	    		
	    		try {
	    			
	    				UsuarioDTO usuarioBuscado = usuarioDAO.buscarPorLogin(login);
	    				if(usuarioBuscado ==  null){
	    					MessageUtil.addMsg(LoginUI.this, "Usuário inexistente");
	    				}
	    				if(usuarioBuscado.getSenha().equals(senha)){
	    					UsuarioAtual = usuarioBuscado.getLogin(); 
	    					TelaPrincipalUI telaprincipal = new TelaPrincipalUI();
	    					telaprincipal.setVisible(true);
	    					textFieldLogin.setText("");
	    					textFieldSenha.setText("");
	    					dispose();
	    				}else{
	    					MessageUtil.addMsg(LoginUI.this, "Senha incorreta");
	    					textFieldLogin.setText("");
	    					textFieldSenha.setText("");
	    				}
	    			}
	    		catch (PersistenciaException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			}
	    });
		btnConfimar.setBounds(23, 94, 100, 23);
		contentPane.add(btnConfimar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldLogin.setText("");
				textFieldSenha.setText("");
			}
		});
		btnCancelar.setBounds(137, 94, 100, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblLogin = new JLabel("Usu\u00E1rio:");
		lblLogin.setBounds(19, 31, 50, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(19, 60, 50, 14);
		contentPane.add(lblSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(79, 28, 158, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(79, 57, 158, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(imageIcon2);
		label_1.setBounds(10, 128, 233, 100);
		contentPane.add(label_1);
		
		
	}
	public void Atualizar(){
		LoginUI.this.dispose();
		main(null);
	}
}