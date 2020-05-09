![Logo](https://raw.githubusercontent.com/sungbin5304/AndroidUtils/master/banner%20(1).png)

-----

# Download [![](https://jitpack.io/v/sungbin5304/AndroidUtils.svg)](https://jitpack.io/#sungbin5304/AndroidUtils)

```Gradle
repositories {
  mavenCentral()
  google()
  maven { 
    url 'https://jitpack.io' 
  }
}

dependencies {
  implementation 'com.github.sungbin5304:AndroidUtils:{version}'
  implementation 'org.jsoup:jsoup:1.12.1' (optional)
}
```

# **Usage**
# Utils
## LayoutUtils
```kotlin
- putMargin(ctx: Context, layout: ViewGroup): FrameLayout
```

## NotificationUtils [[Help Page]](https://github.com/sungbin5304/NotificationManager)
```kotlin
- setGroupName(name: String)
- createChannel(context: Context, name: String, description: String)
- showNormalNotification(context: Context, id: Int, title: String, content: String, icon: Int)
- showInboxStyleNotification(context: Context, id: Int, title: String, content: String, boxText: List<String>, icon: Int)
- deleteNotification(context: Context, id: Int)
```

## DataUtils
```kotlin
- readData(ctx: Context, name: String, _null: String): String
- saveData(ctx: Context, name: String, value: String)
- clearData(ctx: Context)
```
 
## DialogUtils
```kotlin
- show(ctx: Context, title: String, message: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
- showOnce(ctx: Context, title: String, message: String, id: String, listener: DialogInterface.OnClickListener?, cancelable: Boolean = true)
```

## PermissionUtils
```Kotlin
- request(act: Activity, message: String, permission: Array<String>)
- requestReadNotification(act: Activity)
```

## ColorUtils
```Kotlin
- setStatusBarColor(act: Activity, color: Int)
- setNavigationBarColor(act: Activity, color: Int)
- setStatusBarIconColorGray(act: Activity)
```

## StorageUtils
```Kotlin
- sdcard
- createFolder(name: String)
- read(name: String, _null: String): String
- save(name: String, content: String)
- delete(name: String)
- deleteAll(name: String)
```

## ToastUtils
```Kotlin
- show(context: Context, message: String, duration: Int, type: Int)

+ Duration List
- SHORT
- LONG

+ Type List
- INFO
- SUCCESS
- WARNING
- ERROR 
```

## Utils
```Kotlin
- copy(ctx: Context, text: String)
- error(ctx: Context, e: Exception, at: String)
- setUserAgent(agent: String)
- getHtml(address: String): String? (need implementation jsoup library)
- makeRandomUUID(): String
- getAppVersionName(act: Activity): String
```

## StringUtils
```kotlin
- toEditable(string: String): Editable
```

## ReadMoreUtils
```kotlin
- setReadMoreLine(view: TextView, text: String, maxLine: Int, expanedText: String = "...더보기", expanedTextColor: Int = Color.parseColor("#9E9E9E"))
- setReadMoreLength(view: TextView, text: String, maxLength: Int,expanedText: String = "...더보기", expanedTextColor: Int = Color.parseColor("#9E9E9E"))
```

# UI
## TagableRoundImageView
### preview
![image](https://raw.githubusercontent.com/sungbin5304/TagableRoundImageView/master/banner.png)

### xml
```xml
<com.sungbin.sungbintool.ui.TagableRoundImageView
        android:id="@+id/image"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:src="@drawable/doraemon"
        app:triv_imageRadius="16dp"
        app:triv_tagText="gif"
        app:triv_tagPadding="8dp"
        app:triv_tagGravity="end|bottom" />
```

### all attribute
| Attribute | Description| Default |
| ------------- | ------------- | ------------- |
| `triv_tagGravity` | Set tag gravity (`top`, `bottom`, `left`, `right`, `start`, `end`) | `Gravity.END` and `Gravity.BOTTOM` |
| `triv_tagTextStyle` | Set tag text style (`italic`, `normal`) | `NORMAL` |
| `triv_imageRadius` | Set imageview radius | `16dp` |
| `triv_tagRadius` | Set tag layout radius | `2dp` |
| `triv_tagPadding` | Set tag layout padding | `8dp` |
| `triv_tagTextSize` | Set tag text size| `15dp` |
| `triv_tagText` | Set tag text | No value |
| `triv_tagBackgroundColor` | Set tag layout background color | `Color.WHITE` |

### method
```kotlin
- set(text: String, tagBackgroundColor: Int = Color.WHITE,
      tagTextSize: Int = 15dp, tagTextPadding: Int = 8dp,
      tagTextStyle: Int = Typeface.NORMAL, tagRadius: Int = 2dp,
      imageRadius: Int = 16dp)
```

### tip
1. `TagableRoundImageView` is supported GIF images.<br>
You can set GIF image from [Glide](https://github.com/bumptech/glide) library.

2. If you not set `triv_tagText` parameter, `TagableRoundImageView` will be only rounding image.

-----

# License
```
                    Copyright 2020 SungBin

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```


# Happy Coding :)
