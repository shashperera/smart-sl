import React, { Component, useContext, useState } from 'react';
import { Button, View, TextInput, Text,Row , Image} from 'react-native';
import styles from './TimeTable.component.style';
import DateTimePicker from '@react-native-community/datetimepicker';
import { Drawer, Card, Title, Paragraph } from 'react-native-paper';


const TimeTableComponent = (props) => {
  const [selectedDate, handleDateChange] = useState(new Date());
  const [date, setDate] = useState(new Date(1598051730000));
  const [mode, setMode] = useState('date');
  const [show, setShow] = useState(false);
  const [text, setText] = useState('Select the date');

  

  const onChange = (event, selectedDate) => {
    const currentDate = selectedDate || date;
    setShow(Platform.OS === 'ios');
    setDate(currentDate);

    let tempDate = new Date(currentDate);
    let fDate = tempDate.getDate() + '/' + (tempDate.getMonth() + 1) + '/' + (tempDate.getFullYear())
    setText(fDate);
    alert(fDate);
  };

  const showMode = (currentMode) => {
    setShow(true);
    setMode(currentMode);
  };

  const showDatepicker = () => {
    showMode('date');
  };

  const showTimepicker = () => {
    showMode('time');
  };
  let items=['Item 1','Item 2','Item 3','Item 4','Item 5'];
  return (
    <View style={styles.outerView}>
      <View>
        <TextInput placeholder="Start Point" onChange={props.setPhoneNumber} />
        <TextInput placeholder="End Point" onChange={props.setPhoneNumber} />
        <Text placeholder="End Point" onPress={showDatepicker}>{text}{'\n'} </Text>
        <View>
          {/* <View style={styles.dateTimeButton} hidden>
        <Button  onPress={showDatepicker} title="Select Date" />
      </View> */}
          {/* <View>
        <Button onPress={showTimepicker} title="Show time picker!" />
      </View> */}
          {show && (
            <DateTimePicker
              testID="dateTimePicker"
              value={date}
              mode={mode}
              is24Hour={true}
              display="default"
              onChange={onChange} />
          )}
        </View >
        <View style={styles.dateTimeButton}>
          <Button title="SEARCH" onPress={props.TimeTable} />
        </View>
      </View>
      <View style={styles.timetable_container}>
        <Card.Content  style={styles.powderblue} >
        <Image
          style={styles.Image}
          source={require('./../../../assets/bus.png')}
        />
        </Card.Content>
        <Card.Content >
          <Title>Na 5698</Title>
          <Paragraph>Start Time : 5.10am</Paragraph>
          <Paragraph>End Time : 5.10pm</Paragraph>
          <Paragraph>Duration : 12h</Paragraph>
        </Card.Content>
      </View>
      <View style={styles.timetable_container}>
        <Card.Content  style={styles.powderblue} >
        <Image
          style={styles.Image}
          source={require('./../../../assets/bus.png')}
        />
        </Card.Content>
        <Card.Content >
          <Title>Na 5698</Title>
          <Paragraph>Start Time : 5.10am</Paragraph>
          <Paragraph>End Time : 5.10pm</Paragraph>
          <Paragraph>Duration : 12h</Paragraph>
        </Card.Content>
      </View>

    </View>

  );
};

export default TimeTableComponent;
