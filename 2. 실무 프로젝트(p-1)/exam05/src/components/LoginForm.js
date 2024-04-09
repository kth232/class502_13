import styled, { css } from 'styled-components';
import { BigButton } from './commons/ButtonStyle';

const commonStyle = css`
  width: 100%;
`; //변수형, 공통 스타일 정의할 때 사용

const OuterBox = styled.div`
  ${commonStyle}
  position: fixed;
  height: 100%;
  left: 0;
  top: 0;
  display: flex;
  align-items: center;
`; // 보이는 화면 좌측상단 기준 가득 차게 배치, 정중앙 배치

const FormBox = styled.form`
  width: 420px;
  margin: 0 auto;

  h2 {
    text-align: center;
  }
`; //하위 요소에 스타일 입히기

const InputBox = styled.input`
    ${commonStyle}
  display: block;
  height: 45px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 0 10px;
  & + & {
    margin-top: 5px;
  }
`; //``역따옴표로 묶인 부분이 매개변수->태그함수
// &+&: 인접형제요소 선택(첫번째 요소만 제외하고 모두 선택)

const LoginForm = () => {
  return (
    <OuterBox>
      <FormBox autoComplete="off">
        <h2>LOGIN</h2>
        <InputBox type="text" placeholder="아이디" />
        <InputBox type="password" placeholder="비밀번호" />
        <BigButton type="submit" bgcolor='#B2CCFF' selected={true}>LOGIN</BigButton>
      </FormBox>
    </OuterBox>
  );
};

export default LoginForm;
