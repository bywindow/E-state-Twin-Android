package com.idiot.threeviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.view.View
import android.widget.TextView

class ViewerActivity : AppCompatActivity() {

    var surfaceView: SurfaceView? = null
    var customViewer: CustomViewer = CustomViewer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        val title = intent.getStringExtra("title")
        val titleTextView: TextView = findViewById(R.id.toolbar_title_text)
        titleTextView.text = title.toString()

        surfaceView = findViewById<View>(R.id.surface_view) as SurfaceView
        customViewer.run {
            loadEntity()
            setSurfaceView(requireNotNull(surfaceView))

            //directory and model each as param
            loadGlb(this@ViewerActivity, "grogu", "floorplan_test")
//            loadGltf(this@MainActivity, "warcraft", "scene");

            //directory and model as one
            //loadGlb(this@MainActivity, "grogu/grogu");

            //Enviroments and Lightning (OPTIONAL)
//            loadIndirectLight(this@ViewerActivity, "venetian_crossroads_2k")
//            loadEnviroment(this@MainActivity, "venetian_crossroads_2k");
        }
    }

    override fun onResume() {
        super.onResume()
        customViewer.onResume()
    }

    override fun onPause() {
        super.onPause()
        customViewer.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        customViewer.onDestroy()
    }
}