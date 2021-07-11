package screens.counter

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

external interface CounterScreenProps: RProps {
    var counterViewModel: CounterViewModel
    var dispatcher: ActionDispatcher
}

val CounterScreen = functionalComponent<CounterScreenProps> { props ->
    div {
        +"The Current Count is: ${props.counterViewModel.counter}"
    }
    button {
        attrs {
            onClickFunction = {
                props.dispatcher.dispatch(Action(ActionTypes.INCREMENT_COUNTER))
            }
            +"Increment Counter"
        }
    }
    button {
        attrs {
            onClickFunction = {
                props.dispatcher.dispatch(Action(ActionTypes.DECREMENT_COUNTER))
            }
            +"Decrement Counter"
        }
    }
    button {
        attrs {
            onClickFunction = {
                props.dispatcher.dispatch(NavigationAction(NavigationType.FORWARD, "/home"))
            }
            +"Submit"
        }
    }
}
