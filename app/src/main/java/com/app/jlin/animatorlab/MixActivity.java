package com.app.jlin.animatorlab;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.app.jlin.animatorlab.databinding.ActivityMixBinding;

public class MixActivity extends AppCompatActivity {

    private ActivityMixBinding binding;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mix);

        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(this,R.array.mixArray,android.R.layout.simple_spinner_dropdown_item);
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
                        animation = AnimationUtils.loadAnimation(MixActivity.this,R.anim.mix);
                        binding.textView.setText(getResources().getString(R.string.mixdetail));
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
