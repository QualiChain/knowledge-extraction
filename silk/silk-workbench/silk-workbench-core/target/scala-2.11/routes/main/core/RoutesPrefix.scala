// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/qualichain/silk/silk-workbench/silk-workbench-core/conf/core.routes
// @DATE:Tue Jul 30 22:35:14 CEST 2019


package core {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
