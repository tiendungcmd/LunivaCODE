/**
 * Coppyright (C)  2020 Luvina
 * ValidateUser.java, Nov 17, 2020, BuiTienDung
 */
package validates;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Manageruser.entities.UserInforEntities;
import Manageruser.logics.TblUserLogics;
import Manageruser.logics.impl.TblUserLogicsImpl;
import Manageruser.properties.DatabaseProperties;
import Manageruser.properties.MessageErrorProperties;
import utils.Common;

/**
 * @author Bùi Tiến Dũng
 *
 */
public class ValidateUser {
	/**
	 * Kiểm tra thông tin về tìa khoản đăng nhập vào hệ thống
	 * 
	 * @param username
	 *            dl người dùng nhập
	 * @param password
	 *            dl người dùng nhập
	 * @return trả về danh sách lỗi
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<String> validateLogin(String username, String password) throws SQLException, ClassNotFoundException {

		TblUserLogics tblUerLogics = new TblUserLogicsImpl();
		List<String> lstErr = new ArrayList<String>();

		// kiểm tra nhập username hoặc password có rỗng hay không
		if ("".equals(username)) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_loginName"));
		}
		if ("".equals(password)) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_password"));
		}
		// kiểm tra listErr có trống không và kiểm tra tính đúng đắn của
		// username password
		if (lstErr.isEmpty() && !tblUerLogics.checkExistLoginID(username, password)) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER016"));
		}
		return lstErr;
	}

	/**
	 * Kiểm tra thông tin được nhập từ màn hình ADM003
	 * 
	 * @param user
	 *            đôi tượng cần kiểm tra
	 * @return danh sách lỗi
	 */
	public List<String> validateUserInfor(UserInforEntities user) {
		Common cm = new Common();
		// tao danh sach chua cac loi
		List<String> lstErr = new ArrayList<>();
		// kiểm tra không nhập loginName
		if ("".equals(user.getLogin_name())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_loginName"));
		}
		// kiểm tra không nhập tel
		if ("".equals(user.getTel())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_tel"));
		}
		// Kiểm tra không nhập full name
		if ("".equals(user.getFull_name())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_fullName"));
		}
		// Kiểm tra không nhập email
		if ("".equals(user.getEmail())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_email"));
		}
		// Kiểm tra không nhập pass
		if ("".equals(user.getPass())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_pass"));
		}
		// Kiểm tra không nhập total
		if ("".equals(user.getTotal())) {
			// Thêm câu thông báo lỗi vào danh sách
			lstErr.add(MessageErrorProperties.getValueByKey("ER001_total"));
		}
		// kiểm tra MaxLength fullName
		if (!cm.checkMaxlength(user.getFull_name(), 255)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER006_fullName"));
		}
		// Kiểm tra maxlength fullNameKana
		if (!cm.checkMaxlength(user.getFull_name_kana(), 255)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER006_fullNameKana"));
		}
		// Kiểm tra maxLength Email
		if (!cm.checkMaxlength(user.getEmail(), 255)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER006_email"));
		}
		// Kiểm tra maxLength total
		String total = Integer.toString(user.getTotal());
		if (!cm.checkMaxlength(total, 255)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER006_total"));
		}
		// kiểm tra độ dài của login name trong khoảng cố định
		if (!cm.checkLength(user.getLogin_name(), 4, 15)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER007_loginName"));
		}
		// Kiểm tra độ dài của pass
		if (!cm.checkLength(user.getPass(), 4, 15)) {
			lstErr.add(MessageErrorProperties.getValueByKey("ER007_pass"));
		}
		

		return lstErr;

	}

}
