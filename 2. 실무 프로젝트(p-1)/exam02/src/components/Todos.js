import { MdOutlineCheckBoxOutlineBlank, MdCheckBox } from "react-icons/md";

const items = [
  { id: 1, title: 'to do1', done: false },
  { id: 2, title: 'to do2', done: true },
  { id: 3, title: 'to do3', done: false },
];

const Todos = () => {
  //const listItems = items.map((item)=> <li>{item.title}</li>);

  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id}>
            {done ? <MdCheckBox />: <MdOutlineCheckBoxOutlineBlank/>}
            {title}</li>
      ))}
    </ul>
  ); // 빠르게 DOM을 찾기 위함, 비구조화 할당
};
/*
    (
        <ul>
            {items.map((item => <li>{item.title}</li>))}
        </ul>
    );
};
*/
export default Todos;
