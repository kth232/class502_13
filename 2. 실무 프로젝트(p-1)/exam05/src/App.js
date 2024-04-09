import { Routes, Route } from 'react-router-dom';
import loadable from '@loadable/component';
/*
import Home from './pages/Home';
import About from './pages/About';
import Board from './pages/Board';
import BoardList from './pages/BoardList';
import MainLayout from './layouts/MainLayout';
import NotFound from './pages/NotFound';
*/
const Home = loadable(()=>import('./pages/Home'));  //지연 로딩
const About = loadable(()=>import('./pages/About'));
const BoardList = loadable(()=>import('./pages/BoardList'));
const MainLayout = loadable(()=>import('./layouts/MainLayout'));
const NotFound = loadable(()=>import('./pages/NotFound'));

const App = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        {/* 메인 주소, path="/"는 없어도 됨 */}
        <Route index element={<Home />} />
        {/* index는 path="/"와 비슷한 기능, 상위 라우트 주소와 동일하는 의미 */}
        <Route path="about" element={<About />} /> {/* /about */}
        <Route path="board" element={<BoardList />} /> {/* /board */}
        <Route path="*" element={<NotFound />} /> {/* 모든 페이지를 탐색한 후 없는 경우 */}
      </Route>

      {/*
      <Route index element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/board" element={<BoardList />}>
        <Route path="view/:id" element={<Board />} />  // /board/view/:id
      </Route>
      */}
    </Routes>
  );
}; // 경로 변수, 여러개 만들 수 있음(/:명칭/:명칭...)
// 중첩 라우트: 라우트 안에 라우트가 있는 것, 공통 레이아웃 표현
// 주소에 /만 있으면 메인 주소

export default App;
