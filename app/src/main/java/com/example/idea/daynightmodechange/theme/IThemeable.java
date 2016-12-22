package com.example.idea.daynightmodechange.theme;

/**
 * Created by idea on 2016/12/22.
 *
 * 需要切换日夜间模式的View(这里主要是自定义view)或者Activity需要实现该接口
 */

public interface IThemeable {
    /**
     *
     */
    public void applyTheme();

    /**
     * 获取 ThemeManager
     * @returna
     */
    public ThemeManager getThemeManager();

    /**
     * 是否支持模式切换
     * @return
     */
    public boolean isThemeEnable();
}
