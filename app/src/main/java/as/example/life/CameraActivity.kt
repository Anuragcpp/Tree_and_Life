package `as`.example.life

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.io.IOException

class CameraActivity : AppCompatActivity() {
    private lateinit var mCatergorization: Catergorization
    private lateinit var mBitmap: Bitmap
    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2
    private lateinit var mCameraBtn: AppCompatButton
    private lateinit var mGalleryBtn: AppCompatButton
    private lateinit var mDetectBtn: AppCompatButton
    private lateinit var mDiseaseTxt: TextView
    private lateinit var mPhotoImage: ImageView


    private val mInputSize = 224
    private val mModelPath = "plant_disease_model.tflite"
    private val mLabelPath = "plant_labels.txt"

    private val mSamplePath = "automn.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        mCatergorization = Catergorization(assets,mModelPath,mLabelPath,mInputSize)

        mCameraBtn = findViewById(R.id.mCameraButton)
        mGalleryBtn = findViewById(R.id.mGalleryButton)
        mDetectBtn = findViewById(R.id.mDetectionButton)
        mDiseaseTxt = findViewById(R.id.mResultTextView)
        mPhotoImage = findViewById(R.id.mPhotoImageView)

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap,mInputSize,mInputSize,true)
        }

        mCameraBtn.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent,mGalleryRequestCode)
        }
        mDetectBtn.setOnClickListener {
            val progressDialog = ProgressDialog(this@CameraActivity)
            progressDialog.setTitle("Please Wait")
            progressDialog.setMessage("wait there I do something...")
            progressDialog.show()
            val handler = Handler()
            handler.postDelayed(Runnable { progressDialog.dismiss()
                val results = mCatergorization.recognizeImage(mBitmap).firstOrNull()
                mDiseaseTxt.text = results?.title+ "\n Confidence"+ results?.confidence
            },2000)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mCameraRequestCode){
            if (requestCode == Activity.RESULT_OK && data!=null){
                mBitmap = data.extras!!.get("data") as Bitmap
                //   mBitmap = scaleImage(mBitmap)
                mPhotoImage.setImageBitmap(mBitmap)
                mDiseaseTxt.text = "your photo image set now"
            }
            else{
                Toast.makeText(this,"Camer cancel ..", Toast.LENGTH_SHORT).show()
            }
        }
        else if (requestCode == mGalleryRequestCode){
            if (data!=null){
                val uri = data.data
                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,uri)
                }
                catch (e: IOException){
                    e.printStackTrace()
                }

                //   mBitmap = scaleImage(mBitmap)
                mPhotoImage.setImageBitmap(mBitmap)
            }
        }
    }

    private fun scaleImage(mBitmap: Bitmap): Bitmap {
        val originalWidth = mBitmap!!.width
        val originalHeight = mBitmap.height
        val scaleWidth = mInputSize.toFloat()
        val scaleHeight = mInputSize.toFloat()
        val matrix = Matrix()
        matrix.postScale(scaleWidth,scaleHeight)
        // Example of recycling a bitmap

        return Bitmap.createBitmap(mBitmap,0,0,originalWidth,originalHeight,
            matrix,true)
    }
}