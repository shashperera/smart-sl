import axios from "axios";
import {API} from "../constants/APIConstants";

const config = {
    baseURL: API,
    headers: {
        'Content-type': 'application/json',
        'Accept': 'application/json'
    }
}

const AuthenticatedAxiosInstance =  axios.create(config);

export const fetchUsers = async (pages: any) => {
    return await AuthenticatedAxiosInstance.get('api', {...pages});
}

