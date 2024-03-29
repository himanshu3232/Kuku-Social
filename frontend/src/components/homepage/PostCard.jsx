import React, { useState } from "react";
import RepeatIcon from "@mui/icons-material/Repeat";
import { Avatar, Button, Menu, MenuItem } from "@mui/material";
import { useNavigate } from "react-router-dom";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import ChatBubbleOutlineIcon from "@mui/icons-material/ChatBubbleOutline";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import BarChartIcon from "@mui/icons-material/BarChart";
import FavoriteIcon from "@mui/icons-material/Favorite";

export default function PostCard() {
  const navigate = useNavigate();
  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const handleDeletePost = () => {
    handleClose();
    console.log("delete post");
  };
  const handleOpenReplyModel = () => {
    console.log("open model");
  };
  const handleRePost = () => {
    console.log("repost");
  };
  const handleLike = () => {
    console.log("like");
  };
  return (
    <div>
      <div className="flex items-center font-semibold text-gray-700 py-2">
        <RepeatIcon />
        <p>Repost</p>
      </div>
      <div className="flex space-x-5">
        <Avatar
          onClick={() => navigate(`/profile/${6}`)}
          className="cursor-pointer"
          alt="user"
          src="https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659651_640.png"
        />
        <div className="w-full">
          <div className="flex justify-between items-center">
            <div className="flex cursor-pointer items-center space-x-2">
              <span className="font-semibold">21 Guns</span>
              <span className="text-gray-600">@pirate3Guy .2m</span>
              <img
                className="ml-2 w-5 h-5"
                src="https://cdn.pixabay.com/photo/2017/09/29/00/30/checkmark-icon-2797531_640.png"
                alt="verified"
              />
            </div>
            <div>
              <Button
                id="basic-button"
                aria-controls={open ? "basic-menu" : undefined}
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleClick}
              >
                <MoreHorizIcon />
              </Button>
              <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                MenuListProps={{
                  "aria-labelledby": "basic-button",
                }}
              >
                <MenuItem onClick={handleDeletePost}>Delete Post</MenuItem>
                <MenuItem onClick={handleDeletePost}>Edit</MenuItem>
              </Menu>
            </div>
          </div>
          <div className="mt-2">
            <div onClick={() => navigate(`/post/${3}`)} className="cursor-pointer">
              <p className="mb-2 p-0">kuku app nice content</p>
            </div>
            <img
              className="w-[28rem] border border-gray-400 p-5 rounded-md"
              src="https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659651_640.png"
            />
          </div>
          <div className="py-5 flex flex-wrap justify-between items-center">
            <div className=" space-x-3 flex items-center text-gray-600">
              <ChatBubbleOutlineIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
              <p>43</p>
            </div>
            <div
              className={`${
                true ? "text-pink-600" : "text-gray-600"
              } space-x-3 flex items-center`}
            >
              <RepeatIcon className="cursor-pointer" onClick={handleRePost} />
              <p>54</p>
            </div>
            <div
              className={`${
                true ? "text-pink-600" : "text-gray-600"
              } space-x-3 flex items-center`}
            >
              {true ? (
                <FavoriteIcon className="cursor-pointer" onClick={handleLike} />
              ) : (
                <FavoriteBorderIcon
                  className="cursor-pointer"
                  onClick={handleLike}
                />
              )}
              <p>54</p>
            </div>
            <div className=" space-x-3 flex items-center text-gray-600">
              <BarChartIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
              <p>4300</p>
            </div>
            <div className=" space-x-3 flex items-center text-gray-600">
              <FileUploadIcon
                className="cursor-pointer"
                onClick={handleOpenReplyModel}
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
