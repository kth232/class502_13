import { Component } from 'react';
import PropTypes from 'prop-types'; //모듈 필요

class MyComponent2 extends Component {
  //클래스형 컴포넌트
  //component 상속
  static defaultProps = {
    name: 'kim',
  };

  /*
  //스타일 직접 지정하는 건 지양
  MyComponent2.defaultProps = {
    color:'black',
  };
  */

  //propsType을 많이 사용하진 않지만 알아두자
  static propsTypes = {
    //statice ->클래스명, 변수명으로 바로 접근 가능함
    //자료형 명시, 강제는 아니며 경고가 나온다
    name: PropTypes.string,
    num: PropTypes.number.isRequired, //필수 항목으로 지정, 강제 x
    color: PropTypes.string, //문자열로 지정했는데 true로 값을 넣으면 타입 불일치하다는 경고를 띄운다
  };

  //render() 결과물 출력하는 함수, 반드시 필요함, 내부는 jsx 문법으로 정의
  render() {
    // console.log(this.props);
    // console.log('props', Object.getOwnPropertyDescriptors(this.props)) //속성 값 자세하게 볼 때 사용
    // console.log('props.color', Object.isExtensible(this.props))
    // console.log('props', Object.isFrozen(this.props)) //객체 동결 상태=값 변경 안됨<-부모 컴포넌트(App.js)가 넘겨준 값=자신이 소유한 데이터가 아니기 때문
    //사용하는 곳이 부모

    const props1 = this.props; //속성값 담김, 이렇게는 원래 잘 사용 안함

    const styles = {
      //background: props1.color
      background: props1.color ?? 'gold',
    };

    const { name, num, children: c } = this.props; //비구조화 할당, 변수로 분해해서 사용 가능
    //children은 리액트에서 정해준 거라 바꿀 순 없지만 비구조화 할당을 이용해 변수로 지정해서 사용 가능

    return (
      <>
        <div>{props1.title}</div>
        <div>Hello, I'm {name}.</div>
        <div>My favorite number is {num}.</div>
        {c} {/*컴포넌트 안쪽 값은 children 속성으로 들어옴 */}
        <button id="bttn" style={styles} color={true}>
          {c}(click)
        </button>{' '}
        {/*별칭으로 사용 가능, 문자열 외에는 전부 중괄호 안에 넣어야 함*/}
      </>
    );
  }
}

export default MyComponent2;
