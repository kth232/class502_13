import { useState } from 'react';

const Profile = () => {
  const [data, setData] = useState({
    name: 'kim',
    age: 40,
  });

  const changeProfile = () => {
    /*
      data.name = 'lee'; //주소값이 같기 때문에 변경x
      data.age = 30;
      console.log(data);
      setData({name: 'lee', age: '30'}); //새로운 객체 생성->변경o
      setData({...data, name: 'lee'}); //일부만 변경
    */
    setData((state) => {
      //함수형 업데이트
      console.log('previous value: ', state);
      return { ...data, name: 'lee' };
    });
  };

  const { name, age } = data;
  return (
    <>
      <h1>{name}</h1>
      <h2>{age}</h2>
      <button type="button" onClick={changeProfile}>
        change
      </button>
    </>
  );
};

export default Profile;
