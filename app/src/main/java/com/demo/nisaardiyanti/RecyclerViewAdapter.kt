package com.demo.nisaardiyanti
//nama packages
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.nisaardiyanti.db.UserEntity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(val listener: RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
//kelas RecyclerViewAdapter
    var items  = ArrayList<UserEntity>()

    fun setListData(data: ArrayList<UserEntity>) {
        this.items = data
    }
//untuk membuat daftar array pada userentity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
       val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])

    }



    class MyViewHolder(view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view) {
//class MyViewHolder dengan berisi val tvName view.Name,view.tvMail,view.tvPhone,view.deleteUserID
        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val tvPhone = view.tvPhone
        val deleteUserID = view.deleteUserID

         //Data binding dengan berisi data.name,data.email,data.phone
        fun bind(data: UserEntity) {
            tvName.text = data.name

            tvEmail.text = data.email


            tvPhone.text = data.phone

            deleteUserID.setOnClickListener {
                listener.onDeleteUserClickListener(data)
            }
                //Listener merupakan kelas abstrak atau antarmuka yang digunakan untuk
            // menyediakan fungsionalitas untuk komponen UI yang dapat berinteraksi.
                //pada kode diatas delete akan dapat berfungsi karena sudah diset On Click
        }
    }

    interface RowClickListener{
        fun onDeleteUserClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)
    }
}
