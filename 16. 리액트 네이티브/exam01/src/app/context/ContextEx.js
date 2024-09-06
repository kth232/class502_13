'use client';
import ContextEx2 from './ContextEx2';
import { UserProvider } from './userContext';
import ContextEx3 from './ContextEx3';

//같은 provider 내부에 있으면 값 공유됨
//병렬구조
const ContextEx = () => {
  return (
    <UserProvider>
      <ContextEx3 />
      <ContextEx2 />
    </UserProvider>
  );
};

export default ContextEx;
