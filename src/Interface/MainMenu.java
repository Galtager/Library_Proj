package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class MainMenu {

	JFrame frmLibrary;
	private JTable table;
	private JTable student_table;
	private JTextField student_search_txt;

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
		frmLibrary = new JFrame();
		frmLibrary.setFont(null);
		frmLibrary.setBackground(new Color(240, 240, 240));
		frmLibrary.setTitle("Library");
		frmLibrary.setResizable(false);
		frmLibrary.setBounds(100, 100, 1118, 636);
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		clients_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		clients_button.setHorizontalTextPosition(SwingConstants.CENTER);
		clients_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/-human-male-man-people-person-profile-red-user-icon--icon--23.png")));
		clients_button.setBackground(Color.LIGHT_GRAY);
		clients_button.setBounds(864, 11, 100, 127);
		frmLibrary.getContentPane().add(clients_button);
		
		JButton books_button = new JButton("Books");
		books_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		books_button.setHorizontalTextPosition(SwingConstants.CENTER);
		books_button.setVerticalAlignment(SwingConstants.TOP);
		books_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/books-icon--circle-iconset--martz90-18.png")));
		books_button.setBackground(Color.LIGHT_GRAY);
		books_button.setBounds(754, 11, 100, 127);
		frmLibrary.getContentPane().add(books_button);
		
		JButton borrow_button = new JButton("Borrow");
		borrow_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/\u200F\u200Fsvg-red-circle-left-arrow-icon-1 - \u05E2\u05D5\u05EA\u05E7.png")));
		borrow_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		borrow_button.setVerticalAlignment(SwingConstants.TOP);
		borrow_button.setHorizontalTextPosition(SwingConstants.CENTER);
		borrow_button.setBackground(Color.LIGHT_GRAY);
		borrow_button.setBounds(644, 11, 100, 127);
		frmLibrary.getContentPane().add(borrow_button);
		
		JButton return_button = new JButton("Return");
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
		lock_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/redpad-lock-th.png")));
		lock_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		lock_button.setVerticalAlignment(SwingConstants.TOP);
		lock_button.setHorizontalTextPosition(SwingConstants.CENTER);
		lock_button.setBackground(Color.LIGHT_GRAY);
		lock_button.setBounds(314, 11, 100, 127);
		frmLibrary.getContentPane().add(lock_button);
		
		JPanel student_panel = new JPanel();
		student_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		student_panel.setFocusTraversalKeysEnabled(false);
		student_panel.setBackground(new Color(204, 204, 255));
		student_panel.setBounds(-20, 149, 1122, 459);
		frmLibrary.getContentPane().add(student_panel);
		
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
				 "תשלום", "תאריך סיום", "ניצול", "הגבלת כותרות", "ישוב", "כיתה", "ת_ז", "שם_פרטי", "שם_משפחה", "קוד_תלמיד"
			}
		));
		JScrollPane Scroll = new JScrollPane(student_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		student_search_txt = new JTextField();
		student_search_txt.setColumns(10);
		
		JComboBox student_sort_comboBox = new JComboBox();
		student_sort_comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		student_sort_comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u05E7\u05D5\u05D3_\u05EA\u05DC\u05DE\u05D9\u05D3", "\u05E9\u05DD_\u05DE\u05E9\u05E4\u05D7\u05D4", "\u05E9\u05DD_\u05E4\u05E8\u05D8\u05D9", "\u05EA_\u05D6", "\u05DB\u05D9\u05EA\u05D4", "\u05D9\u05E9\u05D5\u05D1", "\u05D4\u05D2\u05D1\u05DC\u05EA_\u05DB\u05D5\u05EA\u05E8\u05D5\u05EA", "\u05E0\u05D9\u05E6\u05D5\u05DC", "\u05EA\u05D0\u05E8\u05D9\u05DA \u05E1\u05D9\u05D5\u05DD", "\u05EA\u05E9\u05DC\u05D5\u05DD"}));
		
		JLabel student_search_lbl = new JLabel(":Search\r\n");
		student_search_lbl.setBackground(Color.WHITE);
		
		JComboBox student_filter_comboBox = new JComboBox();
		student_filter_comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u05E1\u05D3\u05E8 \u05E2\u05D5\u05DC\u05D4", "\u05E1\u05D3\u05E8 \u05D9\u05D5\u05E8\u05D3"}));
		
		JButton student_search_button = new JButton("Search");
		
		JCheckBox student_externalsearch_chckbx = new JCheckBox("External search");
		student_externalsearch_chckbx.setBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")));
		student_externalsearch_chckbx.setBackground(SystemColor.activeCaptionBorder);
		
		JLabel student_num_lbl = new JLabel("Num of Clients:");
		student_num_lbl.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		student_num_lbl.setFocusCycleRoot(true);
		student_num_lbl.setBackground(SystemColor.inactiveCaptionText);
		
		JButton student_information_button = new JButton("?\r\n");
		
		JButton student_close_button = new JButton("Close\r\n");
		student_close_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton student_edit_button = new JButton("Edit");
		student_edit_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_edit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton student_delete_button = new JButton("Delete");
		student_delete_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_insert_button = new JButton("Insert");
		student_insert_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		student_insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton student_card_button = new JButton("Card");
		student_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_excel_button = new JButton("Excel");
		student_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton student_report_button = new JButton("Report");
		student_report_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JCheckBox student_borrowrep_chcbx = new JCheckBox("\u05D4\u05E6\u05D2 \u05D3\u05D5\u05D7 \u05D4\u05E9\u05D0\u05DC\u05D5\u05EA \u05D2\u05D5\u05E8\u05E3.\r\n");
		student_borrowrep_chcbx.setBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")));
		student_borrowrep_chcbx.setToolTipText("");
		student_borrowrep_chcbx.setBackground(SystemColor.activeCaptionBorder);
		
		JCheckBox student_studentsort_chcbx = new JCheckBox("\u05D4\u05E4\u05E8\u05D3 \u05D3\u05E4\u05D9\u05DD \u05DC\u05DB\u05DC \u05EA\u05DC\u05DE\u05D9\u05D3.");
		student_studentsort_chcbx.setBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")));
		student_studentsort_chcbx.setBackground(SystemColor.activeCaptionBorder);
		student_studentsort_chcbx.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_student_panel = new GroupLayout(student_panel);
		gl_student_panel.setHorizontalGroup(
			gl_student_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_student_panel.createSequentialGroup()
					.addGap(260)
					.addComponent(student_num_lbl, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(student_externalsearch_chckbx)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(student_search_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(student_filter_comboBox, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(student_search_txt, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(student_sort_comboBox, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(student_search_lbl)
					.addGap(123))
				.addGroup(gl_student_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(student_information_button, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1068, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_student_panel.createSequentialGroup()
					.addGroup(gl_student_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(student_borrowrep_chcbx)
						.addGroup(gl_student_panel.createSequentialGroup()
							.addContainerGap(422, Short.MAX_VALUE)
							.addComponent(student_studentsort_chcbx)))
					.addGap(10)
					.addComponent(student_report_button, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(student_excel_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(student_card_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(student_insert_button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(student_delete_button, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(student_edit_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(student_close_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
				.addGroup(gl_student_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 1079, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_student_panel.setVerticalGroup(
			gl_student_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_student_panel.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_student_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(student_search_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(student_sort_comboBox, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(student_search_lbl)
						.addComponent(student_search_button)
						.addComponent(student_externalsearch_chckbx)
						.addComponent(student_num_lbl)
						.addComponent(student_filter_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Scroll, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_student_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_student_panel.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_student_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(student_excel_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_card_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_insert_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_delete_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_edit_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_close_button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(student_report_button, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(19))
						.addGroup(gl_student_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(student_information_button)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(student_borrowrep_chcbx)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(student_studentsort_chcbx)
							.addGap(18)))
					.addGap(3))
		);
		student_panel.setLayout(gl_student_panel);
		


		
			}
	}
