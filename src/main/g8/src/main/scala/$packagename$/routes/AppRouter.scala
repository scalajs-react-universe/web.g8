package sri.web.template.routes

import sri.core.ReactElement
import sri.scalacss.Defaults._
import sri.web.template.components._
import sri.web.template.screens.HomeScreen
import sri.web.template.styles.GlobalStyle
import sri.web.router._
import sri.web.vdom.htmltags._
object AppRouter {

  object HomePage extends WebStaticPage


  object Config extends WebRouterConfig {

    override val history: History = HistoryFactory.browserHistory()

    override val initialRoute: (WebStaticPage, WebRoute) = defineInitialRoute(HomePage, (route: WebRoute) => HomeScreen())


    override val notFound: WebRouteNotFound = WebRouteNotFound(HomePage)

    /**
     * this method is responsible for rendering components ,
     * @param route current route that is pushed to stack
     * @return
     */
    override def renderScene(route: WebRoute): ReactElement = {
      div(className = GlobalStyle.flexOneAndDirectionVertical)(
        TopNav(),
        super.renderScene(route)
      )
    }
  }

  val router = WebRouter(Config)
}
