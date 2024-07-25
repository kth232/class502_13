import React from 'react';

const Buttons = ({ color, children }) => {
  //화살표 함수, 함수형 컴포넌트
  //매개변수에 props 값을 비구조 할당으로 정의
  //const { color, children} = props;

  const styles = {
    background: color,
  };

  return <button style={styles}>{children}</button>;
};

export default Buttons;
