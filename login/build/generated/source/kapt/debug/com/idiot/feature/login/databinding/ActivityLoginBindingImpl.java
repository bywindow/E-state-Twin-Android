package com.idiot.feature.login.databinding;
import com.idiot.feature.login.R;
import com.idiot.feature.login.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.sns_icon_layout, 1);
        sViewsWithIds.put(R.id.google_button, 2);
        sViewsWithIds.put(R.id.google_active_button, 3);
        sViewsWithIds.put(R.id.google_icon, 4);
        sViewsWithIds.put(R.id.google_text_view, 5);
        sViewsWithIds.put(R.id.kakao_button, 6);
        sViewsWithIds.put(R.id.kakao_icon, 7);
        sViewsWithIds.put(R.id.kakao_text_view, 8);
        sViewsWithIds.put(R.id.naver_button, 9);
        sViewsWithIds.put(R.id.naver_icon, 10);
        sViewsWithIds.put(R.id.naver_text_view, 11);
        sViewsWithIds.put(R.id.sign_in_button_layout, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (com.google.android.gms.common.SignInButton) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[12]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.viewmodel == variableId) {
            setViewmodel((com.idiot.feature.login.ui.main.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewmodel(@Nullable com.idiot.feature.login.ui.main.LoginViewModel Viewmodel) {
        this.mViewmodel = Viewmodel;
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
        flag 0 (0x1L): viewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}