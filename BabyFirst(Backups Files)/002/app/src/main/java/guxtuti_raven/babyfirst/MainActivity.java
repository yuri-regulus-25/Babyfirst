package guxtuti_raven.babyfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.View;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Debug_Information", "起動したぜ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
