import React, {useState} from "react";

const Counter3 = () => { //지정하지 않고 값만 바꿔도 다시 랜더링
    const [data, setData] = useState({
      number: 0, //숫자가 바뀌기 때문에 다른 객체가 되기 때문에 재랜더링
      name: 'lee',
    });
  
    const { number, name } = data;
  
    const decrease = () => {
      setData({ ...data, number: number - 1 }); //...data: 값을 복사하고 새로운 객체로 만듦
    };
  
    const increase = () => {
      setData({ ...data, number: number + 1 }); 
    };
  
    console.log('호출', data);
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