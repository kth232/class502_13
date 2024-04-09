const todo = {
  id: 1,
  data: [], //schedule data
  init() {
    //저장값 조회->스케줄 완성
    // 처음 DOM 로딩 완료 후 실행될 메서드 - localStorage 저장된 데이터 조회, li 태그 완료
    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : [];
    this.data = todos; //local storage에서 가져옴
    this.id = todos.lenght + 1; // 기존 요소에서 1 더해서 추가

    const itemsEl = document.querySelector(".items");

    for (const item of todos) {
      // Symbol.iterator 반복자 패턴, 반복이 필요한 객체
      const liEl = this.getItem(item.title);
      liEl.dataset.id = item.id;
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

    liEl.dataset.id = id; //아이디 값 확인
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

      //local storage에 저장된 데이터도 삭제, this값은 이벤트 요소의 값으로 바껴있는 상태라 사용 안됨
      const id = Number(liEl.dataset.id);
      const index = todo.data.findIndex((item) => item.id === id);
      if (index !== -1) {
        todo.data.splice(index, 1);
        todo.save();
      } //값을 찾지 못했을 때만 슬라이스로 값 잘라와서 삭제하고 변경사항 저장
    }); // 문자열 상태로 데이터 가져오기 때문에 숫자형으로 바꿔야 함

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
