package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PagamentoOperacaoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescontoPagamento;
	private JTextField txtFieldTotalPagamento;
	private JTextField txtFieldPagamento;
	private JTable tableModalidades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentoOperacaoUI frame = new PagamentoOperacaoUI();
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
	public PagamentoOperacaoUI() {
		setTitle("Realizar Pagamento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModalidadesPagamento = new JLabel("Modalidade:");
		lblModalidadesPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModalidadesPagamento.setBounds(32, 45, 141, 24);
		contentPane.add(lblModalidadesPagamento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(183, 45, 427, 25);
		contentPane.add(comboBox);
		
		JButton btnAdicionarModalidade = new JButton("Adicionar");
		btnAdicionarModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarModalidade.setBounds(469, 94, 141, 31);
		contentPane.add(btnAdicionarModalidade);
		
		JButton btnRemoverModalidade = new JButton("Remover");
		btnRemoverModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemoverModalidade.setBounds(469, 136, 141, 31);
		contentPane.add(btnRemoverModalidade);
		
		JLabel lblMesesPagamento = new JLabel("Meses:");
		lblMesesPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMesesPagamento.setBounds(47, 185, 87, 24);
		contentPane.add(lblMesesPagamento);
		
		JSpinner spinnerMesesPagamento = new JSpinner();
		spinnerMesesPagamento.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerMesesPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerMesesPagamento.setBounds(144, 186, 76, 24);
		contentPane.add(spinnerMesesPagamento);
		
		JLabel lblDescontoPagamento = new JLabel("Desconto:");
		lblDescontoPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescontoPagamento.setBounds(242, 185, 113, 24);
		contentPane.add(lblDescontoPagamento);
		
		textFieldDescontoPagamento = new JTextField();
		textFieldDescontoPagamento.setBounds(353, 178, 257, 31);
		contentPane.add(textFieldDescontoPagamento);
		textFieldDescontoPagamento.setColumns(10);
		
		JLabel lblTotalPagamento = new JLabel("Total:");
		lblTotalPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalPagamento.setBounds(47, 252, 70, 24);
		contentPane.add(lblTotalPagamento);
		
		txtFieldTotalPagamento = new JTextField();
		txtFieldTotalPagamento.setColumns(10);
		txtFieldTotalPagamento.setBounds(127, 245, 141, 31);
		contentPane.add(txtFieldTotalPagamento);
		
		JLabel lblDataPagamento = new JLabel("Data:");
		lblDataPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataPagamento.setBounds(47, 318, 70, 24);
		contentPane.add(lblDataPagamento);
		
		txtFieldPagamento = new JTextField();
		txtFieldPagamento.setColumns(10);
		txtFieldPagamento.setBounds(127, 311, 141, 31);
		contentPane.add(txtFieldPagamento);
		
		JButton btnCancelarPagamento = new JButton("Cancelar");
		btnCancelarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarPagamento.setBounds(484, 377, 127, 31);
		contentPane.add(btnCancelarPagamento);
		
		JButton BtnSalvarPagamento = new JButton("Salvar");
		BtnSalvarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		BtnSalvarPagamento.setBounds(329, 377, 127, 31);
		contentPane.add(BtnSalvarPagamento);
		
		JScrollPane scrollPaneModalidades = new JScrollPane();
		scrollPaneModalidades.setBounds(32, 94, 408, 70);
		contentPane.add(scrollPaneModalidades);
		
		tableModalidades = new JTable();
		scrollPaneModalidades.setViewportView(tableModalidades);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
	}
}
