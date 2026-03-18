package com.example.kotlin01

import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.events.MapListener
import org.osmdroid.events.ScrollEvent
import org.osmdroid.events.ZoomEvent
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class Map : AppCompatActivity(), MapListener, LocationListener {

    private lateinit var mMap: MapView
    private lateinit var controller: IMapController
    private lateinit var mMyLocationOverlay: MyLocationNewOverlay
    private val targetZoomLevel = 16.0
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuração osmdroid
        Configuration.getInstance().load(applicationContext, getSharedPreferences("osm", MODE_PRIVATE))
        setContentView(R.layout.activity_map)

        // Layout Edge-to-Edge
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar MapView
        mMap = findViewById(R.id.map)
        mMap.setMultiTouchControls(true)
        controller = mMap.controller
        controller.setZoom(targetZoomLevel)

        // Overlay de localização
        mMyLocationOverlay = MyLocationNewOverlay(mMap)
        mMap.overlays.add(mMyLocationOverlay)

        // Verificar permissões
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != android.content.pm.PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != android.content.pm.PackageManager.PERMISSION_GRANTED) {

            requestPermissions(
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            ativarLocalizacao()
        }
    }

    private fun ativarLocalizacao() {
        mMyLocationOverlay.enableMyLocation()
        mMyLocationOverlay.runOnFirstFix {
            val usuario = mMyLocationOverlay.myLocation ?: GeoPoint(-23.5505, -46.6333) // fallback
            runOnUiThread {
                controller.setCenter(usuario) // Agora é seguro
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            ativarLocalizacao()
        }
    }

    // --- Métodos obrigatórios MapListener ---
    override fun onScroll(p0: ScrollEvent?): Boolean = true
    override fun onZoom(p0: ZoomEvent?): Boolean = true

    // --- Métodos obrigatórios LocationListener ---
    override fun onLocationChanged(location: Location) {}
    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
    override fun onProviderEnabled(provider: String) {}
    override fun onProviderDisabled(provider: String) {}
}