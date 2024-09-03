import React, { Fragment } from 'react';
import Greeting from './components/Greeting';
//모듈 가져오기

const counter = () => {
  const num = 10;
  const visible = false;
  const styled = {
    background: 'skyblue',
    color: 'blue',
  };
  //jsx 문법, 항상 단일, 트리 형태로 구성하여 빠르게 변화,
  //Fragment를 사용하면 보이진 않지만 단일 태그로 감쌀 때 사용
  return (
    <>
      {/** 우리가 만든 컴포넌트 가져와서 사용 가능, 태그처럼 사용함(태그 닫기 필수!), 속성값 넘겨주기 */}
      <Greeting name="kim" />
      {/**바뀌는 값=변수 */}
      <h1 style={styled}>{num}</h1>
      <button type="button">-1</button>
      <button type="button">+1</button>
      {visible ? <h1>visible?</h1> : ''}
    </>
  );
};

export default counter;
