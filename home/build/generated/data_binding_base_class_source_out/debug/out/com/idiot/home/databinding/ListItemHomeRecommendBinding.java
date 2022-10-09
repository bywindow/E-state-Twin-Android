// Generated by data binding compiler. Do not edit!
package com.idiot.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.idiot.home.R;
import com.idiot.home.ui.UserRecommendViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ListItemHomeRecommendBinding extends ViewDataBinding {
  @NonNull
  public final TextView houseAddress;

  @NonNull
  public final TextView housePrice;

  @NonNull
  public final TextView houseType;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final AppCompatButton thumbnailButton;

  @Bindable
  protected View.OnClickListener mClickListener;

  @Bindable
  protected View.OnClickListener mChangeThumbnail;

  @Bindable
  protected UserRecommendViewModel mViewModel;

  protected ListItemHomeRecommendBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView houseAddress, TextView housePrice, TextView houseType, ImageView imageView,
      RelativeLayout relativeLayout, AppCompatButton thumbnailButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.houseAddress = houseAddress;
    this.housePrice = housePrice;
    this.houseType = houseType;
    this.imageView = imageView;
    this.relativeLayout = relativeLayout;
    this.thumbnailButton = thumbnailButton;
  }

  public abstract void setClickListener(@Nullable View.OnClickListener clickListener);

  @Nullable
  public View.OnClickListener getClickListener() {
    return mClickListener;
  }

  public abstract void setChangeThumbnail(@Nullable View.OnClickListener changeThumbnail);

  @Nullable
  public View.OnClickListener getChangeThumbnail() {
    return mChangeThumbnail;
  }

  public abstract void setViewModel(@Nullable UserRecommendViewModel viewModel);

  @Nullable
  public UserRecommendViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ListItemHomeRecommendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_home_recommend, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ListItemHomeRecommendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ListItemHomeRecommendBinding>inflateInternal(inflater, R.layout.list_item_home_recommend, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemHomeRecommendBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_home_recommend, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ListItemHomeRecommendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ListItemHomeRecommendBinding>inflateInternal(inflater, R.layout.list_item_home_recommend, null, false, component);
  }

  public static ListItemHomeRecommendBinding bind(@NonNull View view) {
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
  public static ListItemHomeRecommendBinding bind(@NonNull View view, @Nullable Object component) {
    return (ListItemHomeRecommendBinding)bind(component, view, R.layout.list_item_home_recommend);
  }
}