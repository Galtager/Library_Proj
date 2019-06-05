package Interface;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.CardLayout;
import java.awt.Component;

public class MainMenu {

	JFrame frmLibrary;
	private JTable student_table;
	private JTextField student_search_txt;
	private SystemSettings nw;
	private StudentSearch ss;
	private JTextField textField;
	private JTable books_table;
	private JTextField book_code_text;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;


	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nw = new SystemSettings();
		ss = new StudentSearch();
		frmLibrary = new JFrame();
		frmLibrary.getContentPane().setBackground(new Color(255, 255, 255));
		frmLibrary.setForeground(new Color(255, 255, 255));
		frmLibrary.setBackground(new Color(255, 255, 255));
		frmLibrary.getContentPane().setForeground(new Color(255, 255, 255));
		frmLibrary.setTitle("Library");
		frmLibrary.setResizable(false);
		frmLibrary.setBounds(100, 100, 1112, 661);
		frmLibrary.dispose();
		frmLibrary.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frmLibrary.addWindowListener( new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the application?", "Please Confirm",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            });
		frmLibrary.getContentPane().setLayout(null);
		
		JButton exit_button = new JButton("Exit");
		exit_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		exit_button.setHorizontalTextPosition(SwingConstants.CENTER);
		exit_button.setVerticalAlignment(SwingConstants.TOP);
		exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JPanel cards = new JPanel();
		cards.setBounds(0, 149, 1112, 459);
		frmLibrary.getContentPane().add(cards);
		CardLayout card_layout = new CardLayout(0, 0); 
		cards.setLayout(card_layout);
		
		JPanel student_panel = new JPanel();
		cards.add(student_panel, "name_531361761719609");
		student_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		student_panel.setFocusTraversalKeysEnabled(false);
		student_panel.setBackground(new Color(204, 204, 255));
		
		student_table = new JTable();
		student_table.setForeground(new Color(0, 0, 0));
		student_table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		student_table.setBackground(new Color(255, 255, 255));
		student_table.setModel(new DefaultTableModel(
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
					"Last Name", "First Name", "ID", "City", "Payment", "Utilization ", "Ending Date"
			}
		));
		JScrollPane Scroll = new JScrollPane(student_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Scroll.setBounds(27, 58, 1079, 305);
		
		student_search_txt = new JTextField();
		student_search_txt.setBounds(675, 25, 115, 20);
		student_search_txt.setColumns(10);
		
		JComboBox student_sort_comboBox = new JComboBox();
		student_sort_comboBox.setBounds(800, 26, 116, 18);
		student_sort_comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		student_sort_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "First Name", "ID", "City", "Payment", "Utilization ", "Ending Date"}));
		
		JLabel student_search_lbl = new JLabel(":Search\r\n");
		student_search_lbl.setBounds(926, 28, 71, 14);
		student_search_lbl.setBackground(Color.WHITE);
		
		JComboBox student_filter_comboBox = new JComboBox();
		student_filter_comboBox.setBounds(568, 25, 97, 20);
		student_filter_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		
		JButton student_search_button = new JButton("Search");
		student_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		student_search_button.setBounds(455, 24, 103, 23);
		
		JLabel student_num_lbl = new JLabel("Num of Clients:");
		student_num_lbl.setBounds(27, 26, 116, 18);
		student_num_lbl.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		student_num_lbl.setFocusCycleRoot(true);
		student_num_lbl.setBackground(SystemColor.inactiveCaptionText);
		
		JButton student_information_button = new JButton("?\r\n");
		student_information_button.setBounds(44, 369, 55, 23);
		
		JButton student_edit_button = new JButton("Edit");
		student_edit_button.setBounds(962, 398, 60, 45);
		student_edit_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton student_delete_button = new JButton("Delete");
		student_delete_button.setBounds(850, 398, 102, 45);
		student_delete_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_insert_button = new JButton("Insert");
		student_insert_button.setBounds(775, 398, 65, 45);
		student_insert_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton student_card_button = new JButton("Card");
		student_card_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		student_card_button.setBounds(709, 398, 60, 45);
		student_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_excel_button = new JButton("Excel");
		student_excel_button.setBounds(639, 398, 60, 45);
		student_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_report_button = new JButton("Report");
		student_report_button.setBounds(552, 398, 77, 45);
		student_report_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_panel.setLayout(null);
		student_panel.add(student_num_lbl);
		student_panel.add(student_search_button);
		student_panel.add(student_filter_comboBox);
		student_panel.add(student_search_txt);
		student_panel.add(student_sort_comboBox);
		student_panel.add(student_search_lbl);
		student_panel.add(student_information_button);
		student_panel.add(student_report_button);
		student_panel.add(student_excel_button);
		student_panel.add(student_card_button);
		student_panel.add(student_insert_button);
		student_panel.add(student_delete_button);
		student_panel.add(student_edit_button);
		student_panel.add(Scroll);
		
		JPanel borrow_panel = new JPanel();
		borrow_panel.setLayout(null);
		borrow_panel.setFocusTraversalKeysEnabled(false);
		borrow_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "borrow", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		borrow_panel.setBackground(new Color(204, 204, 255));
		cards.add(borrow_panel, "name_64416355333680");
		

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
					"Titles loaned"
			}
		));

		JScrollPane scrollPane_titlesloaned = new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_titlesloaned.setBounds(15, 26, 670, 134);
		scrollPane_titlesloaned.setViewportView(table_1);
		borrow_panel.add(scrollPane_titlesloaned);

		table_2 = new JTable();
		table_2.setForeground(new Color(0, 0, 0));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_2.setBackground(new Color(255, 255, 255));
		table_2.setModel(new DefaultTableModel(
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
					"History of lateness"
			}
		));
		
		JScrollPane scrollPane_History = new JScrollPane(table_2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_History.setBounds(15, 161, 670, 134);
		scrollPane_History.setViewportView(table_2);
		borrow_panel.add(scrollPane_History);
		
		table_3 = new JTable();
		table_3.setForeground(new Color(0, 0, 0));
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_3.setBackground(new Color(255, 255, 255));
		table_3.setModel(new DefaultTableModel(
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
					"Renewals"
			}
		));
		
		JScrollPane scrollPane_Renewals = new JScrollPane(table_3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_Renewals.setBounds(15, 296, 670, 134);
		scrollPane_Renewals.setViewportView(table_3);
		borrow_panel.add(scrollPane_Renewals);
		
		JPanel panel_borrow1 = new JPanel();
		panel_borrow1.setBounds(700, 16, 302, 255);
		panel_borrow1.setBackground(new Color(204, 204, 255)); 
		borrow_panel.add(panel_borrow1);
		panel_borrow1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Code");
		lblNewLabel_1.setBounds(0, 0, 103, 22);
		lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblNewLabel_1.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblNewLabel_1);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setBounds(0, 38, 103, 24);
		lblStudentName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblStudentName.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblStudentName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(0, 66, 103, 20);
		lblId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblId.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblId);
		
		JLabel lblLimitTitles = new JLabel("Limit titles");
		lblLimitTitles.setBounds(0, 92, 103, 23);
		lblLimitTitles.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblLimitTitles.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblLimitTitles);
		
		JLabel lblDelays = new JLabel("Delays");
		lblDelays.setBounds(0, 120, 103, 23);
		lblDelays.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblDelays.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblDelays);
		
		JLabel lblTitlesNotReturned = new JLabel("Titles not returned");
		lblTitlesNotReturned.setBounds(0, 147, 144, 23);
		lblTitlesNotReturned.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblTitlesNotReturned.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblTitlesNotReturned);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(0, 204, 103, 23);
		lblGrade.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblGrade.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblGrade);
		
		JLabel lblUtilization = new JLabel("Utilization");
		lblUtilization.setBounds(0, 176, 103, 23);
		lblUtilization.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblUtilization.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblUtilization);
		
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(0, 231, 103, 23);
		lblEndDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblEndDate.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblEndDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, -1, 146, 25);
		panel_borrow1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 38, 146, 23);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(153, 153, 204));
		panel_borrow1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(153, 153, 204));
		textField_3.setBounds(147, 66, 146, 23);
		panel_borrow1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(153, 153, 204));
		textField_4.setBounds(147, 93, 146, 23);
		panel_borrow1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(153, 153, 204));
		textField_5.setBounds(147, 121, 146, 23);
		panel_borrow1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(153, 153, 204));
		textField_6.setBounds(147, 148, 146, 23);
		panel_borrow1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(153, 153, 204));
		textField_7.setBounds(147, 175, 146, 23);
		panel_borrow1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(153, 153, 204));
		textField_8.setBounds(147, 203, 146, 23);
		panel_borrow1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(153, 153, 204));
		textField_9.setBounds(147, 230, 146, 23);
		panel_borrow1.add(textField_9);
		
		JPanel panel_borrow2 = new JPanel();
		panel_borrow2.setBackground(new Color(204, 204, 255));
		panel_borrow2.setBounds(700, 274, 302, 159);
		borrow_panel.add(panel_borrow2);
		panel_borrow2.setLayout(null);
		
		JLabel lblDaysOfBorrow = new JLabel("Days of borrow");
		lblDaysOfBorrow.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblDaysOfBorrow.setBackground(new Color(224, 255, 255));
		lblDaysOfBorrow.setBounds(0, 130, 132, 24);
		panel_borrow2.add(lblDaysOfBorrow);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(153, 153, 204));
		textField_10.setBounds(147, 130, 146, 23);
		panel_borrow2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(153, 153, 204));
		textField_11.setBounds(147, 104, 146, 23);
		panel_borrow2.add(textField_11);
		
		JLabel lblTitleType = new JLabel("Title type");
		lblTitleType.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleType.setBackground(new Color(224, 255, 255));
		lblTitleType.setBounds(0, 104, 103, 24);
		panel_borrow2.add(lblTitleType);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblCategory.setBackground(new Color(224, 255, 255));
		lblCategory.setBounds(0, 75, 103, 24);
		panel_borrow2.add(lblCategory);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(153, 153, 204));
		textField_12.setBounds(147, 75, 146, 23);
		panel_borrow2.add(textField_12);
		
		JLabel lblTitleName = new JLabel("Title Name");
		lblTitleName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleName.setBackground(new Color(224, 255, 255));
		lblTitleName.setBounds(0, 46, 103, 24);
		panel_borrow2.add(lblTitleName);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(153, 153, 204));
		textField_13.setBounds(147, 46, 146, 23);
		panel_borrow2.add(textField_13);
		
		JLabel lblTitleCode = new JLabel("Title Code");
		lblTitleCode.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleCode.setBackground(new Color(224, 255, 255));
		lblTitleCode.setBounds(0, 19, 103, 24);
		panel_borrow2.add(lblTitleCode);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBackground(new Color(255, 255, 255));
		textField_14.setBounds(147, 19, 146, 23);
		panel_borrow2.add(textField_14);
		
		JLabel lblNewLabel_2 = new JLabel("To execute borrow CTRL+C");
		lblNewLabel_2.setBounds(83, 0, 210, 20);
		panel_borrow2.add(lblNewLabel_2);
		
		JButton btn_borrow = new JButton("Borrow");
		btn_borrow.setBounds(1006, 257, 91, 29);
		borrow_panel.add(btn_borrow);
		
		JButton btn_Help = new JButton("Help");
		btn_Help.setBounds(1006, 325, 91, 29);
		borrow_panel.add(btn_Help);
		
		JButton btn_Report = new JButton("Report");
		btn_Report.setBounds(1006, 291, 91, 29);
		borrow_panel.add(btn_Report);
		
		JButton button_Close = new JButton("Close");
		button_Close.setBounds(1006, 391, 91, 29);
		button_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	frmLibrary.dispose();
                }
        });
		borrow_panel.add(button_Close);
		
		
		JButton button_search = new JButton("");
		button_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(!ss.frmStudentSearch.isVisible())
						{
							ss.frmStudentSearch.setVisible(true);
						}	
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
		});
		button_search.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/binoculars.png")));
		button_search.setBounds(1005, 16, 26, 25);
		borrow_panel.add(button_search);
		
		
				
		JPanel books_panel = new JPanel();
		books_panel.setLayout(null);
		books_panel.setFocusTraversalKeysEnabled(false);
		books_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		books_panel.setBackground(new Color(204, 204, 255));
		cards.add(books_panel, "name_867170013027560");
		
		JLabel num_of_books_lable = new JLabel("Num of Books:");
		num_of_books_lable.setFocusCycleRoot(true);
		num_of_books_lable.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		num_of_books_lable.setBackground(Color.BLACK);
		num_of_books_lable.setBounds(27, 26, 116, 18);
		books_panel.add(num_of_books_lable);
		
		JButton button = new JButton("Search");
		button.setBounds(455, 24, 103, 23);
		books_panel.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(568, 25, 97, 20);
		books_panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(675, 25, 115, 20);
		books_panel.add(textField);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Author", "Genre", "Release Date", "Publisher"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBox_1.setBounds(800, 26, 116, 18);
		books_panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel(":Search\r\n");
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(926, 28, 71, 14);
		books_panel.add(label_1);
		
		JButton button_1 = new JButton("?\r\n");
		button_1.setBounds(44, 369, 55, 23);
		books_panel.add(button_1);
		
		JButton button_2 = new JButton("Report");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBounds(552, 398, 77, 45);
		books_panel.add(button_2);
		
		JButton button_3 = new JButton("Excel");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_3.setBounds(639, 398, 60, 45);
		books_panel.add(button_3);
		
		JButton button_4 = new JButton("Card");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.setBounds(709, 398, 60, 45);
		books_panel.add(button_4);
		
		JButton button_5 = new JButton("Insert");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_5.setBounds(775, 398, 65, 45);
		books_panel.add(button_5);
		
		JButton button_6 = new JButton("Delete");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_6.setBounds(850, 398, 102, 45);
		books_panel.add(button_6);
		
		JButton button_7 = new JButton("Edit");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_7.setBounds(962, 398, 60, 45);
		books_panel.add(button_7);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 58, 1079, 305);
		books_panel.add(scrollPane);
		
		books_table = new JTable();
		books_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "Author", "Genre", "Publisher", "Release Date"
			}
		));
		books_table.setForeground(Color.BLACK);
		books_table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		books_table.setBackground(Color.WHITE);
		scrollPane.setViewportView(books_table);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(599, 201, 89, 23);
		
		JPanel return_panel = new JPanel();
		return_panel.setLayout(null);
		return_panel.setFocusTraversalKeysEnabled(false);
		return_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		return_panel.setBackground(new Color(204, 204, 255));
		cards.add(return_panel, "name_1009959647905836");
		
		JButton return_book_button = new JButton("Return");
		return_book_button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return_book_button.setBounds(494, 161, 102, 45);
		return_panel.add(return_book_button);
		
		JLabel book_code_lable = new JLabel("Book Code:");
		book_code_lable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		book_code_lable.setBounds(343, 127, 102, 20);
		return_panel.add(book_code_lable);
		
		book_code_text = new JTextField() {
			 public void processKeyEvent(KeyEvent ev) {
				    char c = ev.getKeyChar();
				    try {
				      // Ignore all non-printable characters. Just check the printable ones.
				      if (c > 31 && c < 127) {
				        Integer.parseInt(c + "");
				      }
				      super.processKeyEvent(ev);
				    }
				    catch (NumberFormatException nfe) {
				      // Do nothing. Character inputted is not a number, so ignore it.
				    }
				  }
		};
		book_code_text.setBounds(441, 130, 229, 20);
		return_panel.add(book_code_text);
		book_code_text.setColumns(10);
		exit_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/red-delete-button-png-5.png")));
		exit_button.setBackground(Color.LIGHT_GRAY);
		exit_button.setBounds(10, 11, 100, 127);
		frmLibrary.getContentPane().add(exit_button);
		
		JButton search_button = new JButton("Search");
		search_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		search_button.setHorizontalTextPosition(SwingConstants.CENTER);
		search_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/search-icon-clip-art_299613.png")));
		search_button.setBackground(Color.LIGHT_GRAY);
		search_button.setBounds(974, 11, 100, 127);
		frmLibrary.getContentPane().add(search_button);
		
		JButton clients_button = new JButton("Clients");
		clients_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_layout.show(cards, "name_531361761719609");
			}
		});
		clients_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		clients_button.setHorizontalTextPosition(SwingConstants.CENTER);
		clients_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/-human-male-man-people-person-profile-red-user-icon--icon--23.png")));
		clients_button.setBackground(Color.LIGHT_GRAY);
		clients_button.setBounds(864, 11, 100, 127);
		frmLibrary.getContentPane().add(clients_button);
		
		JButton books_button = new JButton("Books");
		books_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_layout.show(cards, "name_867170013027560");
			}
		});
		books_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		books_button.setHorizontalTextPosition(SwingConstants.CENTER);
		books_button.setVerticalAlignment(SwingConstants.TOP);
		books_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/books-icon--circle-iconset--martz90-18.png")));
		books_button.setBackground(Color.LIGHT_GRAY);
		books_button.setBounds(754, 11, 100, 127);
		frmLibrary.getContentPane().add(books_button);
		
		JButton borrow_button = new JButton("Borrow");
		borrow_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_layout.show(cards, "name_64416355333680");
			}
		});
		borrow_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/\u200F\u200Fsvg-red-circle-left-arrow-icon-1 - \u05E2\u05D5\u05EA\u05E7.png")));
		borrow_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		borrow_button.setVerticalAlignment(SwingConstants.TOP);
		borrow_button.setHorizontalTextPosition(SwingConstants.CENTER);
		borrow_button.setBackground(Color.LIGHT_GRAY);
		borrow_button.setBounds(644, 11, 100, 127);
		frmLibrary.getContentPane().add(borrow_button);
		
		JButton return_button = new JButton("Return");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card_layout.show(cards, "name_1009959647905836");
			}
		});
		return_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/svg-red-circle-left-arrow-icon-1.png")));
		return_button.setVerticalAlignment(SwingConstants.TOP);
		return_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		return_button.setHorizontalTextPosition(SwingConstants.CENTER);
		return_button.setBackground(Color.LIGHT_GRAY);
		return_button.setBounds(534, 11, 100, 127);
		frmLibrary.getContentPane().add(return_button);
		
		JButton home_button = new JButton("Return");
		home_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/ndldl-th.png")));
		home_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		home_button.setVerticalAlignment(SwingConstants.TOP);
		home_button.setHorizontalTextPosition(SwingConstants.CENTER);
		home_button.setBackground(Color.LIGHT_GRAY);
		home_button.setBounds(424, 11, 100, 127);
		frmLibrary.getContentPane().add(home_button);
		
		JButton lock_button = new JButton("Lock");
		lock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginDialog login_dialog = new LoginDialog();
					login_dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					login_dialog.setVisible(true);
					frmLibrary.dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		lock_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/redpad-lock-th.png")));
		lock_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		lock_button.setVerticalAlignment(SwingConstants.TOP);
		lock_button.setHorizontalTextPosition(SwingConstants.CENTER);
		lock_button.setBackground(Color.LIGHT_GRAY);
		lock_button.setBounds(314, 11, 100, 127);
		frmLibrary.getContentPane().add(lock_button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 139, 1084, 380);
		frmLibrary.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Computer Library");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/library-books.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JMenuBar menuBar = new JMenuBar();
		frmLibrary.setJMenuBar(menuBar);
		
		JMenu jm_Options = new JMenu("Options");
		jm_Options.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(jm_Options);
		
		
		JButton jb_Settings = new JButton("Settings                     F6");
		jb_Settings.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jb_Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!nw.frameClass.isVisible())
					{
						nw.frameClass.setVisible(true);
					}	
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		
		JButton jb_LibraryInformation = new JButton("Library Information    F1");
		jb_LibraryInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(jb_LibraryInformation);
		
		JButton btnWaitFormFor = new JButton("Wait form for title      F5");
		btnWaitFormFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnWaitFormFor);
		jm_Options.add(jb_Settings);
		
		JButton btnBackUpTo = new JButton("Back up to a folder     F2");
		btnBackUpTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnBackUpTo);
		
		JButton btnUsers = new JButton("Users                         F3");
		btnUsers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnUsers);
		
		JButton btnSwitchUser = new JButton("Switch user                F4");
		btnSwitchUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnSwitchUser);
		
		JButton btnImportExcelLists = new JButton("Import Excel Lists       F9");
		btnImportExcelLists.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnImportExcelLists);
		
		JButton btnExit = new JButton("Exit                     Ctrl+Q");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frmLibrary.dispose();
                }
        });
		
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Options.add(btnExit);
		
		JMenu jm_Edit = new JMenu("Edit");
		jm_Edit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(jm_Edit);
		
		JButton btnEditTitleDetails = new JButton("Edit title details                F7");
		btnEditTitleDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Edit.add(btnEditTitleDetails);
		
		JButton btnEditStudentInforamtion = new JButton("Edit student inforamtion   F8");
		btnEditStudentInforamtion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Edit.add(btnEditStudentInforamtion);
		
		JMenu jm_Help = new JMenu("Help");
		jm_Help.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(jm_Help);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Help.add(btnAbout);
	}
}
