# FDLsandbox
Firebase Dynamic Links [Analytics REST API](https://firebase.google.com/docs/dynamic-links/analytics#rest_api) sandbox

More information regarding FDL Analytics REST API can be viewed [here](https://firebase.google.com/docs/reference/dynamic-links/analytics).

## Setup
1. Install [Firebase CLI](https://firebase.google.com/docs/cli/)
2. Add the Firebase Admin SDK
```
npm install firebase-admin --save
```
3. Add Google API
```
npm install googleapis --save
```
4. Get your Private Key
...Go to your [Firebase Console](https://console.firebase.google.com/)
...Open your Project
...Click the gear icon located in the on the upper left side-panel, and choose **Project Settings**
...Select **Service Accounts** tab
...Select **Firebase Admin SDK**
...Click **Generate New Private Key**

## Run

### Option 1
1. Generate your Access Token, run this in your Terminal
```
node access_token_generator.js
```
2. Copy the generated Access Token and run this command in your Terminal. Make sure to replace the necessary values.
```
curl -i 'https://firebasedynamiclinks.googleapis.com/v1/https%3A%2F%2F<APP_CODE>.app.goo.gl%2F<SUFFIX>/linkStats?durationDays=<DURATION>' -H "Authorization: Bearer <ACCESS_TOKEN>"
```

### Option 2
1. Install request
```
npm install request --save
```
2. Run fdl_analytics.js in your Terminal
```
node fdl_analytics.js
```
