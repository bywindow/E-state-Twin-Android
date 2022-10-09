// Generated by data binding compiler. Do not edit!
package com.idiot.userhouse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.idiot.userhouse.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutMyhouseTabBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout listTab;

  @NonNull
  public final ImageView tabIcon;

  @NonNull
  public final TextView tabTitle;

  protected LayoutMyhouseTabBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout listTab, ImageView tabIcon, TextView tabTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.listTab = listTab;
    this.tabIcon = tabIcon;
    this.tabTitle = tabTitle;
  }

  @NonNull
  public static LayoutMyhouseTabBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_myhouse_tab, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutMyhouseTabBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutMyhouseTabBinding>inflateInternal(inflater, R.layout.layout_myhouse_tab, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutMyhouseTabBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_myhouse_tab, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutMyhouseTabBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutMyhouseTabBinding>inflateInternal(inflater, R.layout.layout_myhouse_tab, null, false, component);
  }

  public static LayoutMyhouseTabBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutMyhouseTabBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutMyhouseTabBinding)bind(component, view, R.layout.layout_myhouse_tab);
  }
}