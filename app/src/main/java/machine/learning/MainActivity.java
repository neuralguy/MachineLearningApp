package machine.learning;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_main);
//        updateUI();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.dehaze);
        }
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
        if (ThemeManager.Main) {
            animateTheme(menu);
        }
        return true;
    }

//    public void updateUI() {
//        Button themeLayout = findViewById(R.id.themeLayout);
//        ConstraintLayout rootLayout = findViewById(R.id.main_layout);
//
//        if (ThemeManager.getCurrentTheme(this) == R.style.customNight) {
//            rootLayout.setBackgroundResource(R.drawable.back_main_night);
//            themeLayout.setBackgroundResource(R.color.black);
//        } else {
//            rootLayout.setBackgroundResource(R.drawable.back_main_day);
//            themeLayout.setBackgroundResource(R.color.white_theme);
//        }
//    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);

        if (ThemeManager.Main) {
            Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.change_theme_animation);
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
    }

    public void changeTheme(MenuItem item) {
        if (ThemeManager.getCurrentTheme(this) == R.style.customDay) {
            ThemeManager.saveTheme(this, R.style.customNight);
        } else {
            ThemeManager.saveTheme(this, R.style.customDay);
        }
        ThemeManager.Main = true;
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
        new AlertDialog.Builder(this)
                .setMessage("Вы уверены, что хотите выйти?")
                .setPositiveButton("Да", (dialog, which) -> System.exit(0))
                .setNegativeButton("Нет", null)
                .show();
    }
}