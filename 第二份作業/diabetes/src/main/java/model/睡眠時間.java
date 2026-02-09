package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class 睡眠時間 {
	private LocalDate 日期;
	private DayOfWeek 星期;
	private LocalTime 開始睡覺時間;
	private LocalTime 起床時間;
	private double 總睡眠時數;
	public 睡眠時間(LocalDate 日期, LocalTime 開始睡覺時間, LocalTime 起床時間, double 總睡眠時數) {
		super();
		this.日期 = 日期;
		this.開始睡覺時間 = 開始睡覺時間;
		this.起床時間 = 起床時間;
		this.總睡眠時數 = 總睡眠時數;
	}
	public 睡眠時間() {
		super();
	}
	public LocalDate get日期() {
		return 日期;
	}
	public void set日期(LocalDate 日期) {
		this.日期 = 日期;
	}
	public DayOfWeek get星期() {
		return 星期;
	}
	public void set星期(DayOfWeek 星期) {
		this.星期 = 星期;
	}
	public LocalTime get開始睡覺時間() {
		return 開始睡覺時間;
	}
	public void set開始睡覺時間(LocalTime 開始睡覺時間) {
		this.開始睡覺時間 = 開始睡覺時間;
	}
	public LocalTime get起床時間() {
		return 起床時間;
	}
	public void set起床時間(LocalTime 起床時間) {
		this.起床時間 = 起床時間;
	}
	public double get總睡眠時數() {
		return 總睡眠時數;
	}
	public void set總睡眠時數(double 總睡眠時數) {
		this.總睡眠時數 = 總睡眠時數;
	}
	
	
	
}
