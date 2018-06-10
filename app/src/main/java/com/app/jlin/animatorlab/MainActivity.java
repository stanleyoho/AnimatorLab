package com.app.jlin.animatorlab;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.app.jlin.animatorlab.databinding.ActivityMainBinding;

/**
 * Created by stanley.lin on 2018/6/5.
 *
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initEvent();
    }

    private void initEvent(){
        binding.btnAlpht.setOnClickListener(clickListener);
        binding.btnRotate.setOnClickListener(clickListener);
        binding.btnScale.setOnClickListener(clickListener);
        binding.btnTranslate.setOnClickListener(clickListener);
        binding.btnMix.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            switch (viewId){
                case R.id.btnAlpht:
                    startActivity(new Intent(MainActivity.this,AlphaAnimatorActivity.class));
                    break;
                case R.id.btnRotate:
                    startActivity(new Intent(MainActivity.this,RotateAnimatorActivity.class));
                    break;
                case R.id.btnScale:
                    startActivity(new Intent(MainActivity.this,ScaleAnimatorActivity.class));
                    break;
                case R.id.btnTranslate:
                    startActivity(new Intent(MainActivity.this,TranslateAnimatorActivity.class));
                    break;
                case R.id.btnMix:
                    startActivity(new Intent(MainActivity.this,MixActivity.class));
                    break;
            }
        }
    };
}
