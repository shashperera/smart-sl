import React, { Component, useContext } from 'react';
import { Button, Text, View, Icon, TouchableOpacity, TextInput } from 'react-native';
import { LoginContext } from '../../../Utils/LoginProvider';
import styles from './Payment.component.style';
import { CreditCardInput, LiteCreditCardInput } from "react-native-credit-card-input";

const PaymentComponent = () => {
  state = { useLiteCreditCardInput: false };

  _onChange = (formData) => console.log(JSON.stringify(formData, null, " "));
  _onFocus = (field) => console.log("focusing", field);
  _setUseLiteCreditCardInput = (useLiteCreditCardInput) => this.setState({ useLiteCreditCardInput });

  // function onSubmit() {
  //   console.log('form submitted');
  //   alert(' Toped upby Rs.152');

  // }

  return (
    <View>
      <View style={styles.image_view}>
        <TextInput placeholder="Enter Top Up Ammount" style={styles.text_number} />
      </View>
      <View style={styles.container}>
        {this.state.useLiteCreditCardInput ?
          (
            <LiteCreditCardInput
              autoFocus

              inputStyle={styles.input}
              validColor={"black"}
              invalidColor={"red"}
              placeholderColor={"darkgray"}

              onFocus={this._onFocus}
              onChange={this._onChange} />
          ) : (
            <CreditCardInput
              autoFocus

              requiresName
              requiresCVC
              requiresPostalCode

              cardScale={1.0}
              labelStyle={styles.label}
              inputstyle={styles.input}
              validColor={"black"}
              invalidColor={"red"}
              placeholderColor={"darkgray"}

              onFocus={this._onFocus}
              onChange={this._onChange} />
          )
        }
      </View>
      {/* <Button title="PAY Rs.152.00" onPress={onSubmit} /> */}

    </View>
  );
};

export default PaymentComponent;
