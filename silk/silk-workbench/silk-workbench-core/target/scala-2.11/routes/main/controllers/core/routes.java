// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/conf/core.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019

package controllers.core;

import core.RoutesPrefix;

public class routes {
  
  public static final controllers.core.ReverseAssets Assets = new controllers.core.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.core.ReverseBranding Branding = new controllers.core.ReverseBranding(RoutesPrefix.byNamePrefix());
  public static final controllers.core.ReverseConfigController ConfigController = new controllers.core.ReverseConfigController(RoutesPrefix.byNamePrefix());
  public static final controllers.core.ReverseStart Start = new controllers.core.ReverseStart(RoutesPrefix.byNamePrefix());
  public static final controllers.core.ReversePluginApi PluginApi = new controllers.core.ReversePluginApi(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.core.javascript.ReverseAssets Assets = new controllers.core.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.core.javascript.ReverseBranding Branding = new controllers.core.javascript.ReverseBranding(RoutesPrefix.byNamePrefix());
    public static final controllers.core.javascript.ReverseConfigController ConfigController = new controllers.core.javascript.ReverseConfigController(RoutesPrefix.byNamePrefix());
    public static final controllers.core.javascript.ReverseStart Start = new controllers.core.javascript.ReverseStart(RoutesPrefix.byNamePrefix());
    public static final controllers.core.javascript.ReversePluginApi PluginApi = new controllers.core.javascript.ReversePluginApi(RoutesPrefix.byNamePrefix());
  }

}
