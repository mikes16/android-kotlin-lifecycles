/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikelop.android.kotlin.lifecycles.step4

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mikelop.android.kotlin.lifecycles.R
import kotlinx.android.synthetic.main.location_activity.*

class LocationActivity:AppCompatActivity(){

    val REQUEST_LOCATION_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_activity)

        setupPermissions()
    }

    private fun setupPermissions() {
        val isFineLocationEnabled = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        val isCoarseLocationEnabled = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED

        if (isFineLocationEnabled && isCoarseLocationEnabled) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION),
                    REQUEST_LOCATION_PERMISSION_CODE)
        }else{
            bindLocationListener()
        }
    }

    private fun bindLocationListener(){
        BoundLocationManager.bindLocationListenerIn(this, MyLocationListener(), applicationContext)
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_LOCATION_PERMISSION_CODE -> {
                if (grantResults.isEmpty() ||
                    grantResults[0] != PackageManager.PERMISSION_GRANTED ||
                    grantResults[1] != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "This sample requires Location access",
                            Toast.LENGTH_LONG).show()
                }else{
                    bindLocationListener()
                }
            }
        }
    }

    private inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            location_text.text = String.format(resources.getString(R.string.latlon),
                    location.latitude, location.longitude)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {
            Toast.makeText(this@LocationActivity,
                    "Provider enabled: $provider", Toast.LENGTH_SHORT).show()
        }

        override fun onProviderDisabled(provider: String) {}
    }
}