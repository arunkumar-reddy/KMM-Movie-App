import { Component, h, State } from '@stencil/core';
const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

@Component({
    tag: 'app-container',
    shadow: true,
})
export class AppContainer {
    application: any;
    @State() appState: any;

    componentWillLoad() {
        this.application = new sdk.Application(this.updateState);
    }

    updateState = (state: any) => {
        this.appState = state;
    }

    render() {
        console.log("Rendering app container");
        if (!this.appState) {
            return null;
        }
        return (
            <div>
                {this.renderAppBar(this.appState.appBarState)}
                {this.renderScreen(this.appState.navigationState?.screenType, this.appState.screenViewModel)}
            </div>
        );
    }

    renderAppBar(appBarState) {
        if (!appBarState) {
            return null;
        }
        return (
            <app-bar 
                appBarTitle={this.appState.appBarState?.title}
                appBarColor={this.appState.appBarState?.appBarColor}
                appBarTextColor={this.appState.appBarState?.appBarTextColor}
            />
        )
    }

    renderScreen(screenType: any, screenViewModel: any) {
        return (
            <app-screen 
                screenType={screenType} 
                screenViewModel={screenViewModel}
                dispatcher={this.application}
            />
        )
    }
}
