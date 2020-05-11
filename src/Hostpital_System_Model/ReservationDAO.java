package Hostpital_System_Model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ReservationDAO extends BaseDAO {

	// 인증
	public int certification(String name, String ph, String res_num) {
		connect();
		String sql = "SELECT CHECK_NAME, CHECK_PH, CHECK_ID_NUM FROM CHECK_LIST WHERE CHECK_NAME = ? AND CHECK_PH = ? AND CHECK_ID_NUM = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, ph);
			ps.setString(3, res_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				String temp = rs.getString(3);
				if (temp.equals(res_num)) {
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	// 예약하기
	public int reservation(String id, int dept_num, String d_id, String date) {
		int result = 0;
		connect();
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(date);
		System.out.println(timestamp);
		String sql = "INSERT INTO RESERVATION(RESV_NUM, MEMBER_ID, DEPT_NUM, DOC_ID, RESV_DATE) VALUES (RESERVATION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, dept_num);
			ps.setString(3, d_id);
			ps.setTimestamp(4, timestamp);

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
	
	// 예약 취소 버튼 클릭 시
	public int del_click(int res_num_del, String id_d_res) {
		BlackListDAO black = new BlackListDAO();
		int compare = black.sameDay_check(id_d_res, res_num_del);
		if(compare > 0) {
			return delete_reservation(res_num_del, id_d_res);
		}else {
			int result = black.grade_update(id_d_res);
			if(result == 1) {
				int grade = black.grade_check(id_d_res);
				if(grade == -1) return -2;
				else if(grade == 3) {
					int res = black.insert_black(id_d_res);
					if(res == 1) {
						return delete_reservation(res_num_del, id_d_res);
					}
				}
			}
		}
		return -3;
	}
	
	
	// 예약 취소
	public int delete_reservation(int res_num_del, String id_d_res) {
		int result = 0;
		connect();
		String sql = "DELETE RESERVATION WHERE RESV_NUM = ? AND MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, res_num_del);
			ps.setString(2, id_d_res);

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

	// 예약 번호 출력
	public int getRes_num(String id, int dnum, String doc_id, String resv_date) {
		connect();
		String sql = "SELECT RESV_NUM FROM RESERVATION WHERE MEMBER_ID = ? AND DEPT_NUM = ? AND DOC_ID = ? AND RESV_DATE = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, dnum);
			ps.setString(3, doc_id);
			java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(resv_date);
			ps.setTimestamp(4, timestamp);
			rs = ps.executeQuery();
			while (rs.next()) {
				int res_num = rs.getInt(1);
				return res_num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;
	}
	
	// 예약 전체 조회
	public ArrayList<ArrayList<String>> showRes_list(String id){
		ArrayList<ArrayList<String>> res_list = new ArrayList<ArrayList<String>>();
		connect();
		String sql = "SELECT HOS_NAME, DEPT_NAME, DOC_NAME, RESV_DATE, RESV_REQ_DATE FROM RESER WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				Timestamp date_time = rs.getTimestamp(4);
				SimpleDateFormat date= new SimpleDateFormat( "yyyy-MM-dd HH:mm:mm" , Locale.KOREA );
				String res = date.format( new Date( date_time.getTime( )));
				list.add(res);
				Timestamp req_time = rs.getTimestamp(5);
				String req = date.format( new Date( date_time.getTime( )));
				list.add(req);
				res_list.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return res_list;
	}
	
	public ArrayList<ArrayList<String>> showRes_today(String id){
		ArrayList<ArrayList<String>> res_list = new ArrayList<ArrayList<String>>();
		connect();
		String sql = "SELECT HOS_NAME, DEPT_NAME, DOC_NAME, RESV_DATE, RESV_REQ_DATE FROM RESER WHERE MEMBER_ID = ? AND RESV_DATE > ? AND RESV_DATE < ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date(System.currentTimeMillis()));
			String toDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			cal.add(Calendar.DATE, 1);
			String tomorrow= new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
//			Date today = null;
//			Date tomor = null;
//			today = Date.valueOf(toDay);
//			tomor = Date.valueOf(tomorrow);
//			System.out.println(today);
//			System.out.println(tomor);
			ps.setString(2, toDay);
			ps.setString(3, tomorrow);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				Timestamp date_time = rs.getTimestamp(4);
				SimpleDateFormat date= new SimpleDateFormat( "yyyy-MM-dd HH:mm" , Locale.KOREA );
				String res = date.format( new Date( date_time.getTime( )));
				list.add(res);
				Timestamp req_time = rs.getTimestamp(5);
				String req = date.format( new Date( date_time.getTime( )));
				list.add(req);
				res_list.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return res_list;
	}
	
	public ArrayList<ArrayList<String>> showRes_mon(String id){
		ArrayList<ArrayList<String>> res_list = new ArrayList<ArrayList<String>>();
		connect();
		String sql = "SELECT HOS_NAME, DEPT_NAME, DOC_NAME, RESV_DATE, RESV_REQ_DATE FROM RESER WHERE MEMBER_ID = ? AND RESV_DATE > ? AND RESV_DATE < ?"
				+ " ORDER BY RESV_DATE";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date(System.currentTimeMillis()));
			String toDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
			cal.add(Calendar.DATE, 31);
			String tomorrow= new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
//			Date today = null;
//			Date tomor = null;
//			today = Date.valueOf(toDay);
//			tomor = Date.valueOf(tomorrow);
//			System.out.println(today);
//			System.out.println(tomor);
			ps.setString(2, toDay);
			ps.setString(3, tomorrow);
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				Timestamp date_time = rs.getTimestamp(4);
				SimpleDateFormat date= new SimpleDateFormat( "yyyy-MM-dd HH:mm" , Locale.KOREA );
				String res = date.format( new Date( date_time.getTime( )));
				list.add(res);
				Timestamp req_time = rs.getTimestamp(5);
				String req = date.format( new Date( date_time.getTime( )));
				list.add(req);
				res_list.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return res_list;
	}
	
	public String getRes_list(int renum, String id){
		connect();
		String sql = "SELECT RESV_DATE FROM reservation WHERE RESV_NUM = ? AND MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, renum);
			ps.setString(2, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Timestamp date_time = rs.getTimestamp(1);
				SimpleDateFormat date= new SimpleDateFormat( "yyyy-MM-dd" , Locale.KOREA );
				String res = date.format( new Date( date_time.getTime( )));
				return res;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;
	}
		
	
}
