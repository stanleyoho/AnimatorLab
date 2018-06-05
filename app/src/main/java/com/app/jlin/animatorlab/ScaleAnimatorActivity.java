package com.app.jlin.animatorlab;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.app.jlin.animatorlab.databinding.ActivityScaleAnimatorBinding;

public class ScaleAnimatorActivity extends AppCompatActivity {

    private ActivityScaleAnimatorBinding binding;
    private Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_scale_animator);
        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(this,R.array.scaleArray,android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(arrayAdapter);
        initEvent();
    }

    private void initEvent(){
        binding.button.setOnClickListener(clickListener);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        animation = AnimationUtils.loadAnimation(ScaleAnimatorActivity.this,R.anim.scale_type_1);
                        binding.textView.setText(getResources().getString(R.string.scaleItem0));
                        break;
                    case 1:
                        animation = AnimationUtils.loadAnimation(ScaleAnimatorActivity.this,R.anim.scale_type_1_with_pivot);
                        break;
                    case 2:
                        animation = AnimationUtils.loadAnimation(ScaleAnimatorActivity.this,R.anim.scale_type_1_with_pivot_persent);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();
            switch (viewId){
                case R.id.button:
                    binding.iv.startAnimation(animation);
                    break;
            }
        }
    };
}
