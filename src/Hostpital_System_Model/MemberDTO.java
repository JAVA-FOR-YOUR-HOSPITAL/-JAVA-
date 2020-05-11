package Hostpital_System_Model;

public class MemberDTO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_ad;
	private String member_ph;
	private String member_birth;
	private int member_grade;
	private boolean member_log;
	
	public MemberDTO(String member_id, String member_pw, String member_name, String member_ad, String member_ph,
			String member_birth, int member_grade, boolean member_log) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_ad = member_ad;
		this.member_ph = member_ph;
		this.member_birth = member_birth;
		this.member_grade = member_grade;
		this.member_log = member_log;
	}

	public MemberDTO(String member_name, Boolean member_log) {
		super();
		this.member_name = member_name;
		this.member_log = member_log;
	}

	
	public String getMember_id() {
		return member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public String getMember_ad() {
		return member_ad;
	}

	public String getMember_ph() {
		return member_ph;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public int getMember_grade() {
		return member_grade;
	}

	public boolean getMember_log() {
		return member_log;
	}
	
	
}
