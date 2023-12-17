import { createContext, useContext, useReducer } from 'react'
import { AuthContainerReducer, initState, initializeState } from './AppContainerReducer'

type Props = {
    children: JSX.Element
}

interface IAppContext {
    state: typeof initState
    dispatch: Function
}

const AppContext = createContext<IAppContext>({} as IAppContext)

export default function useAppContext(): IAppContext {
    return useContext(AppContext)
}

export function AppContainerProvider({ children }: Props) {
    const [state, dispatch] = useReducer(AuthContainerReducer, initState, initializeState)

    return <AppContext.Provider value={{ state, dispatch }} children={children} />
}
