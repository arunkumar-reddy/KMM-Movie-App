import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-search-screen',
    styleUrl: 'SearchScreen.css'
})
export class SearchScreen {
    @Prop() searchViewModel: any;
    @Prop() dispatcher: any;

    render() {
        const { query, movieSearchResults, tvSearchResults } = this.searchViewModel;
        return (
            <div class="container">
                <div>
                    <input>Search</input>
                </div>
                {query ?
                    <div>
                        {movieSearchResults && <app-search-results title={"Showing Movie Results"} results={movieSearchResults._array}/>}
                        {tvSearchResults && <app-search-results title={"Showing TV Results"} results={tvSearchResults._array}/>}
                    </div> : <div>Search for your favorite movies and tv shows</div>
                }
            </div>
        )
    }
}