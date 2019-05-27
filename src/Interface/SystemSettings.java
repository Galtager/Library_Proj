package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class SystemSettings {

	private JFrame frameClass;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField JTextFieldl;
	private JLabel jLable1;
	byte[] image;
	String imagepath="";
	ImageIcon myimage;
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemSettings window = new SystemSettings();
					window.frameClass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public SystemSettings() {
		initialize();
	}
	public ImageIcon seticon (String m, byte[] image) {
		if (m!=null) {
			myimage=new ImageIcon(m);
		}else {
			myimage=new ImageIcon(image);
		}
        Image img1 = myimage.getImage();
        Image img2 = img1.getScaledInstance(jLable1.getWidth(), jLable1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		return i;
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameClass = new JFrame();
		frameClass.getContentPane().setBackground(Color.RED);
		frameClass.setTitle("SystemSettings");
		frameClass.setBounds(100, 100, 888, 610);
		frameClass.dispose();//exit
		frameClass.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameClass.addWindowListener( new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the window?", "Please Confirm",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            });
		JLabel jl_SystemSettings = new JLabel("System Settings");
		jl_SystemSettings.setForeground(new Color(0, 0, 0));
		jl_SystemSettings.setFont(new Font("Tahoma", Font.BOLD, 48));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(frameClass.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 758, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(220)
					.addComponent(jl_SystemSettings, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(jl_SystemSettings, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		JPanel jp_SystemOptions = new JPanel();
		jp_SystemOptions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("System Options", null, jp_SystemOptions, null);
		
		JCheckBox jcb_1 = new JCheckBox("Canceling a delay message Returns a title");
		jcb_1.setBounds(213, 53, 407, 33);
		jcb_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox jcb_2 = new JCheckBox("Enable automatic numbering for student code in addition");
		jcb_2.setBounds(213, 129, 539, 33);
		jcb_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox jcb_3 = new JCheckBox("Enable automatic numbering for title code in addition");
		jcb_3.setBounds(213, 201, 507, 33);
		jcb_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel jl_LoanDaysValue = new JLabel("- Default value for loan days Title");
		jl_LoanDaysValue.setBounds(78, 269, 315, 25);
		jl_LoanDaysValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel jl_PaymentValue = new JLabel("- Default payment value");
		jl_PaymentValue.setBounds(78, 321, 225, 25);
		jl_PaymentValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JFormattedTextField jtf_1 = new JFormattedTextField();
		jtf_1.setBounds(395, 264, 41, 39);
		
		JButton jb_Save = new JButton("Save");
		jb_Save.setBounds(681, 366, 75, 33);
		jb_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton jb_Close = new JButton("Close");
		jb_Close.setBounds(591, 366, 81, 33);
		jb_Close.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jb_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		jp_SystemOptions.setLayout(null);
		jp_SystemOptions.add(jcb_2);
		jp_SystemOptions.add(jcb_1);
		jp_SystemOptions.add(jcb_3);
		jp_SystemOptions.add(jl_LoanDaysValue);
		jp_SystemOptions.add(jl_PaymentValue);
		jp_SystemOptions.add(jtf_1);
		jp_SystemOptions.add(jb_Close);
		jp_SystemOptions.add(jb_Save);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(302, 310, 41, 39);
		jp_SystemOptions.add(formattedTextField);
		
		JPanel jp_Backup = new JPanel();
		jp_Backup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Backup", null, jp_Backup, null);
		jp_Backup.setLayout(null);
		
		JLabel lblDataSize = new JLabel("Database size:");
		lblDataSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataSize.setBounds(166, 58, 118, 32);
		jp_Backup.add(lblDataSize);
		
		JButton btnFolderBackup = new JButton("Folder backup");
		btnFolderBackup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFolderBackup.setBounds(162, 116, 262, 84);
		jp_Backup.add(btnFolderBackup);
		
		JButton btnBackupAndCompression = new JButton("Backup and compression");
		btnBackupAndCompression.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBackupAndCompression.setBounds(457, 116, 262, 84);
		jp_Backup.add(btnBackupAndCompression);
		
		JButton button_4 = new JButton("Close");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_4.setBounds(555, 349, 93, 33);
		jp_Backup.add(button_4);
		
		JButton button_5 = new JButton("Save");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_5.setBounds(657, 349, 85, 33);
		jp_Backup.add(button_5);
		
		JLabel lblNewLabel = new JLabel("It is recommended to perform once a week compression");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(166, 216, 553, 20);
		jp_Backup.add(lblNewLabel);
		
		JLabel lblPermanentLocationTo = new JLabel("Permanent location to backup the database");
		lblPermanentLocationTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPermanentLocationTo.setBounds(162, 252, 553, 20);
		jp_Backup.add(lblPermanentLocationTo);
		
		textField = new JTextField();
		textField.setBounds(162, 280, 469, 26);
		jp_Backup.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete_1.setBounds(634, 280, 106, 27);
		jp_Backup.add(btnDelete_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 62, 436, 26);
		jp_Backup.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel jp_DeleteData = new JPanel();
		jp_DeleteData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Delete Data", null, jp_DeleteData, null);
		jp_DeleteData.setLayout(null);
		
		JCheckBox chckbxDeleteTitels = new JCheckBox("Deleting titles");
		chckbxDeleteTitels.setBounds(192, 135, 407, 33);
		chckbxDeleteTitels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jp_DeleteData.add(chckbxDeleteTitels);
		
		JCheckBox chckbx_DelStudAndBorrow = new JCheckBox("Delete students and borrow books");
		chckbx_DelStudAndBorrow.setBounds(192, 49, 407, 33);
		chckbx_DelStudAndBorrow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jp_DeleteData.add(chckbx_DelStudAndBorrow);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(321, 255, 128, 33);
		jp_DeleteData.add(btnDelete);
		
		JButton btnsave_deletedata = new JButton("Save");
		btnsave_deletedata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsave_deletedata.setBounds(694, 349, 75, 33);
		jp_DeleteData.add(btnsave_deletedata);
		
		JButton button_1 = new JButton("Close");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(598, 349, 81, 33);
		jp_DeleteData.add(button_1);
		
		JPanel jp_Logo = new JPanel();
		tabbedPane.addTab("Logo", null, jp_Logo, null);
		
		JLabel jLabel1 = new JLabel("*******Picture*******");
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setToolTipText("");
		jLabel1.setBounds(114, 74, 385, 182);
		jp_Logo.add(jLabel1);
		frameClass.getContentPane().setLayout(groupLayout);
		
		JLabel lbl_logo = new JLabel("A logo image that will appear in all reports");
		lbl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_logo.setBounds(134, 272, 335, 22);
		lbl_logo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextFieldl = new JTextField();
		JTextFieldl.setBounds(84, 298, 401, 26);
		jp_Logo.add(JTextFieldl);
		JTextFieldl.setColumns(10);
		
		JButton button = new JButton("Choose \r\nLogo");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File ("user.dir"));
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png","jpeg" );
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		          if(result == JFileChooser.APPROVE_OPTION)
		          {
		        	  File f=file.getSelectedFile();
		        	  String p =f.getAbsolutePath();
		        	  JTextFieldl.setText(file.getSelectedFile().getAbsolutePath());
		        	  jLabel1.setIcon(seticon(p,null));
		          }
//				JFileChooser fs=new JFileChooser(new File("c:\\"));
//				fs.setDialogTitle("Open a File");
//				fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
//				fs.setFileFilter(new FileTypeFilter(".doc","Word File"));
//				fs.setFileFilter(new FileTypeFilter(".docx","Word File"));
//				fs.setFileFilter(new FileTypeFilter(".jpg","JPEG File"));
//				int result= fs.showSaveDialog(null);
//				if (result==JFileChooser.APPROVE_OPTION) {
//					try {
//						File fi = fs.getSelectedFile();
//						BufferedReader br = new BufferedReader (new FileReader(
//								fi.getPath()));
//						String line = "";
//						String s = "";
//						while ((line=br.readLine())!=null){
//							s += line;
//						}
//						textContent.setText(s);
//						if (br!=null) 
//							br.close();
//					} catch (Exception e2) {
//					JOptionPane.showMessageDialog(null, e2.getMessage());
//					}
//				}
			}
		});
		button.setBounds(539, 97, 161, 84);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		JButton btnDeleteLogo = new JButton("Delete Logo");
		btnDeleteLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteLogo.setBounds(539, 210, 161, 84);
		btnDeleteLogo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jp_Logo.setLayout(null);
		jp_Logo.add(lbl_logo);
		jp_Logo.add(btnDeleteLogo);
		jp_Logo.add(button);
		
		JButton button_2 = new JButton("Close");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_2.setBounds(584, 349, 93, 33);
		jp_Logo.add(button_2);
		
		JButton button_3 = new JButton("Save");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_3.setBounds(686, 349, 85, 33);
		jp_Logo.add(button_3);
		
		JLabel lblPath = new JLabel("path");
		lblPath.setBounds(29, 301, 40, 20);
		jp_Logo.add(lblPath);
		

		

	}
}
