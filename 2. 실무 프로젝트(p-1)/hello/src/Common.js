const Common = {
  a: 1,
  b: 2,
};

export function Buttons() {//메인이 되는 컴포넌트를 파일명으로 하는 것이 권장사항
 return <button>click</button>
}

export function add(num1, num2) {
    return num1 + num2;
}

export const person = {
    name: 'kim',
    age: 40
};

export default Common; //모듈 내보내기(1개만 내보내지만 변수명 수정 가능)
