import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-counter-screen'
})
export class CounterScreen {
    @Prop() counterViewModel: any;
    @Prop() dispatcher: any;

    incrementCounter = () => {
        this.dispatcher.dispatch({
            type: 'INCREMENT_COUNTER'
        });
    }

    decrementCounter = () => {
        this.dispatcher.dispatch({
            type: {
                _name: 'DECREMENT_COUNTER'
            }
        });
    }
    
    render() {
        return (
            <div style={{ flexDirection: 'column' }}>
                <p>{"The counter value is: " + this.counterViewModel.counter}</p>
                <div style={{ flexDirection: 'row' }}>
                    <button onClick={this.incrementCounter}> Increment Counter </button>
                    <button onClick={this.decrementCounter}> Decrement Counter </button>
                </div>
            </div>
        )
    }
}
