const todo = {
  /**
   * 설명용 주석
   * 스케줄 추가, 삭제
   */
  add() {
    const subject = frmRegist.subject.value; //입력값 받아오기

    if (!subject.trim()) {
      //trim(): 좌우 공백 제거
      alert("please write to do");
      return; //할일을 입력하지 않았을 때 함수 종료, 공백은 리스트에 추가되지 않게 함
    }

    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));

    const buttonEl = document.createElement("button");
    buttonEl.appendChild(document.createTextNode("delete"));
    liEl.appendChild(buttonEl);

    const itemsEl = document.querySelector(".items");
    itemsEl.appendChild(liEl);

    //schedule remove
    buttonEl.addEventListener("click", function () {
      itemsEl.removeChild(liEl);
    });

    frmRegist.subject.value = "";
    frmRegist.subject.focus();
  },
};

window.addEventListener("DOMContentLoaded", function () {
  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();
    todo.add(); //schedule add
  });
});
