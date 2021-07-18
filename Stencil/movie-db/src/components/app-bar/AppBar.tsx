import { Component, Prop, h } from '@stencil/core';

@Component({
    tag: 'app-bar',
    styleUrl: 'AppBar.css',
    shadow: true,
})
export class AppBar {
    @Prop() appBarTitle: string;
    @Prop() appBarColor: string;
    @Prop() appBarTextColor: string;

    render() {
        return (
            <header style={{ background: this.appBarColor }}>
                <h1 style={{ color: this.appBarTextColor }}>{this.appBarTitle}</h1>
            </header>
        );
    }
}
