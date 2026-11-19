import './App.css'
import { NavigationBar } from './layouts/navigation-bars/NavigationBar.tsx';
import { TopBooks } from './layouts/home-page/TopBooks.tsx';
import { Carousel } from './layouts/home-page/Carousel.tsx';

function App() {
  return (
      <>
          <NavigationBar />
          <TopBooks />
          <Carousel />
      </>
  )
}

export default App
