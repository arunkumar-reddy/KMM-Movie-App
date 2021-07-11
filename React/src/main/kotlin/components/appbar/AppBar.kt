package components.appbar

import com.arun.moviedb.sdk.viewmodels.appbar.AppBarState
import kotlinx.css.*
import react.*
import styled.*

external interface AppBarProps: RProps {
    var appBarState: AppBarState
}

val AppBar = functionalComponent<AppBarProps> { props ->
    styledDiv {
        css {
            backgroundColor = Color(props.appBarState.appBarTextColor)
        }
        styledP {
            css {
                padding(10.px)
                color = Color(props.appBarState.appBarTextColor)
                fontSize = 5.em
            }
            +props.appBarState.title
        }
    }
}
