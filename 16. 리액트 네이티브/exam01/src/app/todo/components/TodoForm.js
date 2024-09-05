import React from 'react';
import { IoMdRadioButtonOff, IoMdRadioButtonOn } from 'react-icons/io';
import MessageBox from '@/app/commons/components/MessageBox'; //next.js는 사용자가 만든 컴포넌트 가져올 때 경로 앞에 @붙음

//창이 이동하는 형식으로 제출, 폼 내에서 검증도 함
//onchange 이벤트로 입력값 확인, name은 필드명과 동일하게 할 것
const TodoForm = ({ onSubmit, onChange, form, onClick, titleRef, errors }) => {
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <dl>
        <dt>할일</dt>
        <dd>
          <input type="text" name="title" value={form?.title ?? ''} onChange={onChange} ref={titleRef}/>
          {errors?.title && <MessageBox>{errors.title}</MessageBox>}
          {/** ref로 dom 선택 */}
        </dd>
      </dl>
      <dl>
        <dt>내용</dt>
        <dd>
          <textarea name="content" value={form?.content ?? ''} onChange={onChange}></textarea>
          {errors?.content && <MessageBox>{errors.content}</MessageBox>}
        </dd>
      </dl>
      <dl>
        <dt>완료여부</dt>
        <dd>
          <span onClick={()=> onClick(true)}>
            {form?.done ? <IoMdRadioButtonOn/> : 
            <IoMdRadioButtonOff />}
            완료
          </span>
          <span onClick={()=> onClick(false)}>
          {form?.done ? <IoMdRadioButtonOff/> : 
            <IoMdRadioButtonOn />}
            미완료
          </span>
        </dd>
      </dl>
      <button type="submit">할일 등록</button>
    </form>
  );
};

//필요한 것만 
export default React.memo(TodoForm);
