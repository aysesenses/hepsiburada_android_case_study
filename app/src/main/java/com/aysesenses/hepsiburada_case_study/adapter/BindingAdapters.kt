package com.aysesenses.hepsiburada_case_study.adapter

import android.os.Build
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_DIV
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aysesenses.hepsiburada_case_study.R
import com.aysesenses.hepsiburada_case_study.network.ItunesApiStatus
import com.aysesenses.hepsiburada_case_study.network.ItunesProperty
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.time.format.DateTimeFormatter
import com.airbnb.lottie.LottieAnimationView
import com.aysesenses.hepsiburada_case_study.network.EBookProperty
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .transform(RoundedCorners(16))
            .into(imgView)
    }
}
@BindingAdapter("videoUrl")
fun bindVideo(videoView: VideoView, videoUrl: String?) {
        videoView.setVideoPath(videoUrl)
        videoView.requestFocus()
        videoView.start()

}
@BindingAdapter("rating")
fun bindRating(ratingBar: RatingBar, value: Float?) {
  if (value != null){
      ratingBar.visibility = View.VISIBLE
      ratingBar.rating = value
  }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ItunesProperty>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("bookData")
fun bindBooksRecyclerView(recyclerView: RecyclerView, data: List<EBookProperty>?) {
    val adapter = recyclerView.adapter as BooksGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("itunesApiStatus")
//fun bindStatus(statusImageView: ImageView, status: ItunesApiStatus?) {
fun bindStatus(lottieAnimationView: LottieAnimationView, status: ItunesApiStatus?) {
    when (status) {
        ItunesApiStatus.LOADING -> {
            lottieAnimationView.visibility = View.VISIBLE
            //statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ItunesApiStatus.ERROR -> {
            lottieAnimationView.visibility = View.VISIBLE
            //statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ItunesApiStatus.DONE -> {
            lottieAnimationView.visibility = View.GONE
        }
    }
}

@BindingAdapter("descriptionText")
fun setText(view: TextView, text: String?) {
    view.text = text?.let { newText ->
        HtmlCompat.fromHtml(
            newText, FROM_HTML_SEPARATOR_LINE_BREAK_DIV
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("realeseDate")
fun getFormattedDate(view: TextView, text: String?) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz")
    view.text = text?.let {
        val parsedDate = formatter.parse(it)
        val displayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM")
        displayFormatter.format(parsedDate).toString()
    }
}
