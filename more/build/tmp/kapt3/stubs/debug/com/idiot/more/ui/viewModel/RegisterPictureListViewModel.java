package com.idiot.more.ui.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_pictureList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/idiot/model/RegisterEstatePicture;", "pictureList", "Landroidx/lifecycle/LiveData;", "getPictureList", "()Landroidx/lifecycle/LiveData;", "deletePicture", "", "item", "insertPicture", "clipData", "Landroid/content/ClipData;", "size", "", "PictureListFactory", "more_debug"})
public final class RegisterPictureListViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.idiot.model.RegisterEstatePicture>> _pictureList = null;
    
    public RegisterPictureListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.idiot.model.RegisterEstatePicture>> getPictureList() {
        return null;
    }
    
    public final void insertPicture(@org.jetbrains.annotations.NotNull()
    android.content.ClipData clipData, int size) {
    }
    
    public final void deletePicture(@org.jetbrains.annotations.NotNull()
    com.idiot.model.RegisterEstatePicture item) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel$PictureListFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "more_debug"})
    public static final class PictureListFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        
        public PictureListFactory() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}