package com.infinite.Employeequickstart;

public class Employ {

	private int id;
	private String empname;
	private String begin_date;
	private String end_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "Employ [id=" + id + ", empname=" + empname + ", begin_date=" + begin_date + ", end_date=" + end_date
				+ "]";
	}
	
	
}
