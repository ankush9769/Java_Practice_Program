package models;

public class Emp {
	private int eid;
	private String ename;
	private double esalary;
	private int mid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Emp(int eid, String ename, double esalary, int mid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", mid=" + mid + "]";
	}
	
	
}
