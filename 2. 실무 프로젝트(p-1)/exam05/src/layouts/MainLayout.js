import React from 'react';
import { Outlet, NavLink } from 'react-router-dom';
import classNames from 'classnames';

const MainLayout = () => {
  return (
    <>
      <header>
        <h1>header</h1>
        <div>
            <NavLink to ='/about' className={({isActive})=>classNames('menu', {on:isActive})}>ABOUT</NavLink>
            <br/>
            <NavLink to ='/board' className={({isActive})=>classNames('menu', {on:isActive})}>BOARD</NavLink>
        </div>
      </header>
      <main>
        <Outlet />
      </main>
      <footer>
        <h1>footer</h1>
      </footer>
    </>
  ); // 헤더, 푸터는 고정, 가운데(중첩된 라우터 부분)만 바뀜
};

export default React.memo(MainLayout);
