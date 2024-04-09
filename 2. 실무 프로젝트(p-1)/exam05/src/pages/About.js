import React from "react";
import MessageBox from "../components/commons/MessageBox";

const About = () => {
 return (
    <div>
        <h1>회사 소개</h1>
        <div>소개 내용</div>
    </div>
 );
};

export default React.memo(About);
//필요할 때만 렌더링하기 위해 항상 React.memo로 감싸기