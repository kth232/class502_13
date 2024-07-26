import React, {useState} from 'react';
import JoinForm from '../components/JoinForm';

//처리 담당
const JoinContainer = () => {
    const [form, setForm] = useState({});
    console.log('container', Object.getOwnPropertyDescriptor(form));
    {/*여기는 바꿀 수 있음=동결상태x */}

    return <JoinForm form={form}/>;
    {/*여기는 바꿀 수 없음=동결상태o */}
};

export default JoinContainer;