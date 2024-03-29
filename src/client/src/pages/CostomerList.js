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
import DialogDelete from "../components/DialogDelete";

// Redux
import PropTypes from "prop-types";
import { bindActionCreators } from "redux";
import { connect } from "react-redux";

// Material UI
import Button from "@material-ui/core/Button";
// import Table from "@material-ui/core/Table";
// import TableBody from "@material-ui/core/TableBody";
// import TableCell from "@material-ui/core/TableCell";
// import TableHead from "@material-ui/core/TableHead";
// import TableRow from "@material-ui/core/TableRow";

// Table
import EnhancedTable from "../components/EnhancedTable";

// Custom Actions


// START IMPORT ACTIONS
import CostomerActions from "../redux/actions/CostomerActions";

// END IMPORT ACTIONS

/** APIs

* actionsCostomer.delete
*	@description CRUD ACTION delete
*	@param ObjectId id - Id costomer
*
* actionsCostomer.list
*	@description CRUD ACTION list
*	@returns ARRAY OF costomer
*

**/


class CostomerList extends Component {
  // Init component
  constructor(props) {
    super(props);
    this.state = {
      openDialogDelete: false
    };
  }

  // Load data on start
  componentWillMount() {
    this.props.actionsCostomer.loadCostomerList();
  }

  // Delete data
  delete(id) {
    this.setState({ openDialogDelete: true, idDelete: id });
  }

  closeDialogDelete() {
    this.setState({ openDialogDelete: false, idDelete: null });
  }

  confirmDialogDelete(id) {
    this.props.actionsCostomer.deleteCostomer(this.state.idDelete).then(data => {
      this.props.actionsCostomer.loadCostomerList();
      this.setState({ openDialogDelete: false, idDelete: null });
    });
  }

  // Show content
  render() {
    const columns = [ 
      {
        id: "age",
        type: "number",
        label: "Age"
      }, 
      {
        id: "card",
        type: "number",
        label: "Card"
      }, 
      {
        id: "coderoom",
        type: "integer",
        label: "Coderoom"
      }, 
      {
        id: "gender",
        type: "string",
        label: "Gender"
      }, 
      {
        id: "namcostomer",
        type: "string",
        label: "Namcostomer"
      }, 
      {
        id: "nationality",
        type: "string",
        label: "Nationality"
      }, 
      {
        id: "phonenumber",
        type: "number",
        label: "Phonenumber"
      },
    ];
    const link = "/costomers/";

    return (
      <div>
        <h1>Costomer List</h1>

        <EnhancedTable
          data={this.props.list}
          columns={columns}
          link={link}
          onDelete={this.delete.bind(this)}
        />

        <DialogDelete
          open={this.state.openDialogDelete}
          onClose={this.closeDialogDelete.bind(this)}
          onConfirm={this.confirmDialogDelete.bind(this)}
        />

        {/*
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell align="right">Age</TableCell>
              <TableCell align="right">Card</TableCell>
              <TableCell align="right">Coderoom</TableCell>
              <TableCell align="right">Gender</TableCell>
              <TableCell align="right">Namcostomer</TableCell>
              <TableCell align="right">Nationality</TableCell>
              <TableCell align="right">Phonenumber</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {this.props.list.map(row => (
              <TableRow key={row._id}>
                <TableCell component="th" scope="row">
                  <Link to={"/costomers/" + row._id} key={row._id}>
                    {row._id}
                  </Link>
                </TableCell>
                <TableCell align="right">{ row.age }</TableCell>
                <TableCell align="right">{ row.card }</TableCell>
                <TableCell align="right">{ row.coderoom }</TableCell>
                <TableCell align="right">{ row.gender }</TableCell>
                <TableCell align="right">{ row.namcostomer }</TableCell>
                <TableCell align="right">{ row.nationality }</TableCell>
                <TableCell align="right">{ row.phonenumber }</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
        */}

        <div className="footer-card">
          <Link to="/costomers/new">
            <Button variant="contained" color="primary">
              Add
            </Button>
          </Link>
        </div>
      </div>
    );
  }
}

// Store actions
const mapDispatchToProps = function(dispatch) {
  return { 
    actionsCostomer: bindActionCreators(CostomerActions, dispatch),
  };
};

// Validate types
CostomerList.propTypes = { 
  actionsCostomer: PropTypes.object.isRequired,
};

// Get props from state
function mapStateToProps(state, ownProps) {
  return {
    list: state.CostomerListReducer.listCostomer
  };
}

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CostomerList);
