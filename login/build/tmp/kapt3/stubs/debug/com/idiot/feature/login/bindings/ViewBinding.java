package com.idiot.feature.login.bindings;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/idiot/feature/login/bindings/ViewBinding;", "", "()V", "bindIsSubCity", "", "view", "Landroid/widget/TextView;", "isChecked", "", "bindSelectEstate", "Landroidx/appcompat/widget/AppCompatButton;", "selectedType", "", "bindSelectType", "login_debug"})
public final class ViewBinding {
    @org.jetbrains.annotations.NotNull()
    public static final com.idiot.feature.login.bindings.ViewBinding INSTANCE = null;
    
    private ViewBinding() {
        super();
    }
    
    @androidx.databinding.BindingAdapter(value = {"selectedType"})
    @kotlin.jvm.JvmStatic()
    public static final void bindSelectType(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton view, int selectedType) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"selectedEstate"})
    @kotlin.jvm.JvmStatic()
    public static final void bindSelectEstate(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton view, int selectedType) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"isSubCity"})
    @kotlin.jvm.JvmStatic()
    public static final void bindIsSubCity(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, boolean isChecked) {
    }
}