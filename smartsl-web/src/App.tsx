import React, { FC } from 'react'
import Router from './routes'
import Store from './context'
import './App.scss'

const App: FC = () => {
    return (
        <Store>
            <Router />
        </Store>
    )
}

export default App
