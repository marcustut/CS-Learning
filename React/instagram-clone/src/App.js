import React, { useState, useEffect } from 'react';
import { db } from './firebase';

import Post from './Post';

import './App.css';
import Modal from '@material-ui/core';

function App() {
  const [posts, setPosts] = useState([]);
  const [open, setOpen] = useState(false);

  // useEffect runs a piece of code based on a specific condition

  useEffect(() => {
    // this is where the code runs
    db.collection('posts').onSnapshot(snapshot => {
      // every time a new post is added, this code will fire off
      setPosts(snapshot.docs.map(doc => ({
        id: doc.id,
        post: doc.data()
      })));
    });
  }, []);

  return (
    <div className="app">
      {/* <Modal
        open={open}
        onClose={() => setOpen(false)}
      >
        <div style={modalStyle} className={classes.paper}>
      </Modal> */}
      <div className="app__header">
        <img
          className="app__headerImage"
          src="https://www.instagram.com/static/images/web/mobile_nav_type_logo.png/735145cfe0a4.png"
          alt=""
        />
      </div>

      <h1>YOOOOO!</h1>

      {
        posts.map(({id, post}) => {
          return (
            <Post key={id} username={post.username} caption={post.caption} imageUrl={post.imageUrl} />
          )
        })
      }

    </div>
  );
}

export default App;
