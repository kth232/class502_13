const todo = {
  id: 0,
  data: [], //schedule data
  tpl: "", //스케줄 목록 템플릿 HTML
  parser: null,
  init() {
    //스케줄 목록 템플릿 가져오기
    const tplEl = document.getElementById("tpl");
    this.tpl = tplEl.innerHTML;
    this.parser = new DOMParser(); //parse, parser: 변환

    //저장값 조회->스케줄 완성
    // 처음 DOM 로딩 완료 후 실행될 메서드 - localStorage 저장된 데이터 조회, li 태그 완료
    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : [];
    this.data = todos; //local storage에서 가져옴
    this.id = todos.lenght; // 기존 요소에서 1 더해서 추가

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
    const itemsEl = document.querySelector(".items");
    const liEl = this.getItem(subject);
    itemsEl.appendChild(liEl);

    frmRegist.subject.value = "";
    frmRegist.subject.focus();

    const { data } = this; //비구조화 할당
    let id = this.id;
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
    let html = this.tpl; // 처음 하나만 체크하고 치환되기 때문에 정규표현식으로 모두 선택
    html = html.replace(/#subject/g, subject).replace(/#id/g, ++this.id); //메서드 체이닝
    const dom = this.parser.parseFromString(html, "text/html");
    const liEl = dom.querySelector("li");
    const buttonEl = liEl.querySelector("button");
    buttonEl.addEventListener("click", function () {
      const itemsEl = document.querySelector(".items");
      itemsEl.removeChild(liEl);

    //local 스토리지에 저장된 데이터도 삭제
    const id = Number(liEl.dataset.id);
    const index = todo.data.findIndex((item) => item.id === id);
      if (index !== -1) {
        todo.data.splice(index, 1);
        todo.save();
      }
    });

    return liEl;
  },
};

window.addEventListener("DOMContentLoaded", function () {
  todo.init(); //데이터 조회 및 완성. DOM이 완성된 후 선택 가능

  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();

    todo.add(); //schedule add
  });
});
