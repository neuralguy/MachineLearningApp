package machine.learning;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Objects;

public class BegTest extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeManager.getCurrentTheme(this));
        setContentView(R.layout.activity_begtest);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        RadioButton answer1 = findViewById(R.id.radioButton1);
        answer1.setChecked(true);
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
        if (ThemeManager.BegTest) {
            animateTheme(menu);
        }
        return true;
    }

    public void animateTheme(Menu menu) {
        Button themeLayout = findViewById(R.id.themeLayout);
        Animation animation = AnimationUtils.loadAnimation(BegTest.this, R.anim.change_theme_animation);
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

    @SuppressLint("SetTextI18n")
    public void next_quest(View v) {
        TextView question = findViewById(R.id.question);
        RadioButton answer1 = findViewById(R.id.radioButton1);
        RadioButton answer2 = findViewById(R.id.radioButton2);
        RadioButton answer3 = findViewById(R.id.radioButton3);
        RadioButton answer4 = findViewById(R.id.radioButton4);
        TextView count = findViewById(R.id.count);
        Button button = findViewById(R.id.button);
        String last_quest = (String) question.getText();

        if (Objects.equals(last_quest, "Кто создал перцептрон?")) {
            if (answer3.isChecked()) score += 1;
            question.setText(R.string.beginning_test_question2);
            answer1.setText(R.string.beginning_test_answer21);
            answer2.setText(R.string.beginning_test_answer22);
            answer3.setText(R.string.beginning_test_answer23);
            answer4.setText(R.string.beginning_test_answer24);
            count.setText(R.string.two_five);
        }

        else if (Objects.equals(last_quest, "В каких годах были сделаны первые шаги в развитии данной области?")) {
            if (answer2.isChecked()) score += 1;
            question.setText(R.string.beginning_test_question3);
            answer1.setText(R.string.beginning_test_answer31);
            answer2.setText(R.string.beginning_test_answer32);
            answer3.setText(R.string.beginning_test_answer33);
            answer4.setText(R.string.beginning_test_answer34);
            count.setText(R.string.three_five);
        }

        else if (Objects.equals(last_quest, "К какой игре раньше всего применили методы машинного обучения?")) {
            if (answer4.isChecked()) score += 1;
            question.setText(R.string.beginning_test_question4);
            answer1.setText(R.string.beginning_test_answer41);
            answer2.setText(R.string.beginning_test_answer42);
            answer3.setText(R.string.beginning_test_answer43);
            answer4.setText(R.string.beginning_test_answer44);
            count.setText(R.string.four_five);
        }

        else if (Objects.equals(last_quest, "Что необходимо для обучения нейросетей?")) {
            if (answer4.isChecked()) score += 1;
            question.setText(R.string.beginning_test_question5);
            answer1.setText(R.string.beginning_test_answer51);
            answer2.setText(R.string.beginning_test_answer52);
            answer3.setText(R.string.beginning_test_answer53);
            answer4.setText(R.string.beginning_test_answer54);
            count.setText(R.string.five_five);
        }

        else if (Objects.equals(last_quest, "Почему используют нейросети?")) {
            if (answer1.isChecked()) score += 1;
            question.setText("Результат: "+score+"/5");
            count.setVisibility(View.INVISIBLE);
            button.setText("Завершить тест");
        }

        else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, Beginning.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void changeTheme(MenuItem item) {
        if (ThemeManager.getCurrentTheme(this) == R.style.customDay) {
            ThemeManager.saveTheme(this, R.style.customNight);
        } else {
            ThemeManager.saveTheme(this, R.style.customDay);
        }
        ThemeManager.BegTest = true;
        recreate();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Beginning.class));
        finish();
    }
}