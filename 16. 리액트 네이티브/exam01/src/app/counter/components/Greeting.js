import React from 'react';
//React import 선언하지 않으면 컴파일 시 오류 발생
//윈도우는 괜찮지만 맥은 오류 발생

//함수형 컴포넌트, 속성 값 매개변수로 받음
const Greeting = ({ name, age, email, children }) => {
  age = age ?? 20; //기본값 설정
  // console.log('props', props);
  // console.log(Object.getOwnPropertyDescriptor(props));
  // //객체 정보 확인
  // console.log('isExtensible', Object.isExtensible(props));
  // console.log('isFrozen', Object.isFrozen(props));
  //넘어온 값들은 동결 상태이기 때문에 props 값은 바뀌지 않음
  //브라우저 콘솔 창이 아닌 터미널에 로그 출력됨

  // props.name='lee'; //동결상태이기 때문에 값 안 바뀜
  // const {name} = props;
  return (
    <div>
      <h1>
        {name}({email}), 안녕하세요!
      </h1>
      <h1>age: {age}</h1>
      <div>{children(100)}</div>
    </div>
  );
};

//기본값 설정, 거의 사용하지 않는 방법
// Greeting.defaultProps = {
//   age: 20,
// };

export default Greeting;
