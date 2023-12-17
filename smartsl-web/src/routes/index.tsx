import React from 'react'
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom'
import { Home, Login } from '../pages'
import Trips from '../pages/Trips'
import Passengers from "../pages/Passengers";
import Routes from "../pages/Routes";
import Reports from '../pages/Reports';
import Vehicles from '../pages/Vehicles';
import Timetables from '../pages/Timetable';


import { isEmpty } from 'lodash'
import { AUTH_ROUTES, HOME_ROUTE, TRIPS_ROUTE, PASSENGERS_ROUTE, REPORTS_ROUTE, ROUTES_ROUTE,TIMETABLES_ROUTE, VEHICLES_ROUTE } from './constants'
import AppContainer from '../components/AppContainer'
import useAuthReducer from '../context/AuthContext/AuthReducer'

type PrivateRouteProps = {
    path: string
    component: any
}
function PrivateRoute({ component: Component, path }: PrivateRouteProps) {
    const { state: AuthState } = useAuthReducer()

    if (!isEmpty(AuthState.token)) return <Route exact path={path} render={props => <Component {...props} />} />
    else return <Redirect to={AUTH_ROUTES.LOGIN} />
}

export default function Router(): JSX.Element {
    return (
        <BrowserRouter>
            <Switch>
                <Redirect exact path={`/`} to={`/home`} />
                <Route exact path={AUTH_ROUTES.LOGIN} component={Login} />
                <AppContainer>
                    <Switch>
                        <PrivateRoute path={HOME_ROUTE} component={Home} />
                        <PrivateRoute path={TRIPS_ROUTE} component={Trips} />
                        <PrivateRoute path={PASSENGERS_ROUTE} component={Passengers} />
                        <PrivateRoute path={TIMETABLES_ROUTE} component={Timetables} />
                        <PrivateRoute path={REPORTS_ROUTE} component={Reports} />
                        <PrivateRoute path={VEHICLES_ROUTE} component={Vehicles} />
                        <PrivateRoute path={ROUTES_ROUTE} component={Routes} />
                    </Switch>
                </AppContainer>
            </Switch>
        </BrowserRouter>
    )
}
