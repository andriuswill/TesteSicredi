package com.andriuswill.testesicredi.presentantion.ui.eventDetail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.data.models.People
import kotlinx.android.synthetic.main.item_people.view.*

class PeopleAdapter :
    RecyclerView.Adapter<PeopleAdapter.PeopleVH>() {

    private val itens = arrayListOf<People>()

    fun updatePeople(people: List<People>) {
        itens.clear()
        itens.addAll(people)
        notifyDataSetChanged()
    }

    fun addPeople(people: People){
        itens.add(people)
        notifyItemInserted(itens.count() - 1)
        notifyItemRangeChanged(itens.count() - 1, itens.count())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleVH =
        PeopleVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_people,
                parent,
                false
            )
        )

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: PeopleVH, position: Int) {
        val currentPeople = itens[position]
        holder.bind(currentPeople)

    }

    inner class PeopleVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(people: People) = with(itemView) {
            text_name.text = people.name
        }
    }

}