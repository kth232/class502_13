import { Component } from 'react';

class Counter extends Component {
  state = {
    number: 0,
  };

  render() {
    //상태 바뀔 때마다 render함수만 호출
    const { number } = this.state; //비구조화 할당
    const plus = () => this.setState({ number: number + 1 });
    const minus = () => this.setState({ number: number - 1 }); //this는 Counter가 만든 객체

    return (
      <>
        <h2>{number}</h2>
        <button type="button" onClick={plus}>
          +1
        </button>
        <button type="button" onClick={minus}>
          -1
        </button>
      </>
    );
  }
}

export default Counter;
