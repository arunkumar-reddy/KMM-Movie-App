import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import com.arun.moviedb.sdk.viewmodels.ViewModel
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import react.*
import screens.counter.CounterScreen
import screens.home.HomeScreen

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
                    dispatcher = props.actionDispatcher
                }
            }
        }
        is HomeScreenViewModel -> {
            child(HomeScreen) {
                attrs {
                    homeScreenViewModel = props.viewModel as HomeScreenViewModel
                    dispatcher = props.actionDispatcher
                }
            }
        }
        else -> {}
    }
}
