// Generated code from Butter Knife. Do not modify!
package com.omatt.fdlsandbox.modules.deeplink;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.omatt.fdlsandbox.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public final class DeepLinkActivity_ViewBinding implements Unbinder {
  private DeepLinkActivity target;

  private View view2131165221;

  @UiThread
  public DeepLinkActivity_ViewBinding(DeepLinkActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DeepLinkActivity_ViewBinding(final DeepLinkActivity target, View source) {
    this.target = target;

    View view;
    target.textViewDeepLink = Utils.findRequiredViewAsType(source, R.id.textView_deep_link, "field 'textViewDeepLink'", TextView.class);
    target.textViewInviteId = Utils.findRequiredViewAsType(source, R.id.textView_invite_id, "field 'textViewInviteId'", TextView.class);
    target.textViewReferrerId = Utils.findRequiredViewAsType(source, R.id.textView_referrer_id, "field 'textViewReferrerId'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_app_invite_ok, "method 'onClickOK'");
    view2131165221 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickOK();
      }
    });
  }

  @Override
  public void unbind() {
    DeepLinkActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewDeepLink = null;
    target.textViewInviteId = null;
    target.textViewReferrerId = null;

    view2131165221.setOnClickListener(null);
    view2131165221 = null;
  }
}
