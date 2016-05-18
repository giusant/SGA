package br.si.es.sga.gui;

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

import br.si.es.sga.dto.CaixaDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AtividadeLogic;
import br.si.es.sga.logic.CaixaLogic;
import br.si.es.sga.logic.UsuarioLogic;

import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;

public class TelaPrincipalUI extends JFrame implements MouseListener {

  private JPanel contentPane;
  JLabel lblCadastrarFuncionario ;
  JMenuItem mntmFuncionrio ;
  JLabel image2 ;
  static JLabel lblValorDiario;
  static JLabel lblValorTotal;
  static JLabel lblValorSaida;
  JPanel panelInformacaoValores ;
  JLabel lblTotalDoMes;
  JPanel panelValorTotal;
  JLabel lblTotalDeSaida;
  JPanel panelValorSaida;
  JLabel lblTotalDoDia;
  JPanel panelValorDiario;
  private DateFormat dateFormtBD = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat dateFormtUI = new SimpleDateFormat("dd/MM/yyyy");
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
    setTitle("Tela Principal - SGA" + " - Usuário: "+ LoginUI.UsuarioAtual);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 583, 376);
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setForeground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    this.setSize(1200, 700);
    this.setLocationRelativeTo(null);  
    
    ImageIcon imageIcon = new ImageIcon(TelaPrincipalUI.class.getResource("/add1.png"));
    ImageIcon imageIcon2 = new ImageIcon(TelaPrincipalUI.class.getResource("/TelaInicial2.png"));  
    ImageIcon imageIcon3 = new ImageIcon(TelaPrincipalUI.class.getResource("/nome2.png"));

    JLabel image = new JLabel(imageIcon);
    image.setBounds(70, 90, 50, 50);
    contentPane.add(image);    
    
    image2 = new JLabel(imageIcon);
    image2.setBounds(70, 194, 50, 50);
    contentPane.add(image2);
    
    JLabel image4 = new JLabel(imageIcon);
    image4.setBounds(70, 140, 50, 50);
    contentPane.add(image4);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBounds(0, 0, 1194, 21);
    contentPane.add(menuBar);
    
    JMenu mnArquivo = new JMenu("Arquivo");
    menuBar.add(mnArquivo);
    
    JMenuItem mntmSair = new JMenuItem("Sair");
    mntmSair.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		TelaPrincipalUI.this.dispose();
    		LoginUI loginUI = new LoginUI();
    		loginUI.Atualizar();
    	}
    });
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Sobre");
    mntmNewMenuItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		SobreUI sobre = new SobreUI();
    		sobre.setVisible(true);
    		sobre.setResizable(false);
    	}
    });
    mnArquivo.add(mntmNewMenuItem);
    mnArquivo.add(mntmSair);
    
    JMenu mnCadastro = new JMenu("Cadastro");
    menuBar.add(mnCadastro);
    
    JMenuItem mntmAluno = new JMenuItem("Aluno");
    mntmAluno.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mntmAluno){
          CadastroAlunoUI cadastroaluno = new CadastroAlunoUI();
          cadastroaluno.setVisible(true);
        }
      }
    });
    mnCadastro.add(mntmAluno);
    
    mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
    mntmFuncionrio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mntmFuncionrio){
          CadastroFuncionarioUI cadastroFuncionario = new CadastroFuncionarioUI();
          cadastroFuncionario.setVisible(true);
        }
      }
    });
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
    
    JMenuItem mntmNovoPagamento = new JMenuItem("Novo");
    mntmNovoPagamento.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            if(e.getSource() == mntmNovoPagamento){
              PagamentoUI pagamento = new PagamentoUI();
              pagamento.setVisible(true);
            }
          }
        });
        mnPagamento.add(mntmNovoPagamento);
        
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
        
            
        lblCadastrarFuncionario = new JLabel("Cadastrar Funcion\u00E1rio");
        lblCadastrarFuncionario.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCadastrarFuncionario.setBounds(129, 206, 229, 32);
        lblCadastrarFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(lblCadastrarFuncionario);
        
        lblCadastrarFuncionario.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
              if(e.getSource() == lblCadastrarFuncionario){         
              CadastroFuncionarioUI cadastrofuncionario = new CadastroFuncionarioUI();
              cadastrofuncionario.setVisible(true);
            }
            }  
        }); 
        
        JLabel lblNovoPagamento = new JLabel("Novo Pagamento");
        lblNovoPagamento.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if(e.getSource() == lblNovoPagamento){
              PagamentoUI pagamento = new PagamentoUI();
              pagamento.setVisible(true);
            }
          }      
        });
        lblNovoPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNovoPagamento.setBounds(130, 151, 181, 32);
        lblNovoPagamento.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(lblNovoPagamento);
        
        JLabel labelTelaInicial = new JLabel("");
        labelTelaInicial.setIcon(imageIcon2);
        labelTelaInicial.setBounds(563, 51, 598, 511);
        contentPane.add(labelTelaInicial);
        
        JLabel label_1 = new JLabel("");
        label_1.setIcon(imageIcon3);
        label_1.setBounds(86, 415, 247, 94);
        contentPane.add(label_1);
        
        panelInformacaoValores = new JPanel();
        panelInformacaoValores.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelInformacaoValores.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informa\u00E7\u00F5es sobre o caixa", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panelInformacaoValores.setBackground(Color.WHITE);
        panelInformacaoValores.setForeground(Color.WHITE);
        panelInformacaoValores.setBounds(96, 573, 583, 62);
        contentPane.add(panelInformacaoValores);
        panelInformacaoValores.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        
        panelValorDiario = new JPanel();
        panelValorDiario.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelValorDiario.setBackground(Color.WHITE);
        panelInformacaoValores.add(panelValorDiario);
        panelValorDiario.setLayout(new BorderLayout(0, 0));
        
        lblTotalDoDia = new JLabel("Total di\u00E1rio: ");
        lblTotalDoDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorDiario.add(lblTotalDoDia, BorderLayout.WEST);
        
        lblValorDiario = new JLabel("");
        lblValorDiario.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorDiario.add(lblValorDiario, BorderLayout.CENTER);
        
        panelValorSaida = new JPanel();
        panelValorSaida.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelValorSaida.setBackground(Color.WHITE);
        panelInformacaoValores.add(panelValorSaida);
        panelValorSaida.setLayout(new BorderLayout(0, 0));
        
        lblTotalDeSaida = new JLabel("Total de sa\u00EDda di\u00E1rio: ");
        lblTotalDeSaida.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorSaida.add(lblTotalDeSaida, BorderLayout.WEST);
        
        lblValorSaida = new JLabel("");
        lblValorSaida.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorSaida.add(lblValorSaida, BorderLayout.CENTER);
        
        panelValorTotal = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelValorTotal.getLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        panelValorTotal.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelValorTotal.setBackground(Color.WHITE);
        panelInformacaoValores.add(panelValorTotal);
        
        lblTotalDoMes = new JLabel("Total mensal: ");
        lblTotalDoMes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorTotal.add(lblTotalDoMes);
        
        lblValorTotal = new JLabel("");
        lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panelValorTotal.add(lblValorTotal);
        
        JButton btnNotificacoes = new JButton("Notifica\u00E7\u00F5es");
        btnNotificacoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNotificacoes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NotificacaoUI notificacao = new NotificacaoUI();
        		notificacao.setVisible(true);
        	}
        });
        btnNotificacoes.setBounds(86, 280, 148, 32);
        contentPane.add(btnNotificacoes);
        
        
        UsuarioLogic usuarioLogic = new UsuarioLogic();
        try {
			if(!usuarioLogic.getUsuarioPorLogin(LoginUI.UsuarioAtual.toString()).isGerente()){
				setVisibilidadeFuncionario();
			}
		} catch (LogicException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        //Add valores na label
        SetValore();
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
      public void setVisibilidadeFuncionario(){
    	 lblCadastrarFuncionario.setVisible(false);
    	 lblCadastrarFuncionario.setEnabled(false);
    	 mntmFuncionrio.setVisible(false);
    	 mntmFuncionrio.setEnabled(false);
    	 image2.setVisible(false);
    	 //lblTotalDeSaida.setVisible(false);
    	 //lblTotalDoDia.setVisible(false);
    	 lblTotalDoMes.setVisible(false);
    	 //lblValorDiario.setVisible(false);
    	 //lblValorSaida.setVisible(false);
    	 lblValorTotal.setVisible(false);
    	 panelValorTotal.setVisible(false);
    	 
    	 
      }
      public void SetValore(){
    	  CaixaDTO caixaDTO = new CaixaDTO();
    	  CaixaLogic caixaLogic = new CaixaLogic();
    	  AtividadeLogic atividadeLogic = new AtividadeLogic();
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
				System.out.println("valor diario " + valorDiario);
				System.out.println("valor total mes " + valorTotalMes);
				System.out.println("valor saida " +  valorSaida);
				
				caixaDTO.setIdCaixa(caixaLogic.listar().get(0).getIdCaixa());
				caixaDTO.setValorDiario(valorDiario);
				caixaDTO.setValorTotal(valorTotalMes);
				caixaDTO.setValorSaida(valorSaida);
				caixaDTO.setData(dataCalendarInicial.getTime());
				
				caixaLogic.atualizar(caixaDTO);
			
			lblValorDiario.setText( String.valueOf(valorDiario));
			lblValorTotal.setText(String.valueOf(valorTotalMes));
			lblValorSaida.setText(String.valueOf(valorSaida));
    	  } catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      public void atualizarJanela(){
    	  this.dispose();
    	  main(null);
      }
    }
  