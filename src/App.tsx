import MyHeader from './components/header/MyHeader.tsx'
import './App.css'
import MainPizza from "./components/mainPizza/MainPizza.tsx";

export default function App() {
  return (
      <div className="App">
        <MyHeader/>
        <MainPizza/>
      </div>
  );
};