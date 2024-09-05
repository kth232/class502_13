'use client'; //서버사이드 렌더링 시 사용
import React, { useState, useRef, useCallback, useEffect } from 'react';
import TodoForm from '../components/TodoForm';
import TodoList from '../components/TodoLIst';

//컴포넌트 밖에 있으면 다시 만들어지지 않음-> 성능상 이점, 하지만 번거로워서 잘 사용하진 않음

//데이터 처리는 모두 컨테이너 컴포넌트에서!
const TodoContainer = () => {
  const [items, setItems] = useState([
    // {
    //   id: 1,
    //   title: 'todo1',
    //   content: 'content1',
    //   done: true,
    // },
    // {
    //   id: 2,
    //   title: 'todo2',
    //   content: 'content2',
    //   done: false,
    // },
    // {
    //   id: 3,
    //   title: 'todo3',
    //   content: 'content3',
    //   done: false,
    // },
  ]);
  //useState로 상태값, 상태변경 함수, 기본값 정의
  const [form, setForm] = useState({});
  const [errors, setErrors] = useState({}); //변화감지 값에 따라 렌더링

  const titleRef = useRef(); //useRef: dom을 선택하기 위해 사용
  /*
  useEffect(() => {
    // if (titleRef) {
    //   titleRef.current.focus();
    // }
    console.log("useEffect() call")
    return () => {
      console.log("뒷정리 함수-2번째부터 처음 호출<-정리 작업")
    }
  }, [form]); //최초에 한번, 변화기준 값이 바꼈을 때 호출
  //ex) 검색 창에서 검색할 때
  */
  useEffect(() => {
    if (titleRef) {
      titleRef.current.focus();
    }
  }, [titleRef]);

  const onToggle = useCallback((id) => {
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
  }, []);

  const onRemove = useCallback((id) => {
    //filter 메서드, 해당 id만 골라서 걸러줌 -> 해당 id 제외한 새로운 객체 생성
    setItems((items) => items.filter((item) => item.id !== id));
  }, []);

  const onChange = useCallback((e) => {
    /**이벤트 객체의 중요한 속성 2가지
     * e.target: 이벤트가 발생한 요소
     * e.currentTarget: 이벤트가 바인딩된 요소, 중첩된 경우 안쪽 요소
     */
    const name = e.target.name;
    const value = e.target.value;
    setForm((form) => ({ ...form, [name]: value })); //전개연산자
  }, []); //함수 호출 시 현재 상태값을 넘겨주기 때문에 변화감지 값을 안넣어줘도 됨, uesCallback 사용 시 함수 형태로 매개변수를 넣어주는 것이 성능상 유리함
  //직접 입력하는 경우는 변화감지 값을 넣어줘야 하는데 그러면 매번 새로운 객체를 만들게 됨

  const onClick = useCallback((done) => {
    setForm((form) => ({ ...form, done }));
  }, []); //속성명, 변수명 동일하게 하면 같은 걸로 인식

  //이벤트 객체가 넘어옴
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault(); // 양식 기본 동작 차단
      // console.log(form);
      //검증
      const _errors = {};
      let hasErrors = false;

      //항목이 많을 때는 모아서 작성하는 것이 좋다
      const requiredFields = {
        title: '제목을 입력하세요',
        content: '내용을 입력하세요',
      };

      //키/값 쌍으로 가져옴
      for (const [field, message] of Object.entries(requiredFields)) {
        if (!form[field] || !form[field].trim()) {
          _errors[field] = _errors[field] ?? [];
          _errors[field].push(message);
          hasErrors = true;
        }
      }
      setErrors(_errors);

      if (hasErrors) { //검증 실패
        return;
      }

      //일정 등록 처리
      //다음 번호 구하기, max 메서드는 값을 순서대로 넣어야 함
      //매개변수가 3개짜리기 때문에 전개연산자를 사용해서 배열 펼침
      const nextId = items ? Math.max(...items.map((item) => item.id)) + 1 : 1;
      setItems((items) => items.concat({ ...form, id: nextId }));

      //양식 초기화
      setForm({});
      titleRef.current.focus();
    },
    [form, items], //변화감지 값 필요
  );

  //return에는 출력값만 정의
  //이벤트 처리함수도 넘겨줌
  return (
    <>
      <TodoForm
        onSubmit={onSubmit}
        onChange={onChange}
        onClick={onClick}
        form={form}
        titleRef={titleRef}
        errors={errors}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

//객체가 계속 다시 만들어짐, 변화감지 값이 바뀌지 않으면 다시 만들지 않게 useCallback으로 감싸야 함
export default React.memo(TodoContainer);
