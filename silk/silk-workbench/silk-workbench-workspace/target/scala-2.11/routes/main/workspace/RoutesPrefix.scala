// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mulang/Desktop/Learning/FhG/knowledge-extraction/silk/silk-workbench/silk-workbench-workspace/conf/workspace.routes
// @DATE:Sun Dec 15 09:27:21 CET 2019


package workspace {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
