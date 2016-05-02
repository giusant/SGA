package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.EnderecoDTO;
import br.si.es.sga.dto.UsuarioDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AlunoLogic;
import br.si.es.sga.util.MessageUtil;

import javax.swing.ButtonGroup;

public class OperacaoEditarAlunoUI extends JFrame {
	private DateFormat dateFormtUI = new SimpleDateFormat("dd/MM/yyyy");
	//private DateFormat dateFormtBD = new SimpleDateFormat("YYYY/MM/DD");
	private JPanel contentPane;
	private JTextField textFieldNomeEditarAluno;
	private JTextField textFieldRuaEditarAluno;
	private JTextField textFieldNEditarAluno;
	private JTextField textFieldBairroEditarAluno;
	private JTextField textFieldCepEditarAluno;
	private JTextField textFieldCidadeEditarAluno;
	private JTextField textFieldEstadoEditarAluno;
	private JTextField textFieldComplementoEditarAluno;
	private JTextField textFieldTelefoneEditarAluno;
	private JFormattedTextField textFieldDataDeNascEditarAluno;
	private final ButtonGroup buttonGroupAlunoEditar = new ButtonGroup();
	JRadioButton rdbtnMEditarAluno;
	JRadioButton rdbtnFEditarAluno;
	private int idAlunoAtual;
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
		
		rdbtnMEditarAluno = new JRadioButton("M");
		buttonGroupAlunoEditar.add(rdbtnMEditarAluno);
		rdbtnMEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnMEditarAluno.setBounds(159, 117, 52, 28);
		contentPane.add(rdbtnMEditarAluno);
		
		rdbtnFEditarAluno = new JRadioButton("F");
		buttonGroupAlunoEditar.add(rdbtnFEditarAluno);
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
		
		textFieldCepEditarAluno = new JTextField();
		textFieldCepEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldCepEditarAluno.setColumns(10);
		textFieldCepEditarAluno.setBounds(550, 268, 127, 26);
		contentPane.add(textFieldCepEditarAluno);
		
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
		
		JLabel lblDataDeNascEditarAluno = new JLabel("Data de Nasc.:");
		lblDataDeNascEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataDeNascEditarAluno.setBounds(396, 469, 180, 25);
		contentPane.add(lblDataDeNascEditarAluno);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(41, 155, 699, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(41, 434, 699, 2);
		contentPane.add(separator_1);
		
		textFieldDataDeNascEditarAluno = new JFormattedTextField(dateFormtUI);
		textFieldDataDeNascEditarAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDataDeNascEditarAluno.setColumns(10);
		textFieldDataDeNascEditarAluno.setBounds(585, 469, 127, 26);
		contentPane.add(textFieldDataDeNascEditarAluno);
		
		JButton btnSalvarEditarAluno = new JButton("Salvar");
		btnSalvarEditarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoDTO alunoDTO = new AlunoDTO();
				AlunoLogic alunoLogic = new AlunoLogic();
				EnderecoDTO enderecoDTO = new EnderecoDTO();
				
				try {
				
					
				enderecoDTO.setBairro(textFieldBairroEditarAluno.getText());
				enderecoDTO.setCidade(textFieldCidadeEditarAluno.getText());
				enderecoDTO.setRua(textFieldRuaEditarAluno.getText());
				enderecoDTO.setCep(Integer.parseInt(textFieldCepEditarAluno.getText()));
				enderecoDTO.setComplemento(textFieldComplementoEditarAluno.getText());
				enderecoDTO.setNumero(Integer.parseInt(textFieldNEditarAluno.getText()));
				enderecoDTO.setEstado(textFieldEstadoEditarAluno.getText());
				
				 AlunoDTO alunoAtual = alunoLogic.getAluno(idAlunoAtual);
				 enderecoDTO.setIdEndereco(alunoAtual.getIdEndereco().getIdEndereco());
				 
				String sexo = rdbtnMEditarAluno.isSelected() ? "M" : "F";
				
				alunoDTO.setIdAluno(idAlunoAtual);	
				alunoDTO.setNomeAluno(textFieldNomeEditarAluno.getText());
				alunoDTO.setDataNasc( dateFormtUI.parse(textFieldDataDeNascEditarAluno.getText()));
				alunoDTO.setDataMatricula(( new java.util.Date()));
				alunoDTO.setTelefoneAluno(textFieldTelefoneEditarAluno.getText());
				alunoDTO.setIdEndereco(enderecoDTO);
				alunoDTO.setSexo(sexo.toUpperCase());
				
				alunoLogic.atualizar(alunoDTO);
				MessageUtil.addMsg(OperacaoEditarAlunoUI.this, "atualização com sucesso");
				OperacaoEditarAlunoUI.this.dispose();
				
				
				//CadastroAlunoUI ca = new CadastroAlunoUI();
				//ca.dispose();
				//ca.atualizar();
				//ca.preencheTabelaConsulta();
				
						
				
				
				} catch (LogicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSalvarEditarAluno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSalvarEditarAluno.setBounds(211, 561, 111, 31);
		contentPane.add(btnSalvarEditarAluno);
		
		JButton btnCancelarEditarAluno = new JButton("Cancelar");
		btnCancelarEditarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OperacaoEditarAlunoUI.this.dispose();
			}
		});
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
	public void populationAlunoEditar(AlunoDTO alunoDTO){
		//dados do aluno
		this.idAlunoAtual = alunoDTO.getIdAluno();
		this.textFieldNomeEditarAluno.setText(alunoDTO.getNomeAluno().toString());  
		this.rdbtnMEditarAluno.setSelected(alunoDTO.getSexo().equals("M"));
		this.rdbtnFEditarAluno.setSelected(alunoDTO.getSexo().equals("F"));
		//this.textFieldDataDeNascEditarAluno.setValue(((alunoDTO.getDataNasc())));
		this.textFieldDataDeNascEditarAluno.setText((dateFormtUI.format(alunoDTO.getDataNasc())));
		this.textFieldTelefoneEditarAluno.setText((alunoDTO.getTelefoneAluno()));
		
		//dados do endereço
		this.textFieldBairroEditarAluno.setText(alunoDTO.getIdEndereco().getBairro());
		this.textFieldCidadeEditarAluno.setText(alunoDTO.getIdEndereco().getCidade());
		this.textFieldRuaEditarAluno.setText(alunoDTO.getIdEndereco().getRua());
		this.textFieldCepEditarAluno.setText(String.valueOf((alunoDTO.getIdEndereco().getCep())));
		this.textFieldComplementoEditarAluno.setText(alunoDTO.getIdEndereco().getComplemento());
		this.textFieldNEditarAluno.setText(String.valueOf(alunoDTO.getIdEndereco().getNumero()));
		this.textFieldEstadoEditarAluno.setText(alunoDTO.getIdEndereco().getEstado());
		
	}

	public void editar(int idAluno) {
		try {
			AlunoLogic alunoLogic =  new AlunoLogic();
			 AlunoDTO alunoAtual = alunoLogic.getAluno(idAluno);
			 populationAlunoEditar(alunoAtual);
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
