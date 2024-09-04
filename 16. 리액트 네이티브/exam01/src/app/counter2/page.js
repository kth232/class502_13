'use client'; //서버사이드 렌더링 사용 시 정의해야 함->콘솔창에 로그 호출 가능
import React, { useState, useRef } from 'react';

const Counter = () => {
  //상태변경함수가 계속 호출됨
  const [num, setNum] = useState(0);
  //   console.log('Counter func call');

  let num2 = useRef(1); //DOM 선택할 때, 
  const onIncrease = () => {
    console.log(e);
    setNum(num + 1);
    num2.current++; //ref는 current 속성값으로 접근
    console.log('num2', num2.current); 
  };

  const onDecrease = () => {
    setNum(num - 1);
  };

  return (
    <>
      <h1>{num}</h1>
      {/* <button type="button" onClick={() => setNum(num - 1)}>
        -1
      </button> */}
      <button type="button" onClick={onDecrease}>
        -1
      </button>
      {/* <button type="button" onClick={() => setNum(num + 1)}>
        +1
      </button> */}
      <button type="button" onClick={onIncrease}>
        +1
      </button>
    </>
  );
};

export default Counter;
