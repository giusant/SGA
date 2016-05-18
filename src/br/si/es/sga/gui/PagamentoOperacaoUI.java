package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Choice;

import javax.swing.JList;
import javax.swing.JTable;

import java.awt.Scrollbar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import org.w3c.dom.ls.LSInput;

import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.dto.AlunoHasModalidadeDTO;
import br.si.es.sga.dto.AtividadeDTO;
import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.dto.ModalidadeDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AlunoHasModalidadeLogic;
import br.si.es.sga.logic.AlunoLogic;
import br.si.es.sga.logic.AtividadeLogic;
import br.si.es.sga.logic.CaixaLogic;
import br.si.es.sga.logic.ModalidadeLogic;
import br.si.es.sga.logic.UsuarioLogic;
import br.si.es.sga.util.MessageUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class PagamentoOperacaoUI extends JFrame {
	AlunoDTO alunoAtual;
	private JPanel contentPane;
	private JTextField textFieldDescontoPagamento;
	private JTextField txtFieldTotalPagamento;
	private JTextField txtFieldDataPagamento;
	ModalidadeLogic modalidadeLogic = new ModalidadeLogic();
	DefaultListModel  model;
	private JTable tableModalidadesExistente;
	private JTable tableModalidadeSolicitante;
	private ArrayList<Integer> idsModalidades = new ArrayList<Integer>(); 
	JSpinner spinnerMesesPagamento;
	private DateFormat dateFormtCompleto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private DateFormat dateFormtUI = new SimpleDateFormat("dd/MM/yyyy");
	private DateFormat dateFormtBD = new SimpleDateFormat("yyyy-MM-dd");
	
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
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnAdicionarModalidade = new JButton("Adicionar");
		btnAdicionarModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idModalidade = Integer.parseInt(tableModalidadesExistente.getValueAt(tableModalidadesExistente.getSelectedRow(), 0).toString());
				ModalidadeDTO modalidade= null;
				try{
				 modalidade= modalidadeLogic.getModalidade(idModalidade);
					
					inserirLinhaTabelaModalidadeSolicitante(modalidade);
				} catch (LogicException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionarModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarModalidade.setBounds(315, 107, 141, 31);
		contentPane.add(btnAdicionarModalidade);
		
		JButton btnRemoverModalidade = new JButton("Remover");
		btnRemoverModalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idModalidade = tableModalidadeSolicitante.getSelectedRow();
				ModalidadeDTO modalidade= null;
				try{
				 modalidade= modalidadeLogic.getModalidade(idModalidade);
					
					removerLinhaTabelaModalidadeSolicitante(idModalidade);
				} catch (LogicException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemoverModalidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRemoverModalidade.setBounds(315, 163, 141, 31);
		contentPane.add(btnRemoverModalidade);
		
		JLabel lblMesesPagamento = new JLabel("Meses:");
		lblMesesPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMesesPagamento.setBounds(47, 259, 87, 24);
		contentPane.add(lblMesesPagamento);
		
		spinnerMesesPagamento = new JSpinner();
		spinnerMesesPagamento.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				popularCampos();
			}
		});
		spinnerMesesPagamento.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerMesesPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerMesesPagamento.setBounds(155, 260, 76, 24);
	//	spinnerMesesPagamento.getModel().setValue(1);
		contentPane.add(spinnerMesesPagamento);
		
		JLabel lblDescontoPagamento = new JLabel("Desconto:");
		lblDescontoPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescontoPagamento.setBounds(358, 259, 113, 24);
		contentPane.add(lblDescontoPagamento);
		
		textFieldDescontoPagamento = new JTextField();
		textFieldDescontoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldDescontoPagamento.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				
				popularCampos();
			}
		});
		
		textFieldDescontoPagamento.setBounds(481, 257, 257, 31);
		contentPane.add(textFieldDescontoPagamento);
		textFieldDescontoPagamento.setColumns(10);
		
		JLabel lblTotalPagamento = new JLabel("Total:");
		lblTotalPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalPagamento.setBounds(47, 312, 70, 24);
		contentPane.add(lblTotalPagamento);
		
		txtFieldTotalPagamento = new JTextField();
		txtFieldTotalPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldTotalPagamento.setColumns(10);
		txtFieldTotalPagamento.setBounds(127, 305, 141, 31);
		contentPane.add(txtFieldTotalPagamento);
		
		JLabel lblDataPagamento = new JLabel("Data:");
		lblDataPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDataPagamento.setBounds(47, 364, 70, 24);
		contentPane.add(lblDataPagamento);
		
		txtFieldDataPagamento = new JTextField();
		txtFieldDataPagamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldDataPagamento.setColumns(10);
		txtFieldDataPagamento.setBounds(127, 362, 141, 31);
		contentPane.add(txtFieldDataPagamento);
		
		JButton btnCancelarPagamento = new JButton("Cancelar");
		btnCancelarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagamentoOperacaoUI.this.dispose();
			}
		});
		btnCancelarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelarPagamento.setBounds(543, 362, 127, 31);
		contentPane.add(btnCancelarPagamento);
		
		JButton BtnSalvarPagamento = new JButton("Salvar");
		BtnSalvarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtividadeDTO atividadeDTO = new AtividadeDTO();
				AtividadeLogic atividadeLogic = new AtividadeLogic();
				UsuarioLogic usuarioLogic =  new UsuarioLogic();
				
				try {
				atividadeDTO.setTipo("entrada");
				atividadeDTO.setValor(Double.parseDouble(txtFieldTotalPagamento.getText()));
				atividadeDTO.setReferencia("Referente a pagamento de mensalidades");
				String data = dateFormtCompleto.format(new java.util.Date());
				atividadeDTO.setData(dateFormtCompleto.parse(data));
					atividadeDTO.setUsuario(usuarioLogic.getUsuarioPorLogin(LoginUI.UsuarioAtual));
					
					atividadeLogic.cadastrar(atividadeDTO);
					atualizarAluno(alunoAtual);
					atualizarCaixa();
					MessageUtil.addMsg(PagamentoOperacaoUI.this, "Salvo com Sucesso!");
					PagamentoOperacaoUI.this.dispose();
				} catch (LogicException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		BtnSalvarPagamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		BtnSalvarPagamento.setBounds(398, 362, 127, 31);
		contentPane.add(BtnSalvarPagamento);
		
		JScrollPane scrollPaneModalidadesExistentes = new JScrollPane();
		scrollPaneModalidadesExistentes.setBounds(32, 94, 257, 134);
		contentPane.add(scrollPaneModalidadesExistentes);
		
		tableModalidadesExistente = new JTable();
		tableModalidadesExistente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPaneModalidadesExistentes.setViewportView(tableModalidadesExistente);
		tableModalidadesExistente.setRowHeight(20);		
		
		this.setSize(800, 500);		//tamanho da tela
		this.setLocationRelativeTo(null);	//situa a tela no centro


		model = new DefaultListModel<>();
		
		JScrollPane scrollPaneModalidadeSolicitada = new JScrollPane();
		scrollPaneModalidadeSolicitada.setBounds(486, 94, 251, 134);
		contentPane.add(scrollPaneModalidadeSolicitada);
		
		tableModalidadeSolicitante = new JTable();
		tableModalidadeSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableModalidadeSolicitante.setRowHeight(20);
		scrollPaneModalidadeSolicitada.setViewportView(tableModalidadeSolicitante);
		textFieldDescontoPagamento.setText("0.0");
		
		//popular a tabela de modalidades ja existentes 
		preencheTabelaConsulta();
		//popular a table de modalidade 
		preencheTabelaModalidadeSolicitante();
		
		//
		popularCampos();
		
	}

	
	public void preencheTabelaConsulta(){

		ModalidadeLogic modalidadeLogic = new ModalidadeLogic();

		try {
			String [][] lista = modalidadeLogic.Listagem(idsModalidades);
			tableModalidadesExistente.setModel(new DefaultTableModel(
					lista,
					new String[] {
							"ID","Nome","Valor"
					}

					){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@SuppressWarnings("unused")
				public boolean isCellEditable(int linha, int coluna){
					return false;

				}		});


		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.addMsg(PagamentoOperacaoUI.this, e.getMessage());
		}

	}
	public void preencheTabelaModalidadeSolicitante(){

		ModalidadeLogic modalidadeLogic = new ModalidadeLogic();

		try {
			//String [][] lista = modalidadeLogic.Listagem(idsModalidades);
			DefaultTableModel model = new DefaultTableModel();
			
			tableModalidadeSolicitante.setModel(new DefaultTableModel(
					null,
					new String[] {
							"ID","Nome","Valor"
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
				public void InserirLinha(String Placa, String Data){
			        // Adiciona uma linha vazia na JTable
			        //addRow(new Object[]{modalidadeDTO.getIdModalidade(),modalidadeDTO.getNomeModalidade(),modalidadeDTO.getValor()});
			}	
			});
			//((DefaultTableModel)tableModalidadeSolicitante.getModel()).addRow(new Object[]{modalidadeDTO.getIdModalidade(),modalidadeDTO.getNomeModalidade(),modalidadeDTO.getValor()});
			
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtil.addMsg(PagamentoOperacaoUI.this, e.getMessage());
		}

	}
	public void inserirLinhaTabelaModalidadeSolicitante(ModalidadeDTO modalidadeDTO){
		List listaModalidadeExistentes =  new ArrayList();
		boolean pode = true;
		for(int i =0 ; i<tableModalidadeSolicitante.getRowCount();i++){
			if(modalidadeDTO.getIdModalidade() == (int) tableModalidadeSolicitante.getValueAt(i, 0))
				pode = false;
			else
				pode =true;
		}
		if(pode)
		((DefaultTableModel)tableModalidadeSolicitante.getModel()).addRow(new Object[]{modalidadeDTO.getIdModalidade(),modalidadeDTO.getNomeModalidade(),modalidadeDTO.getValor()});
		else
			MessageUtil.addMsg(PagamentoOperacaoUI.this, "Modalidade já inserida");

		
		popularCampos();
	}
	public void removerLinhaTabelaModalidadeSolicitante(int id){
		((DefaultTableModel)tableModalidadeSolicitante.getModel()).removeRow(id);

		popularCampos();
	}
	public void popularCampos(){
		double valor = 0;

		
		
		for(int i=0;i<tableModalidadeSolicitante.getModel().getRowCount();i++){
			try {
				valor = valor +  (double)modalidadeLogic.getModalidade( (int) tableModalidadeSolicitante.getModel().getValueAt(i, 0)).getValor();
			} catch (LogicException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		double desconto = Double.parseDouble(textFieldDescontoPagamento.getText());
		valor = valor * (int) spinnerMesesPagamento.getModel().getValue();
		valor = valor - desconto;
		txtFieldTotalPagamento.setText(String.valueOf(valor));
	}
	public void atualizarAluno(AlunoDTO alunoDTO){
		AlunoHasModalidadeLogic alunoHasModalidadeLogic = new AlunoHasModalidadeLogic();
		AlunoHasModalidadeDTO alunoHasModalidadeDTO = new AlunoHasModalidadeDTO();
		AlunoLogic alunoLogic = new AlunoLogic();
		try {
			 int quant = Integer.parseInt(spinnerMesesPagamento.getModel().getValue().toString());
			alunoDTO.setDataVencimento(dataVencimento(dateFormtUI.parse(txtFieldDataPagamento.getText()), quant));
			alunoLogic.atualizarDataVencimento(alunoDTO);
			
			//Apagar os registro do aluno
			alunoHasModalidadeLogic.deletar(alunoDTO.getIdAluno());
			
			for(int i = 0; i < tableModalidadeSolicitante.getModel().getRowCount();i++){
			alunoHasModalidadeDTO.setIdAluno(alunoDTO.getIdAluno());
			 int idModalidade = (int)tableModalidadeSolicitante.getModel().getValueAt(i, 0);
			alunoHasModalidadeDTO.setIdModalidade(idModalidade);
			alunoHasModalidadeLogic.cadastrar(alunoHasModalidadeDTO);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(int idAluno) {
		try {
			AlunoLogic alunoLogic =  new AlunoLogic();
			alunoAtual = alunoLogic.getAluno(idAluno);
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Date dataVencimento(Date dataAtual, int quant){
		
		Calendar dataVencimento = Calendar.getInstance();
			try {
				dataVencimento.setTime(	dateFormtUI.parse(txtFieldDataPagamento.getText()));
				dataVencimento.add(Calendar.MONTH, quant);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataVencimento.getTime();
	}
	
	
	public void atualizarCaixa(){
		AtividadeLogic atividadeLogic = new AtividadeLogic();
		CaixaDTO caixaDTO = new CaixaDTO();
		CaixaLogic caixaLogic = new CaixaLogic();
		double valorDiario;
		double valorTotalMes;
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
			
			System.out.println("dataInicial " + dataInicial);
			System.out.println("dataIniciaBD "+ dataInicialBD);
			System.out.println("dataCalendarinicial " + dateFormtBD.format(dataCalendarInicial.getTime()) );
			System.out.println("dataCalendarfinal " + dateFormtBD.format(dataCalendarFinal.getTime()) );
			System.out.println("valor " + valorDiario);
			System.out.println("valor " + valorTotalMes);
			
			caixaDTO.setValorDiario(valorDiario);
			caixaDTO.setValorTotal(valorTotalMes);
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
						
			 
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

