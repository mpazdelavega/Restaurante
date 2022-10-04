import './App.css';
import { Routes, Route } from 'react-router-dom';
import Login from './components/auth/login'
import Register from './components/auth/register'
import Client from './components/client/client'
import Home from './components/client/components/home'
import HomeMesa from './components/client/components/homeMesa'
import Detail from './components/client/components/detail'
import Cart from './components/client/components/cart'
import HeadlineCards from './components/client/components/HeadlineCards';
import Food from './components/client/components/Food';
import Footer from './components/client/components/Footer';
import Mesa from './components/client/components/Mesa';
import ReservaUsuario from './components/client/components/reservaUsuario';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="login" element={<Login />} />
      <Route path="register" element={<Register />} />
      <Route path="store" element={<Client />}>
        <Route path="" element={<><Home /><HeadlineCards/><Food/><Footer/></> } />
        <Route path="reserva" element={<><HomeMesa /><Mesa/><Footer/></> } />
        <Route path="reservas" element={<><HomeMesa /><ReservaUsuario/><Footer/></> } />
        <Route path="detail/:id/:category" element={<><Detail /><Footer/></> } />
        <Route path="cart" element={<><Cart /><Footer/></>} />
      </Route>
    </Routes>
  );
}

export default App;
