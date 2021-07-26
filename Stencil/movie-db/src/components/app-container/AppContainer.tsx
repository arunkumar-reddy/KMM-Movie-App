import { Component, h, State } from '@stencil/core';
const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

@Component({
    tag: 'app-container',
    styleUrl: 'AppContainer.css',
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
            <div class="container">
                {this.appState.appBarState && <app-bar appBarState={this.appState.appBarState}/>}
                {this.appState.navigationState && 
                    <app-screen 
                        screenType={this.appState.navigationState.screenType} 
                        screenViewModel={this.appState.screenViewModel}
                        dispatcher={this.application}
                    />
                }
                {this.appState.bottomBarState && <app-bottom-bar bottomBarState={this.appState.bottomBarState}/>}
            </div>
        );
    }
}
