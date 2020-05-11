package Hostpital_System_Test;

import org.junit.Test;

import Hostpital_System_Model.MemberDAO;
import Hostpital_System_Model.MemberDTO;

public class Connect {

	@Test
	public void test() {
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.showInfo("healthysoon");
		System.out.println(member.getMember_grade());
		System.out.println(member.getMember_name());
		System.out.println(member.getMember_birth());
	}

}
