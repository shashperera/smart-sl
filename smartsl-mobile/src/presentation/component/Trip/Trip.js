import React, {Component, useContext} from 'react';
import { View } from 'react-native';
import styles from './Trip.component.style';
import FirebaseUtil from '../../../Utils/FirebaseUtil';
import TripComponent from './TripComponent';

function Trip({navigation}) { 

    signOut = () => {
        FirebaseUtil.signOut().catch((e) => {
            console.log(e);
            alert("Something went wrong");
        });
    }


        return (
            <View style = {styles.container}>
                <TripComponent  
                signOut = {this.signOut}
                navigation={navigation}
                />

            </View>
        );
    

}
export default Trip;