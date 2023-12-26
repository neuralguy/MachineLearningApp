package machine.learning;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class ClassTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_classtask);
        updateUI();
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
        if (ThemeManager.ClassTask) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        ScrollView scroll = findViewById(R.id.scrollView);
        TextView classification = findViewById(R.id.textView2);
        TextView paragraph1 = findViewById(R.id.textView5);

        classification.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraph1.getTop()));

        Button themeLayout = findViewById(R.id.themeLayout);

        if (ThemeManager.getCurrentTheme(this) == R.style.customNight) {
            themeLayout.setBackgroundResource(R.color.black);
        } else {
            themeLayout.setBackgroundResource(R.color.white_theme);
        }
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(ClassTask.this, R.anim.change_theme_animation);
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
        ThemeManager.ClassTask = true;
        recreate();
    }

    public boolean goToActivity(MenuItem item) {
        Navigator.getInstance().ToActivity(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    public void copyCode(View view) {
        String codeToCopy = null;

        switch (view.getId()) {
            case R.id.copy1:
                codeToCopy = this.getString(R.string.classification_code1);
                break;
            case R.id.copy2:
                codeToCopy = this.getString(R.string.classification_code2);
                break;
        }
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("copiedCode", codeToCopy);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "Код скопирован в буфер обмена", Toast.LENGTH_SHORT).show();
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
        ThemeManager.ClassTask = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}