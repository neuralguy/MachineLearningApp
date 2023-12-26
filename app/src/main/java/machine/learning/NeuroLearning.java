package machine.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NeuroLearning extends AppCompatActivity {
    ScrollView scroll;
    private int previousY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_neurolearning);
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
        if (ThemeManager.NeuroLearning) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        TextView menu1 = findViewById(R.id.neurolearning_menu1);
        TextView menu2 = findViewById(R.id.neurolearning_menu2);
        TextView menu3 = findViewById(R.id.neurolearning_menu3);
        TextView menu4 = findViewById(R.id.neurolearning_menu4);

        TextView[] paragraphs = new TextView[] {
                findViewById(R.id.howneurolearning),
                findViewById(R.id.lossfunction),
                findViewById(R.id.backpropagation),
                findViewById(R.id.learning_rate)
        };

        menu1.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[0].getTop()));
        menu2.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[1].getTop()));
        menu3.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[2].getTop()));
        menu4.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[3].getTop()));

        for (TextView paragraph: paragraphs) {
            paragraph.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));
        }

        ImageView[] imageViews = new ImageView[] {
                findViewById(R.id.mse_img),
                findViewById(R.id.last_neuro_img),
                findViewById(R.id.a_img),
                findViewById(R.id.z_img),
                findViewById(R.id.c_img),
                findViewById(R.id.connections_img),
                findViewById(R.id.update_w_img),
                findViewById(R.id.chain_rule_img),
                findViewById(R.id.chain_rule_explain_img),
                findViewById(R.id.der_1_img),
                findViewById(R.id.der_2_img),
                findViewById(R.id.der_3_img),
                findViewById(R.id.diff_log_img),
                findViewById(R.id.express_diff_img),
        };

        ColorMatrix colorMatrix_Invert = new ColorMatrix();
        colorMatrix_Invert.set(new float[] {
                -1,  0,  0,  0, 255, // Красный
                0, -1,  0,  0, 255, // Зеленый
                0,  0, -1,  0, 255, // Синий
                0,  0,  0,  1, 0     // Альфа
        });
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix_Invert);

        Button themeLayout = findViewById(R.id.themeLayout);
        int currentTheme = ThemeManager.getCurrentTheme(this);

        if (currentTheme == R.style.customNight) {
            themeLayout.setBackgroundResource(R.color.black);
        } else {
            themeLayout.setBackgroundResource(R.color.white_theme);
        }

        for (ImageView imageView: imageViews) {
            if (currentTheme == R.style.customNight) {
                imageView.setColorFilter(colorFilter);
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(NeuroLearning.this, R.anim.change_theme_animation);
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
            public void onAnimationRepeat(Animation animation) {}
        });
        themeLayout.startAnimation(animation);
    }

    public void changeTheme(MenuItem item) {
        if (ThemeManager.getCurrentTheme(this) == R.style.customDay) {
            ThemeManager.saveTheme(this, R.style.customNight);
        } else {
            ThemeManager.saveTheme(this, R.style.customDay);
        }
        ThemeManager.NeuroLearning = true;
        recreate();
    }

    public boolean goToActivity (MenuItem item){
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
        ThemeManager.NeuroLearning = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}