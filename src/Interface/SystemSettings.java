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
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;

import java.awt.Window.Type;

public class SystemSettings {

	JFrame frameClass;
	private JTextField JTextFiel_Path;
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
		
		JLabel JLable_LoanDaysValue = new JLabel("Max days for loan");
		JLable_LoanDaysValue.setBounds(61, 32, 171, 25);
		JLable_LoanDaysValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
		JFormattedTextField jtf_LoanDaysValue = new JFormattedTextField(formatter);
		jtf_LoanDaysValue.setText(String.valueOf(Globals.days_per_borrow));
		jtf_LoanDaysValue.setBounds(242, 29, 176, 39);
		
		JButton jb_Save1 = new JButton("Save");
		jb_Save1.setBounds(786, 365, 75, 33);
		jb_Save1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Globals.days_per_borrow = Integer.parseInt(jtf_LoanDaysValue.getText().replace(",", ""));
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
		Tab_SystemOptions.add(JLable_LoanDaysValue);
		Tab_SystemOptions.add(jtf_LoanDaysValue);
		Tab_SystemOptions.add(jb_Close1);
		Tab_SystemOptions.add(jb_Save1);
	
		
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
