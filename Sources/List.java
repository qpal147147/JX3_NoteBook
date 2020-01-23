import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class List{
	static private class Data implements Comparable<Data>,Comparator<Data>{
		Date happenDate;
		String server,name,sect,degree,positioning,sex,speed,place,description;
		Sort compareBy;
		
		Data(Sort s){
			this.compareBy = s;
		}
		Data(Date happenDate, String server, String name, String sect, String degree, String positioning, String sex,String speed, String place, String description) {
			this.happenDate = happenDate;
			this.server = server;
			this.name = name;
			this.sect = sect;
			this.degree = degree;
			this.positioning = positioning;
			this.sex = sex;
			this.speed = speed;
			this.place = place;
			this.description = description;
		}
		@Override
		public String toString() {
			return 	DateFormat.getDateInstance().format(this.happenDate) + "," +
					this.server + "," + 
					this.name + "," +
					this.sect + "," + 
					this.degree + "," + 
					this.positioning + "," +
					this.sex + "," + 
					this.speed + "," + 
					this.place + "," + 
					this.description;
		}
		@Override
		public int compareTo(Data d) {
			return this.happenDate.compareTo(d.happenDate);
		}
		@Override
		public int compare(Data d1, Data d2) {
			int i = 0;
			switch(compareBy) {
				case HAPPEN_DATA:
					i = d1.happenDate.compareTo(d2.happenDate);
					break;
				case SERVER:
					i = d1.server.compareTo(d2.server);
					break;
				case NAME:
					i = d1.name.compareTo(d2.name);
					break;
				case SECT:
					i = d1.sect.compareTo(d2.sect);
					break;
				case DEGREE:
					i = d1.degree.compareTo(d2.degree);
					break;
				case POSITIONING:
					i = d1.positioning.compareTo(d2.positioning);
					break;
				case SEX:
					i = d1.sex.compareTo(d2.sex);
					break;
				case SPEED:
					i = d1.speed.compareTo(d2.speed);
					break;
				case PLACE:
					i = d1.place.compareTo(d2.place);
					break;
			}
			return i;
		}
		
	}
	static private LinkedList<Data> list = new LinkedList<>();
	static private LinkedList<Data> searchData = new LinkedList<>();
	
	static public void addData(Date happenDate, String server, String name, String sect, String degree, String positioning, String sex,String speed, String place, String description) {
		list.add(new Data(happenDate,server,name,sect,degree,positioning,sex,speed,place,description));
		Collections.sort(list);
	}
	static boolean save() {
		StringBuilder sb = new StringBuilder();
		for(Data d:list) {
			sb.append(d.toString());
			sb.append("\n");
		}
		
		try(FileWriter fw = new FileWriter("List.csv")) {
			fw.write("發生時間,伺服器,角色名稱,門派,優劣度,角色定位,性別,通關速度,副本名稱,詳細描述\n");
			fw.write(sb.toString());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"存取檔案錯誤!\n" + e.getMessage(),"錯誤",JOptionPane.ERROR_MESSAGE);
			list.removeLast();
			
			return false;
		}
		
		return true;
	}
	static public void load() throws ParseException, IOException {
		File file = new File("List.csv");
		if(!file.exists()) {
			file.createNewFile();
			try(FileWriter fw = new FileWriter("List.csv")) {
				fw.write("發生時間,伺服器,角色名稱,門派,優劣度,角色定位,性別,通關速度,副本名稱,詳細描述\n");
			}
		}
		else {
			try(Scanner scn = new Scanner(new File("List.csv")).useDelimiter(",|\n")){
				scn.nextLine();
				
				while(scn.hasNext()) {
					list.add(new Data(DateFormat.getDateInstance().parse(scn.next()),scn.next(),scn.next(),scn.next(),scn.next(),scn.next(),scn.next(),scn.next(),scn.next(),scn.next()));
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	static public void addDataToJCB(JComboBox<String> jcb) {
		for(Data d:list) {
			jcb.addItem(d.toString());
		}
	}
	static public void clearJCB(JComboBox<String> jcb) {
		jcb.removeAllItems();
	}
	static public boolean deleteSlectData(int index) {
		File file = new File("List.csv");
		File sameFile = new File("List.csv");
		if(file.renameTo(sameFile)) {			//check file open or close
			list.remove(index);
			save();
			return true;
		}
		else {
			return false;
		}
		
	}
	static public boolean deleteAllData() {
		File file = new File("List.csv");
		File sameFile = new File("List.csv");
		if(file.renameTo(sameFile)) {			//check file open or close
			list.clear();
			save();
			return true;
		}
		else {
			return false;
		}
	}
	static public void selectSortBy(Sort s) {
		Collections.sort(list, new Data(s));
		
	}
	static public int getSearchDataNumber() {
		return searchData.size();
	}
	static public void searchKey(String key,JComboBox<String> com) {
		if(!searchData.isEmpty())searchData.clear();
		for(Data d:list) {
			if(d.toString().indexOf(key) != -1) {
				searchData.add(d);
			}
		}
		for(Data d:searchData) {
			com.addItem(d.toString());
		}
	}
	static public boolean editData(int index,Date happenDate, String server, String name, String sect, String degree, String positioning, String sex,String speed, String place, String description) {
		File file = new File("List.csv");
		File sameFile = new File("List.csv");
		String IndexStr = "";
		if(file.renameTo(sameFile)) {			//check file open or close
			if(searchData.size()!=0) {
				IndexStr = searchData.get(index).toString();
			}
			else IndexStr = list.get(index).toString();
				
			for(Data d:list) {
				if(d.toString().equals(IndexStr)) {
					d.happenDate = happenDate;
					d.server = server;
					d.name = name;
					d.sect = sect;
					d.degree = degree;
					d.positioning = positioning;
					d.sex = sex;
					d.speed = speed;
					d.place = place;
					d.description = description;
				}
			}	
			save();
			return true;
		}
		else {
			return false;
		}
	}
	static public void print() {
		for(Data d:list) {
			System.out.println(d.toString());
		}
	}
}
