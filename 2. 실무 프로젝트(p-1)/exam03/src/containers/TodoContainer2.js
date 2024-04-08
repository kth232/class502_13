import { useState, useReducer, useRef, useCallback } from 'react';
import AddTodo from '../components/AddTodo2';
import TodoList from '../components/TodoLIst2';

const initialValue = [
  { id: 1, title: 'todo1', done: false },
  { id: 2, title: 'todo2', done: true },
  { id: 3, title: 'todo3', done: false },
];

function reducer(items, action) {
  switch (action.type) {
    case 'ADD':
      return items.concat(action.todo);
    case 'TOGGLE':
      return items.map((item) =>
        item.id === action.id ? { ...item, done: !item.done } : item,
      );
    case 'REMOVE':
      return items.filter((item) => item.id !== action.id);
  }
  return items;
}

const TodoContainer = () => {
  //업데이트 시 매번 호출
  const [items, dispatch] = useReducer(reducer, initialValue);
  //const [items, setItems] = useState(initialValue);
  const [todo, setTodo] = useState('');
  const { message, setMessage } = useState('');

  let id = useRef(4); //할일 id, 기본값 4

  //할일 등록 처리
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault(); // 기본 동작 차단, 현재 페이지에서 동작하도록

      if (!todo.trim()) {
        setMessage('please enter what you need to do');
        return;
      } //값이 없으면 경고, return으로 함수 종료

      /*
    setItems((prevItems)=> {
      return prevItems.concat({
        id: id.current,
        title: todo.trim(),
        done: false,
      });
    }); //주소값만 비교, 새로운 객체로 만들어서 반환, 할일 추가할 때 공백 제거
    */

      dispatch({
        type: 'ADD',
        todo: {
          id: id.current,
          title: todo,
          done: false,
        },
      }); //임의로 타입 설정

      id.current++; //현재 id에서 증가

      setTodo(''); //입력칸에 이전 입력값 비워주기
      setMessage('');
    },
    [todo],
  );

  //할일 입력 시 todo 상태값 변경
  const onChange = useCallback((e) => setTodo(e.currentTarget.value), []); //키보드 입력할 때마다 값 담아주기

  // 할일 목록 완료 여부 토글(true -> false, false -> true)
  const onToggle = useCallback((id) => {
    dispatch({ type: 'TOGGLE'.id });
    /*
    const newItems = items.map((item) =>
      item.id === id ? { ...item, done: !item.done } : item,
    );

    setItems(newItems); // 값을 대입하는 방식은 최초 생성 시 값이 고정되어버림


        setItems((prevItems) => {
      return prevItems.map((item) =>
        item.id === id ? { ...item, done: !item.done } : item,
      );
    });
    */
  }, []); //함수형 업데이트, 내부에서 최신 상태값을 매개변수로 넣어 호출해주기 때문에 변화감지할 필요없음, 호출할 때마다 값을 넣어줌, 낭비x

  //할일 목록 제거
  const onRemove = useCallback((id) => {
    dispatch({ type: 'REMOVE', id });
    /*
    const newItems = items.filter((item) => item.id !== id);
    setItems(newItems);


    setItems((prevItems) => {
      return prevItems.filter((item) => item.id !== id);
    });
    */
  }, []);

  return (
    <>
      <AddTodo
        onSubmit={onSubmit}
        onChange={onChange}
        todo={todo}
        message={message}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
      {/* 속성으로 프레젠테이션 컴포넌트에 값 넘겨줌, 문자열 외에는 {} 안에 입력*/}
    </>
  );
};
//데이터 처리, 이벤트 처리는 컨테이너에서..

export default TodoContainer;
