/*//////////////////////////////////////////////////////////////////////////////////////////////////
最終更新 3/31 11:33
問題点
特にない気もする
//////////////////////////////////////////////////////////////////////////////////////////////////*/

package jp.ac.yukine.practice;

//各種クラス使用宣言
import android.app.Activity;
import android.view.MotionEvent;
import android.os.Bundle;
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

import java.util.Random;


public class MainActivity extends Activity {
    //画面切り替えのパターン管理
    public int next_pattern = 1;
    public int now_pattern = 1;
    //各種ID宣言(文字・背景)
    private TextView label;
    private View view;
    //各種ID宣言(画像)
    private ImageView migiue;
    private ImageView hidarishita;
    //各種ID宣言(SE)
    private AudioManager audio;
    private SoundPool otonarashi = null;
    private int sound;
    private boolean play_ready = false;

    //ランダム化
    public Random rand;

    //音量取得
    int MUSIC;

    //一番最初
    @Override
    protected void onCreate(Bundle savedInstanceState) { //初回起動時
        Log.i("Information", "グローバル変数宣言終了 onCreateメソッドへ移行");
        Log.i("Information", "変数 next_Pattern(int): " + next_pattern);
        //画面描写の更新
        super.onCreate(savedInstanceState);

        //各種ID代入(文字・背景)
        setContentView(R.layout.activity_main);
        label = (TextView) findViewById(R.id.aka);
        Log.i("Information", "変数 label(ViewText): " + label);
        view = (View) findViewById(R.id.haikei);
        Log.i("Information", "変数 view(View): " + view);

        //各種ID代入(画像)
        migiue = (ImageView) findViewById(R.id.migiue);
        Log.i("Information", "変数 migiue(ImageView): " + migiue);
        hidarishita = (ImageView) findViewById(R.id.hidarishita);
        Log.i("Information", "変数 hidarishita(InageText): " + hidarishita);

        //ランダム化に必要な変数への代入
        rand = new Random();

        //ナビゲーションバー非表示 (ネットから引っ張ってきた)
        if (Build.VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            View view = window.getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }

        //音量取得
        audio = (AudioManager)getSystemService(this.AUDIO_SERVICE);
        MUSIC = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        Log.i("Information", "音楽再生音量: " + MUSIC);

        //SoundPoolに関しての操作
        Log.i("otonarashi", "otonarashi " + otonarashi);
        Log.i("Information", "sound " + sound);
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
        otonarashi = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(1).build();

        next_pattern = rand.nextInt(11)+1;
        Log.i("Informaion", "selectメソッド呼び出し");
        select();
    }

    //二番目
    @Override
    public boolean onTouchEvent(MotionEvent event) //タップされたときに関する処理
    {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: { //画面をタップした(とにかく触れた)時
                Log.i("Information", "画面にタップ");
                do {
                    next_pattern = rand.nextInt(11) + 1;
                }while(next_pattern == now_pattern);
                now_pattern = next_pattern;
                select();
            }
        }
        //returnで処理の終了
        return super.onTouchEvent(event);
    }

    public void select()
    {
        switch (next_pattern) {
            case 1: //赤
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.aka, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("あか");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.ichigo);
                hidarishita.setImageResource(R.drawable.ringo);
                //背景色変更
                view.setBackgroundColor(Color.RED);
                break;

            case 2: //青
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.ao, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("あお");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.kujira);
                hidarishita.setImageResource(R.drawable.fish);
                //背景色変更
                view.setBackgroundColor(Color.BLUE);
                break;

            case 3: //黄色
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.kiiro, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("きいろ");
                label.setTextColor(Color.BLACK);
                //画像変更
                migiue.setImageResource(R.drawable.hiyoko);
                hidarishita.setImageResource(R.drawable.himawari);
                //背景色変更
                view.setBackgroundColor(Color.YELLOW);
                break;

            case 4: //黒
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.kuro, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("くろ");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.moon);
                hidarishita.setImageResource(R.drawable.star);
                //背景色変更
                view.setBackgroundColor(Color.BLACK);
                break;

            case 5: //緑
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.midori, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("みどり");
                label.setTextColor(Color.BLACK);
                //画像変更
                migiue.setImageResource(R.drawable.leaf);
                hidarishita.setImageResource(R.drawable.frog);
                //背景色変更
                view.setBackgroundColor(Color.GREEN);
                break;

            case 6: //水色
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.mizuiro, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("みずいろ");
                label.setTextColor(Color.BLACK);
                //画像変更
                migiue.setImageResource(R.drawable.cloud);
                hidarishita.setImageResource(R.drawable.rainbow);
                //背景色変更
                view.setBackgroundColor(Color.parseColor("#00FFFF"));
                break;

            case 7: //紫
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.murasaki, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("むらさき");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.grape);
                hidarishita.setImageResource(R.drawable.nasu);
                //背景色変更
                view.setBackgroundColor(Color.parseColor("#800080"));
                break;

            case 8: //オレンジ
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.orange, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("おれんじ");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.orange);
                hidarishita.setImageResource(R.drawable.pumpkin);
                //背景色変更
                view.setBackgroundColor(Color.parseColor("#FF8000"));
                break;

            case 9: //ピンク
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.pink, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("ぴんく");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.peach);
                hidarishita.setImageResource(R.drawable.pig);
                //背景色変更
                view.setBackgroundColor(Color.parseColor("#FF00FF"));
                break;

            case 10: //白
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.siro, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("しろ");
                label.setTextColor(Color.BLACK);
                //画像変更
                migiue.setImageResource(R.drawable.yukidaruma);
                hidarishita.setImageResource(R.drawable.rabit);
                //背景色変更
                view.setBackgroundColor(Color.WHITE);
                break;

            case 11: //茶色
                //効果音再生
                Log.i("Informaion", "PlaySoundメソッド呼び出し");
                sound = otonarashi.load(this, R.raw.tyairo, 1);
                PlaySound();
                //中央の文字の変更
                label.setText("ちゃいろ");
                label.setTextColor(Color.WHITE);
                //画像変更
                migiue.setImageResource(R.drawable.maron);
                hidarishita.setImageResource(R.drawable.bear);
                //背景色変更
                view.setBackgroundColor(Color.parseColor("#996633"));
                break;
        }
    }

    public void PlaySound()
    {
        Log.i("Information", "PlaySoundメソッドさんこんにちは");
        otonarashi.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool otonarashi, int ID, int status) {
                Log.i("Information","loadstatus: "+status);
                if(status == 0)
                {
                    play_ready = true;
                    Log.i("Information", "play_ready: " + play_ready + " trueで再生可能");
                    if(play_ready) {
                        otonarashi.play(sound, MUSIC, MUSIC, 0, 0, 1);
                        Log.i("Information","SoundPool実行(再生) 音量: " + "MUSIC");
                    }
                }
            }
        });
    }
}