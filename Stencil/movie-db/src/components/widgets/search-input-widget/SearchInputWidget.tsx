import { Component, Prop, h, State} from '@stencil/core';
import { getNavigationAction, NavigationTypes } from '../../../utils/ActionUtils';

@Component({
    tag: 'app-search-input'
})
export class SearchInputWidget {
    @Prop() query: string;
    @Prop() dispatcher: any;
    @State() searchInput: string = "";
    
    handleInput = event => {
        this.searchInput = event.target.value;
    }

    handleSubmit = _ => {
        const screenName = "/search/" + this.searchInput
        const action = getNavigationAction(NavigationTypes.FORWARD, screenName);
        this.dispatcher.dispatch(action);
    }

    render() {
        return (
            <div>
                <input onChange={this.handleInput}/>
                <button onClick={this.handleSubmit}>Search</button>
            </div>
        )
    }
}