import React from 'react';
import { MdCheckBoxOutlineBlank, MdCheckBox } from 'react-icons/md';
import { CiSquareRemove } from 'react-icons/ci';
import styled from 'styled-components';

//일반 컴포넌트에 styled-component를 적용할 때 className 꼭 넣어줘야 함
const ItemBox = ({ item, onToggle, onRemove, className }) => {
  const { id, title, content, done } = item;
  return (
    <li key={id} onClick={() => onToggle(id)} className={className}>
      <div>
        {done ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
        {title}
        <CiSquareRemove onClick={() => onRemove(id)} />
      </div>
      {content && <div>{content}</div>}
    </li>
  );
};

const StyledItemBox = styled(ItemBox)`
  display: flex;
  border: 1px solid #000;
  padding: 10px;
  & + & {
    margin-top: 10px;
  }
`;

//컨테이너 컴포넌트가 넘겨준 items가 매개변수로 넘어옴
//데이터 처리는 컨테이너에서 담당
const TodoList = ({ items, onToggle, onRemove }) => {
  return (
    <ul>
      {/** 조건문, 반복문 불가->배열 객체의 map 메서드 사용해서 jsx 객체로 변환
       * 변화 감지를 위해 key값(=id) 부여(중복 없는 값으로 넣어줘야 정확하게 감지함)
       */}
      {/**리액트는 체크박스, 라디오버튼 태그 사용x->이미지 처리함
       * 값 변화로 상태 감지를 해야하고 디자인 상 작업하기 어렵기 때문 */}
      {items &&
        items.length > 0 &&
        items.map((item) => (
          <StyledItemBox
            key={item.id}
            item={item}
            onToggle={onToggle}
            onRemove={onRemove}
          />
        ))}
    </ul>
  );
};

//필요한 것만
export default React.memo(TodoList);
