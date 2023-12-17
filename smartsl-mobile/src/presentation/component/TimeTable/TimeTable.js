import React, { Component, useContext, useState } from 'react';
import { View } from 'react-native';
import TimeTableComponent from './TimeTableComponent';
import styles from './TimeTable.component.style';
import FirebaseUtil from '../../../Utils/FirebaseUtil';

function TimeTable() {

    const [phoneNumber, setPhoneNumber] = useState();

    const TimeTable = () => {
        alert('dsd');
    }
    const handleConfirm = (date) => {
        console.warn("A date has been picked: ", date);
        const [datetime]=date;
       // var tes=const [datetime];
        alert(date);
        hideDatePicker();
      };

    return (
        <View style={styles.container}>
            <TimeTableComponent
                TimeTable={TimeTable}
                setPhoneNumber={setPhoneNumber}
                handleConfirm={handleConfirm}
            />
        </View>
    );


}

export default TimeTable;