package Hostpital_System_Model;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MemberDAO extends BaseDAO {

	// ȸ������
	public int SignUp(String id, String pw1, String pw2, String name, String member_ad, String member_ph,
			String member_birth) {
		if (!pw1.equals(pw2)) {
			return -2;
		}
		int result = check(id);
		if (result == -1) {
			return -1;
		} else {
			connect();
			String sql = "INSERT INTO MEMBER(MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_AD,MEMBER_PH,MEMBER_BIRTH)"
					+ "VALUES (?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw1);
				ps.setString(3, name);
				ps.setString(4, member_ad);
				ps.setString(5, member_ph);
				ps.setDate(6, java.sql.Date.valueOf(member_birth));
				int cnt = ps.executeUpdate();
				if (cnt > 0)
					return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		return -3;
	}

	// id �ߺ� üũ
	public int check(String id) {
		connect();
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 1;
	}

	// �α���
	public MemberDTO login(String id, String pw) {
		connect();
		String sql = "UPDATE MEMBER SET MEMBER_LOG = '1' WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			int cnt = ps.executeUpdate();
			if (cnt > 0) {
				rs = conn.createStatement().executeQuery(
						String.format("SELECT MEMBER_NAME, MEMBER_LOG FROM MEMBER WHERE MEMBER_ID = '%s'", id));
				if (rs.next()) {
					MemberDTO member = new MemberDTO(rs.getString(1), rs.getBoolean(2));
					return member;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// �α׾ƿ�
	public MemberDTO logout(String id) {
		connect();
		String sql = "UPDATE MEMBER SET MEMBER_LOG = '0' WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int cnt = ps.executeUpdate();
			if (cnt > 0) {
				rs = conn.createStatement().executeQuery(
						String.format("SELECT MEMBER_NAME, MEMBER_LOG FROM MEMBER WHERE MEMBER_ID = '%s'", id));
				if (rs.next()) {
					MemberDTO member = new MemberDTO(rs.getString(1), rs.getBoolean(2));
					return member;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// ���� ���� ��� (�� ���� ��ȸ)
	public MemberDTO showInfo(String id) {
		connect();
		String sql = "SELECT MEMBER_ID, MEMBER_NAME, MEMBER_AD, MEMBER_PH, MEMBER_BIRTH, MEMBER_GRADE, MEMBER_LOG"
				+ " FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String member_id = rs.getString(1);
				String member_name = rs.getString(2);
				String member_ad = rs.getString(3);
				String member_ph = rs.getString(4);
				Date dt = rs.getDate(5);
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = transFormat.format(dt);
				int member_grade = rs.getInt(6);
				boolean member_log = rs.getBoolean(7);
				MemberDTO member = new MemberDTO(member_id, null, member_name, member_ad, member_ph, date, member_grade, member_log);
				return member;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// ��й�ȣ ����
	public int pw_change(String id, String pw, String pw2) {
		int result = 0;
		connect();
		String sql = "UPDATE MEMBER SET MEMBER_PW = ? WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw2);
			ps.setString(2, id);
			ps.setString(3, pw);
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
	
	// �ּ� ����
	public int ad_change(String id, String pw, String ad) {
	      int result = 0;
	      connect();
	      String sql = "UPDATE MEMBER SET MEMBER_AD = ? WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, ad);
	         ps.setString(2, id);
	         ps.setString(3, pw);
	         
	         result = ps.executeUpdate();
	         
	         if(result > 0) {
	            return 1;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      finally {
	         disconnect();
	      }
	      return -1;
	   }
	
	// Ż��
	public int withdrawal(String id, String pw, String pw2) {
	      int result = 0;
	      connect();
	      String sql = "DELETE MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, id);
	         ps.setString(2, pw);
	         
	         result = ps.executeUpdate();
	         if(result > 0) {
	            return 1;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      finally {
	         disconnect();
	      }
	      return -1;
	      
	   }
	
	// �ڵ�����ȣ ����
	public int ph_change(String id, String pw, String ph) {
	      int result = 0;
	      connect();
	      String sql = "UPDATE MEMBER SET MEMBER_PH = ? WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1,   ph);
	         ps.setString(2, id);
	         ps.setString(3, pw);
	         
	         result = ps.executeUpdate();
	         
	         if(result > 0) {
	            return 1;
	         }
	         
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	      }
	      finally {
	         disconnect();
	      }
	      return -1;
	   }
	// �� �� �� date ����
//    public Date transformDate(String year, String month, String day)
//    {
//        String date = year+"-"+month+"-"+day;
//        Date dt = Date.valueOf(date);
//        return dt;
//    }


	
	
	
}
