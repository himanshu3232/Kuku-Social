import React, { useState } from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { IconButton } from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import FiberManualRecordIcon from "@mui/icons-material/FiberManualRecord";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  p: 4,
  borderRadius: 4,
  outline: "none",
};

const features = [
  "Edit post: This highly requested feature gives you a 1 hour window to make a limited number of changes to published posts. Use it to make updates, tag someone, or reorder the media you attached. Edit post currently only applies to original posts and quotes.",
  "Longer posts: Want to post more than 280 characters? Longer posts allow subscribers to post up to 25,000 characters. You can also compose longer posts in a quote or reply. Standard functionality like posting media, creating polls, and using hashtags still apply. Everyone will be able to read longer posts, but only Premium subscribers can create them.",
  "Longer video uploads: Share more content with your followers. Premium subscribers can upload videos up to ~3 hours long and up to 8GB file size (1080p) (on kuku.com and Kuku for iOS only). Learn more encrypted direct messages with other Premium accounts.",
  "Create a Community: As a Premium subscriber, you can create a community on Kuku to connect with people who share similar interests. ",
];

export default function VerifiedModal({open, handleClose}) {
  
  const [plan, setPlan] = useState("Annually");

  return (
    <>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <div className="flex items-center space-x-3">
            <IconButton onClick={handleClose} aria-label="delete">
              <CloseIcon />
            </IconButton>
          </div>
          <div className="flex justify-center py-10">
            <div className="w-[80%] space-y-10">
              <div className="p-5 rounded-md flex bg-slate-400 items-center justify-between shadow-lg">
                <h1 className="text-xl pr-5">
                  Blue subscribers with a verified phone number will get a blue
                  checkmark once approved.
                </h1>
                <img
                  className="w-24 h-24"
                  src="https://cdn.pixabay.com/photo/2017/09/29/00/30/checkmark-icon-2797531_640.png"
                  alt="verified"
                />
              </div>
              <div className="flex justify-between border rounded-full px-5 py-3 border border-gray-500">
                <div>
                  <span
                    onClick={() => setPlan("Annually")}
                    className={`${
                      plan === "Annually" ? "text-black" : "text-gray-400"
                    } cursor-pointer`}
                  >
                    Annually
                  </span>
                  <span className="text-green-500 text-sm ml-5">SAVE 12%</span>
                </div>
                <p
                  onClick={() => setPlan("Monthly")}
                  className={`${
                    plan === "Monthly" ? "text-black" : "text-gray-400"
                  } cursor-pointer`}
                >
                  Monthly
                </p>
              </div>
              <div className="space-y-3">
                {features.map((item) => (
                  <div className="flex items-center space-x-5">
                    <FiberManualRecordIcon
                      sx={{ width: "7px", height: "7px" }}
                    />
                    <p className="text-xs">{item}</p>
                  </div>
                ))}
              </div>
              <div className="cursor-pointer flex justify-center bg-gray-900 text-white rounded-full px-5 py-3">
                <span className="line-through italic">
                ₹100.00
                </span>
                <span className="px-5">₹10.00</span>
              </div>
            </div>
          </div>
        </Box>
      </Modal>
    </>
  );
}
