'use client';

import React, { useState } from 'react';
import loadable from '@loadable/component';

const Content = loadable(() => import('./Content'), {fallback: <div>loading...</div>});
//로딩해오는 중일 때 보여줄 수 있음

const LoadableEx = () => {
  const [visible, setVisible] = useState(false);

  return (
    <>
      {visible && <Content />}
      <button type="button" onClick={() => setVisible(!visible)}>
        보이기
      </button>
    </>
  );
};

export default LoadableEx;
