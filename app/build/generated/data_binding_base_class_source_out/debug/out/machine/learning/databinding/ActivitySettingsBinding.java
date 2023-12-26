// Generated by view binder compiler. Do not edit!
package machine.learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import machine.learning.R;

public final class ActivitySettingsBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final LinearLayout beginningContent;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final TextView fontsize;

  @NonNull
  public final TextView fontsizeNum;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final SeekBar seekBar;

  @NonNull
  public final Button themeLayout;

  private ActivitySettingsBinding(@NonNull DrawerLayout rootView,
      @NonNull LinearLayout beginningContent, @NonNull DrawerLayout drawerLayout,
      @NonNull TextView fontsize, @NonNull TextView fontsizeNum, @NonNull NavigationView navView,
      @NonNull ScrollView scrollView, @NonNull SeekBar seekBar, @NonNull Button themeLayout) {
    this.rootView = rootView;
    this.beginningContent = beginningContent;
    this.drawerLayout = drawerLayout;
    this.fontsize = fontsize;
    this.fontsizeNum = fontsizeNum;
    this.navView = navView;
    this.scrollView = scrollView;
    this.seekBar = seekBar;
    this.themeLayout = themeLayout;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.beginning_content;
      LinearLayout beginningContent = ViewBindings.findChildViewById(rootView, id);
      if (beginningContent == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.fontsize;
      TextView fontsize = ViewBindings.findChildViewById(rootView, id);
      if (fontsize == null) {
        break missingId;
      }

      id = R.id.fontsize_num;
      TextView fontsizeNum = ViewBindings.findChildViewById(rootView, id);
      if (fontsizeNum == null) {
        break missingId;
      }

      id = R.id.nav_view;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.seekBar;
      SeekBar seekBar = ViewBindings.findChildViewById(rootView, id);
      if (seekBar == null) {
        break missingId;
      }

      id = R.id.themeLayout;
      Button themeLayout = ViewBindings.findChildViewById(rootView, id);
      if (themeLayout == null) {
        break missingId;
      }

      return new ActivitySettingsBinding((DrawerLayout) rootView, beginningContent, drawerLayout,
          fontsize, fontsizeNum, navView, scrollView, seekBar, themeLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}