import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home.js'
import GroupList from './components/GroupList.js'
import GroupEdit from './components/GroupEdit.js'
import AppNavbar from './components/AppNavbar';

function App() {
  return (
    <>
    <AppNavbar/>
      <Router>
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/groups" element={<GroupList />} />
          <Route path='/groups/:id' element={<GroupEdit/>}/>
        </Routes>
      </Router>
    </>
  );
}

export default App;
