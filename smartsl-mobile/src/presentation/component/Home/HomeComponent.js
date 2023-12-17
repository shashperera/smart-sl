import React, { Component, useContext } from 'react';
import { Button,Alert, Text, View, TouchableOpacity, Image } from 'react-native';
import { LoginContext } from '../../../Utils/LoginProvider';
import styles from './Home.component.style';
import { Card, Title, Paragraph } from 'react-native-paper';

const HomeComponent = (props) => {
  const { user } = useContext(LoginContext);
  const selectOption = () => {

    Alert.alert(
        'SCAN...',
        '',
        [
          {text: 'Scan your card...', onPress: () => props.captureImage('photo')},
          
        ],
        { 
          cancelable: true 
        }
      );        

  }


  return (
    <View>

      <View style={styles.card}>
        <Button onPress={() => props.signOut()} title="Log Out" />

        <View style={styles.cardBottom}>
          <View>
            <Card.Content >
              <Title>Credit Balance</Title>
              <Paragraph>2650.00 LKR</Paragraph>
            </Card.Content>
            <View style={styles.cardBottom1}>
              <TouchableOpacity style={{ flexDirection: 'row', }}
                activeOpacity={0.5}
                onPress={() => props.navigation.navigate('Payment')}>
                <Text h3
                  style={styles.topup}>
                  Top Up
                </Text>
                <Image
                  source={require('./../../../assets/topup.png')}
                  style={{ marginTop: '50%', marginStart: 8, width: '20%', height: '25%', }}
                />
              </TouchableOpacity>
              <Image
                source={require('./../../../assets/card.png')}
                style={{ alignSelf: "flex-end", marginBottom: 10, marginLeft: '10%', width: '40%', height: '100%', }}
              />
            </View>

          </View>
        </View>

        <View style={styles.cardBottomScan}>

        <TouchableOpacity
          activeOpacity={0.5}
          onPress={() => selectOption()}>
              {
                  props.filePath.uri != null ? (
                      <>
                      <Image
                source={{uri: props.filePath.uri}}
          style={styles.imgStyle}/>
                      </>
                  ): (
                    <>
                    <Image
                source={require('./../../../assets/scan.png')}
          style={styles.imgStyle}/>
                    </>
                  )
              }
              
              </TouchableOpacity>
        </View>


        <Text h2 style={{ alignSelf: "flex-start" }}>
          Recent Tours
        </Text>

        <View style={styles.cardTour}>
          <View>
            <Card.Content>
              <Title>Tour 1</Title>
              <View style={{ flexDirection: "row" }}>
              <Paragraph style={{ alignSelf: "flex-start" ,marginEnd:'25%'}}>Start : Colombo</Paragraph>
              <Paragraph style={{ alignSelf: "flex-end" }}>End : Kadawatha</Paragraph>
              </View>
            </Card.Content>
          </View>
        </View>
      </View>
      <View style={styles.cardBottom}>

      </View>


      <View style={styles.bottomnav}>
        <TouchableOpacity
          activeOpacity={0.5}
          onPress={() => props.navigation.navigate('Home')}>
          <Image
            source={require('./../../../assets/home.png')}
            style={styles.IconImage}
          />
          <Text style={styles.buttontext}>Home</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => props.navigation.navigate('Timetable')}
          activeOpacity={0.5}>
          <Image
            source={require('./../../../assets/tt.png')}
            style={styles.IconImage}
          />
          <Text style={styles.buttontext}> Timetables</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => props.navigation.navigate('Trip')}
          activeOpacity={0.5}>
          <Image
            source={require('./../../../assets/trip.png')}
            style={styles.IconImage}
          />
          <Text style={styles.buttontext}> Trips</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => props.navigation.navigate('Payment')}
          activeOpacity={0.5}>
          <Image
            source={require('./../../../assets/plist.png')}
            style={styles.IconImage}
          />
          <Text style={styles.buttontext}> Payments</Text>
        </TouchableOpacity>

      </View>

    </View>
  );
};

export default HomeComponent;
