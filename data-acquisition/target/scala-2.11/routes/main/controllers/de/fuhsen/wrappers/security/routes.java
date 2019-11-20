
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/data-acquisition-service/conf/routes
// @DATE:Sun Aug 04 15:02:29 CEST 2019

package controllers.de.fuhsen.wrappers.security;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.de.fuhsen.wrappers.security.ReverseTokenRetrievalController TokenRetrievalController = new controllers.de.fuhsen.wrappers.security.ReverseTokenRetrievalController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.de.fuhsen.wrappers.security.javascript.ReverseTokenRetrievalController TokenRetrievalController = new controllers.de.fuhsen.wrappers.security.javascript.ReverseTokenRetrievalController(RoutesPrefix.byNamePrefix());
  }

}
