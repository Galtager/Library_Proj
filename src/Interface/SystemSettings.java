package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SystemSettings {

	private JFrame frameClass;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameClass = new JFrame();
		frameClass.getContentPane().setBackground(new Color(0, 153, 153));
		frameClass.setTitle("SystemSettings");
		frameClass.setBounds(100, 100, 888, 610);
		frameClass.dispose();
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
		jcb_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox jcb_2 = new JCheckBox("Enable automatic numbering for student code in addition");
		jcb_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JCheckBox jcb_3 = new JCheckBox("Enable automatic numbering for title code in addition");
		jcb_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel jl_LoanDaysValue = new JLabel("Default value for loan days Title");
		jl_LoanDaysValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel jl_PaymentValue = new JLabel("Default payment value");
		jl_PaymentValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JFormattedTextField jtf_1 = new JFormattedTextField();
		
		JFormattedTextField jtf_2 = new JFormattedTextField();
		
		JButton jb_Save = new JButton("Save");
		jb_Save.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton jb_Close = new JButton("Close");
		jb_Close.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jb_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                frameClass.dispose();
                }
        });
		
		GroupLayout gl_jp_SystemOptions = new GroupLayout(jp_SystemOptions);
		gl_jp_SystemOptions.setHorizontalGroup(
			gl_jp_SystemOptions.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jp_SystemOptions.createSequentialGroup()
					.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jp_SystemOptions.createSequentialGroup()
							.addGap(213)
							.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.LEADING)
								.addComponent(jcb_2)
								.addComponent(jcb_1)
								.addComponent(jcb_3)))
						.addGroup(gl_jp_SystemOptions.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.LEADING)
								.addComponent(jl_LoanDaysValue)
								.addComponent(jl_PaymentValue, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jtf_2)
								.addComponent(jtf_1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))))
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_jp_SystemOptions.createSequentialGroup()
					.addContainerGap(557, Short.MAX_VALUE)
					.addComponent(jb_Close)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jb_Save)
					.addGap(105))
		);
		gl_jp_SystemOptions.setVerticalGroup(
			gl_jp_SystemOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jp_SystemOptions.createSequentialGroup()
					.addGap(53)
					.addComponent(jcb_1)
					.addGap(43)
					.addComponent(jcb_2)
					.addGap(39)
					.addComponent(jcb_3)
					.addGap(30)
					.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.BASELINE)
						.addComponent(jl_LoanDaysValue)
						.addComponent(jtf_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.BASELINE)
						.addComponent(jl_PaymentValue)
						.addComponent(jtf_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jp_SystemOptions.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_Save)
						.addComponent(jb_Close))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jp_SystemOptions.setLayout(gl_jp_SystemOptions);
		
		JPanel jp_Backup = new JPanel();
		jp_Backup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Backup", null, jp_Backup, null);
		
		JPanel jp_DeleteData = new JPanel();
		jp_DeleteData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabbedPane.addTab("Delete Data", null, jp_DeleteData, null);
		
		JPanel jp_Logo = new JPanel();
		tabbedPane.addTab("Logo", null, jp_Logo, null);
		GroupLayout gl_jp_Logo = new GroupLayout(jp_Logo);
		gl_jp_Logo.setHorizontalGroup(
			gl_jp_Logo.createParallelGroup(Alignment.LEADING)
				.addGap(0, 863, Short.MAX_VALUE)
		);
		gl_jp_Logo.setVerticalGroup(
			gl_jp_Logo.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 398, Short.MAX_VALUE)
		);
		jp_Logo.setLayout(gl_jp_Logo);
		frameClass.getContentPane().setLayout(groupLayout);
	}

}
