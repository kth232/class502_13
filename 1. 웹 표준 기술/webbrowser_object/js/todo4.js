const todos = {
  //스케줄 추가
  add(subject) {
    subject = subject ?? ""; //null이거나 undefined일 때만 추가
    subject = subject.trim(); //양쪽 공백 제거
    if (!subject) {
      throw new Error("스케줄을 입력하세요"); //예외 던짐
    }

    const button = document.createElement("button");
    button.append("삭제")

    const liEl = document.createElement("li");
    liEl.append(subject, button); //요소 추가

    const itemsEl = document.getElementById("items");
    itemsEl.append(liEl);

  //스케줄 삭제
    button.addEventListener("click", function() {
        if (confirm("정말 삭제하겠습니까?")) {
            liEl.remove(); //부모요소 선택 없이 삭제 가능
        }
        });
    },
};

window.addEventListener("DOMContentLoaded", function () {
  //todo.init(); //데이터 조회 및 완성. DOM이 완성된 후 선택 가능

  frmRegist.addEventListener("submit", function (e) {
    //제출되면 발생하는 이벤트
    e.preventDefault(); //폼의 기본동작 차단됨

    const todoEl = this.subject;

    try {
      todos.add(todoEl.value); //스케줄 등록

      todoEl.value = "";
    } catch (e) {
      alert(e.message);
    }
    todoEl.focus(); //예외가 발생하든 안하든 focus 발생
    /*
    //this = frmRegist //이벤트가 발생하는 폼 자체
    const subject = this.subject.value.trim();

    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));
    //append()는 가변적 형태, node객체 + string도 가능
    //appendChild()는 node객체만 가능

    const itemsEl = document.getElementById("items");
    itemsEl.appendChild(liEl);

    //todo.add(); //schedule add
    */
  });
});
