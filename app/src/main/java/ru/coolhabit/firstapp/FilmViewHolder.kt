package ru.coolhabit.firstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import ru.coolhabit.firstapp.databinding.ActivityMainBinding
import ru.coolhabit.firstapp.databinding.FilmItemBinding
import ru.coolhabit.firstapp.databinding.FilmItemBinding.inflate


//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : ViewHolder(itemView) {

    val filmBinding = FilmItemBinding.bind(itemView)



    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {


        //Устанавливаем заголовок
        filmBinding.title.text = film.title
        //Устанавливаем постер
        filmBinding.poster.setImageResource(film.poster)
        //Устанавливаем описание
        filmBinding.description.text = film.description
    }
}