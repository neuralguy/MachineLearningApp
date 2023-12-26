package machine.learning;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

public class Navigator {
    private static Navigator instance;

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    @SuppressLint("NonConstantResourceId")
    public void ToActivity(Activity activity, Integer id) {
        Intent intent = null;
        ThemeManager.Main = false;

        switch (id) {
            case R.id.beginning:
                ThemeManager.Beginning = false;
                intent = new Intent(activity, Beginning.class);
                break;
            case R.id.tipslearnings:
                ThemeManager.TipsLearnings = false;
                intent = new Intent(activity, TipsLearnings.class);
                break;
            case R.id.settings:
                ThemeManager.Settings = false;
                intent = new Intent(activity, Settings.class);
                break;
            case R.id.workneuro:
                ThemeManager.WorkNeuro = false;
                intent = new Intent(activity, WorkNeuro.class);
                break;
            case R.id.neurolearning:
                ThemeManager.NeuroLearning = false;
                intent = new Intent(activity, NeuroLearning.class);
                break;
        }

        if (intent != null) {
            activity.startActivity(intent);
            activity.finish();
        }
    }
}