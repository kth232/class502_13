const BoardView = ({ params }) => {
  console.log("props", params);
  //next.js는 브라우저 콘솔 창이 아닌 터미널에 로그 출력됨
  const {seq} = params;
  return (
    <>
      <h1>게시글 보기</h1>
      <h1>게시글 번호: {seq}</h1>
    </>
  );
};

export default BoardView;
