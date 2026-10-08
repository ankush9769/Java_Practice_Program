package models;

public class Manager {
	private int mid;
	private String mname;
	
	public Manager()
	{
		
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	public Manager(int mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + "]";
	}
	
	
}
