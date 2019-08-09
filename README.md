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
 
### Credits:
[Bharath Nair](https://github.com/bnair2001), <br />
[Steve Paul](https://github.com/ST2-EV)
 
### References: 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
