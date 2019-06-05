package Interface;

import java.awt.EventQueue;

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
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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
import javax.swing.JDialog;
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
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JTextPane;

public class MainMenu {

	JFrame frmLibrary;
	private JTable table;
	private JTable student_table;
	private JTextField client_search_txt;
	private SystemSettings nw;
	private ClientRegistration cr;
	private InsertBooks ib;
	
	private JTextField books_textfield;
	private JTable books_table;
	private JTextField book_code_text;


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
		JScrollPane clients_scroll = new JScrollPane(student_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		clients_scroll.setBounds(27, 58, 1079, 305);
		
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
		client_search_button.setBounds(455, 24, 103, 23);
		
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

			
			}});
		
		JButton client_card_button = new JButton("Card");
		client_card_button.setBounds(709, 398, 60, 45);
		client_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
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
		
		JButton books_search_button = new JButton("Search");
		books_search_button.setBounds(455, 24, 103, 23);
		books_panel.add(books_search_button);
		
		JComboBox books_sort_combobox = new JComboBox();
		books_sort_combobox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		books_sort_combobox.setSelectedIndex(0);
		books_sort_combobox.setBounds(568, 25, 97, 20);
		books_panel.add(books_sort_combobox);
		
		books_textfield = new JTextField();
		books_textfield.setColumns(10);
		books_textfield.setBounds(675, 25, 115, 20);
		books_panel.add(books_textfield);
		
		JComboBox books_filter_combobox = new JComboBox();
		books_filter_combobox.setModel(new DefaultComboBoxModel(new String[] {"Author", "Genre", "Release Date", "Publisher"}));
		books_filter_combobox.setSelectedIndex(0);
		books_filter_combobox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		books_filter_combobox.setBounds(800, 26, 116, 18);
		books_panel.add(books_filter_combobox);
		
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
		
		
		JButton books_delete_button = new JButton("Delete");
		books_delete_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_delete_button.setBounds(850, 398, 102, 45);
		books_panel.add(books_delete_button);
		
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
		books_scroll.setViewportView(books_table);
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
