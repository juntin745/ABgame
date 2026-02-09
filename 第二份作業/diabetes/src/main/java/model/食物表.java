package model;

public class 食物表 {
	private String 食物代號;
	private String 食物名稱;
	private int GI值;
	private double 好吃度;
	public 食物表(String 食物名稱, int gI值, double 好吃度) {
		super();
		this.食物名稱 = 食物名稱;
		GI值 = gI值;
		this.好吃度 = 好吃度;
	}
	public 食物表() {
		super();
	}
	public String get食物代號() {
		return 食物代號;
	}
	public void set食物代號(String 食物代號) {
		this.食物代號 = 食物代號;
	}
	public String get食物名稱() {
		return 食物名稱;
	}
	public void set食物名稱(String 食物名稱) {
		this.食物名稱 = 食物名稱;
	}
	public int getGI值() {
		return GI值;
	}
	public void setGI值(int gI值) {
		GI值 = gI值;
	}
	public double get好吃度() {
		return 好吃度;
	}
	public void set好吃度(double 好吃度) {
		this.好吃度 = 好吃度;
	}
	public String toString() {
		return 食物名稱;
	}
}
