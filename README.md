# CurrencyEditText

An Android EditText with automatic currency formatting.

---

## Releases:

#### Current release: 1.0.0.

You can see all the library releases [here](https://github.com/marcoscgdev/CurrencyEditText/releases).

---

## Screenshots
<kbd><img src="https://raw.githubusercontent.com/marcoscgdev/CurrencyEditText/master/Screenshot_1617663066.png" width="350"></kbd>&nbsp;&nbsp;&nbsp;&nbsp;<kbd><img src="https://raw.githubusercontent.com/marcoscgdev/CurrencyEditText/master/Screenshot_1617663115.png" width="350"></kbd>

Download the sample apk [here](https://github.com/marcoscgdev/CurrencyEditText/releases/download/1.0.0/app-debug.apk).

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```groovy
implementation 'com.github.marcoscgdev:CurrencyEditText:1.0.0'
```

### Using the widget

```xml
<com.marcoscg.currencyedittext.CurrencyEditText
    android:id="@+id/editText"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

### Retrieving the value

```kotlin
val value = currencyEditText.getNumericValue()
```

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
Copyright 2021 Marcos Calvo García

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
