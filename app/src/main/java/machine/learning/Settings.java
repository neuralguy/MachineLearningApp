package machine.learning;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_settings);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.dehaze);
        }
        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_change_theme);
        if (ThemeManager.getCurrentTheme(this) == R.style.customDay) {
            item.setIcon(R.drawable.sun);
        } else {
            item.setIcon(R.drawable.moon);
        }
        if (ThemeManager.Settings) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView textView = findViewById(R.id.fontsize);
        final TextView fontsize_num = findViewById(R.id.fontsize_num);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int end_progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 10) progress = 10;
                end_progress = progress;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
                fontsize_num.setText(String.format("%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Начало изменения значения ползунка
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Resources res = getResources();
                Configuration configuration = res.getConfiguration();
                configuration.fontScale = end_progress / 22f;
                res.updateConfiguration(configuration, res.getDisplayMetrics());
                TextView header = findViewById(R.id.header);
            }
        });
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(Settings.this, R.anim.change_theme_animation);
        MenuItem change_theme_btn = menu.findItem(R.id.action_change_theme);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                themeLayout.setAlpha(1);
                change_theme_btn.setEnabled(false);
                themeLayout.setEnabled(true);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                themeLayout.setAlpha(0);
                change_theme_btn.setEnabled(true);
                themeLayout.setEnabled(false);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        themeLayout.startAnimation(animation);
    }

    public void changeTheme(MenuItem item) {
        if (ThemeManager.getCurrentTheme(this) == R.style.customDay) {
            ThemeManager.saveTheme(this, R.style.customNight);
        } else {
            ThemeManager.saveTheme(this, R.style.customDay);
        }
        ThemeManager.Settings = true;
        recreate();
    }

    public boolean goToActivity(MenuItem item) {
        Navigator.getInstance().ToActivity(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        ThemeManager.Settings = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}