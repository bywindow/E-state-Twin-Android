package com.idiot.userhouse.databinding;
import com.idiot.userhouse.R;
import com.idiot.userhouse.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentTenantModeBindingImpl extends FragmentTenantModeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.help_banner_layout, 1);
        sViewsWithIds.put(R.id.help_banner_card, 2);
        sViewsWithIds.put(R.id.tenant_mode_help_textView, 3);
        sViewsWithIds.put(R.id.my_house_card, 4);
        sViewsWithIds.put(R.id.my_house_type_textView, 5);
        sViewsWithIds.put(R.id.my_house_name_textView, 6);
        sViewsWithIds.put(R.id.my_house_addr_textView, 7);
        sViewsWithIds.put(R.id.asset_manage_title, 8);
        sViewsWithIds.put(R.id.asset_manage_tab_list_layout, 9);
        sViewsWithIds.put(R.id.contract_title, 10);
        sViewsWithIds.put(R.id.contract_tab_list_layout, 11);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentTenantModeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentTenantModeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (com.google.android.material.card.MaterialCardView) bindings[2]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.TextView) bindings[7]
            , (com.google.android.material.card.MaterialCardView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}