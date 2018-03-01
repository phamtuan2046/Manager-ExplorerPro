//package phamtuam.filemanager.source.controllers.model
//
//import android.os.Parcel
//import android.os.Parcelable
//import android.support.v4.util.ArrayMap
//import android.util.SparseArray
//
///**
// * Created by P.Tuan on 1/2/2018.
// */
//open class State() : Parcelable {
//    var action: Int = 0
//    lateinit var acceptMimes: Array<String>
//
//    /** Explicit user choice  */
//    var userMode = MODE_UNKNOWN
//    /** Derived after loader  */
//    var derivedMode = MODE_LIST
//
//    /** Explicit user choice  */
//    var userSortOrder = SORT_ORDER_UNKNOWN
//    /** Derived after loader  */
//    var derivedSortOrder = SORT_ORDER_DISPLAY_NAME
//
//    var allowMultiple = false
//    var showSize = false
//    var showFolderSize = false
//    var showThumbnail = false
//    var showHiddenFiles = false
//    var localOnly = false
//    var forceAdvanced = false
//    var showAdvanced = false
//    var rootMode = false
//    var stackTouched = false
//    var restored = false
//
//    /** Current user navigation stack; empty implies recents.  */
//    var stack = DocumentStack()
//    /** Currently active search, overriding any stack.  */
//    var currentSearch: String? = null
//
//    /** Instance state for every shown directory  */
//    var dirState = ArrayMap<String, SparseArray<Parcelable>>()
//
//    constructor(parcel: Parcel) : this() {
//        action = parcel.readInt()
//        acceptMimes = parcel.createStringArray()
//        userMode = parcel.readInt()
//        derivedMode = parcel.readInt()
//        userSortOrder = parcel.readInt()
//        derivedSortOrder = parcel.readInt()
//        allowMultiple = parcel.readByte() != 0.toByte()
//        showSize = parcel.readByte() != 0.toByte()
//        showFolderSize = parcel.readByte() != 0.toByte()
//        showThumbnail = parcel.readByte() != 0.toByte()
//        showHiddenFiles = parcel.readByte() != 0.toByte()
//        localOnly = parcel.readByte() != 0.toByte()
//        forceAdvanced = parcel.readByte() != 0.toByte()
//        showAdvanced = parcel.readByte() != 0.toByte()
//        rootMode = parcel.readByte() != 0.toByte()
//        stackTouched = parcel.readByte() != 0.toByte()
//        restored = parcel.readByte() != 0.toByte()
//        stack = parcel.readParcelable(DocumentStack::class.java.classLoader)
//        currentSearch = parcel.readString()
//    }
//
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeInt(action)
//        parcel.writeStringArray(acceptMimes)
//        parcel.writeInt(userMode)
//        parcel.writeInt(derivedMode)
//        parcel.writeInt(userSortOrder)
//        parcel.writeInt(derivedSortOrder)
//        parcel.writeByte(if (allowMultiple) 1 else 0)
//        parcel.writeByte(if (showSize) 1 else 0)
//        parcel.writeByte(if (showFolderSize) 1 else 0)
//        parcel.writeByte(if (showThumbnail) 1 else 0)
//        parcel.writeByte(if (showHiddenFiles) 1 else 0)
//        parcel.writeByte(if (localOnly) 1 else 0)
//        parcel.writeByte(if (forceAdvanced) 1 else 0)
//        parcel.writeByte(if (showAdvanced) 1 else 0)
//        parcel.writeByte(if (rootMode) 1 else 0)
//        parcel.writeByte(if (stackTouched) 1 else 0)
//        parcel.writeByte(if (restored) 1 else 0)
//        parcel.writeParcelable(stack, flags)
//        parcel.writeString(currentSearch)
//    }
//
//    companion object CREATOR : Parcelable.Creator<State> {
//        val ACTION_OPEN = 1
//        val ACTION_CREATE = 2
//        val ACTION_GET_CONTENT = 3
//        val ACTION_OPEN_TREE = 4
//        val ACTION_MANAGE = 5
//        val ACTION_BROWSE = 6
//        val ACTION_MANAGE_ALL = 7
//
//        val MODE_UNKNOWN = 0
//        val MODE_LIST = 1
//        val MODE_GRID = 2
//
//        val SORT_ORDER_UNKNOWN = 0
//        val SORT_ORDER_DISPLAY_NAME = 1
//        val SORT_ORDER_LAST_MODIFIED = 2
//        val SORT_ORDER_SIZE = 3
//
//        override fun createFromParcel(parcel: Parcel): State {
//            return State(parcel)
//        }
//
//        override fun newArray(size: Int): Array<State?> {
//            return arrayOfNulls(size)
//        }
//    }
//}