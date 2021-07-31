const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

enum ActionTypes {
    NAVIGATE = "NAVIGATE",
    SEARCH_QUERY = "SEARCH_QUERY"
}

enum NavigationTypes {
    FORWARD = "FORWARD",
    BACK = "BACK"
}

function getAction(actionType: ActionTypes): any {
    return sdk.JsUtils.getAction({ type: actionType.toString() });
}

function getNavigationAction(navigationType: NavigationTypes, screenName: string | null): any {
    return sdk.JsUtils.getAction({
        type: ActionTypes.NAVIGATE.toString(),
        navigationType: navigationType.toString(),
        screenName
    });
}

export {ActionTypes, NavigationTypes ,getAction, getNavigationAction}