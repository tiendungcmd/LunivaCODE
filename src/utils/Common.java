/**
 * Coppyright (C)  2020 Luvina
 * Common.java, Nov 17, 2020, BuiTienDung
 */
package utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import Manageruser.properties.MessageErrorProperties;

/**
 * @author Bùi Tiến Dũng
 *
 */
public class Common {
	/**
	 * hàm mã hóa password
	 * 
	 * @param pw
	 *            mat khẩu
	 * @param salt
	 *            salt
	 * @return Chuoi đã mã hóa
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String EncodeCreatePassword(String pw, String salt)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String saltIp = pw + salt;
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(saltIp.getBytes("UTF-8"));
		return new BigInteger(1, crypt.digest()).toString(16);
	}

	// kiểm tra mã hoa
	/**
	 * So sáng pass do người dùng nhập vào sau khi được mã hóa với pass lấy ra
	 * được trong DB
	 * 
	 * @param pass
	 *            pass do người dùng nhập vào sau khi được mã hóa
	 * @param passDB
	 *            pass lấy ra được trong DB
	 * @return nếu giống nhau trả về true, nếu khác nhau trả về false
	 */
	public boolean compare(String pass, String passDB) {
		// Nếu 1 trong 2 pass bị null
		if (pass == null || passDB == null) {
			//
			return false;
		}
		return pass.equals(passDB);
	}

	/**
	 * Kiểm tra xem session đã tồn tại chưa
	 * 
	 * @param ss
	 *            tên session
	 * @return
	 */
	// kiem tra login session
	public static boolean checkLogin(HttpSession ss) {
		boolean check = true;
		if ("".equals(ss.getAttribute("loginName")))
			check = false;
		return check;
	}

	/**
	 * Tao chuoi paging
	 * 
	 * @param totalUser
	 * @param limit
	 * @param currentPage
	 * @return
	 */
	public static List<Integer> getListPaging(int totalUser, int limit, int currentPage) {
		// tao danh sach chua các page sẽ hiển thị
		List<Integer> lst = new ArrayList<>();
		// tinh tong so page
		int totalPage = getTotalPage(totalUser, limit);
		// neu tong so page lon hon gia tri hien tai
		int begin = 1;
		if (totalPage >= currentPage) {

			// neu page hien tai chia het cho 3 -> chi so bat dau cua lstpaging
			if (currentPage % 3 == 0) {
				begin = currentPage - 2;
			} else {
				// neu page hien tai khong chia het cho 3
				begin = (currentPage / 3) * 3 + 1;
			}
			// duyet vong for de vuu vao mang
			// danh sách chưa các page hiển thị là 3 page tính từ page vừa tính
			// được

		}
		for (int i = 1; i <= 3 && begin <= totalPage; i++) {

			lst.add(begin++);
		}
		// lst.add(i);
		return lst;
	}

	/**
	 * lay vi tri data can lay
	 * 
	 * @param currentPage
	 * @param limit
	 * @return vi tri data can lay
	 */
	public static int getOffset(int currentPage, int limit) {
		return currentPage * limit - limit + 1;
	}

	/**
	 * lay so luong hien thi ban ghi tren 1 trang
	 * 
	 * @return
	 */
	public static int getLimit() {
		MessageErrorProperties me = new MessageErrorProperties();
		return Integer.parseInt(me.getValueByKey("RECORD"));
	}

	/**
	 * tinh tong so trang
	 * 
	 * @return
	 */
	public static int getTotalPage(int totalUser, int limit) {
		int totalPage = totalUser / limit;
		int totalPage1 = totalUser % limit;
		if (totalPage1 != 0) {
			return totalPage + 1;
		}
		return totalPage;
	}

	/**
	 * thay the các kí tự đặc biệt
	 * 
	 * @param fullName
	 * @return
	 */
	public static String replaceWildcard(String fullName) {
		fullName.replace("\\", "\\\\");
		fullName.replace("%", "\\%");
		fullName.replace("_", "\\_");
		return fullName;
	}

	/**
	 * Lay nam hien tai
	 * 
	 * @return nam hien tai
	 */
	public static int getYearNow() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);

	}

	/**
	 * Lay thang hien tai
	 * 
	 * @return thang hien tai
	 */
	public static int getMonthNow() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Lay ngay hien tai
	 * 
	 * @return ngay hien tai
	 */
	public static int getDayNow() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}

	/**
	 * cho ngay thagn nam vao 1 danh sach
	 * 
	 * @return list ngay thang nam
	 */
	public static List<Integer> getListDMY() {
		List<Integer> lstDMY = new ArrayList<>();
		lstDMY.add(Common.getYearNow());
		lstDMY.add(Common.getMonthNow());
		lstDMY.add(Common.getDayNow());
		return lstDMY;
	}

	/**
	 * Lay danh sach cac năm từ 1900 - năm hiện tại
	 * 
	 * @param yearFrom
	 *            năm 1900
	 * @param yearTo
	 *            năm hiện tại
	 * @return danh sách các năm
	 */
	public static List<Integer> getListYear(int yearFrom, int yearTo) {
		List<Integer> lstYear = new ArrayList<>();

		for (int i = yearFrom; i <= yearTo; i++) {
			lstYear.add(i);
		}
		return lstYear;

	}

	/**
	 * Lấy danh sách tháng
	 * 
	 * @return danh sách tháng
	 */
	public static List<Integer> getListMonth() {
		List<Integer> lstMonth = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			lstMonth.add(i);
		}
		return lstMonth;
	}

	/**
	 * lay danh sách ngày
	 * 
	 * @return danh sách ngày
	 */
	public static List<Integer> getListDay() {
		List<Integer> lstDay = new ArrayList<>();
		for (int i = 1; i <= 31; i++) {
			lstDay.add(i);
		}
		return lstDay;
	}
	/**
	 * Kiem tra checkMaxlength
	 * @param string chuoi can kiem tra
	 * @param max khoag max cua ki tu
	 * @return nếu vượt quá max kí tự trả về false, ngược lại trả về true
	 */
	public boolean checkMaxlength(String string,int max){
		boolean check =true;
		if(string.length()>max){
			check=false;
		}
		return check;
		
	}
//	public boolean checkFomartLogin(String string){
//		
//		return false;
//	}
	/**
	 * Kiểm tra độ dài trong khoảng cho trước
	 * @param string chuỗi cần kiểm tra
	 * @param a độ dài từ a
	 * @param b độ dài đến b
 	 * @return nếu vượt chuỗi truyền vào ở ngoài độ dài cần kiểm tra thì trả về false,ngược lại trả về true 
	 */
	public boolean checkLength(String string ,int a,int b){
		boolean check =true;
		if(string.length()< a && string.length()>b){
			check = false;
		}
		return check;
	}
}