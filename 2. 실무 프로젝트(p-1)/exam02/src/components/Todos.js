import { useState } from 'react';
import { MdOutlineCheckBoxOutlineBlank, MdCheckBox } from 'react-icons/md';

const initialValue = [
  { id: 1, title: 'to do1', done: false },
  { id: 2, title: 'to do2', done: true },
  { id: 3, title: 'to do3', done: false },
];

const Todos = () => {
  //const listItems = items.map((item)=> <li>{item.title}</li>);

  const [items, setItems] = useState(initialValue);

  const onToggle = (id) => {
    const newItems = items.map((item) =>
      item.id === id ? { ...item, done: !item.done } : item,
    ); //id가 같으면 done 값만 바꿔주고 아니면 item 대입
    setItems(newItems);
  };

  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id} onClick={() => onToggle(id)}>
          {done ? <MdCheckBox /> : <MdOutlineCheckBoxOutlineBlank />}
          {title}
        </li>
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
