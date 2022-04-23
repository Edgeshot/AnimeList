package com.wnadeem.animelist

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator




class animeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var friend: Anime
    private val friendFirstNameTextView: TextView = itemView.findViewById(R.id.idTVanimeName)
    private val friendLastNameTextView: TextView = itemView.findViewById(R.id.idTVfriendName)
    private val friendNicknameTextView: TextView = itemView.findViewById(R.id.idTVcategory)
    private val friendCommentTextView: TextView = itemView.findViewById(R.id.idTVScore)
    private val friendPronouns: TextView = itemView.findViewById(R.id.idTVnotes)
    //private val animePicTitle: TextView = itemView.findViewById(R.id.animePicUrl)
    private var animePicture: ImageView = itemView.findViewById(R.id.imageView)
    private val picasso = Picasso.get()


    fun bind(friend: Anime) {


            this.friend = friend

            friendFirstNameTextView.text = friend.animeNameTitle
            friendLastNameTextView.text = friend.friendNameTitle
            friendNicknameTextView.text = friend.categoryTitle
            friendCommentTextView.text = friend.scoreTitle
            friendPronouns.text = friend.notes

        picasso.load("https://i.pinimg.com/originals/83/43/c3/8343c35bb352921f6871587e0f3c283e.jpg")
            .into(animePicture)
        }
    }

class AnimeAdapter : RecyclerView.Adapter<animeViewHolder>() {
    var anime: List<Anime> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): animeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.animerecyclerview, parent, false)
        return animeViewHolder(view)
    }

    override fun onBindViewHolder(holder: animeViewHolder, position: Int) {
        return holder.bind(anime[position])
    }

    override fun getItemCount() = anime.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateWords(newFriends: List<Anime>) {
        this.anime = newFriends
        notifyDataSetChanged()
    }


    fun getWordAtPosition(position: Int): Anime {
        return anime[position]
    }
}
