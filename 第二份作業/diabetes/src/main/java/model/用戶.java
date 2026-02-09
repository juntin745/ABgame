package model;



public class 用戶{
	private String user_id;
	private String user_name;
	private String 帳號;
	private String 密碼;
	public 用戶(String user_name, String 帳號, String 密碼) {
		super();
		this.user_name = user_name;
		this.帳號 = 帳號;
		this.密碼 = 密碼;
	}
	
	public 用戶() {
		super();
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String get帳號() {
		return 帳號;
	}
	public void set帳號(String 帳號) {
		this.帳號 = 帳號;
	}
	public String get密碼() {
		return 密碼;
	}
	public void set密碼(String 密碼) {
		this.密碼 = 密碼;
	}
	
	
	
	
}
