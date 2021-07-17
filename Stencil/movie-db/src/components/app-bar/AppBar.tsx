import { Component, h } from '@stencil/core';

@Component({
  tag: 'app-bar',
  styleUrl: 'AppBar.css',
  shadow: true,
})
export class AppBar {
  render() {
    return (
      <header>
        <h1>Stencil App Starter</h1>
      </header>
    );
  }
}
