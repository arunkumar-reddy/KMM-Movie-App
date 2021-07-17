import { Component, h, State } from '@stencil/core';
import {} from 'kotlin/kotlin'
const sdk = (window as any).moviesdk.com.arun.moviedb.sdk as any;

@Component({
  tag: 'app-container',
  shadow: true,
})
export class AppContainer {
  application: any;
  @State() appState: any;

  componentWillLoad() {
    this.application = new sdk.Application()
    console.log(this.application.appState);
  }

  render() {
    return (
      <div>
        <app-bar/>
      </div>
    );
  }
}
