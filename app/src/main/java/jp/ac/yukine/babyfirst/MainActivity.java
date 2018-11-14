package jp.ac.yukine.babyfirst;

import android.app.Activity;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConstraintLayout Background_Color = (ConstraintLayout) findViewById(R.id.backgroundcheck);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                random();
                System.out.println("onTouchEvent: タップされたでやんす");
                break;
        }
        return false;
    }

    void random()
    {
        ConstraintLayout Background_Color = (ConstraintLayout) findViewById(R.id.backgroundcheck);
        Random rand = new Random();
        int color_apply = rand.nextInt(10);

        switch (color_apply)
        {
            case 0:
                //赤色
                Background_Color.setBackgroundColor(Color.rgb(210, 00, 45));
                
                break;

            case 1:
                //オレンジ
                Background_Color.setBackgroundColor(Color.rgb(255, 102, 00));
                
                break;

            case 2:
                //黄色
                Background_Color.setBackgroundColor(Color.rgb(255, 204, 00));
                
                break;

            case 3:
                //緑色
                Background_Color.setBackgroundColor(Color.rgb(50, 197, 00));
                
                break;

            case 4:
                //水色
                Background_Color.setBackgroundColor(Color.rgb(72, 199, 255));
                
                break;

            case 5:
                //青色
                Background_Color.setBackgroundColor(Color.rgb(00, 85, 255));
                
                break;

            case 6:
                //紫色
                Background_Color.setBackgroundColor(Color.rgb(127, 40, 255));
                
                break;

            case 7:
                //ピンク
                Background_Color.setBackgroundColor(Color.rgb(255,152, 183));
                
                break;

            case 8:
                //茶色
                Background_Color.setBackgroundColor(Color.rgb(100, 64, 60));
                
                break;

            case 9:
                //黒
                Background_Color.setBackgroundColor(Color.rgb(0, 0, 0));
                
                break;

            case 10:
                //灰色
                Background_Color.setBackgroundColor(Color.rgb(147, 147, 147));
                
                break;

            default:
                //例外処理
                Background_Color.setBackgroundColor(Color.rgb(255, 255, 255));
                
                break;
        }
        System.out.println("Random: 色: " + color_apply);
    }
}
