// Generated code from Butter Knife. Do not modify!
package com.omatt.fdlsandbox.modules.main;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.omatt.fdlsandbox.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public final class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165317;

  private View view2131165222;

  private View view2131165224;

  private View view2131165225;

  private View view2131165223;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.textViewFDLLong = Utils.findRequiredViewAsType(source, R.id.textView_fdl_long, "field 'textViewFDLLong'", TextView.class);
    target.textViewFDLShort = Utils.findRequiredViewAsType(source, R.id.textView_fdl_short, "field 'textViewFDLShort'", TextView.class);
    view = Utils.findRequiredView(source, R.id.switch_catch_crash, "method 'onSwitchChanged'");
    view2131165317 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onSwitchChanged(p1);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_app_invite_send, "method 'sendAppInvite'");
    view2131165222 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendAppInvite();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_gen_fdl, "method 'generateFDL'");
    view2131165224 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.generateFDL();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_web_view, "method 'openInAppBrowser'");
    view2131165225 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openInAppBrowser();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_force_crash, "method 'onClickCrash'");
    view2131165223 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickCrash();
      }
    });
  }

  @Override
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewFDLLong = null;
    target.textViewFDLShort = null;

    ((CompoundButton) view2131165317).setOnCheckedChangeListener(null);
    view2131165317 = null;
    view2131165222.setOnClickListener(null);
    view2131165222 = null;
    view2131165224.setOnClickListener(null);
    view2131165224 = null;
    view2131165225.setOnClickListener(null);
    view2131165225 = null;
    view2131165223.setOnClickListener(null);
    view2131165223 = null;
  }
}
