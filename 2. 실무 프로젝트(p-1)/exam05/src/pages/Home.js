import React, { Suspense, useState } from 'react';
import { Link, Navigate } from 'react-router-dom';
//import MessageBox from "../components/commons/MessageBox";
import styled from 'styled-components';
import loadable from '@loadable/component';


//const MessageBox = React.lazy(()=>import("../components/commons/MessageBox"));
const MessageBox = loadable(() => import('..//components/commons/MessageBox'), {fallback: <div>로딩중..</div>, });


/*
const MessageBox2 = styled(MessageBox) `
 background: orange;
`;
*/

const Home = () => {
  const [visible, setVisible] = useState(false);

  /*
    const result = true;
    if (result) {
        return <Navigate to="/about" replace={true} />;
    }
    */

  return (
    <div>
      <h1>HOME</h1>
      <div>main page</div>
      <div>
        <Link to="/about">회사 소개</Link>
        {/*
            <Suspense fallback={<div>로딩중..</div>}>
                {visible && <MessageBox>Message!!</MessageBox>}
            </Suspense>
            */}
        {visible && <MessageBox>Message!!</MessageBox>}
        <button type="button" onClick={() => setVisible(true)}>
          보여주기
        </button>
      </div>
    </div>
  );
};

export default React.memo(Home);
//필요할 때만 렌더링하기 위해 항상 리액트 메모로 감싸기
