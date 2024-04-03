import { useState } from 'react';

const Counter = () => {
    let num = 10; //페이지 새로고침할 때마다 함수 재호출, 기본 값으로 초기화됨
    console.log('rendering', ', num: ', num);
    const [number, setNumber] = useState(0);

    const plus = () => {
        num++ //증가x
        setNumber(number + 1);
    }
    const minus = () => setNumber(number - 1);

    return (
        <>
            <h2>{number}</h2>
            <button type="button" onClick={plus}>+1</button>
            <button type="button" onClick={minus}>-1</button>
        </>
        );

    /*
    const data = useState(0);
    const number =  data[0];
    const setNumber = data[1];
    //setNumber: 값을 바꾸는 함수
    */
};

export default Counter;
