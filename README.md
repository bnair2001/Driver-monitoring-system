# Driver-monitering-system
Driver behaviour detecting app that warns if the behaviour is detrimental.

### How it works:
* The app starts of with the camera running and it looks for the eyes in the video.
* It then looks for any distracting behaviour shown by the driver.
* If the behaviour is detected to be bad it warns the driver.
* The alert runs till the driver touches the screen and if it takes too long an sos is sent to his emergency contact number

### Note:
The repo is divides into 3 files:
* The alert folder contains the app that triggers the alarm by flashing the screen red and also makes the flashlight of the camera to blink.
* The tfmobile folder consists of the android app that detects around 9 classes of distractions such as:
  - safe driving
  - texting - right
  - talking on the phone - right
  - texting - left
  - talking on the phone - left
  - operating the radio
  - drinking
  - reaching behind
  - hair and makeup
  - talking to passenger
  - Here is the accuracy and loss of the cnn model used to build this application:
     ![](https://i.imgur.com/d4NGndI.png)
* The vigilate folder contains the app that detects if the driver is sleeping or not.
 - example:
 ![Image 1](https://i.imgur.com/IFkhZfU.png)
 ![image 2](https://i.imgur.com/OrfbI4H.png)
 
### Installation:
* First install openCv manager for android by using this [link](https://apkpure.com/opencv-manager/org.opencv.engine/download?from=details).
* Next open the folder of the app you wish to use via android studio and you are good to go.

### Important note:
Th three apps are now seperate apps, if you would like to contribute plases help by combining the three into one.

### Credits:
[Bharath Nair](https://github.com/bnair2001), <br />
[Steve Paul](https://github.com/ST2-EV)
 
### References: 
 [tensorflow for poets](https://codelabs.developers.google.com/codelabs/tensorflow-for-poets/#0)<br />
 [OpenCV  for android](https://github.com/floe/opencv-android/tree/master/manager)<br />
 [The ML model for the tfmobile app](https://github.com/RenatoBMLR/state-farm-distracted-driver-detection)<br />
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
