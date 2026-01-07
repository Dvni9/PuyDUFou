package com.example.puydufou.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.puydufou.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Versión WebView que NO se cierra
        showMapWithWebView()
    }

    private fun showMapWithWebView() {
        val webView = WebView(requireContext())
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true

        // HTML con Google Maps embebido (usa API Key pública de prueba)
        val htmlContent = """
            <!DOCTYPE html>
            <html>
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <style>
                    body, html { margin: 0; padding: 0; height: 100%; }
                    #map { height: 100%; width: 100%; }
                </style>
            </head>
            <body>
                <div id="map"></div>
                <script>
                    function initMap() {
                        // Ubicación de Puy du Fou España
                        var puyDuFou = {lat: 39.8628, lng: -4.0273};
                        var map = new google.maps.Map(document.getElementById('map'), {
                            zoom: 15,
                            center: puyDuFou,
                            mapTypeId: 'hybrid'
                        });
                        
                        // Marcadores de los espectáculos
                        var markers = [
                            {lat: 39.8628, lng: -4.0273, title: 'El Sueño de Toledo', info: 'Espectáculo nocturno principal'},
                            {lat: 39.8630, lng: -4.0265, title: 'A Pluma y Espada', info: 'Combates de esgrima'},
                            {lat: 39.8615, lng: -4.0280, title: 'Cetrería Real', info: 'Exhibición de aves rapaces'},
                            {lat: 39.8640, lng: -4.0250, title: 'Allende la Mar Océana', info: 'Descubrimiento de América'},
                            {lat: 39.8600, lng: -4.0290, title: 'El Último Cantar', info: 'Leyenda del Cid'},
                            {lat: 39.8635, lng: -4.0260, title: 'Los Misterios del Císter', info: 'Secretos medievales'},
                            {lat: 39.8620, lng: -4.0285, title: 'Toledo de Leyenda', info: 'Leyendas toledanas'},
                            {lat: 39.8610, lng: -4.0270, title: 'El Vuelo del Águila', info: 'Acrobacias aéreas'}
                        ];
                        
                        markers.forEach(function(marker) {
                            var markerObj = new google.maps.Marker({
                                position: {lat: marker.lat, lng: marker.lng},
                                map: map,
                                title: marker.title
                            });
                            
                            var infowindow = new google.maps.InfoWindow({
                                content: '<h3>' + marker.title + '</h3><p>' + marker.info + '</p>'
                            });
                            
                            markerObj.addListener('click', function() {
                                infowindow.open(map, markerObj);
                            });
                        });
                    }
                </script>
                <script async defer 
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB0VqZ8epJzLjgN0P2p8vXeFqJ3Q4u6N7w&callback=initMap&libraries=places">
                </script>
            </body>
            </html>
        """.trimIndent()

        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null)

        // Añadir el WebView al layout
        (binding.root as ViewGroup).removeAllViews()
        (binding.root as ViewGroup).addView(webView)

        // Mostrar mensaje informativo
        Toast.makeText(context, "Mapa interactivo de Puy du Fou cargado", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}