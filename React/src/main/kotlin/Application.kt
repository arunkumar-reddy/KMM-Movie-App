import com.arun.moviedb.sdk.AppState
import com.arun.moviedb.sdk.Application
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import react.*
import react.dom.div

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
    useEffect(listOf(state.appState)) {
        CoroutineScope(Dispatchers.Main).launch {
            props.application.appState.collect { appState ->
                console.log("Updating App State for screen: " + appState.screenType + " with: " + (appState.screenViewModel?.value as CounterViewModel).counter)
                setState(WebAppState(appState))
            }
        }
    }
    div {
        state.appState?.screenViewModel?.let { viewModel ->
            child(Screen) {
                attrs {
                    viewModelFlow = viewModel
                    actionDispatcher = props.application
                }
            }
        }
    }
}
