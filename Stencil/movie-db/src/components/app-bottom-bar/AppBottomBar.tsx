import { Component, Prop, h } from '@stencil/core';

@Component({
    tag: 'app-bottom-bar',
    styleUrl: 'AppBottomBar.css',
    shadow: true,
})
export class BottomBar {
    @Prop() bottomBarState: any;

    render() {
        const { bottomBarItems } = this.bottomBarState;
        return (
            <div class="bottomBarContainer">
                {bottomBarItems._array.map(item => (
                    <div class="bottomBarItem">
                        <p class="bottomBarItemText">{item.title}</p>
                    </div>
                ))}
            </div>
        )
    }
}