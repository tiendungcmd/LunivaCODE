/**
 * Coppyright (C)  2020 Luvina
 * MstGroupLogicsImpl.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.logics.impl;

import java.util.List;

import Manageruser.dao.impl.MstGroupDaoImpl;
import Manageruser.entities.MstGroupEntities;
import Manageruser.logics.MstGroupLogics;

/**
 * @author Bùi Tiến Dũng
 *
 */
public class MstGroupLogicsImpl implements MstGroupLogics {

	@Override
	/**
	 * Lay danh sách các Group
	 */
	public List<MstGroupEntities> getAllMstGroup() {
		List<MstGroupEntities> str=null;
		MstGroupDaoImpl ms = new MstGroupDaoImpl();
		str=ms.getAllMstGroup();
		return str;
	}

}
