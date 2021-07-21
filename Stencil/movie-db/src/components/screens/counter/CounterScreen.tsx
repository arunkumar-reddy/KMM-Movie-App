import { Component, Prop, h} from '@stencil/core';

@Component({
    tag: 'app-counter-screen',
    styleUrl: 'CounterScreen.css'
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
            type: 'DECREMENT_COUNTER'
        });
    }

    navigateToHome = () => {
        this.dispatcher.dispatch({
            type: 'NAVIGATE',
            navigationType: 'FORWARD',
            screenName: '/home'
        });
    }
    
    render() {
        return (
            <div class="screenContainer">
                <p>{"The counter value is: " + this.counterViewModel.counter}</p>
                <div class="buttonContainer">
                    <button onClick={this.incrementCounter}> Increment Counter </button>
                    <button onClick={this.decrementCounter}> Decrement Counter </button>
                    <button onClick={this.navigateToHome}> Submit </button>
                </div>
            </div>
        )
    }
}
