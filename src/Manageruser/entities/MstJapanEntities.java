/**
 * Coppyright (C)  2020 Luvina
 * MstJapanEntities.java, Nov 17, 2020, BuiTienDung
 */
package Manageruser.entities;

/**
 * @author Bui Tien Dung
 *
 */
public class MstJapanEntities {
 private String code_level;
 private String name_level;
 
public MstJapanEntities(){
	
}
public MstJapanEntities(String code_level, String name_level) {
	super();
	this.code_level = code_level;
	this.name_level = name_level;
}
public String getCode_level() {
	return code_level;
}
public void setCode_level(String code_level) {
	this.code_level = code_level;
}
public String getName_level() {
	return name_level;
}
public void setName_level(String name_level) {
	this.name_level = name_level;
}
@Override
public String toString() {
	return "MstJapanEntities [code_level=" + code_level + ", name_level=" + name_level + "]";
}
 
}
