import './App.css'
import { NavigationBar } from './layouts/navigation-bars/NavigationBar.tsx';
import { HomePage } from './layouts/home-page/HomePage.tsx';
import { Footer } from './layouts/navigation-bars/Footer.tsx';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
      <>
          <NavigationBar />
          <Routes>
              <Route path="/" element={<HomePage/>} />
          </Routes>
          <Footer />
      </>
  )
}

export default App
