/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.harvey.mvpandroid.mvp;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import java.lang.ref.WeakReference;

/**
 * Created by harvey on 2016/10/13 0013 09:41
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;

    @UiThread
    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @UiThread
    @Nullable
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @UiThread
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @UiThread
    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
