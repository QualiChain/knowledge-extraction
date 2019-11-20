// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/conf/routes
// @DATE:Tue Jul 30 22:38:02 CEST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseWorkbench Workbench = new controllers.ReverseWorkbench(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseWorkbench Workbench = new controllers.javascript.ReverseWorkbench(RoutesPrefix.byNamePrefix());
  }

}
