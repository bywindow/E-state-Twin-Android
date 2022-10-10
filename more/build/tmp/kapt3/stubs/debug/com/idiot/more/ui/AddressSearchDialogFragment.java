package com.idiot.more.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/idiot/more/ui/AddressSearchDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/idiot/more/databinding/FragmentAddressSearchDialogBinding;", "navController", "Landroidx/navigation/NavController;", "webView", "Landroid/webkit/WebView;", "initWebView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "AndroidBridge", "WebViewClientClass", "more_debug"})
public final class AddressSearchDialogFragment extends androidx.fragment.app.DialogFragment {
    private com.idiot.more.databinding.FragmentAddressSearchDialogBinding binding;
    private android.webkit.WebView webView;
    private androidx.navigation.NavController navController;
    
    public AddressSearchDialogFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initWebView(com.idiot.more.databinding.FragmentAddressSearchDialogBinding binding) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/idiot/more/ui/AddressSearchDialogFragment$WebViewClientClass;", "Landroid/webkit/WebViewClient;", "(Lcom/idiot/more/ui/AddressSearchDialogFragment;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "request", "Landroid/webkit/WebResourceRequest;", "more_debug"})
    public final class WebViewClientClass extends android.webkit.WebViewClient {
        
        public WebViewClientClass() {
            super();
        }
        
        @android.annotation.SuppressLint(value = {"WebViewClientOnReceivedSslError"})
        @java.lang.Override()
        public void onReceivedSslError(@org.jetbrains.annotations.Nullable()
        android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
        android.webkit.SslErrorHandler handler, @org.jetbrains.annotations.Nullable()
        android.net.http.SslError error) {
        }
        
        @java.lang.Override()
        public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable()
        android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
        android.webkit.WebResourceRequest request) {
            return false;
        }
        
        @java.lang.Override()
        public void onPageStarted(@org.jetbrains.annotations.Nullable()
        android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        android.graphics.Bitmap favicon) {
        }
        
        @java.lang.Override()
        public void onPageFinished(@org.jetbrains.annotations.Nullable()
        android.webkit.WebView view, @org.jetbrains.annotations.Nullable()
        java.lang.String url) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/idiot/more/ui/AddressSearchDialogFragment$AndroidBridge;", "", "(Lcom/idiot/more/ui/AddressSearchDialogFragment;)V", "processDATA", "", "data", "", "more_debug"})
    public final class AndroidBridge {
        
        public AndroidBridge() {
            super();
        }
        
        @android.webkit.JavascriptInterface()
        public final void processDATA(@org.jetbrains.annotations.NotNull()
        java.lang.String data) {
        }
    }
}