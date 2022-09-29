package com.idiot.more.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/idiot/more/ui/adapter/RegisterInfoPictureAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/idiot/model/RegisterPicture;", "Lcom/idiot/more/ui/adapter/RegisterInfoPictureAdapter$ViewHolder;", "onClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "more_debug"})
public final class RegisterInfoPictureAdapter extends androidx.recyclerview.widget.ListAdapter<com.idiot.model.RegisterPicture, com.idiot.more.ui.adapter.RegisterInfoPictureAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<com.idiot.model.RegisterPicture, kotlin.Unit> onClick = null;
    
    public RegisterInfoPictureAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.idiot.model.RegisterPicture, kotlin.Unit> onClick) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.idiot.more.ui.adapter.RegisterInfoPictureAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.idiot.more.ui.adapter.RegisterInfoPictureAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/idiot/more/ui/adapter/RegisterInfoPictureAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/idiot/more/databinding/ListItemRegisterInfoPictureBinding;", "onClick", "Lkotlin/Function1;", "Lcom/idiot/model/RegisterPicture;", "", "(Lcom/idiot/more/databinding/ListItemRegisterInfoPictureBinding;Lkotlin/jvm/functions/Function1;)V", "currentItem", "imageView", "Landroid/widget/ImageView;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "bind", "item", "more_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.idiot.model.RegisterPicture, kotlin.Unit> onClick = null;
        private final android.widget.ImageView imageView = null;
        private com.idiot.model.RegisterPicture currentItem;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.idiot.more.databinding.ListItemRegisterInfoPictureBinding binding, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.idiot.model.RegisterPicture, kotlin.Unit> onClick) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<com.idiot.model.RegisterPicture, kotlin.Unit> getOnClick() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.idiot.model.RegisterPicture item) {
        }
    }
}