/**
 * Coppyright (C)  2020 Luvina
 * MstJapanLogicsImpl.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.logics.impl;

import java.util.ArrayList;
import java.util.List;

import Manageruser.dao.MstJapanDAO;
import Manageruser.dao.impl.MstJapanDaoImpl;
import Manageruser.entities.MstGroupEntities;
import Manageruser.entities.MstJapanEntities;
import Manageruser.logics.MstGroupLogics;
import Manageruser.logics.MstJapanLogics;


/**
 * @author Bui Tien Dung
 *
 */
public class MstJapanLogicsImpl implements MstJapanLogics{

	

	@Override
	public List<MstJapanEntities> getAllMstJapan() {
		List<MstJapanEntities> mstJapan = null;
		MstJapanDAO mst = new MstJapanDaoImpl();
		mstJapan=mst.getAllMstJapan();
		return mstJapan;
	}
	

}
