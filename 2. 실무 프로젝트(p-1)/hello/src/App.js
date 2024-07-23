/*
import logo from './logo.svg'; // from '모듈 경로' , 확장자 생략 가능
import './App.css'; //(./) 같은 프로젝트 내 존재하는 파일 불러올 때, 유저가 생성한 파일
import Common2, { add as plus, person } from './Common'; // 하나의 경로에서 모듈 여러개 가져오기, as로 별칭 사용
console.log(plus(10, 20));
console.log(person);

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
} //변경사항이 생길 때마다 반복, JS document 객체로 변환

export default App; // 모듈 내보내기




import {fragment} from 'react'; //모듈 가져오기, fragment는 생략 가능
<fragment></fragment> //외부에 태그 노출 x
*/

import Common from './Common'; //태그 형태로 사용 가능

const App = () => {
  //App = 함수형 컴포넌트
  const name = 'js';
  const style = {
    backgroundColor: 'orange',
    color: 'white',
    height: '100px',
  };
  return (
    <>
      {' '}
      {/*fragment 태그 축약형*/}
      {/* 주석은 이렇게.. //는 줄 개행 필수 */}
      <>
        {name && <h1>hi, {name}</h1>} {/*이름이 있는 경우 text 출력*/}
        <h2>welcome</h2>
      </>
      <common>Buttons</common> {/*buttons을 어떻게 꺼내오는가?*/}


      <div className="subject" style={style}>
        {' '}
        {/* 자바스크립트 표현식 {} */}
        first component!
      </div>
      <div style={{ color: 'blue' }}>second {name && name}!</div>
      {name === 'react' && <h1>component</h1>}
      <input type="text" />
    </>
  );
};

export default App; // 모듈 내보내기
//항상 단일태그로 감싸야 함, 효율성 위함
