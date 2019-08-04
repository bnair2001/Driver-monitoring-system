package com.codesec.alert;

import android.Manifest;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    int volume;
    private static final int CAMERA_REQUEST = 123;
    boolean hasCameraFlash = false;
    private TextView txt;
    private Button blinkBtn;


    //Context context = getApplicationContext();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        manageBlinkEffect();
        blinkBtn = (Button) findViewById(R.id.btn);

        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
        ring.start();
        //changeScreenBrightness(context, 255);


        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);
        hasCameraFlash = getPackageManager().
                hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        blinkFlash();
        manageBlinkEffect();
        blinkBtn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"vigilate",Toast.LENGTH_SHORT).show();

               String packageName = "com.teamcodesec.vigilate";
               Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
               if(intent != null) {
                   startActivity(intent);
               }
               android.os.Process.killProcess(android.os.Process.myPid());

            }
       });
    }

    private void manageBlinkEffect() {
        ObjectAnimator anim = ObjectAnimator.ofInt(txt, "backgroundColor", Color.WHITE, Color.RED,
                Color.RED);
        anim.setDuration(350);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.ZORDER_TOP);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }

    private void blinkFlash()
    {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String myString = "010101010101";
        long blinkDelay = 50; //Delay in ms
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == '0') {
                try {
                    String cameraId = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(cameraId, true);
                } catch (CameraAccessException e) {
                }
            } else {
                try {
                    String cameraId = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(cameraId, false);
                } catch (CameraAccessException e) {
                }
            }
            try {
                Thread.sleep(blinkDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private void changeScreenBrightness(Context context, int screenBrightnessValue)
//    {
//        // Change the screen brightness change mode to manual.
//        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
//        // Apply the screen brightness value to the system, this will change the value in Settings ---> Display ---> Brightness level.
//        // It will also change the screen brightness for the device.
//        Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, screenBrightnessValue);
//
//        /*
//        Window window = getWindow();
//        WindowManager.LayoutParams layoutParams = window.getAttributes();
//        layoutParams.screenBrightness = screenBrightnessValue / 255f;
//        window.setAttributes(layoutParams);
//        */
//    }
}
