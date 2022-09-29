package com.idiot.feature.login;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.idiot.feature.login.databinding.ActivityLoginBindingImpl;
import com.idiot.feature.login.databinding.ActivitySignUpBindingImpl;
import com.idiot.feature.login.databinding.ListItemCitiesBindingImpl;
import com.idiot.feature.login.databinding.ListItemDistinctBindingImpl;
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
  private static final int LAYOUT_ACTIVITYLOGIN = 1;

  private static final int LAYOUT_ACTIVITYSIGNUP = 2;

  private static final int LAYOUT_LISTITEMCITIES = 3;

  private static final int LAYOUT_LISTITEMDISTINCT = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.feature.login.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.feature.login.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.feature.login.R.layout.list_item_cities, LAYOUT_LISTITEMCITIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.feature.login.R.layout.list_item_distinct, LAYOUT_LISTITEMDISTINCT);
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
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMCITIES: {
          if ("layout/list_item_cities_0".equals(tag)) {
            return new ListItemCitiesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_cities is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMDISTINCT: {
          if ("layout/list_item_distinct_0".equals(tag)) {
            return new ListItemDistinctBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_distinct is invalid. Received: " + tag);
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
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(6);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.idiot.common.DataBinderMapperImpl());
    result.add(new com.idiot.data.api.DataBinderMapperImpl());
    result.add(new com.idiot.data.repository.DataBinderMapperImpl());
    result.add(new com.idiot.model.DataBinderMapperImpl());
    result.add(new com.idiot.utils.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(17);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "changeThumbnail");
      sKeys.put(2, "city");
      sKeys.put(3, "cityAdapter");
      sKeys.put(4, "clickListener");
      sKeys.put(5, "distinct");
      sKeys.put(6, "hasRequest");
      sKeys.put(7, "inputTitle");
      sKeys.put(8, "isSelected");
      sKeys.put(9, "owner");
      sKeys.put(10, "subCityAdapter");
      sKeys.put(11, "tabTitle");
      sKeys.put(12, "title");
      sKeys.put(13, "type");
      sKeys.put(14, "viewModel");
      sKeys.put(15, "viewmodel");
      sKeys.put(16, "vm");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_login_0", com.idiot.feature.login.R.layout.activity_login);
      sKeys.put("layout/activity_sign_up_0", com.idiot.feature.login.R.layout.activity_sign_up);
      sKeys.put("layout/list_item_cities_0", com.idiot.feature.login.R.layout.list_item_cities);
      sKeys.put("layout/list_item_distinct_0", com.idiot.feature.login.R.layout.list_item_distinct);
    }
  }
}
