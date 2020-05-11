package Hostpital_System_Model;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BlackListDAO extends BaseDAO {

	// 취소 날짜와 예약 날짜 비교하여 결과 반환
	public int sameDay_check(String id, int rs_num) {
		ReservationDAO res = new ReservationDAO();
		String date = res.getRes_list(rs_num, id);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date(System.currentTimeMillis()));
		String toDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		Date resv_date = null;
		Date today = null;

		resv_date = Date.valueOf(date);
		today = Date.valueOf(toDay);
		int compare = resv_date.compareTo(today);
		return compare;
	}
	
	
	// 블랙리스트 추가
	public int insert_black(String id) {
		int result = 0;
		connect();
		String sql = "INSERT INTO B_LIST VALUES(B_LIST_SEQ.NEXTVAL, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;
	}

	// 회원 등급 확인
	public int grade_check(String id) {
		connect();
		String sql = "SELECT MEMBER_GRADE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int grade = rs.getInt(1);
				return grade;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	// 회원 등급 업데이트
	public int grade_update(String id) {
		int result = 0;
		connect();
		String sql = "UPDATE MEMBER SET MEMBER_GRADE = MEMBER_GRADE + 1 WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			result = ps.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;

	}

}
