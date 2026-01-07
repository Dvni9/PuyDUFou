package com.example.puydufou.data.repository

import com.example.puydufou.R
import com.example.puydufou.data.model.Show

object DataGenerator {

    fun getSampleShows(): List<Show> {
        return listOf(
            Show(
                id = 1,
                name = "El Sueño de Toledo",
                description = "Espectáculo nocturno que narra 1500 años de historia de Toledo",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "22:00, 23:30",
                duration = "90 minutos",
                zone = "Zona Principal",
                latitude = 39.8628,
                longitude = -4.0273,
                accessibility = true,
                familyFriendly = true,
                language = "Español"
            ),
            Show(
                id = 2,
                name = "A Pluma y Espada",
                description = "Combates de esgrima y demostraciones ecuestres",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "12:00, 16:00, 18:00",
                duration = "45 minutos",
                zone = "Arena Central",
                latitude = 39.8630,
                longitude = -4.0265,
                accessibility = true,
                familyFriendly = true,
                language = "Español"
            ),
            Show(
                id = 3,
                name = "Cetrería Real",
                description = "Exhibición de aves rapaces en vuelo",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "11:00, 13:00, 17:00",
                duration = "30 minutos",
                zone = "Jardines Reales",
                latitude = 39.8615,
                longitude = -4.0280,
                accessibility = true,
                familyFriendly = true,
                language = "Español"
            ),
            Show(
                id = 4,
                name = "Allende la Mar Océana",
                description = "La aventura del descubrimiento de América",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "15:00, 19:00",
                duration = "60 minutos",
                zone = "Puerto",
                latitude = 39.8640,
                longitude = -4.0250,
                accessibility = true,
                familyFriendly = true,
                language = "Español"
            ),
            Show(
                id = 5,
                name = "El Último Cantar",
                description = "La leyenda del Cid Campeador",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "14:00, 20:00",
                duration = "75 minutos",
                zone = "Castillo",
                latitude = 39.8600,
                longitude = -4.0290,
                accessibility = false,
                familyFriendly = true,
                language = "Español"
            ),
            Show(
                id = 6,
                name = "Los Misterios del Císter",
                description = "Secretos de monasterios medievales",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "13:00, 17:30",
                duration = "50 minutos",
                zone = "Monasterio",
                latitude = 39.8635,
                longitude = -4.0260,
                accessibility = true,
                familyFriendly = false,
                language = "Español"
            ),
            Show(
                id = 7,
                name = "Toledo de Leyenda",
                description = "Leyendas toledanas contadas de forma teatral",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "21:00, 22:30",
                duration = "70 minutos",
                zone = "Casco Histórico",
                latitude = 39.8620,
                longitude = -4.0285,
                accessibility = true,
                familyFriendly = false,
                language = "Español"
            ),
            Show(
                id = 8,
                name = "El Vuelo del Águila",
                description = "Acrobacias aéreas y vuelo de aves rapaces",
                imageResId = R.drawable.ic_launcher_foreground,
                schedule = "12:30, 15:30, 18:30",
                duration = "40 minutos",
                zone = "Cañón",
                latitude = 39.8610,
                longitude = -4.0270,
                accessibility = false,
                familyFriendly = true,
                language = "Español"
            )
        )
    }
}