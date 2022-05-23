package com.penatabahasa.myselfapps.ui.main.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import com.mapbox.geojson.Point
import com.mapbox.maps.*
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager
import com.penatabahasa.myselfapps.R
import com.penatabahasa.myselfapps.databinding.FragmentProfileBinding

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialogVersion()
        contactIntent()
        mapViewFindMe()
    }

    private fun mapViewFindMe() {
        binding.apply {
            mvFindMe.getMapboxMap().loadStyleUri(
                Style.MAPBOX_STREETS
            ) { addAnnotationToMap() }
        }
    }

    private fun addAnnotationToMap() {
        binding.apply {
            bitmapFromDrawableRes(
                requireActivity(),
                R.drawable.ic_location_marker
            )?.let {
                val annotationApi = mvFindMe.annotations
                val pointAnnotationManager = annotationApi.createPointAnnotationManager()
                val pointAnnotationOptions: PointAnnotationOptions = PointAnnotationOptions()
                    .withPoint(Point.fromLngLat(107.61591239816846, -6.878968125445695))
                    .withIconImage(it)
                pointAnnotationManager.create(pointAnnotationOptions)
            }
        }
    }

    private fun bitmapFromDrawableRes(context: Context, @DrawableRes resourceId: Int) =
        convertDrawableToBitmap(AppCompatResources.getDrawable(context, resourceId))

    private fun convertDrawableToBitmap(sourceDrawable: Drawable?): Bitmap? {
        if (sourceDrawable == null) {
            return null
        }
        return if (sourceDrawable is BitmapDrawable) {
            sourceDrawable.bitmap
        } else {
            val constantState = sourceDrawable.constantState ?: return null
            val drawable = constantState.newDrawable().mutate()
            val bitmap: Bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth, drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            bitmap
        }
    }

    private fun contactIntent() {
        binding.apply {
            ivProfileTelephone.setOnClickListener {
                val phoneNumber = "081221724455"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            ivEmail.setOnClickListener {
                val intentEmail = Intent()
                intentEmail.action = Intent.ACTION_VIEW
                intentEmail.addCategory(Intent.CATEGORY_BROWSABLE)
                intentEmail.data = Uri.parse("mailto:mjafarshidik86@gmail.com")
                startActivity(intentEmail)
            }

            ivLinkedIn.setOnClickListener {
                val intentLinkedIn = Intent()
                intentLinkedIn.action = Intent.ACTION_VIEW
                intentLinkedIn.addCategory(Intent.CATEGORY_BROWSABLE)
                intentLinkedIn.data = Uri.parse("https://www.linkedin.com/in/mjafarshidik/")
                startActivity(intentLinkedIn)
            }

            ivGithub.setOnClickListener {
                val intentGithub = Intent()
                intentGithub.action = Intent.ACTION_VIEW
                intentGithub.addCategory(Intent.CATEGORY_BROWSABLE)
                intentGithub.data = Uri.parse("https://github.com/mjafarshidik")
                startActivity(intentGithub)
            }

            ivInstagram.setOnClickListener {
                val intentInstagram = Intent()
                intentInstagram.action = Intent.ACTION_VIEW
                intentInstagram.addCategory(Intent.CATEGORY_BROWSABLE)
                intentInstagram.data = Uri.parse("https://www.instagram.com/mjafarshidik_/")
                startActivity(intentInstagram)
            }
        }
    }

    private fun showDialogVersion() {
        binding.apply {
            btnAlertDialog.setOnClickListener {
                val builder = AlertDialog.Builder(requireActivity(), R.style.CustomAlertDialog)
                    .create()
                val view = layoutInflater.inflate(R.layout.version_alert_dialog, null)
                val button = view.findViewById<Button>(R.id.btnClose)
                builder.setView(view)
                button.setOnClickListener {
                    builder.dismiss()
                }
                builder.setCanceledOnTouchOutside(false)
                builder.show()
            }
        }
    }

    @SuppressLint("Lifecycle")
    override fun onStart() {
        super.onStart()
        binding.apply {
            mvFindMe.onStart()
        }
    }

    @SuppressLint("Lifecycle")
    override fun onStop() {
        super.onStop()
        binding.apply {
            mvFindMe.onStop()
        }
    }

    @SuppressLint("Lifecycle")
    override fun onLowMemory() {
        super.onLowMemory()
        binding.apply {
            mvFindMe.onLowMemory()
        }
    }

    @SuppressLint("Lifecycle")
    override fun onDestroy() {
        super.onDestroy()
        binding.apply {
            mvFindMe.onDestroy()
        }
    }
}