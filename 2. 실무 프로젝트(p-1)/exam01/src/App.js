import MyComponent2 from './components/MyComponent2';
//import Counter from './components/Counter2';
import React from 'react'; //권장사항, 리액트 서버 버전 오류를 없애기 위함(윈도우는 문제 없음)
import Counter from './components/Counter';
import Counter3 from './components/Counter3';
import Profile from './components/Counter';
import MyCpnt, {objA as oA, objB} from './components/MyComponent'; 
import Buttons from './components/Buttons';
//export로 내보내면 default는 변수명 변경 가능, export로 내보내면 변수명 변경 불가(동일한 이름으로만 불러오기 가능)
//as를 통해 별칭 사용 가능

//console.log(oA, objB);

const App = () => {

  return <Counter3 />;


  let num = 15;
  return <Counter num={num}/>;



  // return (
  //   <>
  //   <MyComponent2 num={2} name={'lee'} /*color="green"*/ title="INTRO">
  //   {/*속성값 입력*/}
  //   <h3>nice to meet you</h3>
  //   </MyComponent2>
  //   <Buttons color="green">hello</Buttons>
  //   </>
  // );

};

export default App;
