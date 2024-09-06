import React from 'react';
import { IoMdRadioButtonOff, IoMdRadioButtonOn } from 'react-icons/io';
import MessageBox from '@/app/commons/components/MessageBox'; //next.js는 사용자가 만든 컴포넌트 가져올 때 경로 앞에 @붙음
import '../todo.scss'; //todo.sass보다 체계적임
import styles from '../todo.module.scss';
import classNames from 'classnames/bind';
import styled, { css } from 'styled-components';
// console.log(styles);

//tagged 함수, 공통 스타일을 만들어서 한번에 적용
const commonStyle = css`
  border: 0;
  height: 45px;
  padding: 0 35px;
  color: #fff;
`;

//ssr은 렌더링에 시간이 좀 걸림
const ButtonBox = styled.button`
  background: ${({ color }) => color ?? 'blue'}; //비구조 할당
  font-size: 1.3rem;
  ${commonStyle}
  ${({ width }) =>
    width &&
    css`
      width: ${width};
    `}
`;

const cx = classNames.bind(styles); //bind()는 새로 만들어줌, 이름 중복되지 않게 함

//창이 이동하는 형식으로 제출, 폼 내에서 검증도 함
//onchange 이벤트로 입력값 확인, name은 필드명과 동일하게 할 것
const TodoForm = ({ onSubmit, onChange, form, onClick, titleRef, errors }) => {
  const active = true; //통제
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <button type="button" className={cx({ on: active })}>
        click
      </button>
      <dl className={styles.item}>
        <dt>할일</dt>
        <dd>
          <input
            type="text"
            name="title"
            value={form?.title ?? ''}
            onChange={onChange}
            ref={titleRef}
          />
          {errors?.title && <MessageBox>{errors.title}</MessageBox>}
          {/** ref로 dom 선택 */}
        </dd>
      </dl>
      <dl>
        <dt>내용</dt>
        <dd>
          <textarea
            name="content"
            value={form?.content ?? ''}
            onChange={onChange}
          ></textarea>
          {errors?.content && <MessageBox>{errors.content}</MessageBox>}
        </dd>
      </dl>
      <dl>
        <dt>완료여부</dt>
        <dd>
          <span onClick={() => onClick(true)}>
            {form?.done ? <IoMdRadioButtonOn /> : <IoMdRadioButtonOff />}
            완료
          </span>
          <span onClick={() => onClick(false)}>
            {form?.done ? <IoMdRadioButtonOff /> : <IoMdRadioButtonOn />}
            미완료
          </span>
        </dd>
      </dl>
      <ButtonBox type="submit" color="black" width="300px">
        할일 등록
      </ButtonBox>
    </form>
  );
};

//필요한 것만
export default React.memo(TodoForm);
