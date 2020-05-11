package Hostpital_System_Model;

public class DoctorDTO {
	private String doc_id; 
	private String doc_name;
	private String doc_profile;
	private int dept_num;
	
	public DoctorDTO(String doc_id, String doc_name, String doc_profile, int dept_num) {
		super();
		this.doc_id = doc_id;
		this.doc_name = doc_name;
		this.doc_profile = doc_profile;
		this.dept_num = dept_num;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public String getDoc_profile() {
		return doc_profile;
	}

	public int getDept_num() {
		return dept_num;
	}
	
	public String toString() {
		return getDoc_id()+"\t"+getDoc_name()+"\t"+getDoc_profile()+"\t"+getDept_num();
	}
	
}
