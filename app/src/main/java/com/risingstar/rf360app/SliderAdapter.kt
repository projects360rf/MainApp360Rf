package com.risingstar.rf360app
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.risingstar.rf360app.model.SliderData
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(context: Context,var sliderDataList : ArrayList<SliderData>) : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(view : View) : SliderViewAdapter.ViewHolder(view){

        val imgSlider : ImageView = view.findViewById(R.id.imgSlider)
    }

    override fun getCount(): Int {
        return sliderDataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view : View = LayoutInflater.from(parent?.context).inflate(R.layout.sliderlayout,parent,false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        val sliderItem = sliderDataList[position]
        if (viewHolder != null) {
//            Glide.with(viewHolder.itemView)
//                .load(sliderItem.imgUrl)
//                .fitCenter()
//                .into(viewHolder.imgSlider)

            viewHolder.imgSlider.setImageResource(sliderItem.imgUrl)
        }
    }
}


//class SliderAdapter(context: Context?, sliderDataArrayList: ArrayList<SliderData>) :
//    SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder>() {
//    // list for storing urls of images.
//    private val mSliderItems: List<SliderData>
//
//    // We are inflating the slider_layout
//    // inside on Create View Holder method.
//    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapter.SliderAdapterViewHolder {
//        val inflate: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.slider_layout, null)
//        return SliderAdapter.SliderAdapterViewHolder(inflate)
//    }
//
//    // Inside on bind view holder we will
//    // set data to item of Slider View.
//    override fun onBindViewHolder(
//        viewHolder: SliderAdapter.SliderAdapterViewHolder,
//        position: Int
//    ) {
//        val sliderItem: SliderData = mSliderItems[position]
//
//        // Glide is use to load image
//        // from url in your imageview.
//        Glide.with(viewHolder.itemView)
//            .load(sliderItem.getImgUrl())
//            .fitCenter()
//            .into(viewHolder.imageViewBackground)
//    }
//
//    // this method will return
//    // the count of our list.
//    override fun getCount(): Int {
//        return mSliderItems.size
//    }
//
//    internal class SliderAdapterViewHolder(itemView: View) :
//        ViewHolder(itemView) {
//        // Adapter class for initializing
//        // the views of our slider view.
//        lateinit var itemView: View
//        var imageViewBackground: ImageView
//
//        init {
//            imageViewBackground = itemView.findViewById(R.id.myimage)
//            this.itemView = itemView
//        }
//    }
//
//    // Constructor
//    init {
//        mSliderItems = sliderDataArrayList
//    }
//}
