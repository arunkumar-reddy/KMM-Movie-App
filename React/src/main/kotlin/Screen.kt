import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import react.*
import screens.CounterScreen

external interface ScreenProps: RProps {
    var viewModel: ViewModel
    var actionDispatcher: ActionDispatcher
}

val Screen = functionalComponent<ScreenProps> { props ->
    when (props.viewModel) {
        is CounterViewModel -> {
            child(CounterScreen) {
                attrs {
                    counterViewModel = props.viewModel as CounterViewModel
                    actionDispatcher = props.actionDispatcher
                }
            }
        }
        else -> {}
    }
}
