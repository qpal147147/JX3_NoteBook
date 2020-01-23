import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Search extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTextField server;
	private JTextField name;
	private JTextField sect;
	private JTextField degree;
	private JTextField sex;
	private JTextField positioning;
	private JTextField speed;
	private JTextArea description;
	private JLabel lblNewLabel_2;
	private JTextField place;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JComboBox<String> comboBox;
	private JComboBox<String> selectSort;
	private JScrollPane scrollPane;
	private JLabel dataNumber;
	private JLabel lblNewLabel_12;
	private JTextField searchText;
	private JDateChooser happenDate;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Search() {
		setTitle("\u67E5\u8A62\u8CC7\u6599");
		ImageIcon imgIco = new ImageIcon("image\\JX3NoteBook.png");
		setIconImage(imgIco.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(14, 13, 566, 25);
		contentPane.add(comboBox);
		List.addDataToJCB(comboBox);
		comboBox.setSelectedItem(null);
		comboBox.addItemListener(this);
		
		JLabel lblNewLabel = new JLabel("\u767C\u751F\u6642\u9593");
		lblNewLabel.setBounds(42, 64, 66, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F3A\u670D\u5668");
		lblNewLabel_1.setBounds(269, 64, 57, 19);
		contentPane.add(lblNewLabel_1);
		
		server = new JTextField();
		server.setColumns(10);
		server.setBackground(SystemColor.controlHighlight);
		server.setBounds(340, 61, 116, 25);
		contentPane.add(server);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(SystemColor.controlHighlight);
		name.setBounds(122, 121, 116, 25);
		contentPane.add(name);
		
		sect = new JTextField();
		sect.setColumns(10);
		sect.setBackground(SystemColor.controlHighlight);
		sect.setBounds(340, 121, 116, 25);
		contentPane.add(sect);
		
		degree = new JTextField();
		degree.setColumns(10);
		degree.setBackground(SystemColor.controlHighlight);
		degree.setBounds(122, 181, 116, 25);
		contentPane.add(degree);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBackground(SystemColor.controlHighlight);
		sex.setBounds(122, 241, 116, 25);
		contentPane.add(sex);
		
		positioning = new JTextField();
		positioning.setColumns(10);
		positioning.setBackground(SystemColor.controlHighlight);
		positioning.setBounds(340, 181, 116, 25);
		contentPane.add(positioning);
		
		speed = new JTextField();
		speed.setColumns(10);
		speed.setBackground(SystemColor.controlHighlight);
		speed.setBounds(340, 241, 116, 25);
		contentPane.add(speed);
		
		lblNewLabel_2 = new JLabel("\u526F\u672C");
		lblNewLabel_2.setBounds(42, 312, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		place = new JTextField();
		place.setColumns(10);
		place.setBackground(SystemColor.controlHighlight);
		place.setBounds(122, 309, 334, 25);
		contentPane.add(place);
		
		lblNewLabel_3 = new JLabel("\u8A73\u7D30\u63CF\u8FF0");
		lblNewLabel_3.setBounds(213, 347, 72, 19);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u540D\u5B57");
		lblNewLabel_4.setBounds(42, 124, 57, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\u9580\u6D3E");
		lblNewLabel_5.setBounds(269, 124, 57, 19);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\u512A\u52A3");
		lblNewLabel_6.setBounds(42, 184, 57, 19);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u89D2\u8272\u5B9A\u4F4D");
		lblNewLabel_7.setBounds(269, 184, 66, 19);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("\u6027\u5225");
		lblNewLabel_8.setBounds(42, 244, 57, 19);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\u901F\u5EA6");
		lblNewLabel_9.setBounds(269, 244, 57, 19);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\u9810\u8A2D\u6392\u5E8F");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(470, 64, 110, 19);
		contentPane.add(lblNewLabel_10);
		
		selectSort = new JComboBox<>();
		selectSort.setBounds(480, 96, 100, 25);
		contentPane.add(selectSort);
		for(int i = 0;i<Sort.values().length;i++) {
			selectSort.addItem(Sort.getChinese(i));
		}
		
		selectSort.addItemListener(this);
		
		description = new JTextArea();
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setBackground(SystemColor.controlHighlight);
		description.setBounds(42, 369, 414, 106);
		description.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(description);
		
		scrollPane = new JScrollPane(description);
		scrollPane.setBounds(42, 369, 419, 106);
		contentPane.add(scrollPane);
		
		dataNumber = new JLabel("New label");
		dataNumber.setHorizontalAlignment(SwingConstants.CENTER);
		dataNumber.setBounds(500, 450, 57, 19);
		contentPane.add(dataNumber);
		dataNumber.setText("0\u7B46");
		
		lblNewLabel_12 = new JLabel("\u7576\u524D\u641C\u5C0B\u8CC7\u6599\u7B46\u6578");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(470, 418, 124, 19);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("\u641C\u5C0B");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(500, 158, 57, 19);
		contentPane.add(lblNewLabel_11);
		
		searchText = new JTextField();
		searchText.setBounds(480, 184, 100, 25);
		contentPane.add(searchText);
		searchText.setColumns(10);
		
		JButton searchBtn = new JButton("\u78BA\u5B9A");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchKey = searchText.getText();
				comboBox.removeAllItems();
				List.searchKey(searchKey,comboBox);
				dataNumber.setText(List.getSearchDataNumber() + "");
			}
		});
		searchBtn.setBounds(495, 224, 67, 27);
		contentPane.add(searchBtn);
		
		JButton editDataBtn = new JButton("\u5132\u5B58\u8CC7\u6599");
		editDataBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean checkEdit = List.editData(comboBox.getSelectedIndex(), happenDate.getDate(), server.getText(), name.getText(), sect.getText(), degree.getText(), positioning.getText(), sex.getText(), speed.getText(), place.getText(), description.getText());
				if(checkEdit)JOptionPane.showMessageDialog(null,"更新資料成功!\n","訊息",JOptionPane.PLAIN_MESSAGE, new ImageIcon("image\\success.png"));
				comboBox.removeAllItems();
				List.addDataToJCB(comboBox);
			}
		});
		editDataBtn.setToolTipText("\u5C07\u7DE8\u8F2F\u5F8C\u7684\u5167\u5BB9\u4FDD\u5B58");
		editDataBtn.setBounds(481, 308, 99, 27);
		contentPane.add(editDataBtn);
		
		happenDate = new JDateChooser();
		happenDate.setBounds(122, 64, 116, 25);
		contentPane.add(happenDate);
		
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, lblNewLabel, happenDate, lblNewLabel_1, server, lblNewLabel_4, name, lblNewLabel_5, serc, lblNewLabel_6, degree, lblNewLabel_7, positioning, lblNewLabel_8, sex, lblNewLabel_9, speed, lblNewLabel_2, place, lblNewLabel_3, description, lblNewLabel_10, selectSort}));
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, comboBox, lblNewLabel, happenDate, lblNewLabel_1, server, lblNewLabel_4, name, lblNewLabel_5, serc, lblNewLabel_6, degree, lblNewLabel_7, positioning, lblNewLabel_8, sex, lblNewLabel_9, speed, lblNewLabel_2, place, lblNewLabel_3}));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.drawLine(470, 81, 470, 505);
		g.drawLine(470, 180, 600, 180);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(e.getSource() == comboBox) {
				String s =  e.getItem().toString();
				
				try(Scanner scn = new Scanner(s).useDelimiter(",")){
					while(scn.hasNext()) {
						happenDate.setDate(DateFormat.getDateInstance().parse(scn.next()));
						server.setText(scn.next());
						name.setText(scn.next());
						sect.setText(scn.next());
						degree.setText(scn.next());
						positioning.setText(scn.next());
						sex.setText(scn.next());
						speed.setText(scn.next());
						place.setText(scn.next());
						description.setText(scn.next());
					}
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null,"存取檔案錯誤!\n" + exception.getMessage(),"錯誤",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(e.getSource() == selectSort) {
				Sort s = Sort.getSortName(e.getItem().toString());
				List.selectSortBy(s);
				List.clearJCB(comboBox);
				List.addDataToJCB(comboBox);
			}
		}
	}
}
