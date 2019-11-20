import React from 'react';
import PropTypes from 'prop-types';
import {Card, CardTitle, CardContent, Table, TableHead, TableBody, TableRow, TableCell} from '@eccenca/gui-elements';
import silkStore from "../api/silkStore";
import MappingsTree from '../HierarchicalMapping/Components/MappingsTree';
import hierarchicalMappingChannel from "../HierarchicalMapping/store";

/**
 * Displays a task execution report.
 */
export default class ExecutionReport extends React.Component {

  constructor(props) {
    super(props);
    this.displayName = 'ExecutionReport';
    this.state = {
      currentRuleId: null
    };
    // MappingsTree uses the message bus, so we need to set required Silk properties
    // This is in the constructor to make sure it's called before any usage of the bus
    // FIXME We should get rid of this global state object altogether and use react props/state instead
    hierarchicalMappingChannel.subject('setSilkDetails').onNext({
      baseUrl: this.props.baseUrl,
      project: this.props.project,
      transformTask: this.props.task
    });
  }

  componentDidMount() {
    hierarchicalMappingChannel.subject('ruleId.change').subscribe(({newRuleId, parent})=> {
      this.setState({ currentRuleId: newRuleId });
    });
  }

  render() {
    return <div>
      { this.renderSummary() }
      { 'ruleResults' in this.props.executionReport && this.renderTransformReport() }
    </div>
  }

  renderSummary() {
    const summaryRows = this.props.executionReport.summary.map(v =>
        <tr key={v.key}>
          <td className="silk-report-table-bold">{v.key}</td>
          <td>{v.value}</td>
        </tr>
    );
    return <Card className="silk-report-card">
             <CardTitle>
               Execution Report
             </CardTitle>
             <CardContent>
               <table className="silk-report-table">
                 <thead>
                 </thead>
                 <tbody>
                 { summaryRows }
                 </tbody>
               </table>
             </CardContent>
           </Card>
  }

  renderTransformReport() {
    return <div className="mdl-grid mdl-grid--no-spacing">
             <div className="mdl-cell mdl-cell--3-col">
               <MappingsTree baseUrl={this.props.baseUrl}
                             project={this.props.project}
                             task={this.props.task}
                             currentRuleId="root"
                             showValueMappings={true}
                             ruleValidation={this.generateIcons()} />
             </div>
             <div className="mdl-cell mdl-cell--9-col">
               { this.renderRuleReport() }
             </div>
           </div>
  }

  generateIcons() {
    let ruleIcons = {};
    for(let [ruleId, ruleResults] of Object.entries(this.props.executionReport.ruleResults)) {
      if(ruleResults.errorCount === 0) {
        ruleIcons[ruleId] = "ok"
      } else {
        ruleIcons[ruleId] = "warning"
      }
    }
    return ruleIcons
  }

  renderRuleReport() {
    const ruleResults = this.props.executionReport.ruleResults[this.state.currentRuleId];
    let title;
    if(ruleResults === undefined) {
      title = "Select a mapping for detailed results."
    } else if(ruleResults.errorCount === 0) {
      title = "This mapping executed successfully without any issues."
    } else {
      title = "This mapping generated  " + ruleResults.errorCount + " validation issues during execution."
    }
    return <div className="ecc-silk-mapping__treenav">
             <Card className="mdl-card mdl-shadow--2dp mdl-card--stretch">
               <div className="mdl-card__supporting-text">
                 { title }
               </div>
               { ruleResults !== undefined && ruleResults.errorCount > 0 && this.renderRuleErrors(ruleResults) }
             </Card>
           </div>
  }

  renderRuleErrors(ruleResults) {
    return  <Table className="di-execution-report-table" style={{width: "100%"}}>
              <TableHead>
                <TableRow>
                  <TableCell isHead={true}>Entity</TableCell>
                  <TableCell isHead={true}>Values</TableCell>
                  <TableCell isHead={true}>Issue</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
              { ruleResults.sampleErrors.map(this.renderRuleError) }
              </TableBody>
            </Table>
  }

  renderRuleError(ruleError) {
    return <TableRow key={ruleError.entity}>
             <TableCell>{ruleError.entity}</TableCell>
             <TableCell>{ruleError.values.flat().join(', ')}</TableCell>
             <TableCell>{ruleError.error}</TableCell>
           </TableRow>
  }
}

ExecutionReport.propTypes = {
  baseUrl: PropTypes.string.isRequired, // Base URL of the DI service
  project: PropTypes.string.isRequired, // project ID
  task: PropTypes.string.isRequired, // task ID
  executionReport: PropTypes.object // The transform execution report to render
};
