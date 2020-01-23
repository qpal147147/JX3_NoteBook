import java.awt.EventQueue;

import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Window frame = new Window();
					frame.setVisible(true);
					List.load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
