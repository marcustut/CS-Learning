import firebase from "firebase";

const firebaseApp = firebase.initializeApp ({
  apiKey: "AIzaSyBMRTO8WLZLD1TTWbPB55VLIMO5zKMBjsY",
  authDomain: "instagram-clone-react-9e0c7.firebaseapp.com",
  databaseURL: "https://instagram-clone-react-9e0c7.firebaseio.com",
  projectId: "instagram-clone-react-9e0c7",
  storageBucket: "instagram-clone-react-9e0c7.appspot.com",
  messagingSenderId: "887302113810",
  appId: "1:887302113810:web:7c44a1299bfd988dc366cb",
  measurementId: "G-B4Z1DWCZY8"
});

const db = firebaseApp.firestore();
const auth = firebase.auth();
const storage = firebase.storage();

export { db, auth, storage };
