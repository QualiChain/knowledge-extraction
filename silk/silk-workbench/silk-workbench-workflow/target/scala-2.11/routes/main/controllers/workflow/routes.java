// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-workflow/conf/workflow.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019

package controllers.workflow;

import workflow.RoutesPrefix;

public class routes {
  
  public static final controllers.workflow.ReverseWorkflowApi WorkflowApi = new controllers.workflow.ReverseWorkflowApi(RoutesPrefix.byNamePrefix());
  public static final controllers.workflow.ReverseWorkflowEditorController WorkflowEditorController = new controllers.workflow.ReverseWorkflowEditorController(RoutesPrefix.byNamePrefix());
  public static final controllers.workflow.ReverseAssets Assets = new controllers.workflow.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.workflow.ReverseDialogs Dialogs = new controllers.workflow.ReverseDialogs(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.workflow.javascript.ReverseWorkflowApi WorkflowApi = new controllers.workflow.javascript.ReverseWorkflowApi(RoutesPrefix.byNamePrefix());
    public static final controllers.workflow.javascript.ReverseWorkflowEditorController WorkflowEditorController = new controllers.workflow.javascript.ReverseWorkflowEditorController(RoutesPrefix.byNamePrefix());
    public static final controllers.workflow.javascript.ReverseAssets Assets = new controllers.workflow.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.workflow.javascript.ReverseDialogs Dialogs = new controllers.workflow.javascript.ReverseDialogs(RoutesPrefix.byNamePrefix());
  }

}
