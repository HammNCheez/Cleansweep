package com.cleansweep.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reoccurring_tasks")
public class ReoccurringTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "frequency")
	private String frequency;

	@Column(name = "day_number")
	private Integer dayNumber;

	@Column(name = "task_interval")
	private Integer taskInterval;

	@Column(name = "week_number")
	private Integer weekNumber;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "occurrances")
	private Integer occurrances;

	// t.task_name
	// t.description

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public Integer getTaskInterval() {
		return taskInterval;
	}

	public void setTaskInterval(Integer taskInterval) {
		this.taskInterval = taskInterval;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getOccurrances() {
		return occurrances;
	}

	public void setOccurrances(Integer occurrances) {
		this.occurrances = occurrances;
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();

		sb.append("{");
		sb.append("   Frequency: " + getFrequency() + ",\n");
		sb.append("   DayNumber: " + getDayNumber() + ",\n");
		sb.append("TaskInterval: " + getTaskInterval() + ",\n");
		sb.append("  WeekNumber: " + getWeekNumber() + ",\n");
		sb.append("   StartDate: " + getStartDate() + ",\n");
		sb.append("     EndDate: " + getEndDate() + ",\n");
		sb.append(" Occurrances: " + getOccurrances());
		sb.append("}");

		return sb.toString();
	}
}
