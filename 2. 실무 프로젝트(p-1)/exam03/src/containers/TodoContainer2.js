import { useReducer } from 'react';
import AddTodo from '../components/AddTodo'
import TodoList from '../components/TodoLIst';

const items = [
    { id: 1, title: 'todo1', done: false },
    { id: 2, title: 'todo2', done: true },
    { id: 3, title: 'todo3', done: false },
  ];

  const todo = '';

function reducer(state, action) { //state: 현재 상태값, action-액션 발생 함수에서 넘겨준 값
    console.log(state, action);
}

const TodoContainer2 = () => {
    // state: 현재 상태값, dispatch: 액션 발생 함수
    const [state, dispatch] = useReducer(reducer, {todo, items});

    return (
        <>
            <AddTodo state={state} dispatch={dispatch}/>
            <TodoList state={state} dispatch={dispatch}/>
        </>
    );
};

export default TodoContainer2;