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
// Dependencies
import React, { Component } from "react";
import { Link } from "react-router-dom";
import Utils from "../utils/utils";

// Redux
import PropTypes from "prop-types";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";

// Material UI
import Button from "@material-ui/core/Button";
import { DateTimePicker } from "material-ui-pickers";

// Custom Actions


// START IMPORT ACTIONS
import BillActions from "../redux/actions/BillActions";
import EmployessActions from "../redux/actions/EmployessActions";
import RoomActions from "../redux/actions/RoomActions";

// END IMPORT ACTIONS

/** APIs

* actionsBill.create
*	@description CRUD ACTION create
*	@param bill obj - Object to insert
*
* actionsEmployess.findByemployessid
*	@description CRUD ACTION findByemployessid
*	@param Objectid key - Id della risorsa employessid da cercare
*
* actionsRoom.findByroomid
*	@description CRUD ACTION findByroomid
*	@param Objectid key - Id della risorsa roomid da cercare
*
* actionsBill.get
*	@description CRUD ACTION get
*	@param ObjectId id - Id bill
*	@returns bill
*
* actionsBill.update
*	@description CRUD ACTION update
*	@param ObjectId id - Id bill
*	@returns bill
*

**/

class BillEdit extends Component {
  // Init bill
  constructor(props) {
    super(props);
    this.state = {
      bill: {}
    };
  }

  // Load data on start
  componentDidMount() {
    if (this.props.match.params.id !== "new") {
      this.props.actionsBill.loadBill(this.props.match.params.id);
      this.props.actionsEmployess.findByemployessid(this.props.match.params.id);
      this.props.actionsRoom.findByroomid(this.props.match.params.id);
    }
    
  }

  // Insert props bill in state
  componentWillReceiveProps(props) {
    this.setState(...this.state, {
      bill: props.bill
    });
  }

  // Save data
  save(event) {
    event.preventDefault();
    if (this.state.bill._id) {
      this.props.actionsBill.saveBill(this.state.bill).then(data => {
        this.props.history.push("/bills/");
      });
    } else {
      this.props.actionsBill.createBill(this.state.bill).then(data => {
        this.props.history.push("/bills/");
      });
    }
  }

  // Show content
  render() {
    return (
      <div>
        <h1>Bill Edit</h1>
        <form className="myForm" onSubmit={this.save.bind(this)}>

          <DateTimePicker
            id="date"
            label="Date"
            className="mt-20 mb-20"
            ampm={false}
            value={
              this.state.bill.date
                ? new Date(this.state.bill.date)
                : null
            }
            onChange={Utils.handleChangeDate.bind(this, "bill", "date")}
            fullWidth
            autoOk
            disableFuture
          />
          
          
          <TextField
            id="employessid"
            label="Employessid"
            value={this.state.bill.employessid || ""}
            onChange={Utils.handleChange.bind(this, "bill")}
            type="number"
            type="decimal"
            margin="normal"
            fullWidth
          />
          
          
          <TextField
            id="roomid"
            label="Roomid"
            value={this.state.bill.roomid || ""}
            onChange={Utils.handleChange.bind(this, "bill")}
            type="number"
            type="decimal"
            margin="normal"
            fullWidth
          />
          
          
          <TextField
            id="salarybill"
            label="Salarybill"
            value={this.state.bill.salarybill || ""}
            onChange={Utils.handleChange.bind(this, "bill")}
            margin="normal"
            fullWidth
          />
          
          {/* RELATIONS */}

          {/* EXTERNAL RELATIONS */}
          
          {/* External relation with employess */}
          
          <h3>Employess</h3>
          {(!this.props.listEmployess || this.props.listEmployess.length === 0) && 
            <div>No Employess associated</div>
          }
          {this.props.listEmployess &&
            this.props.listEmployess.map((item, i) => {
              return (
                <Link to={"/employesss/" + item._id} key={item._id}>
                  {item._id}
                </Link>
              );
            })}

          
          {/* External relation with room */}
          
          <h3>Room</h3>
          {(!this.props.listRoom || this.props.listRoom.length === 0) && 
            <div>No Room associated</div>
          }
          {this.props.listRoom &&
            this.props.listRoom.map((item, i) => {
              return (
                <Link to={"/rooms/" + item._id} key={item._id}>
                  {item._id}
                </Link>
              );
            })}

          
          {/* Footer */}
          <div className="footer-card">
            <Link to="/bills/">Back to list</Link>

            <Button type="submit" variant="contained" color="primary">
              Save
            </Button>
          </div>
        </form>
      </div>
    );
  }
}

// Store actions
const mapDispatchToProps = function(dispatch) {
  return { 
    actionsBill: bindActionCreators(BillActions, dispatch),
    actionsEmployess: bindActionCreators(EmployessActions, dispatch),
    actionsRoom: bindActionCreators(RoomActions, dispatch),
  };
};

// Validate types
BillEdit.propTypes = { 
  actionsBill: PropTypes.object.isRequired,
  actionsEmployess: PropTypes.object.isRequired,
  actionsRoom: PropTypes.object.isRequired,
};

// Get props from state
function mapStateToProps(state, ownProps) {
  return {
    bill: state.BillEditReducer.bill,
    listEmployess: state.BillEditReducer.listEmployess,
    listRoom: state.BillEditReducer.listRoom
  };
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(BillEdit);