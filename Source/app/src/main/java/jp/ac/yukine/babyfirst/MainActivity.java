package jp.ac.yukine.babyfirst;

import android.app.Activity;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public boolean inspection = true;
    public int color_apply = -1;

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
        ImageView migi = (ImageView)findViewById(R.id.rightup);
        ImageView hidari = (ImageView)findViewById(R.id.leftdown);
        Random rand = new Random();

        if(inspection)
            if(color_apply == 10)
                color_apply = 0;
            else
                color_apply++;

        else
            color_apply = rand.nextInt(10);

        switch (color_apply)
        {
            case 0:
                //赤色
                Background_Color.setBackgroundColor(Color.rgb(210, 00, 45));
                migi.setImageResource(R.drawable.ichigo);
                hidari.setImageResource(R.drawable.ringo);
                break;

            case 1:
                //オレンジ
                Background_Color.setBackgroundColor(Color.rgb(255, 102, 00));
                migi.setImageResource(R.drawable.orange);
                hidari.setImageResource(R.drawable.pumpkin);
                break;

            case 2:
                //黄色
                Background_Color.setBackgroundColor(Color.rgb(255, 204, 00));
                migi.setImageResource(R.drawable.himawari);
                hidari.setImageResource(R.drawable.hiyoko);
                break;

            case 3:
                //緑色
                Background_Color.setBackgroundColor(Color.rgb(50, 197, 00));
                migi.setImageResource(R.drawable.frog);
                hidari.setImageResource(R.drawable.leaf);
                break;

            case 4:
                //水色
                Background_Color.setBackgroundColor(Color.rgb(72, 199, 255));
                migi.setImageResource(R.drawable.rainbow);
                hidari.setImageResource(R.drawable.cloud);
                break;

            case 5:
                //青色
                Background_Color.setBackgroundColor(Color.rgb(00, 109, 230));
                migi.setImageResource(R.drawable.kujira);
                hidari.setImageResource(R.drawable.fish);
                break;

            case 6:
                //紫色
                Background_Color.setBackgroundColor(Color.rgb(135, 55, 225));
                migi.setImageResource(R.drawable.nasu);
                hidari.setImageResource(R.drawable.grape);
                break;

            case 7:
                //ピンク
                Background_Color.setBackgroundColor(Color.rgb(255,152, 183));
                migi.setImageResource(R.drawable.pig);
                hidari.setImageResource(R.drawable.peach);
                break;

            case 8:
                //茶色
                Background_Color.setBackgroundColor(Color.rgb(100, 64, 60));
                migi.setImageResource(R.drawable.maron);
                hidari.setImageResource(R.drawable.bear);
                break;

            case 9:
                //黒
                Background_Color.setBackgroundColor(Color.rgb(0, 0, 0));
                migi.setImageResource(R.drawable.star);
                hidari.setImageResource(R.drawable.moon);
                break;

            case 10:
                //白色
                Background_Color.setBackgroundColor(Color.rgb(255, 255, 255));
                migi.setImageResource(R.drawable.rabit);
                hidari.setImageResource(R.drawable.yukidaruma);
                break;

            default:
                //例外処理
                Background_Color.setBackgroundColor(Color.rgb(200, 0, 100));
                break;
        }
        System.out.println("Random: 色: " + color_apply);
    }
}
