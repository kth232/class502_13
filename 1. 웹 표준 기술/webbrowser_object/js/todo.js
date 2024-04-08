const todo = {
  id: 1,
  data: [], //schedule data
  init() {
    //저장값 조회->스케줄 완성
    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : [];
    const itemEl=document.querySelector('.items');
    for (const item of todos) {
      // Symbol.iterator 반복자 패턴, 반복이 필요한 객체
      const liEl=this.getItem(item.title);
      itemsEl.appendChild(liEl);
    }
  },
  /**
   * 설명용 주석
   * 스케줄 추가, 삭제
   */
  add() {
    const subject = frmRegist.subject.value; //입력값 받아오기

    if (!subject.trim()) {
      //trim(): 좌우 공백 제거
      alert("please enter what you need to do!");
      return; //할일을 입력하지 않았을 때 함수 종료, 공백은 리스트에 추가되지 않게 함
    }
    /*
    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));

    const buttonEl = document.createElement("button");
    buttonEl.appendChild(document.createTextNode("delete"));
    liEl.appendChild(buttonEl);
    */
    const itemsEl = document.querySelector(".items");
    const liEl = this.getItem(subject);
    itemsEl.appendChild(liEl);

    /*
    //schedule remove
    buttonEl.addEventListener("click", function () {
      itemsEl.removeChild(liEl);
    });
    */
    frmRegist.subject.value = "";
    frmRegist.subject.focus();

    /*
    this.data.push({
      id: this.id++,
      title: subject
    });
    */
    const { data } = this; //비구조화 할당
    let id = this.id++; //아이디 대입 후 증가시킴
    data.push({
      id,
      title: subject,
    });

    this.save();
  },
  save() {
    localStorage.setItem("todos", JSON.stringify(this.data)); //JSON문자열로 바꿔서 data 저장
  },
  getItem(subject) {
    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));

    const buttonEl = document.createElement("button");
    buttonEl.appendChild(document.createTextNode("delete"));
    liEl.appendChild(buttonEl);

    //schedule remove
    buttonEl.addEventListener("click", function () {
      const itemsEl = document.querySelector(".items");
      itemsEl.removeChild(liEl);
    });

    return liEl;
  },
};

window.addEventListener("DOMContentLoaded", function () {
  todo.init(); //데이터 조회 및 완성

  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();
    todo.add(); //schedule add
  });
});
