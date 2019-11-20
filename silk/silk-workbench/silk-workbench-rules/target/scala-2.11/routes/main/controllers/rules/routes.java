// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-rules/conf/rules.routes
// @DATE:Tue Jul 30 22:35:15 CEST 2019

package controllers.rules;

import rules.RoutesPrefix;

public class routes {
  
  public static final controllers.rules.ReverseAssets Assets = new controllers.rules.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.rules.javascript.ReverseAssets Assets = new controllers.rules.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
