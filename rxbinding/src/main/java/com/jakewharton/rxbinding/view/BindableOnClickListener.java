package com.jakewharton.rxbinding.view;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;

import com.jakewharton.rxbinding.internal.BindingCallback;

/**
 * Custom click listener that can react to
 */
public class BindableOnClickListener implements View.OnClickListener {

  BindingCallback bindingCallback;

  void setBindingCallback(BindingCallback bindingCallback) {
    this.bindingCallback = bindingCallback;
  }

  void removeBindingCallback() {
    this.bindingCallback = null;
  }

  @CallSuper
  @Override
  public void onClick(@NonNull final View v) {
    if (this.bindingCallback != null) {
      this.bindingCallback.onActionOccurred();
    }
  }
}
