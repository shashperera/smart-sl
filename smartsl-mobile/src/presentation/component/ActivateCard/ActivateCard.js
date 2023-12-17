import React, { Component, useContext, useState } from 'react';
import { View } from 'react-native';
import ActivateCardComponent from './ActivateCardComponent';
import styles from './ActivateCard.component.style';
import FirebaseUtil from '../../../Utils/FirebaseUtil';

function ActivateCard() {

    const [phoneNumber, setPhoneNumber] = useState();

    const activateCard = () => {
        alert('dsd');
    }

    return (
        <View style={styles.container}>
            <ActivateCardComponent
                activateCard={activateCard}
                setPhoneNumber={setPhoneNumber}
            />
        </View>
    );


}

export default ActivateCard;