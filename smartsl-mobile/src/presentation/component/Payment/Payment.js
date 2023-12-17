import React, {Component, useContext} from 'react';
import { View } from 'react-native';
import PaymentComponent from './PaymentComponent';
import styles from './Payment.component.style';
import FirebaseUtil from '../../../Utils/FirebaseUtil';

export default class Payment extends Component{ 

    signOut = () => {
        FirebaseUtil.signOut().catch((e) => {
            console.log(e);
            alert("Something went wrong");
        });
    }
   

    render() {
        return (
            <View style = {styles.container}>
                <PaymentComponent  
                />
            </View>
        );
    }

}