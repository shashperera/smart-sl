import {IActionType} from "../../interfaces/reducers";
import useUserContext from './index'
import {fetchUsers} from "../../network/Users";
interface IUserState {
    users: any | [],

}

export const initialState: IUserState = {
    users:[],
}

export const init = ({users}: IUserState) => ({users})

export const ACTIONS = {
    SET_DATA: 'set-data',
    FETCH_USERS: 'fetch-users',
    FETCH_USERS_SUCCESS: 'fetch-users-success',
    FETCH_USERS_FAILURE: 'fetch-users-failure'
}

export function UserReducer(state: IUserState, action: IActionType) {
    switch (action.type) {
        case ACTIONS.SET_DATA:
            return {...state, ...action.payload}
        case ACTIONS.FETCH_USERS:
            return {...state, ...action.payload}
        case ACTIONS.FETCH_USERS_SUCCESS:
            return {...state, ...action.payload}
    }
}

export default function useUserReducer() {
    const {state, dispatch} = useUserContext();

    const getUsers = (pages: object) => {
         fetchUsers(pages).then(response => {
             return dispatch({type: ACTIONS.FETCH_USERS_SUCCESS, payload: {users: response.data}});
         }).catch(error => {
             console.log('error', error);
             return dispatch({type: ACTIONS.FETCH_USERS_FAILURE, payload: error.message})
         });
    }

    return { state, methods: { getUsers } }
}
