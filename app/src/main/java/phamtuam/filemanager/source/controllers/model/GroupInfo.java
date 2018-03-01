package phamtuam.filemanager.source.controllers.model;

import java.util.List;

import phamtuam.filemanager.source.controllers.fragment.RootsFragment.*;

/**
 * Created by HaKr on 07/08/16.
 */

public class GroupInfo {
    public String label;
    public List<Item> itemList;

    public GroupInfo(String text, List<Item> list){
        label = text;
        itemList = list;
    }
}
