package com.idiot.home;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.idiot.home.databinding.FragmentHomeBindingImpl;
import com.idiot.home.databinding.FragmentHouseDetailBindingImpl;
import com.idiot.home.databinding.ListItemDetailOptionBindingImpl;
import com.idiot.home.databinding.ListItemHomeRecommendBindingImpl;
import com.idiot.home.databinding.SlideImageHouseDetailBindingImpl;
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
  private static final int LAYOUT_FRAGMENTHOME = 1;

  private static final int LAYOUT_FRAGMENTHOUSEDETAIL = 2;

  private static final int LAYOUT_LISTITEMDETAILOPTION = 3;

  private static final int LAYOUT_LISTITEMHOMERECOMMEND = 4;

  private static final int LAYOUT_SLIDEIMAGEHOUSEDETAIL = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.home.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.home.R.layout.fragment_house_detail, LAYOUT_FRAGMENTHOUSEDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.home.R.layout.list_item_detail_option, LAYOUT_LISTITEMDETAILOPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.home.R.layout.list_item_home_recommend, LAYOUT_LISTITEMHOMERECOMMEND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.home.R.layout.slide_image_house_detail, LAYOUT_SLIDEIMAGEHOUSEDETAIL);
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
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOUSEDETAIL: {
          if ("layout/fragment_house_detail_0".equals(tag)) {
            return new FragmentHouseDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_house_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMDETAILOPTION: {
          if ("layout/list_item_detail_option_0".equals(tag)) {
            return new ListItemDetailOptionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_detail_option is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMHOMERECOMMEND: {
          if ("layout/list_item_home_recommend_0".equals(tag)) {
            return new ListItemHomeRecommendBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_home_recommend is invalid. Received: " + tag);
        }
        case  LAYOUT_SLIDEIMAGEHOUSEDETAIL: {
          if ("layout/slide_image_house_detail_0".equals(tag)) {
            return new SlideImageHouseDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for slide_image_house_detail is invalid. Received: " + tag);
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
    result.add(new com.idiot.data.api.DataBinderMapperImpl());
    result.add(new com.idiot.data.repository.DataBinderMapperImpl());
    result.add(new com.idiot.model.DataBinderMapperImpl());
    result.add(new com.idiot.threeviewer.DataBinderMapperImpl());
    result.add(new com.idiot.utils.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(6);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "changeThumbnail");
      sKeys.put(2, "clickListener");
      sKeys.put(3, "title");
      sKeys.put(4, "viewModel");
      sKeys.put(5, "viewmodel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/fragment_home_0", com.idiot.home.R.layout.fragment_home);
      sKeys.put("layout/fragment_house_detail_0", com.idiot.home.R.layout.fragment_house_detail);
      sKeys.put("layout/list_item_detail_option_0", com.idiot.home.R.layout.list_item_detail_option);
      sKeys.put("layout/list_item_home_recommend_0", com.idiot.home.R.layout.list_item_home_recommend);
      sKeys.put("layout/slide_image_house_detail_0", com.idiot.home.R.layout.slide_image_house_detail);
    }
  }
}
