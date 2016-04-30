package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import br.si.es.sga.jdbc.ConexaoUtil;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

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
		
		ImageIcon imageIcon = new ImageIcon("img/ImagemLogin.jpg");
		ImageIcon imageIcon2 = new ImageIcon("img/nome2.png");
		
		
		JLabel label = new JLabel(imageIcon);
		label.setBounds(247, 51, 199, 177);
		contentPane.add(label);
		
		JButton btnConfimar = new JButton("Confimar");
		btnConfimar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaPrincipalUI telaprincipal = new TelaPrincipalUI();
				telaprincipal.setVisible(true);
			}
		});
		btnConfimar.setBounds(23, 94, 100, 23);
		contentPane.add(btnConfimar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnCancelar.setBounds(137, 94, 100, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(19, 31, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(19, 60, 50, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(79, 28, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(79, 57, 158, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel(imageIcon2);
		label_1.setBounds(10, 128, 233, 100);
		contentPane.add(label_1);
	}
}
