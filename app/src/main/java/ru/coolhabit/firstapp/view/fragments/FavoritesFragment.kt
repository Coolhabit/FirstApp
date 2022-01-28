package ru.coolhabit.firstapp.view.fragments

import ru.coolhabit.firstapp.view.rv_adapters.TopSpacingItemDecoration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.coolhabit.firstapp.view.rv_adapters.FilmListRecyclerAdapter
import ru.coolhabit.firstapp.databinding.FragmentFavoritesBinding
import ru.coolhabit.firstapp.domain.Film
import ru.coolhabit.firstapp.utils.AnimationHelper
import ru.coolhabit.firstapp.view.MainActivity
import ru.coolhabit.firstapp.viewmodel.FavoritesFragmentViewModel

class FavoritesFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(FavoritesFragmentViewModel::class.java)
    }

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.favoritesFragmentRoot, requireActivity(), 1)

        initRecycler()

        viewModel.filmsListLiveData.observe(viewLifecycleOwner) {
            filmsAdapter.addItems(it.filter { it.isInFavorites })
        }
    }

    private fun initRecycler() {
        binding.favoritesRecycler.apply {
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
    }
}