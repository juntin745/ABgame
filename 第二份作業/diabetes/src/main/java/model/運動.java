package model;

public class 運動 {
	private String 運動代號;
	private String 運動名稱;
	public 運動(String 運動名稱) {
		super();
		
		this.運動名稱 = 運動名稱;
	}
	public 運動() {
		super();
	}
	public String get運動代號() {
		return 運動代號;
	}
	public void set運動代號(String 運動代號) {
		this.運動代號 = 運動代號;
	}
	public String get運動名稱() {
		return 運動名稱;
	}
	public void set運動名稱(String 運動名稱) {
		this.運動名稱 = 運動名稱;
	}
	public String toString() {
		return 運動名稱;
	}
	
	
}
