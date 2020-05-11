package Hostpital_System_Model;

import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalDAO extends BaseDAO implements ILookUp<HospitalDTO>{

	// ������ ��� ���� ���
	@Override
	public ArrayList<HospitalDTO> showList() {
		// TODO Auto-generated method stub
		ArrayList<HospitalDTO> hosList = new ArrayList<HospitalDTO>();
		connect();
		String sql = "SELECT * FROM HOSPITAL";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int hos_num = rs.getInt(1);
				String hos_name = rs.getString(2);
				String hos_ad = rs.getString(3);
				String hos_ph = rs.getString(4);
				String hos_time = rs.getString(5);
				hosList.add(new HospitalDTO(hos_num,hos_name,hos_ad,hos_ph,hos_time));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return hosList;
	}
	
    // ���� �̸� �˻�
	@Override
	public ArrayList<HospitalDTO> partSearch(String name) {
		// TODO Auto-generated method stub
		ArrayList<HospitalDTO> hosList = new ArrayList<HospitalDTO>();
		connect();
		String sql = "SELECT * FROM HOSPITAL WHERE HOS_NAME LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				int hos_num = rs.getInt(1);
				String hos_name = rs.getString(2);
				String hos_ad = rs.getString(3);
				String hos_ph = rs.getString(4);
				String hos_time = rs.getString(5);
				hosList.add(new HospitalDTO(hos_num,hos_name,hos_ad,hos_ph,hos_time));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return hosList;
	}

	// ���� ��ȣ�� ���� ���� ���� ���
	public HospitalDTO showInfo(int num) {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT * FROM HOSPITAL WHERE HOSPITAL_NUM = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				int hos_num = rs.getInt(1);
				String hos_name = rs.getString(2);
				String hos_ad = rs.getString(3);
				String hos_ph = rs.getString(4);
				String hos_time = rs.getString(5);
				HospitalDTO hosInfo = new HospitalDTO(hos_num, hos_name, hos_ad, hos_ph, hos_time);
				return hosInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return null;
	}
	
	
	// ���� ��ȣ�� �̸� ���
	public ArrayList<HospitalDTO> hos_list() {
		// TODO Auto-generated method stub
		ArrayList<HospitalDTO> hosList = new ArrayList<HospitalDTO>();
		connect();
		String sql = "SELECT HOS_NUM, HOS_NAME FROM HOSPITAL";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int hos_num = rs.getInt(1);
				String hos_name = rs.getString(2);
				hosList.add(new HospitalDTO(hos_num,hos_name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return hosList;
	}

	// ���� �̸��� ���� ���� ��ȣ ���
	public int getHos_num(String name) {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT HOS_NUM FROM HOSPITAL WHERE HOS_NAME = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				int hos_num = rs.getInt(1);
				return hos_num;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return -1;
	}



	
}
