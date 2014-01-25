    var Immersify = {
        enable : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "enableImmersive", []);
        },
        enableSticky : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "enableSticky", []);
        },
        disable : function(successCallback, errorCallback) {
            cordova.exec(successCallback, errorCallback, "Immersify", "disable", []);
        }
    }
    module.exports = Immersify;
