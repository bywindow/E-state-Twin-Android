package com.idiot.feature.login.ui.sign;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\fJ\u000e\u0010%\u001a\u00020 2\u0006\u0010#\u001a\u00020\fJ\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0\'2\u0006\u0010)\u001a\u00020*H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/idiot/feature/login/ui/sign/SignUpViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "userSignUpRepository", "Lcom/idiot/data/repository/UserSignUpRepository;", "(Landroid/app/Application;Lcom/idiot/data/repository/UserSignUpRepository;)V", "_cityList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/idiot/model/users/UserPreference;", "_preferenceCity", "", "_preferenceEstate", "_preferenceSubCity", "_preferenceTrans", "_subList", "cityList", "Lkotlinx/coroutines/flow/StateFlow;", "getCityList", "()Lkotlinx/coroutines/flow/StateFlow;", "preferenceCity", "getPreferenceCity", "preferenceEstate", "getPreferenceEstate", "preferenceSubCity", "getPreferenceSubCity", "preferenceTrans", "getPreferenceTrans", "subList", "getSubList", "changePrefCity", "", "position", "changePrefEstate", "type", "changePrefSubCity", "changePrefTrans", "requestSingUp", "Lkotlinx/coroutines/flow/Flow;", "Lcom/idiot/feature/login/ui/sign/SignUpEvent$UserDataUploadSuccess;", "accessToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login_debug"})
public final class SignUpViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.idiot.data.repository.UserSignUpRepository userSignUpRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _preferenceTrans = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> preferenceTrans = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _preferenceEstate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> preferenceEstate = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _preferenceCity = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> preferenceCity = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.idiot.model.users.UserPreference>> _cityList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> cityList = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _preferenceSubCity = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> preferenceSubCity = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.idiot.model.users.UserPreference>> _subList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> subList = null;
    
    @javax.inject.Inject()
    public SignUpViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.idiot.data.repository.UserSignUpRepository userSignUpRepository) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPreferenceTrans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPreferenceEstate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPreferenceCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> getCityList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPreferenceSubCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> getSubList() {
        return null;
    }
    
    public final void changePrefTrans(int type) {
    }
    
    public final void changePrefEstate(int type) {
    }
    
    public final void changePrefCity(int position) {
    }
    
    public final void changePrefSubCity(int position) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object requestSingUp(@org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.idiot.feature.login.ui.sign.SignUpEvent.UserDataUploadSuccess>> continuation) {
        return null;
    }
}