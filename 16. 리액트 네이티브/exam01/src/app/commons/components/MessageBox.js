export default function MessageBox({ children }) {
  const messages = Array.isArray(children) ? children : [children];
  //배열인지 아닌지 체크, instanceof 연산자를 사용해도 됨

  return (
    <>
      {messages &&
        messages.length > 0 &&
        messages.map((m) => <div key={m}>{m}</div>)}
    </>
  );
}
