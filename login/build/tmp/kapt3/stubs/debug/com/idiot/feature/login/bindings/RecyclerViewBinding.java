package com.idiot.feature.login.bindings;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/idiot/feature/login/bindings/RecyclerViewBinding;", "", "()V", "bindAdapter", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/idiot/model/users/UserPreference;", "itemList", "", "login_debug"})
public final class RecyclerViewBinding {
    @org.jetbrains.annotations.NotNull()
    public static final com.idiot.feature.login.bindings.RecyclerViewBinding INSTANCE = null;
    
    private RecyclerViewBinding() {
        super();
    }
    
    /**
     * 주소 리스트를 가져와 recyclerView에 adapter를 부착한다.
     */
    @androidx.databinding.BindingAdapter(value = {"adapter", "submitList"})
    @kotlin.jvm.JvmStatic()
    public static final void bindAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.ListAdapter<com.idiot.model.users.UserPreference, ?> adapter, @org.jetbrains.annotations.NotNull()
    java.util.List<com.idiot.model.users.UserPreference> itemList) {
    }
}