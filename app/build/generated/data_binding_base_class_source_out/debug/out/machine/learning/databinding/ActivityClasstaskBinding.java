// Generated by view binder compiler. Do not edit!
package machine.learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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

public final class ActivityClasstaskBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final LinearLayout classtaskContent;

  @NonNull
  public final TextView code1;

  @NonNull
  public final TextView code2;

  @NonNull
  public final TextView comment1;

  @NonNull
  public final TextView comment2;

  @NonNull
  public final Button copy1;

  @NonNull
  public final Button copy2;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  @NonNull
  public final Button themeLayout;

  private ActivityClasstaskBinding(@NonNull DrawerLayout rootView,
      @NonNull LinearLayout classtaskContent, @NonNull TextView code1, @NonNull TextView code2,
      @NonNull TextView comment1, @NonNull TextView comment2, @NonNull Button copy1,
      @NonNull Button copy2, @NonNull DrawerLayout drawerLayout, @NonNull NavigationView navView,
      @NonNull ScrollView scrollView, @NonNull TextView textView1, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5,
      @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8,
      @NonNull TextView textView9, @NonNull Button themeLayout) {
    this.rootView = rootView;
    this.classtaskContent = classtaskContent;
    this.code1 = code1;
    this.code2 = code2;
    this.comment1 = comment1;
    this.comment2 = comment2;
    this.copy1 = copy1;
    this.copy2 = copy2;
    this.drawerLayout = drawerLayout;
    this.navView = navView;
    this.scrollView = scrollView;
    this.textView1 = textView1;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
    this.themeLayout = themeLayout;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityClasstaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityClasstaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_classtask, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityClasstaskBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.classtask_content;
      LinearLayout classtaskContent = ViewBindings.findChildViewById(rootView, id);
      if (classtaskContent == null) {
        break missingId;
      }

      id = R.id.code1;
      TextView code1 = ViewBindings.findChildViewById(rootView, id);
      if (code1 == null) {
        break missingId;
      }

      id = R.id.code2;
      TextView code2 = ViewBindings.findChildViewById(rootView, id);
      if (code2 == null) {
        break missingId;
      }

      id = R.id.comment1;
      TextView comment1 = ViewBindings.findChildViewById(rootView, id);
      if (comment1 == null) {
        break missingId;
      }

      id = R.id.comment2;
      TextView comment2 = ViewBindings.findChildViewById(rootView, id);
      if (comment2 == null) {
        break missingId;
      }

      id = R.id.copy1;
      Button copy1 = ViewBindings.findChildViewById(rootView, id);
      if (copy1 == null) {
        break missingId;
      }

      id = R.id.copy2;
      Button copy2 = ViewBindings.findChildViewById(rootView, id);
      if (copy2 == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

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

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      id = R.id.themeLayout;
      Button themeLayout = ViewBindings.findChildViewById(rootView, id);
      if (themeLayout == null) {
        break missingId;
      }

      return new ActivityClasstaskBinding((DrawerLayout) rootView, classtaskContent, code1, code2,
          comment1, comment2, copy1, copy2, drawerLayout, navView, scrollView, textView1, textView2,
          textView3, textView4, textView5, textView6, textView7, textView8, textView9, themeLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
