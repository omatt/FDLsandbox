var admin = require("firebase-admin");
var request = require('request');
var {google} = require('googleapis');

// Load the service account key JSON file
var serviceAccount = require("LOCATION OF YOUR PRIVATE KEY");
var credential = admin.credential.cert(serviceAccount);

// Autenticate JWT client with the service account
// Required scope is https://www.googleapis.com/auth/firebase
var jwtClient = new google.auth.JWT(serviceAccount.client_email, null, serviceAccount.private_key, [
 'https://www.googleapis.com/auth/firebase'
]);

// Use JWT client to generate an access token
jwtClient.authorize(function(err, tokens) {
 request({
   // HTTP request for fetching link stats
   // @see https://firebase.google.com/docs/reference/dynamic-links/analytics#http_request
   url: 'https://firebasedynamiclinks.googleapis.com/v1/https%3A%2F%2F<APP_CODE>.app.goo.gl%2F<SUFFIX>/linkStats?durationDays=<DURATION>',
   method: 'GET',
   headers: {
     'Authorization': 'Bearer ' + tokens.access_token
   }
 }, function(err, resp) {
   console.log(resp.body);
 });
});
