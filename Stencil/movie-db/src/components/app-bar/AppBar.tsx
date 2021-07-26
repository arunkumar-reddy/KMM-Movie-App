import { Component, Prop, h } from '@stencil/core';

@Component({
    tag: 'app-bar',
    styleUrl: 'AppBar.css',
    shadow: true,
})
export class AppBar {
    @Prop() appBarState: any;

    render() {
        return (
            <header class="appBarContainer" style={{ background: this.appBarState.appBarColor }}>
                <h1 class="appBarText" style={{ color: this.appBarState.appBarTextColor }}>{this.appBarState.title}</h1>
            </header>
        );
    }
}
