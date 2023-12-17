import { IActionType } from '../../interfaces/reducers'
import useAuthContext from './index'
import { useHistory } from 'react-router-dom'
import { AUTH_ROUTES } from '../../routes/constants'
import { SESSION_STORE } from '../../constants/AuthConstants'
import { message } from 'antd'

interface IAuthState {
    user: {
        name: string | null
    }
    token: string | null
    logoutLoading?: boolean
    loginLoading?: boolean
}
export const initialState: IAuthState = {
    user: {
        name: null,
    },
    token: null,
    logoutLoading: false,
    loginLoading: false,
}
export const init = ({ user, token }: IAuthState) => ({ user, token })

export const ACTIONS = {
    SET_DATA: 'set-data',
    LOGIN_REQUEST: 'login-request',
    LOGIN_SUCCESS: 'login-success',
    LOGIN_FAILURE: 'login-failure',
    LOGOUT_REQUEST: 'logout-request',
    LOGOUT_SUCCESS: 'logout-success',
}

export function AuthReducer(state: IAuthState, action: IActionType) {
    switch (action.type) {
        case ACTIONS.SET_DATA:
            return { ...state, ...action.payload }
        case ACTIONS.LOGIN_REQUEST:
            return { ...state, loginLoading: true }
        case ACTIONS.LOGIN_SUCCESS:
            return { ...state, ...action.payload, loginLoading: true }
        case ACTIONS.LOGIN_FAILURE:
            return { ...state, loginLoading: false }
        case ACTIONS.LOGOUT_REQUEST:
            return { ...state, logoutLoading: true }
        case ACTIONS.LOGOUT_SUCCESS:
            return { user: {}, token: null, logoutLoading: false }
        default:
            return initialState
    }
}

export default function useAuthReducer() {
    const { state, dispatch } = useAuthContext()
    const history = useHistory()

    const login = ({ username, remember }: { username: string; remember: boolean }) => {
        try {
            dispatch({ type: ACTIONS.LOGIN_REQUEST })
            const sessionData: IAuthState = {
                user: { name: username },
                token: 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE3MjYyMzkwMjJ9.ivKw7Q7Zwf1MNsqfRdFSU7xXPRwvN-si2awK321kaw4',
            }
            if (remember) localStorage.setItem(SESSION_STORE, JSON.stringify(sessionData))
            else sessionStorage.setItem(SESSION_STORE, JSON.stringify(sessionData))
            dispatch({ type: ACTIONS.LOGIN_SUCCESS, payload: sessionData })
        } catch (e) {
            //message.error(e)
            dispatch({ type: ACTIONS.LOGIN_FAILURE })
        }
    }

    const logout = () => {
        dispatch({ type: ACTIONS.LOGOUT_REQUEST })
        localStorage.removeItem(SESSION_STORE)
        sessionStorage.removeItem(SESSION_STORE)
        history.push(AUTH_ROUTES.LOGIN)
        dispatch({ type: ACTIONS.LOGOUT_SUCCESS })
    }

    return { state, methods: { login, logout } }
}
