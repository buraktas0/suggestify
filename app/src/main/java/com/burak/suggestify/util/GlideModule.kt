package com.burak.suggestify.util

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.annotation.GlideModule;
import com.burak.suggestify.R

@GlideModule
class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.setDefaultRequestOptions(getRequestOptions())
    }

    private fun getRequestOptions(): RequestOptions {
        return RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_broken_image_24)
    }
}