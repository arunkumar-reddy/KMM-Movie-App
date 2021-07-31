/* eslint-disable */
/* tslint:disable */
/**
 * This is an autogenerated file created by the Stencil compiler.
 * It contains typing information for all components that exist in this project.
 */
import { HTMLStencilElement, JSXBase } from "@stencil/core/internal";
export namespace Components {
    interface AppBar {
        "appBarState": any;
    }
    interface AppBottomBar {
        "bottomBarState": any;
        "dispatcher": any;
    }
    interface AppContainer {
    }
    interface AppCounterScreen {
        "counterViewModel": any;
        "dispatcher": any;
    }
    interface AppDiscoverWidget {
        "data": any[];
        "name": string;
    }
    interface AppHomeScreen {
        "dispatcher": any;
        "homeScreenViewModel": any;
    }
    interface AppScreen {
        "dispatcher": any;
        "screenType": any;
        "screenViewModel": any;
    }
    interface AppSearchInput {
        "dispatcher": any;
        "query": string;
    }
    interface AppSearchResults {
        "results": any[];
        "title": string;
    }
    interface AppSearchScreen {
        "dispatcher": any;
        "searchViewModel": any;
    }
}
declare global {
    interface HTMLAppBarElement extends Components.AppBar, HTMLStencilElement {
    }
    var HTMLAppBarElement: {
        prototype: HTMLAppBarElement;
        new (): HTMLAppBarElement;
    };
    interface HTMLAppBottomBarElement extends Components.AppBottomBar, HTMLStencilElement {
    }
    var HTMLAppBottomBarElement: {
        prototype: HTMLAppBottomBarElement;
        new (): HTMLAppBottomBarElement;
    };
    interface HTMLAppContainerElement extends Components.AppContainer, HTMLStencilElement {
    }
    var HTMLAppContainerElement: {
        prototype: HTMLAppContainerElement;
        new (): HTMLAppContainerElement;
    };
    interface HTMLAppCounterScreenElement extends Components.AppCounterScreen, HTMLStencilElement {
    }
    var HTMLAppCounterScreenElement: {
        prototype: HTMLAppCounterScreenElement;
        new (): HTMLAppCounterScreenElement;
    };
    interface HTMLAppDiscoverWidgetElement extends Components.AppDiscoverWidget, HTMLStencilElement {
    }
    var HTMLAppDiscoverWidgetElement: {
        prototype: HTMLAppDiscoverWidgetElement;
        new (): HTMLAppDiscoverWidgetElement;
    };
    interface HTMLAppHomeScreenElement extends Components.AppHomeScreen, HTMLStencilElement {
    }
    var HTMLAppHomeScreenElement: {
        prototype: HTMLAppHomeScreenElement;
        new (): HTMLAppHomeScreenElement;
    };
    interface HTMLAppScreenElement extends Components.AppScreen, HTMLStencilElement {
    }
    var HTMLAppScreenElement: {
        prototype: HTMLAppScreenElement;
        new (): HTMLAppScreenElement;
    };
    interface HTMLAppSearchInputElement extends Components.AppSearchInput, HTMLStencilElement {
    }
    var HTMLAppSearchInputElement: {
        prototype: HTMLAppSearchInputElement;
        new (): HTMLAppSearchInputElement;
    };
    interface HTMLAppSearchResultsElement extends Components.AppSearchResults, HTMLStencilElement {
    }
    var HTMLAppSearchResultsElement: {
        prototype: HTMLAppSearchResultsElement;
        new (): HTMLAppSearchResultsElement;
    };
    interface HTMLAppSearchScreenElement extends Components.AppSearchScreen, HTMLStencilElement {
    }
    var HTMLAppSearchScreenElement: {
        prototype: HTMLAppSearchScreenElement;
        new (): HTMLAppSearchScreenElement;
    };
    interface HTMLElementTagNameMap {
        "app-bar": HTMLAppBarElement;
        "app-bottom-bar": HTMLAppBottomBarElement;
        "app-container": HTMLAppContainerElement;
        "app-counter-screen": HTMLAppCounterScreenElement;
        "app-discover-widget": HTMLAppDiscoverWidgetElement;
        "app-home-screen": HTMLAppHomeScreenElement;
        "app-screen": HTMLAppScreenElement;
        "app-search-input": HTMLAppSearchInputElement;
        "app-search-results": HTMLAppSearchResultsElement;
        "app-search-screen": HTMLAppSearchScreenElement;
    }
}
declare namespace LocalJSX {
    interface AppBar {
        "appBarState"?: any;
    }
    interface AppBottomBar {
        "bottomBarState"?: any;
        "dispatcher"?: any;
    }
    interface AppContainer {
    }
    interface AppCounterScreen {
        "counterViewModel"?: any;
        "dispatcher"?: any;
    }
    interface AppDiscoverWidget {
        "data"?: any[];
        "name"?: string;
    }
    interface AppHomeScreen {
        "dispatcher"?: any;
        "homeScreenViewModel"?: any;
    }
    interface AppScreen {
        "dispatcher"?: any;
        "screenType"?: any;
        "screenViewModel"?: any;
    }
    interface AppSearchInput {
        "dispatcher"?: any;
        "query"?: string;
    }
    interface AppSearchResults {
        "results"?: any[];
        "title"?: string;
    }
    interface AppSearchScreen {
        "dispatcher"?: any;
        "searchViewModel"?: any;
    }
    interface IntrinsicElements {
        "app-bar": AppBar;
        "app-bottom-bar": AppBottomBar;
        "app-container": AppContainer;
        "app-counter-screen": AppCounterScreen;
        "app-discover-widget": AppDiscoverWidget;
        "app-home-screen": AppHomeScreen;
        "app-screen": AppScreen;
        "app-search-input": AppSearchInput;
        "app-search-results": AppSearchResults;
        "app-search-screen": AppSearchScreen;
    }
}
export { LocalJSX as JSX };
declare module "@stencil/core" {
    export namespace JSX {
        interface IntrinsicElements {
            "app-bar": LocalJSX.AppBar & JSXBase.HTMLAttributes<HTMLAppBarElement>;
            "app-bottom-bar": LocalJSX.AppBottomBar & JSXBase.HTMLAttributes<HTMLAppBottomBarElement>;
            "app-container": LocalJSX.AppContainer & JSXBase.HTMLAttributes<HTMLAppContainerElement>;
            "app-counter-screen": LocalJSX.AppCounterScreen & JSXBase.HTMLAttributes<HTMLAppCounterScreenElement>;
            "app-discover-widget": LocalJSX.AppDiscoverWidget & JSXBase.HTMLAttributes<HTMLAppDiscoverWidgetElement>;
            "app-home-screen": LocalJSX.AppHomeScreen & JSXBase.HTMLAttributes<HTMLAppHomeScreenElement>;
            "app-screen": LocalJSX.AppScreen & JSXBase.HTMLAttributes<HTMLAppScreenElement>;
            "app-search-input": LocalJSX.AppSearchInput & JSXBase.HTMLAttributes<HTMLAppSearchInputElement>;
            "app-search-results": LocalJSX.AppSearchResults & JSXBase.HTMLAttributes<HTMLAppSearchResultsElement>;
            "app-search-screen": LocalJSX.AppSearchScreen & JSXBase.HTMLAttributes<HTMLAppSearchScreenElement>;
        }
    }
}
