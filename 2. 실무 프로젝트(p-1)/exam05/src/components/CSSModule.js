import styles from './CSSModule.module.scss';
import { useState } from 'react';
import classNames from 'classnames/bind';

const cx= classNames.bind(styles); //bind로 this의 범위를 바꿔서 새로운 함수를 만듦

const CSSModule = () => {
  const [visible, setVisible] = useState(false);

  return (
    <>
      <div className={styles.wrapper}>
        <span className="commonColor">안녕하세요</span>!!
        <span className={styles.highlight}>반갑습니다.</span>
      </div>
      <div className={cx('menus', ['cls1', 'cls2'], { on: visible })}>
        menu
      </div>
      <button type="button" onClick={() => setVisible(!visible)}>
        click
      </button>
    </>
  ); //조건부 클래스 CSS 적용
};

export default CSSModule;
