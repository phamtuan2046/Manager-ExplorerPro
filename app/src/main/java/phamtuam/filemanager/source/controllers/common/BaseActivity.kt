//package phamtuam.filemanager.source.controllers.common
//
//import android.Manifest
//import android.content.pm.PackageManager
//import android.content.pm.ResolveInfo
//import android.os.Build
//import android.support.design.widget.Snackbar
//import android.support.v4.app.ActivityCompat
//import android.support.v4.content.ContextCompat
//import android.text.TextUtils
//import android.view.View
//import android.widget.AbsListView
//import phamtuam.filemanager.source.controllers.R
//import phamtuam.filemanager.source.controllers.activities.ActionBarActivity
//import phamtuam.filemanager.source.controllers.misc.PermissionUtil
//import phamtuam.filemanager.source.controllers.misc.Utils
//import phamtuam.filemanager.source.controllers.model.DocumentInfo
//import phamtuam.filemanager.source.controllers.model.DocumentStack
//import phamtuam.filemanager.source.controllers.model.RootInfo
//import phamtuam.filemanager.source.controllers.model.State
//import phamtuam.filemanager.source.controllers.provider.ExternalStorageProvider
//import phamtuam.filemanager.source.controllers.setting.SettingsActivity
//
///**
// * Created by P.Tuan on 1/2/2018.
// */
//abstract class BaseActivity : ActionBarActivity(){
//
//    private val storagePermissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//    val REQUEST_STORAGE = 47
//
//    abstract fun getDisplayState() : State
//
//    abstract fun getCurrentRoot(): RootInfo
//
//    abstract fun onStateChanged()
//
//    abstract fun setRootsDrawerOpen(open: Boolean)
//
//    abstract fun onDocumentPicked(doc: DocumentInfo)
//
//    abstract fun onDocumentsPicked(docs: List<DocumentInfo>)
//
//    abstract fun getCurrentDirectory(): DocumentInfo
//
//    abstract fun setPending(pending: Boolean)
//
//    abstract fun onStackPicked(stack: DocumentStack)
//
//    abstract fun onPickRequested(pickTarget: DocumentInfo)
//
//    abstract fun onAppPicked(info: ResolveInfo)
//
//    abstract fun onRootPicked(root: RootInfo, closeDrawer: Boolean)
//
//    abstract fun onSaveRequested(replaceTarget: DocumentInfo)
//
//    abstract fun onSaveRequested(mimeType: String, displayName: String)
//
//    abstract fun isCreateSupported(): Boolean
//    abstract fun getDownloadRoot(): RootInfo
//    abstract fun getActionMode(): Boolean
//    abstract fun setActionMode(actionMode: Boolean)
//    abstract fun setUpStatusBar()
//    abstract fun setUpDefaultStatusBar()
//
//    abstract fun isShowAsDialog(): Boolean
//    abstract fun upadateActionItems(mCurrentView: AbsListView)
//    abstract fun setInfoDrawerOpen(open: Boolean)
//    abstract fun again()
//
//    fun showError(msg: Int) {
//        showToast(msg, ContextCompat.getColor(this, R.color.button_text_color_red), Snackbar.LENGTH_SHORT)
//    }
//
//    fun showToast(msg: Int, actionColor: Int, duration: Int) {
//        val snackbar = Snackbar.make(findViewById(R.id.content_view), msg, duration)
//        snackbar.setAction(android.R.string.ok) { snackbar.dismiss() }
//                .setActionTextColor(actionColor).show()
//    }
//
//    fun showSnackBar(text: String, duration: Int) {
//        val snackbar = Snackbar.make(findViewById(R.id.content_view), text, duration)
//        snackbar.setAction(android.R.string.ok) { snackbar.dismiss() }
//        snackbar.setActionTextColor(SettingsActivity.getAccentColor()).show()
//    }
//
//    fun showSnackBar(text: String, duration: Int, action: String, actionColor: Int) {
//        val snackbar = Snackbar.make(findViewById(R.id.content_view), text, duration)
//        snackbar.setAction(action) { snackbar.dismiss() }
//        snackbar.setActionTextColor(actionColor).show()
//    }
//
//    fun showSnackBar(text: String, duration: Int, action: String, actionColor: Int, listener: View.OnClickListener) {
//        Snackbar.make(findViewById(R.id.content_view), text, duration).setAction(action, listener)
//                .setActionTextColor(actionColor).show()
//    }
//
//    fun showSnackBar(text: String, duration: Int, action: String, listener: View.OnClickListener) {
//        Snackbar.make(findViewById(R.id.content_view), text, duration).setAction(action, listener)
//                .setActionTextColor(SettingsActivity.getAccentColor()).show()
//    }
//
//    fun isSAFIssue(docId: String): Boolean {
//        val isSAFIssue = (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT
//                && !TextUtils.isEmpty(docId) && docId.startsWith(ExternalStorageProvider.ROOT_ID_SECONDARY))
//
//        if (isSAFIssue) {
//            showError(R.string.saf_issue)
//        }
//        return isSAFIssue
//    }
//
//
//
//    protected fun requestStoragePermissions() {
//        if (PermissionUtil.hasStoragePermission(this)) {
//            again()
//        } else {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                Utils.showRetrySnackBar(this, "Storage permissions are needed for Exploring.") { ActivityCompat.requestPermissions(this@BaseActivity, storagePermissions, REQUEST_STORAGE) }
//            } else {
//                ActivityCompat.requestPermissions(this, storagePermissions, REQUEST_STORAGE)
//            }
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when(requestCode){
//            REQUEST_STORAGE -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    again()
//                } else {
//                    Utils.showRetrySnackBar(this, "Permission grating failed", null)
//                    requestStoragePermissions()
//                }
//                return
//            }
//        }
//    }
//}