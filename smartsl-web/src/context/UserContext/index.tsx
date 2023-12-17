import {createContext, useContext, useReducer, useEffect} from "react";
import {ACTIONS, UserReducer, init, initialState} from "./UserReducer";

interface IUserContext {
    state: typeof initialState,
    dispatch: Function
}

const UserContext = createContext<IUserContext>({} as IUserContext)

export default () => {return useContext(UserContext);}

type UserContextProps = {
    children: JSX.Element
}

export function UserContextProvider({children}: UserContextProps): JSX.Element {
    const [state, dispatch] = useReducer(UserReducer, initialState, init);
    const UserContextValue: IUserContext = {state, dispatch}

    useEffect(() => {

    },[])

    return <UserContext.Provider value={UserContextValue} children={children} />
}
