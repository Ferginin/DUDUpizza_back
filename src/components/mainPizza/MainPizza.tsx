import './MainPizza.css'
import {useState} from "react";

export default function MainPizza(){
    const [likes, setLikes] = useState(0)
    const [inputValue, setInputValue] = useState(" ")

    function increment(){
        setLikes(likes + 1)
    }
    function decrement(){
        setLikes(likes - 1)
    }

    return (
        <div className='main__container'>
            <div className='main__container__header'>
                <h1 className='main__container__header'>{likes}</h1>
                <h1 className='main__container__header'>{inputValue}</h1>
            </div>
            <div className='main__container__body'>
                <input type='text' value={inputValue} onChange={event => setInputValue(event.target.value)}></input>
                <button onClick={increment}>Инкремент</button>
                <button onClick={decrement}>Декремент</button>
            </div>
        </div>
    )
}