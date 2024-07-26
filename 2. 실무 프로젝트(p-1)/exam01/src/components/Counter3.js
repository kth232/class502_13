import React, {useState} from "react";

const Counter3 = () => { //지정하지 않고 값만 바꿔도 다시 랜더링
    const [data, setData] = useState({
      number: 0, //숫자가 바뀌기 때문에 다른 객체가 되기 때문에 재랜더링
      name: 'lee',
    });
  
    const { number, name } = data;

    const decreaseFunc = (state) => ({...state, number:number - 1}); //새로운 문법?
  
    const decrease = () => {
      //setData({ ...data, number: number - 1 }); 
      //...data: 전개연산자, 값을 복사하고 새로운 객체로 만듦->부분 치환->랜더링=불변성 유지
      setData((prevState)=>({...prevState, number:number - 1}))
      //setData((prevState) => decreaseFunc(prevState)); = setData(decreaseFunc);
      //새로운 문법? 함수형태에서 매개변수가 바로 들어갈 때 사용
    };
  
    const increase = () => {
      //setData({ ...data, number: number + 1 }); 
      setData((prevState)=>({...prevState, number:number + 1}))
      //함수형태, 첫번째 매개변수에 이전 상태값, 전개연산자로 특정 값만 변경, 바로 값을 바꿔주는 것보다 자주 사용하는 방식
    };
  
    console.log('호출', data);
    //특정 요소 선택 없이 값만 바껴도 랜더링이 됨
    return (
      <>
        <h1>{number}</h1>
        <h2>{name}</h2>
        <button type="button" onClick={decrease}>
          -1
        </button>
        <button type="button" onClick={increase}>
          +1
        </button>
      </>
    );
  };
  
  export default Counter3;