package com.gengmei.animdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.gengmei.animdemo.R;
import com.gengmei.animdemo.SlideBackLayout;
import com.gengmei.animdemo.StorageUtils;
import com.gengmei.animdemo.UtilsManager;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        LottieAnimationView lottieAnimationView = findViewById(R.id.LottieAnimationView);
        UtilsManager.getInstance().setApplicationContext(getApplication());
        String imagePath = StorageUtils.PIC_CACHE + "/anim.json";
        File file = new File(imagePath);
//判断文件夹是否存在,如果不存在则创建文件夹
        if (!file.exists()) {
            Toast.makeText(this, "请把文件放到webp文件/anim.json文件夹下", Toast.LENGTH_SHORT).show();
            return;
        }
//        lottieAnimationView.setAnimation(imagePath);
        View root_view = findViewById(R.id.root_view);
        SlideBackLayout slidebackLayout = new SlideBackLayout(this, lottieAnimationView);
        slidebackLayout.bind();
    }
}
