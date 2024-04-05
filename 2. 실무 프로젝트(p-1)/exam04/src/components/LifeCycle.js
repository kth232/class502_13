import { Component } from 'react';

class LifeCycle extends Component {
  state = {
    number: 0,
  };
  constructor(props) {
    super(props);

    console.log('constructor');
  }

  static getDerivedStateFromProps(prevProps, prevState) {
    console.log('getDerivedStateFromProps');
    if (prevProps.mode === 'even' && prevState.number % 2 === 1) {
      return { number: prevState.number + 1 };
    }

    return null;
  }

  shouldComponentUpdate(props, state) {
    //return state.number % 3 !== 0;
    /*
        console.log(state);
        if (state.number % 3 === 0) {
            this.setState({number:state.number +1});
            return false;
        }
        */
    return true;
  }

  componentDidMount() {
    console.log('componentDidMount');
  } //한번만 호출

  getSnapshotBeforeUpdate(props, state) {
    console.log('getSnampshotBeforeUpdate');

    return { value: 100 };
  }

  componentDidUpdate(props, state, snapshot) {
    console.log('componentDidUpdate');
    console.log('snapshot:', snapshot);
  } // 갱신될 때마다 호출됨

  componentWillUnmount() {
    console.log('componentWillUnmount');
  }

  render() {
    console.log('render');
    const { number } = this.state;
    try {
      number.abc();
    } catch (err) {
      console.log(err.message);
      console.error('err');
      console.log('error handle..');
    } finally {
      console.log('certainly run');
    }
    // throw new error('error!!!!');
    console.log('run');
    return (
      <>
        <h2>{number}</h2>
        <button
          type="button"
          onClick={() => this.setState({ number: number + 1 })}
        >
          +1
        </button>
        <button
          type="button"
          onClick={() => this.setState({ number: number - 1 })}
        >
          -1
        </button>
      </>
    );
  }
}

export default LifeCycle;
