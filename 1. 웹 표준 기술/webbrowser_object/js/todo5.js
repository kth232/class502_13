//템플릿 적용
const todos = {
  //템플릿 가져오기
  getTpl() {
    const tplEl = document.getElementById("tpl");
    return tplEl.innerHTML;
  },
  //복잡한 양식도 편하게 작성 가능
  //템플릿 가져와서 원하는 부분만 선택한 후 치환

  //스케줄 추가
  add(todo) {
    todo = todo ?? ""; //null이거나 undefined일 때만 추가
    todo = todo.trim(); //양쪽 공백 제거
    if (!todo) {
      //todo가 없을 때
      throw new Error("스케줄을 입력하세요"); //예외 던짐
    }
    let html = this.getTpl(); //템플릿 가져오기
    html = html.replace(/#todo#/g, todo); //g(global)가 있으면 치환코드 전체 치환
    //g가 없으면 가장 앞의 하나만 치환됨

    const domParser = new DOMParser(); //텍스트->DOM 객체로 변환
    const dom = domParser.parseFromString(html, "text/html");
    const liEl = dom.querySelector("li"); //li 태그 안에 button에 이벤트 부여
    //DOM 객체 중에서 li 태그만 뽑아옴

    const schedulesEl = document.getElementById("schedules");
    schedulesEl.append(liEl);

    const buttonEl = liEl.querySelector("button");
    buttonEl.addEventListener("click", function () {
      if (confirm("정말 삭제하시겠습니까?")) {
        liEl.remove(); //부모요소 선택 없이 삭제 가능
      }
    });
  },
};

window.addEventListener("DOMContentLoaded", function () {
  frmTodo.addEventListener("submit", function (e) {
    //제출은 페이지를 이동하면서 데이터 전달 -> 기본 동작
    //페이지 이동 시 동적 작업 불가->기본 동작을 차단해야함
    e.preventDefault(); //기본 동작 차단

    const todoEl = this.todo;

    try {
      todos.add(todoEl.value);

      todoEl.value = ""; //요소 추가 후 입력칸 값 비우기
    } catch (err) {
      alert(err.message); //에러 발생 시 메세지 알림
    }

    todoEl.focus();
  });
});
