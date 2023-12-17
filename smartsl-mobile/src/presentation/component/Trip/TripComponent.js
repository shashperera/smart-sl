import React, { Component, useContext } from 'react';
import { Button, Text, View, TouchableOpacity, Image } from 'react-native';
import { LoginContext } from '../../../Utils/LoginProvider';
import styles from './Trip.component.style';
import { Card, Title, Paragraph } from 'react-native-paper';

const TripComponent = props => {
  const { user } = useContext(LoginContext);

  return (
    <View>

      <View style={styles.card}>
        <Button onPress={() => props.signOut()} title="Log Out" />

        <View style={styles.cardBottom}>
          <View><Card.Content >
            <Title>Curent Trip</Title>
            <Paragraph>2650.00 LKR</Paragraph>
          </Card.Content>
            
            <Text h4 style={{ textAlign: 'center' }}>
            </Text>
          </View>
        </View>
        <View style={styles.cardBottom2}>
          <View>
            <View style={styles.cardBottomSame}>
            </View>
            <View style={styles.cardBottomSame}>
            </View>
          </View>
        </View>
        <Text h2 style={{ alignSelf: "flex-start" }}>
          Recent Tours
        </Text>

        <View style={styles.cardTour}>
          <View>
            <Card.Content>
              <Title>Tour 1</Title>
              <View style={{ flexDirection: "row" }}>
                <Paragraph style={{ alignSelf: "flex-start", marginEnd: '25%' }}>Start : Colombo</Paragraph>
                <Paragraph style={{ alignSelf: "flex-end" }}>End : Kadawatha</Paragraph>
              </View>
            </Card.Content>
            <Card.Content>
              <Title>Tour 2</Title>
              <View style={{ flexDirection: "row" }}>
                <Paragraph style={{ alignSelf: "flex-start", marginEnd: '25%' }}>Start : Kaduwela</Paragraph>
                <Paragraph style={{ alignSelf: "flex-end" }}>End : Kadawatha</Paragraph>
              </View>
            </Card.Content>
            <Card.Content>
              <Title>Tour 3</Title>
              <View style={{ flexDirection: "row" }}>
                <Paragraph style={{ alignSelf: "flex-start", marginEnd: '25%' }}>Start : Colombo</Paragraph>
                <Paragraph style={{ alignSelf: "flex-end" }}>End : Matara</Paragraph>
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

export default TripComponent;
