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

public class ClientRegistration {

	JFrame frmClientRegistration;
	private JTextField id_txt;
	private JTextField name_txt;
	private JTextField address_txt;
	private JTextField email_txt;
	private JTextField phone_txt;
	private JPanel panel;
	private JButton clear_button;
	private JButton save_button;
	private JButton close_button;
	private JTextField password_txt;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ClientRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientRegistration = new JFrame();
		frmClientRegistration.setBounds(new Rectangle(0, 0, 0, 0));
		frmClientRegistration.setTitle("Client Registration");
		frmClientRegistration.setBounds(100, 100, 450, 600);
		frmClientRegistration.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		close_button = new JButton("Close");
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		save_button = new JButton("Save");
		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id_txt.getText().equals("") || 
						name_txt.getText().equals("") ||
						address_txt.getText().equals("") ||
						email_txt.getText().equals("") ||
						password_txt.getText().equals("") ||
						phone_txt.getText().equals(""))
					{
						Component frame = null;
						JOptionPane.showMessageDialog(frame ,
							    "Must fill in every field!.");
					}
					else
					{
						LibraryActionsImpl.insertUser(id_txt.getText(),
								name_txt.getText(),
								address_txt.getText(),
								email_txt.getText(),
								phone_txt.getText(),
								password_txt.getText());
						frmClientRegistration.dispose();
					}
				}
		});
		
		clear_button = new JButton("Clear");
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id_txt.setText("");
				name_txt.setText("");
				address_txt.setText("");
				email_txt.setText("");
				phone_txt.setText("");
				password_txt.setText("");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmClientRegistration.getContentPane());
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
		
		JPanel client_details_panel = new JPanel();
		client_details_panel.setBounds(0, 0, 412, 20);
		client_details_panel.setBackground(UIManager.getColor("Button.background"));
		
		JLabel clientid_lbl = new JLabel("ClientID");
		clientid_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		clientid_lbl.setBackground(new Color(224, 255, 255));
		clientid_lbl.setBounds(10, 30, 106, 20);
		
		JLabel name_lbl = new JLabel("Name");
		name_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		name_lbl.setBounds(10, 50, 106, 18);
		
		JLabel adress_lbl = new JLabel("Adress");
		adress_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		adress_lbl.setBounds(10, 110, 106, 20);
		
		JLabel email_lbl = new JLabel("Email:");
		email_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		email_lbl.setBounds(10, 150, 106, 20);
		
		JLabel phone_number_lbl = new JLabel("Phone number:");
		phone_number_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		phone_number_lbl.setBounds(10, 170, 106, 20);
		
		id_txt = new JTextField();
		id_txt.setBounds(120, 30, 96, 20);
		id_txt.setColumns(10);
		
		name_txt = new JTextField();
		name_txt.setBounds(120, 50, 96, 20);
		name_txt.setColumns(10);
		panel.setLayout(null);
		
		JLabel title_lbl = new JLabel("Client Details");
		title_lbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_client_details_panel = new GroupLayout(client_details_panel);
		gl_client_details_panel.setHorizontalGroup(
			gl_client_details_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_client_details_panel.createSequentialGroup()
					.addComponent(title_lbl)
					.addContainerGap(338, Short.MAX_VALUE))
		);
		gl_client_details_panel.setVerticalGroup(
			gl_client_details_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_client_details_panel.createSequentialGroup()
					.addComponent(title_lbl)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		client_details_panel.setLayout(gl_client_details_panel);
		panel.add(client_details_panel);
		panel.add(name_lbl);
		panel.add(email_lbl);
		panel.add(phone_number_lbl);
		panel.add(clientid_lbl);
		panel.add(name_lbl);
		panel.add(name_txt);
		panel.add(id_txt);
		
		address_txt = new JTextField();
		address_txt.setColumns(10);
		address_txt.setBounds(120, 110, 242, 20);
		panel.add(address_txt);
		
		email_txt = new JTextField();
		email_txt.setColumns(10);
		email_txt.setBounds(120, 150, 196, 20);
		panel.add(email_txt);
		
		phone_txt = new JTextField();
		phone_txt.setColumns(10);
		phone_txt.setBounds(120, 170, 96, 20);
		panel.add(phone_txt);
        
        JLabel adress_label = new JLabel("Adress");
        adress_label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        adress_label.setBounds(10, 110, 106, 20);
        panel.add(adress_label);
        
        JLabel password_lbl = new JLabel("Password:");
        password_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        password_lbl.setBounds(10, 201, 106, 20);
        panel.add(password_lbl);
        
        password_txt = new JTextField();
        password_txt.setColumns(10);
        password_txt.setBounds(120, 201, 96, 20);
        panel.add(password_txt);
        
		frmClientRegistration.getContentPane().setLayout(groupLayout);
		
		
	}
}
