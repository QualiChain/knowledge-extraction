
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

package controllers.de.fuhsen.engine;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.de.fuhsen.engine.ReverseQMinerController QMinerController = new controllers.de.fuhsen.engine.ReverseQMinerController(RoutesPrefix.byNamePrefix());
  public static final controllers.de.fuhsen.engine.ReverseLinkingController LinkingController = new controllers.de.fuhsen.engine.ReverseLinkingController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.de.fuhsen.engine.javascript.ReverseQMinerController QMinerController = new controllers.de.fuhsen.engine.javascript.ReverseQMinerController(RoutesPrefix.byNamePrefix());
    public static final controllers.de.fuhsen.engine.javascript.ReverseLinkingController LinkingController = new controllers.de.fuhsen.engine.javascript.ReverseLinkingController(RoutesPrefix.byNamePrefix());
  }

}
