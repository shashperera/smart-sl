import { createContext, useContext, useReducer, useEffect } from 'react'
import { ACTIONS, AuthReducer, init, initialState } from './AuthReducer'
import { isEmpty } from 'lodash'
import { SESSION_STORE } from '../../constants/AuthConstants'

interface IAuthContext {
    state: typeof initialState
    dispatch: Function
}
const AuthContext = createContext<IAuthContext>({} as IAuthContext)

export default function useAuthContext(): IAuthContext {
    return useContext(AuthContext)
}

type AuthContextProps = {
    children: JSX.Element
}
export function AuthContextProvider({ children }: AuthContextProps): JSX.Element {
    const [state, dispatch] = useReducer(AuthReducer, initialState, init)
    const AuthContextValue: IAuthContext = { state, dispatch }

    useEffect(() => {
        if (isEmpty(state.token)) {
            let data = localStorage.getItem(SESSION_STORE)
            if (isEmpty(data)) data = sessionStorage.getItem(SESSION_STORE)
            if (!isEmpty(data)) if (data != null) dispatch({ type: ACTIONS.SET_DATA, payload: JSON.parse(data) })
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [])

    return <AuthContext.Provider value={AuthContextValue} children={children} />
}
