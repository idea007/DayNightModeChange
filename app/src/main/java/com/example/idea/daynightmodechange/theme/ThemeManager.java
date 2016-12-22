package com.example.idea.daynightmodechange.theme;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.idea.daynightmodechange.config.Config;

/**
 * Created by idea on 2016/12/22.
 * 需要切换主题的View，在IThemeable的applyTheme回调方法中调用applyXXX方法设置主题对应的资源
 */

public class ThemeManager {
    //FIXME 从sp中获取当前的主题
    private THEME theme = Config.currentTheme;

    private static ThemeManager instance;

    private ThemeManager() {
    }

    public static ThemeManager getInstance(){
        if(instance==null)
            instance=new ThemeManager();
        return instance;
    }

    public ThemeManager applyTheme(Context context,int resourceId) {
        context.setTheme(ThemeUtils.processStyleResId(context,
                this.theme, resourceId));
        return this;
    }


    public ThemeManager applyBackgroundColor(Context context, View view,
                                            int backgroundResourceId) {
        view.setBackgroundResource(ThemeUtils.processColorResId(context,
                this.theme, backgroundResourceId));
        return this;
    }


    public ThemeManager applyBackgroundColor(View view, int backgroundResourceId) {
        return applyBackgroundColor(view.getContext(), view,
                backgroundResourceId);
    }

    public ThemeManager applyBackgroundColor(View view, int viewId,
                                            int backgroundColorId) {
        return applyBackgroundColor(view.findViewById(viewId),
                backgroundColorId);
    }

    public ThemeManager applyBackgroundDrawable(Context context, View view,
                                               int backgroundDrawableId) {
        view.setBackgroundResource(ThemeUtils.processDrawableResId(context,
                this.theme, backgroundDrawableId));
        return this;
    }

    public ThemeManager applyBackgroundDrawable(View view,
                                               int backgroundDrawableId) {
        return applyBackgroundDrawable(view.getContext(), view,
                backgroundDrawableId);
    }

    public ThemeManager applyBackgroundDrawable(View view, int viewId,
                                               int backgroundDrawableId) {
        return applyBackgroundDrawable(view.findViewById(viewId),
                backgroundDrawableId);
    }

    public ThemeManager applyButtonTextColor(View btnView, int viewId,
                                            int btnTextColorId) {
        return applyTextColor((Button) btnView.findViewById(viewId),
                btnTextColorId);
    }

    public ThemeManager applyImageResource(Context context, ImageView imageView,
                                          int drawableId) {
        imageView.setImageResource(ThemeUtils.processDrawableResId(context,
                this.theme, drawableId));
        return this;
    }

    public ThemeManager applyImageResource(View view, int viewId,
                                          int imageResourceId) {
        return applyImageResource((ImageView) view.findViewById(viewId),
                imageResourceId);
    }

    public ThemeManager applyImageResource(ImageView imageView,
                                          int imageResourceId) {
        return applyImageResource(imageView.getContext(), imageView,
                imageResourceId);
    }

    public ThemeManager applyListDivider(Context context, ListView listView,
                                        int drawableId) {
        listView.setDivider(ThemeUtils.processDrawable(context, this.theme,
                drawableId));
        return this;
    }

    public ThemeManager applyListDivider(ListView listView, int drawableId) {
        return applyListDivider(listView.getContext(), listView, drawableId);
    }

    public ThemeManager applyListSelector(Context context, ListView listView,
                                         int drawableId) {
        listView.setSelector(ThemeUtils.processDrawable(context, this.theme,
                drawableId));
        return this;
    }

    public ThemeManager applyListSelector(ListView listView, int drawableId) {
        return applyListSelector(listView.getContext(), listView, drawableId);
    }

    public ThemeManager applyProgressDrawable(Context context,
                                             ProgressBar progressBar, int drawableId) {
        LayerDrawable layerDrawable = (LayerDrawable) progressBar
                .getProgressDrawable();
        Drawable drawable = ThemeUtils.processDrawable(context, this.theme,
                drawableId);
        drawable.setBounds(layerDrawable.getBounds());
        progressBar.setProgressDrawable(drawable);
        return this;
    }

    public ThemeManager applyProgressDrawable(ProgressBar progressBar,
                                             int drawableId) {
        return applyProgressDrawable(progressBar.getContext(), progressBar,
                drawableId);
    }

    public ThemeManager applySeekbarThumb(Context context, SeekBar seekBar,
                                         int drawableId) {
        Drawable drawable = ThemeUtils.processDrawable(context, this.theme,
                drawableId);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        seekBar.setThumb(drawable);
        return this;
    }

    public ThemeManager applySeekbarThumb(SeekBar seekBar, int drawableId) {
        return applySeekbarThumb(seekBar.getContext(), seekBar, drawableId);
    }

    public ThemeManager applyTextColor(Context context, Button button,
                                      int colorId) {
        button.setTextColor(ThemeUtils.processColorList(context, this.theme,
                colorId));
        return this;
    }

    public ThemeManager applyTextColor(Context context, TextView textView,
                                      int textColorId) {
        textView.setTextColor(ThemeUtils.processColorList(context, this.theme,
                textColorId));
        return this;
    }

    public ThemeManager applyTextColor(View view, int viewId, int textColorId) {
        return applyTextColor((TextView) view.findViewById(viewId), textColorId);
    }

    public ThemeManager applyTextColor(Button button, int textColorId) {
        return applyTextColor(button.getContext(), button, textColorId);
    }

    public ThemeManager applyTextColor(TextView textView, int paramInt) {
        return applyTextColor(textView.getContext(), textView, paramInt);
    }

    public ThemeManager applyTextDrawable(Context context, TextView textView,
                                         int leftResourceId, int topResourceId, int rightResourceId,
                                         int bottomResourceId) {
        int leftId = leftResourceId > 0 ? ThemeUtils.processDrawableResId(
                context, this.theme, leftResourceId) : 0;
        int topId = topResourceId > 0 ? ThemeUtils.processDrawableResId(
                context, this.theme, topResourceId) : 0;
        int rightId = rightResourceId > 0 ? ThemeUtils.processDrawableResId(
                context, this.theme, rightResourceId) : 0;
        int bottomId = bottomResourceId > 0 ? ThemeUtils.processDrawableResId(
                context, this.theme, bottomResourceId) : 0;
        textView.setCompoundDrawablesWithIntrinsicBounds(leftId, topId,
                rightId, bottomId);

        return null;
    }

    public ThemeManager applyTextDrawable(TextView textView, int leftResourceId,
                                         int topResourceId, int rightResourceId, int bottomResourceId) {
        return applyTextDrawable(textView.getContext(), textView,
                leftResourceId, topResourceId, rightResourceId,
                bottomResourceId);
    }

    public ThemeManager applyTextLeftDrawable(Context context,
                                             TextView textView, int drawableId) {
        return applyTextDrawable(context, textView, drawableId, 0, 0, 0);
    }

    public ThemeManager applyTextLeftDrawable(TextView textView, int drawableId) {
        return applyTextDrawable(textView, drawableId, 0, 0, 0);
    }

    public ThemeManager applyTextRightDrawable(TextView textView, int drawableId) {
        return applyTextDrawable(textView, 0, 0, drawableId, 0);
    }

    public ThemeManager applyTextTopDrawable(Context context, TextView textView,
                                            int paramInt) {
        return applyTextDrawable(context, textView, 0, paramInt, 0, 0);
    }

    public ThemeManager applyTextTopDrawable(TextView textView, int drawableId) {
        return applyTextDrawable(textView, 0, drawableId, 0, 0);
    }

    public void changeTheme(THEME t) {
        theme = t;
        Config.currentTheme=t;
    }

    public THEME getCurrentTheme() {
        return getTheme();
    }

    public THEME getTheme() {
        return theme;
    }

    /**
     * 枚举类型
     */
    public static enum THEME {
        DAY, NIGHT("_night");

        String resPrefix;

        private THEME() {
            resPrefix = "";
        }

        private THEME(String prefix) {
            resPrefix = prefix;
        }

        /**
         * 资源名称
         * @param name
         * @return
         */
        public String formatResName(String name) {
            return name + resPrefix;
        }

        public boolean hasResPrefix() {
            return !TextUtils.isEmpty(resPrefix);
        }
    }


}
