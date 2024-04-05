import { MdCheckBox, MdCheckBoxOutlineBlank } from 'react-icons/md';
import { FaTrashCan } from 'react-icons/fa6';

const TodoList = ({ items, onToggle, onRemove }) => {
  return (
    <ol>
      {items.map(({ id, title, done }) => (
        <li key={id}>
          <span onClick={() => onToggle(id)}>
            {done ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
            {title}
          </span>
          <button type="button" onClick={() => onRemove(id)}>
            <FaTrashCan />
          </button>
        </li>
      ))}
    </ol>
  );
};
/**비구조 할당, 기본 스타일(체크박스)은 안예뻐서 잘 안씀, 디자인은 보통 이미지 사용
 * 토글 기능을 span 태그에 넣어줌
 */

export default TodoList;
