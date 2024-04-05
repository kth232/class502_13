import { FaPlus } from 'react-icons/fa6';

const AddTodo = ({ onSubmit, state, dispatch }) => {
  // 비구조화 할당

  return (
    <form onSubmit={onSubmit} autoComplete="off">
      {/**자동완성 끄기 */}
      <h3>To Do Registration</h3>
      <input
        type="text"
        value={state.todo}
        onChange={dispatch({ type: 'INPUT' })}
      />
      <button type="submit">
        <FaPlus />
      </button>
      <hr />
      <h3>To Do List</h3>
    </form>
  );
}; //카멜표기법(이벤트 관리)

export default AddTodo;
