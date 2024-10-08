'use client';
import React, { useState, useMemo } from 'react';

function getAverage(nums) {
    console.log('getAverage() func call')
  if (nums.length === 0) return 0;

  const total = nums.reduce((a, b) => a + b); //sum 함수가 없음=reduce 사용
  return total / nums.length;
}

const Calculator = () => {
  const [numbers, setNumbers] = useState([]);
  const [number, setNumber] = useState([]);

  const avg = useMemo(() =>getAverage(numbers), [numbers]);
  //값이 같으면 렌더링 하지 않도록 useMemo로 감싸기

  const onSubmit = (e) => {
    e.preventDefault();
    setNumbers((numbers) => numbers.concat(number));
  };

  const onChange = (e) => {
    const num = e.target.value;
    setNumber(Number(num));
  };

  return (
    <>
      <form autoComplete="off" onSubmit={onSubmit}>
        <input type="number" onChange={onChange} />
        <button type="submit">숫자 추가하기</button>
      </form>
      <ul>
        {numbers.map((n, i) => (
          <li key={i}>{n}</li>
        ))}
      </ul>
      <div>평균: {avg}</div>
    </>
  );
};

export default Calculator;
