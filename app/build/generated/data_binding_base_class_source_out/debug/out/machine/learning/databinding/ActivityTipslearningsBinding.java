// Generated by view binder compiler. Do not edit!
package machine.learning.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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

public final class ActivityTipslearningsBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final TextView aboutdata;

  @NonNull
  public final TextView aboutdataText1;

  @NonNull
  public final ImageView dataImg;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final FloatingActionButton fabScrollToTop;

  @NonNull
  public final TextView menu1;

  @NonNull
  public final TextView menu2;

  @NonNull
  public final TextView menu3;

  @NonNull
  public final TextView menu4;

  @NonNull
  public final TextView mse;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView13;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  @NonNull
  public final Button themeLayout;

  @NonNull
  public final LinearLayout tipslearningContent;

  @NonNull
  public final TextView tipslearningsReinforcement;

  @NonNull
  public final TextView tipslearningsWithTeacher;

  @NonNull
  public final TextView tipslearningsWithoutTeacher;

  private ActivityTipslearningsBinding(@NonNull DrawerLayout rootView, @NonNull TextView aboutdata,
      @NonNull TextView aboutdataText1, @NonNull ImageView dataImg,
      @NonNull DrawerLayout drawerLayout, @NonNull FloatingActionButton fabScrollToTop,
      @NonNull TextView menu1, @NonNull TextView menu2, @NonNull TextView menu3,
      @NonNull TextView menu4, @NonNull TextView mse, @NonNull NavigationView navView,
      @NonNull ScrollView scrollView, @NonNull TextView textView1, @NonNull TextView textView11,
      @NonNull TextView textView12, @NonNull TextView textView13, @NonNull TextView textView15,
      @NonNull TextView textView16, @NonNull TextView textView17, @NonNull TextView textView7,
      @NonNull TextView textView8, @NonNull TextView textView9, @NonNull Button themeLayout,
      @NonNull LinearLayout tipslearningContent, @NonNull TextView tipslearningsReinforcement,
      @NonNull TextView tipslearningsWithTeacher, @NonNull TextView tipslearningsWithoutTeacher) {
    this.rootView = rootView;
    this.aboutdata = aboutdata;
    this.aboutdataText1 = aboutdataText1;
    this.dataImg = dataImg;
    this.drawerLayout = drawerLayout;
    this.fabScrollToTop = fabScrollToTop;
    this.menu1 = menu1;
    this.menu2 = menu2;
    this.menu3 = menu3;
    this.menu4 = menu4;
    this.mse = mse;
    this.navView = navView;
    this.scrollView = scrollView;
    this.textView1 = textView1;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView13 = textView13;
    this.textView15 = textView15;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
    this.themeLayout = themeLayout;
    this.tipslearningContent = tipslearningContent;
    this.tipslearningsReinforcement = tipslearningsReinforcement;
    this.tipslearningsWithTeacher = tipslearningsWithTeacher;
    this.tipslearningsWithoutTeacher = tipslearningsWithoutTeacher;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTipslearningsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTipslearningsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tipslearnings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTipslearningsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aboutdata;
      TextView aboutdata = ViewBindings.findChildViewById(rootView, id);
      if (aboutdata == null) {
        break missingId;
      }

      id = R.id.aboutdata_text1;
      TextView aboutdataText1 = ViewBindings.findChildViewById(rootView, id);
      if (aboutdataText1 == null) {
        break missingId;
      }

      id = R.id.data_img;
      ImageView dataImg = ViewBindings.findChildViewById(rootView, id);
      if (dataImg == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.fabScrollToTop;
      FloatingActionButton fabScrollToTop = ViewBindings.findChildViewById(rootView, id);
      if (fabScrollToTop == null) {
        break missingId;
      }

      id = R.id.menu1;
      TextView menu1 = ViewBindings.findChildViewById(rootView, id);
      if (menu1 == null) {
        break missingId;
      }

      id = R.id.menu2;
      TextView menu2 = ViewBindings.findChildViewById(rootView, id);
      if (menu2 == null) {
        break missingId;
      }

      id = R.id.menu3;
      TextView menu3 = ViewBindings.findChildViewById(rootView, id);
      if (menu3 == null) {
        break missingId;
      }

      id = R.id.menu4;
      TextView menu4 = ViewBindings.findChildViewById(rootView, id);
      if (menu4 == null) {
        break missingId;
      }

      id = R.id.mse;
      TextView mse = ViewBindings.findChildViewById(rootView, id);
      if (mse == null) {
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

      id = R.id.textView1;
      TextView textView1 = ViewBindings.findChildViewById(rootView, id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = ViewBindings.findChildViewById(rootView, id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = ViewBindings.findChildViewById(rootView, id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView13;
      TextView textView13 = ViewBindings.findChildViewById(rootView, id);
      if (textView13 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
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

      id = R.id.tipslearning_content;
      LinearLayout tipslearningContent = ViewBindings.findChildViewById(rootView, id);
      if (tipslearningContent == null) {
        break missingId;
      }

      id = R.id.tipslearnings_reinforcement;
      TextView tipslearningsReinforcement = ViewBindings.findChildViewById(rootView, id);
      if (tipslearningsReinforcement == null) {
        break missingId;
      }

      id = R.id.tipslearnings_with_teacher;
      TextView tipslearningsWithTeacher = ViewBindings.findChildViewById(rootView, id);
      if (tipslearningsWithTeacher == null) {
        break missingId;
      }

      id = R.id.tipslearnings_without_teacher;
      TextView tipslearningsWithoutTeacher = ViewBindings.findChildViewById(rootView, id);
      if (tipslearningsWithoutTeacher == null) {
        break missingId;
      }

      return new ActivityTipslearningsBinding((DrawerLayout) rootView, aboutdata, aboutdataText1,
          dataImg, drawerLayout, fabScrollToTop, menu1, menu2, menu3, menu4, mse, navView,
          scrollView, textView1, textView11, textView12, textView13, textView15, textView16,
          textView17, textView7, textView8, textView9, themeLayout, tipslearningContent,
          tipslearningsReinforcement, tipslearningsWithTeacher, tipslearningsWithoutTeacher);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
