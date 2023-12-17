import { StyleSheet } from "react-native";

export default StyleSheet.create({
  container: {
    marginTop: 10,
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  Image: {
    width: 200,
    height: 200,
    alignSelf: 'center',
    marginBottom: 5,
    marginTop: 15,
  },
  BottomView: {
    width: '100%',
    height: '100%',
    backgroundColor: '#3490dc',
    borderTopLeftRadius: 30,
    borderTopRightRadius: 30,

  },
  Heading: {
    color: '#fff',
    fontSize: 36,
    fontWeight: 'bold',
    marginLeft: 30,
    marginTop: 5,
    marginBottom: 5,
    alignSelf: 'center',
  },
  FormView: {
    width: '100%',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    marginTop: 5,
  },

  TextInput: {
    width: '90%',
    height: 52,
    borderRadius: 10,
    paddingLeft: 5,
    borderWidth: 1,
    marginTop: 5,
    fontWeight: 'bold',
    borderColor: '#fff',
    color: '#fff',
    alignSelf: 'center',


  },
  Button: {
    width: '90%',
    color: '#000',
    height: 52,
    display: 'flex',
    borderRadius: 10,
    marginTop: 20,
    alignItems: 'center',
    backgroundColor: '#fff',
    justifyContent: 'center',
    alignItems: 'center',
    alignSelf: 'center',

  },
  ButtonText: {
    fontWeight: 'bold',
    fontSize: 18,
  },
  SignupText: {
    color: 'white',
    fontWeight: 'bold',

    fontSize: 16,
  },
  TextButton: {
    width: '100%',
    display: 'flex',
    marginTop: 20,
    justifyContent: 'center',
    alignItems: 'center',
    alignSelf: 'center',

  },
});
