package com.example.kotlin.domain

/**
 * @author Linbing Tang
 * @since 18-3-21.
 */
interface OnItemClickListener<T>{
    /**
     * 点击事件回调
     * @param data 回调数据
     */
    operator fun invoke(data:T)
}