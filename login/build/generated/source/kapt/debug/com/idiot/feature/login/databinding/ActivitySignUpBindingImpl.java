package com.idiot.feature.login.databinding;
import com.idiot.feature.login.R;
import com.idiot.feature.login.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignUpBindingImpl extends ActivitySignUpBinding implements com.idiot.feature.login.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.close_button, 8);
        sViewsWithIds.put(R.id.sign_up_help_text_view, 9);
        sViewsWithIds.put(R.id.trans_type_title, 10);
        sViewsWithIds.put(R.id.trans_type_buttons, 11);
        sViewsWithIds.put(R.id.estate_type_buttons, 12);
        sViewsWithIds.put(R.id.region_title, 13);
        sViewsWithIds.put(R.id.region_top_decor, 14);
        sViewsWithIds.put(R.id.region_Decor, 15);
        sViewsWithIds.put(R.id.region_bottom_decor, 16);
        sViewsWithIds.put(R.id.complete_button, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivitySignUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (androidx.appcompat.widget.AppCompatButton) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.appcompat.widget.AppCompatButton) bindings[8]
            , (androidx.appcompat.widget.AppCompatButton) bindings[17]
            , (androidx.recyclerview.widget.RecyclerView) bindings[7]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.appcompat.widget.AppCompatButton) bindings[2]
            , (androidx.appcompat.widget.AppCompatButton) bindings[3]
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (android.view.View) bindings[16]
            , (android.view.View) bindings[15]
            , (android.widget.TextView) bindings[13]
            , (android.view.View) bindings[14]
            , (android.widget.TextView) bindings[9]
            , (androidx.appcompat.widget.AppCompatButton) bindings[1]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.TextView) bindings[10]
            );
        this.apartmentButton.setTag(null);
        this.citiesRecyclerview.setTag(null);
        this.distinctRecyclerview.setTag(null);
        this.leaseButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.monthlyButton.setTag(null);
        this.officetelButton.setTag(null);
        this.tradingButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.idiot.feature.login.generated.callback.OnClickListener(this, 4);
        mCallback2 = new com.idiot.feature.login.generated.callback.OnClickListener(this, 2);
        mCallback5 = new com.idiot.feature.login.generated.callback.OnClickListener(this, 5);
        mCallback3 = new com.idiot.feature.login.generated.callback.OnClickListener(this, 3);
        mCallback1 = new com.idiot.feature.login.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
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
        if (BR.vm == variableId) {
            setVm((com.idiot.feature.login.ui.sign.SignUpViewModel) variable);
        }
        else if (BR.cityAdapter == variableId) {
            setCityAdapter((com.idiot.feature.login.ui.sign.CityAdapter) variable);
        }
        else if (BR.subCityAdapter == variableId) {
            setSubCityAdapter((com.idiot.feature.login.ui.sign.SubCityAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.idiot.feature.login.ui.sign.SignUpViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public void setCityAdapter(@Nullable com.idiot.feature.login.ui.sign.CityAdapter CityAdapter) {
        this.mCityAdapter = CityAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.cityAdapter);
        super.requestRebind();
    }
    public void setSubCityAdapter(@Nullable com.idiot.feature.login.ui.sign.SubCityAdapter SubCityAdapter) {
        this.mSubCityAdapter = SubCityAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.subCityAdapter);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmPreferenceTrans((kotlinx.coroutines.flow.StateFlow<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeVmCityList((kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>>) object, fieldId);
            case 2 :
                return onChangeVmSubList((kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>>) object, fieldId);
            case 3 :
                return onChangeVmPreferenceEstate((kotlinx.coroutines.flow.StateFlow<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmPreferenceTrans(kotlinx.coroutines.flow.StateFlow<java.lang.Integer> VmPreferenceTrans, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmCityList(kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> VmCityList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmSubList(kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> VmSubList, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmPreferenceEstate(kotlinx.coroutines.flow.StateFlow<java.lang.Integer> VmPreferenceEstate, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        kotlinx.coroutines.flow.StateFlow<java.lang.Integer> vmPreferenceTrans = null;
        com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;
        kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> vmCityList = null;
        java.util.List<com.idiot.model.users.UserPreference> vmSubListGetValue = null;
        java.lang.Integer vmPreferenceTransGetValue = null;
        com.idiot.feature.login.ui.sign.CityAdapter cityAdapter = mCityAdapter;
        int androidxDatabindingViewDataBindingSafeUnboxVmPreferenceTransGetValue = 0;
        int androidxDatabindingViewDataBindingSafeUnboxVmPreferenceEstateGetValue = 0;
        com.idiot.feature.login.ui.sign.SubCityAdapter subCityAdapter = mSubCityAdapter;
        kotlinx.coroutines.flow.StateFlow<java.util.List<com.idiot.model.users.UserPreference>> vmSubList = null;
        java.lang.Integer vmPreferenceEstateGetValue = null;
        java.util.List<com.idiot.model.users.UserPreference> vmCityListGetValue = null;
        kotlinx.coroutines.flow.StateFlow<java.lang.Integer> vmPreferenceEstate = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0x91L) != 0) {

                    if (vm != null) {
                        // read vm.preferenceTrans
                        vmPreferenceTrans = vm.getPreferenceTrans();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 0, vmPreferenceTrans);


                    if (vmPreferenceTrans != null) {
                        // read vm.preferenceTrans.getValue()
                        vmPreferenceTransGetValue = vmPreferenceTrans.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.preferenceTrans.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxVmPreferenceTransGetValue = androidx.databinding.ViewDataBinding.safeUnbox(vmPreferenceTransGetValue);
            }
            if ((dirtyFlags & 0xb2L) != 0) {

                    if (vm != null) {
                        // read vm.cityList
                        vmCityList = vm.getCityList();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 1, vmCityList);


                    if (vmCityList != null) {
                        // read vm.cityList.getValue()
                        vmCityListGetValue = vmCityList.getValue();
                    }
            }
            if ((dirtyFlags & 0xd4L) != 0) {

                    if (vm != null) {
                        // read vm.subList
                        vmSubList = vm.getSubList();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 2, vmSubList);


                    if (vmSubList != null) {
                        // read vm.subList.getValue()
                        vmSubListGetValue = vmSubList.getValue();
                    }
            }
            if ((dirtyFlags & 0x98L) != 0) {

                    if (vm != null) {
                        // read vm.preferenceEstate
                        vmPreferenceEstate = vm.getPreferenceEstate();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 3, vmPreferenceEstate);


                    if (vmPreferenceEstate != null) {
                        // read vm.preferenceEstate.getValue()
                        vmPreferenceEstateGetValue = vmPreferenceEstate.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(vm.preferenceEstate.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxVmPreferenceEstateGetValue = androidx.databinding.ViewDataBinding.safeUnbox(vmPreferenceEstateGetValue);
            }
        }
        if ((dirtyFlags & 0xb2L) != 0) {
        }
        if ((dirtyFlags & 0xd4L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x98L) != 0) {
            // api target 1

            com.idiot.feature.login.bindings.ViewBinding.bindSelectEstate(this.apartmentButton, androidxDatabindingViewDataBindingSafeUnboxVmPreferenceEstateGetValue);
            com.idiot.feature.login.bindings.ViewBinding.bindSelectEstate(this.officetelButton, androidxDatabindingViewDataBindingSafeUnboxVmPreferenceEstateGetValue);
        }
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            this.apartmentButton.setOnClickListener(mCallback4);
            this.citiesRecyclerview.setItemAnimator((androidx.recyclerview.widget.RecyclerView.ItemAnimator) null);
            this.distinctRecyclerview.setItemAnimator((androidx.recyclerview.widget.RecyclerView.ItemAnimator) null);
            this.leaseButton.setOnClickListener(mCallback2);
            this.monthlyButton.setOnClickListener(mCallback3);
            this.officetelButton.setOnClickListener(mCallback5);
            this.tradingButton.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0xb2L) != 0) {
            // api target 1

            com.idiot.feature.login.bindings.RecyclerViewBinding.bindAdapter(this.citiesRecyclerview, cityAdapter, vmCityListGetValue);
        }
        if ((dirtyFlags & 0xd4L) != 0) {
            // api target 1

            com.idiot.feature.login.bindings.RecyclerViewBinding.bindAdapter(this.distinctRecyclerview, subCityAdapter, vmSubListGetValue);
        }
        if ((dirtyFlags & 0x91L) != 0) {
            // api target 1

            com.idiot.feature.login.bindings.ViewBinding.bindSelectType(this.leaseButton, androidxDatabindingViewDataBindingSafeUnboxVmPreferenceTransGetValue);
            com.idiot.feature.login.bindings.ViewBinding.bindSelectType(this.monthlyButton, androidxDatabindingViewDataBindingSafeUnboxVmPreferenceTransGetValue);
            com.idiot.feature.login.bindings.ViewBinding.bindSelectType(this.tradingButton, androidxDatabindingViewDataBindingSafeUnboxVmPreferenceTransGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.changePrefEstate(1);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.changePrefTrans(2);
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.changePrefEstate(2);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.changePrefTrans(3);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // vm != null
                boolean vmJavaLangObjectNull = false;
                // vm
                com.idiot.feature.login.ui.sign.SignUpViewModel vm = mVm;



                vmJavaLangObjectNull = (vm) != (null);
                if (vmJavaLangObjectNull) {



                    vm.changePrefTrans(1);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm.preferenceTrans
        flag 1 (0x2L): vm.cityList
        flag 2 (0x3L): vm.subList
        flag 3 (0x4L): vm.preferenceEstate
        flag 4 (0x5L): vm
        flag 5 (0x6L): cityAdapter
        flag 6 (0x7L): subCityAdapter
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}