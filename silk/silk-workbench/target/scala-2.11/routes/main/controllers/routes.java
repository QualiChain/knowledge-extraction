// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/conf/routes
// @DATE:Sun Dec 15 09:38:57 CET 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseWorkbench Workbench = new controllers.ReverseWorkbench(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseWorkbench Workbench = new controllers.javascript.ReverseWorkbench(RoutesPrefix.byNamePrefix());
  }

}
