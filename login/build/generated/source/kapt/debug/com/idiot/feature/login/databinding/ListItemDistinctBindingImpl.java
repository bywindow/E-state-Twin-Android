package com.idiot.feature.login.databinding;
import com.idiot.feature.login.R;
import com.idiot.feature.login.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemDistinctBindingImpl extends ListItemDistinctBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemDistinctBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }
    private ListItemDistinctBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            );
        this.distinctTextView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.isSelected == variableId) {
            setIsSelected((java.lang.Boolean) variable);
        }
        else if (BR.distinct == variableId) {
            setDistinct((java.lang.String) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIsSelected(@Nullable java.lang.Boolean IsSelected) {
        this.mIsSelected = IsSelected;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.isSelected);
        super.requestRebind();
    }
    public void setDistinct(@Nullable java.lang.String Distinct) {
        this.mDistinct = Distinct;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.distinct);
        super.requestRebind();
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
        java.lang.Boolean isSelected = mIsSelected;
        boolean androidxDatabindingViewDataBindingSafeUnboxIsSelected = false;
        java.lang.String distinct = mDistinct;

        if ((dirtyFlags & 0x5L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(isSelected)
                androidxDatabindingViewDataBindingSafeUnboxIsSelected = androidx.databinding.ViewDataBinding.safeUnbox(isSelected);
        }
        if ((dirtyFlags & 0x6L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.idiot.feature.login.bindings.ViewBinding.bindIsSubCity(this.distinctTextView, androidxDatabindingViewDataBindingSafeUnboxIsSelected);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.distinctTextView, distinct);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): isSelected
        flag 1 (0x2L): distinct
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}