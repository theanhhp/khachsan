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
 *  FOR CUSTOMIZE ServiseBase PLEASE EDIT ../Servise.java
 * 
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER CODE GENERATION --
 * 
 */
 

/**
 * This is the model of Servise object
 * 
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;


import org.springframework.jdbc.core.RowMapper;
import com.khachsan.db.khachsan_db.entity.Servise;

public class ServiseBase implements RowMapper<Servise>{
	
	private Long _id;
	
	// Attributes
    private String nameservise;
    private Double salary;
	
	// Relations idservise
	private String idservise;
	
	
	
	@Override
	public Servise mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Servise obj = new Servise();
		try {
			obj.set_id(rs.getLong("id"));
			obj.setNameservise(rs.getString("nameservise"));
			obj.setSalary(rs.getDouble("salary"));
			
        	
        	// Relations 1:m idservise
			obj.setIdservise(rs.getString("idservise"));
        	
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
	
	public String getNameservise() {
		return nameservise;
	}


	public void setNameservise(String nameservise) {
		this.nameservise = nameservise;
	}
	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
    
    // Relations 1:m idservise
	public String getIdservise() {
		return idservise;
	}

	public void setIdservise(String idservise) {
		this.idservise = idservise;
	}
    
    
    
    
}