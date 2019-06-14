package Interface;

import Misc.Globals;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Window.Type;

public class SystemSettings {

	JFrame frameClass;
	private JTextField textField_backup;
	private JTextField textField_DataSize;
	private JTextField JTextFiel_Path;
	private JLabel jLable1;
	byte[] image;
	String imagepath="";
	ImageIcon myimage;


	/**
	 * Create the application.
	 */
	public SystemSettings() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameClass = new JFrame();
		frameClass.setType(Type.POPUP);
		frameClass.getContentPane().setBackground(Color.RED);
		frameClass.setTitle("System Settings");
		frameClass.setBounds(100, 100, 888, 610);
		frameClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel JLabel_SystemSettings = new JLabel("System Settings");
		JLabel_SystemSettings.setForeground(new Color(0, 0, 0));
		JLabel_SystemSettings.setFont(new Font("Tahoma", Font.BOLD, 48));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(frameClass.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 758, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(220)
					.addComponent(JLabel_SystemSettings, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(JLabel_SystemSettings, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		JPanel Tab_SystemOptions = new JPanel();
		Tab_SystemOptions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("System Options", null, Tab_SystemOptions, null);
		
		JCheckBox jcb_2 = new JCheckBox("Enable automatic numbering for student code in addition");
		jcb_2.setBounds(213, 129, 539, 33);
		jcb_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox jcb_3 = new JCheckBox("Enable automatic numbering for title code in addition");
		jcb_3.setBounds(213, 201, 507, 33);
		jcb_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel JLable_LoanDaysValue = new JLabel("- Default value for loan days Title");
		JLable_LoanDaysValue.setBounds(78, 269, 315, 25);
		JLable_LoanDaysValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel JLable_PaymentValue = new JLabel("- Default payment value");
		JLable_PaymentValue.setBounds(78, 321, 225, 25);
		JLable_PaymentValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JFormattedTextField jtf_LoanDaysValue = new JFormattedTextField();
		jtf_LoanDaysValue.setBounds(395, 264, 41, 39);
		
		JButton jb_Save1 = new JButton("Save");
		jb_Save1.setBounds(786, 365, 75, 33);
		jb_Save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb_Save1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton jb_Close1 = new JButton("Close");
		jb_Close1.setBounds(696, 365, 81, 33);
		jb_Close1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		Tab_SystemOptions.setLayout(null);
		
		JCheckBox jcb_1 = new JCheckBox("Canceling a delay message Returns a title");
		jcb_1.setBounds(213, 53, 407, 33);
		jcb_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Tab_SystemOptions.add(jcb_1);
		Tab_SystemOptions.add(jcb_2);
		Tab_SystemOptions.add(jcb_3);
		Tab_SystemOptions.add(JLable_LoanDaysValue);
		Tab_SystemOptions.add(JLable_PaymentValue);
		Tab_SystemOptions.add(jtf_LoanDaysValue);
		
		JFormattedTextField jtf_PaymentValue = new JFormattedTextField();
		jtf_PaymentValue.setBounds(302, 310, 41, 39);
		Tab_SystemOptions.add(jtf_PaymentValue);
		Tab_SystemOptions.add(jb_Close1);
		Tab_SystemOptions.add(jb_Save1);
		
		JPanel Tab_Backup = new JPanel();
		Tab_Backup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Backup", null, Tab_Backup, null);
		Tab_Backup.setLayout(null);
		
		JLabel jl_lDataSize = new JLabel("Database size:");
		jl_lDataSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jl_lDataSize.setBounds(166, 58, 118, 32);
		Tab_Backup.add(jl_lDataSize);
		
		JButton btnFolderBackup = new JButton("Folder backup");
		btnFolderBackup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFolderBackup.setBounds(162, 116, 262, 84);
		Tab_Backup.add(btnFolderBackup);
		
		JButton btnBackupAndCompression = new JButton("Backup and compression");
		btnBackupAndCompression.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackupAndCompression.setBounds(457, 116, 262, 84);
		Tab_Backup.add(btnBackupAndCompression);
		
		JButton jb_Close2 = new JButton("Close");
		jb_Close2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Close2.setBounds(674, 365, 93, 33);
		jb_Close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		Tab_Backup.add(jb_Close2);
		
		JButton jb_Save2 = new JButton("Save");
		jb_Save2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Save2.setBounds(776, 365, 85, 33);
		Tab_Backup.add(jb_Save2);
		
		JLabel lbl_recommend = new JLabel("It is recommended to perform once a week compression");
		lbl_recommend.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_recommend.setBounds(166, 216, 553, 20);
		Tab_Backup.add(lbl_recommend);
		
		JLabel lbl_backup = new JLabel("Permanent location to backup the database");
		lbl_backup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_backup.setBounds(162, 252, 553, 20);
		Tab_Backup.add(lbl_backup);
		
		textField_backup = new JTextField();
		textField_backup.setBounds(162, 280, 469, 26);
		Tab_Backup.add(textField_backup);
		textField_backup.setColumns(10);
		
		JButton btn_Delete1 = new JButton("Delete");
		btn_Delete1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Delete1.setBounds(634, 280, 106, 27);
		Tab_Backup.add(btn_Delete1);
		
		textField_DataSize = new JTextField();
		textField_DataSize.setBounds(283, 62, 436, 26);
		Tab_Backup.add(textField_DataSize);
		textField_DataSize.setColumns(10);
		
		JPanel Tab_DeleteData = new JPanel();
		Tab_DeleteData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Delete Data", null, Tab_DeleteData, null);
		Tab_DeleteData.setLayout(null);
		
		JCheckBox chckbx_DeleteTitels = new JCheckBox("Deleting titles");
		chckbx_DeleteTitels.setBounds(192, 135, 407, 33);
		chckbx_DeleteTitels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Tab_DeleteData.add(chckbx_DeleteTitels);
		
		JCheckBox chckbx_DelStudAndBorrow = new JCheckBox("Delete students and borrow books");
		chckbx_DelStudAndBorrow.setBounds(192, 49, 407, 33);
		chckbx_DelStudAndBorrow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Tab_DeleteData.add(chckbx_DelStudAndBorrow);
		
		JButton btn_Delete2 = new JButton("Delete");
		btn_Delete2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Delete2.setBounds(321, 255, 128, 33);
		Tab_DeleteData.add(btn_Delete2);
		
		JButton jb_Save3 = new JButton("Save");
		jb_Save3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Save3.setBounds(786, 365, 75, 33);
		Tab_DeleteData.add(jb_Save3);
		
		JButton jb_Close3 = new JButton("Close");
		jb_Close3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Close3.setBounds(690, 365, 81, 33);
		jb_Close3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		Tab_DeleteData.add(jb_Close3);
		
		JPanel Tab_Logo = new JPanel();
		tabbedPane.addTab("Logo", null, Tab_Logo, null);
		
		JLabel jLabel_Pic = new JLabel("Your Logo Here");
		jLabel_Pic.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_Pic.setToolTipText("");
		jLabel_Pic.setBounds(114, 74, 385, 182);
		Tab_Logo.add(jLabel_Pic);
		frameClass.getContentPane().setLayout(groupLayout);
		
		JLabel lbl_comment = new JLabel("A logo image that will appear in all reports");
		lbl_comment.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_comment.setBounds(134, 272, 335, 22);
		lbl_comment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextFiel_Path = new JTextField();
		JTextFiel_Path.setEditable(false);
		JTextFiel_Path.setBounds(84, 298, 401, 26);
		Tab_Logo.add(JTextFiel_Path);
		JTextFiel_Path.setColumns(10);
		
		JButton btn_ChooseLogo = new JButton("Choose \r\nLogo");
		btn_ChooseLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png","jpeg" );
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		          if(result == JFileChooser.APPROVE_OPTION)
		          {
		        	  File f = file.getSelectedFile();
		        	  String p = f.getAbsolutePath();
		        	  JTextFiel_Path.setText(file.getSelectedFile().getAbsolutePath());
		        	  jLabel_Pic.setIcon(new ImageIcon(p));
		        	  jLabel_Pic.setText("");
		          }
			}
		});
		btn_ChooseLogo.setBounds(539, 97, 161, 84);
		btn_ChooseLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		JButton btn_DeleteLogo = new JButton("Delete Logo");
		btn_DeleteLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // Remove icon when button is clicked.
				jLabel_Pic.setIcon(null); 
				jLabel_Pic.setText("Your Logo Here");
				JTextFiel_Path.setText(null);
				Globals.s_global_logo_path = null;
			}
		});
		
		btn_DeleteLogo.setBounds(539, 210, 161, 84);
		btn_DeleteLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Tab_Logo.setLayout(null);
		Tab_Logo.add(lbl_comment);
		Tab_Logo.add(btn_DeleteLogo);
		Tab_Logo.add(btn_ChooseLogo);
		
		JButton jb_Close4 = new JButton("Close");
		jb_Close4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Close4.setBounds(674, 365, 93, 33);
		jb_Close4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		Tab_Logo.add(jb_Close4);
		
		JButton jb_Save4 = new JButton("Save");
		jb_Save4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	        	  if(!JTextFiel_Path.getText().isEmpty() )
	        	  {
	        		  Globals.s_global_logo_path = JTextFiel_Path.getText();
	        	  }
			}
		});
		jb_Save4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jb_Save4.setBounds(776, 365, 85, 33);
		Tab_Logo.add(jb_Save4);
		
		JLabel lbl_Path = new JLabel("path");
		lbl_Path.setBounds(29, 301, 40, 20);
		Tab_Logo.add(lbl_Path);
		

		

	}
}
