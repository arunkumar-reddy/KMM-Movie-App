import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-counter-screen'
})
export class CounterScreen {
    @Prop() counterViewModel: any;
    
    render() {
        return (
            <div style={{ flexDirection: 'column' }}>
                <p>{"The counter value is: " + this.counterViewModel.counter}</p>
                <div style={{ flexDirection: 'row' }}>
                    <button>Increment Counter</button>
                    <button>Decrement Counter</button>
                </div>
            </div>
        )
    }
}
