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
            backgroundColor = Color(props.appBarState.appBarColor)
            display = Display.flex
        }
        styledP {
            css {
                paddingLeft = 20.px
                color = Color(props.appBarState.appBarTextColor)
                fontSize = 50.px
                alignItems = Align.center
            }
            +props.appBarState.title
        }
    }
}
