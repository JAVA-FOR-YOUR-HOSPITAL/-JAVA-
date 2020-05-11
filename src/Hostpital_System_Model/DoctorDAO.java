package Hostpital_System_Model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DoctorDAO extends BaseDAO implements ILookUp<DoctorDTO> {

	// 의사 모든 정보 출력
	@Override
	public ArrayList<DoctorDTO> showList() {
		// TODO Auto-generated method stub
		ArrayList<DoctorDTO> docList = new ArrayList<DoctorDTO>();
		connect();
		String sql = "SELECT * FROM DOCTOR";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String doc_id = rs.getString(1);
				String doc_name = rs.getString(2);
				String doc_profile = rs.getString(3);
				int dept_num = rs.getInt(4);
				docList.add(new DoctorDTO(doc_id, doc_name, doc_profile, dept_num));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return docList;
	}

	// 의사 이름 검색
	@Override
	public ArrayList<DoctorDTO> partSearch(String name) {
		// TODO Auto-generated method stub
		ArrayList<DoctorDTO> docList = new ArrayList<DoctorDTO>();
		connect();
		String sql = "SELECT * FROM DOCTOR WHERE DOCTOR_NAME LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				String doc_id = rs.getString(1);
				String doc_name = rs.getString(2);
				String doc_profile = rs.getString(3);
				int dept_num = rs.getInt(4);
				docList.add(new DoctorDTO(doc_id, doc_name, doc_profile, dept_num));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return docList;
	}

	// 의사 이름에 따른 병원 이름, 진료과 이름, 의사 이름 출력 (진료과이름으로 정렬)
	public ArrayList<ArrayList<String>> docSearch(String name) {
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		connect();
		String sql = "SELECT H.HOS_NAME, E.DEPT_NAME, D.DOC_NAME FROM DOCTOR D, DEPT E, HOSPITAL H WHERE D.DEPT_NUM = E.DEPT_NUM AND E.HOS_NUM = H.HOS_NUM "
				+ "AND D.DOC_NAME LIKE ? ORDER BY E.DEPT_NAME";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				lists.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return lists;
	}

	// 병원 번호와 진료과 번호, 의사 이름에 따른 의사 프로필 출력
	public String getDoc_profile(int hnum, int dnum, String name) {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT DOC_PROFILE FROM DOC_IDS WHERE HOS_NUM = ? AND DEPT_NUM = ? AND DOC_NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hnum);
			ps.setInt(2, dnum);
			ps.setString(3, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				String doc_profile = rs.getString(1);
				return doc_profile;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 병원 번호, 진료과 번호, 의사 이름에 따른 의사 id 출력
	public String getDoc_id(int hnum, int dnum, String name) {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT DOC_ID FROM DOC_IDS WHERE HOS_NUM = ? AND DEPT_NUM = ? AND DOC_NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hnum);
			ps.setInt(2, dnum);
			ps.setString(3, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(1);
				return userId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 병원 번호, 진료과 번호, 의사 아이디에 따른 off_day 출력
	public ArrayList<String> getOff_day(String doc_id) {
		// TODO Auto-generated method stub
		ArrayList<String> offday = new ArrayList<String>();
		connect();
		String sql = "SELECT SCH_OFF FROM JOINS WHERE DOC_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doc_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Date off = rs.getDate(1);
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = transFormat.format(off);
				offday.add(date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return offday;
	}

	// 진료과 번호에 따른 의사 off_day 출력
		public ArrayList<ArrayList<String>> getDept_day(int dnum) {
			// TODO Auto-generated method stub
			ArrayList<ArrayList<String>> offday = new ArrayList<ArrayList<String>>();
			connect();
			String sql = "SELECT DOC_ID, SCH_OFF FROM JOINS WHERE DEPT_NUM = ?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dnum);
				rs = ps.executeQuery();
				while (rs.next()) {
					ArrayList<String> list = new ArrayList<String>();
					String doc_id = rs.getString(1);
					Date date = rs.getDate(2);
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					String off = transFormat.format(date);
					list.add(doc_id);
					list.add(off);
					offday.add(list);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return offday;
		}
		
	// 의사 아이디에 따른 예약 날짜 출력
	public ArrayList<String> getDoc_res(String doc_id) {
		ArrayList<String> res_list = new ArrayList<String>();
		connect();
		String sql = "SELECT RESV_DATE FROM RESER_N WHERE DOC_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doc_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Timestamp date_time = rs.getTimestamp(1);
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
				String res = date.format(new Date(date_time.getTime()));
				res_list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return res_list;
	}
	
	public ArrayList<String> docSearch(String hname, String dname) {
		ArrayList<String> lists = new ArrayList<String>();
		connect();
		String sql = "SELECT D.DOC_NAME FROM DOCTOR D, DEPT E, HOSPITAL H WHERE D.DEPT_NUM = E.DEPT_NUM "
				+ "AND E.HOS_NUM = H.HOS_NUM AND H.HOS_NAME = ? AND E.DEPT_NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hname);
			ps.setString(2, dname);
			rs = ps.executeQuery();
			while (rs.next()) {
				lists.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return lists;
	}

	
}
