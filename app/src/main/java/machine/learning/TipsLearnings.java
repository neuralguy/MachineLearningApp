package machine.learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TipsLearnings extends AppCompatActivity {
    ScrollView scroll;
    private int previousY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_tipslearnings);
        scroll = findViewById(R.id.scrollView);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.dehaze);
        }
        updateUI();
        fab();
    }

    private void fab() {
        FloatingActionButton fabScrollToTop = findViewById(R.id.fabScrollToTop);
        scroll.getViewTreeObserver().addOnScrollChangedListener(() -> {
            if (previousY > scroll.getScrollY()) {
                fabScrollToTop.show();
            } else {
                fabScrollToTop.hide();
            }
            previousY = scroll.getScrollY();
        });

        fabScrollToTop.setOnClickListener(view -> scroll.smoothScrollTo(0, 0));
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
        if (ThemeManager.TipsLearnings) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        TextView menu1 = findViewById(R.id.menu1);
        TextView menu2 = findViewById(R.id.menu2);
        TextView menu3 = findViewById(R.id.menu3);
        TextView menu4 = findViewById(R.id.menu4);

        TextView[] paragraphs = new TextView[] {
                findViewById(R.id.aboutdata),
                findViewById(R.id.tipslearnings_with_teacher),
                findViewById(R.id.tipslearnings_without_teacher),
                findViewById(R.id.tipslearnings_reinforcement)
        };

        menu1.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[0].getTop()));
        menu2.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[1].getTop()));
        menu3.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[2].getTop()));
        menu4.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[3].getTop()));

        for (TextView paragraph: paragraphs) {
            paragraph.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));
        }

        Button themeLayout = findViewById(R.id.themeLayout);
        if (ThemeManager.getCurrentTheme(this) == R.style.customNight) {
            themeLayout.setBackgroundResource(R.color.black);
        } else {
            themeLayout.setBackgroundResource(R.color.white_theme);
        }
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(TipsLearnings.this, R.anim.change_theme_animation);
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
        ThemeManager.TipsLearnings = true;
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
        ThemeManager.TipsLearnings = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}