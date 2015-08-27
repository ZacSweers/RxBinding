package com.jakewharton.rxbinding.view

import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import com.jakewharton.rxbinding.internal.Functions
import rx.Observable
import rx.functions.Action1
import rx.functions.Func0
import rx.functions.Func1

/**
 * Create an observable which emits on `view` attach events. The emitted value is
 * unspecified and should only be used as notification.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.attaches(): Observable<Any> = RxView.attaches(this)

/**
 * Create an observable of attach and detach events on `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.attachEvents(): Observable<ViewAttachEvent> = RxView.attachEvents(this)

/**
 * Create an observable which emits on `view` detach events. The emitted value is
 * unspecified and should only be used as notification.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.detaches(): Observable<Any> = RxView.detaches(this)

/**
 * Create an observable which emits on `view` click events. The emitted value is
 * unspecified and should only be used as notification.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnClickListener] to observe
 * clicks. Only one observable can be used for a view at a time.
 */
public inline fun View.clicks(): Observable<Any> = RxView.clicks(this)

/**
 * Create an observable which emits on `view` click events. The emitted value is
 * unspecified and should only be used as notification. This overload takes a
 * [BindableOnClickListener] instance and does not call
 * {@link View#setOnClickListener(OnClickListener)}, rather it reacts to the `listener`
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.clicks(listener: BindableOnClickListener): Observable<Any> = RxView.clicks(this, listener)

/**
 * Create an observable of click events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnClickListener] to observe
 * clicks. Only one observable can be used for a view at a time.
 */
public inline fun View.clickEvents(): Observable<ViewClickEvent> = RxView.clickEvents(this)

/**
 * Create an observable of [DragEvent] for drags on `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnDragListener] to observe
 * drags. Only one observable can be used for a view at a time.
 */
public inline fun View.drags(): Observable<DragEvent> = RxView.drags(this)

/**
 * Create an observable of [DragEvent] for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnDragListener] to observe
 * drags. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked with each value to determine the return value of the
 * underlying [View.OnDragListener].
 */
public inline fun View.drags(handled: Func1<in DragEvent, Boolean>): Observable<DragEvent> = RxView.drags(this, handled)

/**
 * Create an observable of drag events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnDragListener] to observe
 * drags. Only one observable can be used for a view at a time.
 */
public inline fun View.dragEvents(): Observable<ViewDragEvent> = RxView.dragEvents(this)

/**
 * Create an observable of drag events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnDragListener] to observe
 * drags. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked with each value to determine the return value of the
 * underlying [View.OnDragListener].
 */
public inline fun View.dragEvents(handled: Func1<in ViewDragEvent, Boolean>): Observable<ViewDragEvent> = RxView.dragEvents(this, handled)

/**
 * Create an observable of booleans representing the focus of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnFocusChangeListener] to observe
 * focus change. Only one observable can be used for a view at a time.
 * 
 * *Note:* A value will be emitted immediately on subscribe.
 */
public inline fun View.focusChanges(): Observable<Boolean> = RxView.focusChanges(this)

/**
 * Create an observable of focus-change events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnFocusChangeListener] to observe
 * focus change. Only one observable can be used for a view at a time.
 * 
 * *Note:* A value will be emitted immediately on subscribe.
 */
public inline fun View.focusChangeEvents(): Observable<ViewFocusChangeEvent> = RxView.focusChangeEvents(this)

/**
 * Create an observable which emits on `view` long-click events. The emitted value is
 * unspecified and should only be used as notification.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnLongClickListener] to observe
 * long clicks. Only one observable can be used for a view at a time.
 */
public inline fun View.longClicks(): Observable<Any> = RxView.longClicks(this)

/**
 * Create an observable which emits on `view` long-click events. The emitted value is
 * unspecified and should only be used as notification.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnLongClickListener] to observe
 * long clicks. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked each occurrence to determine the return value of the
 * underlying [View.OnLongClickListener].
 */
public inline fun View.longClicks(handled: Func0<Boolean>): Observable<Any> = RxView.longClicks(this, handled)

/**
 * Create an observable of long-clicks events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnLongClickListener] to observe
 * long clicks. Only one observable can be used for a view at a time.
 */
public inline fun View.longClickEvents(): Observable<ViewLongClickEvent> = RxView.longClickEvents(this)

/**
 * Create an observable of long-click events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnLongClickListener] to observe
 * long clicks. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked with each value to determine the return value of the
 * underlying [View.OnLongClickListener].
 */
public inline fun View.longClickEvents(handled: Func1<in ViewLongClickEvent, Boolean>): Observable<ViewLongClickEvent> = RxView.longClickEvents(this, handled)

/**
 * Create an observable of touch events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnTouchListener] to observe
 * touches. Only one observable can be used for a view at a time.
 */
public inline fun View.touches(): Observable<MotionEvent> = RxView.touches(this)

/**
 * Create an observable of touch events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnTouchListener] to observe
 * touches. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked with each value to determine the return value of the
 * underlying [View.OnTouchListener].
 */
public inline fun View.touches(handled: Func1<in MotionEvent, Boolean>): Observable<MotionEvent> = RxView.touches(this, handled)

/**
 * Create an observable of touch events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnTouchListener] to observe
 * touches. Only one observable can be used for a view at a time.
 */
public inline fun View.touchEvents(): Observable<ViewTouchEvent> = RxView.touchEvents(this)

/**
 * Create an observable of touch events for `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 * 
 * *Warning:* The created observable uses [View.setOnTouchListener] to observe
 * touches. Only one observable can be used for a view at a time.
 *
 * @param handled Function invoked with each value to determine the return value of the
 * underlying [View.OnTouchListener].
 */
public inline fun View.touchEvents(handled: Func1<in ViewTouchEvent, Boolean>): Observable<ViewTouchEvent> = RxView.touchEvents(this, handled)

/**
 * An action which sets the activated property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.activated(): Action1<in Boolean> = RxView.activated(this)

/**
 * An action which sets the clickable property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.clickable(): Action1<in Boolean> = RxView.clickable(this)

/**
 * An action which sets the enabled property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.enabled(): Action1<in Boolean> = RxView.enabled(this)

/**
 * An action which sets the pressed property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.pressed(): Action1<in Boolean> = RxView.pressed(this)

/**
 * An action which sets the selected property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.selected(): Action1<in Boolean> = RxView.selected(this)

/**
 * An action which sets the visibility property of `view`. `false` values use
 * `View.GONE`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 */
public inline fun View.visibility(): Action1<in Boolean> = RxView.visibility(this)

/**
 * An action which sets the visibility property of `view`.
 * 
 * *Warning:* The created observable keeps a strong reference to `view`. Unsubscribe
 * to free this reference.
 *
 * @param visibilityWhenFalse Visibility to set on a `false` value (`View.INVISIBLE`
 * or `View.GONE`).
 */
public inline fun View.visibility(visibilityWhenFalse: Int): Action1<in Boolean> = RxView.visibility(this, visibilityWhenFalse)
