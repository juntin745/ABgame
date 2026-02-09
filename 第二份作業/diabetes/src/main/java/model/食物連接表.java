package model;

public class 食物連接表 {
	private String UID;
	private String 週ID;
	private String 食物ID;
	private int 次數;
	public 食物連接表(String UID,String 週id, String 食物id, int 次數) {
		super();
		this.UID=UID;
		this.週ID = 週id;
		this.食物ID = 食物id;
		this.次數 = 次數;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String get週ID() {
		return 週ID;
	}
	public void set週ID(String 週id) {
		週ID = 週id;
	}
	public String get食物ID() {
		return 食物ID;
	}
	public void set食物ID(String 食物id) {
		食物ID = 食物id;
	}
	public int get次數() {
		return 次數;
	}
	public void set次數(int 次數) {
		this.次數 = 次數;
	}
	public 食物連接表() {
		super();
	}
	
	
	
}
