package com.idiot.more.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\u0016\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/idiot/more/ui/RegisterInfoFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/idiot/more/databinding/FragmentRegisterInfoBinding;", "optionListViewModel", "Lcom/idiot/more/ui/viewModel/RegisterOptionListViewModel;", "getOptionListViewModel", "()Lcom/idiot/more/ui/viewModel/RegisterOptionListViewModel;", "optionListViewModel$delegate", "Lkotlin/Lazy;", "pictureListViewModel", "Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel;", "getPictureListViewModel", "()Lcom/idiot/more/ui/viewModel/RegisterPictureListViewModel;", "pictureListViewModel$delegate", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "selectImageResultLauncher", "Landroid/content/Intent;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "addPicture", "", "initAdapter", "initAddressSearchDialogListener", "initNavigation", "navigateToPhoto", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openBottomSheetDialog", "view", "showPermissionContextPopup", "updatePictureCount", "list", "", "Lcom/idiot/model/RegisterEstatePicture;", "more_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RegisterInfoFragment extends androidx.fragment.app.Fragment {
    private com.idiot.more.databinding.FragmentRegisterInfoBinding binding;
    private final kotlin.Lazy pictureListViewModel$delegate = null;
    private final kotlin.Lazy optionListViewModel$delegate = null;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> selectImageResultLauncher = null;
    
    public RegisterInfoFragment() {
        super();
    }
    
    private final com.idiot.more.ui.viewModel.RegisterPictureListViewModel getPictureListViewModel() {
        return null;
    }
    
    private final com.idiot.more.ui.viewModel.RegisterOptionListViewModel getOptionListViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initNavigation() {
    }
    
    private final void initAdapter() {
    }
    
    private final void addPicture() {
    }
    
    private final void showPermissionContextPopup() {
    }
    
    private final void navigateToPhoto() {
    }
    
    private final void updatePictureCount(java.util.List<com.idiot.model.RegisterEstatePicture> list) {
    }
    
    private final void initAddressSearchDialogListener(com.idiot.more.databinding.FragmentRegisterInfoBinding binding) {
    }
    
    private final void openBottomSheetDialog(android.view.View view) {
    }
}