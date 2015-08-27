package com.jakewharton.rxbinding.view;

import android.support.annotation.Nullable;
import android.view.View;

import com.jakewharton.rxbinding.internal.BindingCallback;
import com.jakewharton.rxbinding.internal.MainThreadSubscription;

import rx.Observable;
import rx.Subscriber;

import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

final class ViewClickOnSubscribe implements Observable.OnSubscribe<Object> {
  private final Object event = new Object();
  private final View view;
  private BindableOnClickListener listener;
  private boolean listenerProvided = true;

  ViewClickOnSubscribe(View view) {
    this(view, null);
    this.listenerProvided = false;
  }

  ViewClickOnSubscribe(View view, @Nullable BindableOnClickListener listener) {
    this.view = view;
    this.listener = listener;
  }

  @Override public void call(final Subscriber<? super Object> subscriber) {
    checkUiThread();

    if (!listenerProvided && listener == null) {
      listener = new BindableOnClickListener();
      view.setOnClickListener(listener);
    }
    listener.setBindingCallback(new BindingCallback() {
      @Override
      public void onActionOccurred() {
        if (!subscriber.isUnsubscribed()) {
          subscriber.onNext(event);
        }
      }
    });

    subscriber.add(new MainThreadSubscription() {
      @Override
      protected void onUnsubscribe() {
        listener.removeBindingCallback();
        listener = null;
        if (!listenerProvided) {
          view.setOnClickListener(null);
        }
      }
    });
  }
}
