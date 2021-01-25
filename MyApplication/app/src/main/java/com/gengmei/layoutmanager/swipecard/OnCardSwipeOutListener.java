package com.gengmei.layoutmanager.swipecard;

public interface OnCardSwipeOutListener<T> {
    void onSwiped(boolean isLeftSwipe, int position, T dataItem);
}
