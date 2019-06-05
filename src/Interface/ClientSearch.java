package Interface; 

 import javax.swing.JFrame; 
import javax.swing.JPanel; 
import java.awt.Rectangle; 
import javax.swing.table.DefaultTableModel;
import java.awt.Color; 
import javax.swing.JLabel; 
import java.awt.Font; 
import javax.swing.JTextField; 
import javax.swing.ScrollPaneConstants; 
import javax.swing.JComboBox; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
 
public class ClientSearch { 
 
	JFrame frmStudentSearch; 
	private JTextField textField_Search;
	private JTable table_1;
	private JTextField txt_Search;
 
	/** 
	 * Launch the application. 
	 */ 
 
	/** 
	 * Create the application. 
	 */ 
	public ClientSearch() { 
		initialize(); 
	} 
 
	/** 
	 * Initialize the contents of the frame. 
	 */ 
	private void initialize() { 
		frmStudentSearch = new JFrame(); 
		frmStudentSearch.setBounds(new Rectangle(0, 0, 0, 0)); 
		frmStudentSearch.setTitle("Student Search"); 
		frmStudentSearch.setBounds(100, 100, 785, 424); 
		frmStudentSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStudentSearch.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 763, 368);
		frmStudentSearch.getContentPane().add(panel);
		
		JLabel Label_Search = new JLabel("Search:");
		Label_Search.setBounds(15, 16, 82, 20);
		Label_Search.setFont(new Font("Tahoma", Font.BOLD, 18));
	
		String[] messageStirngs = {"Student name", "Student code"};
		JComboBox comboBox_Search = new JComboBox(messageStirngs);
		comboBox_Search.setBounds(94, 14, 308, 26);
		panel.setLayout(null);
		
		textField_Search = new JTextField();
		textField_Search.setBounds(406, 14, 219, 26);
		panel.add(textField_Search);
		textField_Search.setColumns(10);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
					"Student code" , "Student name", "grade"
			}
		));
		JScrollPane scrollPane_Search = new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane_Search.setBounds(25, 44, 707, 276);
		scrollPane_Search.setViewportView(table_1);
		panel.add(scrollPane_Search);
		
	
		panel.add(Label_Search);
		panel.add(comboBox_Search);
		
		txt_Search = new JTextField();
		txt_Search.setBackground(new Color(153, 153, 204));
		txt_Search.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_Search.setText("Press the Enter key or double-click the desired entry");
		txt_Search.setBounds(25, 326, 707, 26);
		panel.add(txt_Search);
		txt_Search.setColumns(10);
		
	} 
} 

