package ru.coolhabit.firstapp

import TopSpacingItemDecoration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.coolhabit.firstapp.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {
    private var bindingHome: FragmentHomeBinding? = null

    private val binding get() = bindingHome!!

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
        Film("Dune", R.drawable.poster1, "Feature adaptation of Frank Herbert's science " +
                "fiction novel, about the son of a noble family entrusted with the protection of the most valuable asset and most vital element in the galaxy.", 8.1f),
        Film("Interstellar", R.drawable.poster4, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
            , 9.2f),
        Film("Pulp Fiction", R.drawable.pulp, "The lives of two mob hitmen, a boxer, a gangster and his " +
                "wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",  7.8f),
        Film("Jurassic Park", R.drawable.jurassic, "A pragmatic paleontologist touring an almost complete theme park on an island in Central America " +
                "is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose.", 7.5f),
        Film("Thor: Ragnarok", R.drawable.poster2, "Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnarök, the " +
                "destruction of his world, at the hands of the powerful and ruthless villain Hela.", 7.7f)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHome = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)

        bindingHome?.searchView?.setOnClickListener {
            bindingHome?.searchView?.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        bindingHome?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запрос, и имя фильма приводить к нижнему регистру
                    it.title.lowercase(Locale.getDefault()).contains(newText.lowercase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })

        //находим наш RV
        bindingHome?.mainRecycler?.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    override fun onDestroyView() {
        bindingHome = null
        super.onDestroyView()
    }
}