package Hostpital_System_Model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Book_markDAO extends BaseDAO {

	// 즐겨찾기 추가
	public int book_mark(String id, int hos_num, int dept_num, String d_id) {
		int result = 0;
		connect();
		String sql = "INSERT INTO BOOK_MARK VALUES(BOOK_MARK_SEQ.NEXTVAL, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, hos_num);
			ps.setInt(3, dept_num);
			ps.setString(4, d_id);

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

	// 즐겨찾기 삭제
	public int delete_book_m(int book_num, String id) {
		int result = 0;
		connect();
		String sql = "DELETE BOOK_MARK WHERE BK_NUM = ? AND MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, book_num);
			ps.setString(2, id);

			result = ps.executeUpdate();
			if (result > 0) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	// 즐겨찾기 번호 출력
	public int getBook_num(String id, int hnum, int dnum, String doc_id) {
		connect();
		String sql = "SELECT BK_NUM FROM BOOK_MARK WHERE MEMBER_ID = ? AND HOS_NUM = ? AND DEPT_NUM = ? AND DOC_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, hnum);
			ps.setInt(3, dnum);
			ps.setString(4, doc_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				int book_num = rs.getInt(1);
				return book_num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return -1;
	}

	// 즐겨찾기 조회
	public ArrayList<ArrayList<String>> book_m_look(String id) {
		connect();
		ArrayList<ArrayList<String>> bk_list = new ArrayList<ArrayList<String>>();
		String sql = "SELECT HOS_NAME, DEPT_NAME, DOC_NAME FROM BM WHERE MEMBER_ID = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ArrayList<String> bk_list_2 = new ArrayList<String>();
				bk_list_2.add(rs.getString(1));
				bk_list_2.add(rs.getString(2));
				bk_list_2.add(rs.getString(3));
				bk_list.add(bk_list_2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return bk_list;
	}
}
