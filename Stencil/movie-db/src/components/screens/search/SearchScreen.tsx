import { Component, Prop, h} from '@stencil/core';
import { ActionTypes, getAction } from '../../../utils/ActionUtils';

@Component({
    tag: 'app-search-screen',
    styleUrl: 'SearchScreen.css'
})
export class SearchScreen {
    @Prop() searchViewModel: any;
    @Prop() dispatcher: any;

    componentWillLoad() {
        this.dispatchSearchAction()
    }

    componentWillUpdate() {
        this.dispatchSearchAction()
    }

    dispatchSearchAction() {
        const { query, hasDataLoaded } = this.searchViewModel;
        if (query && !hasDataLoaded ) {
            this.dispatcher.dispatch(getAction(ActionTypes.SEARCH_QUERY));
        }
    }

    render() {
        const { query, movieSearchResults, tvSearchResults, hasDataLoaded } = this.searchViewModel;
        return (
            <div class="container">
                <app-search-input query={query ?? ""} dispatcher={this.dispatcher}/>
                {query ?
                    hasDataLoaded ? 
                        <div>
                            {movieSearchResults && <app-search-results title={"Showing Movie Results"} results={movieSearchResults._array}/>}
                            {tvSearchResults && <app-search-results title={"Showing TV Results"} results={tvSearchResults._array}/>}
                        </div> 
                        : <div>Loading search results</div>
                    : <div>Search for your favorite movies and tv shows</div>
                }
            </div>
        )
    }
}