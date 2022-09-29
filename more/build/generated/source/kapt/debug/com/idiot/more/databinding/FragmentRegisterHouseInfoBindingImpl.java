package com.idiot.more.databinding;
import com.idiot.more.R;
import com.idiot.more.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRegisterHouseInfoBindingImpl extends FragmentRegisterHouseInfoBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.house_info_title, 1);
        sViewsWithIds.put(R.id.close_button, 2);
        sViewsWithIds.put(R.id.building_type_selector, 3);
        sViewsWithIds.put(R.id.building_name_input, 4);
        sViewsWithIds.put(R.id.total_floor_title, 5);
        sViewsWithIds.put(R.id.building_total_floor_input, 6);
        sViewsWithIds.put(R.id.current_floor_title, 7);
        sViewsWithIds.put(R.id.building_current_floor_input, 8);
        sViewsWithIds.put(R.id.net_area_title, 9);
        sViewsWithIds.put(R.id.net_area_input, 10);
        sViewsWithIds.put(R.id.area_title, 11);
        sViewsWithIds.put(R.id.area_input, 12);
        sViewsWithIds.put(R.id.heat_type_selector, 13);
        sViewsWithIds.put(R.id.elevator_title, 14);
        sViewsWithIds.put(R.id.has_elevator_button, 15);
        sViewsWithIds.put(R.id.has_not_elevator_button, 16);
        sViewsWithIds.put(R.id.duplex_title, 17);
        sViewsWithIds.put(R.id.has_duplex_button, 18);
        sViewsWithIds.put(R.id.has_not_duplex_button, 19);
        sViewsWithIds.put(R.id.room_type_selector, 20);
        sViewsWithIds.put(R.id.veranda_title, 21);
        sViewsWithIds.put(R.id.has_veranda_button, 22);
        sViewsWithIds.put(R.id.has_not_veranda_button, 23);
        sViewsWithIds.put(R.id.short_term_title, 24);
        sViewsWithIds.put(R.id.short_able_button, 25);
        sViewsWithIds.put(R.id.short_disable_button, 26);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRegisterHouseInfoBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }
    private FragmentRegisterHouseInfoBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.EditText) bindings[12]
            , (android.widget.TextView) bindings[11]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[6]
            , (android.widget.Spinner) bindings[3]
            , (androidx.appcompat.widget.AppCompatButton) bindings[2]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[14]
            , (androidx.appcompat.widget.AppCompatButton) bindings[18]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[19]
            , (androidx.appcompat.widget.AppCompatButton) bindings[16]
            , (androidx.appcompat.widget.AppCompatButton) bindings[23]
            , (androidx.appcompat.widget.AppCompatButton) bindings[22]
            , (android.widget.Spinner) bindings[13]
            , (android.widget.FrameLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.EditText) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.Spinner) bindings[20]
            , (androidx.appcompat.widget.AppCompatButton) bindings[25]
            , (androidx.appcompat.widget.AppCompatButton) bindings[26]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[21]
            );
        this.houseInfoLayout.setTag(null);
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