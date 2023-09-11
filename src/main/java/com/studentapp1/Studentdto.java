package com.studentapp1;

public class Studentdto {
private int sid;
private String sname;
private double sper;
public Studentdto(int sid, String sname, double sper) {
	this.sid = sid;
	this.sname = sname;
	this.sper = sper;
}
public Studentdto() {
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public double getSper() {
	return sper;
}
public void setSper(double sper) {
	this.sper = sper;
}
}
