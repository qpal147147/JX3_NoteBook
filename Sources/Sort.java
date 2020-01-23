public enum Sort {
	HAPPEN_DATA("�o�ͮɶ�"),
	SERVER("���A��"),
	NAME("�W�r"),
	SECT("����"),
	DEGREE("�u�H��"),
	POSITIONING("����w��"),
	SEX("�ʧO"),
	SPEED("�t��"),
	PLACE("�a�I");
	
	private String Chinese;
	
	Sort(String s){
		this.Chinese = s;
	}
	
	public static String getChinese(int i) {
		String ch = "";
		for(Sort sort:Sort.values()) {
			if(sort.ordinal() == i) {
				ch = sort.Chinese;
			}
		}
		return ch;
	}
	public static Sort getSortName(String s) {
		Sort sortBy = null;
		for(Sort sort:Sort.values()) {
			if(sort.Chinese == s) {
				sortBy = sort;
			}
		}
		return sortBy;
	}
}
