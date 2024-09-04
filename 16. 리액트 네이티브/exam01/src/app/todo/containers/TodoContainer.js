'use client'; //서버사이드 렌더링 시 사용
import React, { useState } from 'react';
import TodoForm from '../components/TodoForm';
import TodoList from '../components/TodoLIst';

const TodoContainer = () => {
  const [items, setItems] = useState([
    {
      id: 1,
      title: 'todo1',
      done: true,
    },
    {
      id: 2,
      title: 'todo2',
      done: false,
    },
    {
      id: 3,
      title: 'todo3',
      done: false,
    },
  ]);
  //useState로 상태값, 상태변경 함수, 기본값 정의

  const onToggle = (id) => {
    /*
    //값 대입
    const newItems = items.map((item) =>
      id === item.id ? { ...item, done: !item.done } : item,
    );
    
    //함수 사용
    setItems((prev) =>
      prev.map((item) =>
        item.id === id ? { ...item, done: !item.done } : item,
      ),
    ); //이전상태값이 첫번째 매개변수로 들어옴
    */

    //immer로 불변성 유지
    setItems(
      produce((draft) => {
        draft
          .filter((item) => item.id === id)
          .forEach((item) => {
            item.done = !item.done;
          });
      }),
    );

    // items.forEach((item) => {
    //   if (id === item.id) {
    //     item.done = !item.done;
    //   }
    // });
    // console.log(items); //내부 값만 변경 시 변화감지 못함->새로운 객체로 만들어줘야 함
    // setItems(items);
  };

  const onRemove = (id) => {
    //filter 메서드, 해당 id만 골라서 걸러줌 -> 해당 id 제외한 새로운 객체 생성
    setItems((items) => items.filter((item) => item.id !== id));
  };

  //이벤트 객체가 넘어옴
  const onSubmit = (e) => {
    e.preventDefault(); // 양식 기본 동작 차단
  };

  //return에는 출력값만 정의
  //이벤트 처리함수도 넘겨줌
  return (
    <>
      <TodoForm onSubmit={onSubmit}/>
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

export default TodoContainer;
