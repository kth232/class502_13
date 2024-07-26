import React, { Component } from 'react';

class Counter extends Component { //클래스형 컴포넌트
  state = { //state 객체 정의
    number: 0,
  };

  render() {
    //상태 바뀔 때마다 render함수 내부가 계속 호출->다시 랜더링함->값이 계속 바뀜
    //요소 하나씩 다 비교하기엔 시간이 오래 걸림->리액트는 객체 주소만 비교
    //->매번 새로운 객체를 만들어서 객체 주소 변경해야만 다시 랜더링
    const { number } = this.state; //비구조화 할당
    console.log('호출!', this.state);

    const plus = () => this.setState({ number: number + 1 }); //값만 바껴도 갱신해줘서 이벤트 처리 간편함
    const minus = () => this.setState({ number: number - 1 }); //this는 Counter가 만든 객체
    //this.state.number-- //값이 바뀌더라도 랜더링 안됨->객체 주소가 같기 때문
    //const number = this.state.number;

    return (
      <>
        <h2>{number}</h2>
        <button type="button" onClick={plus}> 
          +1
        </button>

        <button type="button" onClick={minus}>
          -1
        </button>

                
        {/*setState에 함수 객체 자체의 값을 넣어줘야 함 */}
        {/*
        <button type="button" onClick={()=>this.setState(--this.state.number)}> 
          not act
        </button>

        <button type="button" onClick={()=>this.setState({number:number +1})}> 
          not act2
        </button>


        <button type="button" onClick={()=>this.setState(prevState =>({...prevState, num: number + 1}))}> 
          functional
        </button>
         */}
        {/*함수형태로 작성 가능, 첫번째 매개변수가 이전 상태값
        객체를 내보낼 땐 소괄호로 감싸야 함, 중괄호만 있으면 수행 코드로 인식*/}
      </>
    );
  }
}

export default Counter;
