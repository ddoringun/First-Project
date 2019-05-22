package projectP;

public class IncomeDTO {
	
	int income;
	String category;
	String memo;
	String date;
	String id;
	
	public IncomeDTO() {

	}

	public IncomeDTO( String date, int income, String category, String memo, String id) {
		this.date = date;
		this.income = income;
		this.category = category;
		this.memo = memo;
		this.id = id;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
}
