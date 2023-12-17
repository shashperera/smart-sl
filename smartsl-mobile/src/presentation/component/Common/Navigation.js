import React, { useEffect, useLayoutEffect, useState } from 'react';
import { Alert, Modal, StyleSheet, Text, Pressable, View,TouchableOpacity } from 'react-native';
import {
  FontAwesome,
  EvilIcons,
  FontAwesome5,
  AntDesign,
  MaterialIcons,
} from '@expo/vector-icons';
import { Avatar, ListItem } from 'react-native-elements';
import CustomListItem from '../components/CustomListItem';
import { StatusBar } from 'expo-status-bar';

import { auth, db } from '../services/firebase';

const Bottom = ({ navigation }) => {
    const signOutUser = () => {
    auth
      .signOut()
      .then(() => navigation.replace('Login'))
      .catch((error) => alert(error.message));
  };
  useLayoutEffect(() => {
    navigation.setOptions({
      title: 'Expense Tracker',
      headerRight: () => (
        <View style={{ marginRight: 20 }}>
          <TouchableOpacity activeOpacity={0.5} onPress={signOutUser}>
            <Text style={{ fontWeight: 'bold' }}>Logout</Text>
          </TouchableOpacity>
        </View>
      ),
    });
  }, [navigation]);
  
  return (
    <>
   <View style={styles.addButton}>
        <TouchableOpacity
          activeOpacity={0.5}
          onPress={() => navigation.navigate('Home')}>
          <FontAwesome5 name="home" size={24} color="#00509d" />
          <Text style={{ color: 'grey', fontSize: 8 }}>Home</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => navigation.navigate('Limit')}
          activeOpacity={0.5}>
          <MaterialCommunityIcons
            name="clipboard-flow-outline"
            size={24}
            color="#00509d"
          />
          <Text style={{ color: 'grey', fontSize: 8 }}> Limit</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => navigation.navigate('Add')}
          activeOpacity={0.5}>
          <MaterialIcons name="add-circle" size={55} color="#3bdefb" />
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => navigation.navigate('Off')}
          activeOpacity={0.5}>
          <Ionicons name="cash-outline" size={24} color="#00509d" />
          <Text style={{ color: 'grey', fontSize: 8 }}> List</Text>
        </TouchableOpacity>
        <TouchableOpacity
          activeOpacity={0.5}
          onPress={() => navigation.navigate('Seemore')}>
          <MaterialIcons name="read-more" size={26} color="#00509d" />
          <Text style={{ color: '#00509d', fontSize: 8 }}>More</Text>
        </TouchableOpacity>
      </View>     </>

  );
};

export default Bottom;

const styles = StyleSheet.create({

  seeAll: {
    fontWeight: 'bold',
    color: 'green',
    fontSize: 16,
  },
  addButton: {
    position: 'absolute',
    bottom: 0,
    padding: 10,
    backgroundColor: 'white',
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: '100%',
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 12,
    },
    shadowOpacity: 0.58,
    shadowRadius: 16.0,

    elevation: 24,
  },
  plusButton: {
    backgroundColor: '#00296b',
    padding: 10,
    borderRadius: 50,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 12,
    },
    shadowOpacity: 0.58,
    shadowRadius: 16.0,
    elevation: 24,
  },

  
});
