package com.idiot.more.databinding;
import com.idiot.more.R;
import com.idiot.more.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRegisterInfoBindingImpl extends FragmentRegisterInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(25);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {8},
            new int[] {com.idiot.utils.R.layout.toolbar_layout});
        sIncludes.setIncludes(1, 
            new String[] {"tv_register_title"},
            new int[] {9},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(2, 
            new String[] {"tv_register_title"},
            new int[] {10},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(3, 
            new String[] {"tv_register_title"},
            new int[] {11},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(4, 
            new String[] {"tv_register_title"},
            new int[] {12},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(5, 
            new String[] {"tv_register_title"},
            new int[] {13},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(6, 
            new String[] {"tv_register_title"},
            new int[] {14},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sIncludes.setIncludes(7, 
            new String[] {"tv_register_title"},
            new int[] {15},
            new int[] {com.idiot.more.R.layout.tv_register_title});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.picture_count_textView, 16);
        sViewsWithIds.put(R.id.estate_picture_recyclerview, 17);
        sViewsWithIds.put(R.id.address_search_edit_text, 18);
        sViewsWithIds.put(R.id.home_info_dialog_button, 19);
        sViewsWithIds.put(R.id.price_info_dialog_button, 20);
        sViewsWithIds.put(R.id.register_option_recycler_view, 21);
        sViewsWithIds.put(R.id.register_house_video_button, 22);
        sViewsWithIds.put(R.id.register_ar_checklist_button, 23);
        sViewsWithIds.put(R.id.register_complete_button, 24);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView2;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView3;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView4;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView5;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView6;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView7;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRegisterInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private FragmentRegisterInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8
            , (android.widget.EditText) bindings[18]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[10]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[15]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (androidx.appcompat.widget.AppCompatButton) bindings[19]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[11]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[14]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[13]
            , (android.widget.TextView) bindings[16]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[9]
            , (com.idiot.more.databinding.TvRegisterTitleBinding) bindings[12]
            , (androidx.appcompat.widget.AppCompatButton) bindings[20]
            , (androidx.appcompat.widget.AppCompatButton) bindings[23]
            , (androidx.appcompat.widget.AppCompatButton) bindings[24]
            , (androidx.appcompat.widget.AppCompatButton) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (com.idiot.utils.databinding.ToolbarLayoutBinding) bindings[8]
            );
        setContainedBinding(this.addressTitle);
        setContainedBinding(this.arChecklistTitle);
        setContainedBinding(this.houseDetailTitle);
        setContainedBinding(this.houseVideoTitle);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[7];
        this.mboundView7.setTag(null);
        setContainedBinding(this.optionTitle);
        setContainedBinding(this.pictureTitle);
        setContainedBinding(this.priceDetailTitle);
        setContainedBinding(this.toolbarRegisterInfo);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
        }
        toolbarRegisterInfo.invalidateAll();
        pictureTitle.invalidateAll();
        addressTitle.invalidateAll();
        houseDetailTitle.invalidateAll();
        priceDetailTitle.invalidateAll();
        optionTitle.invalidateAll();
        houseVideoTitle.invalidateAll();
        arChecklistTitle.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbarRegisterInfo.hasPendingBindings()) {
            return true;
        }
        if (pictureTitle.hasPendingBindings()) {
            return true;
        }
        if (addressTitle.hasPendingBindings()) {
            return true;
        }
        if (houseDetailTitle.hasPendingBindings()) {
            return true;
        }
        if (priceDetailTitle.hasPendingBindings()) {
            return true;
        }
        if (optionTitle.hasPendingBindings()) {
            return true;
        }
        if (houseVideoTitle.hasPendingBindings()) {
            return true;
        }
        if (arChecklistTitle.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbarRegisterInfo.setLifecycleOwner(lifecycleOwner);
        pictureTitle.setLifecycleOwner(lifecycleOwner);
        addressTitle.setLifecycleOwner(lifecycleOwner);
        houseDetailTitle.setLifecycleOwner(lifecycleOwner);
        priceDetailTitle.setLifecycleOwner(lifecycleOwner);
        optionTitle.setLifecycleOwner(lifecycleOwner);
        houseVideoTitle.setLifecycleOwner(lifecycleOwner);
        arChecklistTitle.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePriceDetailTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 1 :
                return onChangeArChecklistTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 2 :
                return onChangeAddressTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 3 :
                return onChangeOptionTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 4 :
                return onChangePictureTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 5 :
                return onChangeHouseDetailTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 6 :
                return onChangeHouseVideoTitle((com.idiot.more.databinding.TvRegisterTitleBinding) object, fieldId);
            case 7 :
                return onChangeToolbarRegisterInfo((com.idiot.utils.databinding.ToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangePriceDetailTitle(com.idiot.more.databinding.TvRegisterTitleBinding PriceDetailTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeArChecklistTitle(com.idiot.more.databinding.TvRegisterTitleBinding ArChecklistTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeAddressTitle(com.idiot.more.databinding.TvRegisterTitleBinding AddressTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeOptionTitle(com.idiot.more.databinding.TvRegisterTitleBinding OptionTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePictureTitle(com.idiot.more.databinding.TvRegisterTitleBinding PictureTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHouseDetailTitle(com.idiot.more.databinding.TvRegisterTitleBinding HouseDetailTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeHouseVideoTitle(com.idiot.more.databinding.TvRegisterTitleBinding HouseVideoTitle, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbarRegisterInfo(com.idiot.utils.databinding.ToolbarLayoutBinding ToolbarRegisterInfo, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
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
        if ((dirtyFlags & 0x100L) != 0) {
            // api target 1

            this.addressTitle.setInputTitle("주소");
            this.arChecklistTitle.setInputTitle("AR체크리스트");
            this.houseDetailTitle.setInputTitle("건물정보");
            this.houseVideoTitle.setInputTitle("매물영상");
            this.optionTitle.setInputTitle("옵션");
            this.pictureTitle.setInputTitle("사진");
            this.priceDetailTitle.setInputTitle("가격정보");
            this.toolbarRegisterInfo.setTitle("매물정보 입력");
        }
        executeBindingsOn(toolbarRegisterInfo);
        executeBindingsOn(pictureTitle);
        executeBindingsOn(addressTitle);
        executeBindingsOn(houseDetailTitle);
        executeBindingsOn(priceDetailTitle);
        executeBindingsOn(optionTitle);
        executeBindingsOn(houseVideoTitle);
        executeBindingsOn(arChecklistTitle);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): priceDetailTitle
        flag 1 (0x2L): arChecklistTitle
        flag 2 (0x3L): addressTitle
        flag 3 (0x4L): optionTitle
        flag 4 (0x5L): pictureTitle
        flag 5 (0x6L): houseDetailTitle
        flag 6 (0x7L): houseVideoTitle
        flag 7 (0x8L): toolbarRegisterInfo
        flag 8 (0x9L): null
    flag mapping end*/
    //end
}