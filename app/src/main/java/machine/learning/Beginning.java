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

public class Beginning extends AppCompatActivity {
    ScrollView scroll;
    private int previousY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_beginning);
        scroll = findViewById(R.id.scrollView);
        updateUI();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.dehaze);
        }
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
        if (ThemeManager.Beginning) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        TextView history = findViewById(R.id.textView2);
        TextView relevance = findViewById(R.id.textView3);
        TextView requirements = findViewById(R.id.textView4);
        TextView paragraph1 = findViewById(R.id.textView5);
        TextView paragraph2 = findViewById(R.id.textView7);
        TextView paragraph3 = findViewById(R.id.textView9);

        history.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraph1.getTop()));
        relevance.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraph2.getTop()));
        requirements.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraph3.getTop()));
        paragraph1.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));
        paragraph2.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));
        paragraph3.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));

        Button themeLayout = findViewById(R.id.themeLayout);

        if (ThemeManager.getCurrentTheme(this) == R.style.customNight) {
            themeLayout.setBackgroundResource(R.color.black);
        } else {
            themeLayout.setBackgroundResource(R.color.white_theme);
        }
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(Beginning.this, R.anim.change_theme_animation);
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
        ThemeManager.Beginning = true;
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
        ThemeManager.Beginning = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}