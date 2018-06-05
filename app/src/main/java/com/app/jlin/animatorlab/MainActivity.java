package com.app.jlin.animatorlab;

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
 */

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Animation scaleAnimation,scaleAnimationWithPivot,getScaleAnimationWithPivotPersent;
    private int scaleCount,rotateCount,alphaCount,translateCount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initEvent();
        initAnimator();
    }

    private void initEvent(){
        binding.btnAlpha.setOnClickListener(clickListener);
        binding.btnScale.setOnClickListener(clickListener);
        binding.btnRotate.setOnClickListener(clickListener);
        binding.btnTranslate.setOnClickListener(clickListener);
    }

    private void initAnimator(){
        scaleAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_type_1);
        scaleAnimationWithPivot = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_type_1_with_pivot);
        getScaleAnimationWithPivotPersent = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_type_1_with_pivot_persent);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            switch (viewId){
                case R.id.btnAlpha:

                    break;
                case R.id.btnScale:

                    binding.iv.startAnimation(getScaleAnimationWithPivotPersent);
                    scaleCount++;
                    break;
                case R.id.btnRotate:
                    break;
                case R.id.btnTranslate:
                    break;
            }
        }
    };
}
