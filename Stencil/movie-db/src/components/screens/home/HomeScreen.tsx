import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-home-screen',
    styleUrl: 'HomeScreen.css'
})
export class HomeScreen {
    @Prop() homeScreenViewModel: any;
    @Prop() dispatcher: any;

    componentWillLoad() {
        if (!this.homeScreenViewModel.hasDataLoaded) {
            this.dispatcher.dispatch({
                type: 'LOAD_HOME_SCREEN'
            });
        }
    }
    
    render() {
        if (!this.homeScreenViewModel.hasDataLoaded) {
            return (
                <div>Loading Home Screen Data</div>
            )
        }
        const { popularMovies, latestMovies, popularTvShows, latestTvShows, regionalMovies } = this.homeScreenViewModel
        return (
            <div>
                {popularMovies && <app-discover-widget name={"Popular Movies"} data={popularMovies._array}/>}
                {latestMovies && <app-discover-widget name={"Latest Movies"} data={latestMovies._array}/>}
                {popularTvShows && <app-discover-widget name={"Popular Tv Shows"} data={popularTvShows._array}/>}
                {latestTvShows && <app-discover-widget name={"Latest Tv Shows"} data={latestTvShows._array}/>}
                {regionalMovies && <app-discover-widget name={"Regional Movies"} data={regionalMovies._array}/>}
            </div>
        );
    }
}