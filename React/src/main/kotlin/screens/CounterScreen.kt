package screens

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.viewmodels.CounterViewModel
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

external interface CounterScreenProps: RProps {
    var counterViewModel: CounterViewModel
    var actionDispatcher: ActionDispatcher
}

val CounterScreen = functionalComponent<CounterScreenProps> { props ->
    div {
        +"The Current Count is: ${props.counterViewModel.counter}"
    }
    button {
        attrs {
            onClickFunction = {
                console.log("increment counter clicked")
                props.actionDispatcher.dispatch(Action(ActionTypes.INCREMENT_COUNTER))
            }
            +"Increment Counter"
        }
    }
    button {
        attrs {
            name = "Decrement Counter"
            onClickFunction = {
                props.actionDispatcher.dispatch(Action(ActionTypes.DECREMENT_COUNTER))
            }
            +"Decrement Counter"
        }
    }
}
