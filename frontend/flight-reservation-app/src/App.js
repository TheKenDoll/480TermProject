import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './Layout.js';
import Landing from './components/Login/Landing.js';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Landing />} />
          </Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
