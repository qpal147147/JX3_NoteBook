public enum Sort {
	HAPPEN_DATA("發生時間"),
	SERVER("伺服器"),
	NAME("名字"),
	SECT("門派"),
	DEGREE("優劣度"),
	POSITIONING("角色定位"),
	SEX("性別"),
	SPEED("速度"),
	PLACE("地點");
	
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
