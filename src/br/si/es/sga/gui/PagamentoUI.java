package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PagamentoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableAlunos;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentoUI frame = new PagamentoUI();
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
	public PagamentoUI() {
		setTitle("Pagamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Mensalidade", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAlunosPagMensalidade = new JLabel("Aluno:");
		lblAlunosPagMensalidade.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAlunosPagMensalidade.setBounds(41, 25, 135, 23);
		panel.add(lblAlunosPagMensalidade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 123, 615, 2);
		panel.add(separator);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(41, 70, 479, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarAlunos = new JButton("Pesquisar");
		btnBuscarAlunos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarAlunos.setBounds(526, 70, 135, 29);
		panel.add(btnBuscarAlunos);
		
		tableAlunos = new JTable();
		tableAlunos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableAlunos.setBounds(41, 150, 615, 217);
		panel.add(tableAlunos);
		
		JButton btnRealizarPagamento = new JButton("Realizar Pagamento");
		btnRealizarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRealizarPagamento){
					PagamentoOperacaoUI pagamentooperacao = new PagamentoOperacaoUI();
					pagamentooperacao.setVisible(true);
				}
			}
		});
		btnRealizarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRealizarPagamento.setBounds(243, 383, 247, 29);
		panel.add(btnRealizarPagamento);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Di\u00E1ria", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblRegistrarNovaDiaria = new JLabel("Registrar nova di\u00E1ria no valor de: ");
		lblRegistrarNovaDiaria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarNovaDiaria.setBounds(127, 142, 354, 30);
		panel_1.add(lblRegistrarNovaDiaria);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(491, 142, 140, 30);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdicionarDiaria = new JButton("Adicionar");
		btnAdicionarDiaria.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarDiaria.setBounds(239, 223, 126, 30);
		panel_1.add(btnAdicionarDiaria);
		
		JButton btnCancelarDiaria = new JButton("Cancelar");
		btnCancelarDiaria.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarDiaria.setBounds(426, 223, 126, 30);
		panel_1.add(btnCancelarDiaria);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
	}
}
