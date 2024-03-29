import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Avatar, Button } from "@mui/material";
import BusinessCenter from "@mui/icons-material/BusinessCenter";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import LocationIcon from "@mui/icons-material/LocationOn";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import Box from "@mui/material/Box";
import Tab from "@mui/material/Tab";
import TabContext from "@mui/lab/TabContext";
import TabList from "@mui/lab/TabList";
import TabPanel from "@mui/lab/TabPanel";
import PostCard from "../homepage/PostCard";

export default function Profile() {
  const navigate = useNavigate();
  const handleNavBack = () => navigate(-1);

  const [value, setValue] = useState("1");

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleOpenProfile = () => {
    console.log("Open profile");
  };

  const handleFollow = () => {
    console.log("Follow");
  };

  return (
    <div>
      <section className={"bg-white z-50 flex items-center sticky top-0 bg-opacity-95"}>
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleNavBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-90 ml-5">21 Guns</h1>
      </section>
      <section>
        <img
          className="w-[100%] h-[15rem] object-cover"
          src="https://cdn.pixabay.com/photo/2024/03/05/22/04/bird-8615360_640.jpg"
          alt="image"
        />
      </section>
      <section className="pl-6">
        <div className="flex justify-between items-start mt-5 h-[5rem]">
          <Avatar
            className="transform -translate-y-24"
            alt="user"
            src="https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659651_640.png"
            sx={{ width: "10rem", height: "10rem", border: "4px solid white" }}
          />
          {true ? (
            <Button
              className="rounded-full"
              variant="contained"
              sx={{ borderRadius: "20px" }}
              onClick={handleOpenProfile}
            >
              Edit Profile
            </Button>
          ) : (
            <Button
              className="rounded-full"
              variant="contained"
              sx={{ borderRadius: "20px" }}
              onClick={handleFollow}
            >
              {true ? "Follow" : "Unfollow"}
            </Button>
          )}
        </div>
        <div>
          <div className="flex items-center">
            <h1 className="font-bold text-lg">21 Guns</h1>
            {true && (
              <img
                className="ml-2 w-5 h-5"
                src="https://cdn.pixabay.com/photo/2017/09/29/00/30/checkmark-icon-2797531_640.png"
                alt="verified"
              />
            )}
          </div>
          <h1 className="text-gray-500">@pirate3Guy</h1>
        </div>
        <div className="mt-2 space-y-3">
          <p>This is the description of 21Guns</p>
          <div className="py-1 flex space-x-5">
            <div className="flex items-center text-gray-500">
              <BusinessCenter />
              <p className="ml-2">Education</p>
            </div>
            <div className="flex items-center text-gray-500">
              <LocationIcon />
              <p className="ml-2">India</p>
            </div>
            <div className="flex items-center text-gray-500">
              <CalendarMonthIcon />
              <p className="ml-2">Joined 3 years ago</p>
            </div>
          </div>
          <div className="flex items-center"></div>
          <div className="flex items-center space-x-5">
            <div className="flex items-center space-x-1 font-semibold">
              <span>512</span>
              <span className="text-gray-500">Following</span>
            </div>
            <div className="flex items-center space-x-1 font-semibold">
              <span>242</span>
              <span className="text-gray-500">Followers</span>
            </div>
          </div>
        </div>
      </section>
      <section className="py-5">
        <Box sx={{ width: "100%", typography: "body1" }}>
          <TabContext value={value}>
            <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
              <TabList
                onChange={handleChange}
                aria-label="lab API tabs example"
              >
                <Tab label="POSTS" value="1" />
                <Tab label="REPLIES" value="2" />
                <Tab label="MEDIA" value="3" />
                <Tab label="LIKES" value="4" />
              </TabList>
            </Box>
            <TabPanel value="1">
              {[1, 1, 1, 1].map(() => (
                <PostCard />
              ))}
            </TabPanel>
            <TabPanel value="2">Item Two</TabPanel>
            <TabPanel value="3">Item Three</TabPanel>
            <TabPanel value="4">Item Four</TabPanel>
          </TabContext>
        </Box>
      </section>
    </div>
  );
}
