var admin = require("firebase-admin");
var request = require('request');

var google = require('googleapis');

var serviceAccount = require("LOCATION OF YOUR PRIVATE KEY)");
var credential = admin.credential.cert(serviceAccount);

var jwtClient = new google.auth.JWT(serviceAccount.client_email, null, serviceAccount.private_key, [
 'https://www.googleapis.com/auth/firebase'
]);

jwtClient.authorize(function(err, tokens) {
 request({
   url: 'https://firebasedynamiclinks.googleapis.com/v1/https%3A%2F%2F<APP_CODE>.app.goo.gl%2F<SUFFIX>/linkStats?durationDays=<DURATION>',
   method: 'GET',
   headers: {
     'Authorization': 'Bearer ' + tokens.access_token
   }
 }, function(err, resp) {
   console.log(resp.body);
 });
});
