package com.idiot.more.ui.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "activity", "Landroidx/fragment/app/FragmentActivity;", "repository", "Lcom/idiot/data/repository/EstateImageS3UploadRepository;", "(Landroidx/fragment/app/FragmentActivity;Lcom/idiot/data/repository/EstateImageS3UploadRepository;)V", "_pictureList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/idiot/model/RegisterEstatePicture;", "pictureList", "Landroidx/lifecycle/LiveData;", "getPictureList", "()Landroidx/lifecycle/LiveData;", "deletePicture", "", "item", "insertPicture", "clipData", "Landroid/content/ClipData;", "size", "", "PictureListFactory", "more_debug"})
public final class RegisterPictureListViewModel extends androidx.lifecycle.AndroidViewModel {
    private final androidx.fragment.app.FragmentActivity activity = null;
    private final com.idiot.data.repository.EstateImageS3UploadRepository repository = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.idiot.model.RegisterEstatePicture>> _pictureList = null;
    
    public RegisterPictureListViewModel(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    com.idiot.data.repository.EstateImageS3UploadRepository repository) {
        super(null);
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel$PictureListFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "more_debug"})
    public static final class PictureListFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        private final androidx.fragment.app.FragmentActivity activity = null;
        
        public PictureListFactory(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentActivity activity) {
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