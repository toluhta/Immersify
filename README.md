Immersify
=========

Plugin for Apache Cordova 3.3 to enable Immersive mode on Android Kitkat

More information about Immersive mode can be found from https://developer.android.com/training/system-ui/immersive.html

Installation
=========

cordova plugin add https://github.com/toluhta/Immersify.git

Usage
=========

When device is ready...

###Immersive mode
```
Immersify.enable(successCallback, errorCallback);
```
### Sticky Immersive mode
```
Immersify.enableSticky(successCallback, errorCallback);
```

### Disable
```
Immersify.disable();
```

Tips
=========
Immersive mode is only available on Android Kitkat so check your users platform version before using.

When resuming the app, immersive mode is disabled so maybe hook a eventlistener for resume and enable immersive mode again

License
=========
This projected is licensed under the terms of the MIT license.
