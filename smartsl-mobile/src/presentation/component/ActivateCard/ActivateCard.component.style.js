import { StyleSheet } from "react-native";
import { Switch } from "react-native";

export default StyleSheet.create({
  Switch: {
    alignSelf: "center",
    marginTop: 20,
    marginBottom: 20,
  },
  container: {
    backgroundColor: "#F5F5F5",
    marginTop: 60,
  },
  label: {
    color: "black",
    fontSize: 12,
  },
  input: {
    fontSize: 16,
    color: "black",
  },
  Image: {
    width: 250,
    height: 250,
    marginBottom: 5,
    marginTop: 15,
    alignItems: "center",
    paddingLeft: 50,
  },
  image_view: {
    paddingLeft: 50,
    paddingTop: 0
  },
  first: {
    paddingLeft: 35,
    paddingTop: 20,
    fontWeight:"bold",
    fontSize: 20,
  },
  second: {
    paddingLeft: 35,
  },
  text_number:{
    textAlignVertical: 'top',
    textAlign:"center"
  }
});