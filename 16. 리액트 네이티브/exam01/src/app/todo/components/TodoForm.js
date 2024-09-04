import React from 'react';
import { IoMdRadioButtonOff, IoMdRadioButtonOn } from 'react-icons/io';

//창이 이동하는 형식으로 제출, 폼 내에서 검증도 함
//onchange 이벤트로 입력값 확인, name은 필드명과 동일하게 할 것
const TodoForm = ({ onSubmit, onChange }) => {
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <dl>
        <dt>할일</dt>
        <dd>
          <input type="text" name="title" onChange={onChange} />
        </dd>
      </dl>
      <dl>
        <dt>내용</dt>
        <dd>
          <textarea name="content" onChange={onChange}></textarea>
        </dd>
      </dl>
      <dl>
        <dt>완료여부</dt>
        <dd>
          <span>
            <IoMdRadioButtonOff />
            완료
          </span>
          <span>
            <IoMdRadioButtonOff />
            미완료
          </span>
        </dd>
      </dl>
      <button type="submit">할일 등록</button>
    </form>
  );
};

export default TodoForm;
