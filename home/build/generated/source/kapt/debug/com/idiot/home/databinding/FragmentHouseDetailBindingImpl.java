package com.idiot.home.databinding;
import com.idiot.home.R;
import com.idiot.home.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHouseDetailBindingImpl extends FragmentHouseDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.glideSlideViewPager, 1);
        sViewsWithIds.put(R.id.backButton, 2);
        sViewsWithIds.put(R.id.shareButton, 3);
        sViewsWithIds.put(R.id.videoPlayButton, 4);
        sViewsWithIds.put(R.id.threeDimenButton, 5);
        sViewsWithIds.put(R.id.ARPlayButton, 6);
        sViewsWithIds.put(R.id.ARCameraButton, 7);
        sViewsWithIds.put(R.id.basic_info_layout, 8);
        sViewsWithIds.put(R.id.basic_price_info_textView, 9);
        sViewsWithIds.put(R.id.basic_info_register_date_textView, 10);
        sViewsWithIds.put(R.id.basic_house_name_textView, 11);
        sViewsWithIds.put(R.id.basic_room_image, 12);
        sViewsWithIds.put(R.id.basic_room_textView, 13);
        sViewsWithIds.put(R.id.basic_floor_image, 14);
        sViewsWithIds.put(R.id.basic_floor_textView, 15);
        sViewsWithIds.put(R.id.basic_size_image, 16);
        sViewsWithIds.put(R.id.basic_size_textView, 17);
        sViewsWithIds.put(R.id.basic_cost_image, 18);
        sViewsWithIds.put(R.id.basic_cost_textView, 19);
        sViewsWithIds.put(R.id.option_info_textView, 20);
        sViewsWithIds.put(R.id.detail_option_list, 21);
        sViewsWithIds.put(R.id.price_info_textView, 22);
        sViewsWithIds.put(R.id.deposit_textView, 23);
        sViewsWithIds.put(R.id.deposit_content_textView, 24);
        sViewsWithIds.put(R.id.maintenance_fee_textView, 25);
        sViewsWithIds.put(R.id.maintenance_fee_content_textView, 26);
        sViewsWithIds.put(R.id.maintenance_fee_sub_content_textView, 27);
        sViewsWithIds.put(R.id.parking_fee_textView, 28);
        sViewsWithIds.put(R.id.parking_fee_content_textView, 29);
        sViewsWithIds.put(R.id.detail_info_textView, 30);
        sViewsWithIds.put(R.id.home_type_textView, 31);
        sViewsWithIds.put(R.id.home_type_content_textView, 32);
        sViewsWithIds.put(R.id.home_name_textView, 33);
        sViewsWithIds.put(R.id.home_name_content_textView, 34);
        sViewsWithIds.put(R.id.home_register_date_textView, 35);
        sViewsWithIds.put(R.id.home_register_date_content_textView, 36);
        sViewsWithIds.put(R.id.floor_textView, 37);
        sViewsWithIds.put(R.id.floor_content_textView, 38);
        sViewsWithIds.put(R.id.area_textView, 39);
        sViewsWithIds.put(R.id.net_area_content_textView, 40);
        sViewsWithIds.put(R.id.area_content_textView, 41);
        sViewsWithIds.put(R.id.heat_textView, 42);
        sViewsWithIds.put(R.id.heat_content_textView, 43);
        sViewsWithIds.put(R.id.elevator_textView, 44);
        sViewsWithIds.put(R.id.elevator_content_textView, 45);
        sViewsWithIds.put(R.id.duplex_textView, 46);
        sViewsWithIds.put(R.id.duplex_content_textView, 47);
        sViewsWithIds.put(R.id.loft_textView, 48);
        sViewsWithIds.put(R.id.loft_content_textView, 49);
        sViewsWithIds.put(R.id.verands_textView, 50);
        sViewsWithIds.put(R.id.verands_content_textView, 51);
        sViewsWithIds.put(R.id.short_term_textView, 52);
        sViewsWithIds.put(R.id.short_term_content_textView, 53);
        sViewsWithIds.put(R.id.move_in_available_textView, 54);
        sViewsWithIds.put(R.id.move_in_available_content_textView, 55);
        sViewsWithIds.put(R.id.broker_info_textView, 56);
        sViewsWithIds.put(R.id.broker_profile_imageView, 57);
        sViewsWithIds.put(R.id.broker_name_textView, 58);
        sViewsWithIds.put(R.id.broker_info_host_textView, 59);
        sViewsWithIds.put(R.id.broker_info_addr_textView, 60);
        sViewsWithIds.put(R.id.broker_info_phone_textView, 61);
        sViewsWithIds.put(R.id.broker_call_button, 62);
        sViewsWithIds.put(R.id.house_like_button, 63);
        sViewsWithIds.put(R.id.visit_reservation, 64);
        sViewsWithIds.put(R.id.run_process, 65);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHouseDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 66, sIncludes, sViewsWithIds));
    }
    private FragmentHouseDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[7]
            , (androidx.appcompat.widget.AppCompatButton) bindings[6]
            , (android.widget.TextView) bindings[41]
            , (android.widget.TextView) bindings[39]
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[2]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (com.google.android.material.button.MaterialButton) bindings[62]
            , (android.widget.TextView) bindings[60]
            , (android.widget.TextView) bindings[59]
            , (android.widget.TextView) bindings[61]
            , (android.widget.TextView) bindings[56]
            , (android.widget.TextView) bindings[58]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[57]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[21]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[46]
            , (android.widget.TextView) bindings[45]
            , (android.widget.TextView) bindings[44]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[37]
            , (androidx.viewpager2.widget.ViewPager2) bindings[1]
            , (android.widget.TextView) bindings[43]
            , (android.widget.TextView) bindings[42]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[31]
            , (androidx.appcompat.widget.AppCompatButton) bindings[63]
            , (android.widget.TextView) bindings[49]
            , (android.widget.TextView) bindings[48]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[55]
            , (android.widget.TextView) bindings[54]
            , (android.widget.TextView) bindings[40]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[65]
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[3]
            , (android.widget.TextView) bindings[53]
            , (android.widget.TextView) bindings[52]
            , (androidx.appcompat.widget.AppCompatButton) bindings[5]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[50]
            , (androidx.appcompat.widget.AppCompatButton) bindings[4]
            , (android.widget.TextView) bindings[64]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
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