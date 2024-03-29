import React from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import { Divider } from "@mui/material";
import PostCard from "../homepage/PostCard";

export default function CommentSection() {
  const navigate = useNavigate();
  const handleNavBack = () => navigate(-1);
  return (
    <>
      <section className={"bg-white z-50 flex items-center sticky top-0 bg-opacity-95"}>
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleNavBack}
        />
        <h1 className="py-5 text-xl font-bold opacity-90 ml-5">Post</h1>
      </section>
      <section>
        <PostCard />
        <Divider sx={{ margin: "2rem 0rem" }} />
      </section>
      <section>
        {[1, 1, 1, 1].map(() => (
          <PostCard />
        ))}
      </section>
    </>
  );
}
