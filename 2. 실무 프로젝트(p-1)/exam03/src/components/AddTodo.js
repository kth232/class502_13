import { useEffect } from 'react';
import { FaPlus } from 'react-icons/fa6';

const AddTodo = ({ onSubmit, onChange, todo, message }) => {
  // 비구조화 할당
  useEffect(() => {
    //componentDidMount(), componentDidupdate() -todo값의 변화에 의한 렌더링
    console.log('todo value change->output after rendering');

    return () => {
      console.log('function of cleanup../update');
    };
  }, [todo, message]); // [...] 변화감지 기준

  useEffect(() => {
    console.log('one call when mount'); // componentDidMount()
  }, []); // DOMContentLoaded와 비슷(동일x)

  /*
  useEffect(()=> { //componentDidMount(), componentDidupdate() -message값의 변화에 의한 렌더링
    console.log('message value change');
  }, [message]);
  */
  return (
    <form onSubmit={onSubmit} autoComplete="off">
      {/**자동완성 끄기 */}
      <h3>To Do Registration</h3>
      <input type="text" value={todo ?? ''} onChange={onChange} />
      {/**입력칸에 값 비워주기, 기본값 빈칸 설정*/}
      <button type="submit">
        <FaPlus />
      </button>
      {message && <div>{message}</div>}

      <hr />
      <h3>To Do List</h3>
    </form>
  );
}; //카멜표기법(이벤트 관리)

export default AddTodo;
