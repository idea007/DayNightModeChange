package com.example.idea.daynightmodechange;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.idea.daynightmodechange.config.Config;
import com.example.idea.daynightmodechange.theme.IThemeable;
import com.example.idea.daynightmodechange.theme.ThemeManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestStyleActivity extends AppCompatActivity implements IThemeable {


    @BindView(R.id.ll_container)
    LinearLayout ll_container;
    @BindView(R.id.tv_text1)
    TextView tv_text1;
    @BindView(R.id.tv_text2)
    TextView tv_text2;
    @BindView(R.id.iv_image)
    ImageView iv_image;
    @BindView(R.id.btn_change_mode)
    Button btn_change_mode;
    @BindView(R.id.btn_jump)
    Button btn_jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //切换style的操作要放到setContentView() 之前
        getThemeManager().applyTheme(TestStyleActivity.this, R.style.TestTheme);

        setContentView(R.layout.act_home);
        ButterKnife.bind(this);

        initView();
        initTheme();

    }

    private void initTheme() {
        getThemeManager().applyBackgroundColor(ll_container, R.color.color_home_bg);
        getThemeManager().applyTextColor(tv_text1, R.color.color_text);
        getThemeManager().applyImageResource(iv_image, R.drawable.shape_iv_bg);
        getThemeManager().applyBackgroundDrawable(btn_jump, R.drawable.selector_text_bg);
        getThemeManager().applyBackgroundDrawable(btn_change_mode, R.drawable.selector_text_bg);
    }

    private void initView() {
        btn_change_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Config.currentTheme == ThemeManager.THEME.DAY) {
                    getThemeManager().changeTheme(ThemeManager.THEME.NIGHT);
                } else {
                    getThemeManager().changeTheme(ThemeManager.THEME.DAY);
                }

                applyTheme();

            }
        });
    }

    @Override
    public void applyTheme() {
        recreate();
    }

    @Override
    public ThemeManager getThemeManager() {
        return ThemeManager.getInstance();
    }

    @Override
    public boolean isThemeEnable() {
        return true;
    }
}
