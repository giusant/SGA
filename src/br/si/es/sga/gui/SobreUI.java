package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SobreUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreUI frame = new SobreUI();
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
	public SobreUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 114);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JLabel lblSoftwareParaGerenciamento = new JLabel();
		contentPane.add(lblSoftwareParaGerenciamento, BorderLayout.NORTH);
		lblSoftwareParaGerenciamento.setText("<html>Software para gerenciamento de academia - SGA <br/>\r\n "
				+ "Desenvolvido por: Giuliano Martins de Sena Santiago e Eleandro Rodrigues da Silva Filho <br/> \r\n "
				+ "Colabora\u00E7\u00E3o: Max Willian Soares de Lima <br/> \r\n "
				+ "Rio Branco - AC</html>");
	}

}
