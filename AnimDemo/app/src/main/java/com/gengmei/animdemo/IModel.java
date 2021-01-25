package com.gengmei.animdemo;

// 模型接口，定义了数据模型的操作
interface IModel {
    void setPresenter(IPresenter presenter);

    // 梳理数据
    void handleData(String data);

    // 清除数据
    void clearData();
}

// 视图接口，定义了视图的操作
interface IView {
    void setPresenter(IPresenter presenter);

    // 数据处理中视图
    void loading();

    // 数据展示
    void showData(String data);
}

// 控制器，定义了逻辑操作
interface IPresenter {
    void setView(IView view);

    void setModel(IModel model);

    // Model 处理完成数据通知 Presenter
    void dataHandled(String data);

    // Model 清除数据后通知 Presenter
    void dataCleared();

    // View 中 EditText 文字变化后通知 Presenter
    void onTextChanged(String text);

    // View 中 Button 点击事件通知 Presenter
    void onClearBtnClicked();
}