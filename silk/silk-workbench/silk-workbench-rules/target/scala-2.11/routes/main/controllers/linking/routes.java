// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-rules/conf/linking.routes
// @DATE:Sun Dec 15 09:27:22 CET 2019

package controllers.linking;

import linking.RoutesPrefix;

public class routes {
  
  public static final controllers.linking.ReverseLearning Learning = new controllers.linking.ReverseLearning(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseLinkingDialogs LinkingDialogs = new controllers.linking.ReverseLinkingDialogs(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseReferenceLinksManager ReferenceLinksManager = new controllers.linking.ReverseReferenceLinksManager(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseExecuteLinkingController ExecuteLinkingController = new controllers.linking.ReverseExecuteLinkingController(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseEvaluateLinkingController EvaluateLinkingController = new controllers.linking.ReverseEvaluateLinkingController(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseLinkingTaskApi LinkingTaskApi = new controllers.linking.ReverseLinkingTaskApi(RoutesPrefix.byNamePrefix());
  public static final controllers.linking.ReverseLinkingEditor LinkingEditor = new controllers.linking.ReverseLinkingEditor(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.linking.javascript.ReverseLearning Learning = new controllers.linking.javascript.ReverseLearning(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseLinkingDialogs LinkingDialogs = new controllers.linking.javascript.ReverseLinkingDialogs(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseReferenceLinksManager ReferenceLinksManager = new controllers.linking.javascript.ReverseReferenceLinksManager(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseExecuteLinkingController ExecuteLinkingController = new controllers.linking.javascript.ReverseExecuteLinkingController(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseEvaluateLinkingController EvaluateLinkingController = new controllers.linking.javascript.ReverseEvaluateLinkingController(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseLinkingTaskApi LinkingTaskApi = new controllers.linking.javascript.ReverseLinkingTaskApi(RoutesPrefix.byNamePrefix());
    public static final controllers.linking.javascript.ReverseLinkingEditor LinkingEditor = new controllers.linking.javascript.ReverseLinkingEditor(RoutesPrefix.byNamePrefix());
  }

}
