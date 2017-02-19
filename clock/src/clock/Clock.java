package clock;

import java.util.TreeMap;

/**
 * @version 1.0
 * @author mazahir
 *
 */
public class Clock {

	private int hour, minute;
	private static final String PAST = "past";
	private static final String TO = "to";
	private String time;
	/*
	 * TreeMap: 1- Duplicate entry is not allowed, 2- Mapping key to value, 3-
	 * Order is important, 4- Entries is sorted.
	 */
	private TreeMap<Integer, String> hours = new TreeMap<Integer, String>();
	private TreeMap<Integer, String> minutes = new TreeMap<Integer, String>();

	public Clock() {
		this.hour = -1;
		this.minute = -1;
		this.fillingHoursMap();
		this.fillingMinutesMap();
	}

	public Clock(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.fillingHoursMap();
		this.fillingMinutesMap();
	}

	/*
	 * Methods
	 */
	public void convert () {
		if(this.minute == 0) {
			time = this.hours.get(this.hour) + " " + this.minutes.get(this.minute);
		} else if (this.minute > 30) {
			time = this.minutes.get(this.minute) + " " + TO + " " + this.hours.get((this.hour+1) % 12);
		} else {
			time = this.minutes.get(this.minute) + " " + PAST + " " + this.hours.get(this.hour);
		}
	}

	public void talking() {
		this.convert();
		System.out.println("[" + this.hour + ":" + this.minute + "] " + time.toString());
	}

	/*
	 * Utilities
	 */
	private void fillingHoursMap() {
		this.hours.put(1, "one");
		this.hours.put(2, "two");
		this.hours.put(3, "three");
		this.hours.put(4, "four");
		this.hours.put(5, "five");
		this.hours.put(6, "six");
		this.hours.put(7, "seven");
		this.hours.put(8, "eight");
		this.hours.put(9, "nine");
		this.hours.put(10, "ten");
		this.hours.put(11, "eleven");
		this.hours.put(12, "twelve");
	}

	private void fillingMinutesMap() {
		this.minutes.put(0, "o'clock");
		this.minutes.put(5, "five");
		this.minutes.put(10, "ten");
		this.minutes.put(15, "quarter");
		this.minutes.put(20, "twenty");
		this.minutes.put(25, "twenty-five");
		this.minutes.put(30, "half");
		this.minutes.put(35, "twenty-five");
		this.minutes.put(40, "twenty");
		this.minutes.put(45, "quarter");
		this.minutes.put(50, "ten");
		this.minutes.put(55, "five");
	}

	/*
	 * Getters & Setters
	 */
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String getPast() {
		return PAST;
	}

	public String getTo() {
		return TO;
	}

	public TreeMap<Integer, String> getHours() {
		return hours;
	}

	public TreeMap<Integer, String> getMinutes() {
		return minutes;
	}

}
