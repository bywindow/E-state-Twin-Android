package com.idiot.more;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.idiot.more.databinding.FragmentAddressSearchDialogBindingImpl;
import com.idiot.more.databinding.FragmentMoreBindingImpl;
import com.idiot.more.databinding.FragmentNewRegisterRequestBindingImpl;
import com.idiot.more.databinding.FragmentRegisterBindingImpl;
import com.idiot.more.databinding.FragmentRegisterForBrokerBindingImpl;
import com.idiot.more.databinding.FragmentRegisterHouseInfoBindingImpl;
import com.idiot.more.databinding.FragmentRegisterInfoBindingImpl;
import com.idiot.more.databinding.LayoutMoreTabBindingImpl;
import com.idiot.more.databinding.ListItemBuildingTypeSpinnerBindingImpl;
import com.idiot.more.databinding.ListItemNewRegisterBindingImpl;
import com.idiot.more.databinding.ListItemRegisterInfoPictureBindingImpl;
import com.idiot.more.databinding.ListItemRegisterInfoPictureHeaderBindingImpl;
import com.idiot.more.databinding.ListItemRegisterOptionBindingImpl;
import com.idiot.more.databinding.ListNewRegisterRequestBindingImpl;
import com.idiot.more.databinding.TvRegisterTitleBindingImpl;
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
  private static final int LAYOUT_FRAGMENTADDRESSSEARCHDIALOG = 1;

  private static final int LAYOUT_FRAGMENTMORE = 2;

  private static final int LAYOUT_FRAGMENTNEWREGISTERREQUEST = 3;

  private static final int LAYOUT_FRAGMENTREGISTER = 4;

  private static final int LAYOUT_FRAGMENTREGISTERFORBROKER = 5;

  private static final int LAYOUT_FRAGMENTREGISTERHOUSEINFO = 6;

  private static final int LAYOUT_FRAGMENTREGISTERINFO = 7;

  private static final int LAYOUT_LAYOUTMORETAB = 8;

  private static final int LAYOUT_LISTITEMBUILDINGTYPESPINNER = 9;

  private static final int LAYOUT_LISTITEMNEWREGISTER = 10;

  private static final int LAYOUT_LISTITEMREGISTERINFOPICTURE = 11;

  private static final int LAYOUT_LISTITEMREGISTERINFOPICTUREHEADER = 12;

  private static final int LAYOUT_LISTITEMREGISTEROPTION = 13;

  private static final int LAYOUT_LISTNEWREGISTERREQUEST = 14;

  private static final int LAYOUT_TVREGISTERTITLE = 15;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(15);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_address_search_dialog, LAYOUT_FRAGMENTADDRESSSEARCHDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_more, LAYOUT_FRAGMENTMORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_new_register_request, LAYOUT_FRAGMENTNEWREGISTERREQUEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_register, LAYOUT_FRAGMENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_register_for_broker, LAYOUT_FRAGMENTREGISTERFORBROKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_register_house_info, LAYOUT_FRAGMENTREGISTERHOUSEINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.fragment_register_info, LAYOUT_FRAGMENTREGISTERINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.layout_more_tab, LAYOUT_LAYOUTMORETAB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_item_building_type_spinner, LAYOUT_LISTITEMBUILDINGTYPESPINNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_item_new_register, LAYOUT_LISTITEMNEWREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_item_register_info_picture, LAYOUT_LISTITEMREGISTERINFOPICTURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_item_register_info_picture_header, LAYOUT_LISTITEMREGISTERINFOPICTUREHEADER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_item_register_option, LAYOUT_LISTITEMREGISTEROPTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.list_new_register_request, LAYOUT_LISTNEWREGISTERREQUEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.idiot.more.R.layout.tv_register_title, LAYOUT_TVREGISTERTITLE);
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
        case  LAYOUT_FRAGMENTADDRESSSEARCHDIALOG: {
          if ("layout/fragment_address_search_dialog_0".equals(tag)) {
            return new FragmentAddressSearchDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_address_search_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMORE: {
          if ("layout/fragment_more_0".equals(tag)) {
            return new FragmentMoreBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_more is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWREGISTERREQUEST: {
          if ("layout/fragment_new_register_request_0".equals(tag)) {
            return new FragmentNewRegisterRequestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_new_register_request is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTER: {
          if ("layout/fragment_register_0".equals(tag)) {
            return new FragmentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTERFORBROKER: {
          if ("layout/fragment_register_for_broker_0".equals(tag)) {
            return new FragmentRegisterForBrokerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register_for_broker is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTERHOUSEINFO: {
          if ("layout/fragment_register_house_info_0".equals(tag)) {
            return new FragmentRegisterHouseInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register_house_info is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGISTERINFO: {
          if ("layout/fragment_register_info_0".equals(tag)) {
            return new FragmentRegisterInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_register_info is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMORETAB: {
          if ("layout/layout_more_tab_0".equals(tag)) {
            return new LayoutMoreTabBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_more_tab is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMBUILDINGTYPESPINNER: {
          if ("layout/list_item_building_type_spinner_0".equals(tag)) {
            return new ListItemBuildingTypeSpinnerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_building_type_spinner is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMNEWREGISTER: {
          if ("layout/list_item_new_register_0".equals(tag)) {
            return new ListItemNewRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_new_register is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMREGISTERINFOPICTURE: {
          if ("layout/list_item_register_info_picture_0".equals(tag)) {
            return new ListItemRegisterInfoPictureBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_register_info_picture is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMREGISTERINFOPICTUREHEADER: {
          if ("layout/list_item_register_info_picture_header_0".equals(tag)) {
            return new ListItemRegisterInfoPictureHeaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_register_info_picture_header is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMREGISTEROPTION: {
          if ("layout/list_item_register_option_0".equals(tag)) {
            return new ListItemRegisterOptionBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_register_option is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTNEWREGISTERREQUEST: {
          if ("layout/list_new_register_request_0".equals(tag)) {
            return new ListNewRegisterRequestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_new_register_request is invalid. Received: " + tag);
        }
        case  LAYOUT_TVREGISTERTITLE: {
          if ("layout/tv_register_title_0".equals(tag)) {
            return new TvRegisterTitleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for tv_register_title is invalid. Received: " + tag);
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
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "hasRequest");
      sKeys.put(3, "inputTitle");
      sKeys.put(4, "owner");
      sKeys.put(5, "tabTitle");
      sKeys.put(6, "title");
      sKeys.put(7, "type");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(15);

    static {
      sKeys.put("layout/fragment_address_search_dialog_0", com.idiot.more.R.layout.fragment_address_search_dialog);
      sKeys.put("layout/fragment_more_0", com.idiot.more.R.layout.fragment_more);
      sKeys.put("layout/fragment_new_register_request_0", com.idiot.more.R.layout.fragment_new_register_request);
      sKeys.put("layout/fragment_register_0", com.idiot.more.R.layout.fragment_register);
      sKeys.put("layout/fragment_register_for_broker_0", com.idiot.more.R.layout.fragment_register_for_broker);
      sKeys.put("layout/fragment_register_house_info_0", com.idiot.more.R.layout.fragment_register_house_info);
      sKeys.put("layout/fragment_register_info_0", com.idiot.more.R.layout.fragment_register_info);
      sKeys.put("layout/layout_more_tab_0", com.idiot.more.R.layout.layout_more_tab);
      sKeys.put("layout/list_item_building_type_spinner_0", com.idiot.more.R.layout.list_item_building_type_spinner);
      sKeys.put("layout/list_item_new_register_0", com.idiot.more.R.layout.list_item_new_register);
      sKeys.put("layout/list_item_register_info_picture_0", com.idiot.more.R.layout.list_item_register_info_picture);
      sKeys.put("layout/list_item_register_info_picture_header_0", com.idiot.more.R.layout.list_item_register_info_picture_header);
      sKeys.put("layout/list_item_register_option_0", com.idiot.more.R.layout.list_item_register_option);
      sKeys.put("layout/list_new_register_request_0", com.idiot.more.R.layout.list_new_register_request);
      sKeys.put("layout/tv_register_title_0", com.idiot.more.R.layout.tv_register_title);
    }
  }
}
