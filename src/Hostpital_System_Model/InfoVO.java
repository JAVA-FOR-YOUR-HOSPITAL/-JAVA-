package Hostpital_System_Model;

public class InfoVO {
	private static String id = "";
	private static String Username = "";
	private static String hosname = "";
	private static String deptname = "";
	private static String docname = "";
	private static int hos_num = 0;
	private static int dept_num = 0;
	private static int doc_num = 0;
	private static String date = "";
	private static String time = "";
	private static int findIndex = 0;
	
	public static String getId() {
		return id;
	}
	
	public static void setId(String id) {
		InfoVO.id = id;
	}
	public static String getUsername() {
		return Username;
	}
	public static void setUsername(String username) {
		Username = username;
	}
	public static String getHosname() {
		return hosname;
	}
	public static void setHosname(String hosname) {
		InfoVO.hosname = hosname;
	}
	public static String getDeptname() {
		return deptname;
	}
	public static void setDeptname(String deptname) {
		InfoVO.deptname = deptname;
	}
	public static String getDocname() {
		return docname;
	}
	public static void setDocname(String docname) {
		InfoVO.docname = docname;
	}
	public static int getHos_num() {
		return hos_num;
	}
	public static void setHos_num(int hos_num) {
		InfoVO.hos_num = hos_num;
	}
	public static int getDept_num() {
		return dept_num;
	}
	public static void setDept_num(int dept_num) {
		InfoVO.dept_num = dept_num;
	}
	public static int getDoc_num() {
		return doc_num;
	}
	public static void setDoc_num(int doc_num) {
		InfoVO.doc_num = doc_num;
	}
	public static String getDate() {
		return date;
	}
	public static void setDate(String date) {
		InfoVO.date = date;
	}
	public static String getTime() {
		return time;
	}
	public static void setTime(String time) {
		InfoVO.time = time;
	}

	public static int getFindIndex() {
		return findIndex;
	}

	public static void setFindIndex(int findIndex) {
		InfoVO.findIndex = findIndex;
	}
	
	
	
}
