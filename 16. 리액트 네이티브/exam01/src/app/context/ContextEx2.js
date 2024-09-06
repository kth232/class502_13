'use client';
import React, { useContext } from 'react';
import UserContext from './userContext';
console.log(UserContext);

//children이 함수형태, 내부에서 호출할 때 값 넘겨줌
//random props 문법, consumer: 값을 전달하는 역할
const ContextEx2 = () => {
  const {
    states: { isLogin, userInfo },
    actions: { setIsLogin, setUserInfo },
  } = useContext(UserContext);

  const onLogin = () =>{
    setIsLogin(true);
    setUserInfo({userName: 'lee', email: 'lee@test.org'});
  }

  
  const onLogout = () => {
    setIsLogin(false);
    setUserInfo(null);
  };

  return (
    <div>
      {isLogin ? (
        <button type="button" onClick={onLogout}>로그아웃</button>
      ) : (
        <button type="button" onClick={onLogin}>로그인</button>
      )}
    </div>
  );
};

export default ContextEx2;
