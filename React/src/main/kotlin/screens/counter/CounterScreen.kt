package screens.counter

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationAction
import com.arun.moviedb.sdk.dispatcher.actions.navigation.NavigationType
import com.arun.moviedb.sdk.viewmodels.counter.CounterViewModel
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import styled.css
import styled.styledButton
import styled.styledDiv

external interface CounterScreenProps: RProps {
    var counterViewModel: CounterViewModel
    var dispatcher: ActionDispatcher
}

val CounterScreen = functionalComponent<CounterScreenProps> { props ->
    styledDiv {
        css {
            fontSize = 30.px
            margin(20.px)
        }
        +"The Current Count is: ${props.counterViewModel.counter}"
    }
    styledDiv {
        css {
            marginTop = 10.px
        }
        styledButton  {
            css {
                width = 20.vw
                height = 5.vh
                fontSize = 30.px
            }
            attrs {
                onClickFunction = {
                    props.dispatcher.dispatch(Action(ActionTypes.INCREMENT_COUNTER))
                }
                +"Increment Counter"
            }
        }
        styledButton {
            css {
                width = 20.vw
                height = 5.vh
                fontSize = 30.px
                marginLeft = 20.px
            }
            attrs {
                onClickFunction = {
                    props.dispatcher.dispatch(Action(ActionTypes.DECREMENT_COUNTER))
                }
                +"Decrement Counter"
            }
        }
        styledButton {
            css {
                width = 20.vw
                height = 5.vh
                fontSize = 30.px
                marginTop = 20.px
                marginLeft = 20.px
            }
            attrs {
                onClickFunction = {
                    props.dispatcher.dispatch(NavigationAction(NavigationType.FORWARD, "/home"))
                }
                +"Submit"
            }
        }
    }
}
