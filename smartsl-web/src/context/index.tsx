import React from 'react'
import { AuthContextProvider } from './AuthContext'
import { UserContextProvider} from "./UserContext";
import { AppContainerProvider } from './AppContainer'

type StoreProps = {
    children: JSX.Element
}
export default function Store({ children }: StoreProps) {
    return (
        <AuthContextProvider>
            <AppContainerProvider>
                <UserContextProvider>{children}</UserContextProvider>
            </AppContainerProvider>
        </AuthContextProvider>
    )
}
