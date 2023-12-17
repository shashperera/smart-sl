import { StyleSheet } from "react-native";
import { white } from "react-native-paper/lib/typescript/styles/colors";


export default StyleSheet.create({
  Switch: {
    alignSelf: "center",
    marginTop: 20,
    marginBottom: 20,
  },
  container: {
    backgroundColor: "#F5F5F5",
    marginTop: 10,
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
    width: 100,
    height: 100,
   
    alignItems: "center",
    paddingLeft: 10,
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
  outer_view:{
    height:'100%',
    width:'100%',
    backgroundColor:'red',
    
  },
  dateTimeButton : {
    paddingTop:10,
  },
  outerView:{
    padding:10,
  },
  timetable_container:{  
    flexDirection: 'row',
    paddingTop:20 ,// set elements horizontally, try column.  
    backgroundColor: 'white' ,
    marginBottom:10,
},  
// timetable_card:{  
//   width: 100,  
//   height: 80,  
//  // backgroundColor: 'powderblue',  
// },  
});