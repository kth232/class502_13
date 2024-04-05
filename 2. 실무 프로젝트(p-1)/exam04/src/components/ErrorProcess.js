import {Component} from 'react';

class ErrorProcess extends Component {
    state= {
    isError: false,
    message: '',
};

componentDidCatch(error, info) {
    console.error(error, info)
    this.setState({isError:true, message:error.message});
}
render() {
    const {isError} = this.State;
    const {children} = this.Props;
    return isError ? <div>error!</div>: children;
    }
}

export default ErrorProcess;
