import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Toolkit;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField sect;
	private JTextField place;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Window() {
		ImageIcon imgIco = new ImageIcon("image\\JX3NoteBook.png");
		setIconImage(imgIco.getImage());
		setTitle("\u528D\u4E09\u8A18\u4E8B\u672C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u540D\u5B57");
		lblNewLabel.setBounds(14, 69, 57, 19);
		contentPane.add(lblNewLabel);
		
		JButton DeleteData = new JButton("\u522A\u9664\u8CC7\u6599");
		DeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Delete().setVisible(true);
			}
		});
		DeleteData.setBounds(457, 93, 106, 50);
		contentPane.add(DeleteData);
		
		JButton searchData = new JButton("\u67E5\u8A62\u8CC7\u6599");
		searchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Search().setVisible(true);
			}
		});
		searchData.setBounds(457, 173, 106, 50);
		contentPane.add(searchData);
		
		JLabel lblNewLabel_1 = new JLabel("\u767C\u751F\u6642\u9593");
		lblNewLabel_1.setBounds(14, 13, 87, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F3A\u670D\u5668");
		lblNewLabel_2.setBounds(224, 13, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("\u9580\u6D3E");
		lblNewLabel_3.setBounds(224, 69, 57, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u512A\u52A3");
		lblNewLabel_4.setBounds(14, 127, 57, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u89D2\u8272\u5B9A\u4F4D");
		lblNewLabel_5.setBounds(224, 127, 68, 19);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u6027\u5225");
		lblNewLabel_6.setBounds(14, 198, 57, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u526F\u672C");
		lblNewLabel_7.setBounds(14, 256, 57, 19);
		contentPane.add(lblNewLabel_7);
		
		name = new JTextField();
		name.setBounds(86, 66, 116, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		sect = new JTextField();
		sect.setBounds(291, 66, 106, 25);
		contentPane.add(sect);
		sect.setColumns(10);
		
		place = new JTextField();
		place.setBounds(77, 253, 320, 25);
		contentPane.add(place);
		place.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u8A73\u7D30\u63CF\u8FF0");
		lblNewLabel_8.setToolTipText("\u8ACB\u8F38\u5165\u63CF\u8FF0\u6587\u5B57...");
		lblNewLabel_8.setBounds(175, 310, 86, 19);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u901F\u5EA6");
		lblNewLabel_9.setBounds(224, 198, 57, 19);
		contentPane.add(lblNewLabel_9);
		
		JComboBox<String> server = new JComboBox<>();
		server.setBounds(291, 10, 106, 25);
		contentPane.add(server);
		server.addItem("巔峰再起");
		server.addItem("傲血戰意");
		server.addItem("江海雲夢");
		
		
		JComboBox<String> degree = new JComboBox<>();
		degree.setBounds(86, 124, 116, 25);
		contentPane.add(degree);
		degree.addItem("優");
		degree.addItem("中規中矩");
		degree.addItem("劣");
		
		JComboBox<String> positioning = new JComboBox<>();
		positioning.setBounds(291, 124, 106, 25);
		contentPane.add(positioning);
		positioning.addItem("RL");
		positioning.addItem("團員");
		
		JComboBox<String> sex = new JComboBox<>();
		sex.setBounds(86, 195, 116, 25);
		contentPane.add(sex);
		sex.addItem("男");
		sex.addItem("女");
		sex.addItem("不知");
		
		JComboBox<String> speed = new JComboBox<>();
		speed.setBounds(291, 195, 106, 25);
		contentPane.add(speed);
		speed.addItem("快");
		speed.addItem("慢");
		speed.addItem("黑本");
		
		JTextArea description = new JTextArea();
		description.setBackground(Color.WHITE);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setBounds(14, 331, 383, 182);
		
		JScrollPane scrollPane = new JScrollPane(description);
		scrollPane.setBounds(14, 331, 383, 182);
		contentPane.add(scrollPane);
		
		JDateChooser happenDate = new JDateChooser();
		happenDate.setBounds(86, 10, 116, 25);
		contentPane.add(happenDate);
		 
		JButton addData = new JButton("\u6DFB\u52A0\u8CC7\u6599");
		addData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(happenDate.getDate() == null || name.getText().equals("") || sect.getText().equals("") || place.getText().equals("") || description.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"欄位不能為空!","錯誤",JOptionPane.ERROR_MESSAGE);
				}
				else {
					List.addData(happenDate.getDate(), 
								server.getSelectedItem().toString(), 
								name.getText(), sect.getText(), 
								degree.getSelectedItem().toString(), 
								positioning.getSelectedItem().toString(), 
								sex.getSelectedItem().toString(), 
								speed.getSelectedItem().toString(), 
								place.getText(), description.getText());
					if(List.save())JOptionPane.showMessageDialog(null,"儲存資料成功!\n","訊息",JOptionPane.PLAIN_MESSAGE, new ImageIcon("image\\success.png"));
				}
			}
		});
		addData.setBounds(457, 13, 106, 50);
		contentPane.add(addData);
		
		JButton clearAllText = new JButton("<html>\u6E05\u7A7A\u5DF2\u7D93<br>\u8F38\u5165\u6587\u5B57</html>");
		clearAllText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				sect.setText("");
				place.setText("");
				description.setText("");
			}
		});
		clearAllText.setBounds(457, 253, 106, 50);
		contentPane.add(clearAllText);
	}
}
