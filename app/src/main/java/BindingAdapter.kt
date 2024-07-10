import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class BindingAdapter {
    companion object {
        @BindingAdapter("app:url")
        @JvmStatic
        fun bindImage(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .into(imageView)
        }

    }
}