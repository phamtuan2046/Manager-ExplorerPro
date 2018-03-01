package phamtuam.filemanager.source.controllers.model;

import android.content.ContentProviderClient;
import android.database.Cursor;

import java.io.Closeable;

import phamtuam.filemanager.source.controllers.libcore.io.IoUtils;
import phamtuam.filemanager.source.controllers.misc.ContentProviderClientCompat;

import static phamtuam.filemanager.source.controllers.activities.BaseActivity.State.MODE_UNKNOWN;
import static phamtuam.filemanager.source.controllers.activities.BaseActivity.State.SORT_ORDER_UNKNOWN;

public class DirectoryResult implements Closeable {
	public ContentProviderClient client;
    public Cursor cursor;
    public Exception exception;

    public int mode = MODE_UNKNOWN;
    public int sortOrder = SORT_ORDER_UNKNOWN;

    @Override
    public void close() {
        IoUtils.closeQuietly(cursor);
        ContentProviderClientCompat.releaseQuietly(client);
        cursor = null;
        client = null;
    }
}