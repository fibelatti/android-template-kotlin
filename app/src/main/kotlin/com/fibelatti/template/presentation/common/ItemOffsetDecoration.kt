package com.fibelatti.template.presentation.common

import android.content.Context
import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class ItemOffsetDecoration(private val itemOffset: Int) : RecyclerView.ItemDecoration() {

    constructor(context: Context, @DimenRes itemOffsetId: Int) : this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val layoutParams = view.layoutParams as GridLayoutManager.LayoutParams

        val position = layoutParams.viewLayoutPosition
        if (position == RecyclerView.NO_POSITION) {
            outRect.set(0, 0, 0, 0)
            return
        }

        // add edge margin only if item edge is not the grid edge
        val itemSpanIndex = layoutParams.spanIndex
        // is left grid edge?
        outRect.left = if (itemSpanIndex == 0) 0 else itemOffset
        // is top grid edge?
        outRect.top = if (itemSpanIndex == position) 0 else itemOffset
        outRect.right = 0
        outRect.bottom = 0
    }
}
