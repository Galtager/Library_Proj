package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class Menu {

	private JFrame frame;
	private JMenuItem mntmExit;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initComponents();
		creatEvents();

	}


	
	//////////////////////////////////////////////////////////
	//This method contains all of the code for creating and
	// initializing components
	//////////////////////////////////////////////////////////
	private void initComponents() {
	{
		/**
		 * Initialize the contents of the frame.
		 */
			frame = new JFrame();
			frame.setBounds(0, 0,1920, 1080 );
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPopupMenu popupMenu = new JPopupMenu();
			addPopup(frame.getContentPane(), popupMenu);
			
			JMenuItem mntmCopy = new JMenuItem("Copy");
			mntmCopy.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			popupMenu.add(mntmCopy);
			
			JButton btnEvent = new JButton("\r\n\r\nEvents");
			btnEvent.setIcon(new ImageIcon(Menu.class.getResource("/Interface/events.png")));
			btnEvent.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setLocation(new Point(50, 30));
			btnSearch.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Search.png")));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnClients = new JButton("Clients");
			btnClients.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Client.png")));
			btnClients.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnTitles = new JButton("Titles");
			btnTitles.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Titles.png")));
			btnTitles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnTitles.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnBorrow = new JButton("Borrow");
			btnBorrow.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Borrow.png")));
			btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnReturn = new JButton("Return");
			btnReturn.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Return.png")));
			btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnData = new JButton("Data");
			btnData.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Information.png")));
			btnData.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JButton btnSystemadmin = new JButton("SystemAdmin");
			btnSystemadmin.setIcon(new ImageIcon(Menu.class.getResource("/Interface/Admin.png")));
			btnSystemadmin.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			btnExit = new JButton("Exit");
			btnExit.setIcon(new ImageIcon(Menu.class.getResource("/Interface/exit.jpg")));
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 22));
			
			JSeparator separator = new JSeparator();
			separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			separator.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(separator))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(18)
								.addComponent(btnSearch)
								.addGap(5)
								.addComponent(btnClients)
								.addGap(5)
								.addComponent(btnTitles)
								.addGap(5)
								.addComponent(btnBorrow)
								.addGap(5)
								.addComponent(btnReturn)
								.addGap(5)
								.addComponent(btnEvent)
								.addGap(5)
								.addComponent(btnData)
								.addGap(5)
								.addComponent(btnSystemadmin)
								.addGap(5)
								.addComponent(btnExit)))
						.addContainerGap(19, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnSearch)
							.addComponent(btnClients)
							.addComponent(btnTitles)
							.addComponent(btnBorrow)
							.addComponent(btnReturn)
							.addComponent(btnEvent)
							.addComponent(btnData)
							.addComponent(btnSystemadmin)
							.addComponent(btnExit))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(845, Short.MAX_VALUE))
			);
			frame.getContentPane().setLayout(groupLayout);
			
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JMenu mnOptions = new JMenu("Options");
			mnOptions.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnOptions);
			
			mntmExit = new JMenuItem("Exit");
			mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 20));

			mnOptions.add(mntmExit);
			
			JMenu mnEdit = new JMenu("Edit");
			mnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnEdit);
			
			JMenu mnHelp = new JMenu("Help");
			mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			menuBar.add(mnHelp);
		}
	}

//////////////////////////////////////////////////////////
//This method contains all of the code for creating events 
//////////////////////////////////////////////////////////
	private void creatEvents()
	{
	mntmExit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
		if (ret ==JOptionPane.YES_OPTION)
		{
			// Elegantly shut down program
			// Save any work into file or database, etc.
		System.exit(0);
		}
	}
	});
	
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
			if (ret ==JOptionPane.YES_OPTION)
			{
				// Elegantly shut down program
				// Save any work into file or database, etc.
			System.exit(0);
			}
		}
	});
}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
