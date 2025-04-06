import './header.css'
import Button from "../UI/Button.tsx";

const now = new Date();

export default function myHeader(){
    return (
        <header className="myHeader">
            <Button text='DUDU PIZZA'/>
            <span>Date : { now.toLocaleTimeString() }</span>
        </header>
    )
}