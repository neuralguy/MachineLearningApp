// Generated by view binder compiler. Do not edit!
package machine.learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import machine.learning.R;

public final class ActivityExamplesBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final Button button1;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final FloatingActionButton fabScrollToTop;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final Button themeLayout;

  @NonNull
  public final LinearLayout tipslearningContent;

  private ActivityExamplesBinding(@NonNull DrawerLayout rootView, @NonNull Button button1,
      @NonNull DrawerLayout drawerLayout, @NonNull FloatingActionButton fabScrollToTop,
      @NonNull NavigationView navView, @NonNull ScrollView scrollView, @NonNull Button themeLayout,
      @NonNull LinearLayout tipslearningContent) {
    this.rootView = rootView;
    this.button1 = button1;
    this.drawerLayout = drawerLayout;
    this.fabScrollToTop = fabScrollToTop;
    this.navView = navView;
    this.scrollView = scrollView;
    this.themeLayout = themeLayout;
    this.tipslearningContent = tipslearningContent;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityExamplesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityExamplesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_examples, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityExamplesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button1;
      Button button1 = ViewBindings.findChildViewById(rootView, id);
      if (button1 == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.fabScrollToTop;
      FloatingActionButton fabScrollToTop = ViewBindings.findChildViewById(rootView, id);
      if (fabScrollToTop == null) {
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

      id = R.id.themeLayout;
      Button themeLayout = ViewBindings.findChildViewById(rootView, id);
      if (themeLayout == null) {
        break missingId;
      }

      id = R.id.tipslearning_content;
      LinearLayout tipslearningContent = ViewBindings.findChildViewById(rootView, id);
      if (tipslearningContent == null) {
        break missingId;
      }

      return new ActivityExamplesBinding((DrawerLayout) rootView, button1, drawerLayout,
          fabScrollToTop, navView, scrollView, themeLayout, tipslearningContent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}