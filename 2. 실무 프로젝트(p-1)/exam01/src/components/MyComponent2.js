import { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
  static defaultProps = {
    name: 'kim',
  };

  static propsTypes = {
    name: PropTypes.string,
    num: PropTypes.number.isRequired,
  };

  //render() 결과물 출력하는 함수, 반드시 필요함컴
  render() {
    const { name, num, children } = this.props;
    return (
      <>
        <div>Hello, I'm {name}.</div>
        <div>My favorite number is {num}.</div>
        {children}
      </>
    );
  }
}

export default MyComponent;
