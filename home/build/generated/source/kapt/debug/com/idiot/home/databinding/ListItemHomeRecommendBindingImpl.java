package com.idiot.home.databinding;
import com.idiot.home.R;
import com.idiot.home.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemHomeRecommendBindingImpl extends ListItemHomeRecommendBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.relativeLayout, 5);
        sViewsWithIds.put(R.id.imageView, 6);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemHomeRecommendBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ListItemHomeRecommendBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.RelativeLayout) bindings[5]
            , (androidx.appcompat.widget.AppCompatButton) bindings[1]
            );
        this.houseAddress.setTag(null);
        this.housePrice.setTag(null);
        this.houseType.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.thumbnailButton.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.clickListener == variableId) {
            setClickListener((android.view.View.OnClickListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.idiot.home.ui.UserRecommendViewModel) variable);
        }
        else if (BR.changeThumbnail == variableId) {
            setChangeThumbnail((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable android.view.View.OnClickListener ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.idiot.home.ui.UserRecommendViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
    public void setChangeThumbnail(@Nullable android.view.View.OnClickListener ChangeThumbnail) {
        this.mChangeThumbnail = ChangeThumbnail;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.changeThumbnail);
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
        java.lang.String viewModelRecommendedHouseHousePrice = null;
        java.lang.String viewModelRecommendedHouseHouseAddress = null;
        com.idiot.model.RecommendedHouse viewModelRecommendedHouse = null;
        android.view.View.OnClickListener clickListener = mClickListener;
        java.lang.String viewModelRecommendedHouseHouseType = null;
        com.idiot.home.ui.UserRecommendViewModel viewModel = mViewModel;
        android.view.View.OnClickListener changeThumbnail = mChangeThumbnail;

        if ((dirtyFlags & 0x9L) != 0) {
        }
        if ((dirtyFlags & 0xaL) != 0) {



                if (viewModel != null) {
                    // read viewModel.recommendedHouse
                    viewModelRecommendedHouse = viewModel.getRecommendedHouse();
                }


                if (viewModelRecommendedHouse != null) {
                    // read viewModel.recommendedHouse.housePrice
                    viewModelRecommendedHouseHousePrice = viewModelRecommendedHouse.getHousePrice();
                    // read viewModel.recommendedHouse.houseAddress
                    viewModelRecommendedHouseHouseAddress = viewModelRecommendedHouse.getHouseAddress();
                    // read viewModel.recommendedHouse.houseType
                    viewModelRecommendedHouseHouseType = viewModelRecommendedHouse.getHouseType();
                }
        }
        if ((dirtyFlags & 0xcL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.houseAddress, viewModelRecommendedHouseHouseAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.housePrice, viewModelRecommendedHouseHousePrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.houseType, viewModelRecommendedHouseHouseType);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(clickListener);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.thumbnailButton.setOnClickListener(changeThumbnail);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickListener
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): changeThumbnail
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}