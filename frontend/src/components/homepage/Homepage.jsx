import React from "react";
import { Grid } from "@mui/material";
import Navigation from "../nav/Navigation";
import Feed from "../feed/Feed";
import Trending from "../trending/Trending";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Profile from "../profile/Profile";
import CommentSection from "../commentSection/CommentSection";

export default function Homepage() {
  return (
    <Grid container xs={12} className="px-5 lg:px-36 justify-between">
      <Grid xs={0} lg={2.5} className="hidden lg:block w-full relative">
        <Navigation />
      </Grid>

      <Grid
        xs={12}
        lg={6}
        className="px-5 lg:px-9 hidden lg:block w-full relative"
      >
        <Routes>
          <Route path="/" element={<Feed />} />
          <Route path="/profile/:id" element={<Profile />} />
          <Route path="/post/:id" element={<CommentSection />} />
        </Routes>
      </Grid>

      <Grid xs={0} lg={3} className="hidden lg:block w-full relative">
        <Trending />
      </Grid>
    </Grid>
  );
}
