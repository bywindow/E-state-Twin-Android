package com.idiot.more.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/idiot/more/ui/adapter/RegisterNewInquiryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/idiot/more/ui/adapter/RegisterNewInquiryAdapter$ViewHolder;", "inquiry", "", "Lcom/idiot/data/repository/samples/inquiryInfo;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "more_debug"})
public final class RegisterNewInquiryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.idiot.more.ui.adapter.RegisterNewInquiryAdapter.ViewHolder> {
    private final java.util.List<com.idiot.data.repository.samples.inquiryInfo> inquiry = null;
    
    public RegisterNewInquiryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.idiot.data.repository.samples.inquiryInfo> inquiry) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.idiot.more.ui.adapter.RegisterNewInquiryAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.idiot.more.ui.adapter.RegisterNewInquiryAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/idiot/more/ui/adapter/RegisterNewInquiryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/idiot/more/databinding/ListItemNewRegisterBinding;", "(Lcom/idiot/more/databinding/ListItemNewRegisterBinding;)V", "bind", "", "item", "Lcom/idiot/data/repository/samples/inquiryInfo;", "position", "", "navigateTo", "estateId", "", "view", "Landroid/view/View;", "more_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.idiot.more.databinding.ListItemNewRegisterBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.idiot.more.databinding.ListItemNewRegisterBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.idiot.data.repository.samples.inquiryInfo item, int position) {
        }
        
        private final void navigateTo(long estateId, android.view.View view) {
        }
    }
}