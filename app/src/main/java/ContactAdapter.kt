package com.example.kontaku

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private var contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvItemName)
        val tvPhone: TextView = view.findViewById(R.id.tvItemPhone)
        val btnCall: ImageView = view.findViewById(R.id.btnCall) // Ambil ID ikon telepon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.tvName.text = currentContact.name
        holder.tvPhone.text = currentContact.phone

        // LOGIKA KLIK TOMBOL TELEPON
        holder.btnCall.setOnClickListener {
            val phoneNumber = currentContact.phone

            // Membuat Intent untuk membuka aplikasi Dial/Telepon
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }

            // Menjalankan Intent
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = contacts.size

    fun updateData(newContacts: List<Contact>) {
        this.contacts = newContacts
        notifyDataSetChanged()
    }
}