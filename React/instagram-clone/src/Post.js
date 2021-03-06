import React from 'react';
import './Post.css';
import Avatar from "@material-ui/core/Avatar";

function Post({ username, caption, imageUrl }) {
  return (
    <div className="post">
      <div className="post__header">
        <Avatar 
          className="post__avatar"
          alt="Marcus Lee"
          src="/static/images/avatar/geminimarcus.jpg" 
        />
        <h3>{username}</h3>
      </div>
      {/* Header -> Avatar + Username */}

      <img className="post__image" src={imageUrl} alt="" />
      {/* Image */}

      <h4 className="post__text"><strong>{username}</strong> {caption}</h4>
      {/* Username + Caption */}
    </div>
  )
}

export default Post
