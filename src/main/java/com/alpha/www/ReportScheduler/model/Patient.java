package com.alpha.www.ReportScheduler.model;

import java.time.LocalDate;

public class Patient {
	private int id;
	private String name;
	private LocalDate lastVisit;

	public Patient(int id, String name, LocalDate lastVisit) {
		this.id = id;
		this.name = name;
		this.lastVisit = lastVisit;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getLastVisit() {
		return lastVisit;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", lastVisit=" + lastVisit + "]";
	}

}
