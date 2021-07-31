import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-search-results',
    styleUrl: 'SearchResultsWidget.css'
})
export class SearchResultsWidget {
    @Prop() heading: string;
    @Prop() results: any[];

    render() {
        return (
            <div>
                <p>{this.heading}</p>
                <div>
                    {this.results.map(item => (
                        <div>
                            <p class="item">{item.result.title ?? item.result.name}</p>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}
