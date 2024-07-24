import { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component { //component 상속
  static defaultProps = {
    name: 'kim',
  };

  static propsTypes = {
    name: PropTypes.string,
    num: PropTypes.number.isRequired,
  };

  //render() 결과물 출력하는 함수, 반드시 필요함, 내부는 jsx 문법으로 정의
  render() {
    console.log(this.props);
    console.log('props', Object.getOwnPropertyDescriptors(this.props)) //속성 값 자세하게 볼 때 사용
    console.log('props.color', Object.isExtensible(this.props))
    console.log('props', Object.isFrozen(this.props)) //객체 동결 상태=값 변경 안됨<-부모 컴포넌트(App.js)가 넘겨준 값=자신이 소유한 데이터가 아니기 때문
    //사용하는 곳이 부모

    const props1 = this.props //속성값 담김, 이렇게는 원래 잘 사용 안함

    const styles = {
      background: props1.color
    };

    const { name, num, children } = this.props; //비구조화 할당, 변수로 분해해서 사용 가능
    return (
      <>
        <div>{props1.title}</div>
        <div>Hello, I'm {name}.</div>
        <div>My favorite number is {num}.</div>
        {children} {/*컴포넌트 안쪽 값은 children 속성으로 들어옴 */}

        <button id="bttn" style= {styles}>{children}(click)</button>
      </>
    );
  }
}

export default MyComponent;
