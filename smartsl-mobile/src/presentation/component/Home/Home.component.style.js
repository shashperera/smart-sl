import { StyleSheet } from "react-native";

export default StyleSheet.create({
  container: {
    width:'100%',
    height: '100%',
    flex: 1,
    justifyContent: 'center',
    alignContent: 'center',
  },
  containerNull: {
    alignItems: 'center',
    justifyContent: 'center',
    flex: 1,
    width: '100%',
  },
  card: {
    backgroundColor: 'white',
    alignItems: 'center',
    width: '100%',
    height: '96%',
    padding: 10,
    borderRadius: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.23,
    shadowRadius: 2.62,
    elevation: 4,
    marginVertical: 20,
  },
  cardTop: {
    backgroundColor: 'blue',
    marginBottom: 20,
    borderRadius: 5,

  },
  Image: {
    width: 150,
    height: 100,
    marginBottom: 5,
    marginTop: 5,
  },
  ScanImage: {
    width: '35%',
    height: 150,
   alignSelf: "center"
  },
  IconImage: {
    width: 20,
    height: 25,
    alignSelf: "center"
  },
  cardBottom: {
    flexDirection: 'column',
    justifyContent: 'center',
    width: '100%',
    margin: 'auto',
    marginBottom: 20,
    marginTop: 20,
    backgroundColor: '#bbdefb',
    borderRadius: 5,
  },
  cardTour: {
    flexDirection: 'column',
    justifyContent: 'center',
    width: '100%',
    margin: 'auto',
    marginBottom: 20,
    marginTop: 20,
    backgroundColor: '#F9F9F9',
    borderRadius: 5,
  },
  cardBottom1: {
    flexDirection: 'column',
    width: '100%',
    flexDirection: 'row',
    margin: 'auto',
    marginBottom: 20,
    backgroundColor: '#bbdefb',
    borderRadius: 5,
  },
  cardBottomSame: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20,
  },
  cardBottomScan: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 10,
  },

  cardBottom2: {
    flexDirection: 'column',
    justifyContent: 'center',
    width: '100%',
    margin: 'auto',
    marginBottom: 15,
    backgroundColor: '#ffff', 
    borderRadius: 5,
  },
  recentTitle: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    width: '100%',
  },
  recentTransactions: {
    backgroundColor: 'white',
    width: '100%',
  },

  topup:{
    marginTop: '50%',
    marginStart: '8%',
    fontSize:19,
    color: 'white',
    alignSelf: "flex-start",
    fontWeight:"bold",
    
  },
  imgStyle: {
    height: 120,
    width:120,
    borderRadius: 60,
    alignSelf: "center"

  },
  bottomnav: {
    position: 'absolute',
    bottom: 0,
    padding: 7,
    backgroundColor: '#F6F5F5',
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: '100%',
    height: '11%',
    marginBottom:'1.5%',

    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 12,
    },
    shadowOpacity: 0.58,
    shadowRadius: 16.0,

    elevation: 10,
  },
  recentTransactions: {
    backgroundColor: 'black',
    width: '100%',
  },

  plusButton: {
    backgroundColor: '#bbdefb',
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
  textInput: {
    borderWidth: 1,
    borderColor: '#7a42f4',
    padding: 10,
    marginBottom: 20,
    borderRadius: 5
  },
  buttontext: {
    color: 'grey',
    alignSelf:'center',
      fontSize: 10,
  }
});