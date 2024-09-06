import React, { createContext, useState } from 'react';

//기본값 넣어줄 수 있다, 위치 상관없이 어디서든 접근 가능
const UserContext = createContext({
  states: { isLogin: false, isAdmin: false, userInfo: null },
  actions: {
    setIsLogin: null,
    setIsAdmin: null,
    setUserInfo: null,
  },
});

const UserProvider = ({children}) => {
    const [isLogin, setIsLogin] = useState(false);
    const [isAdmin, setIsAdmin] = useState(false);
    const [userInfo, setUserInfo] = useState(null);

    const value={
        states: {isLogin, isAdmin, userInfo},
        actions: {setIsLogin, setIsAdmin, setUserInfo},
    };

    return <UserContext.Provider value={value}>{children}</UserContext.Provider>
};

const {Consumer: UserConsumer} = UserContext;

export {UserProvider, UserConsumer};

export default UserContext;
