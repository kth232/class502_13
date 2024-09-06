'use client';
import React, { useReducer } from 'react';

//state: 기존 상태값, action: 변경값?
function reducer(state, action) {
  switch (action.type) {
    case 'INCREASE':
      return { number: state.number + 1 };
    case 'DECREASE':
      return { number: state.number - 1 };
    default:
      return state;
  }
}

//버튼을 submit 타입으로 설정할 땐 form태그로 감싸기
const Counter = () => {
  const [state, dispatch] = useReducer(reducer, { number: 0 }); //초기값으로 0 설정
  const { number } = state;

  return (
    <>
      <h1>{number}</h1>
      <button type="button" onClick={() => dispatch({ type: 'DECREASE' })}>
        -1
      </button>
      <button type="button" onClick={() => dispatch({ type: 'INCREASE' })}>
        +1
      </button>
    </>
  );
};

export default Counter;
