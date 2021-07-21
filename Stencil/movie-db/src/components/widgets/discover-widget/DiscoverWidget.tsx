import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-discover-widget',
    styleUrl: 'DiscoverWidget.css'
})
export class DiscoverWidget {
    @Prop() name: string;
    @Prop() data: any[];

    render() {
        return (
            <div>
                <p class="title">{this.name}</p>
                <div class="listContainer">
                    {this.data.map((item) => (
                        <div class="itemContainer">
                            <p class="item">{item._title ?? item._name}</p>
                        </div>
                    ))}
                </div>
            </div>
        )
    }
}