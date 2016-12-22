package com.example.idea.daynightmodechange.theme;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/**
 * 工具类，DecorView递归为view更换主题，通过资源名称找到当前主题的资源id等
 */
public class ThemeUtils {

    public static void applyThemeRecursively(Context context, Dialog dialog) {
        applyThemeRecursively(context, dialog.getWindow().getDecorView());
    }

    public static void applyThemeRecursively(Context context, View view) {
        if (isThemeEnable(context)) {
            if ((view instanceof IThemeable)) {
                ((IThemeable) view).applyTheme();
            }
            if ((view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    applyThemeRecursively(context, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void applyThemeRecursively(View view) {
        applyThemeRecursively(view.getContext(), view);
    }

    public static boolean isThemeEnable(Object object) {
        if ((object instanceof IThemeable)
                && ((IThemeable) object).isThemeEnable()) {
            return true;
        }
        return false;
    }

    public static int processColor(Context context, int colorId) {
        return processColor(context, ThemeManager.getInstance()
                .getCurrentTheme(), colorId);
    }

    public static int processColor(Context context, ThemeManager.THEME theme,
                                   int colorId) {
        int i = processColorResId(context, theme, colorId);
        return context.getResources().getColor(i);
    }

    public static ColorStateList processColorList(Context context, int paramInt) {
        return processColorList(context, ThemeManager.getInstance()
                .getCurrentTheme(), paramInt);
    }

    public static ColorStateList processColorList(Context context,
                                                  ThemeManager.THEME theme, int resourceId) {
        int i = processColorResId(context, theme, resourceId);
        return context.getResources().getColorStateList(i);
    }

    public static int processMipmapResId(Context context, int resourceId) {
        return processThemeResId(context, ThemeManager.getInstance().getCurrentTheme(), "mipmap", resourceId);
    }

    public static int processColorResId(Context context, int resourceId) {
        return processColorResId(context, ThemeManager.getInstance()
                .getCurrentTheme(), resourceId);
    }

    public static int processColorResId(Context context,
                                        ThemeManager.THEME theme, int resourceId) {
        return processThemeResId(context, theme, "color", resourceId);
    }

    public static Drawable processDrawable(Context context, int resourceId) {
        return processDrawable(context, ThemeManager.getInstance()
                .getCurrentTheme(), resourceId);
    }

    public static Drawable processDrawable(Context context,
                                           ThemeManager.THEME theme, int resourceId) {
        int themedResourceId = processDrawableResId(context, theme, resourceId);
        return context.getResources().getDrawable(themedResourceId);
    }

    public static int processDrawableResId(Context context, int resourceId) {
        return processDrawableResId(context, ThemeManager.getInstance()
                .getCurrentTheme(), resourceId);
    }

    public static int processDrawableResId(Context context,
                                           ThemeManager.THEME theme, int resourceId) {
        return processThemeResId(context, theme, "drawable", resourceId);
    }

    public static int processStyleResId(Context context, int resourceId) {
        return processStyleResId(context, ThemeManager.getInstance()
                .getCurrentTheme(), resourceId);
    }

    public static int processStyleResId(Context context,
                                        ThemeManager.THEME theme, int resourceId) {
        return processThemeResId(context, theme, "style", resourceId);
    }

    private static int processThemeResId(Context context,
                                         ThemeManager.THEME theme, String defType, int resourceId) {
        if (theme.hasResPrefix() && isThemeEnable(context)) {
            String strThemeResName = processThemeResName(theme, context
                    .getResources().getResourceName(resourceId));
            return context.getResources().getIdentifier(strThemeResName,
                    defType, context.getPackageName());
        } else {
            return resourceId;
        }
    }

    public static String processThemeResName(ThemeManager.THEME theme,
                                             String resName) {
        return theme.formatResName(resName);
    }
}
