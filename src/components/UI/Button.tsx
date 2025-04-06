import './Button.css'

interface ButtonProps {
    text: string
}

export default function Button({text}: ButtonProps) {
    function Lolol(){
        console.log("хуй");
    }

    return (
        <button className='btn' onClick={Lolol}>
            {text}
        </button>
    )
}