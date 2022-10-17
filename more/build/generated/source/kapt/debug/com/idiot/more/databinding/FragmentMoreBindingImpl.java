package com.idiot.more.databinding;
import com.idiot.more.R;
import com.idiot.more.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMoreBindingImpl extends FragmentMoreBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(10);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_layout"},
            new int[] {4},
            new int[] {com.idiot.utils.R.layout.toolbar_layout});
        sIncludes.setIncludes(3, 
            new String[] {"layout_more_tab", "layout_more_tab", "layout_more_tab", "layout_more_tab"},
            new int[] {5, 6, 7, 8},
            new int[] {com.idiot.more.R.layout.layout_more_tab,
                com.idiot.more.R.layout.layout_more_tab,
                com.idiot.more.R.layout.layout_more_tab,
                com.idiot.more.R.layout.layout_more_tab});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.profile_button, 9);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.LinearLayoutCompat mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMoreBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private FragmentMoreBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[9]
            , (com.idiot.more.databinding.LayoutMoreTabBinding) bindings[5]
            , (com.idiot.more.databinding.LayoutMoreTabBinding) bindings[8]
            , (com.idiot.more.databinding.LayoutMoreTabBinding) bindings[7]
            , (com.idiot.more.databinding.LayoutMoreTabBinding) bindings[6]
            , (com.idiot.utils.databinding.ToolbarLayoutBinding) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (androidx.appcompat.widget.LinearLayoutCompat) bindings[3];
        this.mboundView3.setTag(null);
        setContainedBinding(this.refactorUser);
        setContainedBinding(this.register);
        setContainedBinding(this.runningProcess);
        setContainedBinding(this.settingAlarm);
        setContainedBinding(this.toolbarMore);
        this.userNameTextView.setTag(null);
        this.userRoleTextView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        toolbarMore.invalidateAll();
        refactorUser.invalidateAll();
        settingAlarm.invalidateAll();
        runningProcess.invalidateAll();
        register.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbarMore.hasPendingBindings()) {
            return true;
        }
        if (refactorUser.hasPendingBindings()) {
            return true;
        }
        if (settingAlarm.hasPendingBindings()) {
            return true;
        }
        if (runningProcess.hasPendingBindings()) {
            return true;
        }
        if (register.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.idiot.model.users.MyPageResponse) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.idiot.model.users.MyPageResponse Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbarMore.setLifecycleOwner(lifecycleOwner);
        refactorUser.setLifecycleOwner(lifecycleOwner);
        settingAlarm.setLifecycleOwner(lifecycleOwner);
        runningProcess.setLifecycleOwner(lifecycleOwner);
        register.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRefactorUser((com.idiot.more.databinding.LayoutMoreTabBinding) object, fieldId);
            case 1 :
                return onChangeRegister((com.idiot.more.databinding.LayoutMoreTabBinding) object, fieldId);
            case 2 :
                return onChangeSettingAlarm((com.idiot.more.databinding.LayoutMoreTabBinding) object, fieldId);
            case 3 :
                return onChangeRunningProcess((com.idiot.more.databinding.LayoutMoreTabBinding) object, fieldId);
            case 4 :
                return onChangeToolbarMore((com.idiot.utils.databinding.ToolbarLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRefactorUser(com.idiot.more.databinding.LayoutMoreTabBinding RefactorUser, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegister(com.idiot.more.databinding.LayoutMoreTabBinding Register, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeSettingAlarm(com.idiot.more.databinding.LayoutMoreTabBinding SettingAlarm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRunningProcess(com.idiot.more.databinding.LayoutMoreTabBinding RunningProcess, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbarMore(com.idiot.utils.databinding.ToolbarLayoutBinding ToolbarMore, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
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
        com.idiot.model.users.MyPageResponse model = mModel;
        java.lang.String modelIsBrokerJavaLangStringJavaLangString = null;
        boolean modelIsBroker = false;
        java.lang.String modelName = null;

        if ((dirtyFlags & 0x60L) != 0) {



                if (model != null) {
                    // read model.isBroker
                    modelIsBroker = model.isBroker();
                    // read model.name
                    modelName = model.getName();
                }
            if((dirtyFlags & 0x60L) != 0) {
                if(modelIsBroker) {
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x80L;
                }
            }


                // read model.isBroker ? "기업회원" : "개인회원"
                modelIsBrokerJavaLangStringJavaLangString = ((modelIsBroker) ? ("기업회원") : ("개인회원"));
        }
        // batch finished
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.refactorUser.setTabTitle("내 정보 수정");
            this.register.setTabTitle("매물 등록");
            this.runningProcess.setTabTitle("진행중인 계약");
            this.settingAlarm.setTabTitle("알림 설정");
            this.toolbarMore.setTitle("더보기");
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.userNameTextView, modelName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.userRoleTextView, modelIsBrokerJavaLangStringJavaLangString);
        }
        executeBindingsOn(toolbarMore);
        executeBindingsOn(refactorUser);
        executeBindingsOn(settingAlarm);
        executeBindingsOn(runningProcess);
        executeBindingsOn(register);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): refactorUser
        flag 1 (0x2L): register
        flag 2 (0x3L): settingAlarm
        flag 3 (0x4L): runningProcess
        flag 4 (0x5L): toolbarMore
        flag 5 (0x6L): model
        flag 6 (0x7L): null
        flag 7 (0x8L): model.isBroker ? "기업회원" : "개인회원"
        flag 8 (0x9L): model.isBroker ? "기업회원" : "개인회원"
    flag mapping end*/
    //end
}