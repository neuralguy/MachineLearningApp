package machine.learning;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeManager {
    private static final String PREF_NAME = "DayTheme";
    private static final String KEY_THEME = "NightTheme";

    public static Boolean Main = false;
    public static Boolean Settings = false;
    public static Boolean Beginning = false;
    public static Boolean BegTest = false;
    public static Boolean ClassTask = false;
    public static Boolean Examples = false;
    public static Boolean TipsLearnings = false;
    public static Boolean TipsTest = false;
    public static Boolean WorkNeuro = false;
    public static Boolean NeuroLearning = false;


    public static void saveTheme(Context context, int theme) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_THEME, theme);
        editor.apply();
    }

    public static int getCurrentTheme(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(KEY_THEME, R.style.customDay);
    }
}