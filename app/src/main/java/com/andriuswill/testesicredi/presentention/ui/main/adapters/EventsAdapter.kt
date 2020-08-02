package com.andriuswill.testesicredi.presentention.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.domain.extensions.gone
import com.andriuswill.testesicredi.domain.extensions.show
import com.andriuswill.testesicredi.domain.listener.EventClickListener
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_event.view.*

class EventsAdapter(private val listener: EventClickListener) :
    RecyclerView.Adapter<EventsAdapter.EventVH>() {

    private val itens = arrayListOf<Event>()

    fun updateEvents(events: List<Event>) {
        itens.clear()
        itens.addAll(events)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventVH =
        EventVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_event,
                parent,
                false
            )
        )

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: EventVH, position: Int) {
        val currentEvent = itens[position]
        holder.bind(currentEvent)
        holder.itemView.setOnClickListener {
            listener.onEventClicked(
                currentEvent.id
            )
        }
    }

    inner class EventVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(event: Event) = with(itemView) {
            Picasso.get().load(event.image).fit().centerCrop().into(img_picture)
            Picasso.get()
                .load(event.image)
                .fit()
                .centerCrop()
                .into(img_picture, object : Callback {
                    override fun onSuccess() {
                        text_title.gone()
                    }
                    override fun onError(e: Exception) {
                        text_title.text = event.title
                        text_title.show()
                    }
                })
        }
    }

}