package com.jsbetko.dl4jhumanactivityrecognition;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyana on 16/12/2017.
 */

public class classify extends Service implements SensorEventListener {

    int WINDOW = 200;
    List<Float> xSeg = new ArrayList<>();
    List<Float> ySeg = new ArrayList<>();
    List<Float> zSeg = new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            xSeg.add(event.values[0]);
            ySeg.add(event.values[1]);
            zSeg.add(event.values[2]);
            long curTime = SystemClock.elapsedRealtime();

        }

    }

    private void predict() {
        if (xSeg.size() == WINDOW) {
            //add all segments to dl4j dataset

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
