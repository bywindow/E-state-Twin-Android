package com.idiot.more.binding

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.HouseOption

object RecyclerViewBinding {
  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<HouseOption, *>, itemList: List<HouseOption>) {
    view.adapter = adapter
    adapter.submitList(itemList.toMutableList())
  }

  @JvmStatic
  @BindingAdapter("assetAdapter", "submitAssetList")
  fun bindAssetAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }

  @JvmStatic
  @BindingAdapter(
    value = ["dividerHeight", "dividerPadding", "dividerColor"],
    requireAll = false
  )
  fun RecyclerView.setDivider(dividerHeight: Float?, dividerPadding: Float?, @ColorInt dividerColor: Int?) {
    val decoration = CustomDecoration(
      height = dividerHeight ?: 1.0f,
      padding = dividerPadding ?: 10.0f,
      color = dividerColor ?: Color.TRANSPARENT
    )
    addItemDecoration(decoration)
  }

  class CustomDecoration(
    private val height: Float,
    private val padding: Float,
    @ColorInt private val color: Int
  ) : RecyclerView.ItemDecoration() {
    private val paint = Paint()

    init {
        paint.color = color
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
      val left = parent.paddingStart + padding
      val right = parent.width - parent.paddingEnd - padding
      for (i in 0 until parent.childCount) {
        val child = parent.getChildAt(i)
        val params = child.layoutParams as RecyclerView.LayoutParams
        val top = (child.bottom + params.bottomMargin).toFloat()
        val bottom = top + height
        c.drawRect(left, top, right, bottom, paint)
      }
    }
  }
}