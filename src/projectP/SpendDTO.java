package projectP;


public class SpendDTO {

	
	int spend;
	static String category;
	String memo;
	String date;
	String id;
	
	
	public SpendDTO() {
	}

	public SpendDTO(int spend, String category, String memo, String date, String id) {
		this.spend = spend;
		this.category = category;
		this.memo = memo;
		this.date = date;
		this.id = id;
	}

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
