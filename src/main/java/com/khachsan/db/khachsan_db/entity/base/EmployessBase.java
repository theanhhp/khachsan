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
 *  FOR CUSTOMIZE EmployessBase PLEASE EDIT ../Employess.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Employess object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;


import org.springframework.jdbc.core.RowMapper;
import com.khachsan.db.khachsan_db.entity.Employess;

public class EmployessBase implements RowMapper<Employess>{
	
	private Long _id;
	
	// Attributes
    private String disc;
    private String gender;
    private String name;
    private String position;
    private BigDecimal salary;
	
	// Relations emid
	private String emid;
	
	// Relations employessid
	private String employessid;
	
	
	
	@Override
	public Employess mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employess obj = new Employess();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setDisc(rs.getString("disc"));
			obj.setGender(rs.getString("gender"));
			obj.setName(rs.getString("name"));
			obj.setPosition(rs.getString("position"));
			obj.setSalary(rs.getDouble("salary"));
			
        	
        	// Relations 1:m emid
			obj.setEmid(rs.getString("emid"));
        	
        	// Relations 1:m employessid
			obj.setEmployessid(rs.getString("employessid"));
        	
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
	
	public String getDisc() {
		return disc;
	}


	public void setDisc(String disc) {
		this.disc = disc;
	}
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
    
    // Relations 1:m emid
	public String getEmid() {
		return emid;
	}

	public void setEmid(String emid) {
		this.emid = emid;
	}
    
    // Relations 1:m employessid
	public String getEmployessid() {
		return employessid;
	}

	public void setEmployessid(String employessid) {
		this.employessid = employessid;
	}
    
    
    
    
}