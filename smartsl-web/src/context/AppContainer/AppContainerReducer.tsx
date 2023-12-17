import useAppContext from '../../context/AppContainer'
import { IActionType } from '../../interfaces/reducers'

export const initState = {
    alerts: [],
    loading: false,
}

export function initializeState(state: typeof initState): typeof initState {
    return {
        alerts: state.alerts ?? [],
        loading: state.loading ?? false,
    }
}

const ACTIONS = {
    SET_DATA: 'set-data',
    SET_LOADING_TRUE: 'set-loading-true',
    SET_LOADING_FALSE: 'set-loading-false',
    RESET: 'reset',
}

export function AuthContainerReducer(state: typeof initState, action: IActionType) {
    switch (action.type) {
        case ACTIONS.SET_DATA:
            return { ...state, ...action.payload }
        case ACTIONS.SET_LOADING_TRUE:
            return { ...state, loading: true }
        case ACTIONS.SET_LOADING_FALSE:
            return { ...state, loading: false }
        case ACTIONS.RESET:
            return initializeState(initState)
        default:
            return state
    }
}

export default function useAppContainerReducer() {
    const { state, dispatch } = useAppContext()

    const setLoadingTrue = () => dispatch({ type: ACTIONS.SET_LOADING_TRUE })

    const setLoadingFalse = () => dispatch({ type: ACTIONS.SET_LOADING_FALSE })

    return {
        state,
        methods: {
            setLoadingTrue,
            setLoadingFalse,
        },
    }
}
