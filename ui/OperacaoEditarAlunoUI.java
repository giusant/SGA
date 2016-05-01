package br.si.es.sga.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OperacaoEditarAlunoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeEditarAluno;
	private JTextField textFieldRuaEditarAluno;
	private JTextField textFieldNEditarAluno;
	private JTextField textFieldBairroEditarAluno;
	private JTextField EditarAluno;
	private JTextField textFieldCidadeEditarAluno;
	private JTextField textFieldEstadoEditarAluno;
	private JTextField textFieldComplementoEditarAluno;
	private JTextField textFieldTelefoneEditarAluno;
	private JTextField textFieldDataDeEntradaEditarAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacaoEditarAlunoUI frame = new OperacaoEditarAlunoUI();
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
	public OperacaoEditarAlunoUI() {
		setTitle("Editar Aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JLabel lblNomeEditarAluno = new JLabel("Nome:");
		lblNomeEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeEditarAluno.setBounds(41, 59, 77, 25);
		contentPane.add(lblNomeEditarAluno);
		
		textFieldNomeEditarAluno = new JTextField();
		textFieldNomeEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeEditarAluno.setBounds(127, 59, 613, 26);
		contentPane.add(textFieldNomeEditarAluno);
		textFieldNomeEditarAluno.setColumns(10);
		
		JLabel lblSexoEditarAluno = new JLabel("Sexo:");
		lblSexoEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSexoEditarAluno.setBounds(41, 118, 77, 25);
		contentPane.add(lblSexoEditarAluno);
		
		JRadioButton rdbtnMEditarAluno = new JRadioButton("M");
		rdbtnMEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMEditarAluno.setBounds(159, 117, 52, 28);
		contentPane.add(rdbtnMEditarAluno);
		
		JRadioButton rdbtnFEditarAluno = new JRadioButton("F");
		rdbtnFEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFEditarAluno.setBounds(267, 117, 52, 28);
		contentPane.add(rdbtnFEditarAluno);
		
		JLabel lblEnderecoEditarAluno = new JLabel("Endere\u00E7o");
		lblEnderecoEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnderecoEditarAluno.setBounds(41, 168, 101, 25);
		contentPane.add(lblEnderecoEditarAluno);
		
		JLabel lblRuaEditarAluno = new JLabel("Rua:");
		lblRuaEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRuaEditarAluno.setBounds(41, 215, 61, 19);
		contentPane.add(lblRuaEditarAluno);
		
		textFieldRuaEditarAluno = new JTextField();
		textFieldRuaEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldRuaEditarAluno.setColumns(10);
		textFieldRuaEditarAluno.setBounds(101, 212, 384, 26);
		contentPane.add(textFieldRuaEditarAluno);
		
		JLabel lblNEditarAluno = new JLabel("N\u00BA:");
		lblNEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNEditarAluno.setBounds(502, 211, 46, 27);
		contentPane.add(lblNEditarAluno);
		
		textFieldNEditarAluno = new JTextField();
		textFieldNEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNEditarAluno.setColumns(10);
		textFieldNEditarAluno.setBounds(550, 212, 127, 26);
		contentPane.add(textFieldNEditarAluno);
		
		JLabel lblBairroEditarAluno = new JLabel("Bairro:");
		lblBairroEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBairroEditarAluno.setBounds(41, 268, 77, 25);
		contentPane.add(lblBairroEditarAluno);
		
		textFieldBairroEditarAluno = new JTextField();
		textFieldBairroEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldBairroEditarAluno.setColumns(10);
		textFieldBairroEditarAluno.setBounds(117, 268, 368, 26);
		contentPane.add(textFieldBairroEditarAluno);
		
		JLabel lblCepEditarAluno = new JLabel("CEP:");
		lblCepEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCepEditarAluno.setBounds(502, 268, 52, 25);
		contentPane.add(lblCepEditarAluno);
		
		EditarAluno = new JTextField();
		EditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EditarAluno.setColumns(10);
		EditarAluno.setBounds(550, 268, 127, 26);
		contentPane.add(EditarAluno);
		
		JLabel lblCidadeEditarAluno = new JLabel("Cidade:");
		lblCidadeEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCidadeEditarAluno.setBounds(41, 320, 77, 26);
		contentPane.add(lblCidadeEditarAluno);
		
		textFieldCidadeEditarAluno = new JTextField();
		textFieldCidadeEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCidadeEditarAluno.setColumns(10);
		textFieldCidadeEditarAluno.setBounds(127, 320, 230, 26);
		contentPane.add(textFieldCidadeEditarAluno);
		
		JLabel lblEstadoEditarAluno = new JLabel("Estado:");
		lblEstadoEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEstadoEditarAluno.setBounds(396, 321, 77, 25);
		contentPane.add(lblEstadoEditarAluno);
		
		textFieldEstadoEditarAluno = new JTextField();
		textFieldEstadoEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEstadoEditarAluno.setColumns(10);
		textFieldEstadoEditarAluno.setBounds(482, 320, 194, 26);
		contentPane.add(textFieldEstadoEditarAluno);
		
		JLabel lblComplementoEditarAluno = new JLabel("Complemento:");
		lblComplementoEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComplementoEditarAluno.setBounds(41, 381, 154, 25);
		contentPane.add(lblComplementoEditarAluno);
		
		textFieldComplementoEditarAluno = new JTextField();
		textFieldComplementoEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldComplementoEditarAluno.setColumns(10);
		textFieldComplementoEditarAluno.setBounds(198, 380, 479, 26);
		contentPane.add(textFieldComplementoEditarAluno);
		
		JLabel lblTelefoneEditarAluno = new JLabel("Telefone:");
		lblTelefoneEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelefoneEditarAluno.setBounds(41, 469, 101, 25);
		contentPane.add(lblTelefoneEditarAluno);
		
		textFieldTelefoneEditarAluno = new JTextField();
		textFieldTelefoneEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldTelefoneEditarAluno.setColumns(10);
		textFieldTelefoneEditarAluno.setBounds(152, 469, 218, 26);
		contentPane.add(textFieldTelefoneEditarAluno);
		
		JLabel lblDataDeEntradaEditarAluno = new JLabel("Data de Entrada:");
		lblDataDeEntradaEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataDeEntradaEditarAluno.setBounds(396, 469, 180, 25);
		contentPane.add(lblDataDeEntradaEditarAluno);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 155, 699, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 434, 699, 2);
		contentPane.add(separator_1);
		
		textFieldDataDeEntradaEditarAluno = new JTextField();
		textFieldDataDeEntradaEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDataDeEntradaEditarAluno.setColumns(10);
		textFieldDataDeEntradaEditarAluno.setBounds(585, 469, 127, 26);
		contentPane.add(textFieldDataDeEntradaEditarAluno);
		
		JButton btnSalvarEditarAluno = new JButton("Salvar");
		btnSalvarEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarEditarAluno.setBounds(211, 561, 111, 31);
		contentPane.add(btnSalvarEditarAluno);
		
		JButton btnCancelarEditarAluno = new JButton("Cancelar");
		btnCancelarEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarEditarAluno.setBounds(379, 561, 127, 31);
		contentPane.add(btnCancelarEditarAluno);
		
		JButton btnTirarFotoEditarAluno = new JButton("Tirar foto");
		btnTirarFotoEditarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTirarFotoEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTirarFotoEditarAluno.setBounds(899, 359, 127, 23);
		contentPane.add(btnTirarFotoEditarAluno);
		
		JLabel lblFotoEditarAluno = new JLabel("Foto");
		lblFotoEditarAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoEditarAluno.setBounds(852, 79, 213, 251);
		contentPane.add(lblFotoEditarAluno);
		this.setLocationRelativeTo(null);
	}

}
