import React, { useState } from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { Avatar, Button } from "@mui/material";
import { useNavigate } from "react-router-dom";
import ImageIcon from "@mui/icons-material/Image";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import TagFacesIcon from "@mui/icons-material/TagFaces";
import { useFormik } from "formik";
import * as Yup from "yup";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  outline: "none",
  p: 4,
  borderRadius: 4,
};

const validationSchema = Yup.object().shape({
  content: Yup.string().required("Post text is required"),
});

export default function CommentModal({ handleClose, open }) {
  const navigate = useNavigate();
  const [uploadingImage, setUploadingImage] = useState(false);
  const [selectedImage, setSelectedImage] = useState("");

  const handleSelectImage = (e) => {
    setUploadingImage(true);
    const imgUrl = e.target.files[0];
    formik.setFieldValue("image", imgUrl);
    setSelectedImage(imgUrl);
    setUploadingImage(false);
  };

  const handleSubmit = (value) => {
    console.log("values", value);
    handleClose();
  };

  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
      postId: 4,
    },
    onSubmit: handleSubmit,
    validationSchema,
  });

  return (
    <>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
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
              </div>
              <div className="mt-2">
                <div
                  onClick={() => navigate(`/post/${3}`)}
                  className="cursor-pointer"
                >
                  <p className="mb-2 p-0">kuku app nice content</p>
                </div>
              </div>
            </div>
          </div>
          <section className={"py-10"}>
            <div className="flex space-x-5">
              <Avatar
                alt="user"
                src="https://cdn.pixabay.com/photo/2015/03/04/22/35/avatar-659651_640.png"
              />
              <div className="w-full">
                <form onSubmit={formik.handleSubmit}>
                  <div>
                    <input
                      className={
                        "border-none outline-none text-xl bg-transparent"
                      }
                      name="content"
                      type="text"
                      placeholder="Post on Kuku!"
                      {...formik.getFieldProps("content")}
                    />
                    {formik.errors.content && formik.touched.content && (
                      <span className="text-red-500">
                        {formik.errors.content}
                      </span>
                    )}
                  </div>
                  <div>
                    <img src="" alt="" />
                  </div>
                  <div className="flex justify-between items-center mt-5">
                    <div className="flex space-x-5 items-center">
                      <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                        <ImageIcon className="text-[#1d9bf0]" />
                        <input
                          type="file"
                          name="imageFile"
                          className="hidden"
                          onChange={handleSelectImage}
                        />
                      </label>
                      <FmdGoodIcon className="text-[#1d9bf0]" />
                      <TagFacesIcon className="text-[#1d9bf0]" />
                    </div>
                    <div>
                      <Button
                        sx={{
                          width: "100%",
                          borderRadius: "20px",
                          paddingY: "8px",
                          paddingX: "20px",
                          bgColor: "#1e88e5",
                        }}
                        variant="contained"
                        type="submit"
                      >
                        Post
                      </Button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </section>
        </Box>
      </Modal>
    </>
  );
}
