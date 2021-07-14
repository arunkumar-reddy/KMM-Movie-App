package components.discover

import com.arun.moviedb.sdk.models.discover.DiscoverResult
import kotlinx.css.*
import react.RProps
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledP

external interface DiscoverWidgetProps: RProps {
    var title: String
    var data: List<DiscoverResult>
}

val DiscoverWidget = functionalComponent<DiscoverWidgetProps> { props ->
    styledDiv {
        styledP {
            css {
                fontSize = 40.px
                fontWeight = FontWeight.bold
            }
            +props.title
        }
        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.row
                overflow = Overflow.scroll
                height = 20.vh
            }
            props.data.forEach { result ->
                styledDiv {
                    css {
                        width = 50.vw
                        marginLeft = 20.px
                    }
                    styledP {
                        css {
                            fontSize = 30.px
                        }
                        +(result.title ?: result.name ?: "")
                    }
                }
            }
        }
    }
}

