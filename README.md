# TastyToast

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![API](https://img.shields.io/badge/API-11%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=11)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TastyToast-red.svg?style=flat)](http://android-arsenal.com/details/1/4039)

Make your native android toast look beautiful.

## Preview
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/success.gif)
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/warning.gif)
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/error.gif)
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/info.gif)
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/default.gif)
![gif](https://github.com/yadav-rahul/TastyToast/blob/lib/static/confusion.gif)

## About

Refer Here [Wiki](https://github.com/yadav-rahul/TastyToast/wiki)

Grab the above demo app from here :

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/images/badge_new.png)](https://play.google.com/store/apps/details?id=com.demo.tastytoast)

##Dependency

Add dependency in your app module

```
dependencies {
	compile 'com.sdsmdg.tastytoast:tastytoast:0.1.1'
}
```

##Usage

###Java
```
TastyToast.makeText(getApplicationContext(), "Hello World !", TastyToast.LENGTH_LONG, TastyToast.WARNING);
```
Last parameter here is the type of toast you want to show.

## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/yadav-rahul/TastyToast/pulls).

Any contributions, large or small, major features, bug fixes, are welcomed and appreciated
but will be thoroughly reviewed .

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2016 Rahul Yadav

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
