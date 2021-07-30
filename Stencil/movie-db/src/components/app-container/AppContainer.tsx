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
        const { appBarState, bottomBarState, navigationState, screenViewModel } = this.appState;
        return (
            <div class="container">
                {appBarState && <app-bar appBarState={appBarState}/>}
                {navigationState && 
                    <app-screen 
                        screenType={navigationState.screenType} 
                        screenViewModel={screenViewModel}
                        dispatcher={this.application}
                    />
                }
                {bottomBarState && <app-bottom-bar bottomBarState={bottomBarState} dispatcher={this.application}/>}
            </div>
        );
    }
}
