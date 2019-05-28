package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;

public class ClientRegistration {

	JFrame frmClientRegistration;
	private JTextField textField;
	private JTextField firstname_txt;
	private JTextField lastname_txt;
	private JTextField id_txt;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField payment_txt;
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
		frmClientRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		close_button = new JButton("Close");
		close_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		save_button = new JButton("Save");
		
		clear_button = new JButton("Clear");
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
		
		JLabel firstname_lbl = new JLabel("First name");
		firstname_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		firstname_lbl.setBounds(10, 50, 106, 18);
		
		JLabel lastname_lbl = new JLabel("Last name");
		lastname_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lastname_lbl.setBounds(10, 70, 106, 20);
		
		JLabel client_id_lbl = new JLabel("ID");
		client_id_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		client_id_lbl.setBounds(10, 90, 106, 20);
		
		JLabel adress_lbl = new JLabel("Adress");
		adress_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		adress_lbl.setBounds(10, 110, 106, 20);
		
		JLabel city_lbl = new JLabel("City");
		city_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		city_lbl.setBounds(10, 130, 106, 20);
		
		JLabel email_lbl = new JLabel("Email:");
		email_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		email_lbl.setBounds(10, 150, 106, 20);
		
		JLabel phone_number_lbl = new JLabel("Phone number:");
		phone_number_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		phone_number_lbl.setBounds(10, 170, 106, 20);
		
		JLabel registration_lbl = new JLabel("Registration Day");
		registration_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		registration_lbl.setBounds(10, 190, 106, 20);
		
		JLabel ending_day_lbl = new JLabel("Ending Day");
		ending_day_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ending_day_lbl.setBounds(10, 210, 106, 20);
		
		JLabel limit_lbl = new JLabel("Limit");
		limit_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		limit_lbl.setBounds(10, 240, 106, 20);
		
		JLabel status_lbl = new JLabel("Status");
		status_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		status_lbl.setBounds(10, 260, 106, 20);
		
		JLabel utilization_lbl = new JLabel("Utilization");
		utilization_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		utilization_lbl.setBounds(10, 280, 106, 20);
		
		textField = new JTextField();
		textField.setBounds(120, 30, 96, 20);
		textField.setColumns(10);
		
		firstname_txt = new JTextField();
		firstname_txt.setBounds(120, 50, 96, 20);
		firstname_txt.setColumns(10);
		
		lastname_txt = new JTextField();
		lastname_txt.setBounds(120, 70, 96, 20);
		lastname_txt.setColumns(10);
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
		panel.add(client_id_lbl);
		panel.add(firstname_lbl);
		panel.add(city_lbl);
		panel.add(email_lbl);
		panel.add(phone_number_lbl);
		panel.add(registration_lbl);
		panel.add(ending_day_lbl);
		panel.add(limit_lbl);
		panel.add(status_lbl);
		panel.add(utilization_lbl);
		panel.add(clientid_lbl);
		panel.add(firstname_lbl);
		panel.add(lastname_lbl);
		panel.add(lastname_txt);
		panel.add(firstname_txt);
		panel.add(textField);
		
		id_txt = new JTextField();
		id_txt.setColumns(10);
		id_txt.setBounds(120, 90, 96, 20);
		panel.add(id_txt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 110, 242, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 130, 96, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(120, 150, 196, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(120, 170, 96, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(120, 190, 96, 20);
		panel.add(textField_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(120, 240, 96, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(120, 260, 96, 20);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(120, 280, 96, 20);
		panel.add(textField_12);
		
		JButton id_button = new JButton("ID");
		id_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		id_button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		id_button.setBounds(216, 89, 46, 23);
		panel.add(id_button);
		
		JButton email_button = new JButton("M");
		email_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email_button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		email_button.setBounds(316, 149, 46, 23);
		panel.add(email_button);
		
		JComboBox ending_day_comboBox = new JComboBox();
		ending_day_comboBox.setBounds(120, 209, 96, 22);
		panel.add(ending_day_comboBox);
		
		JLabel payment_lbl = new JLabel("Payment");
		payment_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		payment_lbl.setBounds(10, 300, 106, 20);
		panel.add(payment_lbl);
		
		payment_txt = new JTextField();
		payment_txt.setColumns(10);
		payment_txt.setBounds(120, 300, 67, 20);
		panel.add(payment_txt);
		
		JLabel ils_lbl = new JLabel("  ILS");
		ils_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ils_lbl.setBounds(186, 300, 30, 20);
		panel.add(ils_lbl);
		
		JLabel comments_lbl = new JLabel("Comments:");
		comments_lbl.setVerticalAlignment(SwingConstants.TOP);
		comments_lbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comments_lbl.setBounds(10, 350, 106, 101);
		panel.add(comments_lbl);
		
        JTextArea textArea = new JTextArea(0,0);
		JScrollPane comments_scrollBar = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		comments_scrollBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		comments_scrollBar.setSize(242, 100);
		comments_scrollBar.setLocation(120, 351);
        panel.add(comments_scrollBar);
        
        JLabel adress_label = new JLabel("Adress");
        adress_label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        adress_label.setBounds(10, 110, 106, 20);
        panel.add(adress_label);
        
		frmClientRegistration.getContentPane().setLayout(groupLayout);
		
		
	}
}
