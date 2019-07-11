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
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.xml.transform.Templates;

import Book.Book;
import Entities.Borrower;
import Entities.User;
import LettersMaker.DelayLetter;
import LettersMaker.ExpireMaker;
import Entities.Borrower.book_error_code;
import Library.LibraryActionsImpl;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextField;
import javax.swing.Renderer;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
	
	private CardLayout card_layout;
	JPanel cards;

	
	private Book temp_borrow_book;
	private User temp_borrower_user;

	static private JComboBox books_sort_combobox;
	
	static private JComboBox client_filter_comboBox;
	
	static private JComboBox client_sort_comboBox;
	
	public static JComboBox getClient_sort_comboBox() {
		return client_sort_comboBox;
	}

	public static JComboBox getClient_filter_comboBox() {
		return client_filter_comboBox;
	}

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
	private JTextField book_code_return_text;
	private JTable titles_loaned;
	private JTextField student_ID_borrow_textfield;
	private JTextField student_name_borrow_textfield;
	private JTextField student_utilization_borrow_textfield;
	private JTextField genre_borrow_textfield;
	private JTextField title_borrow_textfield;
	private JTextField title_code_borrow_textfield;
	private User current_user;

	/**
	 * Create the application.
	 */
	public MainMenu(User logged)
	{
		current_user = logged;
		initialize();
		
		card_layout.show(cards, "name_867170013027560");
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

                Component frame = null;
				int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the application?", "Please Confirm",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                	System.exit(0);
				
			}
		});
		
		cards = new JPanel();
		cards.setBounds(0, 149, 1112, 459);
		frmLibrary.getContentPane().add(cards);
		card_layout = new CardLayout(0, 0); 
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
					"ID", "Name", "Address", "Email", "Phone", "Utilization", "Ending Date"
			}
		));
		
		
		client_sort_comboBox = new JComboBox();
		client_sort_comboBox.setBounds(568, 25, 97, 20);
		client_sort_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ascending ", "Descending"}));
		
		client_filter_comboBox = new JComboBox();
		client_filter_comboBox.setBounds(800, 26, 116, 18);
		client_filter_comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		client_filter_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "ID", "Address", "Email", "Phone"}));
		
		client_search_txt = new JTextField();
		client_search_txt.setBounds(675, 25, 115, 20);
		client_search_txt.setColumns(10);
		
		DefaultTableModel usersModel = (DefaultTableModel) student_table.getModel();
		buildUsersTable(users, usersModel);
		
		JScrollPane clients_scroll = new JScrollPane(student_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		clients_scroll.setBounds(37, 55, 1079, 305);


		JLabel client_search_lbl = new JLabel(":Search\r\n");
		client_search_lbl.setBounds(926, 28, 71, 14);
		client_search_lbl.setBackground(Color.WHITE);

		JButton client_search_button = new JButton("Search");
		client_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel booksModel = (DefaultTableModel) student_table.getModel();
				String filterBy = String.valueOf(client_filter_comboBox.getSelectedItem());
				String value = client_search_txt.getText();
				users = (ArrayList<User>) LibraryActionsImpl.filterUsersList(filterBy, value);
				
				buildUsersTable(users, usersModel);
			}
		});
		client_search_button.setBounds(455, 24, 103, 23);
		JButton student_search_button = new JButton("Search");
		student_search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		student_search_button.setBounds(455, 24, 103, 23);
		
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
				users = (ArrayList<User>) libActions.getAllUsers();
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
		JButton student_card_button = new JButton("Card");
		student_card_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		student_card_button.setBounds(709, 398, 60, 45);
		student_card_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton client_excel_button = new JButton("Excel");
		client_excel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		          if(result == JFileChooser.APPROVE_OPTION)
		          {
		        	  File f = file.getSelectedFile();
		        	  libActions.exportUsersToCSV(f);
		          }
			}
		});
		client_excel_button.setBounds(639, 398, 60, 45);
		client_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		client_panel.setLayout(null);
		client_panel.add(client_search_button);
		client_panel.add(client_sort_comboBox);
		client_panel.add(client_search_txt);
		client_panel.add(client_filter_comboBox);
		client_panel.add(client_search_lbl);
		client_panel.add(client_excel_button);
		client_panel.add(client_insert_button);
		client_panel.add(client_delete_button);
		client_panel.add(client_edit_button);
		client_panel.add(clients_scroll);
		
		JButton btnCreateLetterOf = new JButton("Create Letter Of Expiration");
		btnCreateLetterOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.doc", "doc");
				file.addChoosableFileFilter(filter);
				  
				List<User> temp = null;
				
				try
				{
					String client_id = (String) student_table.getValueAt(student_table.getSelectedRow(), 0);
					temp = users.stream().filter(user -> user.getID().equals(client_id)).
							collect(Collectors.toList());
				
				}
				catch(Exception e1) 
				{
				    JOptionPane.showMessageDialog(null, "Select row!", "Info", JOptionPane.ERROR_MESSAGE);
					    return;
				}
				  
				  int result = file.showSaveDialog(null);
				  if(result == JFileChooser.APPROVE_OPTION)
				  {
					  	File f = file.getSelectedFile();
						
						if(temp.size() != 1)
						{
					        JOptionPane.showMessageDialog(null, "Error occured", "Info", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							ExpireMaker em = new ExpireMaker();
							em.generate((Borrower) temp.get(0), f);
							JOptionPane.showMessageDialog(null, "Letter created!", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
				  }
			}
		});
		btnCreateLetterOf.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCreateLetterOf.setBounds(455, 398, 173, 45);
		client_panel.add(btnCreateLetterOf);
		
		JPanel borrow_panel = new JPanel();
		borrow_panel.setLayout(null);
		borrow_panel.setFocusTraversalKeysEnabled(false);
		borrow_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "borrow", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		borrow_panel.setBackground(new Color(204, 204, 255));
		cards.add(borrow_panel, "name_64416355333680");
		

		titles_loaned = new JTable();
		titles_loaned.setForeground(new Color(0, 0, 0));
		titles_loaned.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titles_loaned.setBackground(new Color(255, 255, 255));
		titles_loaned.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Author", "Genre", "Publisher", "Release Date", "Final return date"
			}
		));

		JScrollPane scrollPane_titlesloaned = new JScrollPane(titles_loaned,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_titlesloaned.setBounds(15, 37, 670, 383);
		scrollPane_titlesloaned.setViewportView(titles_loaned);
		borrow_panel.add(scrollPane_titlesloaned);
		
		JPanel panel_borrow1 = new JPanel();
		panel_borrow1.setBounds(695, 47, 302, 220);
		panel_borrow1.setBackground(new Color(204, 204, 255)); 
		borrow_panel.add(panel_borrow1);
		panel_borrow1.setLayout(null);
		
		JLabel student_id_label = new JLabel("Student ID");
		student_id_label.setBounds(0, 0, 103, 22);
		student_id_label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		student_id_label.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(student_id_label);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setBounds(0, 38, 103, 24);
		lblStudentName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblStudentName.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblStudentName);
		
		JLabel lblUtilization = new JLabel("Utilization");
		lblUtilization.setBounds(0, 73, 103, 23);
		lblUtilization.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		lblUtilization.setBackground(new Color(224, 255, 255));
		panel_borrow1.add(lblUtilization);
		
		student_ID_borrow_textfield = new JTextField();
		student_ID_borrow_textfield.setBounds(147, -1, 146, 25);
		panel_borrow1.add(student_ID_borrow_textfield);
		student_ID_borrow_textfield.setColumns(10);
		
		student_name_borrow_textfield = new JTextField();
		student_name_borrow_textfield.setBounds(147, 38, 146, 23);
		student_name_borrow_textfield.setColumns(10);
		student_name_borrow_textfield.setBackground(new Color(153, 153, 204));
		panel_borrow1.add(student_name_borrow_textfield);
		
		student_utilization_borrow_textfield = new JTextField();
		student_utilization_borrow_textfield.setColumns(10);
		student_utilization_borrow_textfield.setBackground(new Color(153, 153, 204));
		student_utilization_borrow_textfield.setBounds(147, 73, 146, 23);
		panel_borrow1.add(student_utilization_borrow_textfield);
		
		JLabel lblTitleCode = new JLabel("Title Code");
		lblTitleCode.setBounds(0, 107, 103, 24);
		panel_borrow1.add(lblTitleCode);
		lblTitleCode.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleCode.setBackground(new Color(224, 255, 255));
		
		title_code_borrow_textfield = new JTextField();
		title_code_borrow_textfield.setBounds(147, 107, 146, 23);
		panel_borrow1.add(title_code_borrow_textfield);
		title_code_borrow_textfield.setColumns(10);
		title_code_borrow_textfield.setBackground(new Color(255, 255, 255));
		
		title_borrow_textfield = new JTextField();
		title_borrow_textfield.setBounds(147, 134, 146, 23);
		panel_borrow1.add(title_borrow_textfield);
		title_borrow_textfield.setColumns(10);
		title_borrow_textfield.setBackground(new Color(153, 153, 204));
		
		JLabel client_borrowed_lable = new JLabel("Borrowed book for client:");
		client_borrowed_lable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		client_borrowed_lable.setBackground(new Color(224, 255, 255));
		client_borrowed_lable.setBounds(15, 11, 214, 23);
		borrow_panel.add(client_borrowed_lable);
		
		JLabel lblTitleName = new JLabel("Title Name");
		lblTitleName.setBounds(0, 134, 103, 24);
		panel_borrow1.add(lblTitleName);
		lblTitleName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblTitleName.setBackground(new Color(224, 255, 255));
		
		JLabel lblCategory = new JLabel("Genre");
		lblCategory.setBounds(0, 163, 103, 24);
		panel_borrow1.add(lblCategory);
		lblCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblCategory.setBackground(new Color(224, 255, 255));
		
		genre_borrow_textfield = new JTextField();
		genre_borrow_textfield.setBounds(147, 163, 146, 23);
		panel_borrow1.add(genre_borrow_textfield);
		genre_borrow_textfield.setColumns(10);
		genre_borrow_textfield.setBackground(new Color(153, 153, 204));
		
		JButton internal_borrow_button = new JButton("Borrow");
		internal_borrow_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(temp_borrower_user != null && temp_borrow_book != null)
				{
					if(temp_borrow_book.getCurrentBorrower() == temp_borrower_user)
					{
						 JOptionPane.showMessageDialog(null, "This user alreay owns this book!", "Info", JOptionPane.INFORMATION_MESSAGE);
						 return;
					}
					
					book_error_code ec = ((Borrower) temp_borrower_user).assignBook(temp_borrow_book); 
					if(ec == book_error_code.exceeds_amount_of_books_per_borrower)
					{
				        JOptionPane.showMessageDialog(null, "Exceeds amount of books per borrower!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(ec == book_error_code.book_unavailable)
					{
						if(!temp_borrow_book.isHoldRequested())
						{
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "Book unavailable, create hold request?" ,"Warning",dialogButton);
							if(dialogResult == JOptionPane.YES_OPTION)
							{
								temp_borrow_book.addHoldRequrest((Borrower)temp_borrower_user);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sorry already borrowd and hold requested!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						buildBorrowTable(((Borrower)temp_borrower_user).getIssuedBooks(), ((DefaultTableModel) titles_loaned.getModel()));
				        JOptionPane.showMessageDialog(null, "Book borrowed!", "Info", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
			        JOptionPane.showMessageDialog(null, "Must choose user and book!", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		internal_borrow_button.setBounds(705, 278, 91, 29);
		borrow_panel.add(internal_borrow_button);
		
		
		JButton stuent_search_borrow = new JButton("");
		stuent_search_borrow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					List<User> temp = users.stream().filter(user -> user.getID().equals(student_ID_borrow_textfield.getText().trim())).
										collect(Collectors.toList());
					
					if(temp.size() != 1)
					{
				        JOptionPane.showMessageDialog(null, "User doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{						
						temp_borrower_user = temp.get(0);
						student_name_borrow_textfield.setText(temp.get(0).getName());
						student_utilization_borrow_textfield.setText(Integer.toString(((Borrower) (temp.get(0))).getIssuedBooksCount()));
						((Borrower)temp_borrower_user).getIssuedBooks();
						
						client_borrowed_lable.setText("Borrowed book for client:" + " " + temp_borrower_user.getID());
						buildBorrowTable(((Borrower)temp_borrower_user).getIssuedBooks(), ((DefaultTableModel) titles_loaned.getModel()));
					}

			}
		});
		stuent_search_borrow.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/binoculars.png")));
		stuent_search_borrow.setBounds(1005, 50, 26, 25);
		borrow_panel.add(stuent_search_borrow);
		
		JButton book_search_borrow = new JButton("");
		book_search_borrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Book> temp = books.stream().filter(book -> String.valueOf(book.getBookID()).equals(title_code_borrow_textfield.getText().trim())).
						collect(Collectors.toList());
				
				if(temp.size() != 1)
				{
			        JOptionPane.showMessageDialog(null, "Book doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					temp_borrow_book = temp.get(0);
					title_borrow_textfield.setText(temp.get(0).getTitle());
					genre_borrow_textfield.setText(temp.get(0).getGenre());
				}
				
			}
		});
		book_search_borrow.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/binoculars.png")));
		book_search_borrow.setBounds(1005, 155, 26, 25);
		borrow_panel.add(book_search_borrow);
		
		JButton btnGenerateDelayLetter = new JButton("Generate Delay Letter");
		btnGenerateDelayLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.doc", "doc");
				file.addChoosableFileFilter(filter);
				  
				List<User> temp = null;
				
				try
				{
					temp = users.stream().filter(user -> user.getID().equals(student_ID_borrow_textfield.getText())).
							collect(Collectors.toList());
				
				}
				catch(Exception e1) 
				{
				    JOptionPane.showMessageDialog(null, "Select row!", "Info", JOptionPane.ERROR_MESSAGE);
					    return;
				}
				  
				  int result = file.showSaveDialog(null);
				  if(result == JFileChooser.APPROVE_OPTION)
				  {
					  	File f = file.getSelectedFile();
						
						if(temp.size() != 1)
						{
					        JOptionPane.showMessageDialog(null, "Error occured", "Info", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							DelayLetter dl = new DelayLetter();
							dl.generate((Borrower) temp.get(0), f);
							JOptionPane.showMessageDialog(null, "Letter created!", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
				  }
			}
				
		});
		btnGenerateDelayLetter.setBounds(815, 278, 182, 29);
		borrow_panel.add(btnGenerateDelayLetter);
				
		JPanel books_panel = new JPanel();
		books_panel.setLayout(null);
		books_panel.setFocusTraversalKeysEnabled(false);
		books_panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		books_panel.setBackground(new Color(204, 204, 255));
		cards.add(books_panel, "name_867170013027560");
		
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
		
		JButton books_excel_button = new JButton("Excel");
		books_excel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		          if(result == JFileChooser.APPROVE_OPTION)
		          {
		        	  File f = file.getSelectedFile();
		        	  libActions.exportBooksToCSV(f);
		          }
			}
		});
		books_excel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		books_excel_button.setBounds(639, 398, 60, 45);
		books_panel.add(books_excel_button);
		
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
				
				books = (ArrayList<Book>) libActions.getAllBooks();
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
		return_book_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(book_code_return_text.getText() != null)
				{
					List<Book> temp = books.stream().filter(book -> String.valueOf(book.getBookID()).equals(book_code_return_text.getText().trim())).
							collect(Collectors.toList());

					if(temp.size() != 1)
					{
				        JOptionPane.showMessageDialog(null, "Book doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Book a = temp.get(0);
						Borrower b = a.getCurrentBorrower();
						if(b != null)
						{
							b.unassignBook(a);
							buildBooksTable(((Borrower)temp_borrower_user).getIssuedBooks(), ((DefaultTableModel) titles_loaned.getModel()));
					        JOptionPane.showMessageDialog(null, "Book free!", "Error", JOptionPane.INFORMATION_MESSAGE);

						}
						else
						{
					        JOptionPane.showMessageDialog(null, "This book belong to no one!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		return_book_button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		return_book_button.setBounds(494, 161, 102, 45);
		return_panel.add(return_book_button);
		
		JLabel book_code_lable = new JLabel("Book Code:");
		book_code_lable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		book_code_lable.setBounds(343, 127, 102, 20);
		return_panel.add(book_code_lable);
		
		book_code_return_text = new JTextField() {
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
		book_code_return_text.setBounds(441, 130, 229, 20);
		return_panel.add(book_code_return_text);
		book_code_return_text.setColumns(10);
		exit_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/red-delete-button-png-5.png")));
		exit_button.setBackground(Color.LIGHT_GRAY);
		exit_button.setBounds(10, 11, 100, 127);
		frmLibrary.getContentPane().add(exit_button);
		
		JButton clients_button = new JButton("Clients");
		clients_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current_user instanceof Borrower)
				{
			        JOptionPane.showMessageDialog(null, "Can not be accessed by borrowers!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					card_layout.show(cards, "name_531361761719609");
				}
			}
		});
		clients_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		clients_button.setHorizontalTextPosition(SwingConstants.CENTER);
		clients_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/-human-male-man-people-person-profile-red-user-icon--icon--23.png")));
		clients_button.setBackground(Color.LIGHT_GRAY);
		clients_button.setBounds(996, 11, 100, 127);
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
		books_button.setBounds(886, 11, 100, 127);
		frmLibrary.getContentPane().add(books_button);
		
		JButton borrow_button = new JButton("Borrow");
		borrow_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(current_user instanceof Borrower)
				{
			        JOptionPane.showMessageDialog(null, "Can not be accessed by borrowers!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					card_layout.show(cards, "name_64416355333680");
				}
			}
		});
		borrow_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/\u200F\u200Fsvg-red-circle-left-arrow-icon-1 - \u05E2\u05D5\u05EA\u05E7.png")));
		borrow_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		borrow_button.setVerticalAlignment(SwingConstants.TOP);
		borrow_button.setHorizontalTextPosition(SwingConstants.CENTER);
		borrow_button.setBackground(Color.LIGHT_GRAY);
		borrow_button.setBounds(776, 11, 100, 127);
		frmLibrary.getContentPane().add(borrow_button);
		
		JButton return_button = new JButton("Return");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(current_user instanceof Borrower)
				{
			        JOptionPane.showMessageDialog(null, "Can not be accessed by borrowers!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					card_layout.show(cards, "name_1009959647905836");
				}
			}
		});
		return_button.setIcon(new ImageIcon(MainMenu.class.getResource("/Interface/svg-red-circle-left-arrow-icon-1.png")));
		return_button.setVerticalAlignment(SwingConstants.TOP);
		return_button.setVerticalTextPosition(SwingConstants.BOTTOM);
		return_button.setHorizontalTextPosition(SwingConstants.CENTER);
		return_button.setBackground(Color.LIGHT_GRAY);
		return_button.setBounds(666, 11, 100, 127);
		frmLibrary.getContentPane().add(return_button);
		
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
		lock_button.setBounds(120, 11, 100, 127);
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
		jm_Options.add(jb_Settings);
		
		JMenu jm_Help = new JMenu("Help");
		jm_Help.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(jm_Help);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(null, 
		        		"This library application made by May, Gal, Sapir and Lidor.", 
		        		"Info",
		        		JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jm_Help.add(btnAbout);
	}
	
	
	
	/*******************************************************************************************************************************************/

	/**    INTERNAL USERS DISPLAY ACTIONS
	
	/*******************************************************************************************************************************************/
	
	private void buildUsersTable(ArrayList<User> users, DefaultTableModel model) {
		Object rowData[]= new Object[7];
		model.setRowCount(0);
		

		if(String.valueOf(client_sort_comboBox.getSelectedItem()).trim().equals("Ascending"))
		{
			Collections.sort(users, new SortAscendingUser());
		}
		else
		{
			Collections.sort(users, new SortDescendingUser());
		}
		
	
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
				rowData[6] = ((Borrower) users.get(i)).getSubscriptionEndingDate().toString();
				model.addRow(rowData);
			}
		}
	}
	
	/*******************************************************************************************************************************************/
	
	class SortAscendingUser implements Comparator<User> 
	{ 
	    public int compare(User a, User b) 
	    { 
	    	if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Name"))
	    	{
	    		 return a.getName().compareTo(b.getName()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("ID"))
	    	{
	    		 return a.getID().compareTo(b.getID()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Address"))
	    	{
	    		 return a.getAddress().compareTo(b.getAddress()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Email"))
	    	{
	    		 return a.getEmail().compareTo(b.getEmail()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Phone"))
	    	{
	    		 return a.getPhoneNumber().compareTo(b.getPhoneNumber());
	    	}
	    	else
	    	{
	    		return 0;
	    	}
	    }
	} 
	
	/*******************************************************************************************************************************************/
	
	class SortDescendingUser implements Comparator<User> 
	{ 
		public int compare(User a, User b) 
	    { 
	    	if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Name"))
	    	{
	    		 return b.getName().compareTo(a.getName()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("ID"))
	    	{
	    		 return b.getID().compareTo(a.getID()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Address"))
	    	{
	    		 return b.getAddress().compareTo(a.getAddress()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Email"))
	    	{
	    		 return b.getEmail().compareTo(a.getEmail()); 
	    	}
	    	else if(String.valueOf(client_filter_comboBox.getSelectedItem()).trim().equals("Phone"))
	    	{
	    		 return b.getPhoneNumber().compareTo(a.getPhoneNumber());
	    	}
	    	else
	    	{
	    		return 0;
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
			Collections.sort(books, new SortAscendingBook());
		}
		else
		{
			Collections.sort(books, new SortDescendingBook());
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
	
	private void buildBorrowTable(ArrayList<Book> books, DefaultTableModel model) {
		Object rowData[]= new Object[7];
		model.setRowCount(0);

		if(String.valueOf(books_sort_combobox.getSelectedItem()).trim().equals("Ascending"))
		{
			Collections.sort(books, new SortAscendingBook());
		}
		else
		{
			Collections.sort(books, new SortDescendingBook());
		}
		
		
		for(int i = 0; i < books.size(); i++) {
			rowData[0] = books.get(i).getBookID();
			rowData[1] = books.get(i).getTitle();
			rowData[2] = books.get(i).getAuthor();
			rowData[3] = books.get(i).getGenre();
			rowData[4] = books.get(i).getPublisher();
			rowData[5] = books.get(i).getPublishingDate();
			rowData[6] = books.get(i).getReturnDate();
			
			model.addRow(rowData);
		}
	}
	
	/*******************************************************************************************************************************************/
	
	class SortAscendingBook implements Comparator<Book> 
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
	
	class SortDescendingBook implements Comparator<Book> 
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
