package com.example.nicholasdippner14.cameratechdemo;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Camera mCamera = null;
    private CameraView mCameraView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mCamera = Camera.open();

        }catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

       if(mCamera != null){
            mCameraView = new CameraView(this,mCamera);
           FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
           camera_view.addView(mCameraView);
       }

        ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
       imgClose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               System.exit(0);
           }
       });
    }
}
