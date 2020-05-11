package Hostpital_System_Model;

public class HospitalDTO {
	private int hos_num;
	private String hos_name;
	private String hos_ad;
	private String hos_ph;
	private String hos_time;
	
	public HospitalDTO(int hos_num, String hos_name, String hos_ad, String hos_ph, String hos_time) {
		super();
		this.hos_num = hos_num;
		this.hos_name = hos_name;
		this.hos_ad = hos_ad;
		this.hos_ph = hos_ph;
		this.hos_time = hos_time;
	}
	
	public HospitalDTO(int hos_num, String hos_name) {
		super();
		this.hos_num = hos_num;
		this.hos_name = hos_name;
	}
	
	public int getHos_num() {
		return hos_num;
	}

	public String getHos_name() {
		return hos_name;
	}

	public String getHos_ad() {
		return hos_ad;
	}

	public String getHos_ph() {
		return hos_ph;
	}

	public String getHos_time() {
		return hos_time;
	}
	
	public String toString() {
		return getHos_num()+"\t"+getHos_name()+"\t"+getHos_ad()+"\t"+getHos_ph()+"\t"+getHos_time();
	}
}
