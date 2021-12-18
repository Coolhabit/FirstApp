package ru.coolhabit.firstapp

class FilmDB {
    companion object {
        val filmDataBase: List<Film> = listOf(
            Film("Dune", R.drawable.poster1,
                "Feature adaptation of Frank Herbert's science " +
                        "fiction novel, about the son of a noble family entrusted with the protection of the most valuable" +
                        " asset and most vital element in the galaxy.", 8.1f),
            Film("Interstellar", R.drawable.poster4,
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's" +
                        " survival.", 9.2f)
        )
    }

}