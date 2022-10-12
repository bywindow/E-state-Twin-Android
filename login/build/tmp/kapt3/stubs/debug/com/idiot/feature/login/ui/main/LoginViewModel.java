package com.idiot.feature.login.ui.main;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fJ!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/idiot/feature/login/ui/main/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/idiot/data/repository/TokenRepository;", "userPreferenceRepository", "Lcom/idiot/data/repository/UserPreferenceRepository;", "(Lcom/idiot/data/repository/TokenRepository;Lcom/idiot/data/repository/UserPreferenceRepository;)V", "_token", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/idiot/model/TokenResponse;", "token", "Lkotlinx/coroutines/flow/StateFlow;", "getToken", "()Lkotlinx/coroutines/flow/StateFlow;", "cacheToken", "Lkotlinx/coroutines/flow/Flow;", "Lcom/idiot/feature/login/ui/main/LoginEvent$TokenCachedSuccess;", "accessToken", "", "refreshToken", "Lcom/idiot/feature/login/ui/main/LoginEvent$CachedTokenFetchSuccess;", "requestToken", "", "provider", "code", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    private final com.idiot.data.repository.TokenRepository repository = null;
    private final com.idiot.data.repository.UserPreferenceRepository userPreferenceRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.idiot.model.TokenResponse> _token = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.idiot.model.TokenResponse> token = null;
    
    @javax.inject.Inject()
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    com.idiot.data.repository.TokenRepository repository, @org.jetbrains.annotations.NotNull()
    com.idiot.data.repository.UserPreferenceRepository userPreferenceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.idiot.model.TokenResponse> getToken() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestToken(@org.jetbrains.annotations.NotNull()
    java.lang.String provider, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.idiot.feature.login.ui.main.LoginEvent.TokenCachedSuccess> cacheToken(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    java.lang.String refreshToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.idiot.feature.login.ui.main.LoginEvent.CachedTokenFetchSuccess> getToken() {
        return null;
    }
}