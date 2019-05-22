package projectP;

public class MemberDTO {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String home;
	private String gender;
	private int age;
	
	
	
	public MemberDTO() {

	}

	public MemberDTO(int num, String id, String pw, String name, String email, String home, String gender, int age) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.home = home;
		this.gender = gender;
		this.age = age;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [" + num + "," + id + "," + pw + "," + name + "," + email + ","
				+ home + "," + gender + "," + age + "] \n";
	}
	
	
	
}
