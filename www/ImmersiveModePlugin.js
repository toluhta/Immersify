    var Immersify = {
        enable : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "enableImmersive", [null]);
        },
        enableSticky : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "enableSticky", [null]);
        },
        disable : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "disable", [null]);
        }
    }
    module.exports = Immersify;
