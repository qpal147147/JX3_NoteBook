import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Delete() {
		setTitle("\u522A\u9664\u8CC7\u6599");
		ImageIcon imgIco = new ImageIcon("image\\JX3NoteBook.png");
		setIconImage(imgIco.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(14, 25, 522, 25);
		contentPane.add(comboBox);
		List.addDataToJCB(comboBox);
		
		JButton deleteBtn = new JButton("\u78BA\u5B9A\u522A\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				if(index == -1) {
					JOptionPane.showMessageDialog(null,"無資料!","錯誤",JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(List.deleteSlectData(index)) {
						JOptionPane.showMessageDialog(null,"刪除資料成功!\n","訊息",JOptionPane.PLAIN_MESSAGE, new ImageIcon("image\\success.png"));
					}
					else {
						JOptionPane.showMessageDialog(null,"存取檔案錯誤!\n此檔案正在執行中","錯誤",JOptionPane.ERROR_MESSAGE);
					}
				}
				List.clearJCB(comboBox);
				List.addDataToJCB(comboBox);
			}
		});
		deleteBtn.setBounds(14, 367, 135, 59);
		contentPane.add(deleteBtn);
		
		JButton DeleteAllData = new JButton("\u522A\u9664\u6240\u6709\u8CC7\u6599");
		DeleteAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(List.deleteAllData()) {
					JOptionPane.showMessageDialog(null,"刪除所有資料成功!\n","訊息",JOptionPane.PLAIN_MESSAGE, new ImageIcon("image\\success.png"));
				}
				else {
					JOptionPane.showMessageDialog(null,"存取檔案錯誤!\n此檔案正在執行中","錯誤",JOptionPane.ERROR_MESSAGE);
				}
				List.clearJCB(comboBox);
				List.addDataToJCB(comboBox);
			}
		});
		DeleteAllData.setBounds(163, 367, 135, 59);
		contentPane.add(DeleteAllData);
		
	}
}
