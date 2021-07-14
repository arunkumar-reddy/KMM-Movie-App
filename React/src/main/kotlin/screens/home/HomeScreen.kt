package screens.home

import com.arun.moviedb.sdk.dispatcher.ActionDispatcher
import com.arun.moviedb.sdk.dispatcher.actions.Action
import com.arun.moviedb.sdk.dispatcher.actions.ActionTypes
import com.arun.moviedb.sdk.viewmodels.home.HomeScreenViewModel
import components.discover.DiscoverWidget
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
        props.homeScreenViewModel.popularMovies?.let {
            div {
                child(DiscoverWidget) {
                    attrs {
                        title = "Popular Movies"
                        data = it
                    }
                }
            }
        }
        props.homeScreenViewModel.latestMovies?.let {
            div {
                child(DiscoverWidget) {
                    attrs {
                        title = "Latest Movies"
                        data = it
                    }
                }
            }
        }
        props.homeScreenViewModel.popularTvShows?.let {
            div {
                child(DiscoverWidget) {
                    attrs {
                        title = "Popular Tv Shows"
                        data = it
                    }
                }
            }
        }
        props.homeScreenViewModel.latestTvShows?.let {
            div {
                child(DiscoverWidget) {
                    attrs {
                        title = "Latest Tv Shows"
                        data = it
                    }
                }
            }
        }
        props.homeScreenViewModel.regionalMovies?.let {
            div {
                child(DiscoverWidget) {
                    attrs {
                        title = "Regional Movies"
                        data = it
                    }
                }
            }
        }
    }
}
