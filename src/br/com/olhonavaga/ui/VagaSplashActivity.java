package br.com.olhonavaga.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import br.com.olhonavaga.R;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 11:40
 */
public class VagaSplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaga_splash_activity);

        new SplashCountDownTimer().start();
    }

    private class SplashCountDownTimer extends CountDownTimer {
        private static final long TIME = 3000;
        private static final long TICK = 500;

        private SplashCountDownTimer() {
            super(TIME, TICK);
        }

        @Override
        public void onFinish() {
            Intent intent = new Intent(VagaSplashActivity.this, VagasListActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }
    }
}