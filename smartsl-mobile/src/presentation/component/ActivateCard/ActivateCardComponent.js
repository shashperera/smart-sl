import React, { Component, useContext } from 'react';
import { Button, Text, View, Icon, TouchableOpacity, Image, div, TextInput } from 'react-native';
import { LoginContext } from '../../../Utils/LoginProvider';
import styles from './ActivateCard.component.style';



const ActivateCardComponent = (props) => {

  return (
    <View>
      <View style={styles.image_view}>
        <Image
          style={styles.Image}
          source={require('./../../../assets/tick.png')}
        />
      </View>
      <Text style={styles.first}>Enter your smart card number{'\n'} </Text>
      <Text style={styles.second}>Your account will be linked to this number{'\n'} </Text>
      <TextInput placeholder="Phone number" style={styles.text_number} onChange={props.setPhoneNumber} />
      <Button title="ACTIVATE"  onPress={props.activateCard} />
    </View>

  );
};

export default ActivateCardComponent;
