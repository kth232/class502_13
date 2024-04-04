import { useState, useEffect, useRef} from 'react';

const JoinForm = () => {
    const [form, setForm] = useState({}); 

    let userIdEl=useRef();
    //let userIdEl;

    useEffect(()=>{
      //userIdEl.focus();
      //console.log(userIdEl.current);
      //userIdEl.current.focus();
      console.log(userIdEl.current);
    }, [userIdEl]);


  /* 변수가 많아지면 일일히 생성하기 어려움, 한번에 생성하는 게 편함
  const [userId, setUserId] = useState('');
  const [userPw, setUserPw] = useState('');

  // 현재 키보드 입력값 가져오는 함수, 
  const onUserIdChange = (e) => {
    setUserId(e.currentTarget.value);
  };
  const onUserPwChange = (e) => {
    setUserPw(e.currentTarget.value);
  };
  */
  const onChange = (e) => {
    //e.currentTaraget ===this, document 객체
    //form[e.currentTaraget.name]: e.currentTarget.value});
    //setform({...form, [e.curretTarget.name]: e.currentTarget.value});
    const name = e.currentTarget.name;
    const value = e.currentTarget.value;

    setForm((prevForm) => ({
      ...prevForm,
      [name]: value,
    }));
  }; //이전 값과 주소값만 비교!, 다른 양식 객체 생성, 변화 감지 가능, 입력할 때마다 렌더링함, 즉시 값 업데이트

  const onSubmit = (e) => {
    e.preventDefault(); //처리 완료
    setForm({}); //양식값 비워줌
  }; //기본 동작 차단(페이지 이동 막음)


  return (
    <form onSubmit={onSubmit}>
      <dl>
        <dt>ID</dt>
        <dd>
          <input
            type="text"
            name="userId"
            placeholder="ID"
            onChange={onChange}
            value={form.userId ?? ''}
            // ref={(ref)=>(userIdEl=ref)}
            ref={userIdEl}
          />
        </dd>
      </dl>
      <dl>
        <dt>Password</dt>
        <dd>
          <input
            type="password"
            name="userPw"
            placeholder="PW"
            onChange={onChange}
            value={form.userPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>PASSWORD CONFIRM</dt>
        <dd>
          <input
            type="password"
            name="confirmPw"
            placeholder="PW CONFIRM"
            onChange={onChange}
            value={form.confirmPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>USER NAME</dt>
        <dd>
          <input
            type="text"
            name="userNm"
            placeholder="USER NAME"
            onChange={onChange}
            value={form.userNm ?? ''}
          />
        </dd>
      </dl>
      <button type="submit">SIGN UP</button>
    </form>
  ); /* id값, 선택자 없어도 됨*/
};

export default JoinForm;
