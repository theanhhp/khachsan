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
package com.khachsan.db.khachsan_db.service.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.khachsan.db.khachsan_db.entity.Costomer;
import com.khachsan.db.khachsan_db.service.CostomerService;

//IMPORT RELATIONS
import com.khachsan.db.khachsan_db.entity.Costomer;

@Service
public class CostomerBaseService {

	private static NamedParameterJdbcTemplate jdbcTemplate;
	
		@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Costomer insert(Costomer obj) {
		Long id = jdbcTemplate.queryForObject("select max(_id) from `costomer`", new MapSqlParameterSource(), Long.class);
		obj.set_id(id == null ? 1 : id + 1);
		String sql = "INSERT INTO `costomer` (`_id`, `age`,`card`,`coderoom`,`gender`,`namcostomer`,`nationality`,`phonenumber`) VALUES (:id,:age,:card,:coderoom,:gender,:namcostomer,:nationality,:phonenumber)";
			SqlParameterSource parameters = new MapSqlParameterSource()
		    .addValue("id", obj.get_id())
			.addValue("age", obj.getAge())
			.addValue("card", obj.getCard())
			.addValue("coderoom", obj.getCoderoom())
			.addValue("gender", obj.getGender())
			.addValue("namcostomer", obj.getNamcostomer())
			.addValue("nationality", obj.getNationality())
			.addValue("phonenumber", obj.getPhonenumber());
		
		jdbcTemplate.update(sql, parameters);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(Long id) {
		String sql = "DELETE FROM `costomer` WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
		
		jdbcTemplate.update(sql, parameters);
	}

    	
    //CRUD - FIND BY Namcostomer
    	
	public List<Costomer> findBynamcostomer(Long idnamcostomer) {
		
		String sql = "select * from `Costomer` WHERE `namcostomer` = :idnamcostomer";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
		.addValue("idnamcostomer", idnamcostomer);
	    
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Costomer.class));
	}
    	
    //CRUD - GET ONE
    	
	public Costomer get(Long id) {
	    
		String sql = "select * from `costomer` where `_id` = :id";
		
	    SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id);
	    
	    return (Costomer) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper(Costomer.class));
	}


    	
        	
    //CRUD - GET LIST
    	
	public List<Costomer> getList() {
	    
		String sql = "select * from `costomer`";
		
	    SqlParameterSource parameters = new MapSqlParameterSource();
	    return jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper(Costomer.class));
	    
	    
	}

    	
    //CRUD - EDIT
    	
	public Costomer update(Costomer obj, Long id) {

		String sql = "UPDATE `costomer` SET `age` = :age,`card` = :card,`coderoom` = :coderoom,`gender` = :gender,`namcostomer` = :namcostomer,`nationality` = :nationality,`phonenumber` = :phonenumber  WHERE `_id`=:id";
		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("id", id)
			.addValue("age", obj.getAge())
			.addValue("card", obj.getCard())
			.addValue("coderoom", obj.getCoderoom())
			.addValue("gender", obj.getGender())
			.addValue("namcostomer", obj.getNamcostomer())
			.addValue("nationality", obj.getNationality())
			.addValue("phonenumber", obj.getPhonenumber());
		jdbcTemplate.update(sql, parameters);
	    return obj;
	}
	
    	
    
    
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in costomerService.java
     */
    

}
