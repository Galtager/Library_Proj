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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

import Book.Book;
import Entities.Borrower;
import Entities.User;
import Library.LibraryActionsImpl;

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
	private JTextField client_search_txt;
	private SystemSettings nw;
	private ClientRegistration cr;
	private InsertBooks ib;
	private LibraryActionsImpl libActions = new LibraryActionsImpl();
	private ArrayList<Book> books = (ArrayList<Book>) libActions.getAllBooks();
	private ArrayList<User> users = (ArrayList<User>) libActions.getAllUsers();

	static private JComboBox books_sort_combobox;
	
	public static JComboBox getBooks_sort_combobox() {
		return books_sort_combobox;
	}

	static private JComboBox books_filter_combobox;
	
	public static JComboBox getBooks_filter_combobox() {
		return books_filter_combobox;
	}

	private JTextField books_textfield;
	private ClientSearch client_search_form;
	private JTable books_table;
	private JTextField book_code_text;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField student_code_textfield;
	private JTextField student_name_textfield;
	private JTextField student_id_textfield;
	private JTextField student_limit_titles_textfield;
	private JTextField student_delays_textfield;
	private JTextField student_not_returned_textfield;
	private JTextField student_utilization_textfield;
	private JTextField student_grade_textfield;
	private JTextField student_end_date_textfield;
	private JTextField student_days_textfield;
	private JTextField student_type_textfield;
	private JTextField student_category_textfield;
	private JTextField student_title_name_textfield;
	private JTextField student_title_code_textfield;


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
		cr = new ClientRegistration();
		ib = new InsertBooks();
		client_search_form = new ClientSearch();
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
		
		JPanel client_panel = new JPanel();
		cards.add(client_panel, "name_531361761719609");
		client_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		client_panel.setFocusTraversalKeysEnabled(false);
		client_panel.setBackground(new Color(204, 204, 255));
		
		student_table = new JTable();
		student_table.setForeground(new Color(0, 0, 0));
		student_table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		student_table.setBackground(new Color(255, 255, 255));
		student_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Address", "Email", "Phone", "Utilization"
			}
		));
		
		DefaultTableModel usersModel = (DefaultTableModel) student_table.getModel();
		buildUsersTable(users, usersModel);
		
		JScrollPane clients_scroll = new JScrollPane(student_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		clients_scroll.setBounds(37, 55, 1079, 305);
		
		client_search_txt = new JTextField();
		client_search_txt.setBounds(675, 25, 115, 20);
		client_search_txt.setColumns(10);
		
		JComboBox client_filter_comboBox = new JComboBox();
		client_filter_comboBox.setBounds(800, 26, 116, 18);
		client_filter_comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		client_filter_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Last Name", "First Name", "ID", "City", "Payment", "Utilization ", "Ending Date"}));
		
		JLabel client_search_lbl = new JLabel(":Search\r\n");
		client_search_lbl.setBounds(926, 28, 71, 14);
		client_search_lbl.setBackground(Color.WHITE);
		
		JComboBox client_sort_comboBox = new JComboBox();
		client_sort_comboBox.setBounds(568, 25, 97, 20);
		client_sort_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		
		JButton client_search_button = new JButton("Search");
		client_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		client_search_button.setBounds(455, 24, 103, 23);
		JButton student_search_button = new JButton("Search");
		student_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		student_search_button.setBounds(455, 24, 103, 23);
		
		JLabel client_num_lbl = new JLabel("Num of Clients:");
		client_num_lbl.setBounds(27, 26, 116, 18);
		client_num_lbl.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		client_num_lbl.setFocusCycleRoot(true);
		client_num_lbl.setBackground(SystemColor.inactiveCaptionText);
		
		JButton client_information_button = new JButton("?\r\n");
		client_information_button.setBounds(44, 369, 55, 23);
		
		JButton client_edit_button = new JButton("Edit");
		client_edit_button.setBounds(962, 398, 60, 45);
		client_edit_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		client_edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton client_delete_button = new JButton("Delete");
		client_delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String client_id = (String) student_table.getValueAt(student_table.getSelectedRow(), 0);
					libActions.deleteUser(client_id);
				}
				catch (Exception e) {
					// Do nothing
				}
				
				buildUsersTable(users, usersModel);
			}
		});
		client_delete_button.setBounds(850, 398, 102, 45);
		client_delete_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton client_insert_button = new JButton("Insert");
		client_insert_button.setBounds(775, 398, 65, 45);
		client_insert_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		client_insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!cr.frmClientRegistration.isVisible())
					{
						cr.frmClientRegistration.setVisible(true);
					}	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton client_card_button = new JButton("Card");
		client_card_button.setBounds(709, 398, 60, 45);
		client_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JButton student_card_button = new JButton("Card");
		student_card_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		student_card_button.setBounds(709, 398, 60, 45);
		student_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton client_excel_button = new JButton("Excel");
		client_excel_button.setBounds(639, 398, 60, 45);
		client_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton client_report_button = new JButton("Report");
		client_report_button.setBounds(552, 398, 77, 45);
		client_report_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		client_panel.setLayout(null);
		client_panel.add(client_num_lbl);
		client_panel.add(client_search_button);
		client_panel.add(client_sort_comboBox);
		client_panel.add(client_search_txt);
		client_panel.add(client_filter_comboBox);
		client_panel.add(client_search_lbl);
		client_panel.add(client_information_button);
		client_panel.add(client_report_button);
		client_panel.add(client_excel_button);
		client_panel.add(client_card_button);
		client_panel.add(client_insert_button);
		client_panel.add(client_delete_button);
		client_panel.add(client_edit_button);
		client_panel.add(clients_scroll);
		
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
		
		student_code_textfield = new JTextField();
		student_code_textfield.setBounds(147, -1, 146, 25);
		panel_borrow1.add(student_code_textfield);
		student_code_textfield.setColumns(10);
		
		student_name_textfield = new JTextField();
		student_name_textfield.setBounds(147, 38, 146, 23);
		student_name_textfield.setColumns(10);
		student_name_textfield.setBackground(new Color(153, 153, 204));
		panel_borrow1.add(student_name_textfield);
		
		student_id_textfield = new JTextField();
		student_id_textfield.setColumns(10);
		student_id_textfield.setBackground(new Color(153, 153, 204));
		student_id_textfield.setBounds(147, 66, 146, 23);
		panel_borrow1.add(student_id_textfield);
		
		student_limit_titles_textfield = new JTextField();
		student_limit_titles_textfield.setColumns(10);
		student_limit_titles_textfield.setBackground(new Color(153, 153, 204));
		student_limit_titles_textfield.setBounds(147, 93, 146, 23);
		panel_borrow1.add(student_limit_titles_textfield);
		
		student_delays_textfield = new JTextField();
		student_delays_textfield.setColumns(10);
		student_delays_textfield.setBackground(new Color(153, 153, 204));
		student_delays_textfield.setBounds(147, 121, 146, 23);
		panel_borrow1.add(student_delays_textfield);
		
		student_not_returned_textfield = new JTextField();
		student_not_returned_textfield.setColumns(10);
		student_not_returned_textfield.setBackground(new Color(153, 153, 204));
		student_not_returned_textfield.setBounds(147, 148, 146, 23);
		panel_borrow1.add(student_not_returned_textfield);
		
		student_utilization_textfield = new JTextField();
		student_utilization_textfield.setColumns(10);
		student_utilization_textfield.setBackground(new Color(153, 153, 204));
		student_utilization_textfield.setBounds(147, 175, 146, 23);
		panel_borrow1.add(student_utilization_textfield);
		
		student_grade_textfield = new JTextField();
		student_grade_textfield.setColumns(10);
		student_grade_textfield.setBackground(new Color(153, 153, 204));
		student_grade_textfield.setBounds(147, 203, 146, 23);
		panel_borrow1.add(student_grade_textfield);
		
		student_end_date_textfield = new JTextField();
		student_end_date_textfield.setColumns(10);
		student_end_date_textfield.setBackground(new Color(153, 153, 204));
		student_end_date_textfield.setBounds(147, 230, 146, 23);
		panel_borrow1.add(student_end_date_textfield);
		
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
		
		student_days_textfield = new JTextField();
		student_days_textfield.setColumns(10);
		student_days_textfield.setBackground(new Color(153, 153, 204));
		student_days_textfield.setBounds(147, 130, 146, 23);
		panel_borrow2.add(student_days_textfield);
		
		student_type_textfield = new JTextField();
		student_type_textfield.setColumns(10);
		student_type_textfield.setBackground(new Color(153, 153, 204));
		student_type_textfield.setBounds(147, 104, 146, 23);
		panel_borrow2.add(student_type_textfield);
		
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
		
		student_category_textfield = new JTextField();
		student_category_textfield.setColumns(10);
		student_category_textfield.setBackground(new Color(153, 153, 204));
		student_category_textfield.setBounds(147, 75, 146, 23);
		panel_borrow2.add(student_category_textfield);
		
		JLabel lblTitleName = new JLabel("Title Name");
		lblTitleName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleName.setBackground(new Color(224, 255, 255));
		lblTitleName.setBounds(0, 46, 103, 24);
		panel_borrow2.add(lblTitleName);
		
		student_title_name_textfield = new JTextField();
		student_title_name_textfield.setColumns(10);
		student_title_name_textfield.setBackground(new Color(153, 153, 204));
		student_title_name_textfield.setBounds(147, 46, 146, 23);
		panel_borrow2.add(student_title_name_textfield);
		
		JLabel lblTitleCode = new JLabel("Title Code");
		lblTitleCode.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleCode.setBackground(new Color(224, 255, 255));
		lblTitleCode.setBounds(0, 19, 103, 24);
		panel_borrow2.add(lblTitleCode);
		
		student_title_code_textfield = new JTextField();
		student_title_code_textfield.setColumns(10);
		student_title_code_textfield.setBackground(new Color(255, 255, 255));
		student_title_code_textfield.setBounds(147, 19, 146, 23);
		panel_borrow2.add(student_title_code_textfield);
		
		JLabel lblNewLabel_2 = new JLabel("To execute borrow CTRL+C");
		lblNewLabel_2.setBounds(83, 0, 210, 20);
		panel_borrow2.add(lblNewLabel_2);
		
		JButton internal_borrow_button = new JButton("Borrow");
		internal_borrow_button.setBounds(1006, 257, 91, 29);
		borrow_panel.add(internal_borrow_button);
		
		JButton help_button = new JButton("Help");
		help_button.setBounds(1006, 325, 91, 29);
		borrow_panel.add(help_button);
		
		JButton report_button = new JButton("Report");
		report_button.setBounds(1006, 291, 91, 29);
		borrow_panel.add(report_button);
		
		
		JButton button_search = new JButton("");
		button_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(!client_search_form.frmStudentSearch.isVisible())
						{
							client_search_form.frmStudentSearch.setVisible(true);
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
		
		books_sort_combobox = new JComboBox();
		books_sort_combobox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		books_sort_combobox.setSelectedIndex(0);
		books_sort_combobox.setBounds(568, 25, 97, 20);
		books_panel.add(books_sort_combobox);
		
		books_textfield = new JTextField();
		books_textfield.setColumns(10);
		books_textfield.setBounds(675, 25, 115, 20);
		books_panel.add(books_textfield);
		
		books_filter_combobox = new JComboBox();
		books_filter_combobox.setModel(new DefaultComboBoxModel(new String[] {"Title", "Author", "Genre", "Release Date", "Publisher"}));
		books_filter_combobox.setSelectedIndex(0);
		books_filter_combobox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		books_filter_combobox.setBounds(800, 26, 116, 18);
		books_panel.add(books_filter_combobox);
		
		JButton books_search_button = new JButton("Search");
		books_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel booksModel = (DefaultTableModel) books_table.getModel();
				String filterBy = String.valueOf(books_filter_combobox.getSelectedItem());
				String value = books_textfield.getText();
				books = (ArrayList<Book>) LibraryActionsImpl.filterBookList(filterBy, value);
				
				buildBooksTable(books, booksModel);
			}
		});
		books_search_button.setBounds(455, 24, 103, 23);
		books_panel.add(books_search_button);
		

		
		JLabel books_search_label = new JLabel(":Search\r\n");
		books_search_label.setBackground(Color.WHITE);
		books_search_label.setBounds(926, 28, 71, 14);
		books_panel.add(books_search_label);
		
		JButton books_report_button = new JButton("Report");
		books_report_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_report_button.setBounds(552, 398, 77, 45);
		books_panel.add(books_report_button);
		
		JButton books_excel_button = new JButton("Excel");
		books_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_excel_button.setBounds(639, 398, 60, 45);
		books_panel.add(books_excel_button);
		
		JButton books_card_button = new JButton("Card");
		books_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_card_button.setBounds(709, 398, 60, 45);
		books_panel.add(books_card_button);
		
		JButton books_insert_button = new JButton("Insert");
		books_insert_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_insert_button.setBounds(775, 398, 65, 45);
		books_panel.add(books_insert_button);
		books_insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!ib.frmInsertBooks.isVisible())
					{
						ib.frmInsertBooks.setVisible(true);
					}	
				} catch (Exception e1) {
					e1.printStackTrace();
				
			}
			}});
		
		JButton books_edit_button = new JButton("Edit");
		books_edit_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_edit_button.setBounds(962, 398, 60, 45);
		books_panel.add(books_edit_button);
		
		JScrollPane books_scroll = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		books_scroll.setBounds(27, 58, 1079, 305);
		books_panel.add(books_scroll);
		
		books_table = new JTable();
		books_table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Author", "Genre", "Publisher", "Release Date"
				}));
		
		DefaultTableModel booksModel = (DefaultTableModel) books_table.getModel();
		buildBooksTable(books, booksModel);
		

		
		books_table.setForeground(Color.BLACK);
		books_table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		books_table.setBackground(Color.WHITE);
		books_scroll.setViewportView(books_table);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(599, 201, 89, 23);
		
		
		JButton books_delete_button = new JButton("Delete");
		books_delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					int book_id = (int) books_table.getValueAt(books_table.getSelectedRow(), 0);
					libActions.deleteBook(book_id);
				}
				catch (Exception e) {
					// Do nothing
				}
				
				buildBooksTable(books, booksModel);
			}
		});
		
		books_delete_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_delete_button.setBounds(850, 398, 102, 45);
		books_panel.add(books_delete_button);
		
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
	
	
	
	/*******************************************************************************************************************************************/

	/**    INTERNAL USERS DISPLAY ACTIONS
	
	/*******************************************************************************************************************************************/
	
	private void buildUsersTable(ArrayList<User> users, DefaultTableModel model) {
		Object rowData[]= new Object[6];
		model.setRowCount(0);
	
		for(int i = 0; i < users.size(); i++) {
			// Only show borrowers
			if(users.get(i) instanceof Borrower)
			{
				rowData[0] = users.get(i).getID();
				rowData[1] = users.get(i).getName();
				rowData[2] = users.get(i).getAddress();
				rowData[3] = users.get(i).getEmail();
				rowData[4] = users.get(i).getPhoneNumber();
				rowData[5] = ((Borrower) users.get(i)).getIssuedBooksCount();
				model.addRow(rowData);
			}
		}
	}
	
	/*******************************************************************************************************************************************/

	/**    INTERNAL BOOKS DISPLAY ACTIONS
	
	/*******************************************************************************************************************************************/
	
	private void buildBooksTable(ArrayList<Book> books, DefaultTableModel model) {
		Object rowData[]= new Object[6];
		model.setRowCount(0);

		if(String.valueOf(books_sort_combobox.getSelectedItem()).trim().equals("Ascending"))
		{
			Collections.sort(books, new SortAscending());
		}
		else
		{
			Collections.sort(books, new SortDescending());
		}
		
		
		for(int i = 0; i < books.size(); i++) {
			rowData[0] = books.get(i).getBookID();
			rowData[1] = books.get(i).getTitle();
			rowData[2] = books.get(i).getAuthor();
			rowData[3] = books.get(i).getGenre();
			rowData[4] = books.get(i).getPublisher();
			rowData[5] = books.get(i).getPublishingDate();
			
			model.addRow(rowData);
		}
	}
	
	/*******************************************************************************************************************************************/
	
	class SortAscending implements Comparator<Book> 
	{ 
	    public int compare(Book a, Book b) 
	    { 
	    	if(String.valueOf(books_filter_combobox.getSelectedItem()).trim().equals("Author"))
	    	{
	    		 return a.getAuthor().compareTo(b.getAuthor()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).trim().equals("Genre"))
	    	{
	    		 return a.getGenre().compareTo(b.getGenre()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).trim().equals("Title"))
	    	{
	    		 return a.getTitle().compareTo(b.getTitle()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).trim().equals("Publisher"))
	    	{
	    		 return a.getPublisher().compareTo(b.getPublisher()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).trim().equals("Release Date"))
	    	{
	    		 return a.getPublishingDate().compareTo(b.getPublishingDate());
	    	}
	    	else
	    	{
	    		return 0;
	    	}
	    }
	} 
	
	/*******************************************************************************************************************************************/
	
	class SortDescending implements Comparator<Book> 
	{ 
	    public int compare(Book a, Book b) 
	    { 
	    	if(String.valueOf(books_filter_combobox.getSelectedItem()).equals("Author"))
	    	{
	    		 return b.getAuthor().compareTo(a.getAuthor()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).equals("Genre"))
	    	{
	    		 return b.getGenre().compareTo(a.getGenre()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).equals("Title"))
	    	{
	    		 return b.getTitle().compareTo(a.getTitle()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).equals("Publisher"))
	    	{
	    		 return b.getPublisher().compareTo(a.getPublisher()); 
	    	}
	    	else if(String.valueOf(books_filter_combobox.getSelectedItem()).equals("Release Date"))
	    	{
	    		 return b.getPublishingDate().compareTo(a.getPublishingDate());
	    	}
	    	else
	    	{
	    		return 0;
	    	}
	    } 
	} 
}
