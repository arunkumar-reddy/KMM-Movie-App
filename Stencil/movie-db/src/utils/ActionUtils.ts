const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

enum ActionTypes {
    SEARCH_QUERY
}

function getAction(actionType: ActionTypes): any {
    return sdk.JsUtils.getAction({ type: actionType.toString() });
}

export {ActionTypes, getAction}