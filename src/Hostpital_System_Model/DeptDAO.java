package Hostpital_System_Model;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO extends BaseDAO implements ILookUp<DeptDTO> {


	// 진료과 모든 정보 출력
	@Override
	public ArrayList<DeptDTO> showList() {
		// TODO Auto-generated method stub
		ArrayList<DeptDTO> deptList = new ArrayList<DeptDTO>();
		connect();
		String sql = "SELECT * FROM DEPT";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int dept_num = rs.getInt(1);
				String dept_name = rs.getString(2);
				String dept_ph = rs.getString(3);
				int hos_num = rs.getInt(4);
				deptList.add(new DeptDTO(dept_num, dept_name, dept_ph, hos_num));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return deptList;
	}

	// 진료과 이름 검색
	public ArrayList<DeptDTO> partSearch(String name) {
		// TODO Auto-generated method stub
		ArrayList<DeptDTO> deptList = new ArrayList<DeptDTO>();
		connect();
		String sql = "SELECT * FROM DEPT WHERE DEPT_NAME LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int dept_num = rs.getInt(1);
				String dept_name = rs.getString(2);
				String dept_ph = rs.getString(3);
				int hos_num = rs.getInt(4);
				deptList.add(new DeptDTO(dept_num,dept_name,dept_ph,hos_num));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return deptList;
	}

	// 병원 번호에 따른 진료과 번호, 진료과 이름 출력
	public ArrayList<DeptDTO> hos_dept(int num) {
		// TODO Auto-generated method stub
		ArrayList<DeptDTO> deptList = new ArrayList<DeptDTO>();
		connect();
		String sql = "SELECT D.DEPT_NUM, D.DEPT_NAME FROM HOSPITAL H, DEPT D " + 
				"WHERE H.HOS_NUM = D.HOS_NUM AND H.HOS_NUM = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
				int dept_num = rs.getInt(1);
				String dept_name = rs.getString(2);
				deptList.add(new DeptDTO(dept_num,dept_name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return deptList;
	}
	
	// 병원번호와 진료과 이름에 따른 진료과 번호 출력
	public int getDept_num(int num, String name) {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT E.DEPT_NUM FROM HOSPITAL H, DEPT E WHERE H.HOS_NUM = E.HOS_NUM AND"
				+ " H.HOS_NUM = ? AND E.DEPT_NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,num);
			ps.setString(2,name);
			rs = ps.executeQuery();
			while(rs.next()) {
				int dept_num = rs.getInt(1);
				return dept_num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return -1;
	}

	// 진료과 이름에 따른 병원 이름과 진료과 이름 출력 
	public ArrayList<ArrayList<String>> dept_Search(String name) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> dept_list = new ArrayList<ArrayList<String>>();
		connect();
		String sql = "SELECT H.HOS_NAME, D.DEPT_NAME FROM HOSPITAL H, DEPT D WHERE H.HOS_NUM = D.HOS_NUM AND DEPT_NAME LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				dept_list.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept_list;
	}

	
}
