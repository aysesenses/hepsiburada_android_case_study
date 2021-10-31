package com.aysesenses.hepsiburada_case_study.ui.main.adapter

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
import com.aysesenses.hepsiburada_case_study.data.api.ItunesApiStatus
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.time.format.DateTimeFormatter
import com.aysesenses.hepsiburada_case_study.data.model.ebook.EBookProperty
import com.aysesenses.hepsiburada_case_study.data.model.app.AppProperty
import com.aysesenses.hepsiburada_case_study.data.model.movie.MovieProperty
import com.aysesenses.hepsiburada_case_study.data.model.music.MusicProperty
import com.aysesenses.hepsiburada_case_study.data.model.podcast.PodcastProperty
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime

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

@BindingAdapter("rating")
fun bindRating(ratingBar: RatingBar, value: Float?) {
  if (value != null){
      ratingBar.visibility = View.VISIBLE
      ratingBar.rating = value
  }
}

@BindingAdapter("listOverviewMusic")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MusicProperty>?) {
    val adapter = recyclerView.adapter as OverviewMusicAdapter
    adapter.submitList(data)
}
@BindingAdapter("listPodcast")
fun bindPodcastRecyclerView(recyclerView: RecyclerView, data: List<PodcastProperty>?) {
    val adapter = recyclerView.adapter as PodcastAdapter
    adapter.submitList(data)
}

@BindingAdapter("listBook")
fun bindBooksRecyclerView(recyclerView: RecyclerView, data: List<EBookProperty>?) {
    val adapter = recyclerView.adapter as BooksGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("listMusic")
fun bindMusicRecyclerView(recyclerView: RecyclerView, data: List<MusicProperty>?) {
    val adapter = recyclerView.adapter as MusicAdapter
    adapter.submitList(data)
}
@BindingAdapter("listApp")
fun bindAppRecyclerView(recyclerView: RecyclerView, data: List<AppProperty>?) {
    val adapter = recyclerView.adapter as AppAdapter
    adapter.submitList(data)
}
@BindingAdapter("listMovie")
fun bindMovieRecyclerView(recyclerView: RecyclerView, data: List<MovieProperty>?) {
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}


@BindingAdapter("itunesApiStatus")
fun bindStatus(statusImageView: ImageView, status: ItunesApiStatus?) {
    when (status) {
        ItunesApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ItunesApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ItunesApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
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
        val displayFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd ")
        displayFormatter.format(parsedDate).toString()
    }
}
@ExperimentalTime
@BindingAdapter("time")
fun getFormattedTimeMillis(view: TextView, text: String?) {
    val times = text?.toLong().let {
        it?.let {
                it1 -> TimeUnit.MILLISECONDS.toMinutes(it1 )
        }
    }.toString()
    (times + "dk").also { view.text = it }
}
@BindingAdapter("price")
fun setStringPrice(view: TextView, text: String?) {
  view.text = text?.let {
      "$$it"
  }
}



