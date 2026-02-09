
package 總表vo;

import java.time.LocalDate;

public class 健康週總表VO {

    private String 用戶id;
    private String 週ID;
    private LocalDate 日期;
    private int 血糖值;
    private int 收縮壓;
    private int 舒張壓;
    private int 脈搏;
    private double 體重;
    private String 運動名稱;
    private Double 單位; 
    private Double 時間;
    private String 食物名稱;
    private Integer GI值;
    private Double 好吃度;
    private Integer 次數;  

    public 健康週總表VO() {
		super();
	}

	public String get用戶id() {
		return 用戶id;
	}

	public void set用戶id(String 用戶id) {
		this.用戶id = 用戶id;
	}

	public String get週ID() {
		return 週ID;
	}

	public void set週ID(String 週id) {
		週ID = 週id;
	}

	public LocalDate get日期() {
		return 日期;
	}

	public void set日期(LocalDate 日期) {
		this.日期 = 日期;
	}

	public int get血糖值() {
		return 血糖值;
	}

	public void set血糖值(int 血糖值) {
		this.血糖值 = 血糖值;
	}

	public int get收縮壓() {
		return 收縮壓;
	}

	public void set收縮壓(int 收縮壓) {
		this.收縮壓 = 收縮壓;
	}

	public int get舒張壓() {
		return 舒張壓;
	}

	public void set舒張壓(int 舒張壓) {
		this.舒張壓 = 舒張壓;
	}

	public int get脈搏() {
		return 脈搏;
	}

	public void set脈搏(int 脈搏) {
		this.脈搏 = 脈搏;
	}

	public double get體重() {
		return 體重;
	}

	public void set體重(double 體重) {
		this.體重 = 體重;
	}

	public String get運動名稱() {
		return 運動名稱;
	}

	public void set運動名稱(String 運動名稱) {
		this.運動名稱 = 運動名稱;
	}

	public Double get單位() {
		return 單位;
	}

	public void set單位(Double 單位) {
		this.單位 = 單位;
	}

	public Double get時間() {
		return 時間;
	}

	public void set時間(Double 時間) {
		this.時間 = 時間;
	}

	public String get食物名稱() {
		return 食物名稱;
	}

	public void set食物名稱(String 食物名稱) {
		this.食物名稱 = 食物名稱;
	}

	public Integer getGI值() {
		return GI值;
	}

	public void setGI值(Integer gI值) {
		GI值 = gI值;
	}

	public Double get好吃度() {
		return 好吃度;
	}

	public void set好吃度(Double 好吃度) {
		this.好吃度 = 好吃度;
	}

	public Integer get次數() {
		return 次數;
	}

	public void set次數(Integer 次數) {
		this.次數 = 次數;
	}

	public String toString() {
        return "健康週總表VO{" +
                "用戶id='" + 用戶id + '\'' +
                ", 週ID='" + 週ID + '\'' +
                ", 日期=" + 日期 +
                ", 血糖值=" + 血糖值 +
                ", 收縮壓=" + 收縮壓 +
                ", 舒張壓=" + 舒張壓 +
                ", 脈搏=" + 脈搏 +
                ", 體重=" + 體重 +
                ", 運動名稱='" + 運動名稱 + '\'' +
                ", 單位=" + 單位 +
                ", 時間=" + 時間 +
                ", 食物名稱='" + 食物名稱 + '\'' +
                ", GI值=" + GI值 +
                ", 好吃度=" + 好吃度 +
                ", 次數=" + 次數 +
                '}';
    }
}