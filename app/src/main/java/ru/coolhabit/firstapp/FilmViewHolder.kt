package ru.coolhabit.firstapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.coolhabit.firstapp.databinding.FilmItemBinding



//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    val filmBinding = FilmItemBinding.bind(itemView)

    //Привязываем view из layout к переменным
    private val title = filmBinding.title
    private val poster = filmBinding.poster
    private val description = filmBinding.description
    //Вот здесь мы находим в верстке наш прогресс бар для рейтинга
    private val ratingDonut = filmBinding.ratingDonut


    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {


        //Устанавливаем заголовок
        filmBinding.title.text = film.title
        //Устанавливаем постер
        //Указываем контейнер, в котором будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(filmBinding.poster)
        //Устанавливаем описание
        filmBinding.description.text = film.description
        //Устанавливаем рейтинг
        filmBinding.ratingDonut.setProgress((film.rating * 10).toInt())
    }
}