package com.gengmei.animdemo;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @author badmask_zly
 * Glide 升级到 4.8.0 之后，若只引用一个 com.github.bumptech.glide:glide:4.8.0，会报错：Failed to find GeneratedAppGlideModule.
 * 需要加入 com.github.bumptech.glide:compiler:4.8.0 这个才ok，并且会支持链式调用。
 * 网上解释是只有想链式调用时，才需要引入上面的库，实证网上大部分的说法不正确。
 * 结果：必须引入 com.github.bumptech.glide:compiler:4.8.0 这个库，
 *      并且使用 RequestOptions 类设置的 error、placeHolder 等方法在 4.8.0 版本中并不好用，so 更改使用方法：
 *
 * GlideApp.with(mContext).load("http://example")
 *                 .asBitmap() // 不显示gif图
 *                 .error(R.drawable.icon_default_head)
 *                 .placeholder(R.drawable.icon_default_head)
 *                 .fallback(R.drawable.icon_default_head)
 *                 .circleCrop()//设置圆形图片
 *                 .override(ScreenUtils.dip2px(35),ScreenUtils.dip2px(35))//指定图片的大小，非必须，当加载的图片比imageview大的时候，写入 iamgeview 的大小
 *                 .into(viewHolder.ivPortrait);
 *
 * 感谢：https://bumptech.github.io/glide/doc/download-setup.html
 * 设置圆角：https://juejin.im/post/5b3a3b8d6fb9a025080411e8
 */

@GlideModule
public class ImageAppGlideModule extends AppGlideModule {
}
