import React from "react";
import SearchIcon from "@mui/icons-material/Search";
import BrightnessIcon from "@mui/icons-material/Brightness4";
import { Button } from "@mui/material";

export default function Trending() {
  const handleChangeTheme = () => {
    console.log("theme changed");
  };
  return (
    <div className="py-5 sticky top">
      <div className="relative flex items-center">
        <input
          type="text"
          className="py-3 rounded-full text-gray-500 w-full pl-12"
        />
        <div className="absolute top-0 left-0 pl-3 pt-3">
          <SearchIcon className="text-gray-500" />
        </div>
        <BrightnessIcon
          onClick={handleChangeTheme}
          className="ml-3 cursor-pointer"
        />
      </div>
      <section className="my-5">
        <h1 className="text-xl font-bold">Get Verified</h1>
        <h1 className="font-bold my-2">Subscribe to unlock new features</h1>
        <Button
          variant="contained"
          sx={{ padding: "10px", paddingX: "20px", borderRadius: "25px" }}
        >
          Get Verified
        </Button>
      </section>
      <section className="mt-7 space-y-5">
        <h1 className="font-bold text-xl py-1">What's happening</h1>
        <div>
          <p className="text-sm">Election 2024</p>
        </div>
      </section>
    </div>
  );
}
