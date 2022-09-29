package com.idiot.userhouse;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.idiot.userhouse.databinding.FragmentMyHouseBindingImpl;
import com.idiot.userhouse.databinding.FragmentOwnerModeBindingImpl;
import com.idiot.userhouse.databinding.FragmentTenantModeBindingImpl;
import com.idiot.userhouse.databinding.LayoutMyhouseTabBindingImpl;
import com.idiot.userhouse.databinding.ListItemOwnerHouseBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTMYHOUSE = 1;

  private static final int LAYOUT_FRAGMENTOWNERMODE = 2;

  private static final int LAYOUT_FRAGMENTTENANTMODE = 3;

  private static final int LAYOUT_LAYOUTMYHOUSETAB = 4;

  private static final int LAYOUT_LISTITEMOWNERHOUSE = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.userhouse.R.layout.fragment_my_house, LAYOUT_FRAGMENTMYHOUSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.userhouse.R.layout.fragment_owner_mode, LAYOUT_FRAGMENTOWNERMODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.userhouse.R.layout.fragment_tenant_mode, LAYOUT_FRAGMENTTENANTMODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.userhouse.R.layout.layout_myhouse_tab, LAYOUT_LAYOUTMYHOUSETAB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.userhouse.R.layout.list_item_owner_house, LAYOUT_LISTITEMOWNERHOUSE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTMYHOUSE: {
          if ("layout/fragment_my_house_0".equals(tag)) {
            return new FragmentMyHouseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_my_house is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTOWNERMODE: {
          if ("layout/fragment_owner_mode_0".equals(tag)) {
            return new FragmentOwnerModeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_owner_mode is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTTENANTMODE: {
          if ("layout/fragment_tenant_mode_0".equals(tag)) {
            return new FragmentTenantModeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_tenant_mode is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMYHOUSETAB: {
          if ("layout/layout_myhouse_tab_0".equals(tag)) {
            return new LayoutMyhouseTabBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_myhouse_tab is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMOWNERHOUSE: {
          if ("layout/list_item_owner_house_0".equals(tag)) {
            return new ListItemOwnerHouseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_owner_house is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(4);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.idiot.data.repository.DataBinderMapperImpl());
    result.add(new com.idiot.model.DataBinderMapperImpl());
    result.add(new com.idiot.utils.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "title");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/fragment_my_house_0", com.idiot.userhouse.R.layout.fragment_my_house);
      sKeys.put("layout/fragment_owner_mode_0", com.idiot.userhouse.R.layout.fragment_owner_mode);
      sKeys.put("layout/fragment_tenant_mode_0", com.idiot.userhouse.R.layout.fragment_tenant_mode);
      sKeys.put("layout/layout_myhouse_tab_0", com.idiot.userhouse.R.layout.layout_myhouse_tab);
      sKeys.put("layout/list_item_owner_house_0", com.idiot.userhouse.R.layout.list_item_owner_house);
    }
  }
}
