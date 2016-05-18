package br.si.es.sga.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import br.si.es.sga.dto.AlunoDTO;
import br.si.es.sga.exeception.LogicException;
import br.si.es.sga.logic.AlunoLogic;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;

public class NotificacaoUI extends JFrame {

	private JPanel contentPane;
	private DateFormat dateFormtBD = new SimpleDateFormat("yyyy-MM-dd");
	AlunoDTO alunoDTO  = new AlunoDTO();
	AlunoLogic alunoLogic = new AlunoLogic();
	JLabel lblNotificacaoFotoAluno;
	JLabel lblNotificacaoInformacaoAluno;
	int i;
	List<AlunoDTO> lista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotificacaoUI frame = new NotificacaoUI();
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
	public NotificacaoUI() {
		setTitle("Notifica\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 522, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);  
		this.setResizable(false);

		JPanel panelCabecalho = new JPanel();
		panelCabecalho.setBackground(new Color(224, 255, 255));
		contentPane.add(panelCabecalho, BorderLayout.NORTH);
		panelCabecalho.setLayout(new BorderLayout(0, 0));

		JLabel lblCabecalhoNotificacoes = new JLabel("Alunos com a data de vencimento expirada :");
		lblCabecalhoNotificacoes.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelCabecalho.add(lblCabecalhoNotificacoes);

		JPanel panelInformacaoAluno = new JPanel();
		panelInformacaoAluno.setBackground(new Color(224, 255, 255));
		contentPane.add(panelInformacaoAluno, BorderLayout.EAST);
		panelInformacaoAluno.setLayout(new BorderLayout(0, 0));

		lblNotificacaoFotoAluno = new JLabel("");
		panelInformacaoAluno.add(lblNotificacaoFotoAluno, BorderLayout.NORTH);

		lblNotificacaoInformacaoAluno = new JLabel("");
		panelInformacaoAluno.add(lblNotificacaoInformacaoAluno, BorderLayout.CENTER);



		String dataHoje = dateFormtBD.format(new java.util.Date());
		System.out.println(dataHoje);
		lista = listAlunos(dataHoje); 
		VerificaDias();
		int quant = lista.size();
		int quantLinhas = (quant/4) +(quant % 2) ;
		if(quantLinhas < 1){
			quantLinhas = 1;
		}

		JPanel panelScroll = new JPanel();
		panelScroll.setBackground(new Color(224, 255, 255));
		contentPane.add(panelScroll, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelScroll = new GroupLayout(panelScroll);
		gl_panelScroll.setHorizontalGroup(
				gl_panelScroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelScroll.createSequentialGroup()
						.addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 943, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(231, Short.MAX_VALUE))
				);
		gl_panelScroll.setVerticalGroup(
				gl_panelScroll.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelScroll.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
						.addContainerGap())
				);

		JPanel panelAlunos = new JPanel();
		panelAlunos.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelAlunos);

		panelAlunos.setLayout(new MigLayout("wrap 3", "[]", "[]"));
		panelScroll.setLayout(gl_panelScroll);

		for(i = 0 ; i < lista.size();i ++){

			alunoDTO = lista.get(i);
			Panel panelAlunoVencido = new Panel();
			Panel panelDetalhe = new Panel();
			panelDetalhe.setLayout(new FlowLayout(FlowLayout.CENTER));

			//panelAlunoVencido.setBackground(Color.RED);
			panelAlunoVencido.setLayout(new BorderLayout());
			panelAlunoVencido.setPreferredSize(new Dimension(250,250));



			JLabel nome = new JLabel(alunoDTO.getNomeAluno(),JLabel.CENTER);
			nome.setFont(new Font("Tahoma", Font.BOLD, 16));

			JButton btnDetalhe = new JButton("Detalhes");
			JLabel lblidAluno = new JLabel();


			byte[] bimg;
			bimg = alunoDTO.getFoto();
			InputStream is = new ByteArrayInputStream(bimg);
			Image img = new ImageIcon(bimg).getImage();
			ImageIcon imgIcon = new ImageIcon(img);
			ImageIcon imgOff = new ImageIcon(imgIcon.getImage().getScaledInstance( 300,200, Image.SCALE_DEFAULT));
			JLabel foto = new JLabel(imgOff,JLabel.CENTER);

			lblidAluno.setText(String.valueOf(alunoDTO.getIdAluno()));



			btnDetalhe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == btnDetalhe){
						try {
							System.out.println(alunoLogic.getAluno(Integer.parseInt(lblidAluno.getText())).getCpfAluno());
							preencherDetalhe(alunoLogic.getAluno(Integer.parseInt(lblidAluno.getText())));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LogicException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});


			panelDetalhe.add(btnDetalhe);
			panelAlunoVencido.add(foto,BorderLayout.CENTER);
			panelAlunoVencido.add(nome, BorderLayout.NORTH);
			panelAlunoVencido.add(panelDetalhe,BorderLayout.SOUTH);
			panelAlunos.add(panelAlunoVencido);
		}


	}
	public List<AlunoDTO> listAlunos(String dataHoje){
		List<AlunoDTO> lista = null;
		AlunoLogic alunoLogic = new AlunoLogic();
		try {

			lista = alunoLogic.listarAlunoVencidos(dataHoje);

		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public void preencherDetalhe(AlunoDTO alunoDTO){
		byte[] bimg;
		bimg = alunoDTO.getFoto();
		InputStream is = new ByteArrayInputStream(bimg);
		Image img = new ImageIcon(bimg).getImage();
		ImageIcon imgIcon = new ImageIcon(img);
		ImageIcon imgOff = new ImageIcon(imgIcon.getImage().getScaledInstance(230, 225, Image.SCALE_DEFAULT));
		lblNotificacaoFotoAluno.setIcon(imgOff);


		String dataAtualBD = dateFormtBD.format(new java.util.Date());
		Date dataCalendarAtualDate = null ;
		Date dataCalendarVencimento = null;
		try {
			dataCalendarAtualDate =dateFormtBD.parse(dataAtualBD);
			dataCalendarVencimento = dateFormtBD.parse(dateFormtBD.format(alunoDTO.getDataVencimento()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diferencaDias= 0;
		diferencaDias = (dataCalendarAtualDate.getTime() - dataCalendarVencimento.getTime()) / (1000*60*60*24);
		lblNotificacaoInformacaoAluno.setText("<html>Nome: <br/> "+alunoDTO.getNomeAluno()+"<br/>\r\n "
				+ "CPF: "+alunoDTO.getCpfAluno()+" <br/> \r\n "
				+ "Contato: "+alunoDTO.getTelefoneAluno()+" <br/> \r\n "
				+ "" + diferencaDias + " dias </html>");

	}
	public void VerificaDias(){
		String dataAtualBD = dateFormtBD.format(new java.util.Date());
		Date dataCalendarAtualDate = null ;
		Date dataCalendarVencimento = null;
		for(int i = 0;i<lista.size();i++){
			try {
				dataCalendarAtualDate =dateFormtBD.parse(dataAtualBD);
				dataCalendarVencimento = dateFormtBD.parse(dateFormtBD.format(lista.get(i).getDataVencimento()));

				long diferencaDias= 0;
				diferencaDias = (dataCalendarAtualDate.getTime() - dataCalendarVencimento.getTime()) / (1000*60*60*24);
				if(diferencaDias > 60){
					lista.remove(i);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


