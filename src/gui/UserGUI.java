/* Desenvolvedor: João Victor Ferreira de Aragão
 * 
 * Data/hora de inicio: 13/04/2022 19:27
 * 
 * Data/hora de término:14/04/2022 10:26
 * 
 * 
 * */


package gui;

import modelo.User;
import dao.UserDAO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Factory.ConnectionFactory;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
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
	public UserGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Formulário");
		lblNewJgoodiesLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nome");
		lblNewJgoodiesLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("CPF");
		lblNewJgoodiesLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("Idade");
		lblNewJgoodiesLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Sexo (M/F)");
		lblNewJgoodiesLabel_4.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Endereço");
		lblNewJgoodiesLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Grau de escolaridade");
		lblNewJgoodiesLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_7 = DefaultComponentFactory.getInstance().createLabel("Nome do Pai");
		lblNewJgoodiesLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_8 = DefaultComponentFactory.getInstance().createLabel("Nome da Mãe");
		lblNewJgoodiesLabel_8.setFont(new Font("Arial", Font.PLAIN, 11));
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewJgoodiesLabel_9 = DefaultComponentFactory.getInstance().createLabel("Se descreva de forma breve");
		lblNewJgoodiesLabel_9.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JTextPane textPane = new JTextPane();
		
		JLabel label = new JLabel("");
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		Button button_1 = new Button("Limpar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textPane.setText("");
				
			}
		});
		
		Button button = new Button("Enviar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User users = new User();
				users.setNome(textField.getText());
				users.setCPF(textField_1.getText());
				//Converte a string da idade para inteiro
				int num_conv = Integer.parseInt(textField_2.getText());
				users.setIdade(num_conv);
				users.setSexo(textField_3.getText());
				users.setEndereço(textField_4.getText());
				users.setEscolaridade(textField_5.getText());
				users.setPai(textField_6.getText());
				users.setMae(textField_7.getText());
				users.setDescr(textPane.getText());
				
				if((textField.getText().isEmpty() || (textField_1.getText().isEmpty()) || (textField_2.getText().isEmpty()) || (textField_3.getText().isEmpty()) || (textField_4.getText().isEmpty())
						|| (textField_5.getText().isEmpty()) || (textField_6.getText().isEmpty()) || (textField_7.getText().isEmpty()) || (textPane.getText().isEmpty())));else {
							UserDAO dao = new UserDAO();
							dao.adiciona(users);
							JOptionPane.showMessageDialog(null, "Usuário "+textField.getText()+" inserido");
						}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textPane.setText("");
			}
		});
		
		Button button_2 = new Button("Relatório");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Connection connection = new ConnectionFactory().getConnection();
		    		
		    		String sql = "SELECT * FROM user ORDER BY id DESC";
		    		
		    		PreparedStatement statement = connection.prepareStatement(sql);
		    		
		    		ResultSet rs = statement.executeQuery();
		    		
		    		DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
		    		
		    		while(rs.next()) {
		    			modelo.addRow(new Object[] {rs.getString("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("idade"), rs.getString("sexo"), rs.getString("endereço"), rs.getString("escolaridade"), rs.getString("pai"), rs.getString("mãe"), rs.getString("Descricao")});
		    			
		    		}
				
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			}});
		
		JLabel label_1 = new JLabel("");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewJgoodiesLabel_1, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_2, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_3, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_4, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_5, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_6, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_7, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_8, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel_9, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewJgoodiesLabel, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 789, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 807, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewJgoodiesLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewJgoodiesLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewJgoodiesLabel_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(161))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Idade", "Sexo", "Endere\u00E7o", "Escolaridade", "Pai", "M\u00E3e", "Descri\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(tbDados);
		contentPane.setLayout(gl_contentPane);
	}
}
