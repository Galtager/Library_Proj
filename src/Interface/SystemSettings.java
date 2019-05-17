package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		frameClass.setTitle("SystemSettings");
		frameClass.setBounds(100, 100, 780, 645);
		frameClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("System Settings");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		GroupLayout groupLayout = new GroupLayout(frameClass.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
					.addGap(189))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(422, Short.MAX_VALUE))
		);
		frameClass.getContentPane().setLayout(groupLayout);
	}
}
