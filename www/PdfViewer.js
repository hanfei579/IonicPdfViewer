
var exec = require('cordova/exec');


var PdfViewer = function () {};
PdfViewer.prototype.viewDocument = function (arg1, arg2,arg3) {
    exec(function(message) {

    }, function(message) {
        window.log(message);
    }, "PdfViewer", "viewDocumentAndroid", [ {url:arg1,contentType:arg2,fileUrlType:arg3}]);
};

module.exports = new PdfViewer();
//
//exports.viewDocument = function (arg1, arg2) {
//    exec(function(message) {
//
//            }, function(message) {
//                window.log(message);
//            }, "PdfViewer", "viewDocumentAndroid", [{ url: arg1, contentType: arg2 }]);
//};
//
//}); 
