package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.AtividadeDTO;
import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AlunoLogic;
import br.si.es.sga.logic.AtividadeLogic;
import br.si.es.sga.logic.CaixaLogic;
import br.si.es.sga.logic.UsuarioLogic;
import br.si.es.sga.util.MessageUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PagamentoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldConsultaAluno;
	private JTextField textFieldValorDiaria;
	private JTable tableAluno;
	private ArrayList<Integer> idsAlunos= new ArrayList<Integer>();
	AlunoDTO alunoAtual;
	private DateFormat dateFormtCompleto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private DateFormat dateFormtBD = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat dateFormtUI = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField textFieldSaida;
	JTextArea textAreaDescricaoSaida;
	
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
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(224, 255, 255));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelMensalidade = new JPanel();
		panelMensalidade.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Registro de Mensalidade", null, panelMensalidade, null);
		panelMensalidade.setLayout(null);
		
		JLabel lblAlunosPagMensalidade = new JLabel("Aluno:");
		lblAlunosPagMensalidade.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAlunosPagMensalidade.setBounds(41, 25, 135, 23);
		panelMensalidade.add(lblAlunosPagMensalidade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 123, 615, 2);
		panelMensalidade.add(separator);
		
		textFieldConsultaAluno = new JTextField();
		textFieldConsultaAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldConsultaAluno.setBounds(41, 70, 479, 29);
		panelMensalidade.add(textFieldConsultaAluno);
		textFieldConsultaAluno.setColumns(10);
		
		JButton btnBuscarAlunos = new JButton("Pesquisar");
		btnBuscarAlunos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheTabelaConsulta();
			}
		});
		btnBuscarAlunos.setBounds(526, 70, 135, 29);
		panelMensalidade.add(btnBuscarAlunos);
		
		JButton btnRealizarPagamento = new JButton("Realizar Pagamento");
		btnRealizarPagamento.setEnabled(false);
		btnRealizarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRealizarPagamento){
					int idAluno = Integer.parseInt(tableAluno.getValueAt(tableAluno.getSelectedRow(), 0).toString());		
					PagamentoOperacaoUI pagamentooperacao = new PagamentoOperacaoUI();
					pagamentooperacao.setVisible(true);
					pagamentooperacao.editar(idAluno);
					
				}
			}
		});
		btnRealizarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRealizarPagamento.setBounds(243, 383, 247, 29);
		panelMensalidade.add(btnRealizarPagamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 136, 615, 219);
		panelMensalidade.add(scrollPane);
		
		tableAluno = new JTable();
		tableAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableAluno.setRowHeight(20);	
		tableAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnRealizarPagamento.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableAluno);
		
		JPanel panelDiaria = new JPanel();
		panelDiaria.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Registro de Di\u00E1ria", null, panelDiaria, null);
		panelDiaria.setLayout(null);
		
		JLabel lblRegistrarNovaDiaria = new JLabel("Registrar nova di\u00E1ria no valor de: ");
		lblRegistrarNovaDiaria.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistrarNovaDiaria.setBounds(127, 142, 354, 30);
		panelDiaria.add(lblRegistrarNovaDiaria);
		
		textFieldValorDiaria = new JTextField();
		textFieldValorDiaria.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldValorDiaria.setBounds(491, 142, 140, 30);
		panelDiaria.add(textFieldValorDiaria);
		textFieldValorDiaria.setColumns(10);

		JButton btnAdicionarDiaria = new JButton("Adicionar");
		btnAdicionarDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtividadeDTO atividadeDTO = new AtividadeDTO();
				AtividadeLogic atividadeLogic = new AtividadeLogic();
				UsuarioLogic usuarioLogic =  new UsuarioLogic();
				try {

				atividadeDTO.setTipo("diaria");
				atividadeDTO.setValor(Double.parseDouble(textFieldValorDiaria.getText()));
				atividadeDTO.setReferencia("Referente a pagamento de diária");
				String data = dateFormtCompleto.format(new java.util.Date());
				atividadeDTO.setData(dateFormtCompleto.parse(data));
					atividadeDTO.setUsuario(usuarioLogic.getUsuarioPorLogin(LoginUI.UsuarioAtual));

					atividadeLogic.cadastrar(atividadeDTO);
					atualizarCaixa();
					MessageUtil.addMsg(PagamentoUI.this, "Salvo com Sucesso!");
					textFieldValorDiaria.setText("");
					
				} catch (LogicException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnAdicionarDiaria.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarDiaria.setBounds(239, 223, 126, 30);
		panelDiaria.add(btnAdicionarDiaria);
		
		JButton btnLimparDiaria = new JButton("Limpar");
		btnLimparDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textFieldValorDiaria.setText("");
			}
		});
		btnLimparDiaria.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLimparDiaria.setBounds(426, 223, 126, 30);
		panelDiaria.add(btnLimparDiaria);
		
		JPanel panelSaida = new JPanel();
		panelSaida.setBackground(new Color(224, 255, 255));
		tabbedPane.addTab("Registro de Sa\u00EDda", null, panelSaida, null);
		
		JLabel lblRegistrarNovaSaida = new JLabel("Registrar nova sa\u00EDda no valor de: ");
		lblRegistrarNovaSaida.setBounds(123, 112, 354, 30);
		lblRegistrarNovaSaida.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textFieldSaida = new JTextField();
		textFieldSaida.setBounds(487, 113, 140, 30);
		textFieldSaida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldSaida.setColumns(10);

		JButton btnAdicionarSaida = new JButton("Adicionar");
		btnAdicionarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtividadeDTO atividadeDTO = new AtividadeDTO();
				AtividadeLogic atividadeLogic = new AtividadeLogic();
				UsuarioLogic usuarioLogic =  new UsuarioLogic();
				try {

					atividadeDTO.setTipo("saida");
					atividadeDTO.setValor(Double.parseDouble(textFieldSaida.getText()));
					atividadeDTO.setReferencia(textAreaDescricaoSaida.getText());
					String data = dateFormtCompleto.format(new java.util.Date());
					atividadeDTO.setData(dateFormtCompleto.parse(data));
					atividadeDTO.setUsuario(usuarioLogic.getUsuarioPorLogin(LoginUI.UsuarioAtual));

					atividadeLogic.cadastrar(atividadeDTO);
					atualizarCaixa();
					MessageUtil.addMsg(PagamentoUI.this, "Salvo com Sucesso!");
					textFieldSaida.setText("");
					textAreaDescricaoSaida.setText("");
				} catch (LogicException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdicionarSaida.setBounds(359, 326, 126, 30);
		btnAdicionarSaida.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblDescricaoSaida = new JLabel("Descri\u00E7\u00E3o da sa\u00EDda:");
		lblDescricaoSaida.setBounds(123, 161, 195, 25);
		lblDescricaoSaida.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textAreaDescricaoSaida = new JTextArea();
		textAreaDescricaoSaida.setBorder(new LineBorder(new Color(0, 0, 0)));
		textAreaDescricaoSaida.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textAreaDescricaoSaida.setBounds(359, 165, 268, 129);
		panelSaida.setLayout(null);
		panelSaida.add(lblRegistrarNovaSaida);
		panelSaida.add(textFieldSaida);
		panelSaida.add(btnAdicionarSaida);
		panelSaida.add(lblDescricaoSaida);
		panelSaida.add(textAreaDescricaoSaida);
		
		JButton btnLimparSaida = new JButton("Limpar");
		btnLimparSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSaida.setText("");
				textAreaDescricaoSaida.setText("");
			}
		});
		btnLimparSaida.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLimparSaida.setBounds(499, 326, 126, 30);
		panelSaida.add(btnLimparSaida);
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro
		
		
		//Preencher a tabela consulta aluno
		preencheTabelaConsulta();
		
	}
	public void preencheTabelaConsulta(){
		if(textFieldConsultaAluno.getText().equals("") || textFieldConsultaAluno ==  null ){
			String nome = textFieldConsultaAluno.getText();
			
			AlunoLogic alunoLogic = new AlunoLogic();
			
			try {
				String [][] lista = alunoLogic.Listagem(idsAlunos);
				tableAluno.setModel(new DefaultTableModel(
						lista,
						new String[] {
								"Número de Identificação","Nome"
						}

						){
					/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

					@SuppressWarnings("unused")
					public boolean isCellEditable(int linha, int coluna){
						return false;
					}
					
					
				});
				
			} catch (Exception e) {
				e.printStackTrace();
				MessageUtil.addMsg(PagamentoUI.this, e.getMessage());
			}
		}else{
			String nome = textFieldConsultaAluno.getText();
			
			AlunoLogic alunoLogic = new AlunoLogic();
			try {
				String [][] lista = alunoLogic.ListagemPorNome(idsAlunos, nome);
				tableAluno.setModel(new DefaultTableModel(
						lista,
						new String[] {
								"Número de Identificação","Nome"
								
						}
						){
					/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

					@SuppressWarnings("unused")
					public boolean isCellEditable(int linha, int coluna){
						return false;
					}
				});
				
				
			} catch (Exception e) {
				e.printStackTrace();
				MessageUtil.addMsg(PagamentoUI.this, e.getMessage());
			}
		}
		
		tableAluno.getColumnModel().getColumn(0).setMaxWidth(0);
		tableAluno.getColumnModel().getColumn(0).setMinWidth(0);
		tableAluno.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		tableAluno.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		
	}
	public void atualizarCaixa(){
		AtividadeLogic atividadeLogic = new AtividadeLogic();
		CaixaDTO caixaDTO = new CaixaDTO();
		CaixaLogic caixaLogic = new CaixaLogic();
		double valorDiario;
		double valorTotalMes;
		double valorSaida;
		 String dataInicial = dateFormtUI.format(new java.util.Date());
		 String dataInicialBD = dateFormtBD.format(new java.util.Date());
		 Calendar dataCalendarInicial = Calendar.getInstance();
		 Calendar dataCalendarFinal = Calendar.getInstance();
		 
		try {
			
			dataCalendarInicial.setTime(dateFormtBD.parse(dataInicialBD));
			System.out.println("dataCalendarinicial " + dateFormtBD.format(dataCalendarInicial.getTime()) );
			dataCalendarInicial.set(Calendar.DAY_OF_MONTH, 1);
			dataCalendarFinal.setTime(dataCalendarInicial.getTime());
			dataCalendarFinal.add(Calendar.MONTH, 1);
			dataCalendarFinal.add(Calendar.DAY_OF_MONTH, 1);
			
			valorDiario = atividadeLogic.valorDiario(dataInicialBD);
			valorTotalMes = atividadeLogic.valorTotalMes(dateFormtBD.format(dataCalendarInicial.getTime()), dateFormtBD.format(dataCalendarFinal.getTime()));
			valorSaida = atividadeLogic.valorSaida(dataInicialBD);
			
			System.out.println("dataInicial " + dataInicial);
			System.out.println("dataIniciaBD "+ dataInicialBD);
			System.out.println("dataCalendarinicial " + dateFormtBD.format(dataCalendarInicial.getTime()) );
			System.out.println("dataCalendarfinal " + dateFormtBD.format(dataCalendarFinal.getTime()) );
			System.out.println("valor diaria" + valorDiario);
			System.out.println("valor total mes" + valorTotalMes);
			System.out.println("valor saida" + valorSaida);
			
			caixaDTO.setValorDiario(valorDiario);
			caixaDTO.setValorTotal(valorTotalMes);
			caixaDTO.setValorSaida(valorSaida);
			caixaDTO.setData(dataCalendarInicial.getTime());
			if(!caixaLogic.listar().isEmpty()) {
			if(caixaLogic.getDataDoMes().compareTo(dataCalendarInicial.getTime()) == 0){
				caixaDTO.setIdCaixa(caixaLogic.listar().get(0).getIdCaixa()); 
				caixaLogic.atualizar(caixaDTO);
			 }else{
				 caixaLogic.deletar();
				 caixaLogic.cadastrar(caixaDTO);
			 }
			}else{
				caixaLogic.cadastrar(caixaDTO);
			}
			
			TelaPrincipalUI.lblValorTotal.setText(String.valueOf(valorTotalMes));
			TelaPrincipalUI.lblValorDiario.setText(String.valueOf(valorDiario));
			TelaPrincipalUI.lblValorSaida.setText(String.valueOf(valorSaida));
			
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
