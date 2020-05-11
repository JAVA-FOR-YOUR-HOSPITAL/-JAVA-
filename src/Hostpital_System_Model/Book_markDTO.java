package Hostpital_System_Model;

public class Book_markDTO {
	private int bm_num;
	private String hos_num;
	private int dept_num;
	
	public Book_markDTO(int bm_num, String hos_num, int dept_num) {
		super();
		this.bm_num = bm_num;
		this.hos_num = hos_num;
		this.dept_num = dept_num;
	}

	public int getBm_num() {
		return bm_num;
	}

	public String getHos_num() {
		return hos_num;
	}

	public int getDept_num() {
		return dept_num;
	}
	
	
	
}
