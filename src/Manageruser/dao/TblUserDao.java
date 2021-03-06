/**
 * Coppyright (C)  2020 Luvina
 * TblUserDao.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import Manageruser.dao.impl.TblUserDaoImpl;
import Manageruser.entities.TblUserEntities;
import Manageruser.entities.UserInforEntities;


/**
 * @author Bùi Tiến Dũng
 *
 */
public interface TblUserDao  {
	public TblUserEntities getUserByUserName(String userName) throws SQLException, ClassNotFoundException;
	public int getTotalUser(int groupID,String fullName );
	public List<UserInforEntities> getListUsers(int ofset,int limit,int groupId,String fullName,String sortType,String sortByFullName,String sortByCodeLevel,String sortByEndDate);
	public boolean getColumn(String column, String table);
	
}
