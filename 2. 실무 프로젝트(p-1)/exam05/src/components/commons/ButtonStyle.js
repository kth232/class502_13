import styled, { css } from 'styled-components';
export const BigButton = styled.button`
  width: 100%;
  height: 45px;
  border: 0;
  background: ${({ bgcolor }) => bgcolor ?? '#5D5D5D'};
  font-size: 1rem;
  font-weight: bold;
  margin-top: 10px;

  ${({selected, bgcolor})=>selected && css`
    border:1px solid ${bgcolor ?? '#5D5D5D'};
    background: #fff;

  `}
`; //비구조 할당, 템플릿 함수(적용할 스타일이 많을 때 사용)
// export 시 default 없으면 여러 파일에서 불러와 사용할 수 있음
// 공통 스타일을 따로 정리하는 것이 활용하기 좋음
// 함수일 때 매개변수는 무조건 props
// 함수 정의 시 내부에서 함수 호출, 속성값 넘어옴
// 표현식에서 if문은 못 씀, 조건문을 써야한다면 && 또는 삼항조건문 사용
