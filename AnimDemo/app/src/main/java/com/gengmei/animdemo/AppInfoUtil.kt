package com.gengmei.animdemo

/**
 * 关于版本的信息
 *
 * @author jie
 * @since 2014年7月31日 下午12:07:20
 */
object AppInfoUtil {
    /**
     * 获取包名
     * @return
     */
    val packageName: String
        get() {
            val context = UtilsManager.getInstance().context
            return context.packageName
        }
}