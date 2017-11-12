package ru.annin.penzgtulesson04.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.annin.penzgtulesson04.R
import ru.annin.penzgtulesson04.mvp.model.Language

/**
 * Adapter списка "Языков программирования".
 *
 * @author Pavel Annin.
 */
class LanguageAdapter(private val items: MutableList<Language> = mutableListOf(),
                      var onItemClick: ((Language) -> Unit)? = null) : RecyclerView.Adapter<LanguageAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val vRoot = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent, false)
        return ItemViewHolder(vRoot)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        items[position].let { item ->
            holder.setup {
                onClick = { onItemClick?.invoke(item) }
                bindToData(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun swap(newItem: List<Language>) {
        items.clear()
        items.addAll(newItem)
    }

    class ItemViewHolder(private val vRoot: View) : RecyclerView.ViewHolder(vRoot) {

        // View's
        private val ivLogo by lazy { vRoot.findViewById<ImageView>(R.id.iv_logo) }
        private val txtTitle by lazy { vRoot.findViewById<TextView>(R.id.txt_title) }

        // Listener's
        var onClick: (() -> Unit)? = null

        fun setup(block: ItemViewHolder.() -> Unit) {
            block()
            vRoot.setOnClickListener { onClick?.invoke() }
        }

        fun bindToData(data: Language) {
            txtTitle.text = data.name
            Glide.with(vRoot)
                    .load(data.logo)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivLogo)
        }
    }
}
