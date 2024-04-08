import React, { useState, useCallback, useMemo } from 'react';

function getAverage(nums) {
  // total / 개수
  const total = nums.reduce((acc, num) => {
    acc += num;
    return acc;
  }, 0); //초기값 0, 반환값 누적되는 형태

  let avg = total / nums.length;
  avg = Math.round(avg * 10) / 10; // 소수점 첫째자리까지 표기(반올림)

  return avg;
} //평균 구하는 함수

const Average = () => {
  const [nums, setNums] = useState([]);
  const [num, setNum] = useState('');

  const onChange = useCallback(
    (e) =>
      setNum(
        Number(e.currentTarget.value) !== NaN
          ? Number(e.currentTarget.value)
          : 0,
      ),
    [],
  );

  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      setNums((nums) => nums.concat(num));
    },
    [num],
  );

  //const avg = getAverage(nums);
  const avg = useMemo(() => getAverage(nums), [nums]); //nums의 값이 변경될 때만 호출, 다른 때는 x
  return (
    <>
      <form autoComplete="off" onSubmit={onSubmit}>
        <input type="number" value={num} onChange={onChange}></input>
        <button type="submit">registration</button>
      </form>
      <ul>
        {nums.map((num, i) => (
          <li key={i}>{num}</li>
        ))}
      </ul>
      평균: {avg}
    </>
  );
};

export default React.memo(Average); //자식 컴포넌트에 변경이 없으면 기존 것 사용하도록
