package ru.coolhabit.firstapp.data

import ru.coolhabit.firstapp.domain.Film
import ru.coolhabit.firstapp.R

class MainRepository {
    companion object {
        val filmsDataBase: List<Film> = listOf(
            Film(
                "Dune",
                R.drawable.poster1,
                "Feature adaptation of Frank Herbert's science " +
                        "fiction novel, about the son of a noble family entrusted with the protection of the most valuable asset and most vital element in the galaxy.",
                8.1f
            ),
            Film(
                "Interstellar",
                R.drawable.poster4,
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                9.2f
            ),
            Film(
                "Pulp Fiction",
                R.drawable.pulp,
                "The lives of two mob hitmen, a boxer, a gangster and his " +
                        "wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                7.8f
            ),
            Film(
                "Jurassic Park",
                R.drawable.jurassic,
                "A pragmatic paleontologist touring an almost complete theme park on an island in Central America " +
                        "is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose.",
                7.5f
            ),
            Film(
                "Thor: Ragnarok",
                R.drawable.poster2,
                "Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnarök, the " +
                        "destruction of his world, at the hands of the powerful and ruthless villain Hela.",
                7.6f
            ),
            Film(
                "Lord of the Rings: The Fellowship of the Ring",
                R.drawable.lotr_1,
                "A meek Hobbit from the Shire and eight companions set out on a journey " +
                        "to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                9.9f
            ),
            Film(
                "Harry Potter and the Prisoner of Azkaban",
                R.drawable.azkaban,
                "Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and " +
                        "Wizardry for their third year of study, where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young " +
                        "wizard.",
                8.1f
            ),
            Film(
                "Dark Knight",
                R.drawable.dark_knight,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must " +
                        "accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                8.9f
            )
        )
    }
}
