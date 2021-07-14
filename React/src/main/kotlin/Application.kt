import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.Application
import components.appbar.AppBar
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.*
import react.dom.div
import styled.css
import styled.styledDiv

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            child(WebApp) {
                attrs {
                    application = Application()
                }
            }
        }
    }
}

external interface WebAppProps: RProps {
    var application: Application
}

class WebAppState(val appState: AppState?): RState

val WebApp = functionalComponent<WebAppProps> { props ->
    val (state, setState) = useState(WebAppState(null))
    useEffect(listOf()) {
        CoroutineScope(Dispatchers.Main).launch {
            props.application.appState.collect { appState ->
                setState(WebAppState(appState))
            }
        }
    }
    div {
        state.appState?.appBarState?.let {
            styledDiv {
                css {
                    width = 100.vw
                    height = 8.vh
                    overflow = Overflow.hidden
                }
                child(AppBar) {
                    attrs {
                        appBarState = it
                    }
                }
            }
        }
        state.appState?.screenViewModel?.let { screenViewModel ->
            styledDiv {
                css {
                    width = 100.vw
                    height = 80.vh
                }
                child(Screen) {
                    attrs {
                        viewModel = screenViewModel
                        actionDispatcher = props.application
                    }
                }
            }
        }
    }
}
