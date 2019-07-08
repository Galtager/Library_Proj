package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

import Library.LibraryActionsImpl;

public class InsertBooks {

	JFrame frmInsertBooks;
	private JTextField name_txt;
	private JTextField author_txt;
	private JTextField genre_txt;
	private JTextField publisher_txt;
	private JPanel panel;
	private JButton clear_button;
	private JButton save_button;
	private JButton close_button;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public InsertBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertBooks = new JFrame();
		frmInsertBooks.setBounds(new Rectangle(0, 0, 0, 0));
		frmInsertBooks.setTitle("Insert Books");
		frmInsertBooks.setBounds(100, 100, 450, 600);
		frmInsertBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		close_button = new JButton("Close");
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInsertBooks.dispose();
			}
		});
				
		JPanel book_details_panel = new JPanel();
		book_details_panel.setBounds(0, 0, 412, 20);
		book_details_panel.setBackground(UIManager.getColor("Button.background"));
		
		JLabel name_lbl = new JLabel("Name");
		name_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		name_lbl.setBackground(new Color(224, 255, 255));
		name_lbl.setBounds(10, 30, 106, 20);
		
		JLabel author_lbl = new JLabel("Author");
		author_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		author_lbl.setBounds(10, 50, 106, 18);
		
		JLabel genre_lbl = new JLabel("Genre");
		genre_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		genre_lbl.setBounds(10, 70, 106, 20);
		
		JLabel publisher_lbl = new JLabel("Publisher");
		publisher_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		publisher_lbl.setBounds(10, 90, 106, 20);
		
		JLabel adress_lbl = new JLabel("Adress");
		adress_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		adress_lbl.setBounds(10, 110, 106, 20);
		
		JLabel release_date_lbl = new JLabel("Release Date");
		release_date_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		release_date_lbl.setBounds(10, 110, 106, 20);
		
		name_txt = new JTextField();
		name_txt.setBounds(120, 30, 96, 20);
		name_txt.setColumns(10);
		
		author_txt = new JTextField();
		author_txt.setBounds(120, 50, 96, 20);
		author_txt.setColumns(10);
		
		genre_txt = new JTextField();
		genre_txt.setBounds(120, 70, 96, 20);
		genre_txt.setColumns(10);
		panel.setLayout(null);
		
		JLabel title_lbl = new JLabel("Book Details");
		title_lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_book_details_panel = new GroupLayout(book_details_panel);
		gl_book_details_panel.setHorizontalGroup(
			gl_book_details_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_book_details_panel.createSequentialGroup()
					.addComponent(title_lbl)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_book_details_panel.setVerticalGroup(
			gl_book_details_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_book_details_panel.createSequentialGroup()
					.addComponent(title_lbl)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		book_details_panel.setLayout(gl_book_details_panel);
		panel.add(book_details_panel);
		panel.add(publisher_lbl);
		panel.add(author_lbl);
		panel.add(release_date_lbl);
		panel.add(name_lbl);
		panel.add(author_lbl);
		panel.add(genre_lbl);
		panel.add(genre_txt);
		panel.add(author_txt);
		panel.add(name_txt);
		
		publisher_txt = new JTextField();
		publisher_txt.setColumns(10);
		publisher_txt.setBounds(120, 90, 96, 20);
		panel.add(publisher_txt);
		
		JLabel comments_lbl = new JLabel("Comments:");
		comments_lbl.setVerticalAlignment(SwingConstants.TOP);
		comments_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comments_lbl.setBounds(10, 161, 106, 101);
		panel.add(comments_lbl);
		
        JTextArea textArea = new JTextArea(0,0);
		JScrollPane comments_scrollBar = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		comments_scrollBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		comments_scrollBar.setSize(242, 100);
		comments_scrollBar.setLocation(120, 163);
        panel.add(comments_scrollBar);
        
        JDateChooser release_date_chooser = new JDateChooser();
        release_date_chooser.setBounds(120, 111, 142, 19);
        release_date_chooser.setDate(new Date());
        panel.add(release_date_chooser);
        
		save_button = new JButton("Save");
		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(genre_txt.getText() == "" || 
					author_txt.getText() == "" ||
					publisher_txt.getText() == "" ||
					release_date_chooser.getDate() == null)
				{
					Component frame = null;
					JOptionPane.showMessageDialog(frame ,
						    "Must fill in every field!.");
				}
				else
				{
					LibraryActionsImpl.insertBook(name_txt.getText(),
							genre_txt.getText(),
							author_txt.getText(),
							publisher_txt.getText(),
							release_date_chooser.getDate());
					frmInsertBooks.dispose();
				}
			}
			
		});
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name_txt.setText("");
				genre_txt.setText("");
				author_txt.setText("");
				publisher_txt.setText("");
				release_date_chooser.setDate(new Date());
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmInsertBooks.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(clear_button)
							.addGap(40)
							.addComponent(save_button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(close_button)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(close_button, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(save_button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(clear_button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
        
        
        frmInsertBooks.getContentPane().setLayout(groupLayout);
		
		
	}
}
