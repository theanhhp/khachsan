/* 
* Generated by
* 
*      _____ _          __  __      _     _
*     / ____| |        / _|/ _|    | |   | |
*    | (___ | | ____ _| |_| |_ ___ | | __| | ___ _ __
*     \___ \| |/ / _` |  _|  _/ _ \| |/ _` |/ _ \ '__|
*     ____) |   < (_| | | | || (_) | | (_| |  __/ |
*    |_____/|_|\_\__,_|_| |_| \___/|_|\__,_|\___|_|
*
* The code generator that works in many programming languages
*
*			https://www.skaffolder.com
*
*
* You can generate the code from the command-line
*       https://npmjs.com/package/skaffolder-cli
*
*       npm install -g skaffodler-cli
*
*   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
*
* To remove this comment please upgrade your plan here: 
*      https://app.skaffolder.com/#!/upgrade
*
* Or get up to 70% discount sharing your unique link:
*       https://app.skaffolder.com/#!/register?friend=5dbfae239ef7a1181f8e04d2
*
* You will get 10% discount for each one of your friends
* 
*/
package com.khachsan.db.khachsan_db.entity.base;

/**
 * 
 * 
  _____                      _              _ _ _     _   _     _        __ _ _      
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |     
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___ 
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|
 
                                                                                   
 * DO NOT EDIT THIS FILE!! 
 *
 *  FOR CUSTOMIZE RoomBase PLEASE EDIT ../Room.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Room object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;


import org.springframework.jdbc.core.RowMapper;
import com.khachsan.db.khachsan_db.entity.Room;

public class RoomBase implements RowMapper<Room>{
	
	private Long _id;
	
	// Attributes
    private Integer emid;
    private Integer idservise;
    private String note;
    private String roomname;
    private String roomstauts;
    private String roomtype;
    private BigDecimal salary;
	
	// Relations coderoom
	private String coderoom;
	
	// Relations roomid
	private String roomid;
	
	
	
	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Room obj = new Room();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setEmid(rs.getInt("emid"));
			obj.setIdservise(rs.getInt("idservise"));
			obj.setNote(rs.getString("note"));
			obj.setRoomname(rs.getString("roomname"));
			obj.setRoomstauts(rs.getString("roomstauts"));
			obj.setRoomtype(rs.getString("roomtype"));
			obj.setSalary(rs.getDouble("salary"));
			
        	
        	// Relations 1:m coderoom
			obj.setCoderoom(rs.getString("coderoom"));
        	
        	// Relations 1:m roomid
			obj.setRoomid(rs.getString("roomid"));
        	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}
	
	public Integer getEmid() {
		return emid;
	}


	public void setEmid(Integer emid) {
		this.emid = emid;
	}
	public Integer getIdservise() {
		return idservise;
	}


	public void setIdservise(Integer idservise) {
		this.idservise = idservise;
	}
	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	public String getRoomname() {
		return roomname;
	}


	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getRoomstauts() {
		return roomstauts;
	}


	public void setRoomstauts(String roomstauts) {
		this.roomstauts = roomstauts;
	}
	public String getRoomtype() {
		return roomtype;
	}


	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
    
    // Relations 1:m coderoom
	public String getCoderoom() {
		return coderoom;
	}

	public void setCoderoom(String coderoom) {
		this.coderoom = coderoom;
	}
    
    // Relations 1:m roomid
	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
    
    
    
    
}