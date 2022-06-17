package ru.coolhabit.firstapp.view.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ru.coolhabit.firstapp.databinding.MergePromoBinding
import ru.coolhabit.remote_module.entity.ApiConstants
private const val PROMO_CORNER = 55
class PromoView(context: Context, attributeSet: AttributeSet?) : FrameLayout(context, attributeSet) {
    val binding = MergePromoBinding.inflate(LayoutInflater.from(context), this)
    val watchButton = binding.watchButton

    fun setLinkForPoster(link: String) {
        Glide.with(binding.root)
            .load(ApiConstants.IMAGES_URL  + "w500" + link)
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(PROMO_CORNER)))
            .into(binding.poster)
    }
}