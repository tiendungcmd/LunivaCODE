/**
 * Coppyright (C) 2020 Luvina
 * Bai 2 25/10/2020 BuiTienDung
 */
package Manageruser.entities;

import java.sql.Date;
import java.util.List;

/**
 * @author 440TranCung
 *
 */
public class UserInforEntities {
	private int user_id;
	private String full_name;
	private Date birthday;
	private String email;
	private String tel;
	private String group_name;
	private String name_level;
	private Date end_date;
	private int total;
	public int getUser_id;
	public String login_name;
	public String full_name_kana;
	public String pass;
	public Date start_date;
	public List<Integer> listDMY;
	public List<Integer>listBirth;
	public List<Integer>listEndDate;
	public List<Integer> listStartdate;
	
	
	@Override
	public String toString() {
		return "UserInforEntities [user_id=" + user_id + ", full_name=" + full_name + ", birthday=" + birthday
				+ ", email=" + email + ", tel=" + tel + ", group_name=" + group_name + ", name_level=" + name_level
				+ ", end_date=" + end_date + ", total=" + total + ", getUser_id=" + getUser_id + ", login_name="
				+ login_name + ", full_name_kana=" + full_name_kana + ", pass=" + pass + ", start_date=" + start_date
				+ ", listDMY=" + listDMY + ", listBirth=" + listBirth + ", listEndDate=" + listEndDate
				+ ", listStartdate=" + listStartdate + "]";
	}




	public UserInforEntities(int user_id, String full_name, Date birthday, String email, String tel, String group_name,
			String name_level, Date end_date, int total, int getUser_id, String login_name, String full_name_kana,
			String pass, Date start_date, List<Integer> listDMY, List<Integer> listBirth, List<Integer> listEndDate,
			List<Integer> listStartdate) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.birthday = birthday;
		this.email = email;
		this.tel = tel;
		this.group_name = group_name;
		this.name_level = name_level;
		this.end_date = end_date;
		this.total = total;
		this.getUser_id = getUser_id;
		this.login_name = login_name;
		this.full_name_kana = full_name_kana;
		this.pass = pass;
		this.start_date = start_date;
		this.listDMY = listDMY;
		this.listBirth = listBirth;
		this.listEndDate = listEndDate;
		this.listStartdate = listStartdate;
	}




	public List<Integer> getListBirth() {
		return listBirth;
	}




	public void setListBirth(List<Integer> listBirth) {
		this.listBirth = listBirth;
	}




	public List<Integer> getListEndDate() {
		return listEndDate;
	}




	public void setListEndDate(List<Integer> listEndDate) {
		this.listEndDate = listEndDate;
	}




	public List<Integer> getListStartdate() {
		return listStartdate;
	}




	public void setListStartdate(List<Integer> listStartdate) {
		this.listStartdate = listStartdate;
	}




	public UserInforEntities() {

	}




	public List<Integer> getListDMY() {
		return listDMY;
	}



	public void setListDMY(List<Integer> listDMY) {
		this.listDMY = listDMY;
	}



	/**
	 * 
	 * @param user_id
	 * @param full_name
	 * @param birthday
	 * @param email
	 * @param tel
	 * @param group_name
	 * @param name_level
	 * @param end_date
	 * @param total
	 * @param getUser_id
	 * @param login_name
	 * @param full_name_kana
	 * @param pass
	 * @param start_date
	 */



	public int getUser_id() {
		return user_id;
	}



	public UserInforEntities(int user_id, String full_name, Date birthday, String email, String tel, String group_name,
			String name_level, Date end_date, int total, int getUser_id, String login_name, String full_name_kana,
			String pass, Date start_date, List<Integer> listDMY) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.birthday = birthday;
		this.email = email;
		this.tel = tel;
		this.group_name = group_name;
		this.name_level = name_level;
		this.end_date = end_date;
		this.total = total;
		this.getUser_id = getUser_id;
		this.login_name = login_name;
		this.full_name_kana = full_name_kana;
		this.pass = pass;
		this.start_date = start_date;
		this.listDMY = listDMY;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getFull_name() {
		return full_name;
	}



	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getGroup_name() {
		return group_name;
	}



	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}



	public String getName_level() {
		return name_level;
	}



	public void setName_level(String name_level) {
		this.name_level = name_level;
	}



	public Date getEnd_date() {
		return end_date;
	}



	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getGetUser_id() {
		return getUser_id;
	}



	public void setGetUser_id(int getUser_id) {
		this.getUser_id = getUser_id;
	}



	public String getLogin_name() {
		return login_name;
	}



	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}



	public String getFull_name_kana() {
		return full_name_kana;
	}



	public void setFull_name_kana(String full_name_kana) {
		this.full_name_kana = full_name_kana;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public Date getStart_date() {
		return start_date;
	}



	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	
}
