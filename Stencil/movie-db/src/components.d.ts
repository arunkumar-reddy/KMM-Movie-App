/* eslint-disable */
/* tslint:disable */
/**
 * This is an autogenerated file created by the Stencil compiler.
 * It contains typing information for all components that exist in this project.
 */
import { HTMLStencilElement, JSXBase } from "@stencil/core/internal";
export namespace Components {
    interface AppBar {
        "appBarColor": string;
        "appBarTextColor": string;
        "appBarTitle": string;
    }
    interface AppContainer {
    }
    interface AppCounterScreen {
        "counterViewModel": any;
        "dispatcher": any;
    }
    interface AppScreen {
        "dispatcher": any;
        "screenType": any;
        "screenViewModel": any;
    }
}
declare global {
    interface HTMLAppBarElement extends Components.AppBar, HTMLStencilElement {
    }
    var HTMLAppBarElement: {
        prototype: HTMLAppBarElement;
        new (): HTMLAppBarElement;
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
    interface HTMLAppScreenElement extends Components.AppScreen, HTMLStencilElement {
    }
    var HTMLAppScreenElement: {
        prototype: HTMLAppScreenElement;
        new (): HTMLAppScreenElement;
    };
    interface HTMLElementTagNameMap {
        "app-bar": HTMLAppBarElement;
        "app-container": HTMLAppContainerElement;
        "app-counter-screen": HTMLAppCounterScreenElement;
        "app-screen": HTMLAppScreenElement;
    }
}
declare namespace LocalJSX {
    interface AppBar {
        "appBarColor"?: string;
        "appBarTextColor"?: string;
        "appBarTitle"?: string;
    }
    interface AppContainer {
    }
    interface AppCounterScreen {
        "counterViewModel"?: any;
        "dispatcher"?: any;
    }
    interface AppScreen {
        "dispatcher"?: any;
        "screenType"?: any;
        "screenViewModel"?: any;
    }
    interface IntrinsicElements {
        "app-bar": AppBar;
        "app-container": AppContainer;
        "app-counter-screen": AppCounterScreen;
        "app-screen": AppScreen;
    }
}
export { LocalJSX as JSX };
declare module "@stencil/core" {
    export namespace JSX {
        interface IntrinsicElements {
            "app-bar": LocalJSX.AppBar & JSXBase.HTMLAttributes<HTMLAppBarElement>;
            "app-container": LocalJSX.AppContainer & JSXBase.HTMLAttributes<HTMLAppContainerElement>;
            "app-counter-screen": LocalJSX.AppCounterScreen & JSXBase.HTMLAttributes<HTMLAppCounterScreenElement>;
            "app-screen": LocalJSX.AppScreen & JSXBase.HTMLAttributes<HTMLAppScreenElement>;
        }
    }
}
