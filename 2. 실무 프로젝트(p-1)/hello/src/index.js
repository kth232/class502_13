import React from 'react'; //node_modules(외부 라이브러리)에서 불러올 경우
import ReactDOM from 'react-dom/client'; //index.js가 기본적으로 가져오는 파일이라 생략 가능
import './index.css';
import App from './App'; //import 뒤에 변수명 지정 가능
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
