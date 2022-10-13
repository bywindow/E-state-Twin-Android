package com.idiot.feature.login.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/idiot/feature/login/ui/main/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/idiot/feature/login/databinding/ActivityLoginBinding;", "viewModel", "Lcom/idiot/feature/login/ui/main/LoginViewModel;", "getViewModel", "()Lcom/idiot/feature/login/ui/main/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initLoginClickListener", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onWindowFocusChanged", "hasFocus", "", "saveKakaoUser", "token", "Lcom/kakao/sdk/auth/model/OAuthToken;", "subscribeUi", "login_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.idiot.feature.login.databinding.ActivityLoginBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LoginActivity() {
        super();
    }
    
    private final com.idiot.feature.login.ui.main.LoginViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initLoginClickListener(com.idiot.feature.login.databinding.ActivityLoginBinding binding) {
    }
    
    private final void saveKakaoUser(com.kakao.sdk.auth.model.OAuthToken token) {
    }
    
    private final void subscribeUi(com.idiot.feature.login.databinding.ActivityLoginBinding binding) {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
}