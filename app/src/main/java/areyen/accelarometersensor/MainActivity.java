package areyen.accelarometersensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
TextView xText,yText,zText;
private Sensor mySensor;
private SensorManager SM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SM=(SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor=SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
        xText=(TextView)findViewById(R.id.XText);
        yText=(TextView)findViewById(R.id.YText);
        zText=(TextView)findViewById(R.id.ZText);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
           xText.setText("X : "+sensorEvent.values[0]);
           yText.setText("Y : "+sensorEvent.values[1]);
           zText.setText("Z : "+sensorEvent.values[1]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
