// Generated by data binding compiler. Do not edit!
package com.idiot.userhouse.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.idiot.userhouse.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ListItemOwnerHouseBinding extends ViewDataBinding {
  @NonNull
  public final TextView myHouseAddrTextView;

  @NonNull
  public final MaterialCardView myHouseCard;

  @NonNull
  public final TextView myHouseNameTextView;

  @NonNull
  public final TextView myHouseTypeTextView;

  @Bindable
  protected View.OnClickListener mClickListener;

  protected ListItemOwnerHouseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView myHouseAddrTextView, MaterialCardView myHouseCard, TextView myHouseNameTextView,
      TextView myHouseTypeTextView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.myHouseAddrTextView = myHouseAddrTextView;
    this.myHouseCard = myHouseCard;
    this.myHouseNameTextView = myHouseNameTextView;
    this.myHouseTypeTextView = myHouseTypeTextView;
  }

  public abstract void setClickListener(@Nullable View.OnClickListener clickListener);

  @Nullable
  public View.OnClickListener getClickListener() {
    return mClickListener;
  }

  @NonNull
  public static ListItemOwnerHouseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_owner_house, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ListItemOwnerHouseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ListItemOwnerHouseBinding>inflateInternal(inflater, R.layout.list_item_owner_house, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemOwnerHouseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_owner_house, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ListItemOwnerHouseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ListItemOwnerHouseBinding>inflateInternal(inflater, R.layout.list_item_owner_house, null, false, component);
  }

  public static ListItemOwnerHouseBinding bind(@NonNull View view) {
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
  public static ListItemOwnerHouseBinding bind(@NonNull View view, @Nullable Object component) {
    return (ListItemOwnerHouseBinding)bind(component, view, R.layout.list_item_owner_house);
  }
}
