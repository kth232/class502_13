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





import {fragment} from 'react';
<fragment></fragment>
*/

const App = () => {
  const name = 'js';
  const style = {
    backgroundColor: 'orange',
    color: 'white',
    height: '100px',
  };
  return (
    <>
      {/* 주석은 이렇게.. //는 줄 개행 필수 */}
      <div className="subject" style={style}>
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
