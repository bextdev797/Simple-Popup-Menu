package com.bextdev.simplepopupmenu;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.YailList;
import com.google.appinventor.components.runtime.EventDispatcher;
import android.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

public class SimplePopupMenu extends AndroidNonvisibleComponent {
  private AndroidViewComponent anchor = null;
  private PopupMenu popupMenu;
  private ComponentContainer container;

  public SimplePopupMenu(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }
  
  @SimpleFunction
  public void ShowMenu(YailList items){
    popupMenu = new PopupMenu(container.$context(), anchor.getView());
    
    for (Object item : items.toArray()) {
      popupMenu.getMenu().add(item.toString());
    }
    
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
       @Override  
       public boolean onMenuItemClick(MenuItem item) {
         OnMenuItemClicked();
         return true;
       }
    });
    
    popupMenu.show();
  }
  
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COMPONENT, defaultValue = "")
  @SimpleProperty
  public void Anchor(AndroidViewComponent component) {
   anchor = component;
  }
  
  @SimpleEvent
  public void OnMenuItemClicked(){
    EventDispatcher.dispatchEvent(this, "OnMenuItemClicked");
  }
  
  @SimpleFunction
  public void Dismiss(){
   popupMenu.dismiss();
  }
}
