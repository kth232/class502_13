import React from 'react';
//React import 선언하지 않으면 컴파일 시 오류 발생
//윈도우는 괜찮지만 맥은 오류 발생

//속성 값 매개변수로 받음
const Greeting = (props) => {
  console.log('props', props);
  console.log(Object.getOwnPropertyDescriptor(props));
  //객체 정보 확인
  console.log('isExtensible', Object.isExtensible(props));
  console.log('isFrozen', Object.isFrozen(props));
  //넘어온 값들은 동결 상태이기 때문에 props 값은 바뀌지 않음
  //브라우저 콘솔 창이 아닌 터미널에 로그 출력됨
  return (
    <div>
      <h1>안녕하세요!</h1>
    </div>
  );
};

export default Greeting;
