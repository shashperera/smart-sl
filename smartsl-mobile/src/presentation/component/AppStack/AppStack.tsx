import 'react-native-gesture-handler';
import {createStackNavigator} from '@react-navigation/stack';
import React, {useContext} from 'react';
import {NavigationContainer} from '@react-navigation/native';
import {LoginContext} from '../../../Utils/LoginProvider';
import LoadingScreen from '../Common/LoadingScreen';
import Login from '../Login/Login';
import DrawerList from '../DrawerContent/DrawerList';
import Payment from '../Payment/Payment';

const Stack = createStackNavigator();

export default function AppStack() {
  const {user, isLoading} = useContext(LoginContext);

  return (
    <NavigationContainer>
      <Stack.Navigator>
        {isLoading ? (
          <Stack.Screen
            name="loading"
            options={{headerShown: false}}
            component={LoadingScreen}
          />
        ) : user ? (
          <><Stack.Screen
              options={{ headerShown: false }}
              name="UserDrawerList"
              component={DrawerList} />
              <Stack.Screen
                name="Payment"
                options={{ headerShown: true }}
                component={Payment} />
                </>
              
        ) : (
          <Stack.Screen
            name="EduTec"
            options={{headerShown: false}}
            component={Login}
          />
          
        )}
       

      </Stack.Navigator>
     
    </NavigationContainer>
  );
}
