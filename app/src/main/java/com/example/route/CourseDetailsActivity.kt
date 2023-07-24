package com.example.route

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.text.Spannable
import android.text.SpannableString
import android.text.method.ScrollingMovementMethod
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity

import com.example.route.databinding.ActivityCourseDetailsBinding

class CourseDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCourseDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBar()
        setActivityContent()
    }

    private fun setActivityContent() {
        val course = intent.parcelable<Course>(Constants.COURSE)
        val image = when (course?.name) {
            Constants.ANDROID_COURSE -> R.drawable.android
            Constants.IOS_COURSE -> R.drawable.ios
            Constants.FULL_STACK_COURSE -> R.drawable.fullstack
            else -> R.color.colorAccent
        }
        binding.imgCourseHeader.setImageResource(image)
        binding.courseContentTv.text = course?.content
        binding.courseContentTv.movementMethod = ScrollingMovementMethod()

    }

    private fun setActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(resources.getColor(R.color.colorPrimaryDark))

        )
        val text = SpannableString(supportActionBar?.title)
        text.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.white)),
            0,
            text.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        supportActionBar?.title = text
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}
