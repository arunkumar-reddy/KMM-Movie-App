import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import react.*
import screens.CounterScreen

external interface ScreenProps: RProps {
    var viewModelFlow: StateFlow<ViewModel>
    var actionDispatcher: ActionDispatcher
}

class ScreenState(val viewModel: ViewModel): RState

val Screen = functionalComponent<ScreenProps> { props ->
    val (state, setState) = useState(ScreenState(props.viewModelFlow.value))
    useEffect(listOf(props.viewModelFlow)) {
        CoroutineScope(Dispatchers.Main).launch {
            props.viewModelFlow.collect { viewModel ->
                setState(ScreenState(viewModel))
            }
        }
    }
    when (state.viewModel) {
        is CounterViewModel -> {
            child(CounterScreen) {
                attrs {
                    counterViewModel = state.viewModel
                    actionDispatcher = props.actionDispatcher
                }
            }
        }
        else -> {}
    }
}
