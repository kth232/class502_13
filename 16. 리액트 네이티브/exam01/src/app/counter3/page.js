import Counter from "../Counter";

export const metadata = {
    title: '카운터',
};

const CounterePage = () => {
return <Counter />
};
//page 컴포넌트는 ssr로 실행됨

export default CounterePage;