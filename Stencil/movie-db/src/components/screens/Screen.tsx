import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-screen'
})
export class Screen {
    @Prop() screenType: any;
    @Prop() screenViewModel: any;
    @Prop() dispatcher: any;

    render() {
        let screen = null;
        switch (this.screenType._name) {
            case 'COUNTER':
                screen = <app-counter-screen counterViewModel={this.screenViewModel} dispatcher={this.dispatcher}/>
                break;
            case 'HOME':
                screen = <app-home-screen homeScreenViewModel={this.screenViewModel} dispatcher={this.dispatcher}/>
            default:
                break;
        }
        return screen;
    }
}
