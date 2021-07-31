import { Component, h, State } from '@stencil/core';
import { getNavigationAction, NavigationTypes } from '../../utils/ActionUtils';

const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

@Component({
    tag: 'app-container',
    styleUrl: 'Application.css',
    shadow: true,
})
export class Application {
    application: any;
    @State() appState: any;

    componentWillLoad() {
        this.addPopStateListener()
        this.application = new sdk.Application(this.updateState);
    }

    addPopStateListener = () => {
        window.addEventListener('popstate', (event) => {
            if (event.state) {
                const { navigationState } = this.appState;
                const action = event.state.screenName === navigationState?.prevState?.screenName ?
                    getNavigationAction(NavigationTypes.BACK, null) : 
                    getNavigationAction(NavigationTypes.FORWARD, event.state.screenName);
                this.application.dispatch(action);
            }
        });
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
