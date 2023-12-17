import React, { Component } from 'react';
import {
  StyleSheet,
  Button,
  View,
  Text,
  Image,
  TextInput,
  TouchableOpacity,
} from 'react-native';
import styles from './Login.component.style';

const LoginComponent = (props) => {
  return (

    <View style={styles.BottomView}>
      <Image
        source={require('./../../../assets/logo.png')}
        style={styles.Image}
      />

      <Text style={styles.Heading}>Smart SL{'\n'} </Text>
      <TextInput style={styles.TextInput}
        placeholder="Email"
        placeholderTextColor={'#fff'}
        onChangeText={props.setEmail}
        autoCapitalize="none"
        value={props.email}
        style={styles.TextInput}
      />
      <TextInput style={styles.TextInput}
        placeholder="Password"
        placeholderTextColor={'#fff'}
        onChangeText={props.setPassword}
        value={props.password}
        secureTextEntry={true}
        style={styles.TextInput}
      />
      {props.create ? (
        <>
          <TextInput style={styles.TextInput}
            placeholder="Confirm Password"
            placeholderTextColor={'#fff'}
            onChangeText={props.setConfirmPassword}
            value={props.confirmPassword}
            secureTextEntry={true}
          />
          <TextInput
            placeholder="Full Name (optional)"
            placeholderTextColor={'#fff'}
            onChangeText={props.setFullname}
            autoCapitalize="none"
            value={props.fullname}
            style={styles.TextInput}
          />
          <TextInput
            placeholder="Address (optional)"
            placeholderTextColor={'#fff'}
            onChangeText={props.setAddress}
            autoCapitalize="none"
            value={props.address}
            style={styles.TextInput}
          />
        </>) : (<></>)}
      {props.create ? (
        <>
          <TouchableOpacity
            style={styles.Button}
            onPress={props.signUp}>
            <Text style={styles.ButtonText}>Sign Up</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={styles.TextButton}>
            <Text style={styles.SignupText} onPress={() => props.setCreate(false)}> Back to Sign in</Text>
          </TouchableOpacity>
        </>
      ) : (
        <>

          <TouchableOpacity style={styles.Button} onPress={props.signIn}>
            <Text style={styles.ButtonText}>Sign In</Text>
          </TouchableOpacity>

          <TouchableOpacity
            style={styles.TextButton}
          >
            <Text style={styles.SignupText} onPress={() => props.setCreate(true)}>Create an Account</Text>
          </TouchableOpacity>
        </>
      )}
    </View>
  );
}

export default LoginComponent