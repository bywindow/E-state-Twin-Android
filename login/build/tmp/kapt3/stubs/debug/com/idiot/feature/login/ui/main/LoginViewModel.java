package com.idiot.feature.login.ui.main;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/idiot/feature/login/ui/main/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/idiot/data/repository/TokenRepository;", "(Lcom/idiot/data/repository/TokenRepository;)V", "_token", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/idiot/model/TokenResponse;", "token", "Lkotlinx/coroutines/flow/StateFlow;", "getToken", "()Lkotlinx/coroutines/flow/StateFlow;", "requestToken", "", "accessToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.idiot.data.repository.TokenRepository repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.idiot.model.TokenResponse> _token = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.idiot.model.TokenResponse> token = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.idiot.data.repository.TokenRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.idiot.model.TokenResponse> getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestToken(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}