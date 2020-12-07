/**
 * Coppyright (C)  2020 Luvina
 * MstJapanDaoImpl.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Manageruser.dao.MstJapanDAO;
import Manageruser.entities.MstGroupEntities;
import Manageruser.entities.MstJapanEntities;

/**
 * @author LA-PM
 *
 */
public class MstJapanDaoImpl extends BaseDaoImpl implements MstJapanDAO{

	@Override
	public List<MstJapanEntities> getAllMstJapan() {
		MstJapanEntities mstJapan;
		List<MstJapanEntities> lstJapan = new ArrayList<>();
		
	
		try {
			//tao ket noi
			connection();
			
			//kiem tra neu thanh cong
			if(conn!=null){
				// tao câu truy vấn
				String sql = "select group_id,group_name from mst_group ";
				// Thực hiện câu truy vấn
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
				// Nếu dữ liệu lấy ra 
				while (rs.next()) {
					mstJapan = new MstJapanEntities();
					// Update dữ liệu mới cho group_id
					mstJapan.setCode_level(rs.getString(1));
					// Update dữ liệu mới cho group_name
					mstJapan.setName_level(rs.getString(2));
					lstJapan.add(mstJapan);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		// TODO Auto-generated method stub
		return null;
	}

	

}
