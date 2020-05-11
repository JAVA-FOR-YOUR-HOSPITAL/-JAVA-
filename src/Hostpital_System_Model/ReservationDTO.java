package Hostpital_System_Model;

public class ReservationDTO {
	private int resv_num;
	private int dept_num;
	private String doc_id;
	private String resv_date;
	private String resv_req_date;
	
	public ReservationDTO(int resv_num, int dept_num, String doc_id, String resv_date, String resv_req_date) {
		super();
		this.resv_num = resv_num;
		this.dept_num = dept_num;
		this.doc_id = doc_id;
		this.resv_date = resv_date;
		this.resv_req_date = resv_req_date;
	}

	public int getResv_num() {
		return resv_num;
	}

	public int getDept_num() {
		return dept_num;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public String getResv_date() {
		return resv_date;
	}

	public String getResv_req_date() {
		return resv_req_date;
	}
}
