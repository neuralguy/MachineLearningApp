package machine.learning;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class WorkNeuro extends AppCompatActivity {
    ScrollView scroll;
    private int previousY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_workneuro);
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
        if (ThemeManager.WorkNeuro) {
            animateTheme(menu);
        }
        return true;
    }

    public void updateUI() {
        TextView neuralnet = findViewById(R.id.workneuro_menu1);
        TextView activation_function = findViewById(R.id.workneuro_menu2);
        TextView types_of_functions = findViewById(R.id.workneuro_menu3);

        TextView[] paragraphs = new TextView[]{
                findViewById(R.id.whats_neural_network),
                findViewById(R.id.activation_function),
                findViewById(R.id.types_of_functions)
        };

        neuralnet.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[0].getTop()));
        activation_function.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[1].getTop()));
        types_of_functions.setOnClickListener(v -> scroll.smoothScrollTo(0, paragraphs[2].getTop()));

        for (TextView paragraph : paragraphs) {
            paragraph.setOnClickListener(v -> scroll.smoothScrollTo(0, 0));
        }

        ImageView[] imageViews = new ImageView[]{
                findViewById(R.id.perceptron_img),
                findViewById(R.id.neural_net_img),
                findViewById(R.id.linear_img),
                findViewById(R.id.not_linear_img),
                findViewById(R.id.relu_img),
                findViewById(R.id.leaky_relu_img),
                findViewById(R.id.sigmoid_img),
        };

        ColorMatrix colorMatrix_Invert = new ColorMatrix();
        colorMatrix_Invert.set(new float[]{
                -1, 0, 0, 0, 255, // Красный
                0, -1, 0, 0, 255, // Зеленый
                0, 0, -1, 0, 255, // Синий
                0, 0, 0, 1, 0     // Альфа
        });
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix_Invert);

        Button themeLayout = findViewById(R.id.themeLayout);
        int currentTheme = ThemeManager.getCurrentTheme(this);

        if (currentTheme == R.style.customNight) {
            themeLayout.setBackgroundResource(R.color.black);
        } else {
            themeLayout.setBackgroundResource(R.color.white_theme);
        }

        for (ImageView imageView : imageViews) {
            if (currentTheme == R.style.customNight) {
                imageView.setColorFilter(colorFilter);
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(WorkNeuro.this, R.anim.change_theme_animation);
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
        ThemeManager.WorkNeuro = true;
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
        ThemeManager.WorkNeuro = false;
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}