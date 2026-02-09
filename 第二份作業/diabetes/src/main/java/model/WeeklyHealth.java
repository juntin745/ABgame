package model;

import java.time.LocalDate;

public class WeeklyHealth {
	private String week_id;
	private LocalDate date;
	private int blood_sugar ;
	private int systolic_blood_pressure;
	private int diastolic_blood_pressure;
	private int pulse;
	private double weight;
	private String 用戶id;
	public WeeklyHealth(LocalDate date, int blood_sugar, int systolic_blood_pressure, int diastolic_blood_pressure,
			int pulse, double weight,String 用戶id) {
		super();
		this.date = date;
		this.blood_sugar = blood_sugar;
		this.systolic_blood_pressure = systolic_blood_pressure;
		this.diastolic_blood_pressure = diastolic_blood_pressure;
		this.pulse = pulse;
		this.weight = weight;
		this.用戶id=用戶id;
	}
	public String get用戶id() {
		return 用戶id;
	}
	public void set用戶id(String 用戶id) {
		this.用戶id = 用戶id;
	}
	public WeeklyHealth() {
		super();
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getBlood_sugar() {
		return blood_sugar;
	}
	public void setBlood_sugar(int blood_sugar) {
		this.blood_sugar = blood_sugar;
	}
	public int getSystolic_blood_pressure() {
		return systolic_blood_pressure;
	}
	public void setSystolic_blood_pressure(int systolic_blood_pressure) {
		this.systolic_blood_pressure = systolic_blood_pressure;
	}
	public int getDiastolic_blood_pressure() {
		return diastolic_blood_pressure;
	}
	public void setDiastolic_blood_pressure(int diastolic_blood_pressure) {
		this.diastolic_blood_pressure = diastolic_blood_pressure;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getWeek_id() {
		return week_id;
	}
	public void setWeek_id(String week_id) {
		this.week_id = week_id;
	}
	
	
	
}
