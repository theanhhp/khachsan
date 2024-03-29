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
 *  TO CUSTOMIZE FUNCTIONS IN ServiseActionsGenerated.js PLEASE EDIT ../ServiseActions.js
 *
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER'S CODE GENERATION --
 *
 */

import * as types from "../../actionTypes";
import ServiseApi from "../../../api/ServiseApi";

let actionsFunction = {

  //CRUD METHODS

  // Create servise
  createServise: function(servise) {
    return function(dispatch) {
      return ServiseApi
        .createServise(servise)
        .then(servise => {
          dispatch(actionsFunction.createServiseSuccess(servise));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  createServiseSuccess: function(servise) {
    return { type: types.CREATE_SERVISE_SUCCESS, payload: servise };
  },


  // Delete servise
  deleteServise: function(id) {
    return function(dispatch) {
      return ServiseApi
        .deleteServise(id)
        .then(servise => {
          dispatch(actionsFunction.deleteServiseSuccess(servise));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  deleteServiseSuccess: function(servise) {
    return { type: types.DELETE_SERVISE_SUCCESS, payload: servise };
  },


  // Find by idservise
  findByidservise: function(key) {
    return function(dispatch) {
      return ServiseApi
        .findByidservise(key)
        .then(item => {
          dispatch(actionsFunction.findByidserviseSuccess(item));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  findByidserviseSuccess: function(item) {
    return { type: types.FINDBYIDSERVISE_SERVISE_SUCCESS, payload: item };
  },


  // Get servise
  loadServise: function(id) {
    return function(dispatch) {
      return ServiseApi
        .getOneServise(id)
        .then(servise => {
          dispatch(actionsFunction.loadServiseSuccess(servise));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  loadServiseSuccess: function(servise) {
    return { type: types.GET_SERVISE_SUCCESS, payload: servise };
  },

  // Load  list
  loadServiseList: function() {
    return function(dispatch) {
      return ServiseApi
        .getServiseList()
        .then(list => {
          dispatch(actionsFunction.loadServiseListSuccess(list));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  loadServiseListSuccess: function(list) {
    return { type: types.LIST_SERVISE_SUCCESS, payload: list };
  },

	
  // Save servise
  saveServise: function(servise) {
    return function(dispatch) {
      return ServiseApi
        .saveServise(servise)
        .then(servise => {
          dispatch(actionsFunction.saveServiseSuccess(servise));
        })
        .catch(error => {
          throw error;
        });
    };
  },

  saveServiseSuccess: function(servise) {
    return { type: types.UPDATE_SERVISE_SUCCESS, payload: servise };
  },


};

export default actionsFunction;
