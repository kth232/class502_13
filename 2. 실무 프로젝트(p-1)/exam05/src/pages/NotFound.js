import React from "react";
import { useNavigate} from 'react-router-dom'

const NotFound =() => {
    const navigate = useNavigate();

    return (
    <>
        <img src="../images/404.jpg" alt="page not found" />;
        <button type="button" onClick={()=>navigate(-1)}>이전 페이지</button>
        <button type="button" onClick={()=>navigate('/')}>메인 페이지</button>
    </>
    )
};
export default React.memo(NotFound);