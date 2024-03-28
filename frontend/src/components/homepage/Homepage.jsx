import React from "react";
import { Grid } from "@mui/material";
import Navigation from "../nav/Navigation";
import Feed from "../feed/Feed";
export default function Homepage() {
  return (
    <Grid container xs={12} className="px-5 lg:px-36 justify-between">
      <Grid xs={0} lg={2.5} className="hidden lg:block w-full relative">
        <Navigation />
      </Grid>

      <Grid xs={12} lg={6} className="hidden lg:block w-full relative">
        <Feed />
      </Grid>

      <Grid xs={0} lg={3} className="hidden lg:block w-full relative">
        <p>Text</p>
      </Grid>
    </Grid>
  );
}
