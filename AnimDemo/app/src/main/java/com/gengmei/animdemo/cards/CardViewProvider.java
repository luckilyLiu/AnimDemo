/*
 * Copyright 2016 drakeet. https://github.com/drakeet
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

package com.gengmei.animdemo.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengmei.animdemo.adapter.CardViewAdapter;
import com.gengmei.animdemo.adapter.JobBaseRecyclerAdapter;

import androidx.annotation.NonNull;

/***
 * @author drakeet
 *
 * https://github.com/drakeet/MultiType
 */
public abstract class CardViewProvider<T, V extends JobBaseRecyclerAdapter.JobBaseRecyclerViewHolder> {

    @Deprecated
    public CardViewAdapter adapter;

    @NonNull
    public abstract V onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);

    public abstract void onBindViewHolder(@NonNull V holder, @NonNull T t, int position);

    /**
     * Get the RecyclerView.Adapter for sending notifications or getting item count, etc.
     * 不要在用这个获取context了
     */
    @Deprecated
    @NonNull
    public final CardViewAdapter getAdapter() {
        return adapter;
    }

    /**
     * card item click
     *
     * @param view     itemView
     * @param bean     data
     * @param position click item position
     */
    public abstract void onCardItemClick(View view, T bean, int position);

}