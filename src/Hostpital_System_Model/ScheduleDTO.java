package Hostpital_System_Model;

public class ScheduleDTO {
	private int sch_num;
	private String doc_id;
	private String sch_off;
	
	public ScheduleDTO(int sch_num, String doc_id, String sch_off) {
		super();
		this.sch_num = sch_num;
		this.doc_id = doc_id;
		this.sch_off = sch_off;
	}

	public int getSch_num() {
		return sch_num;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public String getSch_off() {
		return sch_off;
	}
}
