export default function MemberLayout({ children }) {
  return (
    <>
      <h1>회원 전용 레이아웃</h1>
      {children}
      <h1>회원 전용 하단 레이아웃</h1>
    </>
  );
}
