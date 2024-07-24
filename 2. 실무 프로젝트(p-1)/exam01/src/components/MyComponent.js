import PropTypes from 'prop-types';
import React from 'react'; 

export const objA = {a:10}; //모듈 2가지 한번에 내보내기
export const objB = {b:20};


const MyComponent = ({ name, num, children }) => {
  return ( 
    <>
      <div>Hello, I'm {name}.</div>
      <div>My favorite number is {num}.</div>
      {children}
    </>
  );
};
MyComponent.defaultProps = {
  //기본값 설정
  name: 'kim',
};
MyComponent.propTypes = {
  //자료형 한정함으로 다른 자료형 넣으면 경고 나타내줌
  name: PropTypes.string,
  num: PropTypes.number.isRequired,
};
export default MyComponent; //모듈 1개만 내보내기 가능
