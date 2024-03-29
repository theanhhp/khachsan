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
package com.khachsan.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.khachsan.db.khachsan_db.service.ServiseService;
import com.khachsan.db.khachsan_db.entity.Servise;

//IMPORT RELATIONS
import com.khachsan.db.khachsan_db.entity.Room;

public class ServiseBaseController {
    
    @Autowired
	ServiseService serviseService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
		@RequestMapping(value = "/servise", method = RequestMethod.POST, headers = "Accept=application/json")
	public Servise insert(@RequestBody Servise obj) {
		Servise result = serviseService.insert(obj);

	    
		
		return result;
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/servise/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") Long id) {
		serviseService.delete(id);
	}
	

    //CRUD - FIND BY Idservise
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/servise/findByidservise/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Servise> findByidservise(@PathVariable("key") Long ididservise) {
		List<Servise> list = serviseService.findByidservise(ididservise);
		return list;
	}
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/servise/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Servise get(@PathVariable Long id) {
		Servise obj = serviseService.get(id);
		
		
		
		return obj;
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/servise", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Servise> getList() {
		return serviseService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/servise/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Servise update(@RequestBody Servise obj, @PathVariable("id") Long id) {
		Servise result = serviseService.update(obj, id);

	    
		
		return result;
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
