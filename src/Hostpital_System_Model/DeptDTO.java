package Hostpital_System_Model;

public class DeptDTO {
	private int dept_num;
	private String dept_name;
	private String dept_ph;
	private int hos_num;
	
	public DeptDTO(int dept_num, String dept_name, String dept_ph, int hos_num) {
		super();
		this.dept_num = dept_num;
		this.dept_name = dept_name;
		this.dept_ph = dept_ph;
		this.hos_num = hos_num;
	}
	
	public DeptDTO(int dept_num, String dept_name) {
		super();
		this.dept_num = dept_num;
		this.dept_name = dept_name;
	}
	
	public int getDept_num() {
		return dept_num;
	}

	public String getDept_name() {
		return dept_name;
	}

	public String getDept_ph() {
		return dept_ph;
	}

	public int getHos_num() {
		return hos_num;
	}
	
	public String toString() {
		return getDept_num()+"\t"+getDept_name()+"\t"+getDept_ph()+"\t"+getHos_num();
	}
	
	
}
