import HomeComponent from './HomeComponent';
import styles from './Home.component.style';
import FirebaseUtil from '../../../Utils/FirebaseUtil';
import React, {Component, useContext, useState, useEffect, useRef, useDebugValue} from 'react';
import { View, PermissionsAndroid, Platform } from 'react-native';
import { UserRepositoryImpl } from '../../../data/repositoryImpl/UserRepositoryImpl';
import { UserServiceImpl } from '../../../domain/service/impl/UserServiceImpl';
import { LoginContext } from '../../../Utils/LoginProvider';
import ImagePicker, {launchCamera, launchImageLibrary} from 'react-native-image-picker';

export const userRepository = new UserRepositoryImpl();
export const userService = new UserServiceImpl(userRepository);

function Home({navigation}) { 

    signOut = () => {
        FirebaseUtil.signOut().catch((e) => {
            console.log(e);
            alert("Something went wrong");
        });
    }

    let isAble = false;

    const {user} = useContext(LoginContext);

    const [filePath, setFilePath] = useState({});

    const[userDto, setUserDto] = useState({});
    const [id, setId] = useState(0);
    const [fullname, setFullname] = useState('');
    const [email, setEmail] = useState(user);
    const [address, setAddress] = useState(''); 
    const[userReferenceId, setUserReferenceId]=useState('');

    const fetchUserEmail = async () => {
        const response = await userService.getUserByEmail(user?.email).then(response =>  {
            
            // isAble = true;
            setUserDto(response);
            setId(response.id);
            setEmail(response.email);
            setFullname(response.fullname);
            setAddress(response.address);
            setUserReferenceId(response.userReferenceId);
        });   

        console.log('profile.js-line 37');
        console.log(response);

      };

     useEffect(() => {      
        
            fetchUserEmail();

            console.log('profile.js - 74');         

    },[]);

    const requestCameraPermission = async () => {
        if (Platform.OS === 'android') {
          try {
            const granted = await PermissionsAndroid.request(
              PermissionsAndroid.PERMISSIONS.CAMERA,
              {
                title: 'Camera Permission',
                message: 'App needs camera permission',
              },
            );
            // If CAMERA Permission is granted
            return granted === PermissionsAndroid.RESULTS.GRANTED;
          } catch (err) {
            console.warn(err);
            return false;
          }
        } else return true;
      };
      
      const requestExternalWritePermission = async () => {
        if (Platform.OS === 'android') {
          try {
            const granted = await PermissionsAndroid.request(
              PermissionsAndroid.PERMISSIONS.WRITE_EXTERNAL_STORAGE,
              {
                title: 'External Storage Write Permission',
                message: 'App needs write permission',
              },
            );
            // If WRITE_EXTERNAL_STORAGE Permission is granted
            return granted === PermissionsAndroid.RESULTS.GRANTED;
          } catch (err) {
            console.warn(err);
            alert('Write permission err', err);
          }
          return false;
        } else return true;
      };
    
      const captureImage = async (type) => {
    
        let options = {
          mediaType: type,
          maxWidth: 300,
          maxHeight: 550,
          quality: 1,
          videoQuality: 'low',
          durationLimit: 30, //Video max duration in seconds
          saveToPhotos: true,
        };
        let isCameraPermitted = await requestCameraPermission();
        let isStoragePermitted = await requestExternalWritePermission();
    
        if (isCameraPermitted && isStoragePermitted) {
    
          launchCamera(options, (response) => {
    
            console.log('Response = ', response);
    
            if (response.didCancel) {
              alert('User cancelled scanner');
              return;
            } else if (response.errorCode == 'camera_unavailable') {
              alert('Camera not available on device');
              return;
            } else if (response.errorCode == 'permission') {
              alert('Permission not satisfied');
              return;
            } else if (response.errorCode == 'others') {
              alert(response.errorMessage);
              return;
            }
            console.log('base64 -> ', response.base64);
            console.log('uri -> ', response.uri);
            console.log('width -> ', response.width);
            console.log('height -> ', response.height);
            console.log('fileSize -> ', response.fileSize);
            console.log('type -> ', response.type);
            console.log('fileName -> ', response.fileName);
            setFilePath(response.assets[0]);
          });
    
          
    
        }
      };
    
    


        return (
            <View style = {styles.container}>
                <HomeComponent  
                signOut = {this.signOut}
                filePath= {filePath}
                captureImage= {captureImage}
                navigation={navigation}
                />

            </View>
        );
    

}
export default Home;