package Interface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.User;
import UserManager.UserActions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userID_text_box;
	private JTextField password_text_box;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("Login");
		setBounds(100, 100, 265, 163);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUserID = new JLabel("User ID:");
		lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserID.setBounds(10, 11, 73, 26);
		contentPanel.add(lblUserID);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 42, 73, 26);
		contentPanel.add(lblPassword);
		
		userID_text_box = new JTextField();
		userID_text_box.setBounds(93, 16, 119, 20);
		contentPanel.add(userID_text_box);
		userID_text_box.setColumns(10);
		
		password_text_box = new JTextField();
		password_text_box.setColumns(10);
		password_text_box.setBounds(93, 47, 119, 20);
		contentPanel.add(password_text_box);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				
				JButton ok_button = new JButton("OK");
				ok_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						User logged = UserActions.checkIfUserExists(userID_text_box.getText().trim(), password_text_box.getText().trim());
						if(logged == null) {
							Component frame = null;
							JOptionPane.showMessageDialog(frame ,
								    "User doesnt exist.");
						}
						
						else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										MainMenu window = new MainMenu(logged);
										window.frmLibrary.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							dispose();
						}

					}
				});
				ok_button.setActionCommand("OK");
				buttonPane.add(ok_button);
				getRootPane().setDefaultButton(ok_button);
			}
			{
				JButton cancel_button = new JButton("Cancel");
				cancel_button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancel_button.setActionCommand("Cancel");
				buttonPane.add(cancel_button);
			}
		}
	}
}
