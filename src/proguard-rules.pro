# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.bextdev.popupmenu.PopupMenu {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/bextdev/popupmenu/repack'
-flattenpackagehierarchy
-dontpreverify
