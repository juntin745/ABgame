package model;

public class 運動連接表 {
	private String UID;
	private String 週ID;
	private String 運動ID;
	private double 單位;
	private double 時間;
	public 運動連接表(String UID,String 週id, String 運動id, double 單位, double 時間) {
		super();
		this.UID=UID;
		this.週ID = 週id;
		this.運動ID = 運動id;
		this.單位 = 單位;
		this.時間 = 時間;
	}
	public 運動連接表() {
		super();
	}
	public String get週ID() {
		return 週ID;
	}
	public void set週ID(String 週id) {
		週ID = 週id;
	}
	public String get運動ID() {
		return 運動ID;
	}
	public void set運動ID(String 運動id) {
		運動ID = 運動id;
	}
	public double get單位() {
		return 單位;
	}
	public void set單位(double 單位) {
		this.單位 = 單位;
	}
	public double get時間() {
		return 時間;
	}
	public void set時間(double 時間) {
		this.時間 = 時間;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
}
