package com.click.store.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.click.store.R;
import com.click.store.common.Constant;
import com.click.store.common.util.ACache;
import com.eftimoff.androipathview.PathView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.pathView)
    PathView pathView;
    @BindView(R.id.activity_welcome)
    LinearLayout activityWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        pathView.getPathAnimator()
                .delay(100)
                .duration(500)
                .interpolator(new AccelerateDecelerateInterpolator())
                .listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {
                        jump();
                    }
                })
                .start();
    }

    private void jump() {

        String isShowGuide = ACache.get(this).getAsString(Constant.IS_SHOW_GUIDE);

        // 第一次启动进入引导页面
        if (null == isShowGuide) {
            startActivity(new Intent(this, GuideActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        this.finish();
    }
}
