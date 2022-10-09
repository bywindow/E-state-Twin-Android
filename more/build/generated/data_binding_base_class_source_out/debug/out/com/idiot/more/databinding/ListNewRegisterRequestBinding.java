// Generated by data binding compiler. Do not edit!
package com.idiot.more.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.idiot.more.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ListNewRegisterRequestBinding extends ViewDataBinding {
  @NonNull
  public final TextView houseAddressTextView;

  @NonNull
  public final TextView houseNameTextView;

  @NonNull
  public final TextView ownerTextView;

  @Bindable
  protected String mOwner;

  protected ListNewRegisterRequestBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView houseAddressTextView, TextView houseNameTextView,
      TextView ownerTextView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.houseAddressTextView = houseAddressTextView;
    this.houseNameTextView = houseNameTextView;
    this.ownerTextView = ownerTextView;
  }

  public abstract void setOwner(@Nullable String owner);

  @Nullable
  public String getOwner() {
    return mOwner;
  }

  @NonNull
  public static ListNewRegisterRequestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_new_register_request, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ListNewRegisterRequestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ListNewRegisterRequestBinding>inflateInternal(inflater, R.layout.list_new_register_request, root, attachToRoot, component);
  }

  @NonNull
  public static ListNewRegisterRequestBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_new_register_request, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ListNewRegisterRequestBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ListNewRegisterRequestBinding>inflateInternal(inflater, R.layout.list_new_register_request, null, false, component);
  }

  public static ListNewRegisterRequestBinding bind(@NonNull View view) {
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
  public static ListNewRegisterRequestBinding bind(@NonNull View view, @Nullable Object component) {
    return (ListNewRegisterRequestBinding)bind(component, view, R.layout.list_new_register_request);
  }
}