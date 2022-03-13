//package com.example.superstoreapp.ui
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.elabasy.ubereatsr.Interface.OnItemRecyclerViewClickListener
//import com.example.superstoreapp.DataTesttt
//import com.example.superstoreapp.R
//
//import kotlin.collections.ArrayList
//
//class CategoryRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private var list = ArrayList<DataTesttt>()
//    private val ITEM = 0
//    private val LOADING = 1
//    private var isLoaderVisible = false
//    private var context: Context? = null
//    private var img_url: String? = null
//    private lateinit var clickListener: OnItemRecyclerViewClickListener
//
//    constructor(list: ArrayList<DataTesttt>? = null, context: Context? = null) {
//        if (list != null) {
//            this.list = ArrayList<DataTesttt>(list)
//        }
//        this.context = context
//        notifyDataSetChanged()
//    }
//
//    fun setList(list: ArrayList<DataTesttt>) {
//        this.list.addAll(list)
//        notifyDataSetChanged()
//    }
//
//    // to mack OnClickListener from activity
//    fun setOnItemClick(recyclerViewOnItemClick: OnItemRecyclerViewClickListener) {
//        clickListener = recyclerViewOnItemClick
//        notifyDataSetChanged()
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var viewHolder: RecyclerView.ViewHolder? = null
//        val inflater = LayoutInflater.from(parent.context)
//        when (viewType) {
//            ITEM -> viewHolder = getViewHolder(parent, inflater)
//            LOADING -> {
//                val v2: View = inflater.inflate(R.layout.item_loading, parent, false)
//                viewHolder = LoadingVH(v2)
//            }
//        }
//        return viewHolder!!
//    }
//
//    private fun getViewHolder(
//        parent: ViewGroup, inflater: LayoutInflater
//    ): RecyclerView.ViewHolder {
//        val viewHolder: RecyclerView.ViewHolder
//        val binding: ItemCategoryRecyclerViewBinding =
//            ItemCategoryRecyclerViewBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        viewHolder = ItemHolder(binding)
//        return viewHolder
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onBindViewHolder(ViewHolder: RecyclerView.ViewHolder, position: Int) {
//        val data = list[position]
//        when (getItemViewType(position)) {
//            ITEM -> {
//                val holder = ViewHolder as ItemHolder
//
//
//                holder.binding.categoryImage.setOnClickListener {
//                    clickListener.setOnItemClickListener(position)
//                }
//
////                holder.binding.notificationTv.setText(data.getBody())
////                holder.binding.notificationDate.setText(data.getDate())
////                holder.binding.notificationId.setText("#" + data.getResourceId().toString())
////                if (data.getPhoto() != null) {
////                    if (data.getPhoto().contains("https://")) {
////                        img_url = data.getPhoto()
////                    } else {
////                        img_url = Common.IMG_URL + data.getPhoto()
////                    }
////                }
////                Glide.with(context).load(img_url).placeholder(R.drawable.ic_sonqr_home_logo)
////                    .into(holder.binding.notificationImg)
////                holder.itemView.setOnClickListener { v: View? ->
////                    clickListener.onClickAdapter(position, data.getIsRead(), data.getId())
////                    if (data.getId() !== data.getResourceId()) {
////                        context!!.startActivity(Intent(context, OrderActivity::class.java))
////                    }
////                    Common.notification_id = data.getResourceId()
////                }
////
//
//                //for change time format
////                val givenDateString: String = data.getDate()
////                @SuppressLint("SimpleDateFormat") val sdf =
////                    SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
////                try {
////                    val mDate = sdf.parse(givenDateString)
////                    val timeInMilliseconds = mDate.time
////                    val now = System.currentTimeMillis()
////                    val formatter: DateFormat = SimpleDateFormat("hh:mm a", Locale.US)
////                    val text = formatter.format(Date(timeInMilliseconds + 1000 * 60 * 60 * 2))
////                    val ago = DateUtils.getRelativeTimeSpanString(
////                        timeInMilliseconds + 1000 * 60 * 60 * 2,
////                        now,
////                        DateUtils.MINUTE_IN_MILLIS
////                    )
////                    holder.binding.notificationDate.setText("$ago-$text")
////                } catch (e: ParseException) {
////                    e.printStackTrace()
////                }
//            }
//            LOADING -> {
//            }
//        }
//    }
//
//
//    override fun getItemCount(): Int {
//        return if (list != null) list.size else 0
//    }
//
//    internal class ItemHolder(itemView: ItemCategoryRecyclerViewBinding) :
//        RecyclerView.ViewHolder(itemView.root) {
//        val binding: ItemCategoryRecyclerViewBinding = itemView
//    }
//
//    class LoadingVH(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
//
//    override fun getItemViewType(position: Int): Int {
//        return if (position == list.size - 1 && isLoaderVisible) LOADING else ITEM
//    }
//
//
//    fun addLoadingFooter() {
//        isLoaderVisible = true
//        add(DataTesttt("0"))
//    }
//
//    fun removeLoadingFooter() {
//        isLoaderVisible = false
//        val position: Int = list.size - 1
//        val item = getItem(position)
//        if (item != null) {
//            list.removeAt(position)
//            notifyItemRemoved(position)
//        }
//    }
//
//    fun add(data: DataTesttt) {
//        list.add(data)
//        notifyItemInserted(list.size - 1)
//    }
//
//    fun getItem(position: Int): DataTesttt? {
//        return list[position]
//    }
//
//
//    fun addAll(mcList: ArrayList<DataTesttt>) {
//        for (mc in mcList) {
//            add(mc)
//        }
//    }
//
//
//    fun remove(notifications: DataTesttt) {
//        val position = list.indexOf(notifications)
//        if (position > -1) {
//            list.removeAt(position)
//            notifyItemRemoved(position)
//        }
//    }
//
//    fun clear() {
//        isLoaderVisible = false
//        list.clear()
//        while (itemCount > 0) {
//            getItem(0)?.let { remove(it) }
//            notifyDataSetChanged()
//        }
//        notifyDataSetChanged()
//    }
//
//
//}
//
//
