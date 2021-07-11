package screens.home

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import react.*
import react.dom.*

external interface HomeScreenProps: RProps {
    var homeScreenViewModel: HomeScreenViewModel
    var dispatcher: ActionDispatcher
}

val HomeScreen = functionalComponent<HomeScreenProps> { props ->
    if (!props.homeScreenViewModel.hasDataLoaded) {
        div {
            +"Loading Home screen data"
        }
        props.dispatcher.dispatch(Action(ActionTypes.LOAD_HOME_SCREEN))
    } else {
        div {
            +"Data has loaded with: ${props.homeScreenViewModel.popularMovies?.size}"
        }
    }
}
