import { Component } from 'react';

class Color extends Component {
  state = {
    color: '#B2CCFF',
    subColor: '#8C8C8C',
  };

  render() {
    // this->color로 생성된 객체의 주소
    /*function changeColor(color) {
        console.log(this);
    }*/
    const changeColor = (color) => this.setState({ color }); //color 값이 중요함(변경하는 부분)
    const changeSubColor = (color) =>
      this.setState((prevState) => ({ ...prevState, subColor: color })); //color

    const { color, subColor } = this.state;
    return (
      <>
        <div
          style={{ background: color, width: '100px', height: '100px' }}
        ></div>
        <button
          type="button"
          onClick={() => changeColor('#FFA7A7')} //마우스 왼쪽 클릭
          onContextMenu={() => changeSubColor('#FFA7A7')} //마우스 오른쪽 클릭
        >
          RED
        </button>
        <button
          type="button"
          onClick={() => changeColor('#F2CB61')}
          onContextMenu={() => changeSubColor('#F2CB61')}
        >
          ORANGE
        </button>
        <button
          type="button"
          onClick={() => changeColor('#CEF279')}
          onContextMenu={() => changeSubColor('#CEF279')}
        >
          GREEN
        </button>
        <div
          style={{ background: subColor, width: '50px', height: '50px' }}
        ></div>
      </>
    ); //문자열 외 모든 값은 {} 안에 입력
  }
}

export default Color;
