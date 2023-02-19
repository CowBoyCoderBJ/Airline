/**
* Employee.java
*/

public class Employee extends Person {
	private double weight;
	private String firstName;
	private String lastName;
	private int empID;
	private static int totalEmp = 0;
	private String job;
	
	public Employee(String fn, String ln, String job, double wt) {
		super(fn, ln, wt);
		this.job = job;
		this.empID = getEmpID();
		totalEmp++;
	}

	public int getEmpID(){
		int empid = 500000000 + totalEmp;
		return empid;
	}

	public boolean hasJob(String isItThisJob){
		if (this.job.equals(isItThisJob)){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return super.toString() + ", EMP: "+ this.empID +  ", Job: " + this.job;
	}
	
}
